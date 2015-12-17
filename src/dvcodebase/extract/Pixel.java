package dvcodebase.extract;

public class Pixel {
	int type;
	int x;
	int y;
	Group group;
	int xPType;
	int xNType;
	int yPType;
	int yNType;
	
	public Pixel(int type, int x, int y, Group group, int xPType, int xNType, int yPType, int yNType) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.group = group;
		this.xPType = xPType;
		this.xNType = xNType;
		this.yPType = yPType;
		this.yNType = yNType;
	}
}
