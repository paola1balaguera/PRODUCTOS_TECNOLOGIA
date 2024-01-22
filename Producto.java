package pequeño;



public class Producto {
    private String nombre;
    private double precio;
    private int referencia;
    private int cantidad;
    private int categoria;

    public Producto(String nombre, double precio, int referencia, int cantidad, int categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
    
        @Override
        public String toString() {
            return  "Producto: " + " " + nombre + "\n" + 
                    "Precio :" + " " + precio +  "\n" +
                    "Referencia :" + " " + referencia +  "\n" +
                    "Cantidad :" + " " + cantidad +  "\n" +
                    "Categoria :" +  " " + categoria +
                    "\n"+ "---------------------------";
        }
}






