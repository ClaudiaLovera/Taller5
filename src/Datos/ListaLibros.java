package Datos;

import java.util.ArrayList;
import java.util.List;

public class ListaLibros {

   private static List<Libro> libros;

    public ListaLibros() {
        libros = new ArrayList<>();
    }

    public static void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public boolean existeISBN(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

}
