public class ListaCircularControladaImpl implements ListaCircularControladaTDA {

    private static class Nodo {
        int dato;
        Nodo siguiente;
        Nodo(int dato) { this.dato = dato; }
    }

    private Nodo ultimo;
    private int tamano;

    @Override
    public boolean estaVacia() { return ultimo == null; }

    @Override
    public int contar() { return tamano; }

    private void insertarInicioInterno(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
        }
        tamano++;
    }

    private void insertarFinalInterno(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        tamano++;
    }

    @Override
    public void insertarEnPosicion(int valor, int posicion) {
        if (posicion < 0 || posicion > tamano) {
            System.out.println("Posición inválida: " + posicion);
            return;
        }
        if (posicion == 0) { insertarInicioInterno(valor); return; }
        if (posicion == tamano) { insertarFinalInterno(valor); return; }

        Nodo nuevo = new Nodo(valor);
        Nodo actual = ultimo.siguiente; // primero
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        tamano++;
    }

    @Override
    public boolean eliminarPorPosicion(int posicion) {
        if (estaVacia()) {
            System.out.println("No se puede eliminar: la lista está vacía.");
            return false;
        }
        if (posicion < 0 || posicion >= tamano) {
            System.out.println("Posición inválida: " + posicion);
            return false;
        }
        Nodo primero = ultimo.siguiente;

        if (tamano == 1) {
            ultimo = null;
            tamano = 0;
            return true;
        }

        if (posicion == 0) {
            ultimo.siguiente = primero.siguiente;
        } else {
            Nodo anterior = primero;
            for (int i = 0; i < posicion - 1; i++) {
                anterior = anterior.siguiente;
            }
            Nodo objetivo = anterior.siguiente;
            anterior.siguiente = objetivo.siguiente;
            if (objetivo == ultimo) {
                ultimo = anterior;
            }
        }
        tamano--;
        return true;
    }

    @Override
    public boolean eliminarPorValor(int valor) {
        if (estaVacia()) {
            System.out.println("No se puede eliminar: la lista está vacía.");
            return false;
        }
        Nodo actual = ultimo.siguiente;
        Nodo anterior = ultimo;
        int vueltas = tamano;
        while (vueltas > 0) {
            if (actual.dato == valor) {
                if (tamano == 1) {
                    ultimo = null;
                } else {
                    anterior.siguiente = actual.siguiente;
                    if (actual == ultimo) {
                        ultimo = anterior;
                    }
                }
                tamano--;
                return true;
            }
            anterior = actual;
            actual = actual.siguiente;
            vueltas--;
        }
        System.out.println("Valor " + valor + " no encontrado.");
        return false;
    }

    @Override
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("[ lista vacía ]");
            return;
        }
        Nodo actual = ultimo.siguiente;
        StringBuilder sb = new StringBuilder("[ ");
        do {
            sb.append(actual.dato).append(" ");
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
        sb.append("]");
        System.out.println(sb.toString());
    }
}
