package dvcodebase.extract;

import java.util.ArrayList;

public class Grouper {

	public void group(int[][] types) {
		Pixel[][] pixels = new Pixel[types.length][types[0].length];
		ArrayList<Group> groups = new ArrayList<>();
		
		for(int x = 0; x < types.length; x++) {
			for(int y = 0; y < types[0].length; y++) {
				int xPType = -1;
				int xNType = -1;
				int yPType = -1;
				int yNType = -1;

				try{xPType = types[x+1][y];}catch(Exception e) {}
				try{xNType = types[x-1][y];}catch(Exception e) {}
				try{yPType = types[x][y+1];}catch(Exception e) {}
				try{yNType = types[x][y-1];}catch(Exception e) {}
				
				Pixel p = new Pixel(types[x][y], x, y, null, xPType, xNType, yPType, yNType);
				Group g = new Group();
				g.add(p);
				p.group = g;
				
				pixels[x][y] = p;
				groups.add(g);
			}
		}
		
		for(int x = 0; x < types.length; x++) {
			for(int y = 0; y < types[0].length; y++) {
				if(pixels[x][y].xPType == pixels[x][y].type) {
					pixels[x][y].group.merge(pixels[x+1][y].group);
				}
				
				if(pixels[x][y].yPType == pixels[x][y].type) {
					pixels[x][y].group.merge(pixels[x][y+1].group);
				}
			}
		}
		
		for(int i = 0; i < groups.size(); i++) {
			if(groups.get(i).pixels.size() == 0){
				groups.remove(0);
				i--;
			}
		}
	}
	
	/*int[][] types;
	int[][] groups;
	int numGroups;
	
	public void group(int[][] types) {
		this.types = types;
		this.groups = new int[this.types.length][this.types[0].length];
		this.numGroups = 0;

		int surroundingGroup = -1;
		
		for(int x = 0; x < this.types.length; x++) {
			for(int y = 0; y < this.types[0].length; y++) {
				try { if(this.types[x][y] == this.types[x+1][y] && this.groups[x+1][y] != 0) surroundingGroup = this.groups[x+1][y]; }catch(Exception e){}
				try { if(this.types[x][y] == this.types[x-1][y] && this.groups[x-1][y] != 0) surroundingGroup = this.groups[x-1][y]; }catch(Exception e){}
				try { if(this.types[x][y] == this.types[x][y+1] && this.groups[x][y+1] != 0) surroundingGroup = this.groups[x][y+1]; }catch(Exception e){}
				try { if(this.types[x][y] == this.types[x][y-1] && this.groups[x][y-1] != 0) surroundingGroup = this.groups[x][y-1]; }catch(Exception e){}
				
				if(surroundingGroup == -1) {
					this.groups[x][y] = this.numGroups+1;
					this.numGroups++;
				}
				
				updateGroups(x, y);
				
				//Reset temp var
				surroundingGroup = -1;
			}
		}
		TestStart.outGroups(this.groups, this.numGroups);
	}
	
	void updateGroups(int x, int y) {
		Logger.uLogger.logMore("Update position", new Integer[]{x,y});
		try { if(this.types[x][y] == this.types[x+1][y] && this.groups[x+1][y] != this.groups[x][y]) {
			this.groups[x+1][y] = this.groups[x][y];
			updateGroups(x+1, y);
		}}catch(Exception e){}
		
		try { if(this.types[x][y] == this.types[x-1][y] && this.groups[x-1][y] != this.groups[x][y]) {
			this.groups[x-1][y] = this.groups[x][y];
			updateGroups(x-1, y);
		}}catch(Exception e){}
		
		try { if(this.types[x][y] == this.types[x][y+1] && this.groups[x][y+1] != this.groups[x][y]) {
			this.groups[x][y+1] = this.groups[x][y];
			updateGroups(x, y+1);
		}}catch(Exception e){}
		
		try { if(this.types[x][y] == this.types[x][y-1] && this.groups[x][y-1] != this.groups[x][y]) {
			this.groups[x][y-1] = this.groups[x][y];
			updateGroups(x, y-1);
		}}catch(Exception e){}
	}*/
}
