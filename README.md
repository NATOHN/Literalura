# Resolución del Desafío: Catálogo de Libros en Literalura
## Descripción del Desafío
El desafío consiste en construir una aplicación que permita gestionar un catálogo de libros, utilizando un sistema de base de datos y una interfaz de línea de comandos. Los usuarios deben ser capaces de realizar las siguientes acciones:
1. Buscar libros por título en una base de datos externa (por ejemplo, una API).
2. Guardar libros encontrados en una base de datos local.
3. Listar todos los libros guardados en la base de datos.
## Enfoque y Solución
### 1. **Tecnologías Utilizadas**
   - **Spring Boot** para la construcción de la aplicación backend.
   - **Spring Data JPA** para la integración con la base de datos.
   - **Scanner** para la interacción de la línea de comandos con el usuario.
   - **API externa (Gutendex)** para la búsqueda de libros.
### 2. **Funcionalidades Desarrolladas**
   
   - **Buscar y Guardar Libros:**
     Utilizando el servicio `LibroService`, la aplicación permite que los usuarios busquen libros por título en una API externa y guarden la información en una base de datos local. Esto se hace mediante la clase `ConsolaApp` que interactúa con el servicio y presenta las opciones al usuario.
   
   - **Listar Libros Guardados:**
     La aplicación puede listar todos los libros guardados en la base de datos utilizando la clase `LibroRepositorio`, que maneja la persistencia de los libros.
   - **Interfaz de Línea de Comandos:**
     La interacción se realiza a través de un menú que permite al usuario elegir entre buscar un libro, listar los libros guardados o salir del programa.
### 3. **Solución de Problemas**
   Durante el desarrollo, uno de los principales problemas que enfrenté fue integrar correctamente la base de datos y la API externa para obtener la información de los libros. Para ello, creé métodos específicos en el servicio `LibroService` para manejar las consultas a la API y los procesos de almacenamiento en la base de datos.
### 4. **Ejecución del Proyecto**
   Para ejecutar la aplicación localmente, sigue estos pasos:
   1. **Clonar el Repositorio:**
      ```bash
      git clone https://github.com/tu-usuario/literalura.git
      ```
   
   2. **Configurar la Base de Datos:**
      Asegúrate de que tienes configurada una base de datos (PostgreSQL, MySQL, etc.) y actualiza las configuraciones de conexión en el archivo `application.properties`.
   
   3. **Compilar y Ejecutar la Aplicación:**
      ```bash
      ./mvnw spring-boot:run
      ```
   4. **Interacción:**
      - Inicia la aplicación y utiliza el menú de opciones para buscar libros, listarlos o salir del programa.
### 5. **Pruebas Realizadas**
   Realicé pruebas unitarias utilizando JUnit y Mockito para verificar que los servicios de búsqueda y almacenamiento de libros funcionaban correctamente. También se probó la interacción con la API externa y el manejo de datos en la base de datos.
## Conclusiones
Este desafío me permitió aplicar conocimientos sobre Spring Boot, Spring Data JPA y la integración con APIs externas. Además, pude aprender a gestionar la interacción con el usuario mediante una interfaz de línea de comandos simple y efectiva.
## Contribuciones
Si deseas contribuir al proyecto, realiza un fork del repositorio, agrega nuevas funcionalidades o mejora las existentes, y envía un pull request.
## Licencia
Este proyecto está bajo la Licencia MIT.
