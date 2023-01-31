package com.curso.libreria;
import com.curso.libreria.impl.*;

public class GeneradorInstanciasInterfaz {
    
    public static Interfaz dameInterfazTipo1(){
        return new Clase1QueImplementaInterfaz();
    }
    
    public static Interfaz dameInterfazTipo2(){
        return new Clase2QueImplementaInterfaz();
    }
    
}