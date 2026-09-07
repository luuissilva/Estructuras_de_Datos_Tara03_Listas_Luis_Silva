/**
 * TDA (Tipo de Dato Abstracto) para una lista simplemente enlazada circular.
 * Define QUE operaciones se pueden realizar, sin especificar COMO se
 * implementan internamente (eso lo hace la clase que implemente esta interfaz).
 */
public interface ListaCircularTDA {
    void insertarInicio(int valor);
    void insertarFinal(int valor);
    void mostrar();
    boolean estaVacia();
    int contar();
}
