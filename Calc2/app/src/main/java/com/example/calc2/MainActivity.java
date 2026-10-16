package com.example.calc2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int primerNumero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView tvResultado = findViewById(R.id.textView);
        Button btnUno = findViewById(R.id.button);
        Button btnSuma = findViewById(R.id.button16);
        Button btnResultado = findViewById(R.id.button15);


        btnUno.setOnClickListener( v -> {
            tvResultado.setText(tvResultado.getText()+"1");});

        btnSuma.setOnClickListener( v -> {
            primerNumero = Integer.parseInt(tvResultado.getText().toString());
            tvResultado.setText("");});

        btnResultado.setOnClickListener(v -> {
            int segundoNumero = Integer.parseInt(
                    tvResultado.getText().toString()
            );

            int resultado = primerNumero + segundoNumero;

            tvResultado.setText(String.valueOf(resultado));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



}