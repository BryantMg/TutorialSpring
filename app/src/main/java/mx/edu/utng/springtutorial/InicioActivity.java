package mx.edu.utng.springtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.edu.utng.springtutorial.login.LoginInterno;

/**
 * Created by Bryant Moreno on 20/04/2016.
 */
public class InicioActivity extends Activity {
    Button  button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_layout);
        button = (Button)findViewById(R.id.btnIniciar);
    }

    public void irLogin(View view) {
        startActivity(new Intent(this,LoginInterno.class));
    }
}
