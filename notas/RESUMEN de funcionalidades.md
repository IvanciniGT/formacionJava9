# JAVA 1.5        

## Anotaciones
## Iterable

# JAVA 1.8

## Soporte a programación funcional

- java.util.fucntion;
- Operador ::
- Lambdas

### Streams en collections
    .stream()
    .parallelStream()
                        .map()
                        .flatMap()
                        .filter()
                        .sort()
                        
                        .collect()
                        .forEach()
                        .reduce()
                        
## Posibilidad de meter una anotación al definir los argumentos de una función
    @NonNull
## Optional

Evitar el uso de null como valores devueltos de una función.
Obligando a que el comportamiento de una función quede TOTALMENTE explicitado en su definición

## Cambios en interfaces

- Meter funciones estáticas públicas (con código, por estática no haría falta ni decirlo)
- Meter funcions de instancia con código por defecto    "default"

# JAVA 9

## Modulos

Proyecto Jigsaw

### Concepto de modulo

module-info.java
    requires
    exports
    uses
    provides

Nuevos argumentos en javac y java
    javac --module-source-path
    java --module-source
    
## ServiceLoader

Nos permite obtener instancias de un interfaz, sin conocer quien las implementa
Y sin necesidad de implementar Factories, Builders..

Las instancias que se devuelven se implementan como SINGLETONS 
Surje un concepto similar al de Spring: Inyección de dependencias
        
        ### Inversión de depedencias
        
        Básicamente es el uso de Interfaces para acceder a las funciones que una clase implementa
        Los módulos de alto nivel no dependan de los de bajo nivel... sino de una abstración (Interfaz)

### Inyección de depedencias        <<< JAVA9

Que a mi me den una instancia de un Interfaz sin conocer quién es la clase que lo implementa.
Yo no elijo esa clase. Lo elige el que monta la clase y el interfaz.
        
        ### Inversión de control            <<< SPRING
        
        Yo ya no controlo el flujo de la app ... en el caso de SPRING, es SPRING el que controla el flujo de mi app
        Eso me permite:
        - Que en el constructor se me suministren automáticamente datos, solo por yo haberlos definido
        - Que pueda tener en una instancia variables con valores ya asignados a través de ANOTACIONES

## Interfaces

- Creación de métodos static privados

## Métodos .of de las interfaces del paquete collecions

## JSHELL

# JAVA 10

## Uso de la palabra var

## ...

# JAVA 11

## Posibilidad de ejecutar directamente archivos .java desde la máquina virtual

## Posibilidad de meter la palabra var en los argumentos de las expresiones lambda ?

Para poder usar ANOTACIONES ! sin necesidad de especificar el tipo, haciendo más legible el código

## ...