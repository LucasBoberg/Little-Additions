package xintium.mod.objects.blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xintium.mod.init.BlockInit;
import xintium.mod.init.ItemInit;

public class BlockTomatoPlant extends BlockCrops {

    private static final AxisAlignedBB[] tomato = new AxisAlignedBB[] {new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.125D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.25D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.375D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.5625D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.8125D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.88D, 0.75D), new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.94D, 0.75D)};

    public BlockTomatoPlant(String name) {
        super();
        setUnlocalizedName(name);
        setRegistryName(name);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            if (this.isMaxAge(state)) {
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.TOMATO, 2)));
                worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemInit.SEEDS_TOMATO, 1)));
                worldIn.setBlockState(pos, this.withAge(0));
                return true;
            }
        }
        return false;
    }

    @Override
    protected Item getSeed() {
        return ItemInit.SEEDS_TOMATO;
    }

    @Override
    protected Item getCrop() {
        return ItemInit.TOMATO;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return tomato[((Integer)state.getValue(this.getAgeProperty())).intValue()];
    }
}
