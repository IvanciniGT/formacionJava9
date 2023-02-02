Goles de maven

resources
    compile         *** compila lo que hay donde? src/main/java
        test-compile        compila lo que hay donde? src/test/java
            test                ejecuta las pruebas unitarias definidas en src/test/java
                package         *** empaqueta -> .jar .war .ear pom
                    install         *** Copiar el el artefacto (.jar, .war, .ear)
                                        dentro de nuestro directorio .m2

# Directorio .m2

Eso es un directorio oculto (el . al princpio del nombre implica que es oculto)
que se genera en nuestra carpeta de usuario.

Cuando un proyecto tiene una dependencia, maven mira si la tiene en ese diretorio.
Si no la tiene la intenta descargar de MAVEN CENTRAL


# Estructura de proyecto
                                                                        
diccionarioapp              JAVA                MAVEN               SCM(git 95%)
    aplicacion              modulo                                      submodule-repo independiente
        pom.xml                                 proyecto
    diccionario             modulo                                      submodule-repo independiente
        pom.xml                                 proyecto
    diccionarioFicheros     modulo                                      submodule-repo independiente
        pom.xml                                 proyecto
pom.xml                                         proyecto padre      repositorio


stackoverflow
95%   git
 4%   Nada
 1%   svn
 
# JSHELL

Shell interactiva de java. 

Es una linea de comandos donde puedo ejecutar código java, para:
- Programación exploratoria     *** Me olvidaría .. me olvidé
- Pruebas                       *** Nasti de plasti: Framework de pruebas unitarias 
                                                     Software externo
- Lanzar scripts de java        ES VERDAD. PARA ESTO ES GENIAL !
                                YA ERA HORA !
                                Los DESARROLLADORES no hacemos scripts

Intento de captar a gente que está comenzando a programar y eligen python u otros.

# SOFTWARE

Aplicaciones
Servicios
Drivers
SO
Demonios
Comandos
SCRIPTS         Java no ha estado pensado para montar scripts.
                Hay lenguajes que si:
                        - BASH SCRIPTING
                        - PYTHON
                        - JS        NodeJS
                        - JAVA? Es horrible para montar scripts.. clases... y sus interfaces y sus paquetes... que agobio
                Gente que si monta scripts, que no son los desarolladores.
                    Testers
                    SysAdmins
                    Analistas de datos
                    ETL


## Pruebas de software

Que no os gustan nada! Pero me las trago!

No nos gusta que las llame pruebas !

### Pruebas de software

Clasificacion 1: CONCEPTO DE LA PRUEBA

- Estáticas             Que no ejecutan el código
    - Pruebas de calidad de código < SONARQUBE   
- Dinámicas             Que obligan a ejecutar el código
    - Funcionales       Miran la funcionalidad... el comportamiento del sistema
    - No funcionales    Otros aspectos
        - Rendimiento
                    Quiero mirar la velidad de respuesta de la app > End2End
                    Quiero mirar la latencia de la red en una comunicación a la BBDD > UNITARIA
        - Estres
        - Carga
        - UI
        - UX
        - HA
        - Escalabilidad

Clasificación 2: NIVEL DE LA PRUEBA

- Unitarias             Pruebas que hacemos sobre un componente "AISLADO"
                                Método
                                Clase
                                Query
                        En ocasiones para aislar un componente usamos los frameworks de MOCK
                        CUANTAS? MINIMO tantas como la "complejidad ciclomática" del código
                        Quiero probar cada función de forma AISLADA <<< OBLIGATORIO 
                            Eso lo mira el SONARQUBE : COBERTURA:
                                Qué porcentaje de lineas de código están cubiertas por pruebas unitarias:
                                    80-90%
                        Las hace el desarrollador en su lenguaje, sin herramientas externas,
                            solo usando un framework de pruebas unitarias JUNIT, TESTNG
                        En ocasiones también mediante frameworks de MOCK que complementan a los de pruebas unitarias
- Integración           Prueban la comunicación entre componentes
- Sistema (End2End)     Prueban el sistema en su conjunto: EL COMPORTAMIENTO
                        Que el sistema hace lo que tiene que hacer !
    - Aceptación        Las que me piden. Subconjunto de las de Sistema

# MOCK

Man in the middle

Quizás en algún sitio de mi código yo pido una query a la BBDD
O llamo a un servicio web por http

El mock intercepta eso. Y devuelve una salida PREESTABLECIDA

# Como persona que lleva más de 35 años desarrollando software, consejo:

En cuanto podais empezar METEROS EN EL MUNDO DE LAS PRUEBAS UNITARIAS
Va a mejorar mucho vuestra calidad de vida.


