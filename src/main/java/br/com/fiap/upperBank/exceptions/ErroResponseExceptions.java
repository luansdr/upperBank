package br.com.fiap.upperBank.exceptions;

public class ErroResponseExceptions extends Exception{


    public ErroResponseExceptions(String message){
        super(message);
    }


    public ErroResponseExceptions(){
        super("Algo deu errado");
    }
    
}
