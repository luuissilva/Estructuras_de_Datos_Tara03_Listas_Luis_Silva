/**
 * Implementación del TDA ListaCircularTDA usando nodos enlazados.
 * Se mantiene una única referencia (ultimo) desde la cual se puede
 * acceder tanto al último nodo como al primero (ultimo.siguiente).
 */
public class ListaCircularBasicaImpl implements ListaCircularTDA {

    // Nodo interno: detalle de implementación oculto al usuario del TDA
    private static class Nodo {
        int dato;
        Nodo siguiente;
        Nodo(int dato) { this.dato = dato; }
    }

    private Nodo ultimo;
    private int tamano;

    @Override
    public boolean estaVacia() {
        return ultimo == null;
    }

    @Override
    public int contar() {
        return tamano;
    }

    @Override
    public void insertarInicio(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            ultimo = nuevo;
            nuevo.siguiente = nuevo; // se apunta a sí mismo
        } else {
            nuevo.siguiente = ultimo.siguiente; // apunta al primero actual
            ultimo.siguiente = nuevo;           // el último ahora apunta al nuevo primero
        }
        tamano++;
    }

    @Override
    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (estaVacia()) {
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            nuevo.siguiente = ultimo.siguiente; // apunta al primero
            ultimo.siguiente = nuevo;           // el antiguo último apunta al nuevo
            ultimo = nuevo;                     // el nuevo pasa a ser el último
        }
        tamano++;
    }

    @Override
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo actual = ultimo.siguiente; // primero
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(actual.dato).append(" -> ");
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
        sb.append("(vuelve al primero: ").append(ultimo.siguiente.dato).append(")");
        System.out.println(sb.toString());
    }
}
