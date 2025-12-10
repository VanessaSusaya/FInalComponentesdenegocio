# Sistema de Gestión de Biblioteca – Spring Boot + JWT + MySQL

Proyecto desarrollado para la gestión de usuarios, libros y préstamos dentro de una biblioteca, implementando autenticación segura con JWT, manejo de roles, persistencia con Spring Data JPA y pruebas de endpoints mediante Postman.

---

## Tabla de Contenidos
- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Arquitectura del Proyecto](#-arquitectura-del-proyecto)
- [Requisitos Previos](#-requisitos-previos)
- [Instalación y Configuración](#-instalación-y-configuración)
- [Ejecución del Proyecto](#-ejecución-del-proyecto)
- [Documentación de Endpoints](#-documentación-de-endpoints)
- [Pruebas con Postman](#-pruebas-con-postman)
- [Ejemplos de Entrada y Salida](#-ejemplos-de-entrada-y-salida)
- [Base de Datos](#-base-de-datos--relaciones)
- [Enlace al Repositorio](#-enlace-al-repositorio)

---

## Descripción del Proyecto
El sistema permite gestionar la biblioteca a través de un API REST.  
Incluye:

- ✔ Registro de usuarios  
- ✔ Login y emisión de token JWT  
- ✔ Roles (ADMIN / USUARIO)  
- ✔ CRUD de libros  
- ✔ Gestión de préstamos y devoluciones  
- ✔ Validaciones con Spring Validation  
- ✔ Persistencia con JPA y MySQL  
- ✔ Manejo global de errores  

El sistema está diseñado para ser seguro, modular y fácil de integrar con un frontend web.

---

## Tecnologías Utilizadas
- Java 17  
- Spring Boot 3.x  
- Spring Security + JWT  
- Spring Data JPA  
- MySQL  
- Postman (pruebas)  
- Maven  
- Lombok (opcional)  

---

## Arquitectura del Proyecto
```bash
src/
 └── main/
     ├── java/com/example/demo/
     │   ├── controller/      → Endpoints REST
     │   ├── dto/             → Objetos de transferencia de datos
     │   ├── entity/          → Entidades JPA
     │   ├── repository/      → Repositorios JPA
     │   ├── security/        → Configuración JWT y filtros
     │   ├── service/         → Lógica de negocio
     │   └── exception/       → Manejo de errores globales
     └── resources/
         └── application.properties
```

---

## Requisitos Previos
Antes de instalar, asegúrate de tener:

- Java 17  
- Maven  
- MySQL  
- Postman  

---

## Instalación y Configuración
1️⃣ Clonar el repositorio:
```bash
git clone https://github.com/VanessaSusaya/FInalComponentesdenegocio.git
cd FInalComponentesdenegocio
```

2️⃣ Crear la base de datos

En MySQL:
```bash
CREATE DATABASE librarydb;
```

3️⃣ Configurar application.properties
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/librarydb?useSSL=false
spring.datasource.username=root
spring.datasource.password=TU_CONTRASEÑA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=claveSuperSecreta123
jwt.expiration=86400000
```

▶ Ejecución del Proyecto
Ejecutar con Maven
```bash
mvn spring-boot:run
```

## Servidor activo en:
👉 http://localhost:8080

## Documentación de Endpoints
```bash
1. Autenticación
POST /auth/register – Registrar usuario
POST /auth/login – Iniciar sesión y obtener JWT
2. Libros
GET /libros – Listar todos
POST /libros – Crear libro (ADMIN)
PUT /libros/{id} – Editar libro
DELETE /libros/{id} – Eliminar libro
3. Préstamos
POST /prestamos/crear – Registrar préstamo
PUT /prestamos/devolver/{id} – Registrar devolución
GET /prestamos/usuario/{id} – Listar préstamos por usuario
```
## Pruebas con Postman


Iniciar sesión como admin
POST http://localhost:8080/auth/login


Body:

{
  "email": "admin@libreria.com",
  "password": "admin1234"
}


Respuesta (ejemplo):

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}

Para todas las rutas protegidas, añadir HEADER:
Authorization: Bearer TOKEN_AQUI

Ejemplos de Entrada y Salida
Ejemplo: Crear libro

POST /libros

{
  "titulo": "Clean Code",
  "autor": "Robert Martin",
  "anio": 2008,
  "totalEjemplares": 5,
  "ejemplaresDisponibles": 5,
  "categoria": "Programación"
}


Respuesta

{
  "id": 1,
  "titulo": "Clean Code",
  "autor": "Robert Martin"
}

🗄 Base de Datos – Relaciones

Usuario (1) —— (N) Préstamos

Libro (1) —— (N) Préstamos

Usuario (N) —— (M) Roles

El modelo fue generado automáticamente mediante las entidades JPA.

## Enlace al Repositorio

👉 https://github.com/VanessaSusaya/FInalComponentesdenegocio.git
