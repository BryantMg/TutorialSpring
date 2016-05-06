package mx.edu.utng.springtutorial.configuracion;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.springtutorial.MenuActivity;
import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 01/03/2016.
 */
public class PreferenciasActivity extends Activity implements View.OnClickListener{
    private Button btnPreferencias;
    private Button btnListar;
    private TextView txvTitulo;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preferencias_layout);
        initComponents();
    }

    private void initComponents() {
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        btnPreferencias = (Button) findViewById(R.id.btn_preferencias);
        btnListar = (Button) findViewById(R.id.btn_listar);
        txvTitulo = (TextView)findViewById(R.id.txv_titulo);
        txvTitulo.setText(preferences.getString("nombre_aplicacion","Aplicacion"));
        btnPreferencias.setOnClickListener(this);
        btnListar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_preferencias){
            startActivity(new Intent(this,SeleccionPreferenciasActivity.class));
        }
        if(v.getId()==R.id.btn_listar){

            String mensaje =  preferences.getBoolean("mayor_18",false)==true?"SI":"NO";
            mensaje+="\nIdioma: "+preferences.getString("idioma","")+"\nCorreo electronico: "+preferences.getString("ip_bd","")
                    +"\nNombre de Usuario: "+preferences.getString("nombre_usuario","");
            Toast.makeText(this,"Notificaciones: " + mensaje,Toast.LENGTH_LONG).show();
        }
    }

    public void irMenu(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }
}
