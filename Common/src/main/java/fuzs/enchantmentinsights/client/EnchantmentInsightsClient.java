package fuzs.enchantmentinsights.client;

import fuzs.enchantmentinsights.client.handler.EnchantmentItemTooltipHandler;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.api.client.event.v1.gui.ItemTooltipCallback;
import fuzs.puzzleslib.api.event.v1.core.EventPhase;
import fuzs.puzzleslib.api.init.v3.registry.ResourceKeyHelper;
import fuzs.tooltipinsights.api.v1.client.handler.TooltipDescriptionsHandler;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentInsightsClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        ItemTooltipCallback.EVENT.register(EventPhase.LAST, EnchantmentItemTooltipHandler.INSTANCE::onItemTooltip);
    }

    @Override
    public void onClientSetup() {
        TooltipDescriptionsHandler.printMissingDescriptionWarnings(Registries.ENCHANTMENT,
                (Holder.Reference<Enchantment> holder) -> ResourceKeyHelper.getTranslationKey(holder.key()));
    }
}
