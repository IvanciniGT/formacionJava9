package com.curso.libreria;

public interface Interfaz {
    
    //private static String miDato ="";     No cuela
                                            // En una clase si
    
    String getTexto(); // por defecto en un interfaz es public
    
    // Para que sirven estos métodos?
    // public static : MONTONONES: Todos los que antes metiamos en clases
    // Para que los quería en una clase? 
    //      Dependen de una instancia concreta?  NO 
    //      Se heredan? SI... y de una interfaz? Tabién
    //      Se pueden sobreescribir? NO
    //      Entonces, por qué en una clase?
    //          Por que no habia otro SITIO !
    // Realmente TODOS lo que podiamos hacer en los metodos static de las clases
    // lo podemos hacer aquí? NO
    // Hay una diferencia? En las interfaces no podemos definir VARIABLES ESTATICAS !
    //                      a nivel de la interfaz
    static String getOtroTexto(){                   // SI J.18
        return Interfaz.getOtroTextoPrivado();
    }
    
    // Para que sirven ?
    // Para el código que tengo en un metodo publico statico partirlo en varios trozos y hacerlo más legible
    // Para reusar parte del codigo en varios metoso publicos static
    private static String getOtroTextoPrivado(){    // SI J1.9
        return "soy en interfaz";
    }
    
    // Para qué sirven?
    //  para que las clases hijas no necesiten implementarlo < En una clase abstracta
    // Qué es lo que motiva la inclusión de este tipo de métodos?
    //  Permitir ampliar la funcionalidad de una interfaz sin QUE ME MATEN LOS 3M de personas que han usado mi interfaz y la han extendido
    default String getOtroNumeroDefault(){          // SI, J1.8
        return "hola desde la interfaz";
    }
    // Dia 1 monto una interfaz con el metodo a
    // Dias del 2 al 100... Montonones de personas usan mi interfaz... la extienden y crean sus clases y se ponen a funcionar en sus programas
    // Dia 101 Se me ocurre la brillante idea de añadir una función nueva en la interfaz
    //          Y le pongo una implemenatción por defecto
    // Dia 102 : Las personas poco a poco van haciendo uso SI QUIEREN de esa nueva funcionaldiad
                // SIGO VIVO 
}