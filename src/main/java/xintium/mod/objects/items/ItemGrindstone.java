package xintium.mod.objects.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import xintium.mod.Main;
import xintium.mod.init.ItemInit;
import xintium.mod.util.interfaces.IHasModel;

import javax.annotation.Nullable;
import java.util.List;


public class ItemGrindstone extends Item implements IHasModel {
    public ItemGrindstone(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.LITTLEADDITIONSTAB);
        setNoRepair();
        setMaxDamage(36);
        setMaxStackSize(1);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        tooltip.add(TextFormatting.BLUE + I18n.format("grindstone.info.short"));
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return itemStack.getItemDamage() < itemStack.getMaxDamage() ? new ItemStack(itemStack.getItem(), 1, itemStack.getItemDamage() + 1) : ItemStack.EMPTY;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
