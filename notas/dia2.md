# Patron listener PRE JAVA 1.8

public interface Listener {
    public void notify(String arg);
}

public class LoQueSea implements Listener{
    
    ...
    Tarea t = new Tarea();
    t.addListener(this);
    t.run();
    ...
    
    public void notify(String arg){
        System.out.println(arg);
    }
}

public class Tarea{
    ...
    private List<Listener> listeners= new ArrayList<>();
    
    public void addListener(Listener listener){
        listeners.append(listener);
    }
    
    public void run(){
        
        // Llame a otros sitios para notificarle el grado de avance
        for ( Listener  listener : listeners) {   JAVA 1.5 < - Interface ITERABLE
            listener.notify("Voy por aquí!");
        }
    }
}


# Patron listener POST JAVA 1.8

public class LoQueSea{
    
    ...
    Tarea t = new Tarea();
    t.addListener(this::notify);
    t.run();
    ...
    
    public void notify(String arg){
        System.out.println(arg);
    }
}

public class Tarea{
    ...
    private List<Consumer<String>> listeners= new ArrayList<>();
    
    public void addListener(Consumer<String> listener){
        listeners.append(listener);
    }
    
    public void run(){
        
        // Llame a otros sitios para notificarle el grado de avance
        for ( Listener  listener : listeners) {   JAVA 1.5 < - Interface ITERABLE
            listener.notify("Voy por aquí!");
        }
    }
}

---
# Proyecto modulos

modulos/
        src/
            com/
                curso/
                     libreria/
                             Clase
                             Interfaz
                             ClasesQueImplementanLaInterfaz
            es/
                curso/
                     aplicacion/
                                App.java
                                    main :
                                        Clase
                                        Interfaz
        compilado/
                    *.class
                    
---

Orden de complejidad de un algoritmo: 
    O(n) O(log(n)) O(n·log(n))
    Lo enseñan en la carrera / modulo
    Esto vale para algo? Si estoy montando una bbdd, puede ser. SI NO PA POCO !
    
    Cómo crece lo que tarda un algoritmo en ejecutarse cuando crece el número de datos sobre los que opera
    
Complejidad ciclomatica
    SonarQube:
        El número de caminos distintos que puede tomar un código al ejecutarse < limita a nivel de función

Complejidad cognitiva
    SonarQube:
        Cómo de complejo es para un ser humano entender un código <<<< Superlimita 
        
        
if condicion1
    tarea1                      
    if condicion2               
        tarea2                  CAMINO 1    tarea 1 y tarea 2
    else if condicion3
        tarea3                  CAMINO 2    tarea 1 y tarea 3
                                CAMINO 3    tarea1
else
    if condicion4
        tarea4                  CAMINO 4    tarea4
    else
        tarea5                  CAMINO 5    tarea5
        

        
        
Complejidad ciclomatica de este codigo?     5 Y ACIERTA !
Complejidad cognitiva?                      ALTA !  <<<< Esto lo mira mucho el sonar

switch(variable1){
    case 1:
        tarea1
        break;
    case 2:
        tarea2
        break;
    case 3:
        tarea3
        break;
    case 4:
        tarea4
        break;
    case default:
        tarea5
        break;
}
Complejidad ciclomatica de este codigo?     5
Complejidad cognitiva?                      BAJA 
