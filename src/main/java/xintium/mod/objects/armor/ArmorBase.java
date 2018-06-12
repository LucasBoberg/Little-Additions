package xintium.mod.objects.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import xintium.mod.Main;
import xintium.mod.init.ItemInit;
import xintium.mod.util.handlers.ConfigHandler;
import xintium.mod.util.interfaces.IHasModel;

public class ArmorBase extends ItemArmor implements IHasModel {

    public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.LITTLEADDITIONSTAB);

        if (!ConfigHandler.bronzeArmor){
            ItemInit.ITEMS.add(this);
        }
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
