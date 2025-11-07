import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
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
                    // llamar al metodo para ocnvertir
                    break;
                case 2:
                    // llamar al metodo para ocnvertir
                    break;
                case 3:
                    // llamar al metodo para ocnvertir
                    break;
                case 4:
                    // llamar al metodo para ocnvertir
                    break;
                case 5:
                    // llamar al metodo para ocnvertir
                    break;
                case 6:
                    // llamar al metodo para ocnvertir
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }
        teclado.close();
    }
}
