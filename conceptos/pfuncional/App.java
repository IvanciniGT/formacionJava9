// java App.java            Desde Java 11
// Cómo veis eso?           Otra gilipollez para los de JS o python
import java.util.function.*;
import java.util.*;

public class App {
    
    public static void main(String[] args) {
        
        System.out.println(App.doblar(6));
        System.out.println(App.mitad(6));
        
        // Es posible referenciar una función en JAVA ? 
        // En JAVA 1.8 si, con un nuevo operador que s incluye en JAVA 1.8 ::
        imprimirResultadoDeUnaOperacion( App::doblar, 8 );
        imprimirResultadoDeUnaOperacion( App::mitad, 8 );
        
        // En JAVA 1.8 se añade adicionalmente la opción de crear expresiones lambdas
        // Expresión lambda? 
        // Es una expresión: Algo que devuelve un dato 
        // En este caso, una función ANONIMA 
        //Function<Double,Double> operacion = (Double numero) -> { return numero*2;}; 
                                                        // El tipo de dato devuelto SE INFIERE 
        Function<Double,Double> operacion = (numero) -> { return numero*2;};
                                            // El tipo de dato de entrada también se puede INFERIR
        // Function<Map<String,List<String>> ,Double> operacion = ( @NonNull var numero) -> { return numero*2;}; 
                                            // En JAVA 11, se añadió la posibilidad de poner en los datos de 
                                            // entrada de una lmabda la palabra var
                                            // Le veis gracia? Así visto NINGUNA
                                            // Si lo miro con perspectiva y con las BUENAS PRACTICAS DE HOY EN DIA ... mucha
                                            // Nos da la opción de meter anotaciones antes de la variable, sin forzarnos a escribir el tipo
                                            // Esceribir el tipo, no me preocupa, lo hace solo el entorno de desarrollo
                                            // Pero la linea queda ilegible
        System.out.println(operacion.apply(19.9));
        imprimirResultadoDeUnaOperacion( numero -> numero*3, 20 );
        
        // Esto nos permite en JAVA implementar patrones MAP REDUCE de procesamiento de datos
        // Y en JAVA 1.8 hubo un cambio enorme en el paquete Collections => Stream (aplicar funciones a los items de una coleccion)
        
        //List<String> miLista=new ArrayList<>();
        //miLista.add("TExto 1");
        //miLista.add("TEXTO 2");
        //miLista.add("Texto 3");
        
        // Java 1.9 nuevo cambio en el paquete Collections. Metodos .of en los interfaces de las colecciones
        // Es un cambio en Java 1.9 que no es gran cosa... no aporta nada que no podía hacer antes
        // Pero es COMODO !
        List<String> miLista=List.of("TExto 1", "TEXTO 2", "texto 3");
        
        // Quiero iterar esta lista:
        // Pre java 1.5
        for (int indice = 0; indice < miLista.size(); indice++){
            System.out.println(miLista.get(indice));
        }
        // Pre java 1.8
        for (String texto : miLista){
            System.out.println(texto);
        }
        // Post java 1.8
        miLista.stream().forEach(System.out::println);      // No sólo más cómo de escribir
                                                            // Si no también más eficiente en la ejecución
        miLista.stream()
                        .map( texto -> texto.toUpperCase() )
                        .filter( texto -> texto.endsWith("2") )
                                                                // ^ Metodos de mapeo
                                                                // Reciben un Stream y devuelven un Stream
                        .forEach( System.out::println );        // < Función de reduce. Ya no devuelve un Stream
                                                            // Si no también más eficiente en la ejecución
        miLista.stream()
                        .map( texto -> texto.toUpperCase() )
                        .filter( texto -> texto.endsWith("2") )
                                                                // ^ Metodos de mapeo
                                                                // Reciben un Stream y devuelven un Stream
                        .forEach( System.out::println );        // < Función de reduce. Ya no devuelve un Stream
        miLista.parallelStream()    /// Abre todos los hilos necesarios en función den # de cpus que tenga
                        .map( texto -> texto.toUpperCase() )
                        .filter( texto -> texto.endsWith("2") )
                                                                // ^ Metodos de mapeo
                                                                // Reciben un Stream y devuelven un Stream
                        .forEach( System.out::println );        // < Función de reduce. Ya no devuelve un Stream
    // Tengo una máquina con 8 cores
    }
    
    public static void imprimirResultadoDeUnaOperacion(Function<Double,Double> operacion, double numero ){
        // operacion (función) la ejecute con el valor del numero
        // Y su resultado se imprima
        double resultado = operacion.apply(numero);
        System.out.println(resultado);
    }
    
    public static double doblar(double numero) {
        return numero * 2;
    }
    
    public static double mitad(double numero) {
        return numero / 2;
    }
    
}