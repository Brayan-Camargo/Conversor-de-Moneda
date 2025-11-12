# 💰 Conversor de Moneda (Java CLI)

Una aplicación de línea de comandos (CLI) desarrollada en Java para realizar conversiones de moneda en tiempo real y registrar las transacciones realizadas.

## ✨ Resumen del Proyecto

Este proyecto fue desarrollado para aplicar y consolidar conceptos de **Programación Orientada a Objetos (POO)**, manejo de **APIs REST** y persistencia de datos mediante archivos **JSON**.

## 🚀 Características Principales

* **Tasas de Cambio en Tiempo Real:** Las conversiones se basan en datos obtenidos al instante de la **ExchangeRate-API** para asegurar la precisión.

* **Conversiones Soportadas:** El sistema ofrece un menú interactivo para conversiones directas entre:
    * Peso Mexicano (MXN) ↔ Dólar Estadounidense (USD)
    * Peso Mexicano (MXN) ↔ Peso Argentino (ARS)
    * Peso Mexicano (MXN) ↔ Quetzal Guatemalteco (GTQ)

* **Historial de Transacciones:** Cada conversión exitosa se serializa y se guarda en un archivo local llamado `historial_transacciones.json`.

## 🛠️ Conceptos de Java y Librerías

| **Concepto** | **Implementación** | 
| :--- | :--- | 
| **POO** | Uso de clases modulares (`ResultadoDeCambio`, `TasaApi`) con **encapsulamiento** (Getters/Setters) y constructores. | 
| **Conexión API** | Utilización del módulo nativo **`HttpClient`** para manejar las solicitudes HTTP (GET) y obtener la respuesta JSON. | 
| **Manejo JSON** | La librería **Gson** se utiliza para: (1) **Deserializar** la respuesta de la API y (2) **Serializar** los objetos de la transacción para el archivo de historial. | 
| **Estructura** | Separación de responsabilidades con paquetes: `modelos/`, `servicio/` y la clase principal `Principal`. | 

## ⚙️ Uso Básico

1. El usuario selecciona la opción de conversión en el menú.
2. Ingresa la cantidad a convertir.
3. El programa llama al servicio externo, calcula el resultado y lo muestra en consola.
4. La transacción es automáticamente guardada en el historial.

---

*Desarrollado por Brayan-Camargo.*
