package xintium.mod.objects.tools;

import net.minecraft.item.ItemSpade;
import xintium.mod.Main;
import xintium.mod.init.ItemInit;
import xintium.mod.util.handlers.ConfigHandler;
import xintium.mod.util.interfaces.IHasModel;

public class ToolShovel extends ItemSpade implements IHasModel {
    public ToolShovel(String name, ToolMaterial material) {
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
