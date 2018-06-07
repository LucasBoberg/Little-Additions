package xintium.mod.util.compat.jei.alloymerger;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import xintium.mod.objects.blocks.machines.alloymerger.AlloyMergerRecipes;
import xintium.mod.util.compat.jei.JEICompat;

import java.awt.*;
import java.util.List;

public class AlloyMergerRecipe implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public AlloyMergerRecipe(List<ItemStack> inputs, ItemStack output) {
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInputs(ItemStack.class, inputs);
        ingredients.setOutput(ItemStack.class, output);
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        AlloyMergerRecipes recipes = AlloyMergerRecipes.getInstance();
        float experience = recipes.getAlloyMergerExperience(output);

        if (experience > 0) {
            String experienceString = JEICompat.translateToLocalFormatted("gui.jei.category.smelting.experience", experience);
            FontRenderer renderer = minecraft.fontRenderer;
            int stringWidth = renderer.getStringWidth(experienceString);
            renderer.drawString(experienceString, recipeWidth - stringWidth, 0, Color.gray.getRGB());
        }
    }
}
