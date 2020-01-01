package timberwolfgalaxy.coremod.client.gui;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiShareToLan;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.advancements.GuiScreenAdvancements;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.realms.RealmsBridge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import timberwolfgalaxy.coremod.entity.EntityLabrador;

@SideOnly(Side.CLIENT)
public class MyGui extends GuiScreen
{
    private int saveStep;
    private int visibleTime;
    private EntityLabrador tameable;
    
    
    public MyGui(EntityLabrador tameable) {
    	this.tameable = tameable;
    }
    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        this.saveStep = 0;
        this.buttonList.clear();
        int i = -16;
        int j = 98;

        this.buttonList.add(new GuiButton(1, this.width / 2 - 50, this.height / 8 + 8, 45, 20, I18n.format("tricks.sit")));
        this.buttonList.add(new GuiButton(2, this.width / 2 + 5, this.height / 8 + 8, 45, 20, I18n.format("tricks.stand")));
        this.buttonList.get(1).enabled = false;
        this.buttonList.add(new GuiButton(4, this.width / 2 - 50, this.height / 8 + 8 + 28, 45, 20, I18n.format("tricks.down")));
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException
    {
        switch (button.id)
        {
            case 0:
                this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
                break;
            case 1:
            	if(!this.tameable.world.isRemote){
            		this.tameable.thisSetSitting(true);
            		this.tameable.thisSetDown(false);
					this.tameable.getNavigator().clearPath();
					this.tameable.setAttackTarget((EntityLivingBase) null);
            	}
                this.mc.displayGuiScreen((GuiScreen)null);
                this.mc.setIngameFocus();
            	break;

            case 2:
            	if(!this.tameable.world.isRemote){
            		this.tameable.thisSetSitting(false);
            		this.tameable.thisSetDown(false);
					this.tameable.getNavigator().clearPath();
					this.tameable.setAttackTarget((EntityLivingBase) null);
            	}
                this.mc.displayGuiScreen((GuiScreen)null);
                this.mc.setIngameFocus();
            	break;
            	
            case 3:
            default:
                break;
            case 4:
            	if(!this.tameable.world.isRemote){
            		this.tameable.thisSetSitting(true);
            		this.tameable.thisSetDown(true);
					this.tameable.getNavigator().clearPath();
					this.tameable.setAttackTarget((EntityLivingBase) null);
            	}
                this.mc.displayGuiScreen((GuiScreen)null);
                this.mc.setIngameFocus();
            	break;
            case 5:
                if (this.mc.player != null)
                this.mc.displayGuiScreen(new GuiScreenAdvancements(this.mc.player.connection.getAdvancementManager()));
                break;
            case 6:
                if (this.mc.player != null)
                this.mc.displayGuiScreen(new GuiStats(this, this.mc.player.getStatFileWriter()));
                break;
            case 7:
                this.mc.displayGuiScreen(new GuiShareToLan(this));
                break;
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        ++this.visibleTime;
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, I18n.format("menu.tricks"), this.width / 2, 4, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
        
        this.drawConnector(1, 2);
    }
    
    public void drawConnector(int index1, int index2) {
    	if(buttonList.get(index1).enabled) {
    		drawVerticalLine(buttonList.get(index1).x + buttonList.get(index1).width/2, buttonList.get(index1).y + buttonList.get(index1).height -1, buttonList.get(index1).y + buttonList.get(index1).height + (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))/2, -1);
    		drawHorizontalLine(buttonList.get(index1).x + buttonList.get(index1).width/2, buttonList.get(index2).x + buttonList.get(index2).width/2, buttonList.get(index1).y + buttonList.get(index1).height + (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))/2, -1);
    		drawVerticalLine(buttonList.get(index2).x + buttonList.get(index2).width/2, buttonList.get(index1).y + buttonList.get(index1).height + (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))/2 -1, buttonList.get(index2).y, -1);
    	}else {
    		drawVerticalLine(buttonList.get(index1).x + buttonList.get(index1).width/2, buttonList.get(index1).y + buttonList.get(index1).height -1, buttonList.get(index1).y + buttonList.get(index1).height + (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))/2, Color.DARK_GRAY.getRGB());
    		drawHorizontalLine(buttonList.get(index1).x + buttonList.get(index1).width/2, buttonList.get(index2).x + buttonList.get(index2).width/2, buttonList.get(index1).y + buttonList.get(index1).height + (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))/2, Color.DARK_GRAY.getRGB());
    		drawVerticalLine(buttonList.get(index2).x + buttonList.get(index2).width/2, buttonList.get(index1).y + buttonList.get(index1).height + (buttonList.get(index2).y - (buttonList.get(index1).y + buttonList.get(index1).height))/2 -1, buttonList.get(index2).y, Color.DARK_GRAY.getRGB());
    	}
    	
    	
    }
    
    protected void drawHorizontalLine(int startX, int endX, int y, int color)
    {
        if (endX < startX)
        {
            int i = startX;
            startX = endX;
            endX = i;
        }

        drawRect(startX, y, endX + 1, y + 1, color);
    }

    /**
     * Draw a 1 pixel wide vertical line. Args : x, y1, y2, color
     */
    protected void drawVerticalLine(int x, int startY, int endY, int color)
    {
        if (endY < startY)
        {
            int i = startY;
            startY = endY;
            endY = i;
        }

        drawRect(x, startY + 1, x + 1, endY, color);
    }
}
