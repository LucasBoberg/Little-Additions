package xintium.mod.objects.blocks.machines.alloymerger;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import xintium.mod.init.ItemInit;

import java.util.Map;

public class AlloyMergerRecipes {
    private static final AlloyMergerRecipes INSTANCE = new AlloyMergerRecipes();
    private final Table<ItemStack, ItemStack, ItemStack> mergerList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static AlloyMergerRecipes getInstance() {
        return INSTANCE;
    }

    private AlloyMergerRecipes() {
        addAlloyMergerRecipe(new ItemStack(ItemInit.INGOT_COPPER), new ItemStack(ItemInit.INGOT_TIN), new ItemStack(ItemInit.INGOT_BRONZE, 2), 2.0F);
        addAlloyMergerRecipe(new ItemStack(ItemInit.DUST_COPPER), new ItemStack(ItemInit.DUST_TIN), new ItemStack(ItemInit.INGOT_BRONZE, 2), 2.0F);

        addAlloyMergerRecipe(new ItemStack(ItemInit.INGOT_SILVER), new ItemStack(Items.GOLD_INGOT), new ItemStack(ItemInit.INGOT_ELECTRUM, 2), 2.0F);
        addAlloyMergerRecipe(new ItemStack(ItemInit.DUST_SILVER), new ItemStack(ItemInit.DUST_GOLD), new ItemStack(ItemInit.INGOT_ELECTRUM, 2), 2.0F);

        addAlloyMergerRecipe(new ItemStack(ItemInit.BLANK_CORE), new ItemStack(Items.SUGAR), new ItemStack(ItemInit.SPEED_CORE, 1), 2.0F);
        addAlloyMergerRecipe(new ItemStack(ItemInit.BLANK_CORE), new ItemStack(ItemInit.MAGNET), new ItemStack(ItemInit.MAGNET_CORE, 1), 2.0F);
    }


    public void addAlloyMergerRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) {
        if(getAlloyMergerResult(input1, input2) != ItemStack.EMPTY) return;
        this.mergerList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
    }

    public ItemStack getAlloyMergerResult(ItemStack input1, ItemStack input2) {
        for(Map.Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.mergerList.columnMap().entrySet()) {
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) {
                for(Map.Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey())) {
                        return (ItemStack)ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList() {
        return this.mergerList;
    }

    public float getAlloyMergerExperience(ItemStack stack) {
        for (Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey())) {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }
}
