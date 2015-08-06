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
public class ListaObjetos {
    
    private NodoListaObjetos inicio, fin;
    
    public ListaObjetos(){
        inicio = fin = null;
        
    }
    
    public boolean vacia(){
        return inicio == null;
    }
    
    public void addFinal(String tipo, String nombre){
        if(!vacia()){
            fin = new NodoListaObjetos(tipo, nombre, null, fin);
            fin.anterior.siguiente = fin;
        }else{
            inicio = fin = new NodoListaObjetos(tipo, nombre);
        }
    }
    
    public void mostrarObjetos(){
        if(!vacia()){
            NodoListaObjetos aux = inicio;
        }
    }
}
