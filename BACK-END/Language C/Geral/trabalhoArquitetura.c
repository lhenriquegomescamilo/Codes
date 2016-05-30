//Em desenvolvimento

//Importando bibliotecas 
#include <stdio.h> 
#include <stdlib.h>
#include <string.h>
 
#define MIBYTES 1048576 //Determina tamanho do MIBYTES
#define KIBYTES 1024 //Determina tamanho do KIBYTES
 
//Funcao para elevar o numero 
//utilizado short unsigned int, para o consume de memoria ser reduzido, e utilizado const para melhor seguranca do codigo
int elev(const unsigned int expoente, const short unsigned int base){
        //Utilizado register para identificar quais variaveis ficaram no registrador.
        //Utilizado unsigned para identificar varaiveis que nao vao ter "lado" negativo, aumentando o aproveitamento da memoria
        register unsigned int i = 0, resultado = 1;
        
        //Expoente negativo ou base negativa, retorna 0 como valor
        if(expoente < 0 && base < 0)
                return 0;
                
        //Expoente igual a 0 entao retorna 1, 2^0 = 1
        if(expoente == 0)
                return 1;
                
        //Eleva o numero
        while(i < expoente){
                resultado *= base;
                i++;
        }
        
        //Retorna o resultado do numero elevado
        return resultado;
}

//Funcao que simula alocao de memoria
//utilizado unsigned int, para o consume de memoria ser reduzido, e utilizado const para melhor seguranca do codigo
int alocaMemoria(const unsigned int mem){
        //Utilizado register para identificar quais variaveis ficaram no registrador.
        //Utilizado unsigned para identificar varaiveis que nao vao ter "lado" negativo, aumentando o aproveitamento da memoria
        register unsigned int i = 0, resultado = 0, aux = 0;
        
        //memoria for menor negativa, entao retorna 0 
        if(mem < 0)
                return 0;
        //memoria for igual a 0 entao retorna 0 
        if(mem == 0)
                return 0;
        
        //Determina tamanho da memoria alocada, de acordo com as possibilidades em BITS. Valor aproximado ao digitado
        for(i = 0; i < mem; i++){
                resultado = elev(i, 2); 
 
                if(resultado <= mem)
                        aux = resultado;
                else
                        break; //Se entrar aqui é por que já achou o valor
        }
  
        return aux; //Retorna o valor da memoria alocada
}
 
//Acha o indice da memoria 
//utilizado unsigned int, para o consume de memoria ser reduzido, e utilizado const para melhor seguranca do codigo
int acharIndice(const unsigned int mem, const unsigned int bytes){
        register unsigned int i = 0, aux = 0;
 
    for(i = 0; i < (mem * bytes); i++){
   
        if(elev(i,2) <= (mem * bytes))
            aux = i;
        else
            break;
    }
 
    return aux;
}

//Determina a linhas 
//utilizado  unsigned int, para o consume de memoria ser reduzido, e utilizado const para melhor seguranca do codigo
int acharLinhas(const unsigned int mem, const unsigned int bloco){
    return mem/bloco;
}

//Converte Hexadecimal para binario 

void hexaParaBinario(const unsigned int hexa, const unsigned int endereco){
    unsigned int i, resultado = hexa, binario[endereco];
    
    //Determina valor em bainario e salva no vetor binario
    //Utilizando divisao sucessiva 
    for(i = 0; resultado != 0; i++){
        binario[i] = resultado % 2;
        resultado -= binario[i]/2;
    }
    
    //Informa o valor da memoria em hexa 
    printf("\n\t\tENDERECO MP CONSIDERADO: %x =  ", hexa);
    
    //Apresenta o endereco em binario 
    for(i = (endereco - 1) ; i >= 0; i--)
        printf("%d", binario[i]);
 
    printf("\n\t\t");
}
 
//Chama funcao principal
int main(){
       unsigned  int mp = 0, //Memoria principal 
                     mc = 0, //Memoria Cache 
                     alocaMemoriaPrincipal = 0, //Recebe valor alocado da memoria principal 
                     alocaMemoriaCache = 0, //Recebe valor alocado da memoria cache
                     bloco = 0, //Recebe valor do bloco 
                     palavra = 0, //Recebe valor da palavra 
                     endereco = 0, //Recebe o valor do endereco 
                     linhas = 0, //Recebe valor da linha 
                     op = 0, //Opcao 
                     conjunto = 0, //Valor do conjunto 
                     rotulo = 0, //Valor do rotulo 
                     hexa = 0; //Valor em hexadecimal digitado pelo usuario. 
   
    //Menu para interecao com usuario 
     do{
        system("clear");
 
        printf("\n 1 - Mapeamento Direto");
        printf("\n 2 - Mapeamento Associativo por Conunto");
        printf("\n 3 - Mapeamento Associativo");
        printf("\n 4 - Sair");
        printf("\n\nDigite sua opcao: ");
        scanf("%u", &op); //%u por que recebe um "unsigned integer" 
 
        switch(op){
            case 1:
                system("clear");
                
                //Recebe tamanho da memoria principal 
                printf("\nTAMANHO DA MEMORIA PRINCIPAL: ");
                scanf("%u", &mp); //%u por que recebe um "unsigned integer" 
                
                //verifica se é maior que 0, não pode ser negativa 
                if(mp >= 0){
                    alocaMemoriaPrincipal = alocaMemoria(mp); //Retorna o valor mais proximo ao digitado pelo usuario 
                    endereco = acharIndice(alocaMemoriaPrincipal, MIBYTES); //Determina endereco da memoria principal 
                    printf("\n-----> TAMANHO DA MP ALOCADO: %d MiBytes", alocaMemoriaPrincipal); //Mostra tamanho alocado 
                    printf("\n-----> ENDERECO: %d Bits\n", endereco); //Mostra endereco em bits 
                }else{
                    printf("\n-----> ERRO AO ALOCAR MEMORIA PRINCIPAL \n"); //Caso seja memoria negativa informa erro 
                }
                
                //Verifica tamanho da memoria cache 
                printf("\nTAMANHO DA MEMORIA CACHE: ");
                scanf("%u", &mc); //%u por que recebe um "unsigned integer" 
                
                //Verifica se é negativo 
                if(mc >= 0){
                    alocaMemoriaCache = alocaMemoria(mc); //Aloca memoria cache 
                    printf("\n-----> TAMANHO DA MC ALOCADO: %d KiBytes", alocaMemoriaCache); //Tamaanho da memoria cache 
                }else{
                    printf("\n-----> ERRO AO ALOCAR MEMORIA CACHE\n\n"); //Caso tenha alguma erro 
                }
                
                //Tamanho do bloco digitado pelo usuario 
                printf("\n\nTAMANHO DO BLOCO: ");
                scanf("%u", &bloco); //%u por que recebe um "unsigned integer" 
                
                //Bloco acima de 0 entao: 
                if(bloco > 0){
                    palavra = acharIndice(bloco, 1); //Determina tamanho da palavra 
                    printf("\n-----> TAMANHO DO BLOCO: %d Bytes", bloco); //Mostra tamanho do bloco 
                    printf("\n-----> TAMANHO DA PALAVRA: %d Bits\n", palavra); //Mostra palavra em bits 
                }else{
                    printf("\n-----> ERRO AO DETERMINAR O BLOCO\n"); //Mostra erro 
                }
 
                linhas = alocaMemoriaCache/bloco; //Faz calculos para achar as linhas 
                conjunto = acharIndice(linhas, KIBYTES); //Determina conjuntos 
                rotulo = endereco - (conjunto + palavra); //Determina rotulo 
 
                //Mostra informacoes 
                printf("\nDeterminando linhas...\n"); 
                printf("\n-----> %d KiLinhas", linhas);
                printf("\n-----> %d Bits Conjunto\n\n", conjunto);
               
 
                system("clear");
 
                printf("\n\t\tMEMORIA PRINCIPAL: %d MiBytes", alocaMemoriaPrincipal);
                printf("\n\t\tENDERECO MEMORIA PRINCIPAL: %d Bits -- %u HEXA", endereco, ((endereco/4) + 1));
                printf("\n\n\t\tMEMORIA CACHE: %d KiBytes", alocaMemoriaCache);
                printf("\n\t\tBLOCOS DA CACHE: %d Bytes", bloco);
                printf("\n\t\tENDERECO DA PALAVRA: %d Bits", palavra);
                printf("\n\t\tENDERECO DO ROTULO: %d Bits", rotulo);
                printf("\n\t\tENDERECO DE LINHAS: %d KiConjuntos - 1 Linha", linhas);
                printf("\n\t\tENDERECO DO CONJUNTO: %d Bits\n", conjunto);
                printf("\n\t\tMAPEAMENTO DO CACHE: DIRETO\n");
               
                
                //Pega hexa digitado pelo usuario e apresenta em binario 
                printf("\n\t\tDIGITE ENDERECO HEXA[%u/HEXA]: ", ((endereco/4) + 1));
                scanf("%x", &hexa); //Pega em hexadecimal %x 
               
                hexaParaBinario(hexa, endereco);
               
               
            break;
 
            case 2:
            break;
 
            case 3:
            break;
           
            case 4:
                printf("\nPROGRAMA ENCERRADO\n\n");
            break;
 
            default:
                printf("\nESCOLHA A OPCAO CERTA\n\n");
            break;
 
        }
    }while(op == 4);
return 0;
}
