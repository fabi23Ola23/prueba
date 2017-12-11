package gil.joan.myapplication.Logica;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gil.joan.myapplication.R;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * ____________________________Primer Fragment que se visualiza al iniciar la aplicacion
 * */
public class FragmentInicio extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;

    private View rootView;

    private Button request_api;
    private Button boton_lista;

    public static TextView direccion;
    public static TextView dir_alreves;

    public FragmentInicio() {
        // Required empty public constructor
    }

    public static FragmentInicio newInstance() {
        FragmentInicio fragment = new FragmentInicio();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_inicio, container, false);

        request_api = (Button) rootView.findViewById(R.id.button2);
        request_api.setOnClickListener(this);

        boton_lista = (Button) rootView.findViewById(R.id.button);
        boton_lista.setOnClickListener(this);

        direccion = (TextView) rootView.findViewById(R.id.text1);
        dir_alreves = (TextView) rootView.findViewById(R.id.text2);

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

    @Override
    public void onClick(View v) {
        //hace la peticion al servidor y muestra la direccion de IP en los TextView
        if(v.equals(request_api)){
            Conexion conexion = new Conexion();
            conexion.execute();
        }
        //hace el cambio a el fragment con la utilidad para la manipulacion de datos en la lista
        if(v.equals(boton_lista)){
            FragmentLista fragment = new FragmentLista();
            Log.i("boton", "se apreto");
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.container_fragment, fragment.newInstance());
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
