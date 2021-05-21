/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import AppPackage.AnimationClass;
import java.awt.Color;

/**
 *
 * @author 1GDAW08
 */
public class VprincipalAdmin extends javax.swing.JFrame {
private int xMouse,yMouse;
private boolean menuAbierto=false;
private boolean listaDesplegable=false;
private char modo='o';
    /**
     * Creates new form VprincipalAdmin
     */
    public VprincipalAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        menu.setBackground(new Color(45,45,45,200));
        this.menuAbierto=false;
        this.listaDesplegable=false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cerrar = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        barraDrag = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bMenu = new javax.swing.JLabel();
        bModo = new javax.swing.JLabel();
        Lalta = new javax.swing.JLabel();
        LaltaEquipos = new javax.swing.JLabel();
        LaltaJugadores = new javax.swing.JLabel();
        LaltaJefe = new javax.swing.JLabel();
        LaltaUsuarios = new javax.swing.JLabel();
        Lbaja = new javax.swing.JLabel();
        LbajaEquipos = new javax.swing.JLabel();
        LbajaJugadores = new javax.swing.JLabel();
        LbajaJefes = new javax.swing.JLabel();
        LbajaUsuarios = new javax.swing.JLabel();
        Lmodificacion = new javax.swing.JLabel();
        LmodificacionEquipos = new javax.swing.JLabel();
        LmodificarJugadores = new javax.swing.JLabel();
        LmodificacionJefes = new javax.swing.JLabel();
        LmodificarUsuarios = new javax.swing.JLabel();
        Lcalendario = new javax.swing.JLabel();
        LrealizarEmparejamientos = new javax.swing.JLabel();
        LresultadosJornada = new javax.swing.JLabel();
        LclasificacionGeneral = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        gifAbajo = new javax.swing.JLabel();
        GIFarriba = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Lbienvenido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(60, 63, 65));
        setMaximumSize(new java.awt.Dimension(1500, 750));
        setMinimumSize(new java.awt.Dimension(1500, 750));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-white.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
        });
        getContentPane().add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 0, -1, -1));

        minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar-white.png"))); // NOI18N
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        getContentPane().add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 0, -1, -1));

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
        getContentPane().add(barraDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 50));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        bMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bMenuMouseClicked(evt);
            }
        });
        jPanel1.add(bMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 50));

        bModo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/luna.png"))); // NOI18N
        bModo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bModoMouseClicked(evt);
            }
        });
        jPanel1.add(bModo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 60, -1, -1));

        Lalta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Lalta.setForeground(new java.awt.Color(255, 255, 255));
        Lalta.setText("Alta");
        Lalta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LaltaMouseClicked(evt);
            }
        });
        jPanel1.add(Lalta, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 140, 50, 30));

        LaltaEquipos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LaltaEquipos.setForeground(new java.awt.Color(255, 255, 255));
        LaltaEquipos.setText("Equipos");
        jPanel1.add(LaltaEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 180, -1, -1));

        LaltaJugadores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LaltaJugadores.setForeground(new java.awt.Color(255, 255, 255));
        LaltaJugadores.setText("Jugadores");
        jPanel1.add(LaltaJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 210, -1, -1));

        LaltaJefe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LaltaJefe.setForeground(new java.awt.Color(255, 255, 255));
        LaltaJefe.setText("Jefes");
        jPanel1.add(LaltaJefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 240, -1, -1));

        LaltaUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LaltaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        LaltaUsuarios.setText("Usuarios");
        jPanel1.add(LaltaUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 270, -1, -1));

        Lbaja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Lbaja.setForeground(new java.awt.Color(255, 255, 255));
        Lbaja.setText("Baja");
        Lbaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LbajaMouseClicked(evt);
            }
        });
        jPanel1.add(Lbaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 310, -1, -1));

        LbajaEquipos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbajaEquipos.setForeground(new java.awt.Color(255, 255, 255));
        LbajaEquipos.setText("Equipos");
        jPanel1.add(LbajaEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 340, -1, -1));

        LbajaJugadores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbajaJugadores.setForeground(new java.awt.Color(255, 255, 255));
        LbajaJugadores.setText("Jugadores");
        jPanel1.add(LbajaJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 370, -1, -1));

        LbajaJefes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbajaJefes.setForeground(new java.awt.Color(255, 255, 255));
        LbajaJefes.setText("Jefes");
        jPanel1.add(LbajaJefes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 400, -1, -1));

        LbajaUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LbajaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        LbajaUsuarios.setText("Usuarios");
        jPanel1.add(LbajaUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 430, -1, -1));

        Lmodificacion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Lmodificacion.setForeground(new java.awt.Color(255, 255, 255));
        Lmodificacion.setText("Modificación");
        Lmodificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LmodificacionMouseClicked(evt);
            }
        });
        jPanel1.add(Lmodificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 460, -1, -1));

        LmodificacionEquipos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LmodificacionEquipos.setForeground(new java.awt.Color(255, 255, 255));
        LmodificacionEquipos.setText("Equipos");
        jPanel1.add(LmodificacionEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 490, -1, -1));

        LmodificarJugadores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LmodificarJugadores.setForeground(new java.awt.Color(255, 255, 255));
        LmodificarJugadores.setText("Jugadores");
        jPanel1.add(LmodificarJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 510, -1, -1));

        LmodificacionJefes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LmodificacionJefes.setForeground(new java.awt.Color(255, 255, 255));
        LmodificacionJefes.setText("Jefes");
        jPanel1.add(LmodificacionJefes, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 530, -1, -1));

        LmodificarUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LmodificarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        LmodificarUsuarios.setText("Usuarios");
        jPanel1.add(LmodificarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 550, -1, -1));

        Lcalendario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Lcalendario.setForeground(new java.awt.Color(255, 255, 255));
        Lcalendario.setText("Calendario");
        jPanel1.add(Lcalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 570, -1, 40));

        LrealizarEmparejamientos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LrealizarEmparejamientos.setForeground(new java.awt.Color(255, 255, 255));
        LrealizarEmparejamientos.setText("Realizar Emparejamientos");
        jPanel1.add(LrealizarEmparejamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 610, -1, -1));

        LresultadosJornada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LresultadosJornada.setForeground(new java.awt.Color(255, 255, 255));
        LresultadosJornada.setText("Resultados Jornada");
        jPanel1.add(LresultadosJornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 650, -1, -1));

        LclasificacionGeneral.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LclasificacionGeneral.setForeground(new java.awt.Color(255, 255, 255));
        LclasificacionGeneral.setText("Clasificación general");
        jPanel1.add(LclasificacionGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 690, -1, -1));

        menu.setBackground(new java.awt.Color(120, 120, 120));
        menu.setOpaque(true);
        jPanel1.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-300, 50, 300, 700));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGO.png"))); // NOI18N
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        gifAbajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GIF3Parte2.gif"))); // NOI18N
        jPanel1.add(gifAbajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 500, 500));

        GIFarriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GIF3Parte1.gif"))); // NOI18N
        jPanel1.add(GIFarriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -120, 500, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 750));

        jPanel2.setBackground(new java.awt.Color(45, 45, 45));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        Lbienvenido.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Lbienvenido.setForeground(new java.awt.Color(255, 255, 255));
        Lbienvenido.setText("Bienvenido!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addComponent(Lbienvenido)
                .addContainerGap(412, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(Lbienvenido)
                .addContainerGap(465, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void barraDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraDragMousePressed
       xMouse=evt.getX();
       yMouse=evt.getY();
    }//GEN-LAST:event_barraDragMousePressed

    private void barraDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraDragMouseDragged
       int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_barraDragMouseDragged

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        //Controlador.salir();
        System.exit(0);
    }//GEN-LAST:event_cerrarMouseClicked

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void bMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bMenuMouseClicked
        AnimationClass animacion=new AnimationClass();
        if(menuAbierto){
            menuAbierto=false;
            animacion.jLabelXLeft(0, -300, 3, 5, menu);
             animacion.jLabelXLeft(80,-100, 3, 5, Lalta);
            animacion.jLabelXLeft(80,-100, 3, 5, Lbaja);
            animacion.jLabelXLeft(80,-100, 3, 5, Lmodificacion);
            animacion.jLabelXLeft(80,-100, 3, 5, Lcalendario);
            animacion.jLabelXLeft(80,-250, 3, 5, LrealizarEmparejamientos);
            animacion.jLabelXLeft(80,-250, 3, 5, LresultadosJornada);
            animacion.jLabelXLeft(80,-250, 3, 5, LclasificacionGeneral);
              animacion.jLabelXLeft(70, -70, 3, 5, bModo);
            
        }
        else{
            menuAbierto=true;
            animacion.jLabelXRight(-300,0, 3, 5, menu);
            animacion.jLabelXRight(-100,80, 3, 5, Lalta);
            animacion.jLabelXRight(-100,80, 3, 5, Lbaja);
            animacion.jLabelXRight(-100,80, 3, 5, Lmodificacion);
            animacion.jLabelXRight(-100,80, 3, 5, Lcalendario);
            animacion.jLabelXRight(-250,80, 3, 5, LrealizarEmparejamientos);
            animacion.jLabelXRight(-250,80, 3, 5, LresultadosJornada);
            animacion.jLabelXRight(-250,80, 3, 5, LclasificacionGeneral);
            animacion.jLabelXLeft(-70, 70, 3, 5, bModo);
            
      
        }
        
    }//GEN-LAST:event_bMenuMouseClicked

    private void LaltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LaltaMouseClicked
       AnimationClass animacion = new AnimationClass();
       
       if(listaDesplegable){
           listaDesplegable=false;
           animacion.jLabelXLeft(180, -100, 3, 5, LaltaEquipos);
           animacion.jLabelXLeft(180, -100, 3, 5, LaltaJugadores);
           animacion.jLabelXLeft(180, -100, 3, 5, LaltaJefe);
           animacion.jLabelXLeft(180, -100, 3, 5, LaltaUsuarios);
           
           
           
       }
       else{
           listaDesplegable=true;
           animacion.jLabelXRight(-100, 180, 3, 5, LaltaEquipos);
           animacion.jLabelXRight(-100, 180, 3, 5, LaltaJugadores);
           animacion.jLabelXRight(-100, 180, 3, 5, LaltaJefe);
           animacion.jLabelXRight(-100, 180, 3, 5, LaltaUsuarios);
           
       }
       
    }//GEN-LAST:event_LaltaMouseClicked

    private void LbajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LbajaMouseClicked
       AnimationClass animacion = new AnimationClass();
        if(listaDesplegable){
           listaDesplegable=false;
           animacion.jLabelXLeft(180, -100, 3, 5, LbajaEquipos);
           animacion.jLabelXLeft(180, -100, 3, 5, LbajaJugadores);
           animacion.jLabelXLeft(180, -100, 3, 5, LbajaJefes);
           animacion.jLabelXLeft(180, -100, 3, 5, LbajaUsuarios);
           
           
           
       }
       else{
           listaDesplegable=true;
           animacion.jLabelXRight(-100, 180, 3, 5, LbajaEquipos);
           animacion.jLabelXRight(-100, 180, 3, 5, LbajaJugadores);
           animacion.jLabelXRight(-100, 180, 3, 5, LbajaJefes);
           animacion.jLabelXRight(-100, 180, 3, 5, LbajaUsuarios);
           
       }
    }//GEN-LAST:event_LbajaMouseClicked

    private void LmodificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LmodificacionMouseClicked
        AnimationClass animacion = new AnimationClass();
        if(listaDesplegable){
           listaDesplegable=false;
           animacion.jLabelXLeft(180, -100, 3, 5, LmodificacionEquipos);
           animacion.jLabelXLeft(180, -100, 3, 5, LmodificarJugadores);
           animacion.jLabelXLeft(180, -100, 3, 5, LmodificacionJefes);
           animacion.jLabelXLeft(180, -100, 3, 5, LmodificarUsuarios);
         
           
           
           
       }
       else{
           listaDesplegable=true;
           animacion.jLabelXRight(-100, 180, 3, 5, LmodificacionEquipos);
           animacion.jLabelXRight(-100, 180, 3, 5, LmodificarJugadores);
           animacion.jLabelXRight(-100, 180, 3, 5, LmodificacionJefes);
           animacion.jLabelXRight(-100, 180, 3, 5, LmodificarUsuarios);
         
           
       }
    }//GEN-LAST:event_LmodificacionMouseClicked

    private void bModoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bModoMouseClicked
         
        if(modo==('o')){
           modo='c';
           bModo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sol.png")));
           cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar.png")));
           minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar.png")));
           bMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu-negro.png")));
           jPanel2.setBackground(new Color(255,255,255));
           Lbienvenido.setForeground(new Color(0,0,0));
           menu.setBackground(new Color (255,255,255,200));
           Lalta.setForeground(new Color(0,0,0));
           Lbaja.setForeground(new Color(0,0,0));
           Lmodificacion.setForeground(new Color(0,0,0));
           Lcalendario.setForeground(new Color(0,0,0));
           LrealizarEmparejamientos.setForeground(new Color(0,0,0));
           LresultadosJornada.setForeground(new Color(0,0,0));
           LclasificacionGeneral.setForeground(new Color(0,0,0));
           LbajaEquipos.setForeground(new Color(0,0,0));
           LbajaJugadores.setForeground(new Color(0,0,0));
           LbajaJefes.setForeground(new Color(0,0,0));
           LbajaUsuarios.setForeground(new Color(0,0,0));
           LmodificacionEquipos.setForeground(new Color(0,0,0));
           LmodificarJugadores.setForeground(new Color(0,0,0));
           LmodificacionJefes.setForeground(new Color(0,0,0));
           LmodificarUsuarios.setForeground(new Color(0,0,0));
           LaltaEquipos.setForeground(new Color(0,0,0));
           LaltaJugadores.setForeground(new Color(0,0,0));
           LaltaJefe.setForeground(new Color(0,0,0));
           LaltaUsuarios.setForeground(new Color(0,0,0));
           LbajaEquipos.setForeground(new Color(0,0,0));
           LbajaJugadores.setForeground(new Color(0,0,0));
           LbajaJefes.setForeground(new Color(0,0,0));
           LbajaUsuarios.setForeground(new Color(0,0,0));
           LmodificacionEquipos.setForeground(new Color(0,0,0));
           LmodificarJugadores.setForeground(new Color(0,0,0));
           LmodificacionJefes.setForeground(new Color(0,0,0));
           LmodificarUsuarios.setForeground(new Color(0,0,0));
           
           
           
       }
       else{
           modo='o';
           bModo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/luna.png")));
           cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-white.png")));
           minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimizar-white.png")));
           bMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png")));
           jPanel2.setBackground(new Color(45,45,45));
           Lbienvenido.setForeground(new Color(255,255,255));
           menu.setBackground(new Color (45,45,45,200));
           Lalta.setForeground(new Color(255,255,255));
           Lbaja.setForeground(new Color(255,255,255));
           Lmodificacion.setForeground(new Color(255,255,255));
           Lcalendario.setForeground(new Color(255,255,255));
           LrealizarEmparejamientos.setForeground(new Color(255,255,255));
           LresultadosJornada.setForeground(new Color(255,255,255));
           LclasificacionGeneral.setForeground(new Color(255,255,255));
           LbajaEquipos.setForeground(new Color(255,255,255));
           LbajaJugadores.setForeground(new Color(255,255,255));
           LbajaJefes.setForeground(new Color(255,255,255));
           LbajaUsuarios.setForeground(new Color(255,255,255));
           LmodificacionEquipos.setForeground(new Color(255,255,255));
           LmodificarJugadores.setForeground(new Color(255,255,255));
           LmodificacionJefes.setForeground(new Color(255,255,255));
           LmodificarUsuarios.setForeground(new Color(255,255,255));
           LaltaEquipos.setForeground(new Color(255,255,255));
           LaltaJugadores.setForeground(new Color(255,255,255));
           LaltaJefe.setForeground(new Color(255,255,255));
           LaltaUsuarios.setForeground(new Color(255,255,255));
           LbajaEquipos.setForeground(new Color(255,255,255));
           LbajaJugadores.setForeground(new Color(255,255,255));
           LbajaJefes.setForeground(new Color(255,255,255));
           LbajaUsuarios.setForeground(new Color(255,255,255));
           LmodificacionEquipos.setForeground(new Color(255,255,255));
           LmodificarJugadores.setForeground(new Color(255,255,255));
           LmodificacionJefes.setForeground(new Color(255,255,255));
           LmodificarUsuarios.setForeground(new Color(255,255,255));
       }
    }//GEN-LAST:event_bModoMouseClicked
  
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
            java.util.logging.Logger.getLogger(VprincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VprincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VprincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VprincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VprincipalAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GIFarriba;
    private javax.swing.JLabel Lalta;
    private javax.swing.JLabel LaltaEquipos;
    private javax.swing.JLabel LaltaJefe;
    private javax.swing.JLabel LaltaJugadores;
    private javax.swing.JLabel LaltaUsuarios;
    private javax.swing.JLabel Lbaja;
    private javax.swing.JLabel LbajaEquipos;
    private javax.swing.JLabel LbajaJefes;
    private javax.swing.JLabel LbajaJugadores;
    private javax.swing.JLabel LbajaUsuarios;
    private javax.swing.JLabel Lbienvenido;
    private javax.swing.JLabel Lcalendario;
    private javax.swing.JLabel LclasificacionGeneral;
    private javax.swing.JLabel Lmodificacion;
    private javax.swing.JLabel LmodificacionEquipos;
    private javax.swing.JLabel LmodificacionJefes;
    private javax.swing.JLabel LmodificarJugadores;
    private javax.swing.JLabel LmodificarUsuarios;
    private javax.swing.JLabel LrealizarEmparejamientos;
    private javax.swing.JLabel LresultadosJornada;
    private javax.swing.JLabel bMenu;
    private javax.swing.JLabel bModo;
    private javax.swing.JLabel barraDrag;
    private javax.swing.JLabel cerrar;
    private javax.swing.JLabel gifAbajo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel minimizar;
    // End of variables declaration//GEN-END:variables
}
