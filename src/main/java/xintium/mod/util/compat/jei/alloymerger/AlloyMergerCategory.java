package xintium.mod.util.compat.jei.alloymerger;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import xintium.mod.util.Reference;
import xintium.mod.util.compat.jei.RecipeCategories;

import javax.annotation.Nullable;

public class AlloyMergerCategory extends AbstractAlloyMergerRecipeCategory<AlloyMergerRecipe> {

    private final IDrawable background;
    private final String name;

    public AlloyMergerCategory(IGuiHelper helper) {
        super(helper);
        background = helper.createDrawable(TEXTURES, 4, 12, 150, 60);
        name = "Alloy Merger";
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        animatedFlame.draw(minecraft, 13, 24);
        animatedArrow.draw(minecraft, 36, 23);
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
        return RecipeCategories.ALLOYMERGER;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, AlloyMergerRecipe alloyMergerRecipe, IIngredients ingredients) {
        IGuiItemStackGroup stacks = recipeLayout.getItemStacks();
        stacks.init(input1, true, 30, 4);
        stacks.init(input2, true, 58, 4);
        stacks.init(output, false, 111, 22);
        stacks.set(ingredients);
    }
}
