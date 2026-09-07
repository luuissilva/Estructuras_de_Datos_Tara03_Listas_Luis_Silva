4import java.util.Scanner;

/**
 * Clase de prueba: usa el TDA a través de la INTERFAZ (ListaCircularTDA),
 * no de la implementación concreta. Esto es la esencia del uso de un TDA:
 * el cliente no necesita saber cómo está construida la lista por dentro.
 *
 * Menú interactivo por teclado.
 */
public class PruebaListaCircularBasica {
    public static void main(String[] args) {
        ListaCircularTDA lista = new ListaCircularBasicaImpl();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========================================");
            System.out.println("   LISTA CIRCULAR BÁSICA");
            System.out.println("========================================");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Mostrar todos los elementos");
            System.out.println("4. Verificar si la lista está vacía");
            System.out.println("5. Contar el número de elementos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar al inicio: ");
                    lista.insertarInicio(leerEntero(sc));
                    System.out.println("Insertado correctamente.");
                    break;
                case 2:
                    System.out.print("Valor a insertar al final: ");
                    lista.insertarFinal(leerEntero(sc));
                    System.out.println("Insertado correctamente.");
                    break;
                case 3:
                    lista.mostrar();
                    break;
                case 4:
                    System.out.println("¿Está vacía? " + lista.estaVacia());
                    break;
                case 5:
                    System.out.println("Cantidad de elementos: " + lista.contar());
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
