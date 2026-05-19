# Sistema de Gestión de Garage

## Descripción
Este sistema permite administrar de forma integral un garage o estacionamiento, gestionando el ingreso, permanencia y salida de diferentes tipos de vehículos (Autos, Motos y Camiones). El software controla la disponibilidad de espacio en tiempo real y calcula automáticamente los costos de estadía basándose en tarifas diferenciadas por tipo de vehículo.

## Características Principales
- **Gestión de Espacios**: Cada vehículo ocupa un espacio específico (Vehiculos.Moto: 1, Vehiculos.Auto: 2, Camión: 4).
- **Cálculo de Tarifas**: Polimorfismo aplicado para calcular costos según horas estimadas.
- **Sistema de Seguridad**: Manejo de excepciones personalizadas para evitar errores de negocio (patentes duplicadas, falta de espacio, etc.).
- **Reportes**: Visualización de recaudación total, cantidad de vehículos y estado del garage.

## Tecnologías Utilizadas
- Java 17+
- Programación Orientada a Objetos (POO)
- Manejo de Colecciones (ArrayList)
- Gestión de Excepciones

## Estructura del Proyecto
- `/src`: Código fuente .java
- `/docs`: Documentación UML (PDF) y fundamentación de diseño.

## Cómo Ejecutar
1. Clonar el repositorio.
2. Abrir el proyecto en un IDE (IntelliJ IDEA recomendado).
3. Ejecutar la clase `Main.java`.
4. Seguir las instrucciones del menú interactivo por consola.
