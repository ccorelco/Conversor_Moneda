import java.io.IOException;
import java.util.Scanner;
import java.util.Set;


public class Principal {

    private final ConsultaTipoDeMoneda consultaTipoDeMoneda = new ConsultaTipoDeMoneda();
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("-######- Conversor de Moneda -######-");
        System.out.println("Seleccione la moneda de origen:");
        System.out.println("1. USD (Dólar USA)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (Libra esterlina)");
        System.out.println("4. CLP (Peso chileno)");
        System.out.println("5. BRL (Real brasileño)");
        System.out.println("6. MXN (Peso mexicano)");
        System.out.println("7. JPY (Yen japonés)");
        System.out.println("8. CAD (Dólar canadiense)");
        System.out.println("9. AUD (Dólar australiano)");
        System.out.println("10. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public int leerOpcionUsuario() {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingrese un número.");
            scanner.next(); // Limpiar el buffer
            System.out.print("Ingrese su opción: ");
        }
        return scanner.nextInt();
    }

    public String obtenerMonedaOrigen(int opcion) {
        return switch (opcion) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "GBP";
            case 4 -> "CLP";
            case 5 -> "BRL";
            case 6 -> "MXN";
            case 7 -> "JPY";
            case 8 -> "CAD";
            case 9 -> "AUD";
            default -> null;
        };
    }

    public int leerOpcionMonedaDestino() {
        System.out.println("Ingrese moneda de destino elejida:");
        System.out.println("1. USD (Dólar USA)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. GBP (Libra esterlina)");
        System.out.println("4. CLP (Peso chileno)");
        System.out.println("5. BRL (Real brasileño)");
        System.out.println("6. MXN (Peso mexicano)");
        System.out.println("7. JPY (Yen japonés)");
        System.out.println("8. CAD (Dólar canadiense)");
        System.out.println("9. AUD (Dólar australiano)");
        System.out.print("Elija una opción: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, ingrese una opcion.");
            scanner.next(); // limpia buffer
            System.out.print("Ingrese su opción: ");
        }
        return scanner.nextInt();
    }

    public String obtenerMonedaDestino(int opcion) {
        return switch (opcion) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "GBP";
            case 4 -> "CLP";
            case 5 -> "BRL";
            case 6 -> "MXN";
            case 7 -> "JPY";
            case 8 -> "CAD";
            case 9 -> "AUD";
            default -> null;
        };
    }

    public double obtenerCantidad() {
        double cantidad = 0.0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Ingrese el monto a convertir: ");
            if (scanner.hasNextDouble()) {
                cantidad = scanner.nextDouble();
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Ingrese un número.");
                scanner.next(); // Limpia buffer
            }
        }
        scanner.nextLine(); // Consumir la nueva línea pendiente del nextDouble()
        return cantidad;
    }

    public void mostrarResultado(double cantidadOriginal, String monedaOrigen, double cantidadConvertida, String monedaDestino) {
        final String COLOR_VERDE = "\u001B[92m"; // Verde brillante
        final String RESET = "\u001B[0m";         // Restablece color por defecto

        System.out.printf(COLOR_VERDE + "%.2f %s equivalen a %.2f %s" + RESET + "%n",
                cantidadOriginal, monedaOrigen, cantidadConvertida, monedaDestino);
    }


    public void ejecutarConversion() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcionUsuario();
            String monedaOrigen = obtenerMonedaOrigen(opcion);

            if (monedaOrigen != null) {
                int opcionDestino = leerOpcionMonedaDestino();
                String monedaDestino = obtenerMonedaDestino(opcionDestino);

                if (monedaDestino == null) {
                    System.out.println("Opción de moneda inválida. Ingrese nuevamente.");
                    continue;
                }

                double cantidad = obtenerCantidad();

                try {
                    TipoCambio tipoCambio = consultaTipoDeMoneda.obtenerTipoDeCambio(monedaOrigen, monedaDestino);
                    double cantidadConvertida = cantidad * tipoCambio.valor();
                    mostrarResultado(cantidad, monedaOrigen, cantidadConvertida, tipoCambio.monedaDestino());
                } catch (IOException e) {
                    System.err.println("Error al obtener el tipo de cambio: " + e.getMessage());
                } catch (TipoDeMonedaNoEncontradaException e) {
                    System.err.println(e.getMessage());
                }
            } else if (opcion != 10) {
                System.out.println("Opción inválida. Intente de nuevamente.");
            }
            System.out.println(); // espacio en blanco /salto
        } while (opcion != 10);

        System.out.println("¡Gracias por preferirnos!");
        scanner.close();
    }

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.ejecutarConversion();
    }
}
