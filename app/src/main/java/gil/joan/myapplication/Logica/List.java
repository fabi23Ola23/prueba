package gil.joan.myapplication.Logica;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
//___________________CLASE QUE TIENE LOS METODOS DE LA LISTA DE NUMERO

public class List {

    private ArrayList<Integer> listaNumeros;

    public List(){
        listaNumeros = new ArrayList<Integer>();
    }

    /**
     * ______________________________________Agreaga una cantidad determinada de numeros
     * @param cuantos entero que indica la cantidad de elementos agragar en la lista
     * @return ArrayList de tipo Integer
     * */
    public ArrayList<Integer> agregarNuemerosALista(int cuantos){
        Log.e("Cuantos"," "+cuantos);
        for(int i=0;i<cuantos;i++){
            listaNumeros.add((int)(Math.random()*999) + 1);
        }
        return listaNumeros;
    }

    /**
     * ___________________________________Ordena asendentemente la lista
     * @return ArrayList  numeros ordenados
     */
    public ArrayList<Integer> ordenarAcendentementeLista(){
        Collections.sort(listaNumeros);
        return listaNumeros;
    }

    /**
     * _____________________Limpia la lista
     * @return ArrayList Integer
     */
    public ArrayList<Integer> blanquearLista(){
        listaNumeros = new ArrayList<Integer>();
        return listaNumeros;
    }


}
