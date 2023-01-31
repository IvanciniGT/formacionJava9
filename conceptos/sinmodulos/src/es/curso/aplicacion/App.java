package es.curso.aplicacion;
import com.curso.libreria.*;
import com.curso.libreria.impl.*;

public class App {
    
    public static void main(String[]args){
        Clase cl=new Clase();
        System.out.println( cl.getTexto() );
        System.out.println( cl.getNumero() );
        
        Interfaz inst1 = GeneradorInstanciasInterfaz.dameInterfazTipo1();
        System.out.println( inst1.getTexto() );
        System.out.println( inst1.getOtroNumeroDefault() );
        
        Interfaz inst2 = GeneradorInstanciasInterfaz.dameInterfazTipo2();
        System.out.println( inst2.getTexto() );
        System.out.println( inst2.getOtroNumeroDefault() );
        
        // Mejor? Esto es lo que llevamos haciendo años con los Factories y los Builders
        // Me resuleve el problema de no necesitar saber QUIEN IMPLEMENTA LA INTERFAZ? SI
        // AISLAMIENTO DE RESPONSABILIDADES : SI 
        
        // Pero hay otro que no me ha resuleto:
        // Sigo pudiendo acceder a las implementaciones? SI,  RUINA !!!!!!!
        //new Clase1QueImplementaInterfaz(); // Lo evito? NO, porque la clase es PUBLICA
        // Si le quito el public a la clase RESULEVO ESTE PROBLEMA? SI
        // Puedo quitarle el public a la clase? NO
        // O si.. si pongo todo el código en el mismo paquete... PUES VAYA SOLUCION !!!!!
        new Clase1QueImplementaInterfaz();  // ESTO ES LO QUIERO EVITAR
        // Los tios que hace App NO TIENEN QUE PODER ACCEDER A MIS COSITAS.
        // 1º Porque es mio
        // 2º Porque no me da la gana
        // 3º Porque me la pueden liar parda
        // 4º Volver al 1
        // SOLUCION QUE TENGO EN JAVA: Antes de la 1.9 NINGUNA ! A JODERSE !!!
        // Me faltan modificadores de privacidad = CAGADA DEL LENGUAJE !

        // Y hay otro nuevo que me ha aparecido
        // Ya no necesito conocer a quien implementa... pero ahora necesito conocer
        // Al generador! Pues tampoco es que esto me simplifique mucho la vida!
        // A la documentación como un capullo !!!!!
        
        // Y encima los tios que montan la libreria, han tenido que crear una clase nueva!
        
        // VAYA SOLUCIONES ! VIVA JAVA !
    }
    
}