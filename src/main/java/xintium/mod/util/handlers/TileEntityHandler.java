package xintium.mod.util.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import xintium.mod.objects.blocks.machines.alloymerger.TileEntityAlloyMerger;
import xintium.mod.objects.blocks.machines.crusher.TileEntityCrusher;
import xintium.mod.objects.blocks.machines.furnace.TileEntityBronzeFurnace;

public class TileEntityHandler {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityAlloyMerger.class, "alloy_merger");
        GameRegistry.registerTileEntity(TileEntityCrusher.class, "crusher");
        GameRegistry.registerTileEntity(TileEntityBronzeFurnace.class, "bronze_furnace");
    }
}
