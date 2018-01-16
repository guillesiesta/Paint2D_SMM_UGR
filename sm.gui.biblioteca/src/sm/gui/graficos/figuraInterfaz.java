/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.gui.graficos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author kaizen
 */
public interface figuraInterfaz {
    void dibujar(Graphics g);
    public void mover(Point p1,Point p2);
    void redimensionar(Point p1,Point p2);
    
}
