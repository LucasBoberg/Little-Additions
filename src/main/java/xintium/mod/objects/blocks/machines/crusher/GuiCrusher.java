package xintium.mod.objects.blocks.machines.crusher;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import xintium.mod.util.Reference;

public class GuiCrusher extends GuiContainer {

    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/crusher.png");
    private final InventoryPlayer player;
    private final TileEntityCrusher tileEntityCrusher;

    public GuiCrusher(InventoryPlayer player, TileEntityCrusher tileEntityCrusher) {
        super(new ContainerCrusher(player, tileEntityCrusher));
        this.player = player;
        this.tileEntityCrusher = tileEntityCrusher;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tileName = this.tileEntityCrusher.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2), 5, 4210752);
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if (TileEntityCrusher.isBurning(tileEntityCrusher)) {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(this.guiLeft + 18, this.guiTop + 48 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled(19);
        this.drawTexturedModalRect(this.guiLeft + 81, this.guiTop + 33, 176, 14, 14, l + 1);
    }

    private int getBurnLeftScaled(int pixels) {
        int i = this.tileEntityCrusher.getField(1);
        if (i == 0) i = 450;
        return this.tileEntityCrusher.getField(0) * pixels / i;
    }

    private int getCookProgressScaled(int pixels) {
        int i = this.tileEntityCrusher.getField(2);
        int j = this.tileEntityCrusher.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
