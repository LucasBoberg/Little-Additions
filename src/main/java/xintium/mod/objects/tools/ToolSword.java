package xintium.mod.objects.tools;

import net.minecraft.item.ItemSword;
import xintium.mod.Main;
import xintium.mod.init.ItemInit;
import xintium.mod.util.handlers.ConfigHandler;
import xintium.mod.util.interfaces.IHasModel;

public class ToolSword extends ItemSword implements IHasModel {
    public ToolSword(String name, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.LITTLEADDITIONSTAB);

        if (!ConfigHandler.bronzeTools){
            ItemInit.ITEMS.add(this);
        }
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
