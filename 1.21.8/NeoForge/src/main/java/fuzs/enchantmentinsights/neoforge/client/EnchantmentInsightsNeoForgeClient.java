package fuzs.enchantmentinsights.neoforge.client;

import fuzs.enchantmentinsights.EnchantmentInsights;
import fuzs.enchantmentinsights.client.EnchantmentInsightsClient;
import fuzs.enchantmentinsights.data.client.ModLanguageProvider;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = EnchantmentInsights.MOD_ID, dist = Dist.CLIENT)
public class EnchantmentInsightsNeoForgeClient {

    public EnchantmentInsightsNeoForgeClient() {
        ClientModConstructor.construct(EnchantmentInsights.MOD_ID, EnchantmentInsightsClient::new);
        DataProviderHelper.registerDataProviders(EnchantmentInsights.MOD_ID, ModLanguageProvider::new);
    }
}
