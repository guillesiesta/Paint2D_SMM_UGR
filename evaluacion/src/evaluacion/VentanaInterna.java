/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package evaluacion;


/**
 *
 * @author guillesiesta
 */
public class VentanaInterna extends javax.swing.JInternalFrame {

    //Lienzo2D lienzo = new Lienzo2D();
    /**
     * Creates new form VentanaInterna
     */
    public VentanaInterna() {
        initComponents();
        this.setSize(350, 350);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lienzo2D1 = new sm.gui.iu.Lienzo2DImagen();

        setBackground(new java.awt.Color(254, 254, 254));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout lienzo2D1Layout = new javax.swing.GroupLayout(lienzo2D1);
        lienzo2D1.setLayout(lienzo2D1Layout);
        lienzo2D1Layout.setHorizontalGroup(
            lienzo2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );
        lienzo2D1Layout.setVerticalGroup(
            lienzo2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(lienzo2D1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public sm.gui.iu.Lienzo2DImagen lienzo2D1;
    // End of variables declaration//GEN-END:variables
}
