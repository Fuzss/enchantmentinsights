package fuzs.enchantmentinsights.neoforge;

import fuzs.enchantmentinsights.EnchantmentInsights;
import fuzs.puzzleslib.api.core.v1.ModConstructor;
import net.neoforged.fml.common.Mod;

@Mod(EnchantmentInsights.MOD_ID)
public class EnchantmentInsightsNeoForge {

    public EnchantmentInsightsNeoForge() {
        ModConstructor.construct(EnchantmentInsights.MOD_ID, EnchantmentInsights::new);
    }
}
