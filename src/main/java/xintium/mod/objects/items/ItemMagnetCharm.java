package xintium.mod.objects.items;

import baubles.api.BaubleType;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMagnetCharm extends ItemBauble {
    public ItemMagnetCharm(String name) {
        setMaxDamage(1000);
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        tooltip.add(TextFormatting.BLUE + I18n.format("magnet.info.short"));
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.CHARM;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity) {
        if(entity instanceof EntityPlayer && !entity.getEntityWorld().isRemote){
            EntityPlayer player = (EntityPlayer)entity;
            if(player.isSpectator()) return;
            if(!player.isSneaking()) {
                int range = 6;
                List<EntityItem> items = entity.getEntityWorld().getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(entity.posX-range, entity.posY-range, entity.posZ-range, entity.posX+range, entity.posY+range, entity.posZ+range));
                if(!items.isEmpty()){
                    for(EntityItem item : items){
                        if(item.getEntityData().getBoolean("PreventRemoteMovement")) continue;
                        if(!item.isDead && !item.cannotPickup()){
                            item.onCollideWithPlayer(player);
                        }
                    }
                }
            }
        }
    }
}
