package fuzs.enchantmentinsights.fabric.client;

import fuzs.enchantmentinsights.common.EnchantmentInsights;
import fuzs.enchantmentinsights.common.client.EnchantmentInsightsClient;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class EnchantmentInsightsFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(EnchantmentInsights.MOD_ID, EnchantmentInsightsClient::new);
    }
}
