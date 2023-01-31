module moduloa {
    
    // Voy a definir que PAQUETES exporta
    // Es decir, que PAQUETES pueden importarse dede otros MODULOS
    // Solo las clases e interfaces PUBLICOS de este PAQUETE serán accesibles desde otros MODULOS.
    // Podemos incluso limitar QUE MODULOS pueden acceder a ello
    
    // Por tanto, desde por ejemplo appm podran acceder a: 
    // - com.curso.libreria.impl.Clase1QueImplemntaInterfaz? NO
    //          Pero??... si la clase es publica??? 
    //          YA, pero el PAQUETE al que pertenece NO SE EXPORTA 
    
    exports com.curso.libreria;         // to app;
    
    // Ofrece unos servicios
    provides com.curso.libreria.Interfaz   with  com.curso.libreria.impl.Clase1QueImplementaInterfaz,
                                                 com.curso.libreria.impl.Clase2QueImplementaInterfaz;
}