public class ResultadoDeCambio {
    private String monedaOrigen;
    private String monedaResultado;
    private double valorDeTasaConversion;

    private double cantidadAConvertir;
    private double resultaedoConversion;

    //Aqui generaremos el constructor para inicializar con la API
    public Transaccion(String origen, String destino, double tasa){
        this.monedaOrigen = origen;
        this.monedaResultado = destino;
        this.valorDeTasaConversion = tasa;
    }
    

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaResultado() {
        return monedaResultado;
    }

    public void setMonedaResultado(String monedaResultado) {
        this.monedaResultado = monedaResultado;
    }

    public double getValorDeTasaConversion() {
        return valorDeTasaConversion;
    }

    public void setValorDeTasaConversion(double valorDeTasaConversion) {
        this.valorDeTasaConversion = valorDeTasaConversion;
    }

    public double getCantidadAConvertir() {
        return cantidadAConvertir;
    }

    public void setCantidadAConvertir(double cantidadAConvertir) {
        this.cantidadAConvertir = cantidadAConvertir;
    }

    public double getResultaedoConversion() {
        return resultaedoConversion;
    }

    public void setResultaedoConversion(double resultaedoConversion) {
        this.resultaedoConversion = resultaedoConversion;
    }
}
