package xintium.mod.util.compat.jei.crusher;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.ItemStack;
import xintium.mod.objects.blocks.machines.alloymerger.AlloyMergerRecipes;
import xintium.mod.objects.blocks.machines.crusher.CrusherRecipes;
import xintium.mod.util.compat.jei.JEICompat;

import java.awt.*;
import java.util.List;

public class CrusherRecipe implements IRecipeWrapper {
    private final ItemStack input;
    private final ItemStack output;

    public CrusherRecipe(ItemStack input, ItemStack output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(ItemStack.class, input);
        ingredients.setOutput(ItemStack.class, output);
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        CrusherRecipes recipes = CrusherRecipes.getInstance();
        float experience = recipes.getCrusherExperience(output);

        if (experience > 0) {
            String experienceString = JEICompat.translateToLocalFormatted("gui.jei.category.smelting.experience", experience);
            FontRenderer renderer = minecraft.fontRenderer;
            int stringWidth = renderer.getStringWidth(experienceString);
            renderer.drawString(experienceString, recipeWidth - stringWidth, 0, Color.gray.getRGB());
        }
    }
}
