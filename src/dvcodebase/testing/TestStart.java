package dvcodebase.testing;

import java.awt.image.BufferedImage;

import com.deb.lib.image.FloatingImage;
import com.deb.lib.image.IRGBImage;
import com.deb.lib.program.ProgramFs;

import dvcodebase.extract.ColorTypeConverterStandard;
import dvcodebase.extract.DVCodeExtractor;

public class TestStart {

	public static void main(String[] args) {
		IRGBImage i = new IRGBImage(ProgramFs.getProgramFile("testing/test.png"));
		DVCodeExtractor dv = new DVCodeExtractor();
		dv.extract(i);

	}
	
	public static void outTypes(int[][] types) {
		FloatingImage f = new FloatingImage(types.length, types[0].length, 3, BufferedImage.TYPE_INT_RGB);
		ColorTypeConverterStandard cTC = new ColorTypeConverterStandard();
		
		for(int x = 0; x < types.length; x++) {
			for(int y = 0; y < types[0].length; y++) {
				f.setPixel(x, y, cTC.typeToFloatingColor(types[x][y]));
			}
		}
		
		f.getToIRGB().writeImage("png", ProgramFs.getProgramFile("testing/types.png"));
	}
	
	public static void outGroups(int[][] groups, int gTotal) {
		FloatingImage out = new FloatingImage(groups.length, groups[0].length, 1, BufferedImage.TYPE_BYTE_GRAY);
		for(int x = 0; x < groups.length; x++) {
			for(int y = 0; y < groups[0].length; y++) {
				out.setPixel(x, y, new float[]{((float)groups[x][y])/gTotal});
			}
		}
		out.getToBGRAY().writeImage("png", ProgramFs.getProgramFile("testinf/grouptest.png"));
	}

}
