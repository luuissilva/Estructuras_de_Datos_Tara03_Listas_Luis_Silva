public interface PlaylistCircularTDA {
    void agregarAlInicio(String nombre);
    void agregarAlFinal(String nombre);
    void mostrarPlaylist();
    void reproducirSiguiente();
    boolean eliminarPorNombre(String nombre);
    boolean estaVacia();
}
