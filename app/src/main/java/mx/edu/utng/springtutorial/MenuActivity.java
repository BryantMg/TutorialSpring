package mx.edu.utng.springtutorial;

import android.app.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import mx.edu.utng.springtutorial.configuracion.PreferenciasActivity;
import mx.edu.utng.springtutorial.correo.EnviarCorreoActivity;
import mx.edu.utng.springtutorial.pagutng.UtngActivity;
import mx.edu.utng.springtutorial.rspgame.ActivityRsp;
import mx.edu.utng.springtutorial.sound.SoundActivity;
import mx.edu.utng.springtutorial.utileries.ActivityUtilerias;


/**
 * Created by Bryant Moreno on 29/03/2016.
 */
public class MenuActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);



    }




    public void temario(View view){
        startActivity(new Intent(this, CapitulosActivity.class));
    }

    public void acercaDe(View view) {
        startActivity(new Intent(this,AboutActivity.class));
    }

    public void configuracion(View view) {
        startActivity(new Intent(this, PreferenciasActivity.class));
    }

    public void videos(View view) {
        startActivity(new Intent(this,ActividadVideo.class));
    }

    public void avance(View view) {
        startActivity(new Intent(this,Grafica.class));
    }


    public void correo(View view) {
        startActivity(new Intent(this, EnviarCorreoActivity.class));
    }

    public void juego(View view) {
        startActivity(new Intent(this, ActivityRsp.class));
    }


    public void utilerias(View view) {
        startActivity(new Intent(this, ActivityUtilerias.class));
    }


    public void videoutng(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=1TRmJIzyzZI")));
    }

    public void utngpag(View view) {
        startActivity(new Intent(this, UtngActivity.class));
    }

    public void audio(View view) {
        startActivity(new Intent(this, SoundActivity.class));
    }


}
