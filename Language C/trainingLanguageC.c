//Em desenvolvimento!!!! Alteracoes seram efetuadas...

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//Criacao do tipo para boolean, true e false em C.
typedef enum boolean{
    true = 1, false = 0
}boolean;

//Tipo pessoa
typedef struct Pessoa{
    const char *name;
    const int  password;
    const float balance;
}Person;

//Aloca espaço de memoria para qualquer estrutura.
static void* new(){
    return (void*)malloc(sizeof(void)*1);
}

//Cria um novo arquivo
static FILE *newFile(const char *directory, const char *mode){
    FILE *file;

    do{
       file = fopen(directory, mode);
       fclose(file);
    }while(file == NULL);

    return file;
}

//Verifica se existe o arquivo no diretorio especificado
static boolean containsFile(const char *directory){
    FILE *file = fopen(directory, "r");

    if(file){
        fclose(file);
        return true;
    }
    else{
        fclose(file);
        return false;
    }
}

//Em desenvolvimento, acontece overthrow do sistema
static boolean deleteFile(char *directory){
    if(containsFile(directory)){
        char tmp[] = "del ";
        system(strcat(tmp, directory));
        return true;
    }
    else{
        return false;
    }
}

static void newInfo(const Person *cli){
    FILE *file = newFile("cliente.txt", "a+");

    sprintf(file, "%s:%d:%.5f;", cli->name, cli->password, cli->balance);
}

int main(){
    char *caminho = "person.txt";
    FILE *arq = newFile(caminho, "a+");
    Person *pessoa = (Person*)new();


    if(arq)
        printf("\nArquivo foi criado");
    else
        printf("\nArquivo nao foi criado");


    if(containsFile(caminho))
        printf("\nExiste");
    else
        printf("\nNao existe");



    if(deleteFile(caminho))
        printf("\nArquivo deletado\n");
    else
        printf("\nArquivo nao existe\n");


system("pause");
return 0;
}
