
import com.curso.diccionario.Diccionario;
import com.curso.diccionario.SuministradorDeDiccionarios;
import java.util.ServiceLoader;
import java.util.List;

String palabra = "melon";
String idioma  = "ES";

System.out.println("Cargando diccionario");

SuministradorDeDiccionarios suministradorDeDiccionario = ServiceLoader.load(SuministradorDeDiccionarios.class).iterator().next();  // J1.9: ServiceLoader y módulos
Diccionario miDiccionario = suministradorDeDiccionario.getDiccionario(idioma).orElseThrow( () -> new RuntimeException("Vaya cagada de diccionario: " + idioma) );
System.out.println("Diccionario cargado.... calentando");

for (int i=0;i<10;i++)
    List.of("muelasd","cacatoa", "plo", "membrillz").stream().forEach( p -> miDiccionario.getSugerencias(p) );

System.out.println("Buscando la palabra "+ palabra +" en el diccionario "+ idioma);
long tin=System.currentTimeMillis();
if(miDiccionario.existe(palabra)){
    System.out.println("La palabra significa:");
    miDiccionario.getDefiniciones(palabra).get().stream().forEach(System.out::println); // J1.8 Optional + Stream
}else{
    System.out.println("La palabra no existe. Quizás quisiste decir una de estas???");
    miDiccionario.getSugerencias(palabra).stream().forEach(System.out::println);  // J1.8 Optional + Stream
}
long tout=System.currentTimeMillis();
System.out.println("Hemos tardado: "+(tout-tin)+" milisegundos");


/exit