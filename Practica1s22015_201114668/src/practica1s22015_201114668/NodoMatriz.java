/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s22015_201114668;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author esdras
 */
public class NodoMatriz extends JLabel{
    NodoMatriz siguiente, anterior, arriba, abajo;
    String Tipo, Nombre;
    ImageIcon Fondo;
    
    
    public NodoMatriz getSiguiente(){
        return siguiente;
    }
    public NodoMatriz getAnterior(){
        return anterior;
    }
    public NodoMatriz getArriba(){
        return arriba;
    }
    public NodoMatriz getAbajo(){
        return abajo;
    }
    
    
    public NodoMatriz(String tipo, String nombre, ImageIcon fondo, NodoMatriz s, NodoMatriz ant, NodoMatriz up, NodoMatriz down){
        Tipo = tipo;
        Nombre = nombre;
        Fondo = fondo;
        this.setIcon(fondo);
        siguiente = s;
        anterior = ant;
        arriba = up;
        abajo = down;
    }
    public NodoMatriz(String tipo, String nombre, ImageIcon fondo){
        this(tipo, nombre, fondo, null, null, null, null);
    }
    
    
}
