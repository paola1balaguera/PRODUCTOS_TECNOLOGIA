package pequeño;

public interface Operaciones<T> {
    void agregar(T elemento);
    void actualizar(int referencia, T elemento);
    void eliminar(int referencia);
}

//static todos los metodos 
