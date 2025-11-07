import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.ResultadoDeCambio;
import servicio.ConsultaApi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();

        int opcion = -1; // Esto se hace para que inincie con un calor diferente a 0

        while(opcion != 0) {
            System.out.println("=====================================");
            System.out.println("CONVERSOR DE MONEDA");
            System.out.println("1 - Peso Mexicano a Dólar");
            System.out.println("2 - Dólar a Peso Mexicano");
            System.out.println("3 - Peso Mexicano a Peso Argentino");
            System.out.println("4 - Peso Argentino a Peso Mexicano");
            System.out.println("5 - Peso Mexicano a Quetzal");
            System.out.println("6 - Quetzal a Peso Mexicano");


            System.out.println("0 - Salir");
            System.out.println("=====================================");
            System.out.print("Elige una opción: ");

            opcion = teclado.nextInt(); // Esto tomara el valor de opcion para ejecutar el menu

            switch (opcion){
                case 1:
                    realizarConversion("MXN", "USD", teclado, consulta);
                    break;
                case 2:
                    realizarConversion("USD", "MXN", teclado, consulta);
                    break;
                case 3:
                    realizarConversion("MXN", "ARS", teclado, consulta);
                    break;
                case 4:
                    realizarConversion("ARS", "MXN", teclado, consulta);
                    break;
                case 5:
                    realizarConversion("MXN", "GTQ", teclado, consulta);
                    break;
                case 6:
                    realizarConversion("GTQ", "MXN", teclado, consulta);
                    break;
                case 0:
                    System.out.println("Cerrando el programa. ¡Gracias por usar el conversor!");
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }
        teclado.close();
    }

    //Se hace el metodo para simplificar el codigo y que no se escriba de 6 maneras diferentes, si no que se usa una sola vez para todas.
    public static void realizarConversion(String origen, String destino, Scanner teclado, ConsultaApi consulta) {
        try {
            System.out.printf("Ingrese la cantidad de %s a convertir: ", origen);
            double cantidad = teclado.nextDouble();

            ResultadoDeCambio conversion = consulta.obtenerTasa(origen, destino);

            if (conversion != null) {
                conversion.setCantidadAConvertir(cantidad);
                conversion.calcularResultado();

                System.out.printf("El resultado de %.2f %s a %s es: %.2f%n",
                        cantidad, conversion.getMonedaOrigen(),
                        conversion.getMonedaResultado(),
                        conversion.getResultadoConversion());

                try {
                    Gson gson = new GsonBuilder().setPrettyPrinting().create(); // PrettyPrinting para formato legible
                    String jsonTransaccion = gson.toJson(conversion); // 1. Serializar objeto a JSON

                    // Se escribira un archivo usando append que lo agregara siempre pero al final del archivo
                    FileWriter escritura = new FileWriter("historial_transacciones.json", true); // 'true' para añadir
                    escritura.write(jsonTransaccion + "\n"); // Escribe el JSON y una nueva línea
                    escritura.close(); // Siempre cerrar el archivo

                } catch (IOException e) {
                    System.err.println("Error al guardar la transacción en el historial: " + e.getMessage());
                }
            }
        } catch (Exception e) { // Captura si el Scanner falla al leer double
            System.out.println("Error: Ingrese un número válido para la cantidad.");
            teclado.next(); // Limpia el buffer
        }
    }
}
