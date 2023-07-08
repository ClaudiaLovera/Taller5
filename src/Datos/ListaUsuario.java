package Datos;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ListaUsuario {


    private List<Usuario> usuarios;

    public ListaUsuario() {
        usuarios = new ArrayList<>();
    }



    public static void add(Usuario usuario) {
    }


    public List<Usuario> obtenerUsuarios() {
            return usuarios;}

    public Usuario buscarUsuarioPorUsername(String rut) {
            for (Usuario usuario : usuarios) {
                if (usuario.getRut().equals(rut)) {
                    return usuario;
                }
            }
            return null;

        }

}
