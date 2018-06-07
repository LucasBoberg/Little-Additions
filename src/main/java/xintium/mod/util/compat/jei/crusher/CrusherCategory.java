package xintium.mod.util.compat.jei.crusher;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import xintium.mod.util.Reference;
import xintium.mod.util.compat.jei.RecipeCategories;

public class CrusherCategory extends AbstractCrusherRecipeCategory<CrusherRecipe> {

    private final IDrawable background;
    private final String name;

    public CrusherCategory(IGuiHelper helper) {
        super(helper);
        background = helper.createDrawable(TEXTURES, 4, 3, 140, 76, -16, 4, 0, 0);
        name = "Crusher";
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        animatedFlame.draw(minecraft, 13, 18);
        animatedArrow.draw(minecraft, 77, 14);
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getModName() {
        return Reference.NAME;
    }

    @Override
    public String getUid() {
        return RecipeCategories.CRUSHER;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, CrusherRecipe crusherRecipe, IIngredients ingredients) {
        IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
        stacks.init(input, true, 75, -5);
        stacks.init(output, false, 75, 38);
        stacks.set(ingredients);
    }
}
