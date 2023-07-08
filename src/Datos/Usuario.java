package Datos;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

        private String nombre;
        private String apellido;
        private String rut;
        private String password;

        public Usuario(String nombre, String apellido, String rut, String password) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.rut = rut;
            this.password = password;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public String getRut() {
            return rut;
        }

        public String getPassword() {
            return password;
        }


}
