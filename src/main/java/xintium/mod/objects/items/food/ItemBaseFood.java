package xintium.mod.objects.items.food;

import net.minecraft.item.ItemFood;
import xintium.mod.Main;
import xintium.mod.init.ItemInit;
import xintium.mod.util.interfaces.IHasModel;

public class ItemBaseFood extends ItemFood implements IHasModel {
    public ItemBaseFood(String name, float saturation, int amount, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
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
