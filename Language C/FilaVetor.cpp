/*
@author: Maikon Canuto
@param: Fila(ponteiro)
@version: 1.0
@description: Funcoes para utilizacao de Fila em C, FILA COM VETOR
@Language: C/C++
*/

#include <stdio.h>
#include <stdlib.h>

//Define o tamanho do vetor
#define TAMANHO 50

/*
@description: Estrutura para utilizar fila
@type: Fila
*/
typedef struct fila{
    int quantidade, inicio, vetor[TAMANHO];
}Fila;

/*
@description: Aloca espaco para Fila
@param: void
@return: Fila(ponteiro)
*/
Fila* aloca(){
    Fila *mem = (Fila*)malloc(sizeof(Fila)*1);

    if(mem != NULL){
        mem->quantidade = 0;
        mem->inicio = 0;

        return mem;
    }else{
        return NULL;
    }
}

/*
@description: Enfileirar na fila
@param: Fila(ponteiro), int
@return: void
*/
void enqueue(Fila *fila, int valor){
    if(fila->quantidade != TAMANHO){
        int fim = (fila->inicio + fila->quantidade)%TAMANHO;
        fila->vetor[fim] = valor;
        fila->quantidade++;
    }
}

/*
@description: Desenfileirar da fila
@param: Fila(ponteiro)
@return: int
*/

int dequeue(Fila *fila){
    if(fila->quantidade != 0){
        int valor = fila->vetor[fila->inicio];
        fila->inicio = (fila->inicio + 1)%TAMANHO;
        fila->quantidade--;

        return valor;
    }
}

/*
@description: Mostrar fila
@param: Fila(ponteiro)
@return: void
*/
void mostrarFila(Fila *fila){
    if(fila->quantidade != 0){
        for(int i = 0; i < fila->quantidade; i++){
            printf("%5d", fila->vetor[i]);
        }
    }
}







/*
@description: Main para testes
*/
int main(){
    Fila *fila = aloca();

    enqueue(fila, 20);
    enqueue(fila, 10);

    dequeue(fila);
    mostrarFila(fila);
return 0;
}
