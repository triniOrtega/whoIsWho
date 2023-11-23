/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trini.whoiswho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asura
 */
public class Fichero {

    List<Puntuacion> leerFichero() throws IOException {
        List puntuaciones = new <Puntuacion>ArrayList();
        //FileReader
        FileReader ficheroPuntuaciones = null;
        BufferedReader br = null;
        try {
            ficheroPuntuaciones = new FileReader("puntuaciones.txt");
            br = new BufferedReader(ficheroPuntuaciones);

            String linea;
            linea = br.readLine();
            System.out.println(linea);
            
            String[] marcasIndividuales = linea.split(";");
            for (int i=0; i<marcasIndividuales.length; i++){
                String[] nombreypuntos = marcasIndividuales[i].split(":");
                int punto = Integer.parseInt(nombreypuntos[1]);
                puntuaciones.add(new Puntuacion (nombreypuntos[0],punto));
            }
            

        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.toString());
        } finally {
            try {
            br.close();
            ficheroPuntuaciones.close();
            } catch (IOException e2){
                System.out.println("Error cerrando el fichero: "+e2.toString() );
            }
        }

        return puntuaciones;
    }

    void escribirFichero(List<Puntuacion> puntuaciones) throws IOException {
        FileWriter ficheroPuntuaciones = null;
        PrintWriter pw = null;
        try {
            ficheroPuntuaciones = new FileWriter("puntuaciones.txt");
            pw = new PrintWriter(ficheroPuntuaciones);

            String datospuntuacion = "";
            for (int i = 0; i < puntuaciones.size(); i++) {
                Puntuacion puntuacion = puntuaciones.get(i);
                datospuntuacion = datospuntuacion + (puntuacion.getNombre()
                        + ":" + puntuacion.getPuntos() + ";");
            }
            pw.println(datospuntuacion);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
            ficheroPuntuaciones.close();
        }
    }

}
