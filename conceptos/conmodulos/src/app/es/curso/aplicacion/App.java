package es.curso.aplicacion;
import com.curso.libreria.*;

import java.util.ServiceLoader;     // JAVA 9

public class App {
    
    public static void main(String[]args){
        Clase cl=new Clase();
        System.out.println( cl.getTexto() );
        System.out.println( cl.getNumero() );

        Iterable<Interfaz> interfaces = ServiceLoader.load(Interfaz.class);
                                        // Eso funciona como singleton
                                        // cada vez que lo llamo no me da una instancia
                                        // ME da siempre la misma
        
        for( Interfaz miInterfaz : interfaces){
            System.out.println( miInterfaz.getTexto() );
            System.out.println( miInterfaz.getOtroNumeroDefault() );
        }
    }
    
}