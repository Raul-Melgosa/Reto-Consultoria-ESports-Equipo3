/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import AppPackage.AnimationClass;
import Controlador.Controlador;
import java.awt.Color;

/**
 * Ventana principal de usuario
 * @author Equipo 3(Raúl Melgosa, Oier Velar, Alaitz Candela)
 */
public class VprincipalUsu extends javax.swing.JFrame {
private int xMouse;
private int yMouse;
private boolean menuAbierto=false;
    /**
     * Creates new form VprincipalUsu
     */
    public VprincipalUsu() {
        initComponents();
        setLocationRelativeTo(null);
        menu.setBackground(new Color(45,45,45,200));
        this.menuAbierto=false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bcerrar = new javax.swing.JLabel();
        Bminimizar = new javax.swing.JLabel();
        barraDrag = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Bmodo = new javax.swing.JLabel();
        Bmenu = new javax.swing.JLabel();
        LresultadosJornada = new javax.swing.JLabel();
        Lclasificacion = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        GifArriba = new javax.swing.JLabel();
        GifAbajo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Lbienvenido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(60, 63, 65));
        setMaximumSize(new java.awt.Dimension(1500, 750));
        setMinimumSize(new java.awt.Dimension(1500, 750));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1500, 750));
        setSize(new java.awt.Dimension(1500, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-white.png"))); // NOI18N
        Bcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BcerrarMouseClicked(evt);
            }
        });
        getContentPane().add(Bcerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 0, -1, -1));

        Bminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimizar-white.png"))); // NOI18N
        Bminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BminimizarMouseClicked(evt);
            }
        });
        getContentPane().add(Bminimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 0, -1, -1));

        barraDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraDragMouseDragged(evt);
            }
        });
        barraDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraDragMousePressed(evt);
            }
        });
        getContentPane().add(barraDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(-330, 0, 2000, 50));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO.png"))); // NOI18N
        jPanel1.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Bmodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/luna.png"))); // NOI18N
        jPanel1.add(Bmodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 60, -1, -1));

        Bmenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        Bmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BmenuMouseClicked(evt);
            }
        });
        jPanel1.add(Bmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        LresultadosJornada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LresultadosJornada.setForeground(new java.awt.Color(255, 255, 255));
        LresultadosJornada.setText("Ver resultados de la última jornada");
        LresultadosJornada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LresultadosJornadaMouseClicked(evt);
            }
        });
        jPanel1.add(LresultadosJornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(-280, 140, -1, -1));

        Lclasificacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Lclasificacion.setForeground(new java.awt.Color(255, 255, 255));
        Lclasificacion.setText("Clasificación");
        jPanel1.add(Lclasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 310, -1, -1));

        menu.setOpaque(true);
        jPanel1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 50, 300, 700));

        GifArriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GIF3Parte1.gif"))); // NOI18N
        jPanel1.add(GifArriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -110, -1, -1));

        GifAbajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GIF3Parte2.gif"))); // NOI18N
        jPanel1.add(GifAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 750));

        jPanel2.setBackground(new java.awt.Color(45, 45, 45));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbienvenido.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Lbienvenido.setForeground(new java.awt.Color(255, 255, 255));
        Lbienvenido.setText("Bienvenido!");
        jPanel2.add(Lbienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BcerrarMouseClicked
       Controlador.salir();
    }//GEN-LAST:event_BcerrarMouseClicked

    private void BminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BminimizarMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_BminimizarMouseClicked

    private void barraDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraDragMouseDragged
           int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_barraDragMouseDragged

    private void barraDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraDragMousePressed
         xMouse=evt.getX();
       yMouse=evt.getY();
    }//GEN-LAST:event_barraDragMousePressed

    private void BmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BmenuMouseClicked
        AnimationClass animacion=new AnimationClass();
        if(menuAbierto){
            menuAbierto=false;
            animacion.jLabelXLeft(0, -300, 3, 5, menu);
            animacion.jLabelXLeft(70, -70, 3, 5, Bmodo);
            animacion.jLabelXLeft(20, -280, 3, 5, LresultadosJornada);
            animacion.jLabelXLeft(20, -100, 3, 5, Lclasificacion);
           
            
        }
        else{
            menuAbierto=true;
            animacion.jLabelXRight(-300,0, 3, 5, menu);
            animacion.jLabelXLeft(-280, 70, 3, 5, Bmodo);
            animacion.jLabelXLeft(-280,20, 3, 5, LresultadosJornada);
             animacion.jLabelXLeft(-100, 20, 3, 5, Lclasificacion);
            
      
        }
    }//GEN-LAST:event_BmenuMouseClicked

    private void LresultadosJornadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LresultadosJornadaMouseClicked
        
    }//GEN-LAST:event_LresultadosJornadaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VprincipalUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VprincipalUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VprincipalUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VprincipalUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VprincipalUsu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bcerrar;
    private javax.swing.JLabel Bmenu;
    private javax.swing.JLabel Bminimizar;
    private javax.swing.JLabel Bmodo;
    private javax.swing.JLabel GifAbajo;
    private javax.swing.JLabel GifArriba;
    private javax.swing.JLabel Lbienvenido;
    private javax.swing.JLabel Lclasificacion;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel LresultadosJornada;
    private javax.swing.JLabel barraDrag;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel menu;
    // End of variables declaration//GEN-END:variables
}
