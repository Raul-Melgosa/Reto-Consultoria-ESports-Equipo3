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
 *
 * @author 1GDAW08
 */
public class VClasificacionUsu extends javax.swing.JFrame {
private int xMouse,yMouse;
private boolean menuAbierto=false;
AnimationClass animacion = new AnimationClass();
    /**
     * Creates new form VprincipalAdmin
     */
    public VClasificacionUsu() {
        initComponents();
        bMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimizar-white.png")));
        setLocationRelativeTo(null);
        barraDrag.setBackground(new java.awt.Color(0,0,0,0));
        menu.setBackground(new Color(45,45,45,200));
        this.menuAbierto=false;
        Controlador.rellenarClasificacion(tablaClasificacion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bCerrar = new javax.swing.JLabel();
        bMinimizar = new javax.swing.JLabel();
        barraDrag = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bMenu = new javax.swing.JLabel();
        bLogout = new javax.swing.JLabel();
        bResultadosJornada = new javax.swing.JLabel();
        bClasificacionGeneral = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        gifAbajo = new javax.swing.JLabel();
        GIFarriba = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClasificacion = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setMinimumSize(new java.awt.Dimension(1500, 750));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bCerrar.setBackground(new java.awt.Color(45, 45, 45));
        bCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar-white.png"))); // NOI18N
        bCerrar.setOpaque(true);
        bCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bCerrarMouseExited(evt);
            }
        });
        getContentPane().add(bCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 0, 40, 30));

        bMinimizar.setBackground(new java.awt.Color(45, 45, 45));
        bMinimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimizar-white.png"))); // NOI18N
        bMinimizar.setOpaque(true);
        bMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMinimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bMinimizarMouseExited(evt);
            }
        });
        getContentPane().add(bMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 0, 40, -1));

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
        getContentPane().add(barraDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/menu.png"))); // NOI18N
        bMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMenuMouseClicked(evt);
            }
        });
        jPanel1.add(bMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 50));

        bLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        bLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLogoutMouseClicked(evt);
            }
        });
        jPanel1.add(bLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, 60, 40, 40));

        bResultadosJornada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bResultadosJornada.setForeground(new java.awt.Color(255, 255, 255));
        bResultadosJornada.setText("     Resultados Jornada");
        bResultadosJornada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(bResultadosJornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 110, 300, 30));

        bClasificacionGeneral.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bClasificacionGeneral.setForeground(new java.awt.Color(255, 255, 255));
        bClasificacionGeneral.setText("     Clasificación general");
        bClasificacionGeneral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(bClasificacionGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 150, 300, 30));

        menu.setBackground(new java.awt.Color(120, 120, 120));
        menu.setOpaque(true);
        jPanel1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 50, 300, 700));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LOGO-small.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        gifAbajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GIF3Parte2.gif"))); // NOI18N
        jPanel1.add(gifAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 500, 500));

        GIFarriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GIF3Parte1.gif"))); // NOI18N
        jPanel1.add(GIFarriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -120, 500, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 750));

        jPanel2.setBackground(new java.awt.Color(45, 45, 45));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(200, 200, 200));
        jLabel1.setText("USUARIO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 720, 70, 30));

        tablaClasificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaClasificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posición", "Equipo", "Puntos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaClasificacion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaClasificacion.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tablaClasificacion.getTableHeader().setResizingAllowed(false);
        tablaClasificacion.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaClasificacion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 500, 375));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CLASIFICACIÓN");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 134, 500, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMenuMouseClicked
        if(menuAbierto){
            menuAbierto=false;
            animacion.jLabelXLeft(menu.getX(), menu.getX()-300, 3, 5, menu);
            animacion.jLabelXLeft(bResultadosJornada.getX(),bResultadosJornada.getX()-300, 3, 5, bResultadosJornada);
            animacion.jLabelXLeft(bClasificacionGeneral.getX(),bClasificacionGeneral.getX()-300, 3, 5, bClasificacionGeneral);
            animacion.jLabelXLeft(bLogout.getX(), bLogout.getX()-300, 3, 5, bLogout);
        }
        else{
            bResultadosJornada.setLocation(-300, 350);
            bClasificacionGeneral.setLocation(-300, 390);
            menuAbierto=true;
            animacion.jLabelXRight(menu.getX(), menu.getX()+300, 3, 5, menu);
            animacion.jLabelXRight(bResultadosJornada.getX(),bResultadosJornada.getX()+300, 3, 5, bResultadosJornada);
            animacion.jLabelXRight(bClasificacionGeneral.getX(),bClasificacionGeneral.getX()+300, 3, 5, bClasificacionGeneral);
            animacion.jLabelXRight(bLogout.getX(), bLogout.getX()+300, 3, 5, bLogout);
        }
    }//GEN-LAST:event_bMenuMouseClicked
       
    private void bLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLogoutMouseClicked
        Controlador.VentanaLogin(this);
    }//GEN-LAST:event_bLogoutMouseClicked

    private void barraDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraDragMousePressed
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_barraDragMousePressed

    private void barraDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraDragMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_barraDragMouseDragged

    private void bCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCerrarMouseClicked
        Controlador.salir();
    }//GEN-LAST:event_bCerrarMouseClicked

    private void bCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCerrarMouseEntered
        bCerrar.setBackground(new java.awt.Color(255,0,0));
    }//GEN-LAST:event_bCerrarMouseEntered

    private void bCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCerrarMouseExited
        bCerrar.setBackground(new java.awt.Color(45, 45, 45));
    }//GEN-LAST:event_bCerrarMouseExited

    private void bMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMinimizarMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_bMinimizarMouseClicked

    private void bMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMinimizarMouseEntered
        bMinimizar.setBackground(new Color(100,100,100));
    }//GEN-LAST:event_bMinimizarMouseEntered

    private void bMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMinimizarMouseExited
        bMinimizar.setBackground(new java.awt.Color(45, 45, 45));
    }//GEN-LAST:event_bMinimizarMouseExited

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        jPanel2.requestFocus();
    }//GEN-LAST:event_jPanel2MouseClicked
  
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
            java.util.logging.Logger.getLogger(VClasificacionUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VClasificacionUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VClasificacionUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VClasificacionUsu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VClasificacionUsu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GIFarriba;
    private javax.swing.JLabel bCerrar;
    private javax.swing.JLabel bClasificacionGeneral;
    private javax.swing.JLabel bLogout;
    private javax.swing.JLabel bMenu;
    private javax.swing.JLabel bMinimizar;
    private javax.swing.JLabel bResultadosJornada;
    private javax.swing.JLabel barraDrag;
    private javax.swing.JLabel gifAbajo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel menu;
    private javax.swing.JTable tablaClasificacion;
    // End of variables declaration//GEN-END:variables
}
