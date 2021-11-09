# Hashing_Java_SpringBoot
Generar un endpoint que permita cargar archivos a través de FORM-DATA y por parámetro en la URL poder determinar el algoritmo de hash a aplicar sobre los archivos. Las funciones hash que se deben aplicar sobre los archivos deben ser solamente SHA-256 y SHA-512 del conjunto SHA-2

Ejemplo:
```postman:
  URL: localhost:8080/api/hash?algorithm=SHA256
  BODY (FORM-DATA)
        documents: File[]
```
La respuesta del endpoint debería ser similar a esta:
```json:
{
  "algorithm": "SHA256",
  "documents": [
    {
    "fileName": "test.txt",
    "hash": "8cc6618520b943d7a32a69899f5c68ad2d43eae6e211d2c646b89cef4e7137f2"
    },
    {
    "fileName": "test2.txt",
    "hash": "8cc6618520b943d7a32a69899f5c68ad2d43eae6e211d2c646b89cef4e7137f3"
    }
  ]
}
```

Para ejecutar el programa:
* clone el repositorio 
* ejecutelo con el comando: mvn spring-boot:run
* primero se instalaran las dependencias correspondientes para que el proyecto funcione correctamente
* abra postman, coloque la url: localhost:8080/api/hash?algorithm=SHA*** con el endpoint POST
* reemplaze los *** por el algoritmo que desee usar para encriptar SHA256 o SHA512, en caso de que elija otro no se podra encriptar recibira como respuesta un mensaje de aviso
* seleccione los archivos que desee encriptar y ejecute el programa
