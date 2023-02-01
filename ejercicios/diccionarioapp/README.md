El objetivo Montar una app de consola que me permita preguntar si una 
palabra existe en un determiando idioma.

si la palabra existe, se muestran sus definiciones

si la palabra no existe se muestran sugerencias de la misma **** Os lo resulco ya: Algoritmo Levenstein

---

Pero... voy a tener en cuenta, que este tema, quizás lo pueda usar a futuro en otros proyectos
distintos de mi app de consola

---

Y además, que a día de hoy voy a hacer una implemnetación de ello, que va a leer las palabras (términos)
de un fichero... y voy a utilizar un determinado algoritmo para identificar las sugerencias

FICHERO PALABRAS.txt
palabra=definicion1|definicion2|definicion3                 **** Ya os lo resolveré yo: Con 2 funcione nuevas de Java 11

---

Quizás mañana monte una alternativa completa a todo esto,
trabajando con palabras que terngo en una BBDD o en un SERVICIO WEB
Y haciendo las queries a la BBDD o el servicio WEB cuando me soliciten una palabra.

---
Cómo lo hacemos?

# Cuantos módulos? 3
Bendita inyeccion de dependencias

- El concepto de lo que es un diccionario con sus funciones y la capacidad de poder solicitar un diccionario
    diccionario.jar     < Puras interfaces ! Nada más
  - exports? SI, el del paquete que defina las interfaces
- Una implementación del concepto de lo que es un diccionario con sus funciones y alguien que me de 
  la capacidad de poder solicitar un diccionario    < Puras clases
    diccionarioDeFichero.jar
    diccionarioDeBBDD.jar
  - exports? NO
  - provides? SI proveer un servicio Suministrador de Diccionarios
  - requires? SI del diccionario
  - uses? NO
- Una aplicación de consola... que usará el concepto de diccionario y la capacidad de poder solicitar un diccionario
    app.jar
        > diccionario.jar
            > diccionarioDeBBDD.jar
  - exports? NO
  - provides? NO
  - requires? SI del diccionario y de una implemnatción de un diccionario < JAR
  - uses? SI el servicio del Suministrador de Diccionarios
```java
   
   String palabra_preguntada = "...";
   SuministradorDeDiccionarios suministradorDeDiccionario = <<< NPI... aquí está la inyección de dependencias.
   // Si el día de mañana quiero cambiar al que me suministra los dccionarios, quiero cambiar el código? 
   Diccionario diccionario = suministradorDeDiccionarios.getDiccionario(idioma);
   
   ....
    
``` 


# Los paquetes que vamos a usar

com.curso.diccionario
com.curso.diccionario.fichero
con.curso.aplicacion
