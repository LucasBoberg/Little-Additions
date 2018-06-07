package xintium.mod.objects.blocks.machines.crusher;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xintium.mod.objects.blocks.machines.crusher.slots.SlotCrusherFuel;
import xintium.mod.objects.blocks.machines.crusher.slots.SlotCrusherOutput;

public class ContainerCrusher extends Container {

    private final TileEntityCrusher tileEntityCrusher;
    private int cookTime, totalCookTime, burnTime, currentBurnTime;

    public ContainerCrusher(InventoryPlayer player, TileEntityCrusher tileEntityCrusher) {
        this.tileEntityCrusher = tileEntityCrusher;
        this.addSlotToContainer(new Slot(tileEntityCrusher, 0, 80, 15));
        this.addSlotToContainer(new SlotCrusherFuel(tileEntityCrusher, 1, 17, 53));
        this.addSlotToContainer(new SlotCrusherOutput(player.player, tileEntityCrusher, 2, 80, 58));

        for(int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
        }
    }

    @Override
    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileEntityCrusher);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for(int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener listener = (IContainerListener)this.listeners.get(i);

            if(this.cookTime != this.tileEntityCrusher.getField(2)) listener.sendWindowProperty(this, 2, this.tileEntityCrusher.getField(2));
            if(this.burnTime != this.tileEntityCrusher.getField(0)) listener.sendWindowProperty(this, 0, this.tileEntityCrusher.getField(0));
            if(this.currentBurnTime != this.tileEntityCrusher.getField(1)) listener.sendWindowProperty(this, 1, this.tileEntityCrusher.getField(1));
            if(this.totalCookTime != this.tileEntityCrusher.getField(3)) listener.sendWindowProperty(this, 3, this.tileEntityCrusher.getField(3));
        }

        this.cookTime = this.tileEntityCrusher.getField(2);
        this.burnTime = this.tileEntityCrusher.getField(0);
        this.currentBurnTime = this.tileEntityCrusher.getField(1);
        this.totalCookTime = this.tileEntityCrusher.getField(3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tileEntityCrusher.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.tileEntityCrusher.isUsableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if(slot != null && slot.getHasStack())
        {
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();

            if(index == 2)
            {
                if(!this.mergeItemStack(stack1, 3, 39, true)) return ItemStack.EMPTY;
                slot.onSlotChange(stack1, stack);
            }
            else if(index != 1 && index != 0)
            {

                if(!CrusherRecipes.getInstance().getCrusherResult(stack1).isEmpty())
                    {
                    if(!this.mergeItemStack(stack1, 0, 1, false))
                    {
                        return ItemStack.EMPTY;
                    }
                    else if(TileEntityCrusher.isItemFuel(stack1))
                    {
                        if(!this.mergeItemStack(stack1, 1, 2, false)) return ItemStack.EMPTY;
                    }
                    else if(index >= 3 && index < 30)
                    {
                        if(!this.mergeItemStack(stack1, 31, 40, false)) return ItemStack.EMPTY;
                    }
                    else if(index >= 30 && index < 39 && !this.mergeItemStack(stack1, 3, 30, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
            }
            else if(!this.mergeItemStack(stack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }
            if(stack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
            if(stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
            slot.onTake(playerIn, stack1);
        }
        return stack;
    }
}
