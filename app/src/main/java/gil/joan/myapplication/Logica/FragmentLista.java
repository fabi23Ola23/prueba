package gil.joan.myapplication.Logica;

/**
 * Created by user on 08/12/2017.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


import gil.joan.myapplication.R;

/**
 * ________________________Fragment de la la lista
 * */
public class FragmentLista extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener{


    private OnFragmentInteractionListener mListener;

    private View rootView;

    private Button botondeagregar;
    private Button bremover;
    private Button botondelsort;

    private List manejador;
    private ArrayList<Integer> listadeNumeros;

    private EditText rango;

    public FragmentLista() {
        // Required empty public constructor
    }

    public static FragmentLista newInstance() {

        FragmentLista fragment = new FragmentLista();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView =  inflater.inflate(R.layout.fragment_lista, container, false);

        manejador = new List();

        listadeNumeros = new ArrayList<Integer>();

        botondeagregar = rootView.findViewById(R.id.button1);
        botondelsort = rootView.findViewById(R.id.button4);
        bremover = rootView.findViewById(R.id.button3);


        botondeagregar.setOnClickListener(this);
        bremover.setOnClickListener(this);
        botondelsort.setOnClickListener(this);

        rango = rootView.findViewById(R.id.editText);

        ContenedorFragment fragment = new ContenedorFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.contenedor_lista, fragment.newInstance(listadeNumeros));
        ft.commit();
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        //_____________________________para agreagar numeros a la lista
        if(v.equals(botondeagregar)){

            listadeNumeros = manejador.agregarNuemerosALista(Integer.parseInt(rango.getText().toString()));

        }
        //_____________________________________________para remover los numeros de la lista
        if(v.equals(bremover)){
            listadeNumeros = manejador.blanquearLista();
        }
        //______________________________________para ordenar los numeros de la lista
        if(v.equals(botondelsort)){
            listadeNumeros = manejador.ordenarAcendentementeLista();
        }
        // ___________________________________________actualiza el fragment con la lista
        ContenedorFragment fragment = new ContenedorFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.contenedor_lista, fragment.newInstance(listadeNumeros));
        ft.commit();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
