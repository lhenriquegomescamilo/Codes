//Em desenvolvimento

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
   
    for(i = 0; resultado != 0; i++){
        binario[i] = resultado % 2;
        resultado -= binario[i]/2;
    }
   
    printf("\n\t\tENDERECO MP CONSIDERADO: %x =  ", hexa);
 
    for(i = (endereco - 1) ; i >= 0; i--)
        printf("%d", binario[i]);
 
    printf("\n\t\t");
}
 
Chama funcao principal
int main(){
       unsigned  int mp = 0,
             mc = 0,
             alocaMemoriaPrincipal = 0,
                     alocaMemoriaCache = 0,
                     bloco = 0,
                     palavra = 0,
                     endereco = 0,
                     linhas = 0,
                     op = 0,
                     conjunto = 0,
                     rotulo = 0,
                 hexa = 0;
   
   
        do{
        system("clear");
 
        printf("\n 1 - Mapeamento Direto");
        printf("\n 2 - Mapeamento Associativo por Conunto");
        printf("\n 3 - Mapeamento Associativo");
        printf("\n 4 - Sair");
        printf("\n\nDigite sua opcao: ");
        scanf("%u", &op);
 
        switch(op){
            case 1:
                system("clear");
 
                printf("\nTAMANHO DA MEMORIA PRINCIPAL: ");
                scanf("%u", &mp);
               
                if(mp >= 0){
                    alocaMemoriaPrincipal = alocaMemoria(mp);
                    endereco = acharIndice(alocaMemoriaPrincipal, MIBYTES);
                    printf("\n-----> TAMANHO DA MP ALOCADO: %d MiBytes", alocaMemoriaPrincipal);
                    printf("\n-----> ENDERECO: %d Bits\n", endereco);
                }else{
                    printf("\n-----> ERRO AO ALOCAR MEMORIA PRINCIPAL \n");
                }
 
                printf("\nTAMANHO DA MEMORIA CACHE: ");
                scanf("%u", &mc);
               
                if(mc >= 0){
                    alocaMemoriaCache = alocaMemoria(mc);
                    printf("\n-----> TAMANHO DA MC ALOCADO: %d KiBytes", alocaMemoriaCache);
                }else{
                    printf("\n-----> ERRO AO ALOCAR MEMORIA CACHE\n\n");
                }
 
                printf("\n\nTAMANHO DO BLOCO: ");
                scanf("%u", &bloco);
 
                if(bloco > 0){
                    palavra = acharIndice(bloco, 1);
                    printf("\n-----> TAMANHO DO BLOCO: %d Bytes", bloco);
                    printf("\n-----> TAMANHO DA PALAVRA: %d Bits\n", palavra);
                }else{
                    printf("\n-----> ERRO AO DETERMINAR O BLOCO\n");
                }
 
                linhas = alocaMemoriaCache/bloco;
                conjunto = acharIndice(linhas, KIBYTES);
                rotulo = endereco - (conjunto + palavra);
 
 
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
               
               
                printf("\n\t\tDIGITE ENDERECO HEXA[%u/HEXA]: ", ((endereco/4) + 1));
                scanf("%x", &hexa);
               
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
