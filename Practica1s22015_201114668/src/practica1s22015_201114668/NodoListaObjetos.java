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
    
    public NodoListaObjetos(String tipo, String nombre){
        this(tipo, nombre, null, null);
    }
    
    public NodoListaObjetos(String tipo, String nombre, NodoListaObjetos s, NodoListaObjetos a){
        Tipo = tipo;
        Nombre = nombre;
        siguiente = s;
        anterior = a;
        
    }
    
}
