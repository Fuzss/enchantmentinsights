package fuzs.enchantmentinsights.common.config;

import fuzs.enchantmentinsights.common.EnchantmentInsights;
import fuzs.puzzleslib.common.api.config.v3.Config;
import fuzs.puzzleslib.common.api.config.v3.ConfigCore;
import fuzs.tooltipinsights.common.api.v1.config.StyledTooltipsConfig;
import fuzs.tooltipinsights.common.api.v1.config.TextFormattingConfig;
import fuzs.tooltipinsights.common.api.v1.config.TooltipComponentsConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;

public class ClientConfig implements ConfigCore {
    @Config(description = "Controls enchantment descriptions shown on item tooltips.")
    public final EnchantedItemTooltips enchantedItemTooltips = new EnchantedItemTooltips();
    @Config(description = "Controls enchantment descriptions shown when hovering enchant buttons in the enchanting table screen.")
    public final EnchantingTableTooltips enchantingTableTooltips = new EnchantingTableTooltips();

    public static class EnchantedItemTooltips extends StyledTooltipsConfig<EnchantmentLevelTooltipComponents> {
        @Config(description = "Add enchantment descriptions to certain item groups.")
        public final EnchantmentDescriptionTargets itemDescriptionTargets = new EnchantmentDescriptionTargets();
        @Config(description = "Controls text lines added to enchantment description tooltips.")
        public final EnchantmentLevelTooltipComponents itemTooltipLines = new EnchantmentLevelTooltipComponents();
        @Config(description = "Formatting for setting a text color and various styles for different enchantments.")
        public final EnchantmentTextStyling enchantmentNameStyling = new EnchantmentTextStyling();

        @Override
        public EnchantmentLevelTooltipComponents tooltipLines() {
            return this.itemTooltipLines;
        }
    }

    public static class EnchantingTableTooltips extends StyledTooltipsConfig<EnchantmentTooltipComponents> {
        @Config(description = "Controls text lines added to enchantment description tooltips.")
        public final EnchantmentTooltipComponents widgetTooltipLines = new EnchantmentTooltipComponents();

        @Override
        public EnchantmentTooltipComponents tooltipLines() {
            return this.widgetTooltipLines;
        }
    }

    public static class EnchantmentDescriptionTargets implements ConfigCore {
        @Config(description = "Add enchantment descriptions to enchanted items.")
        public boolean enchantments = true;
        @Config(description = "Add enchantment descriptions to enchanted books.")
        public boolean storedEnchantments = true;
    }

    public static class EnchantmentTextStyling implements ConfigCore {
        @Config(description = "Formatting for setting a text color and various styles for normal enchantments.")
        final TextFormattingConfig defaultFormatting = new TextFormattingConfig(ChatFormatting.GREEN);
        @Config(description = "Formatting for setting a text color and various styles for treasure enchantments.")
        final TextFormattingConfig treasureFormatting = new TextFormattingConfig(ChatFormatting.GOLD);
        @Config(description = "Formatting for setting a text color and various styles for curses.")
        final TextFormattingConfig curseFormatting = new TextFormattingConfig(ChatFormatting.RED);

        public Style defaultStyle;
        public Style treasureStyle;
        public Style curseStyle;

        @Override
        public void afterConfigReload() {
            this.defaultStyle = this.defaultFormatting.getStyle();
            this.treasureStyle = this.treasureFormatting.getStyle();
            this.curseStyle = this.curseFormatting.getStyle();
        }
    }

    public static class EnchantmentTooltipComponents extends TooltipComponentsConfig {
        @Config(description = "Add tags for primary and other supported items to tooltips.")
        public boolean compatibleItems = false;
    }

    public static class EnchantmentLevelTooltipComponents extends EnchantmentTooltipComponents {
        @Config(description = "Add the maximum enchantment level as part of the name to tooltips.")
        public boolean maximumLevel = true;

        public boolean maximumLevel() {
            return this.maximumLevel
                    && EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantedItemTooltips.tooltipDescriptions.isActive();
        }
    }
}
