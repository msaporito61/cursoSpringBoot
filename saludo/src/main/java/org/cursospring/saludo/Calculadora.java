package org.cursospring.saludo;

public class Calculadora {
    
    public static Long sumar(Long x, Long y){
        return x+y;
    }

    public static Long restar(Long x, Long y){
        return x-y;
    }


    public Calculadora() {
    }

    @Override
    public String toString() {
        return "Calculadora []";
    }

    
}
