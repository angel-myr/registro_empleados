# 📌 Proyecto de Registro de Empleados con Spring Boot, Seguridad y Exportación de Reportes

Este proyecto fue desarrollado como parte de mi formación en **Ingeniería de Sistemas**.  
Consiste en una aplicación web de gestión de empleados que incluye autenticación de usuarios, control de accesos por roles y generación de reportes en **PDF y Excel**.  

El proyecto está construido con **Spring Boot 3**, **Thymeleaf**, **Spring Security 6** y **PostgreSQL** como base de datos.

---

## 🚀 Características principales

- ✅ **Gestión CRUD de empleados** (crear, listar, editar y eliminar).  
- 🔐 **Autenticación y autorización** con Spring Security y roles `ADMIN` / `USER`.  
- 📄 **Exportación de reportes** en formato PDF y Excel.  
- 📑 **Validaciones** en formularios con mensajes personalizados.  
- 📊 **Paginación y navegación** en listados de empleados.  
- 🗄️ **Conexión a PostgreSQL** mediante Spring Data JPA.  

---

## 🛠️ Tecnologías utilizadas

- **Backend**: Java 17, Spring Boot 3, Spring Data JPA, Spring Security 6  
- **Frontend**: Thymeleaf, Bootstrap 4, CSS personalizado  
- **Base de datos**: PostgreSQL 15  
- **Dependencias adicionales**:
  - [LibrePDF / OpenPDF](https://github.com/LibrePDF/OpenPDF) → generación de PDF  
  - [Apache POI](https://poi.apache.org/) → generación de Excel  

---

## 📂 Estructura principal del proyecto

```plaintext
├── src/main/java/com/jaed/control
│   ├── entidades        # Entidades JPA (Empleado, Usuario)
│   ├── repositorios     # Interfaces DAO con Spring Data
│   ├── servicio         # Lógica de negocio
│   ├── controlador      # Controladores web
│   ├── seguridad        # Configuración de Spring Security
│   └── util             # Clases para exportación y paginación
│
├── src/main/resources
│   ├── static/css       # Estilos CSS personalizados
│   ├── templates        # Vistas Thymeleaf (HTML)
│   ├── application.properties
│   └── messages.properties
