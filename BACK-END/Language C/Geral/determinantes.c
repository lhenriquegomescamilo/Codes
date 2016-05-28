//Em desenvolvimento

#include <stdio.h>
#include <stdlib.h>

int main(){

 int matriz[3][5], linha = 0, coluna = 0, diagonal[3], voltadiagonal[3], i, controle = 0;

 for(i = 0; i < 9; i++){
    resultado[i] = 1;
 }

 for(linha = 0; linha < 3; linha++){
    for(coluna = 0; coluna < 5; coluna ++){
        matriz[linha][coluna] = 1;
    }
 }


 for(linha = 0; linha < 3; linha++){
    for(coluna = 0; coluna < 5; coluna++){

        if(coluna == (linha + 0)){
            printf("|linha %d Coluna %d |\t\n", linha, coluna);
            diagonal[0] *= matriz[linha][coluna];
        }

        if(coluna == (linha + 1)){
            printf("|linha %d Coluna %d |\t\n", linha, coluna);
            diagonal[1] *= matriz[linha][coluna];
        }

        if(coluna == (linha + 2)){
            printf("|linha %d Coluna %d |\t\n", linha, coluna);
            diagonal[2] *= matriz[linha][coluna];
        }

        if(coluna <= 2){
            voltadiagonal[0] *= matriz[linha][4 - coluna];
        }

    }
    printf("\n");
 }

 for(i = 0; i < 3; i++){
    controle += resultado[i];
 }

 printf("\nSomatorio: %d", controle);
 return 0;
}
