# 🥩 Meat-Manager

Sistema de gestión integral para carnicería con suscripción de clientes, construido con Java 21 y Spring Boot 3. Desarrollado como proyecto de portfolio con foco en arquitectura limpia, buenas prácticas y tecnologías del ecosistema Spring.

> Inspirado en problemas reales observados en el día a día de un negocio: lentitud al cargar proveedores, suscripciones que no se registran, caídas del servidor. No es "otra app de portfolio" — es una solución a problemas concretos.

---

## ⚙️ Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA** — persistencia y consultas personalizadas
- **Spring Cache** — caché básico para optimización
- **MapStruct** — mapeo entre entidades y objetos de dominio
- **PostgreSQL** — base de datos relacional
- **Flyway** — migraciones versionadas de base de datos
- **Docker & Docker Compose** — entornos reproducibles
- **JUnit 5 & Mockito** — testing unitario e integración
- **Swagger / OpenAPI** — documentación automática de la API
- **Maven** — gestión de dependencias
- **DBeaver** — administración de base de datos
- **Postman** — pruebas de endpoints
- **Git & GitHub** — control de versiones
- **IDE:** IntelliJ IDEA

---

## 📐 Arquitectura del proyecto

El sistema está organizado siguiendo **Arquitectura Hexagonal (Puertos y Adaptadores)**, garantizando una separación estricta entre la lógica de negocio y la infraestructura.

```
src/
 ├── application/
 │    ├── handler/         → Casos de uso (un handler por operación)
 │    ├── request/         → Objetos de entrada por caso de uso
 │    ├── response/        → Objetos de salida por caso de uso
 │    └── mediator/        → Patrón Mediator para despacho de handlers
 ├── domain/
 │    ├── model/           → Entidades del dominio (Client, Product, etc.)
 │    └── repository/      → Puertos (contratos de repositorio)
 ├── infrastructure/
 │    ├── controller/      → Exposición de endpoints REST
 │    ├── dto/             → DTOs de request y response HTTP
 │    ├── entity/          → Entidades JPA
 │    ├── mapper/          → MapStruct: entidades ↔ dominio ↔ DTOs
 │    ├── repository/      → Adaptadores (implementaciones JPA)
 │    └── config/          → Configuración de cache, Swagger, etc.
 └── test/
      ├── unit/            → Tests unitarios por caso de uso
      └── integration/     → Tests de integración con base de datos real
```

---

## 🧱 Principios y patrones aplicados

- **Arquitectura Hexagonal** (Puertos y Adaptadores)
- **Patrón Mediator** — desacopla el controller de los casos de uso
- **Principios SOLID**
- **DTO + MapStruct** — separación entre capas
- **Inyección de dependencias**
- **Manejo de excepciones personalizado**
- **Logs estructurados con SLF4J**
- **Variables de entorno** para credenciales sensibles

---

## 🗄️ Base de datos y migraciones

La base de datos corre en un contenedor Docker con PostgreSQL. Las migraciones son versionadas con **Flyway**:

```
resources/
 └── db/
      └── migration/
           ├── V1__create_client_table.sql
           └── V2__insert_initial_data.sql
```

Cada cambio en el esquema se registra como un nuevo script versionado. Nunca se modifican scripts anteriores.

---

## 🐳 Docker

Levantá el entorno completo con un solo comando:

```bash
docker-compose up -d
```

El `docker-compose.yml` levanta:
- **PostgreSQL** en el puerto `5432`
- Base de datos `spring` para desarrollo
- Base de datos `spring_it` para tests de integración
- Volumen persistente para los datos

---

## 🧪 Testing

```
✅ Tests unitarios por caso de uso
✅ Tests de integración con PostgreSQL real
✅ JUnit 5 + Mockito
✅ Casos felices y casos de error
✅ Validación de excepciones y flujos alternativos
```

---

## 🔍 Consultas personalizadas

Implementadas con Spring Data JPA usando métodos derivados y `@Query`:

```java
Optional<ClientEntity> findByEmail(String email);
List<ClientEntity> findByAgeBetween(int minAge, int maxAge);
```

---

## 🧩 Funcionalidades implementadas

- ✅ Gestión de clientes (CRUD completo)
- ✅ Búsqueda por email y por rango de edad
- ✅ Caché básico en consultas frecuentes
- ✅ Tareas programadas (Schedules)
- ✅ Migraciones de base de datos con Flyway
- ✅ Documentación automática con Swagger
- ✅ Perfiles de configuración (dev / test)
- 🔄 Spring Security + JWT *(en curso)*
- 🔜 Sistema de suscripciones
- 🔜 Notificaciones por WhatsApp al registrar una compra
- 🔜 Agente de IA para reportes de caja

---

## 🚀 Próximas mejoras

- **Spring Security + JWT** — autenticación y autorización por roles
- **Sistema de suscripciones** — con notificaciones automáticas de vencimiento
- **Mensajería por WhatsApp** — confirmación de compras en tiempo real
- **Agente de IA** — reportes de caja conversacionales: ventas del día, productos más rotados, cierre de mes
- **Spring Cloud / Microservicios** — evolución de la arquitectura

---

## 👨‍💻 Autor

**Caín Cabrera**  
Backend Developer en formación | Java & Spring Ecosystem  
📍 Buenos Aires, Argentina  
[![GitHub](https://img.shields.io/badge/GitHub-Cain--Cabrera-181717?logo=github)](https://github.com/Cain-Cabrera)  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-cain--cabrera-0A66C2?logo=linkedin)](https://www.linkedin.com/in/cain-cabrera-286a882a8/)
