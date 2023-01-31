javac -d compilado \
    --module-source-path src \
    src/moduloa/com/curso/libreria/*.java \
    src/moduloa/com/curso/libreria/impl/*.java \
    src/app/es/curso/aplicacion/*.java \
    src/app/*.java \
    src/moduloa/*.java

java --module-path compilado \
     -m app/es.curso.aplicacion.App