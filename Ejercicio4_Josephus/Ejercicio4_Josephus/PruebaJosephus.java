import java.util.Scanner;

/**
 * Menú interactivo por teclado para el TDA CirculoJosephusTDA.
 */
public class PruebaJosephus {
    public static void main(String[] args) {
        CirculoJosephusTDA josephus = new CirculoJosephusImpl();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========================================");
            System.out.println("   PROBLEMA DE JOSEPHUS");
            System.out.println("========================================");
            System.out.println("1. Resolver (ingresar n y k)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    System.out.print("Número de personas (n): ");
                    int n = leerEntero(sc);
                    System.out.print("Paso de conteo (k): ");
                    int k = leerEntero(sc);
                    if (n <= 0 || k <= 0) {
                        System.out.println("n y k deben ser mayores a 0.");
                        break;
                    }
                    josephus.construir(n);
                    int sobreviviente = josephus.resolver(k);
                    System.out.println("Sobreviviente: " + sobreviviente);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un número entero válido: ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }
}
