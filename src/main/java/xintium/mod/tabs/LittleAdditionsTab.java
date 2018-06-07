package xintium.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xintium.mod.init.BlockInit;

public class LittleAdditionsTab extends CreativeTabs {

	public LittleAdditionsTab(String label) { super("littleadditionstab"); }

	@Override
	public ItemStack getTabIconItem() { return new ItemStack(Item.getItemFromBlock(BlockInit.ALLOY_MERGER)); }
}
