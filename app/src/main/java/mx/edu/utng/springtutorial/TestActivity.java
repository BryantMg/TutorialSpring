package mx.edu.utng.springtutorial;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Bryant Moreno on 15/04/2016.
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
    }
}