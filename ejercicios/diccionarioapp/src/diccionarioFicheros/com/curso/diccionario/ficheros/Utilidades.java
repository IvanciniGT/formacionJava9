package com.curso.diccionario.ficheros;

import java.net.URL; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.util.Arrays; 
import java.util.List; 
import java.util.Map; 
import java.util.Objects; 
import java.util.stream.Collectors;

interface Utilidades {

    static int distancia(String str1, String str2) {    // J1.8
        return computeLevenshteinDistance(str1.toCharArray(),
                                          str2.toCharArray());
    }

    private static int minimum(int a, int b, int c) {   //J1.9
         return Math.min(a, Math.min(b, c));
    }

    private static int computeLevenshteinDistance(char [] str1, char [] str2) {   //J1.9
        int [][] distance = new int[str1.length+1][str2.length+1];

        for(int i=0;i<=str1.length;i++){
                distance[i][0]=i;
        }
        for(int j=0;j<=str2.length;j++){
                distance[0][j]=j;
        }
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){ 
                  distance[i][j]= minimum(distance[i-1][j]+1,
                                        distance[i][j-1]+1,
                                        distance[i-1][j-1]+
                                        ((str1[i-1]==str2[j-1])?0:1));
            }
        }
        return distance[str1.length][str2.length];
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
                               .map(        linea -> linea.split("=") )                                           // Parto por el igual
                               .collect(    Collectors.toMap( partes -> normalizar(partes[0]),                               // Que uso en el map como clave
                                                              linea  -> Arrays.asList(partes[1].split("\\|")) )); // Que uso en el map como valor
        }catch(Exception e){
            throw new RuntimeException("Error al cargar el diccionario");
        }
    }
    
    static String normalizar(String palabra){
        return palabra.toLowerCase();
    }
}
