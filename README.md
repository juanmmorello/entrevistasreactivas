##Entrevistas reactivas
####Proyecto de aprendizaje de JSONChrist para SomosPNT
####descripcion
Este es un proyecto de backend y frontend desacoplados.
El backend esta desarrollado en Spring Boot, utilizando librerias reactivas,
tanto para web, como para acceso a datos,
utilizando Project Reactor y Reactive Mongo Repositories.
El frontend esta desarrollado en Vue, utilizando NodeJS + webpack para armar
los bundles.

####Deploy
Es requisito contar con docker y docker-compose instalado. Es cuestion de ejecutar
el script de despliegue 'deploy.sh'. Esto por atras, levanta una instancia del backend,
una instancia de mongoDB y una instancia del frontend ya compilado.
Todo esto es expuesto mediante NginX en el puerto 80, listo para ser desplegado
en un entorno productivo

 