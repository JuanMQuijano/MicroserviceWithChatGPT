# Microservicio de Consulta GPT

Este es un microservicio desarrollado en **Spring Boot** que se conecta a la API de **GPT** para hacer consultas sobre un tema ingresado por el usuario. El microservicio obtiene las primeras **X páginas** según la importancia, y retorna la información en formato de **reseña**, incluyendo la **URL**, **descripción** y **rating** de cada sitio.

## Características
- **Tema**: El usuario especifica el tema de interés.
- **Total de páginas**: El usuario define el número de resultados que desea obtener.
- **Formato de respuesta**: Reseñas con **URL**, **descripción** y **rating**.

## Requisitos

- **Java 17 o superior**
- **Spring Boot 2.x**
- **Dependencia de la API de GPT**

## Ejemplo Request & Response
- GET http://localhost:8080/chat?theme=pizza&total=4 

- [
  {
    "url": "https://example.com/pizza",
    "description": "En este sitio puedes encontrar recetas deliciosas de pizza, consejos sobre ingredientes y técnicas de cocción.",
    "rating": 4.5
  },
  {
    "url": "https://pizzaexpert.com",
    "description": "Pizza Expert ofrece una amplia variedad de pizzas gourmet, con una calificación de 4.7 estrellas.",
    "rating": 4.7
  },
  {
    "url": "https://pizzamagazine.com",
    "description": "La mejor revista de pizza, con artículos sobre historia y variedades de pizza en todo el mundo.",
    "rating": 4.0
  },
  {
    "url": "https://pizzasuper.com",
    "description": "Pizza Super es un servicio de entrega de pizza rápida con calificaciones de usuarios que la catalogan como la mejor opción.",
    "rating": 4.3
  }
] **
