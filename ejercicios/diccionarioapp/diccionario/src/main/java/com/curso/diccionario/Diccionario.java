package com.curso.diccionario;

import java.util.Optional;
import java.util.List;

public interface Diccionario {
    
    boolean existe(String palabra);
    
    Optional<List<String>> getDefiniciones(String palabra);
    
    List<String> getSugerencias(String palabra);
    
}