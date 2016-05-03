/*
@author: Maikon Canuto
@param: Pilha (ponteiro), int
@version: 1.0
@description: Funcoes para utilizacao de pilha em C, PILHA COM VETOR
@Language: C/C++
*/

#include <stdio.h>
#include <stdlib.h>

//Tamanho da Pilha em vetor
#define TAMANHO 50

/*
@description: Estrutura para utilizacao da pilha
@type: Pilha
*/
typedef struct pilha{
    int info, vetor[TAMANHO];
}Pilha;

/*
@description: Reserva um espaco de memoria
@param: void
@return: Pilha(ponteiro)
*/
Pilha *alocaPilha(){
    Pilha *mem = (Pilha*)malloc(sizeof(Pilha)*1);

    if(mem != NULL){
        mem->info = 0;
        return mem;
    }else{
        return NULL;
    }
}

/*
@description: Adiciona na pilha
@param: Pilha(ponteiro), int
@return: void
*/
void push(Pilha *pilha, int valor){
    if(pilha->info != TAMANHO){
        pilha->vetor[pilha->info] = valor;
        pilha->info++;
    }
}

/*
@description: Retira da pilha
@param: Pilha(Ponteiro)
@return: int, retorna -1 caso a pilha esteja vazia
*/
int pop(Pilha *pilha){
    if(pilha->info != 0){
        int tmp = pilha->vetor[pilha->info - 1];
        pilha->info--;
        return tmp;
    }else{
        return -1;
    }
}

/*
@description: mostra os valores entro da Pilha
@param: Pilha(ponteiro)
@return: void
*/
void mostrarPilha(Pilha *pilha){
    if(pilha != NULL && pilha->info != 0){
        for(int i = 0; i < pilha->info; i++){
            printf("%5d", pilha->vetor[i]);
        }
    }
}





/*
@description: Main utilizada para testes
*/
int main(){
    Pilha *mem = alocaPilha();

    if(mem != NULL){
        push(mem, 10);
        push(mem, 20);
        push(mem, 30);
    }

    mostrarPilha(mem);

return 0;
}
