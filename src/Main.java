import Datos.Libro;
import Datos.ListaLibros;
import Datos.ListaUsuario;
import Datos.Usuario;
import Ventana.Ventana;
import Ventana.BuscarLibro;
import Ventana.PrestarLibro;
import Ventana.MenuInicial;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static List<Libro> libroList = new ArrayList<>();
    private static List<Usuario> usuarioList = new ArrayList<>();
    public static void main(String[] args) {
        leerArchivoUsuarios();
        leerArchivoLibros();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ventana = new Ventana(libroList,usuarioList);
                ventana.setSize(400,400);
                ventana.setVisible(true);

                MenuInicial menuInicial = new MenuInicial(libroList);
                menuInicial.setVisible(true);

            }
        });

    }

    public static void leerArchivoLibros() {
        ListaLibros listaLibros = new ListaLibros();

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

                Libro libro = new Libro(isbn,title,author,category,copies,price);
                libroList.add(libro);

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

                Usuario usuario = new Usuario(name,rut,lastname,password);
                usuarioList.add(usuario);


                //TODO: Guardar el usuario en algúna estructura de datos.
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }




}