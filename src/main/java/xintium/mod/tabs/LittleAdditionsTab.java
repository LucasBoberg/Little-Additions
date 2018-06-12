package xintium.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import xintium.mod.init.BlockInit;
import xintium.mod.util.Reference;

public class LittleAdditionsTab extends CreativeTabs {

	public LittleAdditionsTab(String label) {
		super("littleadditionstab");
		setBackgroundImageName("little_additions_background.png");
	}

	@Override
	public ItemStack getTabIconItem() { return new ItemStack(Item.getItemFromBlock(BlockInit.ALLOY_MERGER)); }

	@Override
	public boolean hasSearchBar() {
		return true;
	}

	@Override
	public int getSearchbarWidth() {
		return 84;
	}
}
