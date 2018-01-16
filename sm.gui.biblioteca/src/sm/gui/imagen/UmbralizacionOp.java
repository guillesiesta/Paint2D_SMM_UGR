package sm.gui.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImagePixelIterator;

/**
 *
 * @author guillesiesta
 */
public class UmbralizacionOp extends sm.image.BufferedImageOpAdapter{
    private double umbral;

    public UmbralizacionOp(double umbral) {
        this.umbral = umbral;
    }
    

    @Override
    public BufferedImage filter(BufferedImage source, BufferedImage dest) {
        if (dest == null) {
            dest = createCompatibleDestImage(source, null);
        }
        WritableRaster destRaster = dest.getRaster(); //destino
        
        for(BufferedImagePixelIterator it = new BufferedImagePixelIterator(source); it.hasNext();) {
            BufferedImagePixelIterator.PixelData pixel = it.next();
            int px[] = pixel.sample;
            //media de los componentes
            //I(x,y) = (r(x,y) +g(x,y) +b(x,y))/3
            double mediaComp = (px[0] + px[1] + px[2]) / 3;
            
            
            if (mediaComp >= umbral) {
                px[0] = 255;
                px[1] = 255;
                px[2] = 255;
            } else {
                px[0]=0;
                px[1]=0;
                px[2]=0;
            }
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
        }
        return dest;
    }
    
}
