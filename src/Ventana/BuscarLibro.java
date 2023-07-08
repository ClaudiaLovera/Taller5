package Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarLibro extends JFrame{
    private JTextField ISBNField1;
    private JButton buscarButton;
    private JPanel Panel3;

    public BuscarLibro() {

    super("Buscar libro");
    setContentPane(Panel3);
    setSize(400,400);


    buscarButton.addActionListener(new ActionListener() {

            //Boton que actua segun el parametro que tiene dentro
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buscar();

            }

        private void buscar() {
            String isbn = ISBNField1.getText();

            if(isbn.equals("34")){
                JOptionPane.showMessageDialog(null,"Titulo: ");



            }else{
                JOptionPane.showMessageDialog(null,"Ese libro no existe");
            }
        }
    });



}}
