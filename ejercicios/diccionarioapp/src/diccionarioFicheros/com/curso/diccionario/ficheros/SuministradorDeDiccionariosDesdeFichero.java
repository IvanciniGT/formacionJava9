package com.curso.diccionario.ficheros;

import com.curso.diccionario.SuministradorDeDiccionarios;
import com.curso.diccionario.Diccionario;
import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

public class SuministradorDeDiccionariosDesdeFichero implements SuministradorDeDiccionarios {

    private final Map<String,Diccionario> diccionarios = new HashMap<String,Diccionario>();
    
    public SuministradorDeDiccionariosDesdeFichero(){
            //diccionarios.put("ES",new DiccionarioDesdeFichero("ES"));
    }

    public Optional<Diccionario> getDiccionario(String idioma){
        if(!diccionarios.containsKey(idioma))
            diccionarios.put(idioma,new DiccionarioDesdeFichero(idioma));
        return Optional.ofNullable(diccionarios.get(idioma));
    }

}