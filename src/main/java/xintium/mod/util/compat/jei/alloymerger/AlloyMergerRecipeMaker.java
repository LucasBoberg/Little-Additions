package xintium.mod.util.compat.jei.alloymerger;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;

import net.minecraft.item.ItemStack;
import xintium.mod.objects.blocks.machines.alloymerger.AlloyMergerRecipes;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AlloyMergerRecipeMaker {
    public static List<AlloyMergerRecipe> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        AlloyMergerRecipes instance = AlloyMergerRecipes.getInstance();
        Table<ItemStack, ItemStack, ItemStack> recipes = instance.getDualSmeltingList();
        List<AlloyMergerRecipe> jeiRecipes = Lists.newArrayList();

        for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : recipes.columnMap().entrySet()) {
            for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet()) {
                ItemStack input1 = entry.getKey();
                ItemStack input2 = ent.getKey();
                ItemStack output = ent.getValue();
                List<ItemStack> inputs = Lists.newArrayList(input1, input2);
                AlloyMergerRecipe recipe = new AlloyMergerRecipe(inputs, output);
                jeiRecipes.add(recipe);
            }
        }

        return jeiRecipes;
    }
}
