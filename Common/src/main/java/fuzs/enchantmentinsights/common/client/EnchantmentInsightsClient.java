package fuzs.enchantmentinsights.common.client;

import fuzs.enchantmentinsights.common.client.handler.EnchantedItemTooltipHandler;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.common.api.client.event.v1.gui.ItemTooltipCallback;
import fuzs.puzzleslib.common.api.event.v1.core.EventPhase;
import fuzs.puzzleslib.common.api.init.v3.registry.ResourceKeyHelper;
import fuzs.tooltipinsights.common.api.v1.client.handler.TooltipDescriptionsHandler;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentInsightsClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
        registerEventHandlers();
        TooltipDescriptionsHandler.printMissingDescriptionWarnings(Registries.ENCHANTMENT,
                (Holder.Reference<Enchantment> holder) -> ResourceKeyHelper.getTranslationKey(holder.key()));
    }

    private static void registerEventHandlers() {
        ItemTooltipCallback.EVENT.register(EventPhase.LAST, EnchantedItemTooltipHandler.INSTANCE::onItemTooltip);
    }
}
