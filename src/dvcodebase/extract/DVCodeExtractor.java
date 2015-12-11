package dvcodebase.extract;

import com.deb.lib.image.FloatingImage;
import com.deb.lib.image.IRGBImage;

public class DVCodeExtractor {
	int blurRadius;
	
	public DVCodeExtractor() {
		this.blurRadius = 2;
	}
	
	/**
	 * Extracts the dvcode from an image with default operators.
	 * @param image The image of the dvcode.
	 * @return The dvcode's data.
	 */
	public boolean[] extract(IRGBImage image) {
		return this.extract(image, new BlurApplicator());
	}
	
	public boolean[] extract(IRGBImage image, BlurApplicator bA) {
		FloatingImage blurredImage;
		if (this.blurRadius <= 1) blurredImage = bA.applyCroppedBlurRGB(new FloatingImage(image), this.blurRadius);
		else blurredImage = new FloatingImage(image);
		
		//int[][]
		return null;
	}
}
