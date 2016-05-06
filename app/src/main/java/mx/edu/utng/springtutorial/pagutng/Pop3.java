package mx.edu.utng.springtutorial.pagutng;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 04/05/2016.
 */
public class Pop3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_agro_layout);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int heigth = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(heigth*.6));

    }
}
