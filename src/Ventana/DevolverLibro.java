package Ventana;

import Datos.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DevolverLibro extends JFrame{
    private JButton button1;
    private JTextField ISBNField;
    private JPanel Panel6;

    private List<Libro> libroList;
    public DevolverLibro(List<Libro> listaLibros){

    super("Devolver libro");
    setContentPane(Panel6);
    setSize(400,400);
    libroList = listaLibros;

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buscar();
            }
            private void buscar() {
                String isbn = ISBNField.getText();
                Libro libro = buscarLibroISBN(libroList,isbn);

                if(libro != null && libro.getNumCopias() > 0 ){
                    //Aumenta el numero de copias
                    libro.setNumCopias(libro.getNumCopias() + 1);
                    JOptionPane.showMessageDialog(null,"!DEVOLUCION EXITOSA¡: ");
                    dispose();


                }else{
                    JOptionPane.showMessageDialog(DevolverLibro.this, "No se puede prestar el libro con el ISBN "+ isbn +" ingresado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

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
