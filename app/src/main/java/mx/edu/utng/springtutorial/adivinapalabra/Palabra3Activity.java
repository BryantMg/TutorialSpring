package mx.edu.utng.springtutorial.adivinapalabra;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 08/05/2016.
 */
public class Palabra3Activity extends Activity {

    LinearLayout ly_contenedor;
    private final String palabra = "ivate";
    private EditText controles[];
    private Button btnVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palabra3_layout);
        ly_contenedor = (LinearLayout)findViewById(R.id.lny_pal3);

        controles = new EditText[palabra.length()];

        for(int fila=0 ;fila < controles.length;fila++){
            controles[fila] = new EditText(getApplicationContext());
            controles[fila].setTextColor(Color.BLACK);
            controles[fila].setHint(fila+1+"");
            ly_contenedor.addView(controles[fila]);
        }


        btnVerificar = (Button) findViewById(R.id.btnVerif);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(notBlank()){
                    if(getAllText().equals(palabra)){
                        Toast.makeText(getApplicationContext(),"¡ES CORRECTO!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), Palabra4Activity.class));
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
        for(int i=0;i<controles.length;i++){
            respuesta = respuesta + controles[i].getText().toString();
        }
        return respuesta;
    }


    private boolean notBlank(){
        boolean valor = true;

        for(int i=0;i<controles.length;i++){
            if(controles[i].getText().toString().isEmpty()){
                valor=false;
                break;
            }
        }
        return valor;
    }
}
