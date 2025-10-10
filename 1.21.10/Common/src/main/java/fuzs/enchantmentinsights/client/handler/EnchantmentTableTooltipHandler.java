package fuzs.enchantmentinsights.client.handler;

import fuzs.enchantmentinsights.EnchantmentInsights;
import fuzs.enchantmentinsights.client.gui.tooltip.EnchantmentTooltipLines;
import fuzs.enchantmentinsights.client.util.EnchantmentWithLevel;
import fuzs.enchantmentinsights.config.ClientConfig;
import fuzs.tooltipinsights.api.v1.client.handler.TooltipDescriptionsHandler;
import fuzs.tooltipinsights.api.v1.config.ItemDescriptionMode;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public final class EnchantmentTableTooltipHandler extends TooltipDescriptionsHandler<EnchantmentWithLevel> {
    public static final TooltipDescriptionsHandler<EnchantmentWithLevel> INSTANCE = new EnchantmentTableTooltipHandler();

    private EnchantmentTableTooltipHandler() {
        // NO-OP
    }

    @Override
    protected ItemDescriptionMode getItemDescriptionMode() {
        return EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantmentTableTooltips.itemDescriptions;
    }

    @Override
    protected Map<String, EnchantmentWithLevel> getByDescriptionId(ItemStack itemStack, HolderLookup.Provider registries) {
        Stream<EnchantmentWithLevel> stream = registries.lookupOrThrow(Registries.ENCHANTMENT)
                .listElements()
                .map(EnchantmentWithLevel::new);
        return EnchantmentItemTooltipHandler.getByDescriptionId(stream);
    }

    @Override
    protected List<Component> getItemTooltipLines(EnchantmentWithLevel enchantmentWithLevel) {
        return EnchantmentTooltipLines.getEnchantmentTableTooltipLines(enchantmentWithLevel);
    }
}
