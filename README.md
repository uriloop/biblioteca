Práctica Hibernate & JPA
Intro
Con la utilización de Hibernate & JPA y la informacion extraída en el proyecto WebScrapping llamado Animal he conseguido diseñar un programa capaz de hacer un mapeo objeto-relacional donde cada objeto tendra sus atributos y este programa poblara las tablas, capaz de realizar consultas, gestiónar resultados, modificarlos y procesarlos.
Code
El código empieza con un proyecto como esqueleto llamado JPAMagazinesAnnotations, este nos facilitara la implementación de los controladores y modelos. Hay dos controladores, uno para cada tabla, en los dos me he visto obligado a añadir la librería Opencsv que es realmente útil para lo que necesitamos para poblar las tablas de nuestros archivos .csv del anterior proyecto 'Animal', estos controladores nos permiten hacer cosas muy interesantes como consultar datos de la base de datos de la manera que nosotros queramos, yo he intentado replicar la manera visual de PostgreSQL para facilitar la visualización de las consultas. Por cada controlador un modelo con los atributos de cada animal o habitat.
Instrucciónes
Será necesario alterar los datos en el archivo db.properties y persistence.xml para poder conectarnos a la base de datos.
Será necesario tener una base de datos, con el schema.sql. Iniciamos el Main y ya podemos empezar

