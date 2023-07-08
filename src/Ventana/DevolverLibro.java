package Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DevolverLibro extends JFrame{
    private JButton button1;
    private JTextField ISBNField;
    private JPanel Panel6;

    public DevolverLibro(){

    super("Devolver libro");
    setContentPane(Panel6);
    setSize(400,400);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buscar();
            }
            private void buscar() {
                String isbn = ISBNField.getText();

                if(isbn.equals("34")){
                    JOptionPane.showMessageDialog(null,"!DEVOLUCION EXITOSA¡: ");
                    dispose();


                }else{
                    JOptionPane.showMessageDialog(null,"Ese libro no existe");
                }
            }
        });
    }
}
