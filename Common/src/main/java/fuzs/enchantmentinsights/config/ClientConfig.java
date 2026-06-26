package fuzs.enchantmentinsights.config;

import fuzs.enchantmentinsights.EnchantmentInsights;
import fuzs.puzzleslib.api.config.v3.Config;
import fuzs.puzzleslib.api.config.v3.ConfigCore;
import fuzs.tooltipinsights.api.v1.config.StyledTooltipsConfig;
import fuzs.tooltipinsights.api.v1.config.TextFormattingConfig;
import fuzs.tooltipinsights.api.v1.config.TooltipComponentsConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;

public class ClientConfig implements ConfigCore {
    @Config
    public final EnchantmentItemTooltips enchantmentItemTooltips = new EnchantmentItemTooltips();
    @Config
    public final StyledTooltipsConfig<EnchantmentTooltipComponentsConfig> enchantmentTableTooltips = new StyledTooltipsConfig<>(
            new EnchantmentTooltipComponentsConfig());

    public static class EnchantmentItemTooltips extends StyledTooltipsConfig<EnchantmentLevelTooltipComponentsConfig> {
        @Config
        public final EnchantmentDescriptionTargetsConfig itemDescriptionTargets = new EnchantmentDescriptionTargetsConfig();
        @Config
        public final EnchantmentTextStylingConfig enchantmentNameStyling = new EnchantmentTextStylingConfig();

        public EnchantmentItemTooltips() {
            super(new EnchantmentLevelTooltipComponentsConfig());
        }
    }

    public static class EnchantmentDescriptionTargetsConfig implements ConfigCore {
        @Config(description = "Add enchantment descriptions to enchanted items.")
        public boolean enchantments = true;
        @Config(description = "Add enchantment descriptions to enchanted books.")
        public boolean storedEnchantments = true;
    }

    public static class EnchantmentTextStylingConfig implements ConfigCore {
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

    public static class EnchantmentTooltipComponentsConfig extends TooltipComponentsConfig {
        @Config(description = "Add tags for primary and other supported items to tooltips.")
        public boolean compatibleItems = false;
    }

    public static class EnchantmentLevelTooltipComponentsConfig extends EnchantmentTooltipComponentsConfig {
        @Config(description = "Add the maximum enchantment level as part of the name to tooltips.")
        public boolean maximumLevel = true;

        public boolean maximumLevel() {
            return this.maximumLevel
                    && EnchantmentInsights.CONFIG.get(ClientConfig.class).enchantmentItemTooltips.tooltipDescriptions.isActive();
        }
    }
}
