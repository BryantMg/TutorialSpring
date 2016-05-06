package mx.edu.utng.springtutorial.pagutng;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ViewFlipper;

import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 04/05/2016.
 */
public class GalleryActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);

        viewFlipper = (ViewFlipper)this.findViewById(R.id.viewFlipper);
        viewFlipper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(3000);
    }
}
