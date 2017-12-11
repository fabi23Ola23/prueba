package gil.joan.myapplication.Actividad;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import gil.joan.myapplication.Logica.FragmentInicio;
import gil.joan.myapplication.R;

/**
 * Created by user on 08/12/2017.
 */

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //iniciamos por defecto el fragment de inicio
        FragmentInicio fragment = new FragmentInicio();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.container_fragment, fragment.newInstance());
        ft.commit();

    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            Fragment currentFrag = getFragmentManager().findFragmentById(R.id.container_fragment);
            if (currentFrag != null) {
                transaction.remove(currentFrag);
            }
            transaction.commit();
        } else {
            super.onBackPressed();
        }
    }
}
