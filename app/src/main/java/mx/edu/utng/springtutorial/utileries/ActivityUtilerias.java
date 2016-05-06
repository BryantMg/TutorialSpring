package mx.edu.utng.springtutorial.utileries;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 02/05/2016.
 */
public class ActivityUtilerias extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utilerias_layout);
    }

    public void calculador(View view) {
        startActivity(new Intent(this, ActivityCalculator.class));
    }

    public void cronometro(View view) {
        startActivity(new Intent(this,ActivityCronometro.class));
    }
}
