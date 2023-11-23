/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trini.whoiswho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author asura
 */
public class InterfaceIntro {

    String nombreJugador;

    InterfaceIntro() {

        JFrame frame = new JFrame("¿Quién parece quién?"); // Creo mi pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setSize(1050, 400); // dimensiones

        JPanel centro = new JPanel();
        centro.setBackground(Color.cyan);

        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("imagen_intro.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            centro.add(picLabel);
        } catch (IOException ex) {
            System.out.println("No se ha podido encontrar la imagen");
            //Si no existe la imagen da error
        }
        JTextField introIniciales = new JTextField();
        introIniciales.setBounds(50, 260, 200, 30);
        introIniciales.setText("Mis Iniciales");
        frame.add(introIniciales);

        //Crea la barra de abajo con los botones
        JPanel barra = new JPanel();
        JButton empezar = new JButton("Empezar");

        empezar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreJugador = introIniciales.getText();
                Game pantallaJuego = new Game(nombreJugador);
                try {
                    pantallaJuego.openPantalla();
                } catch (IOException ex) {
                    Logger.getLogger(InterfaceIntro.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        JButton salir = new JButton("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        barra.add(empezar);
        barra.add(salir);

        //Situacion en el espacio de mis elementos
        frame.getContentPane().add(BorderLayout.SOUTH, barra);
        frame.getContentPane().add(BorderLayout.CENTER, centro);
        frame.setVisible(true);

    }

}
