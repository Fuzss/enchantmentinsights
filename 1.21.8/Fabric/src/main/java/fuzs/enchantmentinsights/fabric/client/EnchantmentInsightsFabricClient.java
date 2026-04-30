package fuzs.enchantmentinsights.fabric.client;

import fuzs.enchantmentinsights.EnchantmentInsights;
import fuzs.enchantmentinsights.client.EnchantmentInsightsClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class EnchantmentInsightsFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(EnchantmentInsights.MOD_ID, EnchantmentInsightsClient::new);
    }
}
