<?php

/**
 * @copyright (c) 2016, Maikon Canuto  MK
 */

    //Basic PHP: Conditional

    $number1 = 10;
    $number2 = 20;
    $number3 = $number1 + $number2;
    
    //Command if, else and endif
    if($number3 > $number1):
        print("$number3 and greater than $number1 <br> <hr> ");
    elseif($number3 > $number2):
        print("$number3 and greater than $number2 <br> <hr> ");
    else:
        print("$number3 and small <br> <hr> ");
    endif;
    
    //Command switch
    switch ($number3) {
    case 10:
        print("Switch case 10: $number3 <br> <hr>");
        break;
    
    case 20:
        print("Switch case 20: $number3 <br> <hr>");
        break;
    
    case 30:
        print("Switch case 30: $number3 <br> <hr>");
    
   default:
        print("Error <br> <hr>");
        break;
}
?>

