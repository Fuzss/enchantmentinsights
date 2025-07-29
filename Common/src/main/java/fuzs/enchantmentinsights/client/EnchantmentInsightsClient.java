package fuzs.enchantmentinsights.client;

import fuzs.enchantmentinsights.client.handler.EnchantmentTooltipHandler;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.api.client.event.v1.entity.player.ClientPlayerNetworkEvents;
import fuzs.puzzleslib.api.client.event.v1.gui.ItemTooltipCallback;
import fuzs.puzzleslib.api.event.v1.core.EventPhase;
import fuzs.puzzleslib.api.init.v3.registry.ResourceKeyHelper;
import fuzs.tooltipinsights.api.v1.client.gui.tooltip.DescriptionLines;
import fuzs.tooltipinsights.impl.TooltipInsights;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.Connection;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.function.Function;

public class EnchantmentInsightsClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        ItemTooltipCallback.EVENT.register(EventPhase.LAST, new EnchantmentTooltipHandler()::onItemTooltip);
    }

    @Override
    public void onClientSetup() {
        printMissingDescriptionWarnings(Registries.ENCHANTMENT,
                (Holder.Reference<Enchantment> holder) -> ResourceKeyHelper.getTranslationKey(holder.key()));
    }

    /**
     * TODO replace with original method from Tooltip Insights
     */
    @Deprecated(forRemoval = true)
    public static <T> void printMissingDescriptionWarnings(ResourceKey<? extends Registry<? extends T>> registryKey, Function<Holder.Reference<T>, String> descriptionIdGetter) {
        ClientPlayerNetworkEvents.LOGGED_IN.register((LocalPlayer player, MultiPlayerGameMode multiPlayerGameMode, Connection connection) -> {
            player.registryAccess().lookupOrThrow(registryKey).listElements().forEach((Holder.Reference<T> holder) -> {
                String translationKey = descriptionIdGetter.apply(holder);
                if (DescriptionLines.getDescriptionTranslationKey(translationKey) == null) {
                    TooltipInsights.LOGGER.warn("Missing description for {}: {}",
                            holder.key(),
                            translationKey + ".desc");
                }
            });
        });
    }
}
