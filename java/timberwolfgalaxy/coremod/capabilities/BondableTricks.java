package timberwolfgalaxy.coremod.capabilities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BondableTricks implements ITricks{
	
	EntityPlayer player = null;
	boolean[] tricks = {false, false, false, false};

	@Override
	public void setTrick(int trick, boolean state){
		try {
			this.tricks[0] = state;
		}catch(ArrayIndexOutOfBoundsException e) {
			this.postToChat();
		}
	}

	@Override
	public boolean getTrick(int trick){
		try {
			return this.tricks[trick];
		}catch(ArrayIndexOutOfBoundsException e) {
			this.postToChat();
		}
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	private void postToChat(){
		Minecraft.getMinecraft().player.sendChatMessage("Bruh. That trick index doesn't exist. Are you TRYING to crash the server with an ArrayIndexOutOfBoundsException and thinking I haven't planned for it?");
	}

	@Override
	public boolean[] getArray() {
		return this.tricks;
	}
	
	@Override
	public void setPlayer(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public EntityPlayer getPlayer() {
		return this.player;
	}

}
