package gil.joan.myapplication.Logica;


import android.os.AsyncTask;
import android.util.Log;

/**
*___________________________ la invocacion del servicio web
* */
public class Conexion extends AsyncTask {

/**
 * @param recibir lo que recive el tipo RecibirJSONS
 * @param aux  la ip guardada
 */
private Get recibir;
private String aux;


public Conexion(){
    aux = "null";
    recibir = new Get();
}

/**
 *______________________________
 * @param params Arreglo de objetos del tipo Object. Son todos los parametros necesarios para la ejecucion del hilo. En nuestro caso no se envian parametros
 * @return null. Retorno definido por el framework de Android
 */
@Override
protected Object doInBackground(Object[] params) {
    boolean band = false;
    aux = recibir.obtenerIpRespuesta();
    Log.e("AUX"," "+aux);
    if(!aux.equals("null")){
        band = true;
    }
    return band;
}


@Override
protected void onProgressUpdate(Object[] values) {
    super.onProgressUpdate(values);

}

/**
 * __________________________________Coloca la ip obtenida los TextView.
 * @param result Android por defecto.
 * @return void
 */
protected void onPostExecute(Object result) {
    super.onPostExecute(result);
    if(result.equals(true)){
        //MainActivity.dir_ip = aux;
        FragmentInicio.direccion.setText(aux);
        String invertida = "";
        char[] auxChar = aux.toCharArray();
        int tam = auxChar.length;
        for(int i=1;i<=tam;i++){
            invertida = invertida+auxChar[tam-i];
        }
        FragmentInicio.dir_alreves.setText(invertida);
    }
}


@Override
protected void onCancelled() {
    super.onCancelled();
}
}
