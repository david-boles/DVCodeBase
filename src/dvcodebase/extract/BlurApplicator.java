package dvcodebase.extract;

import com.deb.lib.image.FloatingImage;
import com.deb.lib.program.Logger;

public class BlurApplicator {
	
	public BlurApplicator() {
		B = new float[][][]{B0, B1, B2};
	}
	
	public BlurApplicator(float[][][] blurMatrices) {
		B = blurMatrices;
	}
	
	static final float[][] B0 = {{1}};
	
	static final float[][] B1 = {
			{0.06666666f,	0.13333333f,	0.06666666f},
			{0.13333333f,	0.2f,			0.13333333f},
			{0.06666666f,	0.13333333f,	0.06666666f}
	};
	
	static final float[][] B2 = {
			{1*0.015384615f,2*0.015384615f,3*0.015384615f,2*0.015384615f,1*0.015384615f},
			{2*0.015384615f,3*0.015384615f,4*0.015384615f,3*0.015384615f,2*0.015384615f},
			{3*0.015384615f,4*0.015384615f,5*0.015384615f,4*0.015384615f,3*0.015384615f},
			{2*0.015384615f,3*0.015384615f,4*0.015384615f,3*0.015384615f,2*0.015384615f},
			{1*0.015384615f,2*0.015384615f,3*0.015384615f,2*0.015384615f,1*0.015384615f}
	};
	
	float[][][] B = null;
	
	FloatingImage applyCroppedBlurRGB(FloatingImage i, int rad) {
		float[][] m = B[rad];
		rad = m.length;
		FloatingImage out = new FloatingImage(i.getWidth(), i.getHeight(), 3, i.getType());
		
		for(int x = m.length-1; x < i.getWidth()-m.length; x++) {
			for(int y = m[0].length-1; y < i.getHeight()-m[0].length; y++) {
				float totalR = 0;
				
				for(int iX = -rad; iX <= rad; iX++) {
					for(int iY = -rad; iY <= rad; iY++) {
						totalR += i.getPixel(x+iX, y+iY)[0] * m[iX+rad][iY+rad];
					}
				}
				
				float totalG = 0;
				
				for(int iX = -rad; iX <= rad; iX++) {
					for(int iY = -rad; iY <= rad; iY++) {
						totalG += i.getPixel(x+iX, y+iY)[1] * m[iX+rad][iY+rad];
					}
				}
				
				float totalB = 0;
				
				for(int iX = -rad; iX <= rad; iX++) {
					for(int iY = -rad; iY <= rad; iY++) {
						totalB += i.getPixel(x+iX, y+iY)[2] * m[iX+rad][iY+rad];
					}
				}
				
				out.setPixel(x, y, new float[]{totalR, totalG, totalB});
			}
			Logger.uLogger.log("Blur column ", x);
		}
		
		int radT2 = rad*2;
		return out.newCropped(radT2, radT2, out.getWidth()-(radT2+2), out.getHeight()-(radT2+2));
	}
}
