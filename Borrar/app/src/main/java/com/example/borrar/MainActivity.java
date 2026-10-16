package com.example.borrar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup radiogrupo;
    RadioButton radio1,radio2,radio3;

    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        radiogrupo = findViewById(R.id.rGrupo);
        radio1 = findViewById(R.id.radioButton);
        radio2 = findViewById(R.id.radioButton2);
        radio3 = findViewById(R.id.radioButton3);

        btnMain = findViewById(R.id.button);

        radio1.setText("Hola Mundo");
        System.out.println(radio1.getText());
        btnMain.setOnClickListener(v->{

            System.out.println(radio1.getId());
            System.out.println(radio2.getId());
            System.out.println(radio3.getId());

            System.out.println(radiogrupo.getCheckedRadioButtonId());


        });








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}