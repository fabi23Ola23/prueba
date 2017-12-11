package gil.joan.myapplication.Logica;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import gil.joan.myapplication.R;

import java.util.ArrayList;

/**
 * Created by user on 08/12/2017.
 */

public class AdaptadorLista extends ArrayAdapter<Integer> {

    /**
     *@param context Objeto del tipo Activity que se usa para acceder a los metodos de manejo de contexto de la actividad
     *@param numeros ArrayList de objetos del tipo Hoja que alamacena las hojas a mostrar en el ListView
     *
     */
    private Activity context;
    private ArrayList<Integer> numeros = new ArrayList<Integer>();

    /**
     * _____________________Constructor de la clase AdaptadorLista
     *@param actividad Objeto del tipo Activity que se usa para invocar metodos de Activities dentro de esta clase
     *@param numeros ArrayList de objetos del tipo Integer que alamacena las hojas a mostrar en el ListView
     *
     */
    public AdaptadorLista(Activity actividad, ArrayList<Integer> numeros) {
        super(actividad, R.layout.item_numero,numeros);
        this.context = actividad;
        this.numeros = numeros;
    }

    /**
     *
     * _________________________________ Instancia uno a uno los elementos
     *
     * @param position posicion del elemento en el ListView
     * @param converView El objeto de tipo View que inlfa el layout del item del ListView
     * @param parent proporcionado por el Framework Android. No se usa.
     * @return item. Objeto del tipo View
     */
    public View getView(int position, View converView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View item = inflater.inflate(R.layout.item_numero, null);
        if(numeros.get(position)!=null){
            TextView nombre = (TextView)item.findViewById(R.id.texto_item);
            nombre.setText(numeros.get(position).toString());
        }
        return item;
    }

}