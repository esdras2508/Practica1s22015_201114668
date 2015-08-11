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
    public  int posFila = 0, PosCol=0;
    
    public Matriz(){
        raiz = null;
    }
    
    public boolean vacia(){
        return raiz == null;
    }
    
    public NodoMatriz getRaiz(){
        return raiz;
    }
    
    public void addFila(){
        if(!vacia()){
            NodoMatriz aux1 = getRaiz();
            while(aux1.getArriba() != null){
                aux1 = aux1.getArriba();
            }
            NodoMatriz aux2 = aux1;
            
            String Posicion = ""+posFila+"0";
            aux1.arriba = new NodoMatriz("vacio", "vacio", Posicion, null);
            aux1.arriba.abajo = aux1;
            aux1 = aux1.arriba;
            posFila++;
            for (int c =1; c < PosCol; c++) {
                String Posicion2 = ""+(posFila -1)+""+c;
                aux1.siguiente = new NodoMatriz("vacio", "vacio", Posicion2, null);
                aux1.siguiente.anterior = aux1;
                aux2 = aux2.getSiguiente();
                aux1 = aux1.getSiguiente();
                
                aux1.abajo = aux2;
                aux2.arriba = aux1;
            }
        }else{
            raiz = new NodoMatriz("vacio", "vacio", "00", null);
            posFila++;
            addCol();
            addFila();
        }
    }

    public void addCol() {
        if(PosCol == 0){
            NodoMatriz aux = getRaiz();
            for (PosCol = 1;  PosCol < 4; PosCol++) {
                String pos = "0"+PosCol;
                aux.siguiente = new NodoMatriz("vacio", "vacio", pos, null);
                aux.siguiente.anterior = aux;
                aux = aux.getSiguiente();
            }
        }else{
            NodoMatriz aux1 = getRaiz();
            
            while(aux1.siguiente != null){
                aux1 = aux1.getSiguiente();
            }
            NodoMatriz aux2 = aux1;
            String pos2 = "0"+(PosCol);
            aux1.siguiente = new NodoMatriz("vacio", "vacio", pos2, null);
            aux1.siguiente.anterior = aux1;
            aux1 = aux1.siguiente;
            PosCol++;
            for(int c = 1; c < posFila; c++){
                String pos3 = ""+c+""+(PosCol-1);
                aux1.arriba = new NodoMatriz("vacio", "vacio", pos3, null);
                aux1.arriba.abajo = aux1;
                aux2 = aux2.getArriba();
                aux1 = aux1.getArriba();
                
                aux1.anterior = aux2;
                aux2.siguiente = aux1;
            }
        }
    }
}
