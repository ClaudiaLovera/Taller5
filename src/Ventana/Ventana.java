package Ventana;

import Datos.ListaUsuario;
import Datos.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{

    private MenuInicial menuInicial;
    private JTextField rutField;
    private JTextField ContraseniaField;
    private JButton iniciarSesiónButton;
    private JButton cerrarProgramaButton;
    private JPanel Panel;
    ListaUsuario listaUsuario;

    public Ventana(){
        super("Iniciar sesion ");
        setContentPane(Panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        cerrarProgramaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                System.exit(0);
            }
        });
        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ingresar();

            }

            private void ingresar(){
                String rut = rutField.getText();
                String contrasenia = ContraseniaField.getText();

                if(rut.equals("87") && contrasenia.equals("hola")){
                    JOptionPane.showMessageDialog(null, "Ingreso Valido");
                    if(menuInicial != null){
                        menuInicial.setVisible(true);
                    }else{
                        menuInicial = new MenuInicial();
                    }


                }
                else{
                    JOptionPane.showMessageDialog(null, "¡RUT o contraseña INVALIDOS!");
                }
            }
        });



    }


}
