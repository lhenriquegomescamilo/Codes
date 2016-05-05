<?php

//Exercicio sobre function 

/**
 * @copyright (c) 2016, Maikon Canuto MK
 * 
 * @Descricao Verifica se o número é par ou impar. 
 * @param type $number Integer
 * @return boolean
 */
function paridade($number){
    if($number % 2 == 0):
        return TRUE;
    else:
        return FALSE;
    endif;
}

/**
 * @copyright (c) 2016, Maikon Canuto MK
 * 
 * @Descricao Verifica se o número é primo
 * @param type $number Integer
 * @return boolean
 */
function primo($number){
    $i = 2;
    $tmp = 0;
            
    while($i <= $number){
        if($number % $i == 0):
            $tmp++;
        endif;
    }
    
    if($tmp == 1):
        return TRUE;
    else:
        return FALSE;
    endif;
}

/**
 * @copyright (c) 2016, Maikon Canuto MK
 * 
 * @Descricao Verifica se o número é negativo. 
 * @param type $number Integer
 * @return boolean
 */
function negativo($number){
    if($number < 0):
        return TRUE;
    else:
        return FALSE;
    endif;
}

/**
 * @copyright (c) 2016, Maikon Canuto MK
 * 
 * @Descricao Verifica se o número é Positivo. 
 * @param type $number Integer
 * @return boolean
 */
function positivo($number){
    if($number >= 0):
        return TRUE;
    else:
        return FALSE;
    endif;
}

/**
 *  * @copyright (c) 2016, Maikon Canuto MK
 * 
 * @Descricao Verifica qual número é maior, e retorna. Caso forem iguais retorna TRUE, retorna FALSE por algum tipo de erro
 * @param type $number1 
 * @param type $number2
 * @return $number1, $number2 e $boolean
 */
function numeroMaximo($number1, $number2){
    if($number1 > $number2):
        return $number1;
    elseif($number2 > $number1):
        return $number2;
    elseif($number1 == $number2):
        return TRUE;
    else:
        return FALSE;
    endif;
}

