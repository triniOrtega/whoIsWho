/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trini.whoiswho;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author asura
 */
public class Personaje {

    private Boolean mujer = true;
    private Boolean hombre = false;
    private Boolean ojosazules = false;
    private Boolean ojosmarrones = true;
    private Boolean pelonegro = true;
    private Boolean pelorojo = false;
    private Boolean pelorubio = false;
    private Boolean pielblanca = true;
    private Boolean pieloscura = false;
    private Boolean gafas = false;
    String name = "";
    Respuesta respuesta = null;
    private Boolean soySolucion = false;
    private JButton boton = null;
    private Boolean voyaresolver = false;

    public Personaje(boolean mujer,
            boolean hombre,
            boolean ojosazules,
            boolean ojosmarrones,
            boolean pelonegro,
            boolean pelorojo,
            boolean pelorubio,
            boolean pielblanca,
            boolean pieloscura,
            boolean gafas,
            String name,
            Respuesta respuesta,
            boolean soySolucion,
            Icon icon) {

        this.mujer = mujer;
        this.hombre = hombre;
        this.ojosazules = ojosazules;
        this.ojosmarrones = ojosmarrones;
        this.pelonegro = pelonegro;
        this.pelorojo = pelorojo;
        this.pelorubio = pelorubio;
        this.pielblanca = pielblanca;
        this.pieloscura = pieloscura;
        this.gafas = gafas;
        this.name = name;
        this.respuesta = respuesta;
        this.soySolucion = soySolucion;
        this.boton = new JButton(icon);
        addButtonHandler();

    }

    public JButton getBoton() {
        return boton;
    }

    public Boolean getMujer() {
        return mujer;
    }

    public void setMujer(Boolean mujer) {
        this.mujer = mujer;
    }

    public Boolean getHombre() {
        return hombre;
    }

    public void setHombre(Boolean hombre) {
        this.hombre = hombre;
    }

    public Boolean getOjosazules() {
        return ojosazules;
    }

    public void setOjosazules(Boolean ojosazules) {
        this.ojosazules = ojosazules;
    }

    public Boolean getOjosmarrones() {
        return ojosmarrones;
    }

    public void setOjosmarrones(Boolean ojosmarrones) {
        this.ojosmarrones = ojosmarrones;
    }

    public Boolean getPelonegro() {
        return pelonegro;
    }

    public void setPelonegro(Boolean pelonegro) {
        this.pelonegro = pelonegro;
    }

    public Boolean getPelorojo() {
        return pelorojo;
    }

    public void setPelorojo(Boolean pelorojo) {
        this.pelorojo = pelorojo;
    }

    public Boolean getPelorubio() {
        return pelorubio;
    }

    public void setPelorubio(Boolean pelorubio) {
        this.pelorubio = pelorubio;
    }

    public Boolean getPielblanca() {
        return pielblanca;
    }

    public void setPielblanca(Boolean pielblanca) {
        this.pielblanca = pielblanca;
    }

    public Boolean getPieloscura() {
        return pieloscura;
    }

    public void setPieloscura(Boolean pieloscura) {
        this.pieloscura = pieloscura;
    }

    public Boolean getGafas() {
        return gafas;
    }

    public void setGafas(Boolean gafas) {
        this.gafas = gafas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getSoySolucion() {
        return soySolucion;
    }

    public void setSoySolucion(Boolean soySolucion) {
        this.soySolucion = soySolucion;
    }

    public void voyAResolver() {
        this.voyaresolver = true;
    }

    private String getRespuestaTexto(Boolean b) {
        if (b) {
            return "Correcto";
        } else {
            return "Incorrecto";
        }

    }

    private void addButtonHandler() {
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (voyaresolver) {
                    if (soySolucion) {
                        respuesta.getRespuestaJLabel().setText("Correcto");
                    } else {
                        respuesta.getRespuestaJLabel().setText("Incorrecto");
                    }
                } else {
                    boton.setVisible(false);
                }

            }
        });

    }
}
