package xintium.mod.util.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import xintium.mod.objects.blocks.machines.alloymerger.ContainerAlloyMerger;
import xintium.mod.objects.blocks.machines.alloymerger.GuiAlloyMerger;
import xintium.mod.objects.blocks.machines.alloymerger.TileEntityAlloyMerger;
import xintium.mod.objects.blocks.machines.crusher.ContainerCrusher;
import xintium.mod.objects.blocks.machines.crusher.GuiCrusher;
import xintium.mod.objects.blocks.machines.crusher.TileEntityCrusher;
import xintium.mod.objects.blocks.machines.furnace.ContainerBronzeFurnace;
import xintium.mod.objects.blocks.machines.furnace.GuiBronzeFurnace;
import xintium.mod.objects.blocks.machines.furnace.TileEntityBronzeFurnace;
import xintium.mod.util.Reference;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == ConfigHandler.GUI_ALLOY_MERGER) return new ContainerAlloyMerger(player.inventory, (TileEntityAlloyMerger)world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == ConfigHandler.GUI_CRUSHER) return new ContainerCrusher(player.inventory, (TileEntityCrusher)world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == ConfigHandler.GUI_BRONZE_FURNACE) return new ContainerBronzeFurnace(player.inventory, (TileEntityBronzeFurnace)world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == ConfigHandler.GUI_ALLOY_MERGER) return new GuiAlloyMerger(player.inventory, (TileEntityAlloyMerger)world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == ConfigHandler.GUI_CRUSHER) return new GuiCrusher(player.inventory, (TileEntityCrusher)world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == ConfigHandler.GUI_BRONZE_FURNACE) return new GuiBronzeFurnace(player.inventory, (TileEntityBronzeFurnace)world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }
}
