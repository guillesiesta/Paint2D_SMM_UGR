/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.gui.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author guillesiesta
 */
public class RectanguloRedondoG extends FiguraG{
    
    //Atributos
    private Color relleno;
    private int redondeo; //Redondeo del borde
    private boolean isrelleno;
    private Point punto,punto1, punto2;
    
    //Constructores
    
    //por defecto
    public RectanguloRedondoG(){
        this.figura = new RoundRectangle2D.Double();
        this.trazo = new  BasicStroke(1);
        this.color = Color.BLACK;
        this.relleno = Color.BLACK;
        this.isrelleno= false;
        //Por defecto no crea redondeos en el borde
    }
    
    public RectanguloRedondoG(Color c, Stroke trazo, boolean transpa, boolean alisa, Composite co,
                   RenderingHints r, Color rellenoColor, boolean estarelleno, int redondeo,
                   Point2D p){
        this.figura = new RoundRectangle2D.Double(p.getX(),p.getY(),0,0,redondeo,redondeo);
        this.color = c;
        this.trazo = trazo;
        this.transparente = transpa;
        this.alisado = alisa;
        this.composite = co;
        this.render = r;
        this.relleno = rellenoColor;
        this.isrelleno = estarelleno;
        this.redondeo = redondeo;
        this.punto2 = (Point)p;
        
    }
    
    public void setTienerelleno(boolean tiene) {
        this.isrelleno = tiene;
    }

    public void setRelleno(Color relleno) {
        this.relleno = relleno;
    }
    public Color getColorRelleno() {
       return relleno;
    }

    @Override
    public boolean getContenido(Point p1) {
        return ((RoundRectangle2D)figura).contains(p1);
    }

    @Override
    public void dibujarfigura(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(color);
        g2d.setStroke(this.trazo);
        g2d.setComposite(this.composite);
        g2d.setRenderingHints(render);
        g2d.draw(figura);
        if(this.isrelleno){ 
            g2d.setPaint(this.relleno); 
            g2d.fill(figura);
        }
    }

    @Override
    public void moverfigura(Point p1, Point p2) {
        ((RoundRectangle2D)figura).setFrameFromDiagonal( 
                (this.punto.x+(p2.x-p1.x)),(this.punto.y+(p2.y-p1.y)),
                (this.punto1.x+(p2.x-p1.x)),(this.punto1.y+(p2.y-p1.y)) );
    }

    @Override
    public void actualizarfigura(Point p1, Point p2) {
        this.punto=p1;
        this.punto1=p2;
        ((RoundRectangle2D)figura).setFrameFromDiagonal(p1, p2);
    }
    
}
