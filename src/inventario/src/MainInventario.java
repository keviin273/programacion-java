package gestioninventario;

public class MainInventario {

    public static void main(String[] args) {
        // Tres objetos distintos: cada new reserva su propio espacio en el Heap.
        Producto productoUno = new Producto();
        productoUno.codigo = "P-001";
        productoUno.nombre = "Teclado mecánico";
        productoUno.precio = 45000.0;
        productoUno.stock = 12;

        Producto productoDos = new Producto();
        productoDos.codigo = "P-002";
        productoDos.nombre = "Mouse inalámbrico";
        productoDos.precio = 18500.0;
        productoDos.stock = 40;

        Producto productoTres = new Producto();
        productoTres.codigo = "P-003";
        productoTres.nombre = "Monitor 24 pulgadas";
        productoTres.precio = 120000.0;
        productoTres.stock = 5;

        // Ejercitar los métodos sobre productoUno
        productoUno.mostrarFicha();
        productoUno.venderUnidades(3);
        productoUno.venderUnidades(50);   // error: stock insuficiente
        productoUno.reponerStock(20);
        productoUno.actualizarPrecio(39900.0);

        // Aliasing: copia NO es un objeto nuevo, es otra variable apuntando al mismo objeto.
        Producto copia = productoUno;
        copia.stock = 29;
        System.out.println("Stock de productoUno tras modificar copia: " + productoUno.stock
                + " (mismo objeto en el Heap)");

        // Objetos independientes y casos de error
        System.out.println();
        System.out.println("--- Objetos independientes y casos de error ---");
        productoDos.venderUnidades(2);
        productoTres.venderUnidades(0);   // error: cantidad inválida
        productoTres.reponerStock(-5);    // error: cantidad inválida
        System.out.println("Stock -> productoUno: " + productoUno.stock
                + ", productoDos: " + productoDos.stock
                + ", productoTres: " + productoTres.stock);
    }
}
