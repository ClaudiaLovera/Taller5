package Ventana;
import Datos.Libro;
import Datos.ListaLibros;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BuscarLibro extends JFrame{
    private JTextField ISBNField1;
    private JButton buscarButton;
    private JPanel Panel3;

    private List<Libro> libroList;

    public BuscarLibro(List<Libro> listaLibros) {

    super("Buscar libro");
    setContentPane(Panel3);
    setSize(400,400);
    libroList = listaLibros;


    buscarButton.addActionListener(new ActionListener() {

            //Boton que actua segun el parametro que tiene dentro
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buscar();

            }

            private void buscar() {
                String isbn = ISBNField1.getText();
                Libro busqueda = buscarLibroISBN(libroList,isbn);

             if(busqueda != null){
                    mostrarDatosLibro(busqueda);

             }else{
                 JOptionPane.showMessageDialog(null,"Ese libro no existe");
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

             private void mostrarDatosLibro(Libro libro) {
            String mensaje = "Título: " + libro.getTitulo() + "\n"
                    + "Autor: " + libro.getAutor() + "\n"
                    + "Categoría: " + libro.getCategoria() + "\n"
                    + "Número de copias: " + libro.getNumCopias();
            JOptionPane.showMessageDialog(BuscarLibro.this, mensaje, "Información del libro", JOptionPane.INFORMATION_MESSAGE);
            }



    });




}}
