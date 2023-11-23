/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trini.whoiswho;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author asura En el caso de que los comentarios aparezcan sin tildes, se debe
 * a que uso teclado ingles
 */
public class Game {

    List<Personaje> personajes = null;
    List<Pregunta> preguntas = null;
    int indicePersonajeSolution = 0;
    JFrame frame = null;
    private String nombreJugador = "";
    Fichero fichero;
    List<Puntuacion> puntuaciones;

    public Game(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        personajes = new ArrayList();
        preguntas = new ArrayList();

    }

    void openPantalla() throws IOException {

        Respuesta respuesta = new Respuesta();
        Random ran = new Random();
        indicePersonajeSolution = ran.nextInt(9);
        System.out.println("Soy Jugador: " + nombreJugador + " solucion: " + indicePersonajeSolution);
        inicializarPersonaje(personajes, respuesta, indicePersonajeSolution);

        fichero = new Fichero();
        puntuaciones = fichero.leerFichero();

        frame = new JFrame("¿Quién parece quién?"); // Creo mi pantalla

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setSize(1000, 800); // dimensiones

        //Llama a la barra de menú
        JMenuBar mb = barraMenu();

        //Llamando a la función del panel de partida
        JPanel pantallaPartida = createGridlayout();

        //Llamando a la función del panel de botones
        JPanel parteBotones = parteInteractiva();

        //Llamando a la función del panel de preguntas
        JPanel parteVerde = partePreguntas(respuesta);

        //Llamando a la función del panel de respuesta
        JPanel parteRosa = parteRespuesta(respuesta);

        //Añado cada elemento a mi pantalla
        frame.getContentPane()
                .add(BorderLayout.NORTH, mb);
        frame.add(pantallaPartida);
        frame.add(parteVerde);
        frame.add(parteBotones);
        frame.add(parteRosa);
        frame.setVisible(
                true);

    }

    JMenuBar barraMenu() {
        //creando la barra de menu
        JMenuBar barraMenu = new JMenuBar();
        JMenu m1 = new JMenu("Menú");

        barraMenu.add(m1);

        JMenuItem m11 = new JMenuItem("Nueva Partida");
        m11.addActionListener(new ActionListener() { //para asignar acciones a los botones
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

                frame = new JFrame("¿Quién parece quién?"); // Creo mi pantalla

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(1000, 800); // dimensiones
                try {
                    // Game nuevoJuego = new Game(nombreJugador);
                    // nuevoJuego.openPantalla();
                    personajes = new ArrayList();
                    preguntas = new ArrayList();
                    openPantalla();
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        JMenuItem m22 = new JMenuItem("Puntuaciones");

        m22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame pantallaPuntuaciones = new JFrame("Mejores Puntuaciones");

                pantallaPuntuaciones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                pantallaPuntuaciones.setSize(400, 400);
                
                JTextArea muestraPuntuaciones = new JTextArea();
                String todoslospuntos = "";
                for (int i = 0; i <puntuaciones.size(); i++){
                    todoslospuntos = todoslospuntos 
                            + " Jugador: "+ puntuaciones.get(i).getNombre() 
                            +"    Puntos: "+ puntuaciones.get(i).getPuntos()+"\n";
                }
                
                pantallaPuntuaciones.add(muestraPuntuaciones);
                
                muestraPuntuaciones.setText(todoslospuntos);
                
                
                
                pantallaPuntuaciones.setVisible(true);

                

            }
        });

        m1.add(m11);

        m1.add(m22);

        return barraMenu;
    }

    JPanel createGridlayout() {
        JPanel pantallaPartida = new JPanel();
        pantallaPartida.setBackground(Color.cyan);

        //paso los botones a mi panel de partida       
        for (int i = 0; i < personajes.size(); i++) {
            pantallaPartida.add(personajes.get(i).getBoton());
        }

        //creo un tablero de 3x3   
        pantallaPartida.setLayout(new GridLayout(3, 3, 25, 25));
        pantallaPartida.setBounds(0, 23, 600, 600);
        pantallaPartida.setVisible(true);

        return pantallaPartida;
    }

    JPanel partePreguntas(Respuesta respuesta
    ) {
        //panel donde aparecen las preguntas
        JPanel partePreguntas = new JPanel();
        partePreguntas.setBackground(Color.yellow);
        partePreguntas.setBounds(600, 23, 400, 600);
        JLabel titulo = new JLabel("¿Ese personaje...");
        titulo.setFont(new Font("Arial", Font.PLAIN, 40));
        Personaje personajeSolucion = personajes.get(indicePersonajeSolution);

        Pregunta pregunta1 = new Pregunta("           es chica?         ", 0, respuesta, personajeSolucion);
        preguntas.add(pregunta1);

        Pregunta pregunta2 = new Pregunta("           es chico?         ", 1, respuesta, personajeSolucion);
        preguntas.add(pregunta2);

        Pregunta pregunta3 = new Pregunta("tiene el pelo rubio?", 2, respuesta, personajeSolucion);
        preguntas.add(pregunta3);

        Pregunta pregunta4 = new Pregunta("tiene el pelo rojo?", 3, respuesta, personajeSolucion);
        preguntas.add(pregunta4);

        Pregunta pregunta5 = new Pregunta("tiene el pelo oscuro?", 4, respuesta, personajeSolucion);
        preguntas.add(pregunta5);

        Pregunta pregunta6 = new Pregunta("tiene los ojos azules?", 5, respuesta, personajeSolucion);
        preguntas.add(pregunta6);

        Pregunta pregunta7 = new Pregunta("tiene los ojos marrones?", 6, respuesta, personajeSolucion);
        preguntas.add(pregunta7);

        Pregunta pregunta8 = new Pregunta("      tiene gafas?     ", 7, respuesta, personajeSolucion);
        preguntas.add(pregunta8);

        Pregunta pregunta9 = new Pregunta("es de piel oscura?", 8, respuesta, personajeSolucion);
        preguntas.add(pregunta9);

        partePreguntas.add(titulo);

        for (int i = 0; i < preguntas.size(); i++) {
            partePreguntas.add(preguntas.get(i).getPreguntaJLabel());
        }
        return partePreguntas;
    }

    JPanel parteInteractiva() {
        //panel con los botones preguntar y resolver
        JPanel parteInteractiva = new JPanel();

        JButton resolver = new JButton("Resolver");
        parteInteractiva.setBounds(600, 623, 400, 200);
        parteInteractiva.setBackground(Color.magenta);

        resolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int contadorPreguntas = 0;
                for (int i = 0; i < personajes.size(); i++) {
                    personajes.get(i).voyAResolver();

                    //sumarpuntaciones
                }
                for (int i = 0; i < preguntas.size(); i++) {
                    contadorPreguntas = contadorPreguntas + preguntas.get(i).getContadorPreguntas();
                }

                puntuaciones.add(new Puntuacion(nombreJugador, 9 - contadorPreguntas));

                try {
                    puntuaciones.sort(comparacionPuntuaciones());
                    if (puntuaciones.size() > 10) {
                        puntuaciones.remove(10);
                    }
                    fichero.escribirFichero(puntuaciones);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        parteInteractiva.add(resolver);

        return parteInteractiva;

    }

    JPanel parteRespuesta(Respuesta respuesta
    ) {
        //panel que muestra las respuestas
        JPanel parteRespuesta = new JPanel();
        parteRespuesta.setBackground(Color.pink);
        parteRespuesta.setLayout(null);

        parteRespuesta.add(respuesta.getRespuestaJLabel());
        

        return parteRespuesta;
    }

    private void setDefaultCloseOperation(int HIDE_ON_CLOSE) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void inicializarPersonaje(List lista, Respuesta respuesta, int indiceSolucion) {

        //Asigno mis iconos de personajes a los botones
        Icon brave = new ImageIcon("brave.jpeg");
        Icon draco = new ImageIcon("draco.jpg");
        Icon pepperann = new ImageIcon("pepperann.jpg");
        Icon daenerys = new ImageIcon("daenerys.jpg");
        Icon harry = new ImageIcon("harry.jpeg");
        Icon jon = new ImageIcon("jon_snow.jpg");
        Icon tiana = new ImageIcon("tiana.jpg");
        Icon bella = new ImageIcon("bella.jpg");
        Icon ron = new ImageIcon("ron.jpg");

        //plantilla de personajes
        Boolean soySolucion = false;
        if (indiceSolucion == 0) {
            soySolucion = true;
        }

        Personaje joncharacter = new Personaje(false,
                true, false, true,
                true, false, false,
                true, false, false,
                "Jon", respuesta, soySolucion, jon);

        lista.add(joncharacter);

        soySolucion = false;
        if (indiceSolucion == 1) {
            soySolucion = true;
        }
        Personaje bravecharacter = new Personaje(true,
                false, true, false,
                false, true, false,
                true, false, false,
                "Brave", respuesta, soySolucion, brave);
        lista.add(bravecharacter);

        soySolucion = false;
        if (indiceSolucion == 2) {
            soySolucion = true;
        }

        Personaje dracocharacter = new Personaje(false,
                true, true, false,
                false, false, true,
                true, false, false,
                "Draco", respuesta, soySolucion, draco);
        lista.add(dracocharacter);

        soySolucion = false;
        if (indiceSolucion == 3) {
            soySolucion = true;
        }

        Personaje daeneryscharacter = new Personaje(true,
                false, true, false,
                false, false, true,
                true, false, false,
                "Daenerys", respuesta, soySolucion, daenerys);
        lista.add(daeneryscharacter);

        soySolucion = false;
        if (indiceSolucion == 4) {
            soySolucion = true;
        }

        Personaje bellacharacter = new Personaje(true,
                false, false, true,
                true, false, false,
                true, false, false,
                "Bella", respuesta, soySolucion, bella);
        lista.add(bellacharacter);

        soySolucion = false;
        if (indiceSolucion == 5) {
            soySolucion = true;
        }

        Personaje roncharacter = new Personaje(false,
                true, true, false,
                false, true, false,
                true, false, false,
                "Ron", respuesta, soySolucion, ron);
        lista.add(roncharacter);

        soySolucion = false;
        if (indiceSolucion == 6) {
            soySolucion = true;
        }

        Personaje pepperanncharacter = new Personaje(true,
                false, false, true,
                false, true, false,
                true, false, true,
                "Pepperann", respuesta, soySolucion, pepperann);
        lista.add(pepperanncharacter);

        soySolucion = false;
        if (indiceSolucion == 7) {
            soySolucion = true;
        }

        Personaje tianacharacter = new Personaje(true,
                false, false, true,
                true, false, false,
                false, true, false,
                "Tiana", respuesta, soySolucion, tiana);
        lista.add(tianacharacter);

        soySolucion = false;
        if (indiceSolucion == 8) {
            soySolucion = true;
        }

        Personaje harrycharacter = new Personaje(false,
                true, true, false,
                true, false, false,
                true, false, true,
                "Harry", respuesta, soySolucion, harry);
        lista.add(harrycharacter);

    }

    private Comparator<Puntuacion> comparacionPuntuaciones() {
        return new Comparator<Puntuacion>() {
            @Override
            public int compare(Puntuacion p1, Puntuacion p2) {
                if (p1.getPuntos() > p2.getPuntos()) {
                    return -1;
                } else {
                    return 1;
                }

            }
        };
    }

}
