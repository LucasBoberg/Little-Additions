package xintium.mod.init;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import xintium.mod.objects.armor.ArmorBase;
import xintium.mod.objects.items.ItemBase;
import xintium.mod.objects.items.ItemGrindstone;
import xintium.mod.objects.items.ItemWalkingBelt;
import xintium.mod.objects.items.ItemMagnetCharm;
import xintium.mod.objects.items.food.ItemBaseCanFood;
import xintium.mod.objects.items.food.ItemBaseFood;
import xintium.mod.objects.items.food.ItemSeedsTomato;
import xintium.mod.objects.tools.*;
import xintium.mod.util.Reference;

public class ItemInit {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	// Materials
    public static final ToolMaterial TOOL_BRONZE = EnumHelper.addToolMaterial("tool_bronze", 2, 190, 5.0F, 1.6F, 18);
    public static final ArmorMaterial ARMOR_BRONZE = EnumHelper.addArmorMaterial("armor_bronze", Reference.MODID + ":bronze", 14, new int[]{2, 5, 5, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	// Items
	public static final Item INGOT_COPPER = new ItemBase("ingot_copper");
	public static final Item NUGGET_COPPER = new ItemBase("nugget_copper");
	public static final Item DUST_COPPER = new ItemBase("dust_copper");
	public static final Item INGOT_TIN = new ItemBase("ingot_tin");
	public static final Item NUGGET_TIN = new ItemBase("nugget_tin");
	public static final Item DUST_TIN = new ItemBase("dust_tin");

    public static final Item INGOT_BRONZE = new ItemBase("ingot_bronze");
    public static final Item NUGGET_BRONZE = new ItemBase("nugget_bronze");
    public static final Item DUST_BRONZE = new ItemBase("dust_bronze");

	public static final Item INGOT_SILVER = new ItemBase("ingot_silver");
	public static final Item NUGGET_SILVER = new ItemBase("nugget_silver");
	public static final Item DUST_SILVER = new ItemBase("dust_silver");

	public static final Item INGOT_ELECTRUM = new ItemBase("ingot_electrum");
	public static final Item NUGGET_ELECTRUM = new ItemBase("nugget_electrum");
	public static final Item DUST_ELECTRUM = new ItemBase("dust_electrum");

	public static final Item DUST_COAL = new ItemBase("dust_coal");
	public static final Item DUST_GOLD = new ItemBase("dust_gold");
	public static final Item DUST_IRON = new ItemBase("dust_iron");

	public static final Item PCB = new ItemBase("pcb");
	public static final Item GRINDSTONE = new ItemGrindstone("grindstone");

	public static final Item BLANK_CORE = new ItemBase("blank_core");
	public static final Item MAGNET = new ItemBase("magnet");
	public static final Item BELT = new ItemBase("belt");
	public static final Item SPEED_CORE = new ItemBase("speed_core");
	public static final Item MAGNET_CORE = new ItemBase("magnet_core");
	public static final Item WALKING_BELT = new ItemWalkingBelt("walking_belt");
	public static final Item MAGNET_CHARM = new ItemMagnetCharm("magnet_charm");

	// Food
    public static final Item FLOUR = new ItemBase("flour");
    public static final Item CAN_TIN = new ItemBase("can_tin");
    public static final Item SAUCE_TOMATO = new ItemBaseCanFood("sauce_tomato", 1.2f, 4);

    public static final Item TOMATO = new ItemBaseFood("tomato", 1.0f, 2, false);
    public static final Item SEEDS_TOMATO = new ItemSeedsTomato("seeds_tomato");

    public static final Item CHEESE = new ItemBaseFood("cheese", 1.2f, 5, false);
    public static final Item PIZZA = new ItemBaseFood("pizza", 0.8f, 18, true);

	// Tools
    public static final Item AXE_BRONZE = new ToolAxe("axe_bronze", TOOL_BRONZE);
    public static final Item HOE_BRONZE = new ToolHoe("hoe_bronze", TOOL_BRONZE);
    public static final Item PICKAXE_BRONZE = new ToolPickaxe("pickaxe_bronze", TOOL_BRONZE);
    public static final Item SHOVEL_BRONZE = new ToolShovel("shovel_bronze", TOOL_BRONZE);
    public static final Item SWORD_BRONZE = new ToolSword("sword_bronze", TOOL_BRONZE);

    // Armor
    public static final Item HELMET_BRONZE = new ArmorBase("helmet_bronze", ARMOR_BRONZE, 1, EntityEquipmentSlot.HEAD);
    public static final Item CHESTPLATE_BRONZE = new ArmorBase("chestplate_bronze", ARMOR_BRONZE, 1, EntityEquipmentSlot.CHEST);
    public static final Item LEGGINGS_BRONZE = new ArmorBase("leggings_bronze", ARMOR_BRONZE, 2, EntityEquipmentSlot.LEGS);
    public static final Item BOOTS_BRONZE = new ArmorBase("boots_bronze", ARMOR_BRONZE, 1, EntityEquipmentSlot.FEET);
}
