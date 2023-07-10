package Datos;

public class Libro {

    private String titulo;
    private String autor;
    private String categoria;
    private int numCopias;
    private String isbn;
    private int precios;


    /**
     * Constructor de la clase
     * @param isbn isbn del libro
     * @param titulo titulo del libro
     * @param autor autor del libro
     * @param categoria categoria del libro
     * @param numCopias numero de copias del libro
     * @param precios precio del libro
     */
    public Libro(String isbn, String titulo, String autor, String categoria, int numCopias, int precios) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.numCopias = numCopias;
        this.isbn = isbn;
        this.precios = precios;
    }

    /**
     * Metodo que entrega la informacion del libro
     * @return la informacion del libro
     */
    public String toString(){
        return "Titulo: "+titulo+"Autor: "+autor+"Categoria: "+categoria+"Numero de copias: "+numCopias;
    }

    /**
     * Obtiene el titulo del libro
     * @return titulo del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el titulo del libro
     * @param titulo nuevo titulo del libro
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro
     * @return el autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece un nuevo autor del libro
     * @param autor autor del libro
     */
    public void setAutor(String autor) {

        this.autor = autor;
    }

    /**
     * Obtiene el tipo de categoria que tiene el libro
     * @return categoria del libro
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece tipo de categoria que tiene el libro
     * @return categoria del libro
     */
    public void setCategoria(String categoria) {

        this.categoria = categoria;
    }

    /**
     * Obtiene el numero de copias que tiene el libro
     * @return numero de copias del libro
     */
    public int getNumCopias() {
        return numCopias;
    }

    /**
     * Establece el numero de copias que tiene el libro
     * @return numero de copias del libro
     */
    public void setNumCopias(int numCopias) {

        this.numCopias = numCopias;
    }

    /**
     * Obtiene el isbn del libro
     * @return isbn del libro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el isbn del libro
     * @return isbn del libro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Obtiene el precio del libro
     * @return precio del libro
     */
    public int getPrecios() {
        return precios;
    }

    /**
     * Establece el precio del libro
     * @return precio del libro
     */
    public void setPrecios(int precios) {
        this.precios = precios;
    }
}
