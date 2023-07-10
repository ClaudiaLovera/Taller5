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

    /**
     * Arreglos usados para guardar la informacion
     */
    private static List<Libro> libroList = new ArrayList<>();
    private static List<Usuario> usuarioList = new ArrayList<>();
    public static void main(String[] args) {
        leerArchivoUsuarios();
        leerArchivoLibros();

        /**
         * Crea e inicia la ventana
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Crea la ventana enviandole los arreglos para su uso
                JFrame ventana = new Ventana(libroList,usuarioList);
                //Establece el tamaño de la ventana
                ventana.setSize(400,400);
                //Pone como visible la ventana
                ventana.setVisible(true);

                MenuInicial menuInicial = new MenuInicial(libroList);
                menuInicial.setVisible(true);

            }
        });

    }

    /**
     * Metodo para leer el archivo que contiene los libros
     */
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

                //Guarda el libro en una estructura de datos
                Libro libro = new Libro(isbn,title,author,category,copies,price);
                libroList.add(libro);



            }
            //Atrapa las excepciones de campo
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

                //Guarda el usuario en una estructura de datos
                Usuario usuario = new Usuario(name,rut,lastname,password);
                usuarioList.add(usuario);


            }
            //Atrapa las excepciones de campo
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }




}