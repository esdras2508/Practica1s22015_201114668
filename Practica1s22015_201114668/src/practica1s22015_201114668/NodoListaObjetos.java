/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s22015_201114668;

/**
 *
 * @author esdras
 */
public class NodoListaObjetos {
    NodoListaObjetos siguiente;
    NodoListaObjetos anterior;
    String Tipo, Nombre;
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
    
    //Obtener Nodo siguiente o anterior
    public NodoListaObjetos getSiguiente(){
        return siguiente;
    }
    public NodoListaObjetos getAnterior(){
        return anterior;
    }
    
    public NodoListaObjetos(String tipo, String nombre, int posicion){
        this(tipo, nombre, posicion, null, null);
    }
    
    public NodoListaObjetos(String tipo, String nombre, int posicion, NodoListaObjetos s, NodoListaObjetos a){
        Tipo = tipo;
        Nombre = nombre;
        Posicion = posicion;
        siguiente = s;
        anterior = a;
        
    }
    
}
