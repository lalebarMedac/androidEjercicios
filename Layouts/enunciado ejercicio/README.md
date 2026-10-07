# 🧮 Práctica Guiada: Maquetación Avanzada de una Calculadora en Android

**Módulo:** Programación Multimedia y Dispositivos Móviles (PMDM)  
**Unidad:** Tema 4 - Programación en Android II: Layouts  
**Herramientas:** Android Studio (Editor Visual & XML)  

---

### 🎯 Objetivo de la Práctica
Diseñar la interfaz gráfica de una calculadora completa para dispositivos móviles combinando el anidamiento de **`LinearLayout`** y **`TableLayout`** [3, 4]. 

Al finalizar la práctica, los alumnos comprenderán el funcionamiento de los contenedores (`ViewGroup`), la gestión proporcional de espacios (`layout_weight`), el ajuste automático de columnas (`stretchColumns`), y la personalización de estilos mediante márgenes, tintes y esquinas redondeadas en componentes `Button` [5-7].

---

### 📐 Esquema de la Arquitectura de la Interfaz

Para maquetar la calculadora utilizaremos un **LinearLayout vertical raíz** que dividirá la pantalla en dos bloques principales [3]:
1. **Bloque Superior (Pantalla de Resultados):** Un `TextView` alineado a la derecha y abajo [8, 9].
2. **Bloque Inferior (Teclado 4x4):** Un `TableLayout` con 4 filas (`TableRow`) y 4 columnas de botones por fila [10, 11].

---

### 🛠️ Pasos de Realización en el Editor Visual (Modo Design)

#### **Paso 1: Configurar el Contenedor Principal (`LinearLayout`)**
1. Abre el archivo de diseño `activity_main.xml`.
2. En el panel **Component Tree** (abajo a la izquierda), selecciona el nodo raíz y asegúrate de que sea un **`LinearLayout`**.
3. En el panel **Attributes** (a la derecha), establece:
   * **`orientation`**: `vertical` [3]
   * **`layout_width`**: `match_parent` [7]
   * **`layout_height`**: `match_parent` [7]

#### **Paso 2: Añadir la Pantalla de Resultados (`TextView`)**
1. Arrastra un `TextView` desde **Palette > Text** dentro del `LinearLayout` [9].
2. En el panel **Attributes**:
   * **`id`**: `tvDisplay` [12]
   * **`layout_width`**: `match_parent` [7]
   * **`layout_height`**: `0dp` *(¡clave para activar la proporción por peso!)*
   * **`layout_weight`**: `1.5` [5]
   * **`gravity`**: despliega y marca **`end`** y **`bottom`** [8]
   * **`textSize`**: `48sp`
   * **`textColor`**: `#FFFFFF`
   * **`background`**: `#212121`

#### **Paso 3: Crear la Rejilla del Teclado (`TableLayout`)**
1. Arrastra un **`TableLayout`** desde **Palette > Layouts** justo debajo del `TextView` [3].
2. En el panel **Attributes** del `TableLayout`:
   * **`layout_width`**: `match_parent` [7]
   * **`layout_height`**: `0dp`
   * **`layout_weight`**: `4` [5]
   * **`stretchColumns`**: `*` *(obliga a las columnas a expandirse horizontalmente en toda la pantalla)* [6]

#### **Paso 4: Configurar las 4 Filas (`TableRow`)**
1. En el **Component Tree**, crea 4 filas `<TableRow>` dentro del `TableLayout` [10].
2. Selecciona las 4 filas a la vez (manteniendo pulsada la tecla **Ctrl** / **Cmd**) y en **Attributes** asigna [5]:
   * **`layout_width`**: `match_parent` [7]
   * **`layout_height`**: `0dp`
   * **`layout_weight`**: `1` (reparte el 25% de la altura del teclado a cada fila) [5]

#### **Paso 5: Añadir y Personalizar los Botones (`Button`)**
1. Inserta 4 botones dentro de cada una de las 4 filas (16 botones en total) [10].
2. Selecciona los 16 botones a la vez y asigna las siguientes dimensiones [7]:
   * **`layout_width`**: `match_parent`
   * **`layout_height`**: `match_parent`
   * **`layout_margin`**: `3dp` *(crea separación física entre las teclas)*
   * **`cornerRadius`**: `4dp` *(elimina el aspecto abombado/píldora y le da forma rectangular)*
3. Personaliza los colores de fondo usando **`backgroundTint`**:
   * **Números (0-9):** `#333333` (Gris oscuro)
   * **Operadores (`+`, `-`, `*`, `/`, `=`):** `#FF9800` (Naranja)
   * **Borrado (`C`):** `#D32F2F` (Rojo)

---

### 💻 Código XML Completo (`activity_main.xml`)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="8dp">

    <!-- 1. PANTALLA DE RESULTADOS -->
    <TextView
        android:id="@+id/tvDisplay"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1.5"
        android:background="#212121"
        android:gravity="end|bottom"
        android:padding="16dp"
        android:text="0"
        android:textColor="#FFFFFF"
        android:textSize="48sp"
        android:textStyle="bold" />

    <!-- 2. TECLADO DE LA CALCULADORA -->
    <TableLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="4"
        android:stretchColumns="*">

        <!-- Fila 1 -->
        <TableRow
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1">

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="7"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="8"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="9"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#FF9800"
                android:text="/"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />
        </TableRow>

        <!-- Fila 2 -->
        <TableRow
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1">

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="4"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="5"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="6"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#FF9800"
                android:text="*"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />
        </TableRow>

        <!-- Fila 3 -->
        <TableRow
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1">

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="1"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                Aquí tienes el enunciado completo de la práctica en formato **Markdown**, listo para copiar y entregar a tus alumnos:

```markdown
# 🧮 Práctica Guiada: Maquetación Avanzada de una Calculadora en Android

**Módulo:** Programación Multimedia y Dispositivos Móviles (PMDM)  
**Unidad:** Tema 4 - Programación en Android II: Layouts  
**Herramientas:** Android Studio (Editor Visual y XML)  

---

### 🎯 Objetivo de la Práctica
Diseñar la interfaz gráfica completa de una calculadora para dispositivos móviles combinando el anidamiento de **`LinearLayout`** y **`TableLayout`**. 

Al finalizar la práctica, comprenderás el funcionamiento de los contenedores (`ViewGroup`), la gestión proporcional de espacios (`layout_weight`), el ajuste automático de columnas (`stretchColumns`) y la personalización visual de componentes `Button` mediante márgenes, tintes de color y bordes suavizados.

---

### 📐 Arquitectura General del Diseño

Para maquetar la calculadora utilizaremos un **LinearLayout vertical raíz** que dividirá la pantalla en dos bloques principales:
1. **Pantalla de Resultados (Superior):** Un `TextView` alineado abajo a la derecha.
2. **Teclado 4x4 (Inferior):** Un `TableLayout` compuesto por 4 filas (`TableRow`) con 4 botones cada una.

---

### 🛠️ Pasos de Realización en el Editor Visual (Modo Design)

#### **Paso 1: Configurar el Contenedor Principal (`LinearLayout`)**
1. Abre el archivo de diseño `activity_main.xml`.
2. En el panel **Component Tree** (abajo a la izquierda), selecciona el nodo raíz y asegúrate de que sea un **`LinearLayout`**.
3. En el panel **Attributes** (a la derecha), establece:
   * **`orientation`**: `vertical`
   * **`layout_width`**: `match_parent`
   * **`layout_height`**: `match_parent`

#### **Paso 2: Añadir la Pantalla de Resultados (`TextView`)**
1. Arrastra un `TextView` desde **Palette > Text** dentro del `LinearLayout`.
2. En el panel **Attributes**:
   * **`id`**: `tvDisplay`
   * **`layout_width`**: `match_parent`
   * **`layout_height`**: `0dp` *(necesario para la proporción por peso)*
   * **`layout_weight`**: `1.5`
   * **`gravity`**: despliega y marca **`end`** y **`bottom`**
   * **`textSize`**: `48sp`
   * **`textColor`**: `#FFFFFF`
   * **`background`**: `#212121`

#### **Paso 3: Crear la Rejilla del Teclado (`TableLayout`)**
1. Arrastra un **`TableLayout`** desde **Palette > Layouts** justo debajo del `TextView`.
2. En el panel **Attributes** del `TableLayout`:
   * **`layout_width`**: `match_parent`
   * **`layout_height`**: `0dp`
   * **`layout_weight`**: `4`
   * **`stretchColumns`**: `*` *(obliga a todas las columnas a expandirse horizontalmente)*

#### **Paso 4: Configurar las 4 Filas (`TableRow`)**
1. En el **Component Tree**, añade 4 filas `<TableRow>` dentro del `TableLayout`.
2. Selecciona las 4 filas a la vez (manteniendo **Ctrl** / **Cmd**) y en **Attributes** asigna:
   * **`layout_width`**: `match_parent`
   * **`layout_height`**: `0dp`
   * **`layout_weight`**: `1` *(asigna el 25% de la altura del teclado a cada fila)*

#### **Paso 5: Añadir y Personalizar los Botones (`Button`)**
1. Inserta 4 botones dentro de cada una de las 4 filas (16 botones en total).
2. Selecciona los 16 botones a la vez y asigna las siguientes propiedades comunes:
   * **`layout_width`**: `match_parent`
   * **`layout_height`**: `match_parent`
   * **`layout_margin`**: `3dp` *(crea separación entre teclas)*
   * **`cornerRadius`**: `4dp` *(les da forma rectangular compacta)*
3. Personaliza los colores de fondo usando **`backgroundTint`**:
   * **Teclas numéricas (0-9):** `#333333` (Gris oscuro)
   * **Operadores (`+`, `-`, `*`, `/`, `=`):** `#FF9800` (Naranja)
   * **Borrado (`C`):** `#D32F2F` (Rojo)

---

### 💻 Código XML de Estructura (`activity_main.xml`)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="8dp">

    <!-- 1. PANTALLA DE RESULTADOS -->
    <TextView
        android:id="@+id/tvDisplay"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1.5"
        android:background="#212121"
        android:gravity="end|bottom"
        android:padding="16dp"
        android:text="0"
        android:textColor="#FFFFFF"
        android:textSize="48sp"
        android:textStyle="bold" />

    <!-- 2. REJILLA DE BOTONES -->
    <TableLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="4"
        android:stretchColumns="*">

        <!-- Ejemplo de Fila 1 (Repetir estructura para las filas 2, 3 y 4) -->
        <TableRow
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1">

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="7"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="8"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#333333"
                android:text="9"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />

            <Button
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:layout_margin="3dp"
                android:backgroundTint="#FF9800"
                android:text="/"
                android:textColor="#FFFFFF"
                android:textSize="22sp"
                app:cornerRadius="4dp" />
        </TableRow>

        <!-- Filas 2, 3 y 4: Misma estructura cambiando texto y colores según corresponda -->

    </TableLayout>

</LinearLayout>
