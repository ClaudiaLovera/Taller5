package Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicial extends JFrame {

    BuscarLibro buscarLibro;
    AgregarLibro agregarLibro;
    PrestarLibro prestarLibro;
    DevolverLibro devolverLibro;
    private JButton buscarLibroButton;
    private JButton prestarLibroButton;
    private JButton agregarLibroButton;
    private JButton devolverLibroButton;
    private JPanel Panel2;


    public MenuInicial(){
        super("Menu inicial");
        setContentPane(Panel2);
        setSize(400,400);

        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(buscarLibro != null){
                    buscarLibro.setVisible(true);
                }
                else{
                    buscarLibro = new BuscarLibro();
                }
            }
        });
        agregarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(agregarLibro != null){
                    agregarLibro.setVisible(true);
                }else{
                    agregarLibro = new AgregarLibro();
                }
            }
        });
        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(prestarLibro != null){
                    prestarLibro.setVisible(true);
                }else{
                    prestarLibro = new PrestarLibro();
                }

            }
        });
        devolverLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(devolverLibro != null){
                    devolverLibro.setVisible(true);
                }else{
                    devolverLibro = new DevolverLibro();
                }
            }
        });
    }
}
