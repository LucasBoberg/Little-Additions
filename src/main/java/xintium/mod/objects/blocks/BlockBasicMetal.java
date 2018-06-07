package xintium.mod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import xintium.mod.Main;
import xintium.mod.init.BlockInit;
import xintium.mod.init.ItemInit;
import xintium.mod.util.interfaces.IHasModel;

public class BlockBasicMetal extends Block implements IHasModel {
	
	public BlockBasicMetal(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.STONE);
		setHardness(5.0F);
		setResistance(25.0F);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(Main.LITTLEADDITIONSTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
