package Ventana;

import javax.swing.*;

public class AgregarLibro extends JFrame {
    private JPanel Panel5;
    private JButton agregarButton;
    private JTextField CategoriaField;
    private JTextField textField2;
    private JTextField AutorField;
    private JTextField TituloField;
    private JLabel Titulo;

    public AgregarLibro(){
        super("Agregar libro");
        setContentPane(Panel5);
        setSize(400,400);
    }
}
