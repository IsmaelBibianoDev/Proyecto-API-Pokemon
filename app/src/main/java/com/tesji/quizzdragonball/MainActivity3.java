package com.tesji.quizzdragonball;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.tesji.quizzdragonball.models.Catalogo;
import com.tesji.quizzdragonball.models.ModeloRetorno;

public class MainActivity3 extends AppCompatActivity {

    public Button btn_consulta;
    public Button btn_regresar;
    public TextInputEditText txt_Consulta;
    public String respuesta = "", imagen = "";
    public ModeloRetorno catalogo = new ModeloRetorno();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        // Ocultar la barra de notificaciones y la barra de navegación
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );

        btn_consulta = findViewById(R.id.btn_Consultar);
        txt_Consulta = findViewById(R.id.txtinput_personaje);
        btn_regresar = findViewById(R.id.btn_Salir);
        btn_consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_Consulta.getText().toString().trim().length()==0){
                    txt_Consulta.setError("Llenar el campo");
                    txt_Consulta.requestFocus();
                } else {
                    ConsultarApi rg = new ConsultarApi();
                    try {
                        rg.respuesta(txt_Consulta.getText().toString());
                        muestraToast("Procesando...");
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                catalogo = rg.modeloRetorno;
                                respuesta = "ID: " + catalogo.getId() + "\n" +
                                        "Nombre: " + catalogo.getName() + "\n" +
                                        "Altura: " + catalogo.getHeight() + "\n" +
                                        "Peso: " + catalogo.getWeight() + "\n";
                                imagen = catalogo.getFront_default();
                                if (!respuesta.equals("")) {
                                    Intent intent = new Intent(MainActivity3.this, Consulta_Activity.class);
                                    intent.putExtra("informacion", respuesta);
                                    intent.putExtra("imagen", imagen);
                                    startActivity(intent);
                                }
                            }
                        }, 5000);
                    } catch (Exception ex) {
                        muestraToast("Error" + ex);
                    }
                }
            }
        });

        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    public void muestraToast(String msj){
        Toast.makeText(this, "" + msj, Toast.LENGTH_SHORT).show();
    }

}