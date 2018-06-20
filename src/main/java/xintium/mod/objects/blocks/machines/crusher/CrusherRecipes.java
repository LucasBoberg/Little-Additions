package xintium.mod.objects.blocks.machines.crusher;

import com.google.common.collect.Maps;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;
import xintium.mod.init.BlockInit;
import xintium.mod.init.ItemInit;

import java.util.Map;

public class CrusherRecipes {
    private static final CrusherRecipes INSTANCE = new CrusherRecipes();
    private final Map<ItemStack, ItemStack> crusherList = Maps.<ItemStack, ItemStack>newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static CrusherRecipes getInstance() {
        return INSTANCE;
    }

    private CrusherRecipes() {
        // Copper
        NonNullList<ItemStack> stacksOreCopper = OreDictionary.getOres("oreCopper");
        for(ItemStack stackOreCopper : stacksOreCopper) {
            addCrusherRecipe(stackOreCopper, new ItemStack(ItemInit.DUST_COPPER, 2), 2.0F);
        }
        NonNullList<ItemStack> stacksIngotCopper = OreDictionary.getOres("ingotCopper");
        for(ItemStack stackIngotCopper : stacksIngotCopper) {
            addCrusherRecipe(stackIngotCopper, new ItemStack(ItemInit.DUST_COPPER, 1), 1.0F);
        }
        NonNullList<ItemStack> stacksBlockCopper = OreDictionary.getOres("blockCopper");
        for(ItemStack stackBlockCopper : stacksBlockCopper) {
            addCrusherRecipe(stackBlockCopper, new ItemStack(ItemInit.DUST_COPPER, 9), 4.0F);
        }

        // Tin
        NonNullList<ItemStack> stacksOreTin = OreDictionary.getOres("oreTin");
        for(ItemStack stackOreTin : stacksOreTin) {
            addCrusherRecipe(stackOreTin, new ItemStack(ItemInit.DUST_TIN, 2), 2.0F);
        }
        NonNullList<ItemStack> stacksIngotTin = OreDictionary.getOres("ingotTin");
        for(ItemStack stackIngotTin : stacksIngotTin) {
            addCrusherRecipe(stackIngotTin, new ItemStack(ItemInit.DUST_TIN, 1), 1.0F);
        }
        NonNullList<ItemStack> stacksBlockTin = OreDictionary.getOres("blockTin");
        for(ItemStack stackBlockTin : stacksBlockTin) {
            addCrusherRecipe(stackBlockTin, new ItemStack(ItemInit.DUST_TIN, 9), 4.0F);
        }

        // Silver
        NonNullList<ItemStack> stacksOreSilver = OreDictionary.getOres("oreSilver");
        for(ItemStack stackOreSilver : stacksOreSilver) {
            addCrusherRecipe(stackOreSilver, new ItemStack(ItemInit.DUST_SILVER, 2), 2.0F);
        }
        NonNullList<ItemStack> stacksIngotSilver = OreDictionary.getOres("ingotSilver");
        for(ItemStack stackIngotSilver : stacksIngotSilver) {
            addCrusherRecipe(stackIngotSilver, new ItemStack(ItemInit.DUST_SILVER, 1), 1.0F);
        }
        NonNullList<ItemStack> stacksBlockSilver = OreDictionary.getOres("blockSilver");
        for(ItemStack stackBlockSilver : stacksBlockSilver) {
            addCrusherRecipe(stackBlockSilver, new ItemStack(ItemInit.DUST_SILVER, 9), 4.0F);
        }

        // Bronze
        NonNullList<ItemStack> stacksIngotBronze = OreDictionary.getOres("ingotBronze");
        for(ItemStack stackIngotBronze : stacksIngotBronze) {
            addCrusherRecipe(stackIngotBronze, new ItemStack(ItemInit.DUST_BRONZE, 1), 1.0F);
        }
        NonNullList<ItemStack> stacksBlockBronze = OreDictionary.getOres("blockBronze");
        for(ItemStack stackBlockBronze : stacksBlockBronze) {
            addCrusherRecipe(stackBlockBronze, new ItemStack(ItemInit.DUST_BRONZE, 9), 4.0F);
        }

        // Electrum
        NonNullList<ItemStack> stacksIngotElectrum = OreDictionary.getOres("ingotElectrum");
        for(ItemStack stackIngotElectrum : stacksIngotElectrum) {
            addCrusherRecipe(stackIngotElectrum, new ItemStack(ItemInit.DUST_ELECTRUM, 1), 1.0F);
        }
        NonNullList<ItemStack> stacksBlockElectrum = OreDictionary.getOres("blockElectrum");
        for(ItemStack stackBlockElectrum : stacksBlockElectrum) {
            addCrusherRecipe(stackBlockElectrum, new ItemStack(ItemInit.DUST_ELECTRUM, 9), 4.0F);
        }

        // Vanilla
        addCrusherRecipe(new ItemStack(Items.COAL), new ItemStack(ItemInit.DUST_COAL, 1), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.COAL_BLOCK)), new ItemStack(ItemInit.DUST_COAL, 9), 4.0F);

        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.GOLD_ORE)), new ItemStack(ItemInit.DUST_GOLD, 2), 2.0F);
        addCrusherRecipe(new ItemStack(Items.GOLD_INGOT), new ItemStack(ItemInit.DUST_GOLD, 1), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.GOLD_BLOCK)), new ItemStack(ItemInit.DUST_GOLD, 9), 4.0F);

        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.IRON_ORE)), new ItemStack(ItemInit.DUST_IRON, 2), 2.0F);
        addCrusherRecipe(new ItemStack(Items.IRON_INGOT), new ItemStack(ItemInit.DUST_IRON, 1), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.IRON_BLOCK)), new ItemStack(ItemInit.DUST_IRON, 9), 4.0F);

        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.STONEBRICK)), new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE)), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.STONE)), new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE)), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE)), new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.GRAVEL)), new ItemStack(Item.getItemFromBlock(Blocks.SAND)), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.SANDSTONE)), new ItemStack(Item.getItemFromBlock(Blocks.SAND), 4), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.RED_SANDSTONE)), new ItemStack(Item.getItemFromBlock(Blocks.SAND), 4, 1), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.GLOWSTONE)), new ItemStack(Items.GLOWSTONE_DUST, 4), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.CLAY)), new ItemStack(Items.CLAY_BALL, 4), 1.0F);
        addCrusherRecipe(new ItemStack(Items.REEDS), new ItemStack(Items.SUGAR, 3), 1.0F);
        addCrusherRecipe(new ItemStack(Items.BLAZE_ROD), new ItemStack(Items.BLAZE_ROD, 5), 1.0F);
        addCrusherRecipe(new ItemStack(Items.BONE), new ItemStack(Items.DYE, 5, 15), 1.0F);
        addCrusherRecipe(new ItemStack(Item.getItemFromBlock(Blocks.BONE_BLOCK)), new ItemStack(Items.DYE, 9, 15), 4.0F);
        addCrusherRecipe(new ItemStack(Items.PRISMARINE_SHARD), new ItemStack(Items.PRISMARINE_CRYSTALS, 1), 1.0F);
    }

    public void addCrusherRecipe(ItemStack input, ItemStack result, float experience) {
        if(getCrusherResult(input) != ItemStack.EMPTY) return;
        this.crusherList.put(input, result);
        this.experienceList.put(result, Float.valueOf(experience));
    }


    public ItemStack getCrusherResult(ItemStack input) {
        for (Map.Entry<ItemStack, ItemStack> entry : this.crusherList.entrySet()) {
            if(this.compareItemStacks(input, (ItemStack)entry.getKey())) {
                return (ItemStack) entry.getValue();
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getCrusherList() {
        return this.crusherList;
    }

    public float getCrusherExperience(ItemStack stack) {
        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }
}
