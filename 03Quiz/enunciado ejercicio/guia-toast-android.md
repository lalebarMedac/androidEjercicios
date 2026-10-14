# 💬 Guía de Uso: Mensajes Flotantes con Toast en Android

### 1. ¿Qué es un Toast?
Un **`Toast`** es un mecanismo de notificación rápida en Android. Muestra un mensaje flotante breve en pantalla durante unos segundos para informar al usuario sobre un evento y luego desaparece automáticamente sin detener el flujo de la aplicación.

---

### 2. Sintaxis General en Java

Para mostrar un `Toast` se invoca el método estático `makeText()` de la clase `Toast` y se encadena con el método `.show()`:

```java
Toast.makeText(contexto, "Mensaje a mostrar", duracion).show();
```

---

### 3. Parámetros del Método `makeText()`

1. **`Context` (Contexto):** Referencia a la actividad actual. Normalmente se indica con `this` (si estamos en la actividad principal) o `getApplicationContext()`.
2. **`Mensaje`:** Texto de la notificación (puede ser una cadena directa entre comillas o una referencia a `strings.xml`).
3. **`Duración`:** Determina cuánto tiempo estará visible el aviso:
   * **`Toast.LENGTH_SHORT`:** Muestra la notificación durante un periodo breve (aprox. 2 segundos).
   * **`Toast.LENGTH_LONG`:** Muestra la notificación durante un periodo más extendido (aprox. 3.5 segundos).

---

### 4. Ejemplos Prácticos de Código

#### **A. Mensaje directo simple:**
```java
Toast.makeText(this, "¡Respuesta correcta!", Toast.LENGTH_SHORT).show();
```

#### **B. Validación de respuesta no seleccionada:**
```java
if (rgOpciones.getCheckedRadioButtonId() == -1) {
    Toast.makeText(this, "Por favor, selecciona una opción", Toast.LENGTH_LONG).show();
}
```

#### **C. Mensaje desde recursos de texto (`strings.xml`):**
```java
Toast.makeText(this, getString(R.string.mensaje_exito), Toast.LENGTH_SHORT).show();
```

---

⚠️ **Recordatorio importante:** Si no añades `.show()` al final de la instrucción, el objeto `Toast` se creará internamente pero nunca llegará a visualizarse en la pantalla.
