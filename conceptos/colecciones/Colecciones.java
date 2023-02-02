import java.util.List;

public class Colecciones {
    
    public static void main(String[] args){
        
        List<String> miLista = List.of("item1", "item2", "item3"); // J9
        var miLista2 = List.copyOf(miLista);                       // J10
        
        // Importante, esos elementos me devuelven una coleccion INMUTABLE !
        // Tanto los de J9, como los de J10
        
        miLista2.stream().forEach(System.out::println);
        
    }
    
}

// java Colecciones.java ( J11)