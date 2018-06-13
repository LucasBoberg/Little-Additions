package xintium.mod.util.compat;

import net.minecraftforge.oredict.OreDictionary;
import xintium.mod.init.BlockInit;
import xintium.mod.init.ItemInit;

public class OreDictionaryCompat {

    public static void registerOres() {
        OreDictionary.registerOre("oreCopper", BlockInit.ORE_COPPER);
        OreDictionary.registerOre("oreTin", BlockInit.ORE_TIN);
        OreDictionary.registerOre("oreSilver", BlockInit.ORE_SILVER);
        OreDictionary.registerOre("blockCopper", BlockInit.BLOCK_COPPER);
        OreDictionary.registerOre("blockTin", BlockInit.BLOCK_TIN);
        OreDictionary.registerOre("blockBronze", BlockInit.BLOCK_BRONZE);
        OreDictionary.registerOre("blockSilver", BlockInit.BLOCK_SILVER);
        OreDictionary.registerOre("blockElectrum", BlockInit.BLOCK_ELECTRUM);
        OreDictionary.registerOre("ingotCopper", ItemInit.INGOT_COPPER);
        OreDictionary.registerOre("ingotTin", ItemInit.INGOT_TIN);
        OreDictionary.registerOre("ingotBronze", ItemInit.INGOT_BRONZE);
        OreDictionary.registerOre("ingotSilver", ItemInit.INGOT_SILVER);
        OreDictionary.registerOre("ingotElectrum", ItemInit.INGOT_ELECTRUM);
        OreDictionary.registerOre("dustCopper", ItemInit.DUST_COPPER);
        OreDictionary.registerOre("dustTin", ItemInit.DUST_TIN);
        OreDictionary.registerOre("dustBronze", ItemInit.DUST_BRONZE);
        OreDictionary.registerOre("dustSilver", ItemInit.DUST_SILVER);
        OreDictionary.registerOre("dustElectrum", ItemInit.DUST_ELECTRUM);
        OreDictionary.registerOre("nuggetCopper", ItemInit.NUGGET_COPPER);
        OreDictionary.registerOre("nuggetTin", ItemInit.NUGGET_TIN);
        OreDictionary.registerOre("nuggetBronze", ItemInit.NUGGET_BRONZE);
        OreDictionary.registerOre("nuggetSilver", ItemInit.NUGGET_SILVER);
        OreDictionary.registerOre("nuggetElectrum", ItemInit.NUGGET_ELECTRUM);
        OreDictionary.registerOre("dustCoal", ItemInit.DUST_COAL);
        OreDictionary.registerOre("dustGold", ItemInit.DUST_GOLD);
        OreDictionary.registerOre("dustIron", ItemInit.DUST_IRON);

        OreDictionary.registerOre("cropTomato", ItemInit.TOMATO);
        OreDictionary.registerOre("dyeRed", ItemInit.TOMATO);
    }
}
