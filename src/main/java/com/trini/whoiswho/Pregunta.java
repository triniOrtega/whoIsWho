/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trini.whoiswho;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author asura
 */
public class Pregunta {

    private JLabel pregunta;
    private int numeroPregunta;
    private Respuesta respuesta;
    private Personaje personajeSolucion;
    private int contadorPreguntas = 0;

    public Pregunta(String texto, int id, Respuesta respuesta, Personaje personajeSolucion) {
        this.numeroPregunta = id;
        pregunta = new JLabel(texto);//
        pregunta.setForeground(Color.black);
        pregunta.setFont(new Font("Arial", Font.PLAIN, 25));
        addInteraction(pregunta);
        this.respuesta = respuesta;
        this.personajeSolucion = personajeSolucion;
    }

    JLabel getPreguntaJLabel() {
        return pregunta;
    }

    public JLabel getPregunta() {
        return pregunta;
    }

    public int getNumeroPregunta() {
        return numeroPregunta;
    }

    private void addInteraction(JLabel interaction) {
        //para la interaccion con las preguntas
        interaction.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                contadorPreguntas++;
                switch (numeroPregunta) {
                    case 0:
                        boolean respuestaMujer = personajeSolucion.getMujer();
                        String respuestaTexto1 =  getRespuestaTexto(respuestaMujer);
                        respuesta.getRespuestaJLabel().setText(respuestaTexto1);
                        break;

                    case 1:
                        boolean respuestaHombre = personajeSolucion.getHombre();
                        String respuestaTexto2 = getRespuestaTexto(respuestaHombre);
                        respuesta.getRespuestaJLabel().setText(respuestaTexto2);
                        break;

                    case 2:
                        boolean respuestaRubio = personajeSolucion.getPelorubio();
                        String respuestaTexto3 = getRespuestaTexto(respuestaRubio);
                        respuesta.getRespuestaJLabel().setText(respuestaTexto3);
                        break;

                    case 3:
                        boolean respuestaRojo = personajeSolucion.getPelorojo();
                        String respuestaTexto4 = getRespuestaTexto(respuestaRojo);
                        respuesta.getRespuestaJLabel().setText(respuestaTexto4);
                        break;

                    case 4:
                        boolean respuestaNegro = personajeSolucion.getPelonegro();
                        String respuestaTexto5 = getRespuestaTexto(respuestaNegro);
                        respuesta.getRespuestaJLabel().setText(respuestaTexto5);
                        break;

                    case 5:
                        boolean respuestaOjosAzules = personajeSolucion.getOjosazules();
                        String respuestaTexto6 = getRespuestaTexto(respuestaOjosAzules);
                        respuesta.getRespuestaJLabel().setText(respuestaTexto6);
                        break;

                    case 6:
                        boolean respuestaOjosMarrones = personajeSolucion.getOjosmarrones();
                        String respuestaTexto7 = getRespuestaTexto(respuestaOjosMarrones);
                        respuesta.getRespuestaJLabel().setText(respuestaTexto7);
                        break;

                    case 7:
                        boolean respuestaGafas = personajeSolucion.getGafas();
                        String respuestaTexto8 = getRespuestaTexto(respuestaGafas);
                        respuesta.getRespuestaJLabel().setText(respuestaTexto8);
                        break;

                    case 8:
                        boolean respuestaPielOscura = personajeSolucion.getPieloscura();
                        String respuestaTexto9 = getRespuestaTexto(respuestaPielOscura);
                        respuesta.getRespuestaJLabel().setText(respuestaTexto9);
                        break;
                }
                //genera respuesta
                

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

    }

    public int getContadorPreguntas() {
        return contadorPreguntas;
    }

    public void setContadorPreguntas(int contadorPreguntas) {
        this.contadorPreguntas = contadorPreguntas;
    }
    
    private String getRespuestaTexto(Boolean b){
        if (b){
            return "Sí";
        } else {
            return "No";
        }
        
    }

}
