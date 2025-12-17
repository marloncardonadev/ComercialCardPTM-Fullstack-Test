# 📦 Gestión de Productos – Prueba Técnica

Este proyecto corresponde a la **Prueba Técnica para el cargo Analista Desarrollador**.  
Consiste en una aplicación **Full Stack** con **Backend en Spring Boot (Java)** y **Frontend en React + TypeScript**, que permite la gestión de productos, métricas de inventario y funcionalidades adicionales solicitadas.

---

## 🧱 Arquitectura General

### Backend
- **Lenguaje:** Java 17
- **Framework:** Spring Boot 3
- **Base de datos:** MySQL
- **Arquitectura:** Clean Architecture (DDD ligero)
- **Persistencia:** Spring Data JPA
- **API:** REST

### Frontend
- **Framework:** React 18
- **Lenguaje:** TypeScript
- **Build tool:** Vite
- **HTTP client:** Axios
- **Estilos:** CSS puro

---

## 📂 Estructura del Proyecto

```
root/
 ├── backend/
 │   ├── src/main/java/com/comercialcard/crudapp
 │   ├── src/main/resources
 │   └── pom.xml
 └── frontend/
     ├── src/
     ├── package.json
     └── vite.config.ts
```

---

## ⚙️ Requisitos Previos

- Java 17+
- Maven
- Node.js 18+
- MySQL 8+
- Git

---

## 🗄️ Base de Datos

Crear la base de datos en MySQL:

```sql
CREATE DATABASE crud_app;
```

Las tablas se generan automáticamente al iniciar el backend.

---

## ▶️ Ejecución del Backend

```bash
cd backend
mvn clean spring-boot:run
```

Backend disponible en:

```
http://localhost:8080
```

---

## ▶️ Ejecución del Frontend

```bash
cd frontend
npm install
npm run dev
```

Frontend disponible en:

```
http://localhost:5173
```

---

## 🔌 Endpoints Principales

### Productos
- `GET /api/products`
- `POST /api/products`
- `PUT /api/products/{id}`
- `DELETE /api/products/{id}`

### Inventario
- `GET /api/products/inventory/summary`

### Combinaciones
- `POST /api/products/combinations`

```json
{
  "budget": 10000
}
```

---

## 🧮 Funcionalidades Implementadas

### Backend
- CRUD completo de productos
- Cálculo del valor total del inventario
- Producto con mayor valor de inventario
- Algoritmo de combinaciones (2–3 productos, máx. 5 resultados)
- Manejo global de errores
- Configuración CORS

### Frontend
- CRUD de productos (crear, listar, actualizar, eliminar)
- Ordenamiento por precio (sin backend)
- Resumen de inventario
- Combinaciones por presupuesto
- Modal con **2 datos sobre gatos** traducidos al español
- Footer con **dato inútil del día**
- UI limpia y responsive

---

## 🐱 APIs Externas Utilizadas

- Cat Facts: https://github.com/wh-iterabb-it/meowfacts
- Useless Facts: https://uselessfacts.jsph.pl/

---

## 🧠 Decisiones Técnicas Destacadas

- Separación clara de responsabilidades (Clean Architecture)
- Dominio independiente del framework
- Frontend tipado y modular
- Sin sobre–ingeniería innecesaria
- Código legible y mantenible

---

## 🧪 Pruebas

La arquitectura está preparada para pruebas unitarias sobre:
- Servicios de dominio
- Casos de uso
- Algoritmo de combinaciones

---

## 👤 Autor

**Marlon Cardona**  
Prueba Técnica – Analista Desarrollador

---

## ✅ Estado del Proyecto

✔ Funcional  
✔ Probado localmente  
✔ Listo para evaluación
