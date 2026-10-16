package com.example.a03quiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 1. Declaración de componentes gráficos
    private TextView tvPregunta, tvPuntuacion;
    private RadioGroup rgOpciones;
    private RadioButton rbOp1, rbOp2, rbOp3;
    private Button btnSiguiente;

    private String[] preguntas = {
            "¿Cuál es el lenguaje nativo tradicional de Android?",
            "¿En qué carpeta se guardan las cadenas de texto?",
            "¿Qué contenedor permite seleccionar solo un RadioButton?"
    };

    private String[][] opciones = {
            {"Java", "Swift", "Python"},
            {"res/drawable", "res/values", "res/layout"},
            {"LinearLayout", "RadioGroup", "TableLayout"}
    };

    private int[] respuestasCorrectas = {0, 1, 1}; // Índices de la opción correcta
    private int posicionActual = 0;
    private int puntos = 0;

    private int numPregunta=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvPregunta = findViewById(R.id.tvPregunta);
        tvPuntuacion = findViewById(R.id.tvPuntuacion);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        rgOpciones = findViewById(R.id.rgOpciones);
        rbOp1 = findViewById(R.id.rbOp1);
        rbOp2 = findViewById(R.id.rbOp2);
        rbOp3 = findViewById(R.id.rbOp3);

        tvPregunta.setText(preguntas[numPregunta]);
        rbOp1.setText(opciones[numPregunta][0]);
        rbOp2.setText(opciones[numPregunta][1]);
        rbOp3.setText(opciones[numPregunta][2]);


        btnSiguiente.setOnClickListener(
                v->{

                    int idSeleccionado = rgOpciones.getCheckedRadioButtonId();

                    if (idSeleccionado == -1) {
                        Toast.makeText(this, "Por favor, selecciona una respuesta", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int indiceSeleccionado = -1;
                    if (idSeleccionado == R.id.rbOp1) indiceSeleccionado = 0;
                    else if (idSeleccionado == R.id.rbOp2) indiceSeleccionado = 1;
                    else if (idSeleccionado == R.id.rbOp3) indiceSeleccionado = 2;

                    if (indiceSeleccionado == respuestasCorrectas[numPregunta]) {
                        puntos = puntos+10;
                        Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
                    }

                    tvPuntuacion.setText("Puntuación: " + String.valueOf(puntos));
                    numPregunta++;

                    tvPregunta.setText(preguntas[numPregunta]);
                    rbOp1.setText(opciones[numPregunta][0]);
                    rbOp2.setText(opciones[numPregunta][1]);
                    rbOp3.setText(opciones[numPregunta][2]);

                    rgOpciones.clearCheck();

                });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}