package pequeño;

 import java.util.InputMismatchException;
 import java.util.Scanner;
 
 public class interfaz {
     private static Scanner scanner = new Scanner(System.in);
     private static Inventario inventario = new Inventario();
 
     public static void main(String[] args) {
         int opcion=0;
         boolean continuar = true;
         while (continuar) {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next(); 
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    eliminarProducto();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    agregarCategoria();
                    break;
                case 5:
                    eliminarCategoria();
                    break;
                case 6:
                    verInventarioCategoria();
                    break;
                case 7:
                    verCategorias();
                    break;
                case 8:
                continuar = false;
                    System.out.println("PROGRAMA TERMINADO");
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        }

     }
 
     private static void mostrarMenu() {
        System.out.println("\n=== Menú ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Eliminar producto");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Agregar categoría");
        System.out.println("5. Eliminar categoría");
        System.out.println("6. Mostrar inventario por categoría");
        System.out.println("7. Mostrar categorías");
        System.out.println("8. Salir");
    }

 
     private static void agregarProducto() {
        try {
            
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Ingrese la referencia: ");
            int referencia = scanner.nextInt();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            inventario.verCategorias();
            System.out.print("Ingrese la categoría: ");
            int categoria = scanner.nextInt();

            Producto nuevoProducto = new Producto(nombre, precio, referencia, cantidad, categoria);
            inventario.agregar(nuevoProducto);
            System.out.println("PRODUCTO REGISTRADO");

        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor válido.");
            scanner.next(); 
        }
        //inventario.agregar(null);
     }
 
     private static void eliminarProducto() {
        try {
            System.out.print("Ingrese la referencia del producto a eliminar: ");
            int referenciaEliminar = scanner.nextInt();
            inventario.eliminar(referenciaEliminar);

            System.out.println("Revisa si tu producto ya no se encuentre en el inventario:");
            verCategorias();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor válido.");
            scanner.next(); 
        }
        //inventario.eliminar(0);;
     }
 
     private static void actualizarProducto() {
         //inventario.actualizar(0, null);
         try {
            System.out.print("Ingrese la referencia del producto a actualizar: ");
            int referenciaActualizar = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Ingrese el nuevo nombre del producto: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese el nuevo precio del producto: ");
            double nuevoPrecio = scanner.nextDouble();
            System.out.print("Ingrese la nueva cantidad del producto: ");
            int nuevaCantidad = scanner.nextInt();
            System.out.print("Ingrese la nueva categoría del producto: ");
            int nuevaCategoria = scanner.nextInt();

            Producto productoActualizado = new Producto(nuevoNombre, nuevoPrecio, referenciaActualizar, nuevaCantidad, nuevaCategoria);
            inventario.actualizar(referenciaActualizar, productoActualizado);

            System.out.println("Revisa el inventario, de tu producto actualizado:");
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor válido.");
            scanner.next();
        }
     }
 
     private static void agregarCategoria() {
         //inventario.agregarCategoria(0, null);
         try {
            System.out.println("NUEVA CATEGORIA");
            System.out.print("Ingrese el código: ");
            int codiguito = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();

            Categoria nuevaCategoria = new Categoria(codiguito, nombre);
            inventario.agregarCategoria(codiguito, nuevaCategoria);

            System.out.println("AGREGADO CORRECTAMENTE");
            verCategorias();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor válido.");
            scanner.next(); 
        }

     }
 
     private static void eliminarCategoria() {
         //inventario.eliminarCategoria(0);
         try {
            System.out.print("Ingrese el código de la categoría a eliminar: ");
            int codigoEliminar = scanner.nextInt();
            inventario.eliminarCategoria(codigoEliminar);
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor válido.");
            scanner.next();
        }
        }
 
     private static void verInventarioCategoria() {
        try {
            System.out.print("Ingrese el código de la categoría: ");
            int codigoCategoria = scanner.nextInt();
            inventario.verInventarioCategoria(codigoCategoria);
        } catch (InputMismatchException e) {
            System.out.println("Por favor, ingrese un valor válido.");
            scanner.next(); 
        }
     }
 
    private static void verCategorias() {
        //inventario.verCategorias();
        try {
            System.out.println("Categorías disponibles:");
            inventario.verCategorias();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

}