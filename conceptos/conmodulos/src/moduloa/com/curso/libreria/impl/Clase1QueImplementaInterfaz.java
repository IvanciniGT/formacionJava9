package com.curso.libreria.impl;
import com.curso.libreria.*;

public class Clase1QueImplementaInterfaz implements Interfaz {
    
    public Clase1QueImplementaInterfaz () {
        
    }
    
    public String getTexto(){
        return "hola desde la clase 1 que implementa la interfaz";
    }

    public String getOtroNumeroDefault(){
        return "hola desde la clase 1 que implementa la interfaz, sobreescribiendo el default";
    }
}