package Ventana;

import Datos.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clase que contiene los objetos del panel devolverLibro
 */
public class DevolverLibro extends JFrame{
    private JButton button1;
    private JTextField ISBNField;
    private JPanel Panel6;

    private List<Libro> libroList;

    /**
     * Constructor de la clase
     * @param listaLibros arreglo de libros
     */
    public DevolverLibro(List<Libro> listaLibros){

        //Titulo de la pestaña
    super("Devolver libro");
    setContentPane(Panel6);
    setSize(400,400);
    libroList = listaLibros;

        /**
         * Boton al que se le da una accion, en este caso al presionar el boton de buscar
         */
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buscar();
            }

            /**
             * Metodo que busca el libro, comparando con los datos leidos desde el panel
             */
            private void buscar() {
                String isbn = ISBNField.getText();
                Libro libro = buscarLibroISBN(libroList,isbn);

                /**
                 * Si el libro existe, se agregara 1 a la lista
                 */
                if(libro != null && libro.getNumCopias() > 0 ){
                    //Aumenta el numero de copias
                    libro.setNumCopias(libro.getNumCopias() + 1);
                    JOptionPane.showMessageDialog(null,"!DEVOLUCION EXITOSA¡: ");
                    dispose();


                }else{
                    JOptionPane.showMessageDialog(DevolverLibro.this, "No se puede prestar el libro con el ISBN "+ isbn +" ingresado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            /**
             * Metodo que busca el libro segun el isbn
             * @param libroList arreglo de libros
             * @param isbn codigo del libro
             * @return
             */
            private Libro buscarLibroISBN(List<Libro> libroList, String isbn) {
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
