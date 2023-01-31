package com.curso.libreria;

public interface Interfaz {
    
    String getTexto(); 
    static String getOtroTexto(){
        return Interfaz.getOtroTextoPrivado();
    }
    
    private static String getOtroTextoPrivado(){
        return "soy en interfaz";
    }
    default String getOtroNumeroDefault(){ 
        return "hola desde la interfaz";
    }
}