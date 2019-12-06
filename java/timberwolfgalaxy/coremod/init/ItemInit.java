package timberwolfgalaxy.coremod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import timberwolfgalaxy.coremod.objects.armor.ArmorArilium;
import timberwolfgalaxy.coremod.objects.items.ItemAriliumIngot;
import timberwolfgalaxy.coremod.objects.items.ItemCarrackCoin;
import timberwolfgalaxy.coremod.objects.items.ItemRadianCoin;
import timberwolfgalaxy.coremod.objects.items.ItemSilverCoin;
import timberwolfgalaxy.coremod.objects.tools.ToolAriliumAxe;
import timberwolfgalaxy.coremod.objects.tools.ToolAriliumHoe;
import timberwolfgalaxy.coremod.objects.tools.ToolAriliumPickaxe;
import timberwolfgalaxy.coremod.objects.tools.ToolAriliumShovel;
import timberwolfgalaxy.coremod.objects.tools.ToolAriliumSword;
import timberwolfgalaxy.coremod.util.Reference;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial TOOL_ARILIUM = EnumHelper.addToolMaterial("tool_arilium", 4, 2048, 9.0F, 4.0F, 10);
	public static final ArmorMaterial ARMOR_ARILIUM = EnumHelper.addArmorMaterial("armor_arilium", Reference.MODID + ":arilium", -1, new int[]{5, 7, 9, 4}, 10, SoundEvents.BLOCK_NOTE_HARP, 2.5F);	
	
	//Ores
	public static final Item INGOT_ARILIUM = new ItemAriliumIngot("ingot_arilium");
	
	//Currency
	public static final Item COIN_CARRACK = new ItemCarrackCoin("coin_carrack");
	public static final Item COIN_SILVER = new ItemSilverCoin("coin_silver");
	public static final Item COIN_RADIAN = new ItemRadianCoin("coin_radian");
	
	//Tools + Weapons
	public static final Item AXE_ARILIUM = new ToolAriliumAxe("axe_arilium", TOOL_ARILIUM);
	public static final Item HOE_ARILIUM = new ToolAriliumHoe("hoe_arilium", TOOL_ARILIUM);
	public static final Item PICKAXE_ARILIUM = new ToolAriliumPickaxe("pickaxe_arilium", TOOL_ARILIUM);
	public static final Item SHOVEL_ARILIUM = new ToolAriliumShovel("shovel_arilium", TOOL_ARILIUM);
	public static final Item SWORD_ARILIUM = new ToolAriliumSword("sword_arilium", TOOL_ARILIUM);
	
	//Armor
	public static final Item HELMET_ARILIUM = new ArmorArilium("helmet_arilium", ARMOR_ARILIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_ARILIUM = new ArmorArilium("chestplate_arilium", ARMOR_ARILIUM, 3, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_ARILIUM = new ArmorArilium("leggings_arilium", ARMOR_ARILIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_ARILIUM = new ArmorArilium("boots_arilium", ARMOR_ARILIUM, 1, EntityEquipmentSlot.FEET);
}
