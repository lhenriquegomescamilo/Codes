/*
@author: Maikon Canuto
@param: char, int
@version: 1
@description: Código para mudar da string no terminal CMD.
*/

#include <windows.h>
#include <stdio.h>

/*
@description: Mudando cor da string
@param: char *string -> Frase desejada, int color -> numero da cor
*/
void setColorFont(const char *string, const unsigned int color)
{
    //Define padroes para trocar a cor
    HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);

    //Define a cor desejada
    SetConsoleTextAttribute(console, color);

    //Imprime a string na tela
    printf("%s", string);

    //Define a cor original do terminal
    const unsigned int colorPadrao = 7;
    SetConsoleTextAttribute(console, colorPadrao);
}




/*
description: Main para testes
*/
int main(){
    setColorFont("MK", 12);
return 0;
}
