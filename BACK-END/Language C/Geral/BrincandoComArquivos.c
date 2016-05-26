//Fazendo testes com gravação de arquivo em C 
//Em desenvolvimento

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFF 1024
#define NOME 50
#define CPF 11
#define SENHA 5
#define VALOR 10

typedef struct cliente{
    char nome[NOME],
         cpf[CPF],
         senha[SENHA],
         valor[VALOR];
}Cliente;

Cliente *cria_pessoa(){
    return (Cliente*)malloc(sizeof(Cliente)*1);
}

void registra_informacao(const char *caminho, const char *categoria, const char *info){
    char aux[BUFF] = "";
    sprintf(aux, "%s-%s.txt", caminho, categoria);

    FILE *arq = fopen(aux, "w+");

    if(arq != NULL){
        fprintf(arq, "%s", info);
        fclose(arq);
    }

    fclose(arq);
}

char *busca_informacao(const char caminho[], const char categoria[]){
    char aux[BUFF] = "", tmp[BUFF] = "", letra[BUFF] = "";
    sprintf(aux, "%s-%s.txt", caminho, categoria);

    FILE *arq = fopen(aux, "r+");

    if(arq != NULL){
        while(fscanf(arq, "%s", letra) != EOF)

        fclose(arq);
    }
    fclose(arq);
    return letra;
}

int comparaStrings(const char *string, const char *str){
    int i, aux = 0;

    if(strlen(string) == strlen(str)){
        for(i = 0; i < strlen(string); i++)
            if(string[i] == str[i])
                aux++;
    }

    if(aux == strlen(string))
        return 1;
    else
        return 0;
}

void mostraVetor(const char *string){
    int i;

    if(string != NULL){
        for(i = 0; i < strlen(string); i++){
            printf("%c", string[i]);
        }
    }
}

int login(){
    Cliente *pessoa = cria_pessoa();
    char *cpf, *senha;

    system("cls");

    fflush(stdin);
    printf("\nDigite seu CPF: ");
    gets(pessoa->cpf);

    cpf = busca_informacao(pessoa->cpf, "cpf");

    fflush(stdin);
    printf("\nDigite sua senha: ");
    gets(pessoa->senha);

    senha = busca_informacao(pessoa->senha, "senha");

    if((comparaStrings(pessoa->senha, senha) == 1 ) && (comparaStrings(pessoa->cpf, cpf) == 1))
        return 1;
    else
        return 0;
}

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

int main(){
    //cadastra_cliente();

    if(login()){
        printf("\nLogado com sucesso");
    }else{
        printf("\nSENHA E CPF incorretos");
    }
return 0;
}

