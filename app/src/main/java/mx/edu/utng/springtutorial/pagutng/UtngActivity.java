package mx.edu.utng.springtutorial.pagutng;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import mx.edu.utng.springtutorial.MapsActivity;
import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 03/05/2016.
 */
public class UtngActivity extends Activity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utng_layout);

        Button b = (Button)findViewById(R.id.btn_pop);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UtngActivity.this, Pop.class));
            }
        });

        Button soft = (Button)findViewById(R.id.btn_soft);
        soft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UtngActivity.this,Pop2.class));
            }
        });

        Button agro = (Button)findViewById(R.id.btn_agro);
        agro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UtngActivity.this, Pop3.class));
            }
        });


    }
    public void pagutng(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.utng.edu.mx/")));
    }

    public void vermapa(View view) {
        startActivity(new Intent(this,MapsActivity.class));
    }


    public void vergaleria(View view) {
        startActivity(new Intent(this,GalleryActivity.class));
    }

    public void videoPromo(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=1TRmJIzyzZI")));
    }
}
