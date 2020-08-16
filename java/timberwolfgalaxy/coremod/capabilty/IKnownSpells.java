package timberwolfgalaxy.coremod.capabilty;

public interface IKnownSpells {
	public void learnAll();
	public boolean learn(int spell);
	public boolean unlearn(int spell);
	public int[] getKnownSpells();
	public void setKnownSpells(int[] spells);
}
