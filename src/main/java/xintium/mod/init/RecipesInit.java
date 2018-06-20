package xintium.mod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipesInit {

	public static void init() {
		GameRegistry.addSmelting(ItemInit.DUST_COPPER, new ItemStack(ItemInit.INGOT_COPPER), 0.7F);
		GameRegistry.addSmelting(BlockInit.ORE_COPPER, new ItemStack(ItemInit.INGOT_COPPER), 0.7F);
		GameRegistry.addSmelting(ItemInit.DUST_TIN, new ItemStack(ItemInit.INGOT_TIN), 0.7F);
		GameRegistry.addSmelting(BlockInit.ORE_TIN, new ItemStack(ItemInit.INGOT_TIN), 0.7F);

		GameRegistry.addSmelting(BlockInit.ORE_SILVER, new ItemStack(ItemInit.INGOT_SILVER), 0.7F);

		GameRegistry.addSmelting(ItemInit.DUST_BRONZE, new ItemStack(ItemInit.INGOT_BRONZE), 0.7F);
		GameRegistry.addSmelting(ItemInit.DUST_SILVER, new ItemStack(ItemInit.INGOT_SILVER), 0.7F);
		GameRegistry.addSmelting(ItemInit.DUST_ELECTRUM, new ItemStack(ItemInit.INGOT_ELECTRUM), 0.7F);

		GameRegistry.addSmelting(ItemInit.DUST_BRONZE, new ItemStack(ItemInit.INGOT_BRONZE), 0.7F);
		GameRegistry.addSmelting(ItemInit.DUST_IRON, new ItemStack(Items.IRON_INGOT), 0.7F);
		GameRegistry.addSmelting(ItemInit.DUST_GOLD, new ItemStack(Items.GOLD_INGOT), 0.7F);

		GameRegistry.addSmelting(ItemInit.FLOUR, new ItemStack(Items.BREAD), 0.7F);
		GameRegistry.addSmelting(Items.EGG, new ItemStack(ItemInit.BOILED_EGG), 0.7F);
	}
}
