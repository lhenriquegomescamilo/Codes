#include <stdio.h>
#include <string.h>

/*
* Parametros: char *str - Uma string
* Retorna: char *str - Uma String sem espacos
*/
char *retiraEspaco(const char string[]){
    //Inicializa variaveis para controle
    short unsigned int i = 0, j = 0, tam = 0;

    //string auxiliar com tamanho de 1024
    char str[1024];

    //Caso a string passada seja NULA ou com tamanho 0
    if(string == NULL || strlen(string) == 0)
        return NULL;
    else
        tam = strlen(string); //Caso seja direfente de NULO entao determina valor

    //Verifica a string com espacos
    for(i = 0; i < tam; i++){
        if(string[i] != ' '){
            str[j] = string[i];
            j++;
        }
    }

    //Adiciona \0 no final da string
    str[j] = '\0';

    //Retorna string sem espacos
    return str;
}

int main(){

    //Teste da funcao "retiraEspaco" da string
    printf("%s\n", retiraEspaco("Meu Git Maikon Canuto"));

return 0;
}

