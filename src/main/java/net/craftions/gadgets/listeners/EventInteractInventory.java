package net.craftions.gadgets.listeners;

import net.craftions.gadgets.Gadgets;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class EventInteractInventory implements Listener {
    @EventHandler
    public void onInteractInventory(InventoryClickEvent e) {
        if (e.getClickedInventory().getContents().length == Gadgets.GADGETS.size()) {
            e.setCancelled(true);

        }
    }
}
