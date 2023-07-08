import Datos.ListaUsuario;
import Datos.Usuario;
import Ventana.Ventana;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Ventana();
                frame.setSize(400,400);
                frame.setVisible(true);

            }
        });




    }

    public static void leerArchivoLibros() {



        // Leer el archivo "libros.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String isbn = chain[0];
                String title = chain[1];
                String author = chain[2];
                String category = chain[3];
                int copies = Integer.parseInt(chain[4]);
                int price = Integer.parseInt(chain[5]);

                //TODO: Guardar el libro en algúna estructura de datos.
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Método encargado de leer el archivo de "usuarios.txt".
     */
    public static void leerArchivoUsuarios() {

        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut = chain[0];
                String name = chain[1];
                String lastname = chain[2];
                String password = chain[3];

                ListaUsuario.add(new Usuario(name,rut,lastname,password));


                //TODO: Guardar el usuario en algúna estructura de datos.
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }




}