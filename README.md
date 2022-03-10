# Java Login Layered Skeletor

[![Github][github-shield]][github-url]
[![Kofi][kofi-shield]][kofi-url]
[![LinkedIn][linkedin-shield]][linkedin-url]
[![Khanakat][khanakat-shield]][khanakat-url]

## 📓 TABLA DE CONTENIDO

* [Acerca del proyecto](#acerca-del-proyecto)
* [Características](#características)
* [Instalación](#instalación)
* [Licencia](#licencia)

## 🔥 ACERCA DEL PROYECTO

Este proyecto es una muestra de una solución base de `CRUD Layered + Swing UI` utilizando `Java + JDBC + MySQL`.  
Funcionalidades del proyecto CRUD, Login, Swing UI, Programación Orientada a Objetos (POO). Arquitectura tradicional en Capas, Basado en Patrones de Arquitectura de Aplicaciones Empresariales (PEAA) y Diseño Orientado al Dominio (DDD).

IDE utilizado: `Intellij IDEA`

Esta simple **Aplicación Java Swing**, permite que las operaciones **CRUD** administren recursos como: `Usuarios Tareas y Notas`.

## ✔️ CARACTERÍSTICAS

- [x] Servicios Base de Datos (CRUD)
- [x] Formularios con Swing UI, Only-Window
- [x] Iniciar sesión, Cerrar Sesión y Mostrar datos del usuario
- [x] Roles y Privilegios de usuarios
- [x] Editar Perfil de Usuario + Validaciones de seguridad de datos

### Solo Usuarios Administradores de sistema (SA)

- Mostrar datos de Usuarios
- Buscar / Filtrar datos de Usuarios
- Agregar Usuarios
- Editar Usuarios
- Eliminar Usuarios

### Característica del proyecto

- Arquitectura tradicional en capas (DDD)
- Basada en algunos patrones de software de PEAA y DDD
- Programación Orientada a Objetos
- Base de datos JDBC / MySQL
- Java
- Intellij IDEA

## Descripción general de la estructura (MODELO-ARQUITECTURA)

### Capa Interfaz de Usuario

La capa de interfaz de usuario es responsable de presentar la información al usuario e interpretar los comandos del usuario asignándolos a los servicios de la capa de aplicación.

### Capa de Dominio

La capa de dominio contiene los modelos de dominio y objetos de valores independientes.Esta capa contiene información sobre el dominio empresarial. Es responsable de los conceptos de dominio de negocios, información sobre los casos de uso de negocios y las reglas de negocios. Los objetos de dominio encapsulan el estado y el comportamiento de las entidades comerciales .

### Capa de Infraestructura

Esta capa actúa como una biblioteca de apoyo, también transversal para todas las demás capas, facilitando la comunicación entre todas las capas.Sus responsabilidades incluyen; Proporcionar comunicación entre capas, Implementa persistencia para objetos de negocio (Comunicación con la base de datos), proporcionar caché de registro y servicios de seguridad.

### Descripción detallada de la estructura

![diagrama de estructura](/extra/img/structure_diagram.png)

## Abstracciones

En este componente solo debe contener Interfaces, una interfaz contiene las definiciones de un grupo de funcionalidades relacionadas que una clase o una estructura pueden implementar. Mediante las interfaces puede incluir, un comportamiento de varios orígenes en una clase. Esta capacidad es importante, porque Java entre otros, no admiten la herencia múltiple de clases. Además, debe usar una interfaz si desea simular la herencia de estructuras, porque no pueden heredar de otra estructura o clase. Te recomiendo investigar la importancia de Interfaces y Clases Abstractas.

### Interfaz Repositorio Genérico

Esta interfaz declara todos los métodos (CRUD) genéricos  de los objetos de acceso datos (Dao), tales como: Agregar, Editar, Eliminar, Obtener todos los datos, y Obtener datos por Valor (Búsqueda/ Filtro).

### Interfaz Repositorio de Usuarios

Implementa la interfaz repositorio genérico, por lo tanto implementa todos los métodos CRUD Genéricos, aquí adiciona otras funcionalidades de User Dao, por ejemplo método login (Establecida en el proyecto).

## Repositorio

Este componente es responsable de persistir los datos de la aplicación en la base de datos.

### Clase Repositorio (Clase Abstracta / Base)

Esta clase establece la comunicación con la base de datos, la cadena de conexión esta definida en la misma clase.

### Clase Repositorio de Usuarios

Clase objeto de acceso a datos del usuario (User Dao), es responsable de realizar las peticiones y operaciones CRUD del usuario en la base de datos, en esta clase se establece los parámetros. (Implementa la Interfaz Repositorio de Usuarios)

### Clase Repositorio de Notas

Clase objeto de acceso a datos de notas (Note Dao), es responsable de realizar las peticiones y operaciones CRUD de notas en la base de datos, en esta clase se establece los parámetros. (Implementa la Interfaz Repositorio de Notas)

### Clase Repositorio de Tareas

Clase objeto de acceso a datos de tareas (Task Dao), es responsable de realizar las peticiones y operaciones CRUD de tareas en la base de datos, en esta clase se establece los parámetros. (Implementa la Interfaz Repositorio de Tareas)

## Entidades

En este componente se Mapea todas las tablas de la base de datos, es decir, tendrás una clase por cada tabla (Entidad).

## ⚙️ INSTALACIÓN

Clonar el repositorio.

```bash
gh repo clone FernandoCalmet/Java-Login-Layered-Skeletor
```

Ejecutar aplicación.

```bash
dotnet run
```

## 📄 LICENCIA

Este proyecto está bajo la Licencia (Licencia MIT) - mire el archivo [LICENSE](LICENSE) para más detalles.

## ⭐️ DAME UNA ESTRELLA

Si esta Implementación le resultó útil o la utilizó en sus Proyectos, déle una estrella. ¡Gracias! O, si te sientes realmente generoso, [¡Apoye el proyecto con una pequeña contribución!](https://ko-fi.com/fernandocalmet).

<!--- reference style links --->
[github-shield]: https://img.shields.io/badge/-@fernandocalmet-%23181717?style=flat-square&logo=github
[github-url]: https://github.com/fernandocalmet
[kofi-shield]: https://img.shields.io/badge/-@fernandocalmet-%231DA1F2?style=flat-square&logo=kofi&logoColor=ff5f5f
[kofi-url]: https://ko-fi.com/fernandocalmet
[linkedin-shield]: https://img.shields.io/badge/-fernandocalmet-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/fernandocalmet
[linkedin-url]: https://www.linkedin.com/in/fernandocalmet
[khanakat-shield]: https://img.shields.io/badge/khanakat.com-brightgreen?style=flat-square
[khanakat-url]: https://khanakat.com
