package com.tesji.quizzdragonball;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AudioPlayer audioPlayer = AudioPlayer.getInstance(this);
        audioPlayer.start();

        /*// Audio de fondo
        mediaPlayer = MediaPlayer.create(this, R.raw.soundfondo);
        mediaPlayer.setLooping(true); //----> Repetir el audio
        mediaPlayer.start(); //----> Iniciar reproducción */

        // Ocultar la barra de notificaciones y la barra de navegación
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        //Cambiar de Pantalla o Main
        LinearLayout layout = findViewById(R.id.main); //---> Elegimos el main al que se le va a asignar un objeto
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);//---> Elegimos el main al que se le va a pasar
                startActivity(intent); //---> Evento OnClick nos manda directamente al segundo Main
            }
        });

        // Animacion de Texto
        TextView textView = findViewById(R.id.textView);
        Animation blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.parpadeo);//---> Carga la animación
        textView.startAnimation(blinkAnimation);//----> Aplica la animación

        // Imagen de charizar flotando
        ImageView goku = findViewById(R.id.imageView2);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.flotante);
        goku.startAnimation(animation);

    }
/*
    // Metodo de fondo de musica detener cuando salga de app
    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.stop(); //----> Detener reproducción
            mediaPlayer.release(); //----> Liberar recursos
        }
    }*/
}