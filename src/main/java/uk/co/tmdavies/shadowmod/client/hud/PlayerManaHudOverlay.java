package uk.co.tmdavies.shadowmod.client.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import uk.co.tmdavies.shadowmod.client.data.ClientPlayerManaData;
import uk.co.tmdavies.shadowmod.utils.ModConstants;

public class PlayerManaHudOverlay {

    private static final ResourceLocation FILLED_MANA = new ResourceLocation(ModConstants.MOD_ID,
            "textures/mana/filled_mana.png");

    private static final ResourceLocation EMPTY_MANA = new ResourceLocation(ModConstants.MOD_ID,
            "textures/mana/empty_mana.png");

    public static final IGuiOverlay HUD_MANA = (((gui, poseStack, partialTick, screenWidth, screenHeight) -> {

        int x = screenWidth/2;
        int y = screenHeight;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, EMPTY_MANA);

        // Draw Empty Mana
        for (int i = 0; i < 10; i++) {

            // Params = poseStack, X, Y, offSetX, offSetY, drawSizeHeight, drawSizeWidth, iconSizeHeight, iconSizeWidth
            GuiComponent.blit(poseStack, x - 94 + (i * 9), y - 54, 0, 0, 12, 12, 12, 12);

        }

        RenderSystem.setShaderTexture(0, FILLED_MANA);

        // Divide Mana by 10, render each icon by the returned amount
//        int mana = ClientPlayerManaData.getPlayerMana(); Returns 0 for some reason
//        int perIcon = mana/10;

        for (int i = 0; i < ModConstants.MAX_MANA; i++) {

            if (ClientPlayerManaData.getPlayerMana() > i) {

                // Params = poseStack, X, Y, offSetX, offSetY, drawSizeHeight, drawSizeWidth, iconSizeHeight, iconSizeWidth
                GuiComponent.blit(poseStack, x - 94 + (i * 9), y - 54, 0, 0, 12, 12, 12, 12);

            } else {

                break;

            }
        }



    }));

}
