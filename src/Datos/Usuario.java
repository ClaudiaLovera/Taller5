package Datos;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

        private String nombre;
        private String apellido;
        private String rut;
        private String password;

    /**
     * Constructor de la clase
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param rut rut del usuario
     * @param password contraseña del usuario
     */
        public Usuario(String nombre, String apellido, String rut, String password) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.rut = rut;
            this.password = password;
        }

    /**
     * Obtiene el nombre del usuario
     * @return nombre del usuario
     */
    public String getNombre() {
            return nombre;
        }

    /**
     * Obtiene el apellido del usuario
     * @return
     */
    public String getApellido() {
            return apellido;
        }

    /**
     * Obtiene el rut del usuario
     * @return rut del usuario
     */
        public String getRut() {
            return rut;
        }

    /**
     * Obtiene la contraseña del usuario
     * @return contraseña del usuario
     */
        public String getPassword() {
            return password;
        }


}
