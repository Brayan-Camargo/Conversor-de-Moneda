package modelos; // Asegúrate de que esté en tu paquete modelos

public class TasaApi {
    //Los nombres de los atributos deben COINCIDIR con las claves del JSON
    private String result;
    private String base_code;
    private String target_code;
    private double conversion_rate; // Este es el valor clave

    public double getConversionRate() {
        return conversion_rate;
    }

    public String getResult() {
        return result;
    }
}