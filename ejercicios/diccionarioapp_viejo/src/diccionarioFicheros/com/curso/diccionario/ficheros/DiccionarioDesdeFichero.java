package com.curso.diccionario.ficheros;

import com.curso.diccionario.Diccionario;
import java.util.List; 
import java.util.Map; 
import java.util.Optional; 
import java.util.Comparator; 
import java.util.stream.Collectors;

public class DiccionarioDesdeFichero implements Diccionario {
    
    private final Map<String,List<String>> palabras;
    private final String idioma;

    public DiccionarioDesdeFichero(String idioma){
        this.idioma = idioma;
        this.palabras = Utilidades.cargarDiccionario(this.idioma);
    }
    
    public boolean existe(String palabra){
        return palabras.containsKey(Utilidades.normalizar(palabra));
    }
    
    public Optional<List<String>> getDefiniciones(String palabra){
        return Optional.ofNullable(palabras.get(Utilidades.normalizar(palabra)));
    }
    
    public List<String> getSugerencias(String palabra){
        //final var palabraABuscar = normalizar(palabra);   // J1.8 J10 // Pondría esto en mi vida? NO, NUNCA. MALA PRACTICA
        final String palabraABuscar = Utilidades.normalizar(palabra);  // J1.8 // Pondría esto en mi vida? SI. BUENA PRACTICA
        
        return this.palabras.keySet()                                                                           // Aplicar la distancia de levenstein sobre TODAS las palabras del diccionario
                            .parallelStream()                                                                   // vamos a poner la CPU pa' freir huevos.. calentita !
                            .map(       termino     -> new Sugerencia( termino,
                                                             Utilidades.distancia(termino, palabraABuscar)) )   // Esto me da un numerito
                            .filter(    sugerencia  -> sugerencia.diferencia <= Utilidades.DISTANCIA_MAXIMA )   // Quitar las palabras que se alejen más de DISTANCIA_MAXIMA unidades
                            .sorted(    Comparator.comparing( sugerencia -> sugerencia.diferencia )         )   // Ordeno de menor a mayor puntuación
                            .limit(     Utilidades.MAXIMO_SUGERENCIAS                                       )   // Devuelvo todas? a lo mejor son muchas... Corto en MAXIMO_SUGERENCIAS0
                            .map(       sugerencia  -> sugerencia.termino                                   )   // Me quedo solo con los términos
                            .collect(   Collectors.toList()                                                 );  // Lo convierto a una lista
    }
    
    
    private static class Sugerencia{
        String termino;
        int    diferencia;
        
        Sugerencia(String termino, int diferencia){
            this.termino=termino;
            this.diferencia=diferencia;
        }
    }
    
}