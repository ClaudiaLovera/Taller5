package Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrestarLibro extends JFrame{
    private JButton buscarButton;
    private JTextField ISBNField;
    private JPanel Panel4;

    public PrestarLibro(){
        super("Prestar libro");
        setContentPane(Panel4);
        setSize(400,400);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buscar();
            }

            private void buscar() {
                String isbn = ISBNField.getText();

                if(isbn.equals("34")){
                    JOptionPane.showMessageDialog(null,"!PRESTAMO EXITOSO¡: ");
                    dispose();


                }else{
                    JOptionPane.showMessageDialog(null,"Ese libro no existe");
                }
            }
        });

    }
}
