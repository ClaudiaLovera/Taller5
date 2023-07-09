package Datos;

public class Libro {

    private String titulo;
    private String autor;
    private String categoria;
    private int numCopias;
    private String isbn;
    private int precios;



    public Libro(String isbn, String titulo, String autor, String categoria, int numCopias, int precios) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.numCopias = numCopias;
        this.isbn = isbn;
        this.precios = precios;
    }

    public String toString(){
        return "Titulo: "+titulo+"Autor: "+autor+"Categoria: "+categoria+"Numero de copias: "+numCopias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumCopias() {
        return numCopias;
    }

    public void setNumCopias(int numCopias) {
        this.numCopias = numCopias;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrecios() {
        return precios;
    }

    public void setPrecios(int precios) {
        this.precios = precios;
    }
}
