package com.antikb.mod;

import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class KnockbackHandler {

    @SubscribeEvent
    public void onKnockback(LivingKnockBackEvent event) {
        float multiplier = AntiKnockback.strengthMultiplier;

        if (multiplier <= 0.0f) {
            event.setStrength(0.0f);
            return;
        }

        event.setStrength(event.getStrength() * multiplier);
    }
}
