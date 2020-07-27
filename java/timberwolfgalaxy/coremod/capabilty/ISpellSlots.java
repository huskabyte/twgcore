package timberwolfgalaxy.coremod.capabilty;

import java.util.ArrayList;

public interface ISpellSlots {
	public void fillSlots();
	public void consume(int level, int number);
	public void set(int level, int number);
	public int[] getMaxSlots();
	
	public int[] getSlots();
}
