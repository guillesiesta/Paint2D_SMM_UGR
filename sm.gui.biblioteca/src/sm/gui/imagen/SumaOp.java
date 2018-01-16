package sm.gui.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageSampleIterator;

/**
 *
 * @author guillesiesta
 */
public class SumaOp extends sm.image.BinaryOp {
    private float alfa;
    
    public SumaOp(BufferedImage imagen) {
        super(imagen);
    }
    
    public final void setAlpha(float alpha) {
        if (alpha<0.0f){
            alpha=0.0f;
        }else if(alpha>1.0f){
            alpha=1.0f;
        }
        this.alfa=alpha;
    }

    public float getAlpha() {
        return alfa;
    }
    
    @Override
    public int binaryOp(int i, int j) {
        int r=i+j;
        
        if(r>255){
            r=255;
        }else if(r<0){
            r=0;
        }
        return r;
    }
    @Override
    public BufferedImage filter(BufferedImage src,BufferedImage dest){
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        WritableRaster rightRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        WritableRaster leftRaster = left.getRaster();

        for (BufferedImageSampleIterator it = new BufferedImageSampleIterator(dest); it.hasNext();) {
            //Recorremos la imagen de destino
            BufferedImageSampleIterator.SampleData smp = it.next(); // Sample del destino
            //Carnaca (vamos al tema en serio)
            int samp1 = rightRaster.getSample(smp.col, smp.row, smp.band);
            int samp2 = leftRaster.getSample(smp.col, smp.row, smp.band);
            smp.value = binaryOp(samp1, samp2);
            
            destRaster.setSample(smp.col, smp.row, smp.band, smp.value);//resultado almacenado en dest
        }

        return dest;
    }
    
}//fin clase
