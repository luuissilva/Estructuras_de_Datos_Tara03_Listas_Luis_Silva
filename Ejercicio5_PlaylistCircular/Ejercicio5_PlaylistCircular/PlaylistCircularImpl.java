public class PlaylistCircularImpl implements PlaylistCircularTDA {

    private static class Cancion {
        String nombre;
        Cancion siguiente;
        Cancion(String nombre) { this.nombre = nombre; }
    }

    private Cancion ultimo;   // último nodo insertado (mantiene la circularidad)
    private Cancion actual;   // canción que se está reproduciendo actualmente
    private int cantidad;

    @Override
    public boolean estaVacia() { return ultimo == null; }

    @Override
    public void agregarAlInicio(String nombre) {
        Cancion nueva = new Cancion(nombre);
        if (estaVacia()) {
            ultimo = nueva;
            nueva.siguiente = nueva;
            actual = nueva;
        } else {
            nueva.siguiente = ultimo.siguiente;
            ultimo.siguiente = nueva;
        }
        cantidad++;
    }

    @Override
    public void agregarAlFinal(String nombre) {
        Cancion nueva = new Cancion(nombre);
        if (estaVacia()) {
            ultimo = nueva;
            nueva.siguiente = nueva;
            actual = nueva;
        } else {
            nueva.siguiente = ultimo.siguiente;
            ultimo.siguiente = nueva;
            ultimo = nueva;
        }
        cantidad++;
    }

    @Override
    public void mostrarPlaylist() {
        if (estaVacia()) {
            System.out.println("La playlist está vacía.");
            return;
        }
        Cancion nodo = ultimo.siguiente;
        StringBuilder sb = new StringBuilder("Playlist: ");
        do {
            sb.append(nodo == actual ? "[" + nodo.nombre + "]" : nodo.nombre);
            sb.append(" -> ");
            nodo = nodo.siguiente;
        } while (nodo != ultimo.siguiente);
        sb.append("(vuelve a: ").append(ultimo.siguiente.nombre).append(")");
        System.out.println(sb.toString());
    }

    @Override
    public void reproducirSiguiente() {
        if (estaVacia()) {
            System.out.println("No hay canciones para reproducir.");
            return;
        }
        actual = actual.siguiente; // si estaba en la última, vuelve automáticamente a la primera
        System.out.println("Reproduciendo ahora: " + actual.nombre);
    }

    @Override
    public boolean eliminarPorNombre(String nombre) {
        if (estaVacia()) {
            System.out.println("La playlist está vacía.");
            return false;
        }
        Cancion nodo = ultimo.siguiente;
        Cancion anterior = ultimo;
        int vueltas = cantidad;
        while (vueltas > 0) {
            if (nodo.nombre.equals(nombre)) {
                if (cantidad == 1) {
                    ultimo = null;
                    actual = null;
                } else {
                    anterior.siguiente = nodo.siguiente;
                    if (nodo == ultimo) ultimo = anterior;
                    if (nodo == actual) actual = nodo.siguiente;
                }
                cantidad--;
                System.out.println("Canción \"" + nombre + "\" eliminada.");
                return true;
            }
            anterior = nodo;
            nodo = nodo.siguiente;
            vueltas--;
        }
        System.out.println("Canción \"" + nombre + "\" no encontrada.");
        return false;
    }
}
