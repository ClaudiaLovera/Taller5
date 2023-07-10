package ventana;

import Datos.Libro;
import Datos.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Clase que representa la ventana de inicio de sesión
 */
public class Ventana extends JFrame {
    private static List<Libro> libroList;
    private static List<Usuario> usuarioList;
    private MenuInicial menuInicial;
    private JTextField rutField;
    private JTextField ContraseniaField;
    private JButton iniciarSesionButton;
    private JButton cerrarProgramaButton;
    private JPanel Panel;

    /**
     * Constructor de la clase
     * @param listaLibros ; Lista de libros
     * @param listaUsuarios ; Lista de Usuarios
     */
    public Ventana(List<Libro> listaLibros, List<Usuario> listaUsuarios) {
        super("Iniciar Sesion");
        setContentPane(Panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        libroList = listaLibros;
        usuarioList = listaUsuarios;
        //Se le da una acción al botón 'Cerrar Programa'
        cerrarProgramaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                System.exit(0);
            }
        });

        //Se le da una acción al botón 'Iniciar Sesión'
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ingresar();
            }

            /**
             * Método para iniciar sesión
             */
            private void ingresar() {
                String rut = rutField.getText();
                String password = ContraseniaField.getText();
                //Buscar al usuario en la lista según el RUT y la contraseña
                Usuario buscarUsuario = buscarUsuario(rut, password);

                //Si el usuario es valido, muestra un mensaje y abre la ventan de Menú Inicial
                if (buscarUsuario != null) {
                    JOptionPane.showMessageDialog(null, "¡Ingreso Valido!");

                    if (menuInicial != null) {
                        //Mostrar por ventana si ya existe
                        menuInicial.setVisible(true);

                    } else {
                        //Nueva instancia en Menú Inicial
                        menuInicial = new MenuInicial(libroList);
                    }

                } else {
                    //Muestra un mensaje de error si los datos son incorrectos
                    JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo...");

                }
            }

            /**Método para buscar un usuario en la lista según el RUT y la contraseña ingresada
             *
             * @param rut ; RUT del usuario
             * @param password ; Contraseña del usuario
             * @return Retorna usuario si se encuentra, o null si no
             */
            private Usuario buscarUsuario(String rut, String password) {
                for (Usuario usuario : usuarioList) {
                    if (usuario.getRut().equalsIgnoreCase(rut) && usuario.getPassword().equalsIgnoreCase(password)) {
                        return usuario; //Se retorna el usuario si se encuentra
                    }
                }

                return null; //Retorna null si el usuario no se encuentra
            }

            /**
             * Método para crear un archivo con los datos de los usuarios y libros prestados
             */
            private void crearArchivo() {
                try (PrintWriter writer = new PrintWriter(new FileWriter("registro.txt"))) {
                    // Recorrer la lista de usuarios
                    for (Usuario usuario : usuarioList) {
                        //Recorrer la lista de libros prestados
                        for (Libro libro : libroList) {
                            //Escribir los datos en el archivo
                            writer.println(usuario.getRut() + ", " + usuario.getNombre() + ", " + usuario.getApellido() + ", " + libro.getIsbn() + ", " + libro.getTitulo() + ", " + "Tipo de transacción");
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error al crear el archivo: " + e.getMessage());
                }
            }

        });

    }

}