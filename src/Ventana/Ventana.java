package Ventana;

import Datos.Libro;
import Datos.ListaUsuario;
import Datos.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Clase que contiene los objetos de la "ventana"
 */
public class Ventana extends JFrame{
    private static List<Libro> libroList;
    private static List<Usuario> usuariosList;
    private MenuInicial menuInicial;
    private JTextField rutField;
    private JTextField ContraseniaField;
    private JButton iniciarSesiónButton;
    private JButton cerrarProgramaButton;
    private JPanel Panel;

    /**
     * Constructor de la clase
     * @param listaLibros arreglo de libros
     * @param listaUsuarios arreglo de usuarios
     */
    public Ventana(List<Libro> listaLibros,List<Usuario> listaUsuarios){
        super("Iniciar sesion ");
        setContentPane(Panel);
        //Cierra la ventana al presionar la x de la ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        libroList = listaLibros;
        usuariosList = listaUsuarios;

        /**
         * Boton al que se le da una accion al presionarlo
         * Dispose() destruye la ventana
         */
        cerrarProgramaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                System.exit(0);
            }
        });

        /**
         * Boton al que se le da una accion, en este caso el de iniciar sesion
         */
        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ingresar();

            }

            //Metodo para iniciar sesion
            private void ingresar() {
                String rut = rutField.getText();
                String contrasenia = ContraseniaField.getText();
                //Busca al usuario en la lista según el RUT y la contraseña
                Usuario buscarUsuario = buscarUsuario(rut, contrasenia);

                //Si el usuario no es nulo, desplegara el mensaje
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
                    //Desplega un mensaje de error en caso de ingresar algun dato erroneo
                    JOptionPane.showMessageDialog(null, "Ha ingresado un dato erroneo...");

                }
            }

            //Método para buscar un usuario en la lista según el RUT y la contraseña ingresada
            private Usuario buscarUsuario(String rut, String contrasenia) {
                for (Usuario usuario : usuariosList) {
                    if (usuario.getRut().equalsIgnoreCase(rut) && usuario.getPassword().equals(contrasenia)) {
                        return usuario; //Se retorna el usuario si se encuentra
                    }
                }

                return null; //Retorna null si el usuario no se encuentra
            }




        });



    }


}
