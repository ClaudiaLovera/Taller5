package Ventana;

import Datos.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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


    public AgregarLibro(List<Libro> listaLibros) {
        super("Agregar libro");
        setContentPane(Panel5);
        setSize(400, 400);

        libroList = listaLibros;

        agregarButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }

            private void agregarLibro() {
                String isbn = isbnField.getText();
                String titulo = TituloField.getText();
                String autor = AutorField.getText();
                String categoria = CategoriaField.getText();

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

            private boolean libroExiste(String isbn) {
                for (Libro libro : libroList) {
                    if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                        return true;
                    }
                }

                return false;
            }

            //Método limpiarCampo() -> Se utiliza para reestablecer los campos de entrada después de
            //que se agrega un libro de forma exitosa
            private void reestablecerEntrada() {
                isbnField.setText("");
                TituloField.setText("");
                AutorField.setText("");
                CategoriaField.setText("");
            }

        });


    }
}


