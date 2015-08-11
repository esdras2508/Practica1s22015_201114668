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
    String Numero;
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
    public String getNumero(){
        return Numero;
    }
    
    
    public void setTipo(String tipo){
        Tipo = tipo;
    } 
    public void setNombre(String nombre){
        Nombre = nombre;
    }
    public void setNumero(String numero){
        Numero = numero;
    }
    
    
    public NodoMatriz(String tipo, String nombre, String pos, ImageIcon fondo, NodoMatriz s, NodoMatriz ant, NodoMatriz up, NodoMatriz down){
        Tipo = tipo;
        Nombre = nombre;
        Numero = pos;
        Fondo = fondo;
        this.setIcon(fondo);
        siguiente = s;
        anterior = ant;
        arriba = up;
        abajo = down;
    }
    public NodoMatriz(String tipo, String nombre, String pos, ImageIcon fondo){
        this(tipo, nombre, pos, fondo, null, null, null, null);
    }
    
    
}
