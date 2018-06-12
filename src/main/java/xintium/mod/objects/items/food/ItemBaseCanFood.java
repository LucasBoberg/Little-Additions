package xintium.mod.objects.items.food;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xintium.mod.Main;
import xintium.mod.init.ItemInit;
import xintium.mod.util.interfaces.IHasModel;


public class ItemBaseCanFood extends ItemFood implements IHasModel {
    public ItemBaseCanFood(String name, float saturation, int amount) {
        super(amount, saturation, false);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.LITTLEADDITIONSTAB);
        setContainerItem(ItemInit.CAN_TIN);
        setMaxStackSize(1);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(ItemInit.CAN_TIN);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
