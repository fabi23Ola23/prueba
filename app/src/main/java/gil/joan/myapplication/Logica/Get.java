package gil.joan.myapplication.Logica;



import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// _____________________________________________Clase para la peticion GET

public class Get {

    private JSONObject devolver;
    private String ruta = "https://httpbin.org/get";

    private int progreso;

    /**
     * ___________________________Constructor de la clase
     */
    public Get(){

    }


    /**
     * _______________________________Convierte una Objeto InputStream en un String
     * @param is Objeto InputStream resultado de la solicitud de un servicio a la Api
     * @return String con el resultado del InputStream
     * @throws IOException cierra el socket en caso de fallo
     */
    private String convertStreamToString(InputStream is) throws IOException {
        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            }
            finally {
                is.close();
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    //TODO: Metodo que se invoca de primero

    /**
     * _______________metodo GET
     * @param direccion direccion del servicio
     * @return String con el resultado del servicio solicitado
     */
    private String hacerPeticionServicios(String direccion){
        String devuelve ="";
        URL url = null;
        try {
            HttpURLConnection urlConn;
            //DataOutputStream printout;
            //DataInputStream input;
            url = new URL(direccion);
            urlConn = (HttpURLConnection) url.openConnection();
            Log.i("MsjApk"," connection "+urlConn);
            urlConn.setDoInput(true);
            urlConn.setDoOutput(false);
            urlConn.setUseCaches(false);
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setRequestProperty("Accept", "application/json");
            urlConn.connect();
            // Envio los parámetros post.
            //OutputStream os = urlConn.getOutputStream();
            //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            //writer.write(enviar);
            //writer.flush();
            //writer.close();

            int respuesta = urlConn.getResponseCode();
            Log.i("MsjApk"," respuesta "+respuesta);
            StringBuilder result = new StringBuilder();

            if (respuesta == HttpURLConnection.HTTP_OK){
                InputStream in = new BufferedInputStream(urlConn.getInputStream());  // preparo la cadena de entrada
                Log.i("MsjApk"," inputstream "+in);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));  // la introduzco en un BufferedReader
                Log.i("MsjApk"," Qdevuelve1 "+devuelve);
                Log.i("MsjApk"," reader "+reader);
                Log.i("MsjApk"," resultado "+result);
                Log.i("MsjApk"," Qdevuelve2 "+devuelve);
                devuelve = convertStreamToString(in);
                Log.i("MsjApk"," Qdevuelve3 "+devuelve);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return devuelve;
    }


    /**
     * __________________________________ la direccion de IP del servicio
     * @return String con la IP, en caso de error da un mensaje de error
     */
    public String obtenerIpRespuesta(){
        String data= hacerPeticionServicios(ruta);
        Log.i("MsjApk"," obtenerdelJSON "+data);

        if(!data.equalsIgnoreCase("")){
            JSONObject json;

            try {
                json = new JSONObject(data);

                String resultJSON = json.getString("origin");

                Log.i("MsjApk"," Estado "+resultJSON);

                return resultJSON;

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return "NO NETWORK CONNECTION";
    }

}

