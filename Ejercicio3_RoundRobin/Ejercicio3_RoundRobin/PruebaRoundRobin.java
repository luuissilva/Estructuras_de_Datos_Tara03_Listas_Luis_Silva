import java.util.Scanner;

/**
 * Menú interactivo por teclado para el TDA ColaCircularProcesosTDA (Round-Robin).
 */
public class PruebaRoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el valor del quantum: ");
        int quantum = leerEntero(sc);

        ColaCircularProcesosTDA simulador = new SimuladorRoundRobinImpl(quantum);
        int opcion;

        do {
            System.out.println("\n========================================");
            System.out.println("   SIMULACIÓN ROUND-ROBIN (quantum = " + quantum + ")");
            System.out.println("========================================");
            System.out.println("1. Agregar proceso");
            System.out.println("2. Mostrar estado de la cola");
            System.out.println("3. Iniciar simulación (hasta que todos terminen)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del proceso: ");
                    String nombre = sc.nextLine();
                    System.out.print("Tiempo restante: ");
                    int tiempo = leerEntero(sc);
                    simulador.agregarProceso(nombre, tiempo);
                    System.out.println("Proceso agregado.");
                    break;
                case 2:
                    simulador.mostrarEstado();
                    break;
                case 3:
                    if (simulador.estaVacia()) {
                        System.out.println("No hay procesos en la cola.");
                    } else {
                        simulador.simular();
                    }
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
