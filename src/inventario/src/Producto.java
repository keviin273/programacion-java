package gestioninventario;

public class Producto {

    public String nombre;
    public String codigo;
    public double precio;
    public int stock;

    public void venderUnidades(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: cantidad inválida (" + cantidad + ") para vender "
                    + nombre + ", debe ser mayor a cero.");
        } else if (cantidad > stock) {
            System.out.println("Error: stock insuficiente para vender " + cantidad
                    + " unidades de " + nombre + ".");
        } else {
            stock -= cantidad;
            System.out.println("Venta realizada: " + cantidad + " unidades de " + nombre
                    + ". Stock restante: " + stock);
        }
    }

    public void reponerStock(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
            System.out.println("Reposición registrada: +" + cantidad + " unidades. Stock actual: " + stock);
        } else {
            System.out.println("Error: cantidad inválida (" + cantidad + ") para reponer "
                    + nombre + ", debe ser mayor a cero.");
        }
    }

    // El parámetro se llama igual que el atributo (sombreamiento intencional):
    // "precio" solo es el parámetro; "this.precio" es el atributo del objeto.
    public void actualizarPrecio(double precio) {
        double precioAnterior = this.precio;
        this.precio = precio;
        System.out.println("Precio actualizado de " + nombre + ": $" + precioAnterior + " -> $" + this.precio);
    }

    public void mostrarFicha() {
        System.out.println("=== Ficha de producto ===");
        System.out.println("Código:  " + codigo);
        System.out.println("Nombre:  " + nombre);
        System.out.println("Precio:  $" + precio);
        System.out.println("Stock:   " + stock);
        System.out.println("==========================");
    }
}
