package dvcodebase.extract;

import com.deb.lib.image.FloatingImage;
import com.deb.lib.image.IRGBImage;

import dvcodebase.testing.TestStart;

public class DVCodeExtractor {
	
	/**
	 * Extracts the dvcode from an image with default operators.
	 * @param image The image of the dvcode.
	 * @return The dvcode's data.
	 */
	public boolean[] extract(IRGBImage image) {
		return this.extract(image, new BlurApplicator(), 2, new TypeDeterminator(), new Grouper());
	}
	
	public boolean[] extract(IRGBImage image, BlurApplicator bA, int blurRadius, TypeDeterminator tD, Grouper g) {
		FloatingImage blurredImage;
		if (blurRadius <= 1) blurredImage = bA.applyCroppedBlurRGB(new FloatingImage(image), blurRadius);
		else blurredImage = new FloatingImage(image);
		
		int[][] pixelTypes = tD.determineTypes(blurredImage);
		
		//TestStart.outTypes(pixelTypes);
		
		g.group(pixelTypes);
		
		return null;
	}
}
