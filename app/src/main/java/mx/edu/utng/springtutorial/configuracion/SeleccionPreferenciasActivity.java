package mx.edu.utng.springtutorial.configuracion;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import mx.edu.utng.springtutorial.R;

/**
 * Created by Bryant Moreno on 01/03/2016.
 */
public class SeleccionPreferenciasActivity extends PreferenceActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones_preferencia);
        Preference btnRegresar = (Preference)findPreference(getString(R.string.btn_regresar));

        btnRegresar.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(SeleccionPreferenciasActivity.this,PreferenciasActivity.class));
                finish();
                return false;
            }
        });
    }
}
