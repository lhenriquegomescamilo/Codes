/*
@author: Maikon Canuto
@param: Lista(struct)
@version: 1.1
@description: Funcoes para Lista Encadeada Simples
@language: C/C++
*/

#include <stdio.h>
#include <stdlib.h>

/*
@description: Estrutura para utilizacao da lista
@type: Lista
*/
typedef struct lista{
    int info;
    struct lista *prox;
}Lista;

/*
@description: Reserva um espaco de memoria
@return: void*
@param: void*
*/
void *new(int tmp){
    return (void*)malloc(sizeof(void) * tmp);
}

/*Or:
void *new(){
    return (void*)malloc(sizeof(void)*1);
}
*/

/*
@description: Reserva um espaco de memoria
@return: Lista
@param: void
*/
Lista *aloca(){
    Lista *mem = (Lista*)new();

    if(mem != NULL){
        mem->info = 0;
        mem->prox = NULL;
        return mem;
    }else{
        return NULL;
    }
}

/*
@description: Adiciona um elemento no inicio da lista
@return: void
@param: Lista, int
*/
void adicionaInicio(Lista *lista, int valor){
    Lista *mem = aloca();

    if(mem != NULL){
        Lista *tmp = lista->prox;

        mem->info = valor;
        mem->prox = tmp;
        lista->prox = mem;
    }
}

/*
@description: Adiciona no final da lista
@return: void
@param: Lista, void
*/
void adicionaFinal(Lista *lista, int valor){
    Lista *mem = aloca();

    if(mem != NULL){
        mem->prox = NULL;
        mem->info = valor;
        Lista *tmp = lista;

        while(tmp->prox != NULL)
            tmp = tmp->prox;

        tmp->prox = mem;
    }
}

/*
@description: Buscar de um elemento na lista
@return: Lista
@param: Lista, valor
*/
Lista *buscar(Lista *lista, int valor){
    if(lista != NULL){
        Lista *tmp = lista;

        while(tmp != NULL && tmp->info != valor)
            tmp = tmp->prox;

        return tmp;
    }else{
        return NULL;
    }
}

//Versão da funcao buscar sem variavel auxiliar
Lista *buscaSemAuxiliar(Lista *lista, int valor){
    if(lista != NULL){
        while(lista != NULL && lista->info != valor)
            lista = lista->prox;

        return lista;
    }else{
        return NULL;
    }
}

/*
@description: Buscar elemento de forma recursiva
@return: Lista
@param: Lista, valor
*/
Lista *buscaR(Lista *lista, int valor){

    if(lista->prox == NULL)
        return NULL;

    if(lista->prox->info == valor)
        return lista->prox;

    return buscaR(lista->prox, valor);
}

/*
@description: Mostra todos os elementos da lista
@return: void
@param: Lista
*/
void mostrarLista(Lista *lista){
    if(lista != NULL){
        Lista *tmp = lista->prox;

        while(tmp != NULL){
            printf("%5d", tmp->info);
            tmp = tmp->prox;
        }
    }
}

//Funcao de mostrar lista sem usar variavel auxiliar
void mostrarListaSemAuxiliar(Lista *lista){
    if(lista != NULL){
        while(lista != NULL){
            printf("%5d", lista->info);
            lista = lista->prox;
        }
    }
}

/*
@description: Busca e remove elemento
@return: void
@param: Lista, valor
*/

void buscaRemove(Lista *lista, int valor){
    if(lista != NULL){
        Lista *tmp = lista, *mem = lista->prox;

        while(mem != NULL && mem->info != valor){
            tmp = mem;
            mem = mem->prox;
        }

        if(mem != NULL){
            tmp->prox = mem->prox;
            free(mem);
        }
    }
}

/*
@description: Remove o primeiro elemento da lista
@return: void
@param: Lista
*/
void removeInicio(Lista *lista){
    if(lista->prox != NULL){
        Lista *tmp = lista->prox;
        lista->prox = tmp->prox;;

        free(tmp);
    }
}

/*
@description: Remove o ultimo elemento da lista
@return: void
@param: Lista
*/
void removeFinal(Lista *lista){
    if(lista->prox != NULL){
        Lista *ultimo = lista, *penultimo;

        while(ultimo->prox != NULL){
            penultimo = ultimo;
            ultimo = ultimo->prox;
        }

        penultimo->prox = NULL;
    }
}

/*
@description: Apaga toda a lista
@return: void
@param: Lista
*/
void apagaLista(Lista *lista){
    free(lista);
}

/*
@description: Concatenar lista
@return: void
@param: Lista
*/

Lista *concatenarLista(Lista *p_lista, Lista *s_lista){
    if(p_lista != NULL && s_lista != NULL){
        Lista *tmp = p_lista->prox;

        while(tmp->prox != NULL)
            tmp = tmp->prox;

        tmp->prox = s_lista->prox;

        return p_lista;
    }else{
        return NULL;
    }
}





/*
@description: Utilizacao da main para testes
*/
int main(){

return 0;
}
