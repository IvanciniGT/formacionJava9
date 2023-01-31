# JAVA

Lenguaje de programación:
- Paradigmas: Forma de usar el lenguaje para completar ciertas tareas
    - Programación imperativa:  for , while, if, switch, else
    - Programación procedural:  Habilidad de crear y ejecutar funciones
    - Programación funcional:   Desde Java 1.8
    - Orientación a Objetos:    Hoy en día puedo montar una app cpmleta en JAVA sin una sola CLASE !!!

- Compilados vs Interpretados: 
    - Compilados:   C, C++, C#, Fortran
        Beneficios: 
            - Rendimiento de las apps normalmente superior!
                1.2 de JAVA en el JIT-> Dentro de la JVM (Hotspot)
            - Comprobación de errores!!!! 
        Contras: 
            - Un poco más engorroso que en los interpretados el proceso de empaquetado de la app. 
            - Al compilar generamos un binario ejecutable que depende de:
                - Sistema Operativo en el que se va a poder ejecutar: SOLO 1
                - Arquitectura de microprocesador x64, arm, macos (M1)
            - Acabo con un montón de binarios ejecutables que he de distribuir y mantener
    - Interpretado: Javascript, Python, Bash
        Beneficios:    
            - Menos engorrosos al empaquetar (no llevan compilación)
            - Mientras tenga un interprete en el SO de destino, solo tengo 1 distribuible
                - JS, PY: Código fuente de mi app
                - JAVA -> BYTE-CODE (lenguaje): JVM
        CONTRAS: 
            - Rendimiento de las apps ligeramente (o mucho) INFERIOR
            - No hay comprobación de errores al compilar.. no se compila!
    
        JAVA: Compilado
                .java -> javac -> .class    -> interpretado -> jvm -> codigo binario ejecutable
                                    ^
                                  byte-code

- Tipado estático vs tipado dinámico
    Tipado estático: JAVA, C, C++, C#
    Tipado dinámico: Python, JS

    qué es mejor? 
        - Como mejor, la respuesta está muy clara: ESTATICO !! SIEMPRE !!!
    qué es más cómodo? 
        - Depende.

## Variables

String texto = "hola";

Cuántas cosas hace? 3
1 - "hola"       ->     Crear u nuevo objeto de tipo String y ubicarlo en algún sitiop (NPI de donde) de la RAM
2 - String texto ->     Crea una nueva variable que puede apuntar a objetos de tipo String  
3 - =            ->     Asignamos la variable al dato. LA VARIABLE APUNTA A ESE DATO QUE TENGO EN LA RAM

texto = "adios";
1 - "adios"      ->     Crear u nuevo objeto de tipo String y ubicarlo en algún sitiop (NPI de donde) de la RAM
                        En el mismo sitio donde estaba el "hola". Ni cerquita.... Donde le venga bien!
    - En este momento cuántas cosas tengo en RAM? 2
        "hola"                  ----> SE CONVIERTE EN BASURA ... Que a posteriori habrá que limipiar: GC 
        "adios" < texto
2 - texto =      ->     Asignamos la variable al dato. LA VARIABLE APUNTA A ESE DATO QUE TENGO EN LA RAM

Variable: Una referencia a una dirección de memoria.

Las variables no varian de valor en absoluto... de Hecho no guardan valores.
Las variable no toman valores

JAVA, hace un destrozo con la memoria RAM... No es nada eficiente en su uso de la memoria RAM
    ^ Es bueno o malo? Ni bueno ni malo.... Es un feature ! Una característica de JAVA
    JAVA se diseño de esa forma... para intencionalmente generar BASURA !
        Se puso en la balanza:
            - Me interesa un lenguaje muy eficiente para controlar la memoria? NO, para eso ya tengo C, C++
            - Me interesa más un lenguaje que se más sencillo de usar, que C o C++.

## Tipado estático vs Tipado dinámico

Hay lenguajes que al definir una variable no limitan el tipo de datos al que la variable puede apuntar: TIPADO DINAMICO
    Más cómodo:
        # Python 
            numero = 7
            numero = "hola"
            numero = True
            lista = []
        # JS
            var numero = 7
            var texto = "hola"
            var logico = True
            logico = "hasta luego"
            var lista = []
    Problema? 
        No tengo ni idea que se puede meter en cada sitio:
            def generar_informe(datos: list, titulo: str): bool     EN PYTHON DA PISTAS !! 
            function generarInforme(datos, titulo): JS -> TypeScript -> transpilación -> JS
        Qué tengo que pasar como datos? NPI
            A la docu... a ver si se han dignado
            Y si no... a bucear entre el código de la función... a ver si me empapo.
                En un proyecto grande, con varias personas trabajando distintas, esto es inasumible!
        Y si quiero montar un script de 50 lineas? SUPER COMODO !!!!
        
Hay lenguajes que al definir una variable SI limitan el tipo de datos al que la variable puede apuntar: TIPADO ESTATICO
        int numero = 7;
        String texto = "hola";
        boolean logico = true;
        Map<String,List<Integer>> miLista = new HashMap<String,List<Integer>>();
        Map<String,List<Integer>> miLista = new HashMap<>();                          + JAVA 1.8
        var miLista = new HashMap<String,List<Integer>>();                            + JAVA 1.10
        
        Funcionalmente GUAY !!!!! Mucho chequeo, todo autodocumentado
        Comodo? Ni un poquito

El var de JAVA no es igual al var de JS.
La variable definida con un var en JAVA sigue teniendo un tipo... pero ese tipo se INFIERE, del valor !
Y no se cambia a posteriori.
Esto es una mierda gigante... lo de los var... OPINION PERSONAL !


## Programación funcional

Las funciones son datos / objetos como cualquier otro.
Desde una variable podemos referenciar a una función < -----
En el momento que esto es posible, podemos suministrar una función como argumento a otra función
                                   podemos hacer que una fucnión devuelva otra función como resultado
                                   
# Sintaxis de JAVA

JAVA tiene unas CAGADAS en su sintaxis de campeonato!

La pensaron con el culo!

La principal crítica a JAVA (sintaxis):

- Verbosidad... Es hartante escribir código JAVA.
                Para cualquier chorrada, tienes que escribir un huevo de código

                De hecho hoy en día existen alternativas a la sintaxis de JAVA para generar byte-code:
                - Kotlin    \   Teléfonos moviles 
                - Scala     /   Bigdata           \ Son 2 lenguajes de programación / Sintaxis alternativas a JAVA

- JAVA: null > JS: undefined > PYTHON: None             


# Entornos de desarrollo JAVA

- IntelliJ  > Google ... tiro eclipse a la basura como entorno oficial de desarrollo JAVA para Android
                            y llego a un acuerdo con IntelliJ, pagandoles una pasta todos los años para 
                            que monatran Android Studio (que es un IntelliJ capao) > JETBRAINS
- Eclipse
- Netbeans
- VSCode

# Setter and Getter!

Está bien? o es una cagada? ES UNA CAGADA !
Los setter y los getter en JAVA son importantísimos para conseguir ENCAPSULACION

ENCAPSULAR EL CODIGO ES UNA BUENA PRACTICA Y DEBES HACERLO...

No me mezcles CHURRAS CON MERINAS !!!!
ENCAPSULAR NO ES UNA BUENA PRACTICA... ES OBLIGATORIO !!!!! Lo que es una MUY MALA PRACTICA ES NO HACERLO

Hasta ahí bien... Ahora, cómo encapsular código... como en JAVA NO... que es una mierda!!

```java
// DIA 1
public Cuadrado {
    
    private int lado;
    
    public Cuadrado(int lado) {
        this.setLado(lado);
    }
    public int getLado(){
        return this.lado;
    }
    // Dia 101
    // Quiero hacer un cambio en la clase
    // Por definición, como debería ser el lado de un cuadrado? Podría ser < 0 
    public void setLado(int newLado){
        if (lado<0){
            throw new RuntimeException("No me jodas con valores negativos """");
        }
        this.lado=newLado;
    }
    
}

...
// Que pasa con el código que han escrito las tropecientas personas? 
// YA NO LES COMPILA SI QUIERA ! Esto es admisible? 
// Dia 2, 3, 4, 100 : Tropecientas personas escribiendo código como este que hay abajo

Cuadrado c1 = new Cuadrado(5);
System.out.println(c1.lado);
c1.lado = 7 ;
System.out.println(c1.lado);

````

FUNCIONA ??? SI
SI ME VEN ESCRIBIR ESO? Al dia siguiente estoy en la calle!
                        Hereje !!!!!!!!! Destrozas la encapsulación!!!!!


```java

public Cuadrado {
    
    private int lado;
    
    public Cuadrado(int lado) {
        this.setLado(lado);
    }
    public int getLado(){
        return this.lado;
    }
    // Aunque ahora no lo usas... por si el día 101 quieres hacer un chequeo.. 
    // que los tropecientos que lo usen no se vean afectados = MIERDA !!!!! > Python, C# Lo resuleven genial property
    public void setLado(int newLado){
        this.lado=newLado;
    }
    // CAGADA DE JAVA !
}

...

Cuadrado c1 = new Cuadrado(5);
System.out.println(c1.getLado());
c1.setLado( 7 );
System.out.println(c1.getLado());

```

De esos mierdolos, JAVA está lleno... y muchos cambios de los que os contaré estos días, 
van en este sentido.. en resolver estas cagadas en la sintaxis.

# Indefensión aprendida

## La historieta del elefante atado al palo con una cuerda? 

Esto nos pasa con JAVA... estamos tan acostumbrados a tantas cagadas que tiene en el
lenguaje que las hemos interiorizado... y ya no nos resultan raras, ni nos molestan... 
pero eso no significa que no sean cagadas!

## Modificadores de privacidad en JAVA

|               |  Variable o función o clase                                           |
| ------------- | --------------------------------------------------------------------- |
| Public        |  Accesible desde cualquier sitio                                      |
| Private       |  Solo desde la misma clase                                            |
| Default       |  En el mismo paquete                                                  |
| Protected     |  En el mismo paquete y clases que extendienda a la del modifiador     |

Echamos de menos
- El poder poner algo público pero no para todo el mundo... solo para otros paquetes.


C#

Solución
    Proyectos               <<<<<< Existe en JAVA? NO. Esto cambia en JAVA 9.  
        Paquetes de clases
            public lo puedo hace para mi proyecto
                                 para mi solución
                                 para todo el mundo
---

Arquitecturas actuales:

Apps de WEB !

Serv de apps: 
- Websphere     .war .ear   \
- Weblogic      .war .ear       Se están quedando para legacy !
- JBoss         .war .ear   /
------------
- Tomcat        .war


Existe una colección de estandares en el mundo JAVA que define todas esas cosas: JEE
------------------------------------------------------------------------------------------
Quién define lo que es un fichero war
Quién define lo que es un fichero ear
Quién define lo que es una aplicación WEB, Servlets, JavaFaces, JSPs
Quién define lo que es JMS
Quién define que Websphere o Weblogic o JBoss Son servidores de apps de clase empresarial
                 Mientras que tomcas es un serv. de apps de clase web

J2EE > JEE > JEE

Java® Enterprise Edition > Jakarta Enterprise Edition

Antiguamente montabamos apps web MUY GRANDE y CON MUCHAS FUNCIONALIADD (muy complejas)
Esto ha ido a más, a menos o sigue igual? Hoy en día montamos apps we muy simples... pero muchas

Cuál es el sev. de apps más usado a día de hoy? TOMCAT

---

Hoy en día no queremos montar apliaciones monolíticas : OBSOLETO !!!!

Qué problemas tenían estas aplicaciones:
- Mantenimiento complejo: Todo altamente interconectado / dependencias rígidas entre si!
- Quiero hacer un pequeño cambio => GEnerar una versión nuena de TODO EL SISTEMA: Con un nuevo paso a producción 
- Escalado granular?  O ESCALO TODO o NO ESCALO NADA !

# Escalabilidad 

Capacidad de ajustar la infraestructura a las necesidades de cada momento.

App3: Es lo normal a día a día de hoy: INTERNET : Web telepi!
    Hora 00     0
    Hora 06
    Hora 07
    Hora 12     3
    Hora 13     10
    Hora 15     200
    Hora 17     20
    Hora 20: Madrid Barça: 300000       ESCALABILIDAD HORIZONTAL: MAS MASQUINAS !
    Hora 23:   20                                   Mas copias de la APP funcionando simultaneamente
    Hora 00:    0
    
    Quiero hacer una copia nueva en funcionamieto de toda la app? 
    
--- 

# DEV---> OPS ?

Cultura de la automatización !
Automatizar QUE? TODO lo que hay entre el desarrollo y la operación de un sistema.



---
# Antiguamente con las metodologías en cascada, empeñabamos un tiempo enorme en la:
toma de requisitos          \
analisis de requisitos          Documentos de requisitos
planificación del trabajo   /   


# Metodologías ágiles:

Entregas incrementales del producto 

Dia 15 de proyecto entrego en producción: 
    Pruebas de producción del 10%
    10 % de la funcionalidad - 100% funcional, que va a producción!
Dia 30 de proyecto entrego en producción: 
    Pruebas de producción del 15%               Y de donde sale la pasta??
    +5 % de la funcionalidad - 100% funcional, que va a producción!
Dia 45 de proyecto entrego en producción: 
    +10 % de la funcionalidad - 100% funcional, que va a producción!
Dia 60 de proyecto entrego en producción: 
    +7 % de la funcionalidad - 100% funcional, que va a producción!
    
Pero esto no ha venido sin sus propios problemas !

¿ cuántas veces instalo en prod un proyecto ? TROPETANTAS ... y de donde sale la pasta? 
Y antes? Al finalizar el proeyco... después de 1 año?

Solo hay una solución? AUTOMATIZAR 

Si hago un despliegue en prod a la orden de COMMIT !
Me tengo que fiar mucho... y como no me fío? qué hacemos? MONTONES DE PRUEBAS AUTOMATIZADAS
- ESTATICAS - Pruebas que no requieren ejecutar el código
                Pruebas de calidad de código. No me interesa en esteas pruebas si el sistema funciona.
                Solo miro si el código que han escrito los desarrolladores es suficientemente DECENTE !
                Y si nolo es, ese código NO PASA A PRODUCCION... y esa decisión no la toma un humano.
                Sonarqube > leer el código ... y le calcula SMELL CODE: QUE CODIGO HUELE QUE TRAS PA'TRAS !!!!!
- DINAMICAS - Pruebas que si ejecutan el código


# Hoy en día en JAVA (desde Java9) tenemos una palabra nueva: 
module
    package
        class
        interface

# Qué tal está hoy en día el mercado del JAVA comparado con hace 20 años? Cuesta abajo y sin frenos !!

A principios de los 2000, JAVA era el lenguaje del futuro!
Solo iba a quedar JAVA
JAVA era lo mejor !!!!

JAVA Se usaba:
- Aplicaciones WEB
    Ya no montamos lamega app web monolítica:
    - Front-end                             Se monta algún frontend con JAVA?   NO, sería ruinoso
                                            Por que en JAVA no tengo las ultimas opciones tecnologicas para ello
                                            WebComponent?  AngularJS, ReactJS => Obsoletos 
                                                <usuario id="18273"/> => HTML reusable
                                            Y los navegadores de forma naiva ya ofrecen esta funcionaldiad
                                            No me hance falta Angulars, ni Reacts para tener componentes WEB
                                            Esa funcionalidad la exportan (es invocable) via JS

                                            PWA (aplicación web progresiva) . serviceWorkers.JS 
    - Back-end                              JAVA    ****** peleandose Python, C#, JS
- Aplicaciones de Escritorio                NADA
- Aplicaciones para smartphones             NADA Kotlin
- Sistemas embebidos                        NADA

Todo ese boom, pasó !
Al igual que cambiarñon la forma de desarrollar apps.
Hoy en día a JAVA solo le queda 1 cosa... un nicho !

NODE-JS = La máquina virtual de JS
    express
JVM     = LA máquina virtual de JAVA 




# Versiones de JAVA

Se crea un lenguaje de programación llamado mocha dentro del navegador Netscape . MOCHA > JAVA script
                                    V
version 1.0         1996    > Sun Microsystems
version 1.1         1997
version 1.2         1998
version 1.3         2000
version 1.4         2002
version 1.5         2004
version 1.6         2006
    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< LA MUERTE DE JAVA ! Java cae en manos de los TO LO QUE TOCO LO JODO !
                                                                                            ORACLE 
version 1.7         2011    + 5 años? 
version 1.8         2014    
    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< LA SEGUNDA MUERE DE JAVA : Oracle dice que va a cobrar por la JVM
                                                                            Usuario 25$/año
                                                                            Empresa 50$/core
version 9           2017    + 3 años        projecto jigsaw -> modulos
                                                JVM -> Spec . Hoy en día tenemos un huevo de implementaciones de la JVM
                                            JShell.Guiño a los Pythoneros.. a ver si les engaño y les traigo a JAVA
version 10         2018   + 6 meses
                                            La palabra var. Guiño a los JS y Pythoneros.. a ver si les engaño y les traigo a JAVA 
version 11         2018   + 6 meses    
version 12         2019    
version 13         2019    
version 14         2020    
version 15         2020    
version 16         2021    
version 17         2021    
version 18         2022    
version 19         2022    
version 20         2023    


Sun microsystems
- OpenOffice            >           StarOffice  (CLOSED)
            > LibreOffice
- MySQL                                         (LA DEJARON MORIR)
            > MariaDB
- Hudson                                        (LA DEJARON MORIR)
            > Jenkins !

# Sun microsystems

Grandioso fabricante de HARDWARE !!!!
- Con una arquitectura propia de microprocesador: sparc
- Con su propio sistema operativo: SOLARIS , UNIX®


----

El conjunto de interfaces publico que tengo en mis paquetes de mi libreria 
es lo que llamamos: API

API? Application programming INTERFACE
La implementación la tengo que hacer (montar mis clases) 
Debe la gente acceder a ello? Tengo que exponerlas? NO

1º Puedo exponer de un proyecto JAVA solo las interfaces?  PUBLICAS solo las interfaces?
SI.. siempre y cuando Monte TODO el código en un paquete! Y entonces... vaya gracia los paquetes.
Si tengo mi codigo en varios paquetes esto no puedo hacer

2º Puedo exponer solo las interfaces?

---

Libreria en JAVA: 
Obtener un diccionario para un idioma
Me debe 
El conjunto de interfaces publico que tengo en mis paquetes de mi libreria 
es lo que llamamos: API

API? Application programming INTERFACE
De ese diccionario quiero consultar si una palabra existe y si no, que me sugiera las posibilidades
mancana -> manzana?
Diccionario -> 650k palabras de español

paquete: com.curso.diccionario
Interfaces? 
- public Diccionario.java      --->  Interfaz
    - public boolean existe(String palabra)
    - public List<String> sugerencias(String palabra)
    - public List<String> definición(String palabra)               //CAGADA pero luego hablamos de esto !
- public SuministradorDeDiccionarios.java
    - Diccionario dameDiccionario(String idioma)
 

paquete: com.curso.diccionario.impl
Clases
- [default] DiccionarioImpl.java  ---> clase implementa Diccionario
- [default]SuministradorDeDiccionariosImpl
    - Diccionario dameDiccionario(String idioma)
       // CODIGO . ES POSIBLE EN JAVA METER CODIGO EN UN INTERFAZ? Desde Java 1.8 podemos meter código en interfaces
                    // funciones static 
                    // funciones de instancia (default)
                Uno de los cambios que tenemos en Java 9 es poder definir metodos de instancia privados en interfaces
        // Le puedo dar gracia... y cargarlo la primera vez y guardarlo en una caché

----> diccionario-v1.0.2.jar

-----
Un tio está montando su app
    Quiero un diccionario
    ...
    #SuministradorDeDiccionarios suministrador = new SuministardorDeDiccionarios();
    SuministradorDeDiccionarios suministrador = SuministardorDeDiccionarios.dameDiccioanrio();
    Diccionario myDict = suministrador.dameDiccionario("ES");

----

- public boolean existe(String palabra)
    Que devuelve esta función: 
        true Si encuentra la palabra
        false si no encuentra la palabra

- public List<String> sugerencias(String palabra)
        Una lista con palabras parecidas... Y si no encuentra ninguna?  Una lista vacia
                                                                        null                NO TIENE SENTIDO CONCEPTUAL ! 
                                                                                            MUY MALA PRACTICA

        CONCEPTUALMENTE es lo mismo que una palabra (que no existe) tenga 5 o 7 sugerencias? TOTALMENTE
            El comportamiento del sistema es el mismo: Dará 5 o 7 sugerencias.
            Y si solo hay una sugerencia cuantas devuelvo? 1
            Y si hay 14 sugerencias cuantas devuelvo? 14
            Y si no hay. Si hay 0 sugenrecias? Devuelvo 0

        Ese comportamiento "mágico" donde lo encuentro detallado?       Documentación. Quién se lee una documentación? 
            En serio me tengo que leer una documentación para entender cómo funciona una función? 
                Si es así es que la SINTAXIS TIENE UN PROBLEMA !
                                

- public List<String> definición(String palabra)    <<< Cagada. por qué?
        Qué devuelve? 
            Una lista con las definiciones de la palabra, si existe.
                Si una palabra tiene 3 definiciones, cuantas devuelvo? 3
                Si una palabra tiene 30 definiciones, cuantas devuelvo? 30
            Y si la palabra no existe? 
                Lanzar una exception . Nos gusta lanzar Exceptions? NO , nada !
                                        Cuando se debería lanzar una excepcion? Cuando sea un erro IMPREVISIBLE!
                En este caso, antiguamente es cuando devolviamos un null!
                    Pero hoy en día esta considerado una NUY MUY MUY FATALMENTE MUY MALA PRACTICA DEVOLVER UN NULL !!!!
                    Nunca una función debe devolver null: Por qué es un compartamiento "mágico" que no está explicitado en la sintaxis
            Desde java 1.8 hay una alternativa a esto, considerada LA BUENA PRACTICA, SIN OPCION, SIN ALTERNATIVA :
                OPTIONAL

- public Optional<List<String>> definición( String palabra )    >>>> SIGUE SIENDO UNA MIERDA GIGANTE !
        misTerminos.get(palabra);


        Que es un optional? 
            Una forma de explicitar en la sintaxis que una funcion puede no devolver nada!
        Optional no presente< Valor vacio. No devuelve NADA != null
        
    null LO ODIAMOS A MUERTE ! 
    Ya no se trabaja con el null!!!!!!!

    Estoy explicitando que palabra NO QUIERO QUE SEA null? NO
    
- public Optional<List<String>> definición( @NonNull String palabra )    >>>> Ahora si ! GUAY !!!!


JAVA 1.5                    + ANOTACIONES 
en JAVA 1.7                 + Poder escribir una anotación al definir una variable, dentro de una función (argumentos)
jpa -> JEE