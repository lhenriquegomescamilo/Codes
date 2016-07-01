//Funcao para mostrar o resto de uma divisao

#include <stdio.h>

/*
(quociente * divisor) + resto = dividendo
(quociente * divisor) - dividendo = - resto (-1)
-(quociente * divisor) + dividendo = resto Logo:
resto = dividendo - (quociente * divisor)
resto = dividendo - ((dividendo/divisor) * divisor)

Dividendo: 8
Divisor: 5
Quociente: 1
Resto: 3

-(1 * 5) + 8 = resto
-5 + 8 = resto
resto = 3
*/

//Retorna o resto da divisao
int restoDivisao(int dividendo, int divisor){
    return (dividendo - ((dividendo/divisor) * divisor));
}

//Retorna o quociente da divisao
int quocienteDivisao(int dividendo, int divisor){
    return dividendo/divisor;
}

int main(){

    printf("Resto: %d", restoDivisao(8, 5));

 return 0;
}
