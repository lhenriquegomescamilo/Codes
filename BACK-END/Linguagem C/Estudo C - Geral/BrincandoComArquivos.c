//Fazendo testes com gravação de arquivo em C 
//Em desenvolvimento

//Inclui bibliotecas no projeto
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Determina tamanho do BUFF para essas variaveis 
#define BUFF 1024 //Tamanho para Leitura de Arquivo
#define NOME 50 //Tamanho para o Vetor NOME
#define CPF 11 //Tamanho para o Vetor CPF
#define SENHA 5 //Tamanho para o Vetor SENHA
#define VALOR 10 //Tamanho para o Vetor VALOR

//Cria uma struct do tipo Cliente, com informacoes de NOME, CPF, SENHA e VALOR. 
typedef struct cliente{
    
    //Atributos da struct cliente
    char nome[NOME], cpf[CPF], senha[SENHA], valor[VALOR];
    
}Cliente;

//Aloca um espaco de memoria do tipo Cliente e retorna o endereco alocado
Cliente *cria_pessoa(){
    return (Cliente*)malloc(sizeof(Cliente)*1);
}

//Grava a informacao passada por parametro.
void registra_informacao(const char *caminho, const char *categoria, const char *info){
    
    //Declara variaveis de controle 
    char aux[BUFF] = "";
    
    //Concatena caminho com o tipo ex: "012321-cpf.txt", e envia isso para variavel aux
    sprintf(aux, "%s-%s.txt", caminho, categoria);
    
    //Abre um arquivo
    FILE *arq = fopen(aux, "w+");
    
    //Grava informacoes no arquivo
    if(arq != NULL){
        fprintf(arq, "%s", info);
        fclose(arq);
    }

    fclose(arq);
}

//Busca a informacao no arquivo gravado e retorna o conteudo como string
char *busca_informacao(const char caminho[], const char categoria[]){
    
    //Declara varaiveis de controle 
    char aux[BUFF] = "",  letra[BUFF] = "";
    
    //Concatena caminho com o tipo ex: "012321-cpf.txt", e envia isso para variavel aux
    sprintf(aux, "%s-%s.txt", caminho, categoria);
    
    //Abre um arquivo
    FILE *arq = fopen(aux, "r+");

    //Faz a leitura do conteudo dentro do arquivo e adiciona isso na varaivel "letra"
    if(arq != NULL){
        while(fscanf(arq, "%s", letra) != EOF) //Pega informacao com fscanf até o final do arquivo

        fclose(arq);
    }
    fclose(arq);
    
    //Retorna informacao dentro do arquivo como vetor de char
    return letra;
}

//Compara duas strings e verifica se os caracteres sao iguais
int comparaStrings(const char *string, const char *str){
    
    //Declara variaveis de controle 
    short unsigned int i = 0, aux = 0;
    
    //Verifica se o tamanho de string e igual ao de str 
    if(strlen(string) == strlen(str)){
        for(i = 0; i < strlen(string); i++) //Percorre as duas strings comparando cada posicao
            if(string[i] == str[i])
                aux++; //Adiciona +1 a varaivel aux caso as duas posicoes sejam iguais EX: "A == A"
    }
    
    //Verifica se a AUX tem o mesmo tamanho da string, se sim todos os elementos sao iguais
    if(aux == strlen(string))
        return 1; //Verdadeiro 
    else 
        return 0; //Falso
}

//Mostra informacoes do vetor passado como parametro
void mostraVetor(const char *string){
    short unsigned int i;
    
    //Caso seja diferente de NULO (vazio) entao mostra as posicoes 
    if(string != NULL){
        for(i = 0; i < strlen(string); i++){
            printf("%c", string[i]);
        }
    }
}

//Funcao para login no sistema
int login(){
    
    //Declara variaveis de controle
    Cliente *pessoa = cria_pessoa();
    char *cpf, *senha;

    system("cls");
    
    //Recebe CPF do usuario
    fflush(stdin);
    printf("\nDigite seu CPF: ");
    gets(pessoa->cpf);
    
    //Busca esse CPF no arquivo
    cpf = busca_informacao(pessoa->cpf, "cpf");
    
    //Recebe Senha do usuario
    fflush(stdin);
    printf("\nDigite sua senha: ");
    gets(pessoa->senha);

    //Busca esse SENHA no arquivo
    senha = busca_informacao(pessoa->senha, "senha");
    
    //Compara se o CPF e a SENHA sao iguais a digitas 
    if((comparaStrings(pessoa->senha, senha) == 1 ) && (comparaStrings(pessoa->cpf, cpf) == 1)) //Preciso alterar essa comparacao 
        return 1;
    else
        return 0;
}

//Cadastra informacoes digitadas pelo usuario no arquivo
void cadastra_cliente(){
    Cliente *pessoa = cria_pessoa();

    fflush(stdin);
    printf("\nDigite seu CPF: ");
    gets(pessoa->cpf);
    registra_informacao(pessoa->cpf, "cpf", pessoa->cpf);

    fflush(stdin);
    printf("\nDigite seu nome: ");
    gets(pessoa->nome);
    registra_informacao(pessoa->cpf, "nome", pessoa->nome);

    fflush(stdin);
    printf("\nDigite sua senha: ");
    gets(pessoa->senha);
    registra_informacao(pessoa->cpf, "senha", pessoa->senha);

    fflush(stdin);
    printf("\nDigite um valor inicial: ");
    gets(pessoa->valor);
    registra_informacao(pessoa->cpf, "valor", pessoa->valor);
}

//Faz testes
int main(){
    cadastra_cliente();

    if(login()){
        printf("\nLogado com sucesso");
    }else{
        printf("\nSENHA E CPF incorretos");
    }
return 0;
}

