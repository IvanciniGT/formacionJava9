package com.curso.aplicacion;

import com.curso.diccionario.Diccionario;
import com.curso.diccionario.SuministradorDeDiccionarios;
import java.util.ServiceLoader;

public class App {
    
    public static void main(String[] args){
        if(args.length != 2){
            System.out.println("No me has dado palabra o idioma. Saliendo");
            System.exit(1);
        }
        
        String palabra = args[0];
        final String idioma  = args[1];
        System.out.println("Buscando la palabra "+ palabra +" en el diccionario "+ idioma);
        
        SuministradorDeDiccionarios suministradorDeDiccionario = ServiceLoader.load(SuministradorDeDiccionarios.class)
                                                                              .iterator()
                                                                              .next();  // J1.9: ServiceLoader y módulos
        Diccionario miDiccionario = suministradorDeDiccionario
                                            .getDiccionario(idioma)  // J1.8 Optional + Programación funcional
                                            .orElseThrow( () -> new RuntimeException("Vaya cagada de diccionario: " + idioma) );
        
        if(miDiccionario.existe(palabra)){
            System.out.println("La palabra significa:");
            miDiccionario.getDefiniciones(palabra).get().stream().forEach(System.out::println); // J1.8 Optional + Stream
        }else{
            System.out.println("La palabra no existe. Quizás quisiste decir una de estas???");
            miDiccionario.getSugerencias(palabra).stream().forEach(System.out::println);  // J1.8 Optional + Stream
        }
    }
    
}

        // Optional<Diccionario> miPosibleDiccionario = suministradorDeDiccionario.getDiccionario(idioma);
        // if(!miPosibleDiccionario.isPresent()){
        //     throw new Exception("Diccionario no reconocido: "+diccionario");
        // }
