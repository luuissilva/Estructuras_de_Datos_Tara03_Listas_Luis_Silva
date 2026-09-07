public class SimuladorRoundRobinImpl implements ColaCircularProcesosTDA {

    private static class Proceso {
        String nombre;
        int tiempoRestante;
        Proceso siguiente;
        Proceso(String nombre, int tiempoRestante) {
            this.nombre = nombre;
            this.tiempoRestante = tiempoRestante;
        }
    }

    private Proceso ultimo;
    private int cantidad;
    private final int quantum;

    public SimuladorRoundRobinImpl(int quantum) {
        this.quantum = quantum;
    }

    @Override
    public boolean estaVacia() { return ultimo == null; }

    @Override
    public void agregarProceso(String nombre, int tiempoRestante) {
        Proceso nuevo = new Proceso(nombre, tiempoRestante);
        if (ultimo == null) {
            ultimo = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
        cantidad++;
    }

    @Override
    public void mostrarEstado() {
        if (ultimo == null) {
            System.out.println("   Cola de procesos: [ vacía ]");
            return;
        }
        Proceso actual = ultimo.siguiente;
        StringBuilder sb = new StringBuilder("   Cola de procesos: [ ");
        do {
            sb.append(actual.nombre).append("(").append(actual.tiempoRestante).append(") ");
            actual = actual.siguiente;
        } while (actual != ultimo.siguiente);
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public void simular() {
        int turno = 1;
        System.out.println("Estado inicial:");
        mostrarEstado();
        System.out.println();

        while (ultimo != null) {
            Proceso actual = ultimo.siguiente; // proceso al frente de la cola
            System.out.println("Turno " + turno + ": ejecutando " + actual.nombre +
                    " (tiempo restante antes: " + actual.tiempoRestante + ")");

            int ejecutado = Math.min(quantum, actual.tiempoRestante);
            actual.tiempoRestante -= ejecutado;
            System.out.println("   Se ejecuta durante " + ejecutado + " unidades (quantum=" + quantum + ").");

            if (actual.tiempoRestante <= 0) {
                System.out.println("   " + actual.nombre + " ha terminado y se elimina de la lista.");
                if (cantidad == 1) {
                    ultimo = null;
                } else {
                    ultimo.siguiente = actual.siguiente; // se quita el nodo del frente
                }
                cantidad--;
            } else {
                System.out.println("   " + actual.nombre + " no ha terminado (restante: " +
                        actual.tiempoRestante + "), vuelve al final del ciclo.");
                ultimo = actual; // actual pasa a ser el último => el frente avanza al siguiente
            }

            mostrarEstado();
            System.out.println();
            turno++;
        }
        System.out.println("Todos los procesos han finalizado.");
    }
}
