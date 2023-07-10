package ventana;

import Datos.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Clase que contiene los objetos del panel agregarLibro
 */
public class AgregarLibro extends JFrame {
    private JPanel Panel5;
    private JButton agregarButton;
    private JTextField CategoriaField;
    private JTextField numCopiasField;
    private JTextField AutorField;
    private JTextField TituloField;
    private JLabel Titulo;
    private JTextField precioField;
    private JTextField isbnField;
    private List<Libro> libroList;


    /**
     * Constructor de la clase
     * @param listaLibros arreglo que contiene los libros
     */
    public AgregarLibro(List<Libro> listaLibros) {
        //Titulo de la pestaña
        super("Agregar libro");
        setContentPane(Panel5);
        //Tamaño de la pestaña
        setSize(400, 400);

        libroList = listaLibros;

        /**
         * Boton al que se le da una accion, en este caso el de agregarlibro
         */
        agregarButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }

            /**
             * Metodo que agrega el libro, guardando los datos ingreados desde teclado, para luego compararlos(ISBN) y agregarlos
             */
            private void agregarLibro() {
                String isbn = isbnField.getText();
                String titulo = TituloField.getText();
                String autor = AutorField.getText();
                String categoria = CategoriaField.getText();

                /**
                 * Si el libro ya existe, se le desplegara un mensaje indicandolo
                 */
                if (libroExiste(isbn)) {
                    JOptionPane.showMessageDialog(AgregarLibro.this, "El libro con el ISBN: " + isbn + " ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    //Agregar nuevo libro a la lista
                    Libro nuevoLibro = new Libro(isbn, titulo, autor, categoria, 0, 0);
                    libroList.add(nuevoLibro);
                    JOptionPane.showMessageDialog(AgregarLibro.this, "¡El libro ha sido agregado exitosamente!", "Información", JOptionPane.INFORMATION_MESSAGE);
                    reestablecerEntrada();
                }
            }

            /**
             * Metodo que valida si el libro existe
             */
            private boolean libroExiste(String isbn) {
                for (Libro libro : libroList) {
                    if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                        return true;
                    }
                }

                return false;
            }

            /**
             * Método que reestablece los campos de entrada despues de que se agrega un libro
             */
            private void reestablecerEntrada() {
                isbnField.setText("");
                TituloField.setText("");
                AutorField.setText("");
                CategoriaField.setText("");
            }

        });


    }
}


