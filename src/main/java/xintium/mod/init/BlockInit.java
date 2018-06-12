package xintium.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import xintium.mod.objects.blocks.BlockBase;
import xintium.mod.objects.blocks.BlockBasicMetal;
import xintium.mod.objects.blocks.BlockBasicOre;
import xintium.mod.objects.blocks.BlockTomatoPlant;
import xintium.mod.objects.blocks.machines.alloymerger.BlockAlloyMerger;
import xintium.mod.objects.blocks.machines.crusher.BlockCrusher;
import xintium.mod.objects.blocks.machines.furnace.BlockBronzeFurnace;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_COPPER = new BlockBasicMetal("block_copper", Material.ROCK);
	public static final Block ORE_COPPER = new BlockBasicOre("ore_copper", Material.ROCK);
	public static final Block BLOCK_TIN = new BlockBasicMetal("block_tin", Material.ROCK);
	public static final Block ORE_TIN = new BlockBasicOre("ore_tin", Material.ROCK);
	public static final Block BLOCK_SILVER = new BlockBasicMetal("block_silver", Material.IRON);
	public static final Block ORE_SILVER = new BlockBasicOre("ore_silver", Material.ROCK);

	public static final Block BLOCK_BRONZE = new BlockBasicMetal("block_bronze", Material.ROCK);
	public static final Block BLOCK_ELECTRUM = new BlockBasicMetal("block_electrum", Material.IRON);

    public static final Block CASE_MACHINE = new BlockBasicMetal("case_machine", Material.ROCK);
	public static final Block ALLOY_MERGER = new BlockAlloyMerger("alloy_merger");
	public static final Block CRUSHER = new BlockCrusher("crusher");
	public static final Block BRONZE_FURNACE = new BlockBronzeFurnace("bronze_furnace");

	public static final Block TOMATO_PLANT = new BlockTomatoPlant("tomato_plant");
}
