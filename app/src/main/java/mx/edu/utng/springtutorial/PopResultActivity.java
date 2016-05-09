package mx.edu.utng.springtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.edu.utng.springtutorial.grafica.GraficaHelperDos;
import mx.edu.utng.springtutorial.grafica.GraficaTopic;

/**
 * Created by Bryant Moreno on 09/05/2016.
 */
public class PopResultActivity extends Activity {


    GraficaHelperDos db= new GraficaHelperDos(this);
    GraficaTopic g= new GraficaTopic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_result_layout);

        TextView t=(TextView)findViewById(R.id.txv_mensaje);

        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar3);
//get score
        Bundle b = getIntent().getExtras();////////-------------------------Resive la info de la base de datos
        int score= b.getInt("score");
//display score
        bar.setRating(score);
        switch (score) {
            case 1:
                t.setText("1 de 5");
                break;
            case 2: t.setText("2 de 5");
                break;
            case 3:
                t.setText("3 de 5");
                break;
            case 4:t.setText("4 de 5");
                break;
            case 5:
                t.setText("5 de 5");
                g.setNombre("Capitulos del 1 al 5");
                g.setSigla("Spring");
                g.setVotos(score);
                db.insertResult(g);
                break;
            default:

        }

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int heigth = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(heigth*.6));




    }
}
