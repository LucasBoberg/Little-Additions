package xintium.mod.objects.items;

import baubles.api.BaubleType;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWalkingBelt extends ItemBauble {
    public ItemWalkingBelt(String name) {
        setMaxDamage(1000);
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.BELT;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        tooltip.add(TextFormatting.BLUE + I18n.format("walking_belt.info.short"));
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        modifySpeed((EntityPlayer) player);
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        cancelModifySpeed((EntityPlayer) player);
    }

    private void modifySpeed(EntityPlayer player) {
        player.capabilities.setPlayerWalkSpeed(0.15f);
        if (!player.getEntityWorld().isRemote) {
            player.sendPlayerAbilities();
        }
    }

    private void cancelModifySpeed(EntityPlayer player) {
        player.capabilities.setPlayerWalkSpeed(0.1f);
        if (!player.getEntityWorld().isRemote) {
            player.sendPlayerAbilities();
        }
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = ((EntityPlayer) entity);
            modifySpeed(player);
        }
    }
}
