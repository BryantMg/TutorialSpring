package mx.edu.utng.springtutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import mx.edu.utng.springtutorial.grafica.GraficaHelperDos;
import mx.edu.utng.springtutorial.grafica.GraficaTopic;
import mx.edu.utng.springtutorial.grafica.GraficoActivityDos;

/**
 * Created by Bryant Moreno on 25/03/2016.
 */
public class ResultadoActivity extends Activity {

    GraficaHelperDos db= new GraficaHelperDos(this);
    GraficaTopic g= new GraficaTopic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
        TextView t=(TextView)findViewById(R.id.textResult);
//get score
        Bundle b = getIntent().getExtras();////////-------------------------Resive la info de la base de datos
        int score= b.getInt("score");
//display score
        bar.setRating(score);
        switch (score) {
            case 1:
                t.setText("Podrias hacerlo mejor");
                break;
            case 2: t.setText("Lo siento, no has pasado satisfactoriamente el cuestionario");
                break;
            case 3:
                t.setText("Casi pero no es suficiente, ¿porque no estudias mas?");
                break;
            case 4:t.setText("Tal vez deberias de probar hacer de nuevo el examen");
                break;
            case 5:
                t.setText("Eres asombroso has pasado correctamente todo el cuestionario");
                g.setNombre("Capitulos del 1 al 5");
                g.setSigla("Spring");
                g.setVotos(score);
                db.insertResult(g);
                break;
            default:

        }




    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }

    public void playagain(View o) {
        Intent intent = new Intent(this, CapitulosActivity.class);
        startActivity(intent);
    }

    public void irGrafica(View view) {
        Intent intent = new Intent(this, GraficoActivityDos.class);
        startActivity(intent);

    }
    protected void onPause(){
        super.onPause();
        finish(); //termina la actividad
    }
}
