package dvcodebase.extract;

import java.awt.Color;

public abstract class ColorTypeConverter {
	/**
	 * Converts a color in the image into the type it's group should be. Should only return 1-3 inclusive.
	 * @param color The color to convert.
	 * @return The type of this color.
	 */
	public abstract int colorToType(Color color);
	
	/**
	 * Converts a color in the image into the type it's group should be. Should only return 1-3 inclusive.
	 * @param color The color to convert.
	 * @return The type of this color.
	 */
	public abstract int floatingColorToType(float[] color);
	
	/**
	 * Converts a type of a group into a representative color, usually a maximum inverse of colorToType().
	 * @param type The type to convert.
	 * @return The color representing this type.
	 */
	public abstract Color typeToColor(int type);
	
	/**
	 * Converts a type of a group into a representative color, usually a maximum inverse of colorToType().
	 * @param type The type to convert.
	 * @return The color representing this type.
	 */
	public abstract float[] typeToFloatingColor(int type);
}
