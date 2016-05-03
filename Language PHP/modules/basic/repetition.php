<?php

/**
 * @copyright (c) 2016, Maikon Canuto MK
 */
    
    //Basic PHP: Repetition
    
    //Command FOR

    print("Growing <br> <hr>");
    
    for($i = 0; $i < 10; $i++){
        print("Number: $i <br>");
    }
    
    print("<br> Decreasing <br> <hr>");
    
    for($j = 10; $j >= 0; $j--)
        print("Number: $j <br> ");
    
    print("<hr>");
    
    //Command ForEach
    $array = array(1 => "Maikon", 2 => "Canuto", 3 =>"PHP", 4 => "Repetition");
    
    foreach($array as $key){
        print("Key: $key <br>");
    }
    
    print("<br>");
    
    $array = [1 => "MK", 2 => "Pedrosa", 3 =>"PHP 5.6", 4 => "Repetition ForEach"];
    
    foreach($array as $key => $value)
          print("Key: $key is Value: $value <br>");
    
    print("<hr>");
    
    //Command While
   $i = 0;
   while($i < 10){
       print("Number while: $i <br>");
       $i++;
   }
   
   print("<hr>");
   
   //Command Do-while
   
   $i = 10;
   
   do{
       print("Number do-while: $i <br>");
       $i--;
   }while($i >= 0);
   
    print("<hr>");
    
?>