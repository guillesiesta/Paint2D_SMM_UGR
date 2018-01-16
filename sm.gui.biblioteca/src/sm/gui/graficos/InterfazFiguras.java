/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.gui.graficos;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author guillesiesta
 */
public interface InterfazFiguras {
    void dibujarfigura(Graphics g);
    public void moverfigura(Point p1,Point p2);
    void actualizarfigura(Point p1,Point p2);
}
