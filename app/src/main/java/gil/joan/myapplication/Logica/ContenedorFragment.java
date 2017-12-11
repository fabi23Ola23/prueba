package gil.joan.myapplication.Logica;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import gil.joan.myapplication.R;

/**
 * Created by user on 08/12/2017.
 */

public class ContenedorFragment extends Fragment{

    private OnFragmentInteractionListener mListener;

    private View rootView;

    private ListView listado;

    private AdaptadorLista adaptadorLista;
    private ArrayList<Integer> listaNumeros;

    public ContenedorFragment() {
        // Required empty public constructor
    }


    public static ContenedorFragment newInstance(ArrayList<Integer> listaNumeros) {
        ContenedorFragment fragment = new ContenedorFragment();
        fragment.listaNumeros = listaNumeros;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);

        listado = (ListView)rootView.findViewById(R.id.listView);

        if(listaNumeros.size()!=0){
            //_______________________________________________________muestra  los numeros
            adaptadorLista = new AdaptadorLista(getActivity(), listaNumeros);
            listado.setAdapter(adaptadorLista);
        }
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


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}