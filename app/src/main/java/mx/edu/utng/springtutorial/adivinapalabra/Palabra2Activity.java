package mx.edu.utng.springtutorial.adivinapalabra;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 08/05/2016.
 */
public class Palabra2Activity extends Activity {

    LinearLayout ly_contenedor1;
    private final String palabra1 = "spring";
    private EditText controles1[];
    private Button btnVerificar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palabra2_layout);
        ly_contenedor1 = (LinearLayout)findViewById(R.id.lny_pal2);

        controles1 = new EditText[palabra1.length()];

        for(int fila=0 ;fila < controles1.length;fila++){
            controles1[fila] = new EditText(getApplicationContext());
            controles1[fila].setTextColor(Color.BLACK);
            controles1[fila].setHint(fila+1+"");
            ly_contenedor1.addView(controles1[fila]);
        }


        btnVerificar1 = (Button) findViewById(R.id.btnVerif);

        btnVerificar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(notBlank()){
                    if(getAllText().equals(palabra1)){
                        Toast.makeText(getApplicationContext(),"¡ES CORRECTO!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Palabra3Activity.class));
                    }else {
                        Toast.makeText(getApplicationContext(),"¡ES INCORRECTO!",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(),"Llena todos los campos",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private String getAllText(){

        String respuesta ="";
        for(int i=0;i<controles1.length;i++){
            respuesta = respuesta + controles1[i].getText().toString();
        }
        return respuesta;
    }


    private boolean notBlank(){
        boolean valor = true;

        for(int i=0;i<controles1.length;i++){
            if(controles1[i].getText().toString().isEmpty()){
                valor=false;
                break;
            }
        }
        return valor;
    }
}
