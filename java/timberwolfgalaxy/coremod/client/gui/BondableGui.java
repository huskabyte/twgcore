package timberwolfgalaxy.coremod.client.gui;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.entity.model.ModelLabrador;

@SideOnly(Side.CLIENT)
public class BondableGui extends GuiScreen {
	private int saveStep;
	private int visibleTime;
	private EntityBondable tameable;

	public BondableGui(EntityBondable tameable) {
		this.tameable = tameable;
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question. Called when
	 * the GUI is displayed and when the window resizes, the buttonList is cleared
	 * beforehand.
	 */
	public void initGui() {
		this.saveStep = 0;
		this.buttonList.clear();
		int i = -16;
		int j = 98;

		this.buttonList.add(new GuiButton(1, this.width / 2 - 50, this.height / 8 + 8, 45, 20,
				I18n.format(tameable.getName() + ".trick0")));
		this.buttonList.add(new GuiButton(2, this.width / 2 + 5, this.height / 8 + 8, 45, 20,
				I18n.format(tameable.getName() + ".trick1")));
		this.buttonList.add(new GuiButton(4, this.width / 2 - 50, this.height / 8 + 8 + 28, 45, 20,
				I18n.format(tameable.getName() + ".trick2")));
		this.buttonList.add(new GuiButton(5, this.width / 2 - 100, this.height / 8 + 8 + 28, 45, 20,
				I18n.format(tameable.getName() + ".trick3")));
	}

	public void setTricks(boolean sit, boolean trick2, boolean trick3) {
		this.tameable.thisSetSitting(sit);
		this.tameable.thisSetTrick2(trick2);
		this.tameable.thisSetTrick3(trick3);
	}

	/**
	 * Called by the controls from the buttonList when activated. (Mouse pressed for
	 * buttons)
	 */
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case 0:
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
			break;
		case 1:
			if (!this.tameable.world.isRemote) {
				setTricks(true, false, false);
				this.tameable.getNavigator().clearPath();
				this.tameable.setAttackTarget((EntityLivingBase) null);
			}
			this.mc.displayGuiScreen((GuiScreen) null);
			this.mc.setIngameFocus();
			break;

		case 2:
			if (!this.tameable.world.isRemote) {
				setTricks(false, false, false);
				this.tameable.getNavigator().clearPath();
				this.tameable.setAttackTarget((EntityLivingBase) null);
			}
			this.mc.displayGuiScreen((GuiScreen) null);
			this.mc.setIngameFocus();
			break;

		case 3:
		default:
			break;
		case 4:
			if (!this.tameable.world.isRemote) {
				setTricks(true, true, false);
				this.tameable.getNavigator().clearPath();
				this.tameable.setAttackTarget((EntityLivingBase) null);
			}
			this.mc.displayGuiScreen((GuiScreen) null);
			this.mc.setIngameFocus();
			break;
		case 5:
			if (!this.tameable.world.isRemote) {
				setTricks(true, false, true);
				this.tameable.getNavigator().clearPath();
				this.tameable.setAttackTarget((EntityLivingBase) null);
			}
			this.mc.displayGuiScreen((GuiScreen) null);
			this.mc.setIngameFocus();
			break;
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
		this.drawCenteredString(this.fontRenderer, I18n.format("menu.tricks"), this.width / 2, 4, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);

		this.drawConnector(0, 2);
		this.drawConnector(0, 3);
	}

	public void drawConnector(int index1, int index2) {
		if (buttonList.get(index1).enabled) {
			drawVerticalLine(buttonList.get(index1).x + buttonList.get(index1).width / 2,
					buttonList.get(index1).y + buttonList.get(index1).height - 1,
					buttonList.get(index1).y + buttonList.get(index1).height
							+ (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))
									/ 2,
					-1);
			drawHorizontalLine(buttonList.get(index1).x + buttonList.get(index1).width / 2,
					buttonList.get(index2).x + buttonList.get(index2).width / 2,
					buttonList.get(index1).y + buttonList.get(index1).height
							+ (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))
									/ 2,
					-1);
			drawVerticalLine(buttonList.get(index2).x + buttonList.get(index2).width / 2, buttonList.get(index1).y
					+ buttonList.get(index1).height
					+ (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height)) / 2 - 1,
					buttonList.get(index2).y, -1);
		} else {
			drawVerticalLine(buttonList.get(index1).x + buttonList.get(index1).width / 2,
					buttonList.get(index1).y + buttonList.get(index1).height - 1,
					buttonList.get(index1).y + buttonList.get(index1).height
							+ (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))
									/ 2,
					Color.DARK_GRAY.getRGB());
			drawHorizontalLine(buttonList.get(index1).x + buttonList.get(index1).width / 2,
					buttonList.get(index2).x + buttonList.get(index2).width / 2,
					buttonList.get(index1).y + buttonList.get(index1).height
							+ (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))
									/ 2,
					Color.DARK_GRAY.getRGB());
			drawVerticalLine(buttonList.get(index2).x + buttonList.get(index2).width / 2, buttonList.get(index1).y
					+ buttonList.get(index1).height
					+ (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height)) / 2 - 1,
					buttonList.get(index2).y, Color.DARK_GRAY.getRGB());
		}

	}

	protected void drawHorizontalLine(int startX, int endX, int y, int color) {
		if (endX < startX) {
			int i = startX;
			startX = endX;
			endX = i;
		}

		drawRect(startX, y, endX + 1, y + 1, color);
	}

	/**
	 * Draw a 1 pixel wide vertical line. Args : x, y1, y2, color
	 */
	protected void drawVerticalLine(int x, int startY, int endY, int color) {
		if (endY < startY) {
			int i = startY;
			startY = endY;
			endY = i;
		}

		drawRect(x, startY + 1, x + 1, endY, color);
	}
}