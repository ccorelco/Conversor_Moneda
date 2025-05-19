# Conversor de Moneda

Este proyecto es una aplicación de consola escrita en Java que permite a los usuarios **convertir entre diferentes monedas internacionales** en tiempo real, utilizando tasas de cambio actualizadas a través de una API externa.

## 🚀 Funcionalidad

La aplicación guía al usuario paso a paso para:

1. Seleccionar una **moneda de origen**.
2. Seleccionar una **moneda de destino**.
3. Ingresar un **monto a convertir**.
4. Consultar el tipo de cambio actual y **mostrar el resultado convertido**.

El usuario puede repetir este proceso cuantas veces quiera, y tiene la opción de salir mediante el menú.

## 📌 Características

- Interfaz de texto amigable.
- Validación de entradas (opciones y números).
- Conversión en tiempo real usando tasas actualizadas.
- Manejo de errores de conexión o monedas no válidas.

## 💱 Monedas compatibles

- USD – Dólar USA  
- EUR – Euro  
- GBP – Libra esterlina  
- CLP – Peso chileno  
- BRL – Real brasileño  
- MXN – Peso mexicano  
- JPY – Yen japonés  
- CAD – Dólar canadiense  
- AUD – Dólar australiano  

## 🛠️ Requisitos

- Java 11 o superior
- Biblioteca externa: [`gson`](https://github.com/google/gson) para parseo JSON  
  Puedes descargar el `.jar` desde [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson) y agregarlo manualmente al proyecto.

## 🧾 Estructura del proyecto

- `Principal.java`: Clase principal que contiene la lógica de la interfaz y flujo del programa.
- `ConsultaTipoDeMoneda.java`: Encargada de realizar la consulta a la API para obtener el tipo de cambio.
- `TipoCambio.java`: Representa el resultado de la conversión.
- `TipoDeMonedaNoEncontradaException.java`: Excepción personalizada para monedas inválidas o no encontradas.

## ✅ Ejemplo de uso
-######- Conversor de Moneda -######-
Seleccione la moneda de origen:
1. USD (Dólar USA)
2. EUR (Euro)
3. GBP (Libra esterlina)
4. CLP (Peso chileno)
5. BRL (Real brasileño)
6. MXN (Peso mexicano)
7. JPY (Yen japonés)
8. CAD (Dólar canadiense)
9. AUD (Dólar australiano)
10. Salir
    
-######- Conversor de Moneda -######-
Seleccione la moneda de origen:
USD (Dólar USA)
...
Ingrese una opción: 1
Ingrese moneda de destino elejida:

EUR (Euro)
...
Ingrese una opción: 2
Ingrese el monto a convertir: 100
100.00 USD equivalen a 92.15 EUR

Ingrese una opción: 10
¡Gracias por preferirnos!
