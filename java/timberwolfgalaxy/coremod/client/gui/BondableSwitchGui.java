package timberwolfgalaxy.coremod.client.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.init.EntityInit;
import timberwolfgalaxy.coremod.util.handlers.SwitchPacketHandler;
import timberwolfgalaxy.coremod.util.packets.PacketBondableSwitch;

@SideOnly(Side.CLIENT)
public class BondableSwitchGui extends GuiScreen {
	private int saveStep;
	private int visibleTime;
	private int page = 0;
	private EntityBondable bondable;

	public BondableSwitchGui(EntityBondable bondable) {
		this.bondable = bondable;
	}

	public void addButton(BondableGuiButton button) {
		this.buttonList.add(button);
	}
	
	public void initGui() {
		this.saveStep = 0;
		this.buttonList.clear();
		
		this.addButton(new GuiButton(-1, 0, 0, 45, 20, I18n.format("bonded.close")));
		
		this.addButton(new GuiButton(-2, 50, 0, 20, 20, "<"));
		this.addButton(new GuiButton(-3, 75, 0, 20, 20, ">"));
		addButtons();
	}

	/**
	 * Called by the controls from the buttonList when activated. (Mouse pressed for
	 * buttons)
	 */
	protected void actionPerformed(GuiButton button) throws IOException {
		
		if(button.id >=0) {
			SwitchPacketHandler.INSTANCE.sendToServer(new PacketBondableSwitch(button.id));
		}else {
			switch(button.id) {
				case -2:
					page--;
					this.buttonList.clear();
					this.addButton(new GuiButton(-1, 0, 0, 45, 20, I18n.format("bonded.close")));
					
					this.addButton(new GuiButton(-2, 50, 0, 20, 20, "<"));
					this.addButton(new GuiButton(-3, 75, 0, 20, 20, ">"));
					addButtons();
					
					return;
				case -3:
					page++;
					this.buttonList.clear();
					this.addButton(new GuiButton(-1, 0, 0, 45, 20, I18n.format("bonded.close")));
					
					this.addButton(new GuiButton(-2, 50, 0, 20, 20, "<"));
					this.addButton(new GuiButton(-3, 75, 0, 20, 20, ">"));
					addButtons();
					
					return;
			}
		}
		
		
		this.mc.displayGuiScreen((GuiScreen) null);
		this.mc.setIngameFocus();
	}
	
	private void addButtons() {
		for(int i = 0; i + (page * 25) < EntityInit.bondableIdList.size() && i < 25; i++) {
			if(EntityBondable.hasBondable(bondable, EntityInit.bondableIdList.get(i))) {
				GuiButton button = new GuiButton(i + (page * 25), (int)(70*((Math.floor(i/5)) + 1)), 40 * (i%5 + 1), 70, 20, I18n.format("entity." + EntityInit.bondableIdList.get(i + (page * 25)) + ".name"));
				button.enabled = true;
				this.addButton(button);
			}else {
				GuiButton button = new GuiButton(i + (page * 25), (int)(70*((Math.floor(i/5)) + 1)), 40 * (i%5 + 1), 70, 20, I18n.format("entity." + EntityInit.bondableIdList.get(i + (page * 25)) + ".name"));
				button.enabled = false;
				this.addButton(button);
			}
		}
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	public void updateScreen() {
		super.updateScreen();
		++this.visibleTime;
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, I18n.format("menu.switch"), this.width / 2, 4, 16777215);
		this.drawString(this.fontRenderer, I18n.format("menu.page") + " " + (page + 1), 100, 0, 16777215);
		
		if(page == 0) {
			this.buttonList.get(1).enabled = false;
		}else {
			this.buttonList.get(1).enabled = true;
		}
		if((float)page+1 >= ((float)EntityInit.bondableIdList.size())/25F) {
			this.buttonList.get(2).enabled = false;
		}else {
			this.buttonList.get(2).enabled = true;
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}


}
