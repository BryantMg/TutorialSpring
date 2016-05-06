package mx.edu.utng.springtutorial.sound;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import mx.edu.utng.springtutorial.CapitulosActivity;
import mx.edu.utng.springtutorial.MenuActivity;
import mx.edu.utng.springtutorial.R;

public class SoundActivity extends Activity {

    private MediaPlayer mp;
    private Button btnSonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_layout);
        btnSonido = (Button) findViewById(R.id.btnSonido);
        btnSonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(SoundActivity.this, R.raw.summermad);
                mp.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.release();
    }

    public void curso(View view) {
        startActivity(new Intent(this, CapitulosActivity.class));
    }

    public void irInicio(View view) {
        startActivity(new Intent(this, MenuActivity.class));
    }
}
