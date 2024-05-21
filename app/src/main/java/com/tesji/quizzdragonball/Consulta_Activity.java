package com.tesji.quizzdragonball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class Consulta_Activity extends AppCompatActivity {

    TextView txtInfo;
    ImageView img1;
    Button btnRegresar;
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consulta);

        txtInfo = findViewById(R.id.text_info);
        img1 = findViewById(R.id.imageView);
        btnRegresar = findViewById(R.id.btn_regresar);

        Bundle extras = getIntent().getExtras();
        String informacion = extras.getString("informacion");
        String imagen = extras.getString("imagen");
        txtInfo.setText(informacion);
        Picasso.get().load(imagen).error(R.mipmap.ic_launcher).into(img1);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Consulta_Activity.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        // Ocultar la barra de notificaciones y la barra de navegación
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }

    public void muestraToast(String msj){
        Toast.makeText(this, "" + msj, Toast.LENGTH_SHORT).show();
    }
}