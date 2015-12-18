package dvcodebase.extract;

import java.awt.image.BufferedImage;

import com.deb.lib.image.FloatingImage;

public class TypeDeterminator {
	
	ColorTypeConverter cTC;
	
	public TypeDeterminator() {
		this.cTC = new ColorTypeConverterStandard();
	}
	
	public TypeDeterminator(ColorTypeConverter cTC) {
		this.cTC = cTC;
	}
	
	public int[][] determineTypes(FloatingImage f) {
		if(f.getType() != BufferedImage.TYPE_INT_RGB) return null;
		int[][] out = new int[f.getWidth()][f.getHeight()];
		
		for(int x = 0; x < f.getWidth(); x++) {
			for(int y = 0; y < f.getHeight(); y++) {
				out[x][y] = cTC.floatingColorToType(f.getPixel(x, y));
			}
		}
		
		return out;
	}
}
