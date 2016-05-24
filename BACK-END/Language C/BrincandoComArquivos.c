//Fazendo testes com gravação de arquivo em C 
//Em desenvolvimento !! 

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BUFF 1024

void registra_informacao(const char *string, const char *tipo, const char *info){
    char aux[BUFF] = "";
    sprintf(aux, "%s-%s.txt", string, tipo);

    FILE *arq = fopen(aux, "w+");

    if(arq != NULL){
        fprintf(arq, "%s", info);
        fclose(arq);
    }
}

char *busca_informacao(const char *string, const char *tipo){
    char aux[BUFF] = "", tmp[BUFF] = "", letra;
    sprintf(aux, "%s-%s.txt", string, tipo);

    FILE *arq = fopen(aux, "r+");

    if(arq != NULL){
        while(!feof(arq)){
            letra = fgetc(arq);
            sprintf(tmp, "%c", letra);
        }
        fclose(arq);
    }

    return tmp;
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

int main(){
    char *nome = busca_informacao("04900092126", "cpf");

    registra_informacao("04900092126", "cpf", "Maikon"); //funciona
    printf("\nBuscar Informacao: %s", nome);
    printf("\nStrings: %d\n", comparaStrings("Maikon", "Maikon"));

return 0;
}
