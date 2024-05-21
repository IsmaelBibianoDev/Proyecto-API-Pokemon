package com.tesji.quizzdragonball;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textView;
    private String text;
    private int index = 0;
    private long delay = 30; // Milisegundos de retraso entre cada letra
    private Button btIniciar;

    private Button btSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textView3);
        text = getString(R.string.txt_frase);
        // Iniciar el efecto de texto letra por letra
        animateText();

        // Ocultar la barra de notificaciones y la barra de navegación
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        btIniciar = findViewById(R.id.btnStart);
        btSalir = findViewById(R.id.btnExit);

        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);//---> Elegimos el main al que se le va a pasar
                startActivity(intent); //---> Evento OnClick nos manda directamente al segundo Main
            }
        });

        btSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); //---> Cierra todas las actividades
            }
        });



    }

    // Metodo para animacion de texto
    private void animateText() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (index < text.length()) {
                    textView.setText(textView.getText().toString() + text.charAt(index));
                    index++;
                    handler.postDelayed(this, delay);
                }
            }
        }, delay);
    }


}