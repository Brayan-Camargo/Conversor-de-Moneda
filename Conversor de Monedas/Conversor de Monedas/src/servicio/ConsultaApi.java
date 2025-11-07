package servicio;

import com.google.gson.Gson;
import modelos.ResultadoDeCambio;
import modelos.TasaApi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    //Esto es la clave API y con esto la llamas
    private final String API_KEY = "7f6e829e8a0b79ef0407743f";

    //Haremos el metodo para obtener la tasa de cambio
    public String obtenerRespuestaJSON(String monedaOrigen, String monedaDestino) {

        //Haremos la construccion de la URL completa y automatica
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        //Hacemos el metodo try y catch que funcionan paraa el manejo de excepciones
        try {
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            //Usamos un if para verificar algunos resultados
            if (respuesta.statusCode() == 200) {
                return respuesta.body();
            } else {
                System.out.println("Error en la solicitud. Código de estado: " + respuesta.statusCode());
                return null;
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la consulta a la API: " + e.getMessage());
            return null;
        }
    }

    // Este sera un nuevo metodo para la consulta mejorada con Gson
    public ResultadoDeCambio obtenerTasa(String monedaOrigen, String monedaDestino) {
        String jsonRespuesta = obtenerRespuestaJSON(monedaOrigen, monedaDestino);

        if (jsonRespuesta == null){
            return null;
        }

        //de nuevo utilizaremos el metodo try y el metodo catch para manejar excepciones
        try {
            //iniciamos el Gson
            Gson gson = new Gson();

            TasaApi datosApi = gson.fromJson(jsonRespuesta, TasaApi.class);

            //Con este if verificamos el resultado
            if (datosApi.getResult().equalsIgnoreCase("success")) {
                return new ResultadoDeCambio(
                        datosApi.getBase_code(),
                        datosApi.getTarget_code(),
                        datosApi.getConversionRate()
                );
            } else {
                System.out.println("La API detecta un error: " + jsonRespuesta);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al pricesas el  archivo Json: " + e.getMessage());
            return null;
        }
    }
}