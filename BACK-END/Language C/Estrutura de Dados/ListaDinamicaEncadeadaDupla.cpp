///Em desenvolvimento  !!!

#include <stdio.h>
#include <stdlib.h>


typedef struct listaD{
    int info;
    struct listaD *prox;
    struct listaD *ant;
}ListaDupla;

//Aloca
ListaDupla *aloca(){
    ListaDupla *mem = (ListaDupla*)malloc(sizeof(ListaDupla)*1);

    if(mem != NULL){
        mem->info = 0;
        mem->prox = NULL;
        mem->ant  = NULL;

        return mem;
    }else{
        return NULL;
    }
}

//Adiciona no inicio;
ListaDupla *adicionaInicio(ListaDupla *lista, int valor){

    if(lista != NULL){
        ListaDupla *mem = aloca();

        if(mem != NULL){
            mem->info = valor;
            mem->prox = lista->prox;
            mem->ant = lista;
            lista->prox = mem;

            return lista;
        }
    }else{
        return NULL;
    }

}

ListaDupla *adicionaFinal(ListaDupla *lista, int valor){
    if(lista != NULL){
        ListaDupla *tmp = lista, *mem = aloca();

        if(mem != NULL){

            while(tmp->prox != NULL)
                tmp = tmp->prox;


            tmp->prox = mem;
            mem->ant = tmp;
            mem->info = valor;

            return lista;
        }
    }else{
        return NULL;
    }
}


//Mostra lista
void mostrarLista(ListaDupla *lista){
    if(lista != NULL){
        while(lista != NULL){
            printf("%5d", lista->info);
            lista = lista->prox;
        }
    }
}


int main(){
    ListaDupla *p = aloca();

    p = adicionaInicio(p, 200);
    p = adicionaInicio(p, 20);
    p = adicionaInicio(p, 30);
    p = adicionaInicio(p, 40);
    p = adicionaFinal(p, 60);
    p = adicionaFinal(p, 30);
    p = adicionaFinal(p, 100);
    p = adicionaFinal(p, 1);
    mostrarLista(p);

return 0;
}
