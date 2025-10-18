package fuzs.enchantmentinsights.neoforge.client;

import com.mojang.datafixers.util.Either;
import fuzs.enchantmentinsights.EnchantmentInsights;
import fuzs.enchantmentinsights.client.EnchantmentInsightsClient;
import fuzs.enchantmentinsights.client.handler.EnchantmentTableTooltipHandler;
import fuzs.enchantmentinsights.data.client.ModLanguageProvider;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.api.core.v1.utility.TransformingForwardingList;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.EnchantmentScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.Nullable;

@Mod(value = EnchantmentInsights.MOD_ID, dist = Dist.CLIENT)
public class EnchantmentInsightsNeoForgeClient {

    public EnchantmentInsightsNeoForgeClient() {
        ClientModConstructor.construct(EnchantmentInsights.MOD_ID, EnchantmentInsightsClient::new);
        registerEventHandlers(NeoForge.EVENT_BUS);
        DataProviderHelper.registerDataProviders(EnchantmentInsights.MOD_ID, ModLanguageProvider::new);
    }

    private static void registerEventHandlers(IEventBus eventBus) {
        eventBus.addListener((final RenderTooltipEvent.GatherComponents event) -> {
            if (event.getItemStack().isEmpty() && Minecraft.getInstance().screen instanceof EnchantmentScreen) {
                EnchantmentTableTooltipHandler.INSTANCE.onGatherTooltipComponents(Minecraft.getInstance(),
                        new TransformingForwardingList<>(event.getTooltipElements()) {
                            @Override
                            protected @Nullable Component getAsElement(@Nullable Either<FormattedText, TooltipComponent> element) {
                                return element != null && element.left().isPresent() && element.left()
                                        .get() instanceof Component component ? component : null;
                            }

                            @Override
                            protected @Nullable Either<FormattedText, TooltipComponent> getAsListElement(@Nullable Component component) {
                                return component != null ? Either.left(component) : null;
                            }
                        });
            }
        });
    }
}
