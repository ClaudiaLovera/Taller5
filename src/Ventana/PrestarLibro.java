package Ventana;

import Datos.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PrestarLibro extends JFrame{



    private List<Libro> libroList;
    private JButton buscarButton;
    private JTextField ISBNField;
    private JPanel Panel4;

    public PrestarLibro(List<Libro> listaLibros){


        super("Prestar libro");
        setContentPane(Panel4);
        setSize(400,400);
        libroList = listaLibros;



        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buscar();


            }
            private void buscar(){
                String isbn = ISBNField.getText();
                Libro libro = buscarLibroISBN(isbn);

                if (libro != null && libro.getNumCopias() > 0) {
                    //Realizar el préstamo del libro
                    libro.setNumCopias(libro.getNumCopias() - 1);
                    JOptionPane.showMessageDialog(PrestarLibro.this, "¡Préstamo exitoso!", "Información", JOptionPane.INFORMATION_MESSAGE);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(PrestarLibro.this, "No se puede prestar el libro con el ISBN "+ isbn +" ingresado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private Libro buscarLibroISBN(String isbn) {
                for (Libro libro : libroList) {
                    if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                        return libro;
                    }
                }

                return null;
            }

            /*
            private void regresarMenuInicial() {
            MenuInicial menuInicial = new MenuInicial();
                menuInicial.setVisible(true);
                //dispose() -> Se utiliza para cerrar la ventana y liberar los recursos utilizados
                PrestarLibro.this.dispose();
            }
             */


        });

    }

}
