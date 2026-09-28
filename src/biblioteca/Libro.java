package biblioteca;
public class Libro {

    private static final String TITULO_POR_DEFECTO = "Sin título";
    private static final String AUTOR_POR_DEFECTO = "Autor desconocido";
    private static final String ISBN_POR_DEFECTO = "ISBN pendiente";
    private static final int COPIAS_POR_DEFECTO = 0;
    private static final double PRECIO_POR_DEFECTO = 15000.0;

    private final String titulo;
    private final String autor;
    private final String isbn;
    private int copiasDisponibles;
    private double precioReposicion;

    // Constructor canónico: único lugar donde vive la validación completa.
    public Libro(String titulo, String autor, String isbn, int copiasDisponibles, double precioReposicion) {
        if (esTextoInvalido(titulo)) {
            System.out.println("Título inválido, se usó \"" + TITULO_POR_DEFECTO + "\" por defecto.");
            this.titulo = TITULO_POR_DEFECTO;
        } else {
            this.titulo = titulo;
        }

        if (esTextoInvalido(autor)) {
            System.out.println("Autor inválido, se usó \"" + AUTOR_POR_DEFECTO + "\" por defecto.");
            this.autor = AUTOR_POR_DEFECTO;
        } else {
            this.autor = autor;
        }

        if (esTextoInvalido(isbn)) {
            System.out.println("ISBN inválido, se usó \"" + ISBN_POR_DEFECTO + "\" por defecto.");
            this.isbn = ISBN_POR_DEFECTO;
        } else {
            this.isbn = isbn;
        }

        if (copiasDisponibles < 0) {
            System.out.println("Copias inválidas (" + copiasDisponibles + "): no pueden ser negativas, se usó "
                    + COPIAS_POR_DEFECTO + " por defecto.");
            this.copiasDisponibles = COPIAS_POR_DEFECTO;
        } else {
            this.copiasDisponibles = copiasDisponibles;
        }

        // Arranca con el valor seguro; el setter lo reemplaza solo si el precio es válido.
        this.precioReposicion = PRECIO_POR_DEFECTO;
        if (!setPrecioReposicion(precioReposicion)) {
            System.out.println("Precio de reposición inválido (" + precioReposicion
                    + "): debe ser mayor a 0, se usó $" + PRECIO_POR_DEFECTO + " por defecto.");
        }
    }

    // Constructor de conveniencia: delega en el canónico, sin repetir validaciones.
    public Libro(String titulo, String autor, String isbn) {
        this(titulo, autor, isbn, 1, PRECIO_POR_DEFECTO);
    }

    // Regla de validación de texto, escrita una sola vez.
    private static boolean esTextoInvalido(String texto) {
        return texto == null || texto.isBlank();
    }

    // Regla de validación de precio, escrita una sola vez.
    private static boolean esPrecioValido(double precio) {
        return precio > 0; // también rechaza NaN
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public double getPrecioReposicion() {
        return precioReposicion;
    }

    public boolean setPrecioReposicion(double precio) {
        if (!esPrecioValido(precio)) {
            return false;
        }
        this.precioReposicion = precio;
        return true;
    }

    // No hay setCopiasDisponibles: prestar() y devolver() son la única puerta.
    public boolean prestar() {
        if (copiasDisponibles > 0) {
            copiasDisponibles--;
            System.out.println("Préstamo registrado: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
            return true;
        }
        System.out.println("Error: no hay copias disponibles de \"" + titulo + "\" para prestar.");
        return false;
    }

    public void devolver() {
        copiasDisponibles++;
        System.out.println("Devolución registrada: \"" + titulo + "\". Copias disponibles: " + copiasDisponibles);
    }

    public void mostrarFicha() {
        System.out.println("=== Ficha de libro ===");
        System.out.println("Título:  " + titulo);
        System.out.println("Autor:   " + autor);
        System.out.println("ISBN:    " + isbn);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Precio de reposición: $" + precioReposicion);
        System.out.println("=======================");
    }
}
