package mx.edu.utng.springtutorial.adivinapalabra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.springtutorial.MenuActivity;
import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 09/05/2016.
 */
public class FinActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endgame_layout);
    }


    public void irInicio2(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }

    public void juegos(View view) {
    }
}
