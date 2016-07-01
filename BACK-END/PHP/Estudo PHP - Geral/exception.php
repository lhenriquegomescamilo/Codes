<!DOCTYPE>
<html lang="pt-br">

	<head>
		<title> Estudo sobre exception </title>
		<meta charset="UTF-8"/>
	</head>

	<body>
		<?php
			function inverse($x){
   				if(!$x):
					throw new Exception("Divisao por zero");
   				endif;

   			return 1/$x;
			}

			try{
				print("Numero: " . inverse(1) . "<br>");
			}catch(Exception $error){
				print("Excecao capturada: " . $error->getMessage() . "<br>");
			}
		?>
	</body>

</html>
