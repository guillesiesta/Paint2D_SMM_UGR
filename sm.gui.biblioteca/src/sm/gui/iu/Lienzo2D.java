package sm.gui.iu;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import sm.gui.graficos.ElipseG;
import sm.gui.graficos.FiguraG;
import sm.gui.graficos.LineaG;
import sm.gui.graficos.PuntoG;
import sm.gui.graficos.RectanguloG;
import sm.gui.graficos.RectanguloRedondoG;

/**
 *
 * @author guillesiesta
 */
public class Lienzo2D extends javax.swing.JPanel {
    
    public static int herramienta = -1; //0 para el lápiz, 1 para la linea, 2 para el rectangulo, 3 para el circulo
    private Color color,colorrelleno; //Por defecto vale negro
    private Stroke stroke;
    private Composite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f);;
    private RenderingHints render;
    public boolean relleno;
    public boolean transparente;
    public boolean renderizar;
    public boolean editar;
    private Point punto;
    private Point punto1;
    /*CLASES NUEVAS G*/
    private ElipseG elipse;
    private LineaG lineaca;
    private RectanguloG rectangulaco;
    private RectanguloRedondoG recredondaco;
    private PuntoG puntaco;
    private int redondeado = 20; //por defecto vale 20 el redondeado del rectangulo
    private ArrayList <FiguraG> figurasG = new ArrayList();
    private FiguraG fg;

    /**
     * Creates new form Lienzo2D
     */
    public Lienzo2D() {
        initComponents();
        stroke = new BasicStroke(1);
        color = Color.BLACK;
        render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
    }

    /*GETTER Y SETTER*/
    
    public Color getColorRelleno(){
        return colorrelleno;
    }
    
    public int getRedondeado(){
        return redondeado;
    }
    
    public int getHerramienta() {
        return herramienta;
    }

    public Stroke getStroke() {
        return stroke;
    }
    public Composite getComposite(){
        return composite;
    }
    public RenderingHints getRender(){
        return render;
    }
    
    public Color getColor(){
        return color;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public Point getPunto() {
        return punto;
    }

    public static void setHerramienta(int h) {
        herramienta = h;
    }
    
    public void setEditar(boolean e){
        this.editar = e;
    }
    
    public void setAlisar(boolean a){
        this.renderizar = a;
        if(!renderizar){
            render.clear();
        }else{
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        //repaint();
    }
    
    public void setTransparencia(boolean b, float trans){
        this.transparente = b;
        
        if(!transparente){
            composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, trans);
        }else{
            composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, trans);
        }
        //repaint();
    }
    
    public void setTransparencia(boolean b){
        this.transparente = b;
        
        if(!transparente){
            composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
        }else{
            composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
        }
        //repaint();
    }
    
    public void setStrokeAtr(int g) {
        stroke = new BasicStroke(g);
        //repaint();
    }

    public void setStroke(BasicStroke b){
        this.stroke = b;
        //repaint();
    }
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
        //repaint();
    }
    
    public void setColor(Color c) {
        this.color = c;
        //repaint();
    }
    
    public void setColorRelleno(Color color){
        this.colorrelleno = color;
        //repaint();
    }
    
    public void setRedondeado(int r){
        this.redondeado = r;
        //repaint();
    }

    public void SetComposite(Composite c){
    
    }
    
    //METODO PAINT
    public void paint(Graphics g){
        super.paint(g);
        
        for(FiguraG f:figurasG){
            f.dibujarfigura(g);
        }
    }


    private FiguraG getSelectedShape(Point2D p){
        /*for(FiguraG f:figurasG)
            if(f.getContenido((Point) p)) return f;
        return null;*/
        for(int i=figurasG.size()-1;i>=0;i--){ //Para que empiece a coger la ultima figura dibujada
            FiguraG s=figurasG.get(i);
            if(s.getContenido((Point) p)){
                return s;
            } 
        }
        return null;
    }

    public void createShape(){
        switch(herramienta){
            case 0: //PUNTO
                //puntaco = new PuntoG(punto);
                puntaco = new PuntoG(color,stroke,transparente,renderizar,composite,render,punto);
                figurasG.add(puntaco);
                break;
            case 1: //LINEA
                //lineaca = new LineaG(punto,punto);
                lineaca = new LineaG(color,stroke,transparente,renderizar,composite,render,punto,punto);
                figurasG.add(lineaca);
                break;
            case 2: //RECTANGULO
                //rectangulaco = new RectanguloG();
                rectangulaco = new RectanguloG(color,stroke,transparente,renderizar,composite,render,colorrelleno, relleno);
                figurasG.add(rectangulaco);
                break;
            case 3: //CIRCULO
                //elipse = new ElipseG();
                elipse = new ElipseG(color, stroke, transparente, editar, composite, render, colorrelleno, relleno);
                figurasG.add(elipse);
                break;
            case 4://RECTANGULO REDONDO
                recredondaco = new RectanguloRedondoG(color,stroke,transparente,renderizar,composite,
                                                        render,colorrelleno,relleno, redondeado, punto);
               
                figurasG.add(recredondaco);
                break;
            
        }
    }
    
    public void updateShape(){
        switch(herramienta){
            case 0: //PUNTO
                break;
            case 1: //LINEA
                lineaca.actualizarfigura(punto, punto1);
                break;
            case 2: //RECTANGULO
                rectangulaco.actualizarfigura(punto, punto1);
                break;
            case 3: //CIRCULO
                elipse.actualizarfigura(punto, punto1);
                break;
            case 4://RoundRectangle
                recredondaco.actualizarfigura(punto, punto1);
                break;
            
        }
    }

    
    public void eligeShape(java.awt.event.MouseEvent evt){
        
        fg = this.getSelectedShape(evt.getPoint());
        if(fg instanceof RectanguloG){
          rectangulaco = (RectanguloG) fg;
        }else if(fg instanceof ElipseG){
          elipse = (ElipseG) fg;
        }else if(fg instanceof LineaG){
          lineaca = (LineaG) fg;
        }else if(fg instanceof RectanguloRedondoG){
          recredondaco = (RectanguloRedondoG) fg;
        }else if(fg instanceof PuntoG){
          puntaco = (PuntoG) fg;
        }
    }
    
    public void mueveShape(java.awt.event.MouseEvent evt, Point p){
    
        if(fg instanceof RectanguloG){
            if(rectangulaco!=null) rectangulaco.moverfigura(punto, p);
        }else if(fg instanceof ElipseG){
            if(elipse!=null) elipse.moverfigura(punto, p);
        }else if(fg instanceof LineaG){
            if(lineaca!=null) lineaca.setLocation(p);
        }else if(fg instanceof RectanguloRedondoG){
            if(recredondaco!=null) recredondaco.moverfigura(punto, p);
        }else if(fg instanceof PuntoG){
            if(puntaco!=null) puntaco.moverfigura(punto, p);
                
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(254, 254, 254));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        if(editar){
            punto = evt.getPoint();
            this.eligeShape(evt);
        }else{
            punto = evt.getPoint();
            this.createShape();
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        this.formMouseDragged(evt);
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        if(editar){
            Point punto2;
            punto2 =evt.getPoint();
            this.mueveShape(evt, punto2);
        }else{
            punto1 = evt.getPoint();
            this.updateShape();
        }
        this.repaint();
    }//GEN-LAST:event_formMouseDragged


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
