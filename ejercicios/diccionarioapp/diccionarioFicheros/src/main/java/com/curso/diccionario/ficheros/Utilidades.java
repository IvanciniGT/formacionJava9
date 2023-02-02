package com.curso.diccionario.ficheros;

import java.net.URL; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.util.Arrays; 
import java.util.List; 
import java.util.Map; 
import java.util.Objects; 
import java.util.stream.Stream;
import java.util.Collection;
import java.util.stream.Collectors;

interface Utilidades {
    
    public static final int DISTANCIA_MAXIMA   =  2;
    public static final int MAXIMO_SUGERENCIAS = 10;

    static int distancia(String str1, String str2) {    // J1.8
        if ( Math.abs(str1.length() - str2.length()) > DISTANCIA_MAXIMA ) return DISTANCIA_MAXIMA+2;
        return distance(str1,str2);
    }

    static final int [] costs_template = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}; //[b_length + 1];

    private static int distance(String a, String b) {
        int b_length=b.length();
        b_length=b_length<=20?b_length:20;
        int a_length=a.length();
        int [] costs = costs_template.clone(); ///new int[][b_length + 1];
        //for (int j = 0; j < costs.length; j++)
        //    costs[j] = j;
        for (int i = 1; i <= a_length; i++) {
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b_length; j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        return costs[b.length()];
    }
    
    static Map<String,List<String>> cargarDiccionario(String idioma){

        String nombreDelFichero   =  "diccionario."+idioma+".txt";
        URL urlFicheroDiccionario =  Objects.requireNonNull(Utilidades.class.getClassLoader().getResource(nombreDelFichero));
                                     // MUY BUENA PRACTICA. Si no, el sonarqube me tira el código a la cara !
                                     // Necesito una URL. Si no la tengo no quiero que se ejecute ni una sol
                                     // linea más del código. Genera un NullPointerException
        try{
            String contenidoDelFichero = Files.readString(Path.of(urlFicheroDiccionario.getFile()));    // J11
            return contenidoDelFichero.lines()                                                                   // Para cada linea
                               .filter(     linea -> linea.trim().length()>0)
                               .map(        linea -> linea.split("=") )                                           // Parto por el igual
                               .collect(    Collectors.toMap( partes -> normalizar(partes[0]),                               // Que uso en el map como clave
                                                              partes -> Arrays.asList(partes[1].split("\\|")) ,
                                                              (definiciones1, definiciones2) -> 
                                                                  Stream.of(definiciones1, definiciones2)
                                                                  .flatMap(Collection::stream)
                                                                  .collect(Collectors.toList())
                                                              )); // Que uso en el map como valor
        }catch(Exception e){
            throw new RuntimeException("Error al cargar el diccionario",e);
        }
    }
    
    static String normalizar(String palabra){
        return palabra.toLowerCase();
    }
}
