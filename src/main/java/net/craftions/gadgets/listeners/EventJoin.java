package net.craftions.gadgets.listeners;

import net.craftions.gadgets.Gadgets;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

public class EventJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Gadgets.ACTIVE_GADGETS.put(e.getPlayer().getUniqueId(), new ArrayList<>());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        for (String s : Gadgets.ACTIVE_GADGETS.get(e.getPlayer().getUniqueId())) {
            try {
                Gadgets.KEY_TO_GADGET.get(s).getUnapplier().apply(e.getPlayer());
            } catch (NullPointerException ignored) {}
        }
        Gadgets.ACTIVE_GADGETS.remove(e.getPlayer().getUniqueId());
    }
}
