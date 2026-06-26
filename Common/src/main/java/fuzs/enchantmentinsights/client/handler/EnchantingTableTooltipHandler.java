package fuzs.enchantmentinsights.client.handler;

import fuzs.enchantmentinsights.EnchantmentInsights;
import fuzs.enchantmentinsights.client.gui.tooltip.EnchantmentTooltipLines;
import fuzs.enchantmentinsights.client.util.EnchantmentWithLevel;
import fuzs.enchantmentinsights.config.ClientConfig;
import fuzs.tooltipinsights.api.v1.client.handler.TooltipDescriptionsHandler;
import fuzs.tooltipinsights.api.v1.config.StyledTooltipsConfig;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ItemStack;

import java.util.Map;
import java.util.stream.Stream;

public final class EnchantingTableTooltipHandler extends TooltipDescriptionsHandler<EnchantmentWithLevel, ClientConfig.EnchantmentTooltipComponentsConfig> {
    public static final TooltipDescriptionsHandler<EnchantmentWithLevel, ClientConfig.EnchantmentTooltipComponentsConfig> INSTANCE = new EnchantingTableTooltipHandler();

    private EnchantingTableTooltipHandler() {
        super(EnchantmentTooltipLines.ENCHANTMENT_SUPPLIERS);
    }

    @Override
    protected StyledTooltipsConfig<ClientConfig.EnchantmentTooltipComponentsConfig> getStyleConfig() {
        return EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantmentTableTooltips;
    }

    @Override
    protected Map<String, EnchantmentWithLevel> getByDescriptionId(ItemStack itemStack, HolderLookup.Provider registries) {
        Stream<EnchantmentWithLevel> stream = registries.lookupOrThrow(Registries.ENCHANTMENT)
                .listElements()
                .map(EnchantmentWithLevel::new);
        return EnchantedItemTooltipHandler.getByDescriptionId(stream);
    }
}
