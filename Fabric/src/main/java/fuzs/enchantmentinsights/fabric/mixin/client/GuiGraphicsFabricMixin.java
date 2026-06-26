package fuzs.enchantmentinsights.fabric.mixin.client;

import fuzs.enchantmentinsights.common.client.handler.EnchantingTableTooltipHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(GuiGraphicsExtractor.class)
abstract class GuiGraphicsFabricMixin {
    @Shadow
    @Final
    private Minecraft minecraft;

    @ModifyVariable(method = "setComponentTooltipForNextFrame(Lnet/minecraft/client/gui/Font;Ljava/util/List;II)V",
                    at = @At("HEAD"),
                    argsOnly = true)
    public List<Component> setComponentTooltipForNextFrame(List<Component> lines) {
        if (this.minecraft.screen instanceof EnchantmentScreen screen) {
            EnchantingTableTooltipHandler.INSTANCE.onGatherTooltipComponents(screen.minecraft, lines);
        }

        return lines;
    }
}
