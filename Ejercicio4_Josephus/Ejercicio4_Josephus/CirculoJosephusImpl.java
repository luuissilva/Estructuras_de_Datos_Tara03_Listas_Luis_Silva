public class CirculoJosephusImpl implements CirculoJosephusTDA {

    private static class Nodo {
        int valor;
        Nodo siguiente;
        Nodo(int valor) { this.valor = valor; }
    }

    private Nodo ultimo;

    @Override
    public void construir(int n) {
        ultimo = null;
        for (int i = 1; i <= n; i++) {
            Nodo nuevo = new Nodo(i);
            if (ultimo == null) {
                ultimo = nuevo;
                nuevo.siguiente = nuevo;
            } else {
                nuevo.siguiente = ultimo.siguiente;
                ultimo.siguiente = nuevo;
                ultimo = nuevo;
            }
        }
    }

    @Override
    public int resolver(int k) {
        System.out.print("Orden de eliminación: ");

        Nodo actual = ultimo.siguiente; // empieza en la persona 1
        Nodo anterior = ultimo;

        while (actual.siguiente != actual) { // mientras quede más de una persona
            for (int i = 1; i < k; i++) {
                anterior = actual;
                actual = actual.siguiente;
            }
            System.out.print(actual.valor + " ");
            anterior.siguiente = actual.siguiente;
            if (actual == ultimo) {
                ultimo = anterior;
            }
            actual = actual.siguiente;
        }
        System.out.println();
        return actual.valor;
    }
}
