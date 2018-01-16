/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.gui.graficos;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;

/**
 *
 * @author guillesiesta
 */
public abstract class FiguraG implements InterfazFiguras{
    
    /*Atributos*/
    Shape figura;
    Color color;
    Stroke trazo;
    boolean transparente;
    boolean alisado;
    Composite composite;
    RenderingHints render;
    
    public Shape getFig() {
        return figura;
    }

    /*GETTER Y SETTER*/
    
    public abstract boolean getContenido(Point p1);

    public void setFigura(Shape f) {
        this.figura = f;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public Stroke getTrazo() {
        return trazo;
    }

    public void setTrazo(BasicStroke b) {
        this.trazo = b;
    }

    public boolean isTransparente() {
        return transparente;
    }

    public void setTransparente(boolean t) {
        this.transparente = t;
    }

    public boolean isAlisado() {
        return alisado;
    }

    public void setAlisado(boolean a) {
        this.alisado = a;
    }

    public Composite getComposite() {
        return composite;
    }

    public void setComposite(Composite c) {
        this.composite = c;
    }

    public RenderingHints getRender() {
        return render;
    }

    public void setRender(RenderingHints r) {
        this.render = r;
    }
    
}