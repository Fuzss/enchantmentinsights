package fuzs.enchantmentinsights.common.client.gui.component;

import com.google.common.collect.ImmutableList;
import fuzs.enchantmentinsights.common.EnchantmentInsights;
import fuzs.enchantmentinsights.common.client.util.EnchantmentWithLevel;
import fuzs.enchantmentinsights.common.config.ClientConfig;
import fuzs.tooltipinsights.common.api.v1.client.gui.component.TooltipComponentExtractor;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ItemEnchantments;

import java.util.List;
import java.util.stream.Stream;

public final class EnchantmentComponents {
    private static final TooltipComponentExtractor<EnchantmentWithLevel, ItemEnchantments> ENCHANTMENTS = new TooltipComponentExtractor<>(
            DataComponents.ENCHANTMENTS) {
        @Override
        protected boolean isEnabled() {
            return EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantmentItemTooltips.itemDescriptionTargets.enchantments;
        }

        @Override
        protected Stream<EnchantmentWithLevel> extractFromComponent(ItemEnchantments itemEnchantments) {
            return itemEnchantments.entrySet().stream().map(EnchantmentWithLevel::new);
        }
    };
    private static final TooltipComponentExtractor<EnchantmentWithLevel, ItemEnchantments> STORED_ENCHANTMENTS = new TooltipComponentExtractor<>(
            DataComponents.STORED_ENCHANTMENTS) {
        @Override
        protected boolean isEnabled() {
            return EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantmentItemTooltips.itemDescriptionTargets.storedEnchantments;
        }

        @Override
        protected Stream<EnchantmentWithLevel> extractFromComponent(ItemEnchantments itemEnchantments) {
            return itemEnchantments.entrySet().stream().map(EnchantmentWithLevel::new);
        }
    };
    private static final List<TooltipComponentExtractor<EnchantmentWithLevel, ?>> ENCHANTMENT_SUPPLIERS = ImmutableList.of(
            ENCHANTMENTS,
            STORED_ENCHANTMENTS);

    private EnchantmentComponents() {
        // NO-OP
    }

    public static Stream<EnchantmentWithLevel> getAllEnchantments(ItemStack itemStack) {
        return ENCHANTMENT_SUPPLIERS.stream()
                .flatMap((TooltipComponentExtractor<EnchantmentWithLevel, ?> supplier) -> supplier.extractFromItemStack(
                        itemStack));
    }
}
