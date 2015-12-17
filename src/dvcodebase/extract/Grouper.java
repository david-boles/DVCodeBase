package dvcodebase.extract;

import com.deb.lib.program.Logger;

import dvcodebase.testing.TestStart;

public class Grouper {
	
	int[][] types;
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
	}
}
