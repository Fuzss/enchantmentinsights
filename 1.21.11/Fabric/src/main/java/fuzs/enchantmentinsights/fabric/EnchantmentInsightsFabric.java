package fuzs.enchantmentinsights.fabric;

import fuzs.enchantmentinsights.EnchantmentInsights;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import net.fabricmc.api.ModInitializer;

public class EnchantmentInsightsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(EnchantmentInsights.MOD_ID, EnchantmentInsights::new);
    }
}
