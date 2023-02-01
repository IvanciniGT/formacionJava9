package com.curso.diccionario;

import java.util.Optional;

public interface SuministradorDeDiccionarios {

    Optional<Diccionario> getDiccionario(String idioma);

}