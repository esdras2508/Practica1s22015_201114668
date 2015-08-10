/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s22015_201114668;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author esdras
 */
public class NodoListaObjetos extends JLabel{
    NodoListaObjetos siguiente;
    NodoListaObjetos anterior;
    String Tipo, Nombre;
    ImageIcon imagen;
    int Posicion;
    
    //Obtener datos del nodo
    public String getTipo(){
        return Tipo;
    }
    public String getNombre(){
        return Nombre;
    }
    public int getPosicion(){
        return Posicion;
    }
    public ImageIcon getImagen(){
        return imagen;
    }
    
    //Obtener Nodo siguiente o anterior
    public NodoListaObjetos getSiguiente(){
        return siguiente;
    }
    public NodoListaObjetos getAnterior(){
        return anterior;
    }
    
    public NodoListaObjetos(String tipo, String nombre, int posicion, ImageIcon imagen){
        this(tipo, nombre, posicion, imagen, null, null);
    }
    
    public NodoListaObjetos(String tipo, String nombre, int posicion, ImageIcon vista, NodoListaObjetos s, NodoListaObjetos a){
        Tipo = tipo;
        Nombre = nombre;
        Posicion = posicion;
        imagen = vista;
        this.setIcon(vista);
        siguiente = s;
        anterior = a;
        
    }
    
}
