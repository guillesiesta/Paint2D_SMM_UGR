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
 * @author kaizen
 */
public abstract class myFigura implements figuraInterfaz{
    Shape fig;
    Color color;
    Stroke borde;
    boolean transparente;
    boolean alisado;
    Composite composite;
    RenderingHints render;
    public Shape getFig() {
        return fig;
    }

    
    public abstract boolean getContenido(Point p1);

    public void setFig(Shape fig) {
        this.fig = fig;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Stroke getBorde() {
        return borde;
    }

    public void setBorde(BasicStroke borde) {
        this.borde = borde;
    }

    public boolean isTransparente() {
        return transparente;
    }

    public void setTransparente(boolean transparente) {
        this.transparente = transparente;
    }

    public boolean isAlisado() {
        return alisado;
    }

    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }

    public Composite getComposite() {
        return composite;
    }

    public void setComposite(Composite composite) {
        this.composite = composite;
    }

    public RenderingHints getRender() {
        return render;
    }

    public void setRender(RenderingHints render) {
        this.render = render;
    }
    
}