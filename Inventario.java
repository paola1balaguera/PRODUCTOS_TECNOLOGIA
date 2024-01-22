package pequeño;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class Inventario implements Operaciones<Producto> {
    Scanner scanner = new Scanner(System.in);
    private List<Producto> inventario;
    private Map<Integer, Categoria> categorias;

    public Inventario() {
        inventario = new ArrayList<>();
        categorias = new TreeMap<>();
        inicializarCategorias();
    }

    private void inicializarCategorias() {
        categorias.put(1, new Categoria(1, "Computadores"));
        categorias.put(2, new Categoria(2, "Celulares"));
        categorias.put(3, new Categoria(3, "Electrodomésticos"));
        categorias.put(4, new Categoria(4, "TV"));
        categorias.put(5, new Categoria(5, "Accesorios"));
        categorias.put(6, new Categoria(6, "Videojuegos"));
        categorias.put(7, new Categoria(7, "Audio y video"));
    }

    @Override
    public void agregar(Producto producto) {

        if (!inventario.contains(producto)) {
            inventario.add(producto);
            System.out.println("Producto agregado correctamente.");
        } else {
            System.out.println("Error: Producto con la misma referencia ya existe.");
        }
    }

    @Override
    public void eliminar(int referencia) {
        
        inventario.removeIf(producto -> producto.getReferencia() == referencia);
        System.out.println("Producto eliminado correctamente.");
    }

    @Override
    public void actualizar(int referencia, Producto nuevoProducto) {

        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getReferencia() == referencia) {
                inventario.set(i, nuevoProducto);
                System.out.println("Producto actualizado correctamente.");
                return;
            }
        }
        System.out.println("Error: Producto no encontrado.");
    }

    public void agregarCategoria(int codigo, Categoria categoria) {
        
        categorias.putIfAbsent(codigo, categoria);
        System.out.println("Categoría agregada correctamente.");
    }

    public void eliminarCategoria(int codigo) {
        categorias.remove(codigo);
        System.out.println("Categoría eliminada correctamente.");
        System.out.println("Revisa que tu categoria ya no se encuentre:");
        verCategorias();
    }

    public void verInventarioCategoria(int categoria) {
        System.out.println("Inventario para la categoría " + categoria + ":");
        inventario.stream()
                .filter(producto -> producto.getCategoria() == categoria)
                .forEach(producto -> System.out.println("  " + producto));
    }
    

    public void verCategorias() {
       
        categorias.forEach((key, value) -> System.out.println(key + " - " + value.getNombre()));
    }
    }
