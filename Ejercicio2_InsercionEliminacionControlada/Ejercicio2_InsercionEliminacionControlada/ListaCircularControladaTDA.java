public interface ListaCircularControladaTDA {
    void insertarEnPosicion(int valor, int posicion);
    boolean eliminarPorPosicion(int posicion);
    boolean eliminarPorValor(int valor);
    void mostrar();
    boolean estaVacia();
    int contar();
}
