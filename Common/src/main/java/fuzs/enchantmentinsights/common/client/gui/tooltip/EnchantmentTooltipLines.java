package fuzs.enchantmentinsights.common.client.gui.tooltip;

import com.google.common.collect.ImmutableList;
import fuzs.enchantmentinsights.common.client.util.EnchantmentWithLevel;
import fuzs.enchantmentinsights.common.config.ClientConfig;
import fuzs.puzzleslib.common.api.init.v3.registry.ResourceKeyHelper;
import fuzs.tooltipinsights.common.api.v1.client.gui.tooltip.DescriptionLines;
import fuzs.tooltipinsights.common.api.v1.client.gui.tooltip.InternalNameLines;
import fuzs.tooltipinsights.common.api.v1.client.gui.tooltip.ModNameLines;
import fuzs.tooltipinsights.common.api.v1.client.gui.tooltip.TooltipLinesExtractor;
import fuzs.tooltipinsights.common.api.v1.config.TooltipComponentsConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.HolderSet;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.List;
import java.util.stream.Stream;

public final class EnchantmentTooltipLines {
    public static final TooltipLinesExtractor<EnchantmentWithLevel, TooltipComponentsConfig> DESCRIPTION = new DescriptionLines<>() {
        @Override
        protected String getDescriptionId(EnchantmentWithLevel enchantmentWithLevel) {
            ResourceKey<Enchantment> resourceKey = enchantmentWithLevel.enchantment().unwrapKey().orElseThrow();
            return ResourceKeyHelper.getTranslationKey(resourceKey);
        }
    };
    public static final TooltipLinesExtractor<EnchantmentWithLevel, ClientConfig.EnchantmentTooltipComponentsConfig> COMPATIBLE_ITEMS = new TooltipLinesExtractor<>(
            true) {
        @Override
        protected boolean isEnabled(ClientConfig.EnchantmentTooltipComponentsConfig tooltipComponents) {
            return tooltipComponents.compatibleItems;
        }

        @Override
        public Stream<Component> getTooltipLines(EnchantmentWithLevel enchantmentWithLevel, int maxWidth) {
            Enchantment.EnchantmentDefinition enchantmentDefinition = enchantmentWithLevel.enchantment()
                    .value()
                    .definition();
            Stream.Builder<Component> builder = Stream.builder();
            enchantmentDefinition.primaryItems()
                    .flatMap(HolderSet::unwrapKey)
                    .map(this::getTagKeyAsComponent)
                    .ifPresent(builder);
            enchantmentDefinition.supportedItems().unwrapKey().map(this::getTagKeyAsComponent).ifPresent(builder);
            return builder.build();
        }

        private Component getTagKeyAsComponent(TagKey<?> tagKey) {
            return Component.literal("#" + tagKey.location()).withStyle(ChatFormatting.LIGHT_PURPLE);
        }
    };
    public static final TooltipLinesExtractor<EnchantmentWithLevel, TooltipComponentsConfig> MOD_NAME = new ModNameLines<>() {
        @Override
        protected ResourceKey<?> getResourceKey(EnchantmentWithLevel enchantmentWithLevel) {
            return enchantmentWithLevel.enchantment().unwrapKey().orElseThrow();
        }
    };
    public static final TooltipLinesExtractor<EnchantmentWithLevel, TooltipComponentsConfig> INTERNAL_NAME = new InternalNameLines<>() {
        @Override
        protected ResourceKey<?> getResourceKey(EnchantmentWithLevel enchantmentWithLevel) {
            return enchantmentWithLevel.enchantment().unwrapKey().orElseThrow();
        }
    };
    public static final List<TooltipLinesExtractor<EnchantmentWithLevel, ClientConfig.EnchantmentTooltipComponentsConfig>> ENCHANTMENT_SUPPLIERS = ImmutableList.of(
            DESCRIPTION.cast(),
            COMPATIBLE_ITEMS,
            MOD_NAME.cast(),
            INTERNAL_NAME.cast());
    public static final List<TooltipLinesExtractor<EnchantmentWithLevel, ClientConfig.EnchantmentLevelTooltipComponentsConfig>> ENCHANTMENT_LEVEL_SUPPLIERS = ImmutableList.of(
            DESCRIPTION.cast(),
            COMPATIBLE_ITEMS.cast(),
            MOD_NAME.cast(),
            INTERNAL_NAME.cast());

    private EnchantmentTooltipLines() {
        // NO-OP
    }
}
