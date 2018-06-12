package xintium.mod.util.compat.jei;

import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import mezz.jei.api.ingredients.IIngredientRegistry;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import xintium.mod.init.BlockInit;
import xintium.mod.init.ItemInit;
import xintium.mod.objects.blocks.machines.alloymerger.ContainerAlloyMerger;
import xintium.mod.objects.blocks.machines.alloymerger.GuiAlloyMerger;
import xintium.mod.objects.blocks.machines.crusher.ContainerCrusher;
import xintium.mod.objects.blocks.machines.crusher.GuiCrusher;
import xintium.mod.objects.blocks.machines.furnace.ContainerBronzeFurnace;
import xintium.mod.objects.blocks.machines.furnace.GuiBronzeFurnace;
import xintium.mod.util.compat.jei.alloymerger.AlloyMergerCategory;
import xintium.mod.util.compat.jei.alloymerger.AlloyMergerRecipeMaker;
import xintium.mod.util.compat.jei.crusher.CrusherCategory;
import xintium.mod.util.compat.jei.crusher.CrusherRecipeMaker;

import java.util.IllegalFormatException;

@JEIPlugin
public class JEICompat implements IModPlugin {

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        final IJeiHelpers helpers = registry.getJeiHelpers();
        final IGuiHelper gui = helpers.getGuiHelper();

        registry.addRecipeCategories(new AlloyMergerCategory(gui));
        registry.addRecipeCategories(new CrusherCategory(gui));
    }

    @Override
    public void register(IModRegistry registry) {
        final IIngredientRegistry ingredientRegistry = registry.getIngredientRegistry();
        final IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IRecipeTransferRegistry recipeTransfer = registry.getRecipeTransferRegistry();
        IIngredientBlacklist blacklist = registry.getJeiHelpers().getIngredientBlacklist();

        blacklist.addIngredientToBlacklist(new ItemStack(Item.getItemFromBlock(BlockInit.TOMATO_PLANT)));

        registry.addRecipes(AlloyMergerRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.ALLOYMERGER);
        registry.addRecipeClickArea(GuiAlloyMerger.class, 78, 32, 28, 23, RecipeCategories.ALLOYMERGER, VanillaRecipeCategoryUid.FUEL);
        registry.addRecipeCategoryCraftingItem(new ItemStack(BlockInit.ALLOY_MERGER), RecipeCategories.ALLOYMERGER);
        recipeTransfer.addRecipeTransferHandler(ContainerAlloyMerger.class, RecipeCategories.ALLOYMERGER, 0, 1, 4, 36);

        registry.addRecipes(CrusherRecipeMaker.getRecipes(jeiHelpers), RecipeCategories.CRUSHER);
        registry.addRecipeClickArea(GuiCrusher.class, 72, 34, 28, 16, RecipeCategories.CRUSHER, VanillaRecipeCategoryUid.FUEL);
        registry.addRecipeCategoryCraftingItem(new ItemStack(BlockInit.CRUSHER), RecipeCategories.CRUSHER);
        recipeTransfer.addRecipeTransferHandler(ContainerCrusher.class, RecipeCategories.CRUSHER, 0, 1, 3, 36);

        registry.addRecipeCategoryCraftingItem(new ItemStack(BlockInit.BRONZE_FURNACE), VanillaRecipeCategoryUid.SMELTING, VanillaRecipeCategoryUid.FUEL);
        registry.addRecipeClickArea(GuiBronzeFurnace.class, 78, 32, 28, 23, VanillaRecipeCategoryUid.SMELTING, VanillaRecipeCategoryUid.FUEL);
        recipeTransfer.addRecipeTransferHandler(ContainerBronzeFurnace.class, VanillaRecipeCategoryUid.SMELTING, 0, 1, 3, 36);
        recipeTransfer.addRecipeTransferHandler(ContainerBronzeFurnace.class, VanillaRecipeCategoryUid.FUEL, 1, 1, 3, 36);
        recipeTransfer.addRecipeTransferHandler(ContainerAlloyMerger.class, VanillaRecipeCategoryUid.FUEL, 1, 1, 3, 36);
        recipeTransfer.addRecipeTransferHandler(ContainerCrusher.class, VanillaRecipeCategoryUid.FUEL, 1, 1, 3, 36);

        registry.addDescription(new ItemStack(ItemInit.GRINDSTONE), net.minecraft.client.resources.I18n.format("grindstone.info.long"));
    }

    public static String translateToLocal(String key) {
        if (I18n.canTranslate(key)) return I18n.translateToLocal(key);
        else return I18n.translateToFallback(key);
    }

    public static String translateToLocalFormatted(String key, Object... format) {
        String s = translateToLocal(key);
        try {
            return String.format(s, format);
        } catch (IllegalFormatException e) {
            return "Format error: " + s;
        }
    }
}
