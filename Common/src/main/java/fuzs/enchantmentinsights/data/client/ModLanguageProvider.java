package fuzs.enchantmentinsights.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractLanguageProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import net.minecraft.world.item.enchantment.Enchantments;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations(TranslationBuilder translationBuilder) {
        this.addVanillaEnchantments(translationBuilder);
        this.addModEffects(translationBuilder);
    }

    private void addVanillaEnchantments(TranslationBuilder translationBuilder) {
        translationBuilder.add(Enchantments.AQUA_AFFINITY, "desc", "Improves underwater mining speed.");
        translationBuilder.add(Enchantments.BANE_OF_ARTHROPODS, "desc", "Increases damage against arthropods.");
        translationBuilder.add(Enchantments.BINDING_CURSE, "desc", "Prevents armor removal.");
        translationBuilder.add(Enchantments.BLAST_PROTECTION, "desc", "Reduces explosion damage.");
        translationBuilder.add(Enchantments.BREACH, "desc", "Reduces target's armor effectiveness.");
        translationBuilder.add(Enchantments.CHANNELING, "desc", "Summons lightning on struck targets during storms.");
        translationBuilder.add(Enchantments.DENSITY, "desc", "Increases mace smash damage.");
        translationBuilder.add(Enchantments.DEPTH_STRIDER, "desc", "Increases underwater movement speed.");
        translationBuilder.add(Enchantments.EFFICIENCY, "desc", "Increases mining speed.");
        translationBuilder.add(Enchantments.FEATHER_FALLING, "desc", "Reduces fall damage.");
        translationBuilder.add(Enchantments.FIRE_ASPECT, "desc", "Sets targets ablaze.");
        translationBuilder.add(Enchantments.FIRE_PROTECTION, "desc", "Reduces fire damage.");
        translationBuilder.add(Enchantments.FLAME, "desc", "Creates flaming arrows.");
        translationBuilder.add(Enchantments.FORTUNE, "desc", "Increases block drop rates.");
        translationBuilder.add(Enchantments.FROST_WALKER, "desc", "Creates frozen water walkways.");
        translationBuilder.add(Enchantments.IMPALING, "desc", "Increases damage against aquatic mobs.");
        translationBuilder.add(Enchantments.INFINITY, "desc", "Prevents arrow consumption.");
        translationBuilder.add(Enchantments.KNOCKBACK, "desc", "Increases knockback strength.");
        translationBuilder.add(Enchantments.LOOTING, "desc", "Increases mob drop rates.");
        translationBuilder.add(Enchantments.LOYALTY, "desc", "Returns thrown trident.");
        translationBuilder.add(Enchantments.LUCK_OF_THE_SEA, "desc", "Increases fishing treasure chances.");
        translationBuilder.add(Enchantments.LURE, "desc", "Reduces fishing time.");
        translationBuilder.add(Enchantments.MENDING, "desc", "Repairs items with experience.");
        translationBuilder.add(Enchantments.MULTISHOT, "desc", "Shoots multiple arrows.");
        translationBuilder.add(Enchantments.PIERCING, "desc", "Arrows pierce multiple targets.");
        translationBuilder.add(Enchantments.POWER, "desc", "Increases arrow damage.");
        translationBuilder.add(Enchantments.PROJECTILE_PROTECTION, "desc", "Reduces projectile damage.");
        translationBuilder.add(Enchantments.PROTECTION, "desc", "Reduces most damage types.");
        translationBuilder.add(Enchantments.PUNCH, "desc", "Increases arrow knockback.");
        translationBuilder.add(Enchantments.QUICK_CHARGE, "desc", "Reduces crossbow loading time.");
        translationBuilder.add(Enchantments.RESPIRATION, "desc", "Extends underwater breathing.");
        translationBuilder.add(Enchantments.RIPTIDE, "desc", "Launches user in water or rain.");
        translationBuilder.add(Enchantments.SHARPNESS, "desc", "Increases melee damage.");
        translationBuilder.add(Enchantments.SILK_TOUCH, "desc", "Blocks drop themselves.");
        translationBuilder.add(Enchantments.SMITE, "desc", "Increases damage against undead.");
        translationBuilder.add(Enchantments.SOUL_SPEED, "desc", "Increases speed on soul blocks.");
        translationBuilder.add(Enchantments.SWEEPING_EDGE, "desc", "Increases sweep attack damage.");
        translationBuilder.add(Enchantments.SWIFT_SNEAK, "desc", "Increases sneaking speed.");
        translationBuilder.add(Enchantments.THORNS, "desc", "Damages attacking entities.");
        translationBuilder.add(Enchantments.UNBREAKING, "desc", "Increases item durability.");
        translationBuilder.add(Enchantments.VANISHING_CURSE, "desc", "Destroys item on death.");
        translationBuilder.add(Enchantments.WIND_BURST, "desc", "Creates launching wind on mace smash.");
    }

    private void addModEffects(TranslationBuilder translationBuilder) {
        translationBuilder.add("enchantment.enchantplus.armor/fury", "desc", "Increases damage and armor penetration.");
        translationBuilder.add("enchantment.enchantplus.armor/lifeplus", "desc", "Increases maximum health.");
        translationBuilder.add("enchantment.enchantplus.armor/venom_protection",
                "desc",
                "Reduces negative effect duration.");
        translationBuilder.add("enchantment.enchantplus.axe/timber", "desc", "Cuts down entire trees.");
        translationBuilder.add("enchantment.enchantplus.boots/agility", "desc", "Increases movement speed.");
        translationBuilder.add("enchantment.enchantplus.boots/lava_walker", "desc", "Creates solid lava walkways.");
        translationBuilder.add("enchantment.enchantplus.boots/step_assist",
                "desc",
                "Allows stepping up higher blocks.");
        translationBuilder.add("enchantment.enchantplus.bow/accuracy_shot", "desc", "Reduces arrow spread.");
        translationBuilder.add("enchantment.enchantplus.bow/breezing_arrow",
                "desc",
                "Launches nearby entities upward.");
        translationBuilder.add("enchantment.enchantplus.bow/echo_shot", "desc", "Creates echoing arrows.");
        translationBuilder.add("enchantment.enchantplus.bow/explosive_arrow", "desc", "Creates explosive arrows.");
        translationBuilder.add("enchantment.enchantplus.bow/storm_arrow", "desc", "Creates storm charged arrows.");
        translationBuilder.add("enchantment.enchantplus.chestplate/builder_arm", "desc", "Increases block reach.");
        translationBuilder.add("enchantment.enchantplus.elytra/armored", "desc", "Reduces damage while gliding.");
        translationBuilder.add("enchantment.enchantplus.helmet/auto_feed", "desc", "Automatically restores hunger.");
        translationBuilder.add("enchantment.enchantplus.helmet/bright_vision", "desc", "Provides night vision.");
        translationBuilder.add("enchantment.enchantplus.helmet/voidless", "desc", "Prevents falling into the void.");
        translationBuilder.add("enchantment.enchantplus.hoe/scyther", "desc", "Tills multiple blocks.");
        translationBuilder.add("enchantment.enchantplus.leggings/dwarfed", "desc", "Reduces player size.");
        translationBuilder.add("enchantment.enchantplus.leggings/fast_swim", "desc", "Increases swimming speed.");
        translationBuilder.add("enchantment.enchantplus.leggings/leaping", "desc", "Increases jump height.");
        translationBuilder.add("enchantment.enchantplus.leggings/oversize", "desc", "Increases player size.");
        translationBuilder.add("enchantment.enchantplus.mace/striker", "desc", "Summons lightning on attacks.");
        translationBuilder.add("enchantment.enchantplus.mace/wind_propulsion",
                "desc",
                "Launches user upward on impact.");
        translationBuilder.add("enchantment.enchantplus.pickaxe/bedrock_breaker", "desc", "Allows breaking bedrock.");
        translationBuilder.add("enchantment.enchantplus.pickaxe/spawner_touch",
                "desc",
                "Allows mining monster spawners.");
        translationBuilder.add("enchantment.enchantplus.pickaxe/vein_miner", "desc", "Mines connected ore blocks.");
        translationBuilder.add("enchantment.enchantplus.sword/attack_speed", "desc", "Increases attack speed.");
        translationBuilder.add("enchantment.enchantplus.sword/fear", "desc", "Delays creeper explosions.");
        translationBuilder.add("enchantment.enchantplus.sword/life_steal", "desc", "Restores health on hit.");
        translationBuilder.add("enchantment.enchantplus.sword/poison_aspect", "desc", "Poisons struck targets.");
        translationBuilder.add("enchantment.enchantplus.sword/pull", "desc", "Chance to obtain monster spawn eggs.");
        translationBuilder.add("enchantment.enchantplus.sword/reach", "desc", "Increases attack range.");
        translationBuilder.add("enchantment.enchantplus.sword/xp_boost", "desc", "Increases experience gain.");
        translationBuilder.add("enchantment.enchantplus.tools/auto_smelt",
                "desc",
                "Automatically smelts mined blocks.");
        translationBuilder.add("enchantment.enchantplus.tools/miningplus", "desc", "Increases mining speed.");
        translationBuilder.add("enchantment.enchantplus.bow/eternal_frost", "desc", "Creates icy arrows.");
        translationBuilder.add("enchantment.enchantplus.bow/rebound", "desc", "Arrows ricochet between targets.");
        translationBuilder.add("enchantment.enchantplus.durability/curse_of_breaking",
                "desc",
                "Increases durability consumption.");
        translationBuilder.add("enchantment.enchantplus.durability/curse_of_enchant",
                "desc",
                "Prevents enchanting and disenchanting.");
        translationBuilder.add("enchantment.enchantplus.mace/teluric_wave", "desc", "Creates seismic waves.");
        translationBuilder.add("enchantment.enchantplus.sword/last_hope",
                "desc",
                "Consumes the weapon for a fatal strike.");
        translationBuilder.add("enchantment.enchantplus.sword/tears_of_asflors",
                "desc",
                "Converts experience into damage.");
        translationBuilder.add("enchantment.enchantplus.trident/gungnir_breath",
                "desc",
                "Freezes water and slows targets.");
        translationBuilder.add("enchantment.enchantplus.elytra/kinetic_protection",
                "desc",
                "Reduces elytra collision damage.");
        translationBuilder.add("enchantment.enchantplus.hoe/harvest", "desc", "Plants seeds in an area.");
        translationBuilder.add("enchantment.enchantplus.sword/dimensional_hit",
                "desc",
                "Increases damage in other dimensions.");
        translationBuilder.add("enchantment.enchantplus.sword/critical", "desc", "Partially ignores armor.");
        translationBuilder.add("enchantment.enchantplus.sword/death_touch", "desc", "Applies Darkness.");
        translationBuilder.add("enchantment.enchantplus.sword/runic_despair",
                "desc",
                "Increases damage in the Runic dimension.");
        translationBuilder.add("enchantment.enchantplus.chestplate/magnet", "desc", "Collects nearby items.");
        translationBuilder.add("enchantment.enchantplus.mounted/cavalier_egis",
                "desc",
                "Reduces damage while mounted.");
        translationBuilder.add("enchantment.enchantplus.mounted/ethereal_leap", "desc", "Increases mount jump height.");
        translationBuilder.add("enchantment.enchantplus.mounted/steel_fang", "desc", "Increases wolf damage.");
        translationBuilder.add("enchantment.enchantplus.mounted/velocity", "desc", "Increases mount speed.");
        translationBuilder.add("enchantment.air_jump_enchantment.air_jump", "desc", "Grants an extra midair jump.");
        translationBuilder.add("enchantment.kattersstructures.blunt",
                "desc",
                "Increases damage against armored targets.");
        translationBuilder.add("enchantment.kattersstructures.crystal_curse",
                "desc",
                "Increases damage but reduces durability.");
        translationBuilder.add("enchantment.kattersstructures.web_walker", "desc", "Increases cobweb movement speed.");
        translationBuilder.add("enchantment.phy_nvs.nightvision", "desc", "Provides temporary night vision.");
        translationBuilder.add("enchantment.deeperdarker.catalysis", "desc", "Spreads sculk from defeated mobs.");
        translationBuilder.add("enchantment.deeperdarker.sculk_smite", "desc", "Increases damage against sculk mobs.");
        translationBuilder.add("enchantment.create_sa.gravity_gun", "desc", "Allows moving and throwing entities.");
        translationBuilder.add("enchantment.create_sa.impact", "desc", "Creates a damaging impact burst.");
        translationBuilder.add("enchantment.create_sa.digging", "desc", "Mines a larger area.");
        translationBuilder.add("enchantment.create_sa.hellfire", "desc", "Increases flamethrower damage.");
        translationBuilder.add("enchantment.galosphere.enfeeble", "desc", "Pink salt pillars inflict slowness.");
        translationBuilder.add("enchantment.galosphere.rupture", "desc", "Pink salt pillars release damaging shards.");
        translationBuilder.add("enchantment.galosphere.sustain", "desc", "Extends pink salt pillar duration.");
        translationBuilder.add("enchantment.galosphere.sifting", "desc", "Increases suspicious block yields.");
        translationBuilder.add("enchantment.wan_ancient_beasts.hunter_mark",
                "desc",
                "Increases damage against beasts.");
        translationBuilder.add("enchantment.wan_ancient_beasts.blood_thirst",
                "desc",
                "Increases damage while affected by potion effects.");
        translationBuilder.add("enchantment.wan_ancient_beasts.life_steal", "desc", "Restores health on hit.");
        translationBuilder.add("enchantment.gofish.deepfry", "desc", "Catches cooked fish.");
        translationBuilder.add("enchantment.shieldsplus.recoil", "desc", "Knocks back attackers.");
        translationBuilder.add("enchantment.shieldsplus.reflection", "desc", "Reflects damage to attackers.");
        translationBuilder.add("enchantment.shieldsplus.reinforced", "desc", "Increases shield protection.");
        translationBuilder.add("enchantment.shieldsplus.aegis", "desc", "Reduces damage after blocking.");
        translationBuilder.add("enchantment.shieldsplus.ablaze", "desc", "Ignites attackers.");
        translationBuilder.add("enchantment.shieldsplus.lightweight", "desc", "Increases movement while blocking.");
        translationBuilder.add("enchantment.shieldsplus.fast_recovery", "desc", "Reduces shield cooldown.");
        translationBuilder.add("enchantment.shieldsplus.shield_bash", "desc", "Grants a shield bash attack.");
        translationBuilder.add("enchantment.shieldsplus.perfect_parry",
                "desc",
                "Perfectly timed blocks negate damage.");
        translationBuilder.add("enchantment.shieldsplus.celestial_guardian",
                "desc",
                "Survive lethal damage while blocking.");
        translationBuilder.add("enchantment.grapplemod.wallrunenchantment", "desc", "Allows running on walls.");
        translationBuilder.add("enchantment.grapplemod.doublejumpenchantment", "desc", "Grants an extra jump.");
        translationBuilder.add("enchantment.grapplemod.slidingenchantment", "desc", "Allows momentum based sliding.");
        translationBuilder.add("enchantment.hunterillager.bounce", "desc", "Increases boomerang bounces.");
        translationBuilder.add("enchantment.betterarcheology.penetrating_strike",
                "desc",
                "Partially bypasses protection enchantments.");
        translationBuilder.add("enchantment.betterarcheology.seas_bounty",
                "desc",
                "Increases fishing treasure variety.");
        translationBuilder.add("enchantment.betterarcheology.soaring_winds", "desc", "Boosts elytra takeoff.");
        translationBuilder.add("enchantment.betterarcheology.tunneling", "desc", "Mines an extra block below.");
        translationBuilder.add("enchantment.endlessbiomes.vwooping", "desc", "Attackers may be teleported away.");
        translationBuilder.add("enchantment.endlessbiomes.shared_pain", "desc", "Excess damage hits nearby enemies.");
        translationBuilder.add("enchantment.stalwart_dungeons.thunder_strike",
                "desc",
                "Allows hammers to summon lightning.");
        translationBuilder.add("enchantment.butcher.butcherenchantment", "desc", "Mobs drop their corpses.");
        translationBuilder.add("enchantment.blockswapper.excavating", "desc", "Allows replacing blocks with air.");
        translationBuilder.add("enchantment.cardiac.lifesteal", "desc", "Defeated mobs drop extra healing orbs.");
    }
}
