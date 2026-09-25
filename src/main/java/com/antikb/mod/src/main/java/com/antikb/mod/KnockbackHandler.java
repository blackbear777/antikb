package com.antikb.mod;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KnockbackHandler {

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.START) {
            return;
        }
        if (!(event.player instanceof EntityPlayer)) {
            return;
        }

        EntityPlayer player = event.player;
        IAttributeInstance attribute = player.getEntityAttribute(SharedMonsterAttributes.knockbackResistance);
        if (attribute == null) {
            return;
        }

        double desired = 1.0 - AntiKnockback.strengthMultiplier;
        if (desired < 0.0) desired = 0.0;
        if (desired > 1.0) desired = 1.0;

        if (attribute.getBaseValue() != desired) {
            attribute.setBaseValue(desired);
        }
    }
}
