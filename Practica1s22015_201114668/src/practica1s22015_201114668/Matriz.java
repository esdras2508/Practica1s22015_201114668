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
public class Matriz {
    private NodoMatriz raiz;
    
    public Matriz(){
        raiz = null;
    }
    
    public boolean vacia(){
        return raiz == null;
    }
    
    public NodoMatriz getRaiz(){
        return raiz;
    }
}
