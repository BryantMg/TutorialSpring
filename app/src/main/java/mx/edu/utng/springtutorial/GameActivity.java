package mx.edu.utng.springtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.springtutorial.adivinapalabra.Palabra1Activity;
import mx.edu.utng.springtutorial.rspgame.ActivityRsp;

/**
 * Created by Bryant Moreno on 09/05/2016.
 */
public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_layout);
    }


    public void rockpaper(View view) {
        startActivity(new Intent(this, ActivityRsp.class));
    }

    public void adivina(View view) {
        startActivity(new Intent(this, Palabra1Activity.class));
    }
}
