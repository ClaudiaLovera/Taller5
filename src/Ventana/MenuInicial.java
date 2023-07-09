package Ventana;

import Datos.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuInicial extends JFrame {

    private List<Libro> libroList;
    BuscarLibro buscarLibro;
    AgregarLibro agregarLibro;
    PrestarLibro prestarLibro;
    DevolverLibro devolverLibro;
    private JButton buscarLibroButton;
    private JButton prestarLibroButton;
    private JButton agregarLibroButton;
    private JButton devolverLibroButton;
    private JPanel Panel2;


    public MenuInicial(List<Libro> libroList){
        super("Menu inicial");
        setContentPane(Panel2);
        setSize(400,400);
        this.libroList = libroList;

        buscarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(buscarLibro != null){
                    BuscarLibro buscarLibro = new BuscarLibro(libroList);
                    buscarLibro.setVisible(true);
                }
                else{
                    buscarLibro = new BuscarLibro(libroList);
                }
            }
        });
        agregarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(agregarLibro != null){
                    agregarLibro.setVisible(true);
                }else{
                    agregarLibro = new AgregarLibro(libroList);
                }
            }
        });
        prestarLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(prestarLibro != null){
                    prestarLibro.setVisible(true);
                }else{
                    prestarLibro = new PrestarLibro(libroList);
                }

            }
        });
        devolverLibroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(devolverLibro != null){
                    devolverLibro.setVisible(true);
                }else{
                    devolverLibro = new DevolverLibro(libroList);
                }
            }
        });
    }
}
