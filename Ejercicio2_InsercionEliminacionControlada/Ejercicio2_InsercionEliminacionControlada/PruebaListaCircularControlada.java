import java.util.Scanner;

/**
 * Menú interactivo por teclado para el TDA ListaCircularControladaTDA.
 */
public class PruebaListaCircularControlada {
    public static void main(String[] args) {
        ListaCircularControladaTDA lista = new ListaCircularControladaImpl();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========================================");
            System.out.println("   LISTA CIRCULAR - INSERCIÓN Y ELIMINACIÓN CONTROLADA");
            System.out.println("========================================");
            System.out.println("1. Insertar en una posición específica");
            System.out.println("2. Eliminar por posición");
            System.out.println("3. Eliminar por valor");
            System.out.println("4. Mostrar la lista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    System.out.print("Valor a insertar: ");
                    int valor = leerEntero(sc);
                    System.out.print("Posición (0 = inicio, " + lista.contar() + " = final): ");
                    int posIns = leerEntero(sc);
                    System.out.print("Antes:   ");
                    lista.mostrar();
                    lista.insertarEnPosicion(valor, posIns);
                    System.out.print("Después: ");
                    lista.mostrar();
                    break;
                case 2:
                    System.out.print("Posición a eliminar: ");
                    int posDel = leerEntero(sc);
                    System.out.print("Antes:   ");
                    lista.mostrar();
                    lista.eliminarPorPosicion(posDel);
                    System.out.print("Después: ");
                    lista.mostrar();
                    break;
                case 3:
                    System.out.print("Valor a eliminar: ");
                    int valDel = leerEntero(sc);
                    System.out.print("Antes:   ");
                    lista.mostrar();
                    lista.eliminarPorValor(valDel);
                    System.out.print("Después: ");
                    lista.mostrar();
                    break;
                case 4:
                    lista.mostrar();
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
