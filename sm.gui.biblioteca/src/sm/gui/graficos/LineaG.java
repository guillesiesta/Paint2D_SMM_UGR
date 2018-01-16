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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author guillesiesta
 */
public class LineaG extends FiguraG{

    /*ATRIBUTOS*/   
    Point2D p1;
    Point2D p2;
    
    //Constructores
    
    public LineaG(Color c, Stroke trazo, boolean transpa, 
                         boolean alisa, Composite compo, RenderingHints ren,Point2D p, Point2D p1) {
        this.color = c;
        this.trazo = trazo;
        this.transparente = transpa;
        this.alisado = alisa;
        this.composite = compo;
        this.render = ren;
        figura=new Line2D.Float(p,p1);
    }
    
    public LineaG(Point2D p, Point2D p1){
        this.p1=(p);
        this.p2=(p1);
        this.color = Color.BLACK;
        figura=new Line2D.Float(p,p1);
        this.trazo= new BasicStroke(1.0f);
    }
    
    //METODOS
    public boolean isNear(Point2D p){
        return ((Line2D)figura).ptLineDist(p)<=2.0;
    }
    
    
    public boolean contains(Point2D p) {
        return isNear(p);
    }
    
    public void setLocation(Point2D pos){
        double dx=pos.getX()-((Line2D)figura).getX1();
        double dy=pos.getY()-((Line2D)figura).getY1();
        Point2D newp2 = new Point2D.Double(((Line2D)figura).getX2()+dx, ((Line2D)figura).getY2()+dy);
        ((Line2D)figura).setLine(pos,newp2);
    }
    
    @Override
    public boolean getContenido(Point p1) {
        return isNear(p1);
    }

    @Override
    public void dibujarfigura(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(color);
        g2d.setStroke(this.trazo);
        g2d.setComposite(this.composite);
        g2d.setRenderingHints(render);
         g2d.draw(figura);
    }

    @Override
    public void moverfigura(Point p1, Point p2) {
        this.setLocation(p1);
    }

    @Override
    public void actualizarfigura(Point p1, Point p2) {
        ((Line2D)figura).setLine(p1,p2);
    }
    
}
