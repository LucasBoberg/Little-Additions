package xintium.mod.util.compat.jei.crusher;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.util.ResourceLocation;
import xintium.mod.util.Reference;

public abstract class AbstractCrusherRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    protected static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/crusher.png");

    protected static final int input = 0;
    protected static final int fuel = 1;
    protected static final int output = 2;

    protected final IDrawableStatic staticFlame;
    protected final IDrawableAnimated animatedFlame;
    protected final IDrawableAnimated animatedArrow;

    public AbstractCrusherRecipeCategory(IGuiHelper helper) {
        staticFlame = helper.createDrawable(TEXTURES, 176, 0, 14, 14);
        animatedFlame = helper.createAnimatedDrawable(staticFlame, 300, IDrawableAnimated.StartDirection.TOP, true);

        IDrawableStatic staticArrow = helper.createDrawable(TEXTURES, 176, 14, 14, 19);
        animatedArrow = helper.createAnimatedDrawable(staticArrow, 450, IDrawableAnimated.StartDirection.TOP, false);
    }
}
