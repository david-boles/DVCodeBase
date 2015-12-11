package dvcodebase.extract;

import java.awt.Color;

public class ColorTypeConverterStandard extends ColorTypeConverter {
	
	@Override
	public int colorToType(Color color) {
		if(color.getRed() >= color.getGreen() && color.getRed() >= color.getBlue()) return 0;
		if(color.getGreen() >= color.getRed() && color.getGreen() >= color.getBlue()) return 1;
		if(color.getBlue() >= color.getRed() && color.getBlue() >= color.getGreen()) return 2;
		return -1;
	}

	@Override
	public Color typeToColor(int type) {
		if(type == 0) return Color.RED;
		if(type == 1) return Color.GREEN;
		if(type == 2) return Color.BLUE;
		return Color.WHITE;
	}

}
