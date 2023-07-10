package Ventana;

import Datos.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clase que contiene los objetos de el panel prestarLibro
 */
public class PrestarLibro extends JFrame{

    private List<Libro> libroList;
    private JButton buscarButton;
    private JTextField ISBNField;
    private JPanel Panel4;

    /**
     * Constructor de la clase
     * @param listaLibros arreglo de libros
     */
    public PrestarLibro(List<Libro> listaLibros){


        //Titulo de la pestaña
        super("Prestar libro");
        setContentPane(Panel4);
        setSize(400,400);
        libroList = listaLibros;


        /**
         * Boton al que se le da una accion, en este caso al presionar buscar, se buscara el libro a prestar
         */

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buscar();


            }

            /**
             * Metodo para buscar el libro, obteniendo el dato leido desde teclado
             */
            private void buscar(){
                String isbn = ISBNField.getText();
                Libro libro = buscarLibroISBN(isbn);

                /**
                 * Si el libro existe, se disminuira en 1 la cantidad total de libros
                 */
                if (libro != null && libro.getNumCopias() > 0) {
                    //Realizar el préstamo del libro
                    libro.setNumCopias(libro.getNumCopias() - 1);
                    JOptionPane.showMessageDialog(PrestarLibro.this, "¡Préstamo exitoso!", "Información", JOptionPane.INFORMATION_MESSAGE);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(PrestarLibro.this, "No se puede prestar el libro con el ISBN "+ isbn +" ingresado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            /**
             * Metodo que busca el libro segun el isbn
             * @param isbn codigo del libro
             * @return libro
             */
            private Libro buscarLibroISBN(String isbn) {
                for (Libro libro : libroList) {
                    if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                        return libro;
                    }
                }

                return null;
            }



        });

    }

}
