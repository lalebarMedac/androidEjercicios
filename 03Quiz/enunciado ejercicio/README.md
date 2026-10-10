# 📱 Práctica: Juego de Preguntas y Respuestas (Quiz App)

**Módulo:** Programación Multimedia y Dispositivos Móviles (PMDM)  
**Unidad:** Tema 3, 4 y 5 (Recursos, Layouts y Componentes Interactivos)  
**Modalidad:** Individual  

---

### 🎯 Objetivo de la Práctica
Desarrollar la interfaz gráfica y la lógica interna de una aplicación móvil en Android Studio que implemente un **juego de preguntas y respuestas tipo Quiz** ejecutado en una **única pantalla**, actualizando dinámicamente los componentes visuales según las acciones del usuario.

---

### 📋 Requisitos de la Aplicación y Reglas del Ejercicio

#### **1. Estructura de la Interfaz Gráfica (`activity_main.xml`)**
* La interfaz debe estar maquetada en una sola actividad utilizando un contenedor raíz adecuado (`LinearLayout` o `ConstraintLayout`).
* Debe incluir de forma organizada y centrada los siguientes elementos visuales:
  1. **Enunciado de la Pregunta:** Un `TextView` destacado en la parte superior.
  2. **Opciones de Respuesta:** Un contenedor `RadioGroup` que agrupe exactamente **3 o 4 componentes `RadioButton`**.
  3. **Botón de Acción:** Un `Button` para validar la respuesta y avanzar.
  4. **Marcador de Puntuación:** Un `TextView` en la parte inferior para mostrar el progreso en tiempo real.

#### **2. Reglas de Recursos y Estilos (Buenas Prácticas)**
* **Cero textos "hardcodeados":** Todos los textos estáticos de la aplicación (título, botones, mensajes predeterminados) deben estar declarados obligatoriamente en el archivo de recursos `res/values/strings.xml`.
* **Unidades de medida correctas:** Los tamaños de texto deben expresarse en **`sp`** y los espacios/márgenes entre componentes en **`dp`**.
* **Personalización visual:** Se deben definir colores propios en `colors.xml` para distinguir la pregunta, las opciones y el botón.

#### **3. Requisitos Funcionales y Lógica del Juego (`MainActivity`)**
* **Selección exclusiva:** El usuario solo podrá marcar una única respuesta por pregunta mediante el `RadioGroup`.
* **Validación de selección obligatoria:** Si el usuario pulsa el botón de comprobar sin haber marcado ninguna opción, la app **no debe avanzar** y mostrará una notificación rápida (**`Toast`**) advirtiendo que debe seleccionar una respuesta.
* **Evaluación y Puntuación:**
  * Al pulsar el botón, la app comprobará si la opción seleccionada es la correcta.
  * Se mostrará un `Toast` informando si ha acertado o fallado (*"¡Correcto!"* / *"Incorrecto"*).
  * Si la respuesta es correcta, se sumará un punto al marcador de pantalla.
* **Transición dinámica:**
  * Al avanzar a la siguiente pregunta, se actualizarán los textos del enunciado y de los `RadioButton` por código.
  * El `RadioGroup` debe **desmarcar automáticamente** la opción elegida en la pregunta anterior.
* **Final de la Partida:**
  * El Quiz constará de un mínimo de **3 preguntas**.
  * Al responder la última pregunta, la app mostrará un mensaje indicando que el juego ha terminado junto con la puntuación final obtenida, y ocultará o desactivará las opciones de respuesta y el botón para evitar más pulsaciones.

