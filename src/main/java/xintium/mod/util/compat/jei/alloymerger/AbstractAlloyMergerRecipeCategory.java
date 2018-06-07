package xintium.mod.util.compat.jei.alloymerger;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;
import xintium.mod.util.Reference;

public abstract class AbstractAlloyMergerRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/alloy_merger.png");

    protected static final int input1 = 0;
    protected static final int input2 = 1;
    protected static final int fuel = 2;
    protected static final int output = 3;

    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    protected final IDrawableAnimated animatedArrow;

    public AbstractAlloyMergerRecipeCategory(IGuiHelper helper) {
        staticFlame = helper.createDrawable(TEXTURES, 176, 0, 14, 14);
        animatedFlame = helper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

        IDrawableStatic staticArrow = helper.createDrawable(TEXTURES, 176, 14, 62, 17);
        animatedArrow = helper.createAnimatedDrawable(staticArrow, 350, IDrawableAnimated.StartDirection.LEFT, false);
    }
}
