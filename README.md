# Sistema Modular CRUD + Java + JavaSwing + SQL
> SistemaModular-CRUD-Java-JavaSwing-SQL

> Autor : Fernando Calmet  
https://github.com/fernandocalmet  
----------
<p>Esta aplicación de muestra está destinada a proporcionar un ejemplo práctico de una aplicación modular. Específicamente, esta aplicación de muestra demuestra lo siguiente:</p>

<ul>
	<li>Crear, Eliminar, Listar uno, Modificar, Listar todos y Busquedas con filtro de datos.</li>
	<li>Acceso de conexión y desconexión de usuarios al sistema.</li>
	<li>Para la conexión con con la base de datos se importan los drivers de las bibliotecas correspondientes de cada gestor de base de datos.</li>	
</ul>

<p>Tenga en cuenta que si bien este programa de ejemplo funciona, las características mencionadas anteriormente no están destinadas a ser tomadas y utilizadas en aplicaciones comerciales de producción. En otras palabras, este no es un proyecto semilla para ser tomado  e implementado en su entorno de producción.</p>  

<p>Por ejemplo, ciertos problemas no se abordan en absoluto en esta  muestra (por ejemplo, seguridad, privacidad, entre otros). En esta aplicación de muestra, se enfoca por lograr un equilibrio entre claridad, facilidad de mantenimiento y rendimiento. Sin embargo, la claridad es, en última instancia, la cualidad más importante en una aplicación de muestra.</p>

<p>Por lo tanto, hay ciertos casos en los que podríamos renunciar a una implementación más complicada (por ejemplo, el almacenamiento en caché de un valor de uso frecuente, un manejo robusto de errores, una estructura de modelo de dominio más genérico) a favor de un código que sea más fácil de leer. En ese sentido, agradezco cualquier comentario que haga que esta aplicación de muestra sean más fácil de aprender.</p>
  
## Tabla de contenidos
* [Requerimientos](#requerimientos)
* [Diagrama de Casos de uso](#diagrama-de-casos-de-uso)
* [Diagrama de Clases](#diagrama-de-clases)
* [Diagrama de Datos](#diagrama-de-datos)
* [Diagrama de Componentes](#diagrama-de-componentes)
* [Diagrama de Despliegue](#diagrama-de-despliegue)
* [Demostración de la aplicación](#demostracion-de-la-aplicacion)
  
  
## Requerimientos
### Requerimientos Funcionales
- Conexión + Desconexión de acceso de usuarios
- Operaciones CRUD + Busqueda con filtro de datos

### Requerimientos No funcionales
1. Java JDK 1.8
2. MySQL JDBC Driver (mysql-connector-java)
3. Microsoft JDBC Driver (sqljdbc42)
4. Apache XAMPP [apachefriends.org](https://www.apachefriends.org/)
5. XAMMP: Servicio del modulo Apache
6. XAMMP: Servicio del modulo MySQL

## Diagrama de Casos de uso
![Diagrama de Casos de uso](diagramas/Diagrama-Casos_de_uso.png)

## Diagrama de Clases
![Diagrama de Clases](diagramas/Diagrama-Clases.png)

## Diagrama de Datos
![Diagrama de Datos](diagramas/Diagrama-Datos.png)

## Diagrama de Componentes
![Diagrama de Componentes](diagramas/Diagrama-Componentes.png)

## Diagrama de Despliegue
![Diagrama de Despliegue](diagramas/Diagrama-Despliegue.png)

## Demostracion de la aplicacion
![Demostracion GIF](diagramas/demo.gif)