package xintium.mod.objects.items;

import net.minecraft.item.Item;
import xintium.mod.Main;
import xintium.mod.init.ItemInit;
import xintium.mod.util.interfaces.IHasModel;

public class ItemBase extends Item implements IHasModel {
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.LITTLEADDITIONSTAB);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
