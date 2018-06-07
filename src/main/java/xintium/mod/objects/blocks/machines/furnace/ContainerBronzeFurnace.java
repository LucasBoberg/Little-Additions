package xintium.mod.objects.blocks.machines.furnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerBronzeFurnace extends Container {
    private final TileEntityBronzeFurnace tileBronzeFurnace;
    private int cookTime;
    private int totalCookTime;
    private int burnTime;
    private int currentBurnTime;

    public ContainerBronzeFurnace(InventoryPlayer playerInventory, TileEntityBronzeFurnace tileEntityBronzeFurnace) {
        this.tileBronzeFurnace = tileEntityBronzeFurnace;
        this.addSlotToContainer(new Slot(tileEntityBronzeFurnace, 0, 56, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(tileEntityBronzeFurnace, 1, 17, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, tileEntityBronzeFurnace, 2, 116, 35));

        int k;
        for(k = 0; k < 3; ++k) {
            for(int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + k * 9 + 9, 8 + j * 18, 84 + k * 18));
            }
        }

        for(k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }

    }

    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileBronzeFurnace);
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for(int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener listener = (IContainerListener)this.listeners.get(i);

            if(this.cookTime != this.tileBronzeFurnace.getField(2)) listener.sendWindowProperty(this, 2, this.tileBronzeFurnace.getField(2));
            if(this.burnTime != this.tileBronzeFurnace.getField(0)) listener.sendWindowProperty(this, 0, this.tileBronzeFurnace.getField(0));
            if(this.currentBurnTime != this.tileBronzeFurnace.getField(1)) listener.sendWindowProperty(this, 1, this.tileBronzeFurnace.getField(1));
            if(this.totalCookTime != this.tileBronzeFurnace.getField(3)) listener.sendWindowProperty(this, 3, this.tileBronzeFurnace.getField(3));
        }

        this.cookTime = this.tileBronzeFurnace.getField(2);
        this.burnTime = this.tileBronzeFurnace.getField(0);
        this.currentBurnTime = this.tileBronzeFurnace.getField(1);
        this.totalCookTime = this.tileBronzeFurnace.getField(3);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tileBronzeFurnace.setField(id, data);
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileBronzeFurnace.isUsableByPlayer(playerIn);
    }

    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index != 1 && index != 0) {
                if (!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty()) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (TileEntityBronzeFurnace.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 3 && index < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }
}
