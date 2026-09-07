public interface ColaCircularProcesosTDA {
    void agregarProceso(String nombre, int tiempoRestante);
    boolean estaVacia();
    void mostrarEstado();
    void simular(); // ejecuta el algoritmo Round-Robin completo
}
