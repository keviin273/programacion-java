package biblioteca;

public class MainBiblioteca {

    public static void main(String[] args) {
        // new Libro(); // no compila: al declarar constructores propios, el constructor
        //              // sin argumentos que regalaba el compilador dejó de existir.

        // Constructor de conveniencia (1 copia, precio por defecto)
        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "9780132350884");
        // Constructor canónico
        Libro libro2 = new Libro("Efectivo con Java", "Ana Restrepo", "9781234567897", 3, 22000.0);
        Libro libro3 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", "9780307474728", 2, 18500.0);

        // Rechazo 1: título vacío (el constructor informa el rechazo)
        Libro libroInvalido = new Libro("", "Autor Cualquiera", "9780000000000");
        boolean usoTituloPorDefecto = libroInvalido.getTitulo().equals("Sin título");

        // Rechazo 2: precio inválido en el setter
        double precioAnterior = libro1.getPrecioReposicion();
        boolean aceptado = libro1.setPrecioReposicion(-100.0);
        boolean precioConservado = libro1.getPrecioReposicion() == precioAnterior;
        System.out.println("¿Se aceptó el precio -100.0? " + aceptado
                + (!aceptado && precioConservado ? " (se mantiene el precio anterior)" : ""));
        System.out.println();

        libro1.mostrarFicha();
        libro2.mostrarFicha();
        libro3.mostrarFicha();

        // Agotar las copias de libro1 (tiene 1) y pedir una de más
        boolean prestamo1 = libro1.prestar();  // true
        boolean prestamo2 = libro1.prestar();  // false: no queda en negativo
        libro1.devolver();

        double anterior = libro1.getPrecioReposicion();
        if (libro1.setPrecioReposicion(18000.0)) {
            System.out.println("Precio de reposición actualizado de \"" + libro1.getTitulo() + "\": $"
                    + anterior + " -> $" + libro1.getPrecioReposicion());
        }
    }
}
