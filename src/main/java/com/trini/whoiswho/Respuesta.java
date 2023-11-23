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
public class Respuesta {

    private JLabel respuesta;
    
    public Respuesta() {
                
        respuesta = new JLabel();
        respuesta.setBounds(220, 620, 300, 100);

        respuesta.setFont(new Font("Arial", Font.PLAIN, 40));
        respuesta.setForeground(Color.black);
        
    }
    
    JLabel getRespuestaJLabel(){
        return respuesta;
    }

    
}
