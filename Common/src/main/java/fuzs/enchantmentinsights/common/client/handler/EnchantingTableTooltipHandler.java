package fuzs.enchantmentinsights.common.client.handler;

import fuzs.enchantmentinsights.common.EnchantmentInsights;
import fuzs.enchantmentinsights.common.client.gui.tooltip.EnchantmentTooltipLines;
import fuzs.enchantmentinsights.common.client.util.EnchantmentWithLevel;
import fuzs.enchantmentinsights.common.config.ClientConfig;
import fuzs.tooltipinsights.common.api.v1.client.gui.tooltip.TooltipLinesExtractor;
import fuzs.tooltipinsights.common.api.v1.client.handler.TooltipDescriptionsHandler;
import fuzs.tooltipinsights.common.api.v1.config.TooltipDescriptionMode;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public final class EnchantingTableTooltipHandler extends TooltipDescriptionsHandler<EnchantmentWithLevel> {
    public static final TooltipDescriptionsHandler<EnchantmentWithLevel> INSTANCE = new EnchantingTableTooltipHandler();

    private EnchantingTableTooltipHandler() {
        // NO-OP
    }

    @Override
    protected TooltipDescriptionMode getTooltipDescriptionMode() {
        return EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantmentTableTooltips.tooltipDescriptions;
    }

    @Override
    protected Map<String, EnchantmentWithLevel> getByDescriptionId(ItemStack itemStack, HolderLookup.Provider registries) {
        Stream<EnchantmentWithLevel> stream = registries.lookupOrThrow(Registries.ENCHANTMENT)
                .listElements()
                .map(EnchantmentWithLevel::new);
        return EnchantedItemTooltipHandler.getByDescriptionId(stream);
    }

    @Override
    protected List<Component> getItemTooltipLines(EnchantmentWithLevel enchantmentWithLevel) {
        return TooltipLinesExtractor.getTooltipLines(EnchantmentTooltipLines.ENCHANTMENT_SUPPLIERS,
                enchantmentWithLevel,
                EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantmentTableTooltips);
    }
}
