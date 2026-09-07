import java.util.Scanner;

/**
 * Menú interactivo por teclado para el TDA PlaylistCircularTDA.
 */
public class PruebaPlaylist {
    public static void main(String[] args) {
        PlaylistCircularTDA playlist = new PlaylistCircularImpl();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n========================================");
            System.out.println("   PLAYLIST MUSICAL CIRCULAR");
            System.out.println("========================================");
            System.out.println("1. Agregar canción al inicio");
            System.out.println("2. Agregar canción al final");
            System.out.println("3. Mostrar playlist completa");
            System.out.println("4. Reproducir siguiente canción");
            System.out.println("5. Eliminar canción por nombre");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de la canción: ");
                    playlist.agregarAlInicio(sc.nextLine());
                    System.out.println("Canción agregada al inicio.");
                    break;
                case 2:
                    System.out.print("Nombre de la canción: ");
                    playlist.agregarAlFinal(sc.nextLine());
                    System.out.println("Canción agregada al final.");
                    break;
                case 3:
                    playlist.mostrarPlaylist();
                    break;
                case 4:
                    playlist.reproducirSiguiente();
                    break;
                case 5:
                    System.out.print("Nombre de la canción a eliminar: ");
                    playlist.eliminarPorNombre(sc.nextLine());
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
