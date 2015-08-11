/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import static java.awt.event.MouseEvent.MOUSE_CLICKED;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import practica1s22015_201114668.Matriz;
import practica1s22015_201114668.NodoListaObjetos;
import practica1s22015_201114668.NodoMatriz;

/**
 *
 * @author esdras
 */
public class Tablero extends javax.swing.JFrame {

    Matriz juego = new Matriz();
    NodoMatriz dibujo;
    public int posX, columnas;
    public int posY, filas;
    public NodoMatriz aux;
    public String tipoDatos;
    
    /**
     * Creates new form Tablero
     */
    public NodoListaObjetos objetos;
    Tablero(NodoListaObjetos fin, String datos) {
        initComponents();
        objetos = fin;
        tipoDatos = datos;
        
        juego.addFila();
        dibujar(juego);
        
        objLista.setBounds(500,20, 250,150);
        objLista.setOpaque(true);    
        ImageIcon p = new ImageIcon(objetos.getImagen().getImage().getScaledInstance(75, 75, BufferedImage.SCALE_SMOOTH));
        objLista.setIcon(p);
        String texto = "<html><body>Tipo: "+objetos.getTipo() + " <br> Nombre: "+objetos.getNombre()+" </body></html>";
        objLista.setText(texto);
        p.setImageObserver(objLista);
        //add(objetos);
        
        
        
        
    }
    
    public void dibujar(Matriz tablero){
        dibujo = tablero.getRaiz();
        //clic probar = new clic();
        aux = dibujo;
        posX = 10;
        posY = 500;
       
       
        for(int c1 = 0; c1 < tablero.posFila; c1++){
            for(int c=0; c < tablero.PosCol; c++){
                dibujo.setBounds(posX,posY, 80,80);
                dibujo.setOpaque(true);
                dibujo.setNumero(""+c1+c);
                dibujo.setBackground(Color.CYAN);
                javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

                dibujo.setBorder(border);
                dibujo.setName(""+c1+c);
                add(dibujo);
                
                MouseListener ml = new MouseListener() {
                        @Override
                        public void mouseReleased(MouseEvent e) {System.out.println("Released!");}

                        @Override
                        public void mousePressed(MouseEvent e) {
                            String numero = ((JLabel)e.getSource()).getName();
                            
                            //((JLabel)e.getSource()).setIcon(objetos.getIcon());
                            ((JLabel)e.getSource()).setIcon(new ImageIcon(objetos.getImagen().getImage().getScaledInstance(75, 75, BufferedImage.SCALE_SMOOTH)));
                            editarMatriz(objetos.getTipo(), objetos.getNombre(), numero);
                            
                            MostrarObjetos();
                            System.out.println("Pressed!" + numero);
                            //dibujo.setIcon(objetos.getIcon());
                            
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {System.out.println("Exited!");}

                        @Override
                        public void mouseEntered(MouseEvent e) {System.out.println("Entered!");}

                        @Override
                        public void mouseClicked(MouseEvent e) {System.out.println("Clicked!");}

                    
                };
                 dibujo.addMouseListener(ml);
                
                
                
                /*dibujo.addMouseMotionListener(new MouseMotionAdapter() {
                    
                    @Override
                    public void mouseDragged(MouseEvent arg0){
                        ImageIcon copiar = new ImageIcon(objetos.getImagen().getImage().getScaledInstance(75, 75, BufferedImage.SCALE_SMOOTH));
                        dibujo.setIcon(copiar);
                    }
});*/
                
                posX = posX + 80;
                dibujo = dibujo.getSiguiente();
                columnas++;
            }
            posY = posY - 80;
            columnas = posX;
            posX = 10;
            dibujo = aux.getArriba();
            aux = aux.getArriba();
            filas++;
        }
        
    }
  
    
    public void editarMatriz(String tipo, String nombre, String numero) {
        NodoMatriz llenar = juego.getRaiz();
        NodoMatriz auxBuscar = llenar;
        
        for(int c = 0; c < juego.posFila; c++){
            for(int c1 = 0; c1 < juego.PosCol; c1++){
               if(!llenar.getNumero().equals(numero)){
                    llenar = llenar.getSiguiente();
                }else{
                   llenar.setTipo(tipo);
                   llenar.setNombre(nombre);
                   c = juego.posFila +1;
                    break;
                    
                } 
            }
            auxBuscar = auxBuscar.getArriba();
            llenar = auxBuscar;
        }
        
    }
    
    public void MostrarObjetos(){
        if(tipoDatos.equals("pila")){
            objetos = objetos.getAnterior();
        }else if(tipoDatos.equals("cola")){
            objetos = objetos.getSiguiente();
        }
        
        objLista.setBounds(500,20, 250,150);
            objLista.setOpaque(true);
            ImageIcon p = new ImageIcon(objetos.getImagen().getImage().getScaledInstance(75, 75, BufferedImage.SCALE_SMOOTH));

            objLista.setIcon(p);

            String texto = "<html><body>Tipo: "+objetos.getTipo() + " <br> Nombre: "+objetos.getNombre()+" </body></html>";
            objLista.setText(texto);
            p.setImageObserver(objLista);
            //add(objetos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        objLista = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("GRAFICAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ELIMINAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jButton3.setText("Agregar Fila");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Agregar Columna");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButton3)
                        .addGap(37, 37, 37)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(objLista, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(objLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4))))
                .addContainerGap(379, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        juego.addFila();
        
        aux = juego.getRaiz();
        while(aux.getArriba() != null){
            aux = aux.getArriba();
        }
        
        dibujo = aux;
        posX = 10;
        //posY = 500;
       
       
            for(int c=0; c < juego.PosCol; c++){
                dibujo.setBounds(posX,posY, 80,80);
                dibujo.setOpaque(true);
                dibujo.setBackground(Color.CYAN);
                javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

                dibujo.setBorder(border);
                add(dibujo);
                
                MouseListener ml = new MouseListener() {
                        @Override
                        public void mouseReleased(MouseEvent e) {System.out.println("Released!");}

                        @Override
                        public void mousePressed(MouseEvent e) {
                            String numero = ((JLabel)e.getSource()).getName();
                            
                            //((JLabel)e.getSource()).setIcon(objetos.getIcon());
                            ((JLabel)e.getSource()).setIcon(new ImageIcon(objetos.getImagen().getImage().getScaledInstance(75, 75, BufferedImage.SCALE_SMOOTH)));
                            editarMatriz(objetos.getTipo(), objetos.getNombre(), numero);
                            
                            MostrarObjetos();
                            System.out.println("Pressed!" + numero);
                            //dibujo.setIcon(objetos.getIcon());
                            
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {System.out.println("Exited!");}

                        @Override
                        public void mouseEntered(MouseEvent e) {System.out.println("Entered!");}

                        @Override
                        public void mouseClicked(MouseEvent e) {System.out.println("Clicked!");}

                    
                };
                 dibujo.addMouseListener(ml);
                
                posX = posX + 80;
                dibujo = dibujo.getSiguiente();
                
            }
            posY = posY - 80;
        
            actualizarPantalla();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    public void actualizarPantalla(){
        
        SwingUtilities.updateComponentTreeUI(this); 
        
        synchronized(getTreeLock()) {
            this.validateTree(); 
        }
    } 
    
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        juego.addCol();
        posX = columnas;
        
        aux = juego.getRaiz();
        while(aux.getSiguiente()!= null){
            aux = aux.getSiguiente();
        }
        
        dibujo = aux;
        posY = 500;
       
       
            for(int c=0; c < juego.posFila; c++){
                dibujo.setBounds(posX,posY, 80,80);
                dibujo.setOpaque(true);
                dibujo.setBackground(Color.CYAN);
                javax.swing.border.Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

                dibujo.setBorder(border);
                add(dibujo);
                
                MouseListener ml = new MouseListener() {
                        @Override
                        public void mouseReleased(MouseEvent e) {System.out.println("Released!");}

                        @Override
                        public void mousePressed(MouseEvent e) {
                            String numero = ((JLabel)e.getSource()).getName();
                            
                            //((JLabel)e.getSource()).setIcon(objetos.getIcon());
                            ((JLabel)e.getSource()).setIcon(new ImageIcon(objetos.getImagen().getImage().getScaledInstance(75, 75, BufferedImage.SCALE_SMOOTH)));
                            editarMatriz(objetos.getTipo(), objetos.getNombre(), numero);
                            
                            MostrarObjetos();
                            System.out.println("Pressed!" + numero);
                            //dibujo.setIcon(objetos.getIcon());
                            
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {System.out.println("Exited!");}

                        @Override
                        public void mouseEntered(MouseEvent e) {System.out.println("Entered!");}

                        @Override
                        public void mouseClicked(MouseEvent e) {System.out.println("Clicked!");}

                    
                };
                 dibujo.addMouseListener(ml);
                
                
                posY = posY - 80;
                dibujo = dibujo.getArriba();
                
            }
            posX = posX + 80;
            columnas = posX;
            
            actualizarPantalla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ruta = "c:\\pila.txt";;
        File archivo = new File(ruta);
        BufferedWriter bw = null;
        if(archivo.exists()) {
            try {
                // El fichero ya existe
                bw = new BufferedWriter(new FileWriter(archivo));
            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bw.write("El fichero de texto ya estaba creado.");
            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                // El fichero no existe y hay que crearlo
                bw = new BufferedWriter(new FileWriter(archivo));
            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bw.write("Acabo de crear el fichero de texto.");
            } catch (IOException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel objLista;
    // End of variables declaration//GEN-END:variables
}
