package uk.co.tmdavies.shadowmod.events.custom;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class ManaRegenerationEvent extends PlayerEvent {

    private final Player player;

    public ManaRegenerationEvent(Player player) {

        super(player);

        this.player = player;


    }

    public Player getPlayer() {
        return player;
    }

}
