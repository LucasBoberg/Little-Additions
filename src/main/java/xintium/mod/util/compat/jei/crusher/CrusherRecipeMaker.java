package xintium.mod.util.compat.jei.crusher;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;
import xintium.mod.objects.blocks.machines.alloymerger.AlloyMergerRecipes;
import xintium.mod.objects.blocks.machines.crusher.CrusherRecipes;
import xintium.mod.util.compat.jei.alloymerger.AlloyMergerRecipe;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CrusherRecipeMaker {
    public static List<CrusherRecipe> getRecipes(IJeiHelpers helpers) {
        IStackHelper stackHelper = helpers.getStackHelper();
        CrusherRecipes instance = CrusherRecipes.getInstance();
        Map<ItemStack, ItemStack> recipes = instance.getCrusherList();
        List<CrusherRecipe> jeiRecipes = Lists.newArrayList();

        for (Map.Entry<ItemStack, ItemStack> entry : recipes.entrySet()) {
            ItemStack input = entry.getKey();
            ItemStack output = entry.getValue();
            CrusherRecipe recipe = new CrusherRecipe(input, output);
            jeiRecipes.add(recipe);
        }

        return jeiRecipes;
    }
}
