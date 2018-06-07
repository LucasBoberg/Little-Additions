package xintium.mod.init;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.item.Item;
import xintium.mod.objects.items.ItemBase;
import xintium.mod.objects.items.ItemGrindstone;
import xintium.mod.objects.items.ItemWalkingBelt;
import xintium.mod.objects.items.ItemMagnetCharm;

public class ItemInit {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
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
}
