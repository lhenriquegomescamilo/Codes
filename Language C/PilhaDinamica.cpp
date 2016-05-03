/*
@author: Maikon Canuto
@param: Pilha
@version: 1.0
@description: Funcoes para Pilha dinamica
@language: C/C++
*/
#include <stdio.h>
#include <stdlib.h>

/*
description: Estruturas para Pilha e Lista
type: Pilha, Lista
*/

typedef struct lista{
    int info;
    struct lista *prox;
}Lista;

typedef struct pilha{
    Lista *top;
}Pilha;


/*
@description: Reserva espaco de memoria para Lista
@param: void
@return: Lista(Ponteiro)
*/
Lista *alocaLista(){
    Lista *mem = (Lista*)malloc(sizeof(Lista)*1);

    if(mem != NULL){
        mem->info = 0;
        mem->prox = NULL;

        return mem;
    }else{
        return NULL;
    }
}

/*
@description: Reserva espaco de memoria para Pilha
@param: void
@return: Pilha(Ponteiro)
*/
Pilha *alocaPilha(){
    Pilha *mem = (Pilha*)malloc(sizeof(Pilha)*1);

    if(mem != NULL){
        mem->top = NULL;
        return mem;
    }else{
        return NULL;
    }
}

/*
@description: Adiciona valor a Pilha de forma dinamica
@param: Pilha(Ponteiro), int valor
@return: void
*/
void push(Pilha *pilha, int valor){
    Lista *lista = alocaLista();

    if(lista != NULL){
        lista->info = valor;
        lista->prox = pilha->top;
        pilha->top = lista;
    }
}

/*
@description: Retira valor da pilha de forma dinamica
@param: Pilha(Ponteiro)
@return: inteiro, retorna -1 caso a pilha esteja vazia
*/
int pop(Pilha *pilha){
    if(pilha->top != NULL){
        Lista *lista = pilha->top;
        int tmp = lista->info;
        pilha->top = lista->prox;

        return tmp;
    }else{
        return -1;
    }
}








/*
@description: Main para realizar teste
*/
int main(){
    Pilha *mem = alocaPilha();

    push(mem, 10);
    int a = pop(mem);

return 0;
}
