package net.craftions.gadgets.listeners;

import net.craftions.gadgets.GadgetInventory;
import net.craftions.gadgets.Gadgets;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class EventInteract implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getHand() == EquipmentSlot.HAND
        && e.hasItem()) {
            if (e.getItem().getType() == Gadgets.MATERIAL) {
                e.setCancelled(true);
                Player p = e.getPlayer();
                GadgetInventory inv = new GadgetInventory();
                inv.open(p);
            }
        }
    }
}
