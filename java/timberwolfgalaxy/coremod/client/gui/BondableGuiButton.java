package timberwolfgalaxy.coremod.client.gui;

import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;

public class BondableGuiButton extends GuiButton{
	
	private ArrayList<BondableGuiButton> dependencies = new ArrayList<BondableGuiButton>();
	public boolean unknown = true;

	public BondableGuiButton(int buttonId, int x, int y, String buttonText) {
		super(buttonId, x, y, 45, 20, buttonText);
		
		checkForEnable();
		if(this.unknown) this.enabled = false; else this.enabled = true;
	}
	
	public void activeTrick(boolean active) {
		this.enabled = false;
	}
	
	public void checkForEnable() {
		for(int i = 0; i < dependencies.size(); i++) {
			if(dependencies.get(i).unknown && i == dependencies.size()-1) {
				this.unknown = true;
			}else if(dependencies.get(i).unknown){
				break;
			}
		}
	}
	
	public void addDependency(BondableGuiButton button) {
		dependencies.add(button);
	}
	
	public void learn() {
		this.unknown = false;
		this.enabled = true;
	}
	
	public void unlearn() {
		this.unknown = true;
		this.enabled = false;
	}

}
