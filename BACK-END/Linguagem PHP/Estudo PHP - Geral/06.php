<?php

/**
 * @copyright (c) 2016, Maikon Canuto MK
 */

    class Prime{
        
        public function toPrime($number){
            $tmp = 0;
            
            for($i = 2; $i <= $number; $i++){
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
        public function testPrime($ini, $final){
            $tmp = new Prime();
            
            for($i = $ini; $i <= $final; $i++){
                if($tmp->toPrime($i)):
                    print("[$i] is prime <br>");
                else:
                    print("[$i] not is prime <br>");
                endif;
            }
        }
        
    }
    class Pessoa{
        private $name;
        private $idade;
        private $sexo;
        
        public function setName($nome){
            $this->name = $nome;
        }
        
        public function setIdade($idade){
            $this->idade = $idade;
        }
        
        public function setSexo($sexo){
            $this->sexo = $sexo;
        }
        
        public function getName(){
            return this.name;
        }
        
        public function getIdade(){
            return this.idade;
        }
        
        public function getSexo(){
            return this.sexo;
        }
        
        public function makeNiver(){
            this.$idade++;
        }
        
        public function relatorio(){
            
            print("Nome: $this->name <br>");
            print("Sexo:  $this->sexo  <br>");
            print("Idade:  $this->idade <br><hr>");
        }
    }
    class Aluno{
        
        private $nome;
        private $sexo;
        private $idade;
        private $matricula;
        private $turma;
        private $notas = [];
        private $media;
        
        public function setNome($nome){
            $this->nome = $nome;
        }
        public function getNome(){
            return $this->nome;
        }
        public function setSexo($sexo){
            $this->sexo = $sexo;
        }
        public function getSexo(){
            return $this->sexo;
        }
        public function setIdade($idade){
            $this->idade = $idade;
        }
        public function getIdade(){
            return $this->idade;
        }
        public function setMatricula($matricula){
            $this->matricula = $matricula;
        }
        public function getMatricula(){
            return $this->matricula;
        }
        public function setTurma($turma){
            $this->turma = $turma;
        }
        public function getTurma(){
            return $this->turma;
        }
        public function setNotas($nota1, $nota2, $nota3){
            $this->notas = array(3);
            $this->notas[0] = $nota1;
            $this->notas[1] = $nota2;
            $this->notas[2] = $nota3;
        }
        public function getNotas(){
            return $this->notas;
        } //Retorna um array
        public function calculaMedia(){
           $calculaMedia = 0;
           
            for($i = 0; $i < sizeof($this->notas); $i++){
                $calculaMedia += ($this->notas[$i]/sizeof($this->notas));
            }
            
            $this->media = $calculaMedia;
        }
        public function relatorio(){
            print("Nome do Aluno: $this->nome <br>");
            print("Sexo do Aluno:  $this->sexo  <br>");
            print("Idade do Aluno:  $this->idade <br>");
            print("Matricula: $this->matricula <br>");
            print("Turma: $this->turma <br>");
            print("Notas: ");
            foreach($this->notas as $valor){
                print("[$valor],   ");
            }
            print("<br> Media das notas: $this->media <br><hr>");
            
        }
        
    }
    
    //Teste class Prime
    //$tmp = new Prime();
    //$tmp->testPrime(0, 999);
    
    //Teste class Pessoa 
    //$pessoa = new Pessoa();
    //$pessoa->setName("Maikon");
    //$pessoa->setIdade(20);
    //$pessoa->setSexo("Masculino");
    //$pessoa->relatorio();
    
    //Teste class Aluno
    //$a1 = new Aluno();
    //$a1->setNome("Maikon");
    //$a1->setIdade(20);
    //$a1->setMatricula("1512130069");
    //$a1->setSexo("Masculino");
    //$a1->setTurma("CCO");
    //$a1->setNotas(10, 10, 10);
    //$a1->calculaMedia();
    //$a1->relatorio();
    
?>