/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1s22015_201114668;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author esdras
 */
public class ListaObjetos {
    
    private NodoListaObjetos inicio, fin;
    private int pos = 0;
    
    public ListaObjetos(){
        inicio = fin = null;
        
    }
    
    public boolean vacia(){
        return inicio == null;
    }
    
    //Obtener inicio o final de lista
    public NodoListaObjetos getInicio(){
        return inicio;
    }
    public NodoListaObjetos getFin(){
        return fin;
    }
    
    
    
    public void addFinal(String tipo, String nombre, ImageIcon fondo){
        if(!vacia()){
            pos++;
            fin = new NodoListaObjetos(tipo, nombre, pos, fondo, null, fin);
            fin.anterior.siguiente = fin;
        }else{
            pos++;
            inicio = fin = new NodoListaObjetos(tipo, nombre, pos, fondo);
        }
    }
    
    public void editar(String nombre, int posicion){
        NodoListaObjetos aux = getInicio();
        while(aux != null){
            if(aux.Posicion == posicion){
                aux.Nombre = nombre;
                JOptionPane.showMessageDialog(null, "Objeto editado exitosamente.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                break;
            }else {
                aux = aux.getSiguiente();
            }
        }
        
    }
    
    public void eliminar(int posicion){
        NodoListaObjetos aux = getInicio();
        while(aux != null){
            if(aux.Posicion == posicion){
                if(inicio == fin){
                    inicio = fin = null;
                    JOptionPane.showMessageDialog(null, "Objeto eliminado exitosamente. No hay mas objetos que mostrar se procedera a mostrar la pantalla de creacion de objetos.", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }else if(aux == this.getInicio()){
                    inicio = aux.siguiente;
                    aux.getSiguiente().anterior = null;
                    JOptionPane.showMessageDialog(null, "Objeto eliminado exitosamente. Actualizando vista de objetos...", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }else if(aux == this.getFin()){
                    fin = aux.anterior;
                    aux.getAnterior().siguiente = null;
                    JOptionPane.showMessageDialog(null, "Objeto eliminado exitosamente. Actualizando vista de objetos...", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }else{
                    aux.getAnterior().siguiente = aux.getSiguiente();
                    aux.getSiguiente().anterior = aux.getAnterior();
                    JOptionPane.showMessageDialog(null, "Objeto eliminado exitosamente. Actualizando vista de objetos...", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                
            }else{
                aux = aux.getSiguiente();
            }
        }
    }
    
    public void mostrarObjetos(){
        if(!vacia()){
            NodoListaObjetos aux = inicio;
        }
    }
}
