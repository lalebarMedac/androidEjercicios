# 🔘 Guía de Uso: RadioGroup y RadioButton en Android

### 1. Concepto y Funcionamiento
* **`RadioButton`:** Es un componente gráfico de selección. A diferencia de los `CheckBox` (que permiten selección múltiple), los `RadioButton` se utilizan para elegir **una única opción** entre varias alternativas exclusivas.
* **`RadioGroup`:** Es el contenedor encargado de agrupar varios `RadioButton`. Su función principal es garantizar que únicamente un `RadioButton` esté activo dentro del grupo a la vez. Los grupos se pueden posicionar tanto en **vertical** como en **horizontal**.

---

### 2. Definición en el Layout XML (`activity_main.xml`)

Los componentes `RadioButton` deben incluirse dentro de un contenedor `<RadioGroup>`:

```xml
<RadioGroup
    android:id="@+id/rgOpciones"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical">

    <RadioButton
        android:id="@+id/rbOp1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/opcion1" />

    <RadioButton
        android:id="@+id/rbOp2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/opcion2" />

</RadioGroup>
```

---

### 3. Manejo desde Código Java (`MainActivity.java`)

#### **A. Consultar cuál está seleccionado (por ejemplo, al pulsar un botón):**
Para comprobar qué opción ha marcado el usuario en un momento concreto:

```java
RadioGroup rgOpciones = findViewById(R.id.rgOpciones);

// Obtiene el ID del RadioButton marcado (-1 si no hay ninguno seleccionado)
int idSeleccionado = rgOpciones.getCheckedRadioButtonId();

if (idSeleccionado == -1) {
    // Ninguna opción marcada
} else if (idSeleccionado == R.id.rbOp1) {
    // El usuario seleccionó la Opción 1
} else if (idSeleccionado == R.id.rbOp2) {
    // El usuario seleccionó la Opción 2
}
```

#### **B. Escuchar cambios de selección en tiempo real:**
Para ejecutar una acción en el instante en que el usuario cambia de opción, se utiliza el método `setOnCheckedChangeListener()` con la interfaz `RadioGroup.OnCheckedChangeListener` y el método `onCheckedChanged(RadioGroup group, int checkedId)`:

```java
rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // 'group' es el id del RadioGroup modificado
        // 'checkedId' es el id del RadioButton activado
        switch (checkedId) {
            case R.id.rbOp1:
                // Acción al seleccionar la opción 1
                break;
            case R.id.rbOp2:
                // Acción al seleccionar la opción 2
                break;
        }
    }
});
```

#### **C. Métodos útiles:**
* **Limpiar selecciones:** `rgOpciones.clearCheck();` (desmarca cualquier opción activa).
* **Consultar estado individual:** `rbOp1.isChecked();` (devuelve `true` si está marcado o `false` si no).
* **Modificar selección por código:** `rbOp1.setChecked(true);` o `rbOp1.setChecked(false);`.
