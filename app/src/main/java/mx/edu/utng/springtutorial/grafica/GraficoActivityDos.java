package mx.edu.utng.springtutorial.grafica;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;

import mx.edu.utng.springtutorial.R;
import mx.edu.utng.springtutorial.correo.EnviarCorreoActivity;
import mx.edu.utng.springtutorial.login.LoginInterno;
import mx.edu.utng.springtutorial.login.PreguntaActivity;

/**
 * Created by Bryant Moreno on 30/03/2016.
 */
public class GraficoActivityDos extends Activity implements View.OnClickListener{

    private GraficaHelperDos sqlite;
    private PieChart pieChart;
    private TableLayout table_layout;
    private BarChart barChart;
    private PreguntaActivity puntos;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grafica);
        pieChart = (PieChart) findViewById(R.id.pieChart);
        barChart = (BarChart)findViewById(R.id.barChart);

        table_layout = (TableLayout) findViewById(R.id.tableLayout1);
        sqlite = new GraficaHelperDos(this);
        setDataChart();//grafico
        createDataTable();//tabla
    }


    public void setDataChart() {
        //obtiene registro de la base de datos
        sqlite.openConnection();
        ArrayList<GraficaTopic> candidatos = sqlite.getCandidatos();
        sqlite.closeConnection();


        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();


        sqlite.openConnection();
        float total_votos = sqlite.getTotalVotos();
        sqlite.closeConnection();




        for (int index = 0; index < candidatos.size(); index++) {
            float votos = (candidatos.get(index).getVotos());
            entries.add(new BarEntry(votos,index));
            labels.add(candidatos.get(index).getSigla());
        }


        BarDataSet dataset = new BarDataSet(entries, "Calificación");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(labels, dataset);
        barChart.setData(data);
        barChart.setDescription("Capítulos");


    }

    //Para crear la tabla de votación:

    private void createDataTable() {
        sqlite.openConnection();
        ArrayList<GraficaTopic> candidatos = sqlite.getCandidatos();
        sqlite.closeConnection();

        //
        TableRow.LayoutParams tableRowParams = new TableRow.LayoutParams();
        tableRowParams.setMargins(5, 3, 5, 3);
        tableRowParams.weight = 1;
        //encabezado
        TableRow rowHead = new TableRow(this);
        rowHead.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        //col 1
        TextView col1 = new TextView(this);
        col1.setBackgroundResource(R.drawable.tv_bg);
        col1.setGravity(Gravity.CENTER);
        col1.setTypeface(null, Typeface.BOLD);
        col1.setTextSize(12);
        col1.setPadding(6, 10, 6, 10);
        col1.setText("SIGLA");
        //col 2
        TextView col2 = new TextView(this);
        col2.setBackgroundResource(R.drawable.tv_bg);
        col2.setGravity(Gravity.CENTER);
        col2.setTypeface(null, Typeface.BOLD);
        col2.setTextSize(12);
        col2.setPadding(6, 10, 6, 10);
        col2.setText("TEMA");
        //col 3
        TextView col3 = new TextView(this);
        col3.setBackgroundResource(R.drawable.tv_bg);
        col3.setGravity(Gravity.CENTER);
        col3.setTypeface(null, Typeface.BOLD);
        col3.setTextSize(12);
        col3.setPadding(6, 10, 6, 10);
        col3.setText("CALIFICACION");
        //añade columnas
        rowHead.addView(col1, tableRowParams);
        rowHead.addView(col2, tableRowParams);
        rowHead.addView(col3, tableRowParams);
        //añade fila
        table_layout.addView(rowHead);
        for (GraficaTopic c : candidatos) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            //col 1
            TextView tv1 = new TextView(this);
            tv1.setBackgroundResource(R.drawable.tv_bg);
            tv1.setGravity(Gravity.CENTER);
            tv1.setTypeface(null, Typeface.BOLD);
            tv1.setTextSize(12);
            tv1.setPadding(6, 10, 6, 10);
            tv1.setText(c.getSigla());
            //col 2
            TextView tv2 = new TextView(this);
            tv2.setBackgroundResource(R.drawable.tv_bg);
            tv2.setGravity(Gravity.CENTER);
            tv2.setTextSize(12);
            tv2.setPadding(6, 10, 6, 10);
            tv2.setText(c.getNombre());
            //col 3
            TextView tv3 = new TextView(this);
            tv3.setBackgroundResource(R.drawable.tv_bg);
            tv3.setGravity(Gravity.CENTER);
            tv3.setTextSize(12);
            tv3.setPadding(6, 10, 6, 10);
            tv3.setText(String.valueOf(c.getVotos()));
            //añade columnas
            row.addView(tv1, tableRowParams);
            row.addView(tv2, tableRowParams);
            row.addView(tv3, tableRowParams);
            //añade fila
            table_layout.addView(row);
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(GraficoActivityDos.this, LoginInterno.class));
    }
    public void enviarCorreo(View view) {
        startActivity(new Intent(this, EnviarCorreoActivity.class));
    }
}
