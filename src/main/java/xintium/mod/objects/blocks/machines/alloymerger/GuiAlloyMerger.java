package xintium.mod.objects.blocks.machines.alloymerger;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import xintium.mod.util.Reference;

public class GuiAlloyMerger extends GuiContainer {

    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/gui/alloy_merger.png");
    private final InventoryPlayer player;
    private final TileEntityAlloyMerger tileEntityAlloyMerger;

    public GuiAlloyMerger(InventoryPlayer player, TileEntityAlloyMerger tileEntityAlloyMerger) {
        super(new ContainerAlloyMerger(player, tileEntityAlloyMerger));
        this.player = player;
        this.tileEntityAlloyMerger = tileEntityAlloyMerger;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tileName = this.tileEntityAlloyMerger.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2), 5, 4210752);
        this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if (TileEntityAlloyMerger.isBurning(tileEntityAlloyMerger)) {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(this.guiLeft + 18, this.guiTop + 48 - k, 176, 12 - k, 14, k + 1);
        }

        int l = this.getCookProgressScaled(62);
        this.drawTexturedModalRect(this.guiLeft + 40, this.guiTop + 35, 176, 14, l + 1, 16);
    }

    private int getBurnLeftScaled(int pixels) {
        int i = this.tileEntityAlloyMerger.getField(1);
        if (i == 0) i = 150;
        return this.tileEntityAlloyMerger.getField(0) * pixels / i;
    }

    private int getCookProgressScaled(int pixels) {
        int i = this.tileEntityAlloyMerger.getField(2);
        int j = this.tileEntityAlloyMerger.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}
