package ventana;
import Datos.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clase que contiene los objetos del panel buscarLibro
 */
public class BuscarLibro extends JFrame{
    private JTextField ISBNField1;
    private JButton buscarButton;
    private JPanel Panel3;

    private List<Libro> libroList;

    /**
     * Constructor de la clase
     * @param listaLibros arreglo de libros
     */
    public BuscarLibro(List<Libro> listaLibros) {

    //Titulo de la pestaña
    super("Buscar libro");
    setContentPane(Panel3);
    setSize(400,400);
    libroList = listaLibros;


        /**
         * Boton al que se le da una accion, en este caso al presionar el boton buscar
         */
    buscarButton.addActionListener(new ActionListener() {

            //Boton que actua segun el parametro que tiene dentro
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buscar();

            }

        /**
         * Metodo que busca el isbn y lo compara con los datos leidos desde teclado
         */
        private void buscar() {
                String isbn = ISBNField1.getText();
                Libro busqueda = buscarLibroISBN(libroList,isbn);

            //Si la busqueda es exitosa, se desplegara la informacion del librp
             if(busqueda != null){
                    mostrarDatosLibro(busqueda);

             }else{
                 JOptionPane.showMessageDialog(null,"Ese libro no existe");
             }
             }

        /**
         * Metodo que busca el libro  segun el isbn
         * @param libroList arreglo de libros
         * @param isbn codigo del libro
         * @return libro encontrado
         */
             private Libro buscarLibroISBN(List<Libro> libroList, String isbn) {
              for (Libro libro : libroList) {
                if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                    return libro;
                }
             }

             return null;
             }

        /**
         * Metodo que despliega los datos del libro
         * @param libro libro encontrado
         */
        private void mostrarDatosLibro(Libro libro) {
            String mensaje = "Título: " + libro.getTitulo() + "\n"
                    + "Autor: " + libro.getAutor() + "\n"
                    + "Categoría: " + libro.getCategoria() + "\n"
                    + "Número de copias: " + libro.getNumCopias();
            JOptionPane.showMessageDialog(BuscarLibro.this, mensaje, "Información del libro", JOptionPane.INFORMATION_MESSAGE);
            }



    });




}}
