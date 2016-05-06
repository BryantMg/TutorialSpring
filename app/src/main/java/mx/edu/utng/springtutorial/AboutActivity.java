package mx.edu.utng.springtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.springtutorial.correo.EnviarCorreoActivity;

/**
 * Created by Bryant Moreno on 20/04/2016.
 */
public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca_layout);
    }

    public void irMenu(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    public void maps(View view) {
        startActivity(new Intent(this,MapsActivity.class));
    }

    public void correo(View view) {
        startActivity(new Intent(this, EnviarCorreoActivity.class));
    }
}
