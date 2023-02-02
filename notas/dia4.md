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