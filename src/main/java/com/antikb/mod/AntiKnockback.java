package com.antikb.mod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AntiKnockback.MODID, name = AntiKnockback.NAME, version = AntiKnockback.VERSION, acceptableRemoteVersions = "*")
public class AntiKnockback {

    public static final String MODID = "antikb";
    public static final String NAME = "AntiKnockback";
    public static final String VERSION = "1.0.0";

    public static float strengthMultiplier = 0.0f;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        strengthMultiplier = config.getFloat(
                "strengthMultiplier",
                Configuration.CATEGORY_GENERAL,
                0.0f,
                0.0f,
                5.0f,
                "Multiplier applied to all knockback strength. 0 = knockback fully disabled. 1 = vanilla knockback."
        );

        if (config.hasChanged()) {
            config.save();
        }

        MinecraftForge.EVENT_BUS.register(new KnockbackHandler());
    }
}
