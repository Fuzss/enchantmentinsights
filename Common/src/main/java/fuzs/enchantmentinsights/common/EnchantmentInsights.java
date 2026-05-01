package fuzs.enchantmentinsights.common;

import fuzs.enchantmentinsights.common.config.ClientConfig;
import fuzs.puzzleslib.common.api.config.v3.ConfigHolder;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnchantmentInsights implements ModConstructor {
    public static final String MOD_ID = "enchantmentinsights";
    public static final String MOD_NAME = "Enchantment Insights";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final ConfigHolder CONFIG = ConfigHolder.builder(MOD_ID).client(ClientConfig.class);

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
