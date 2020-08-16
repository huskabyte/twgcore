package timberwolfgalaxy.coremod.capabilty;

public class Level implements ILevel{
	
	private int level = 0;
	
	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void levelUp() {
		level++;
	}

	@Override
	public int getLevel() {
		return level;
	}

}
