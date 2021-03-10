package net.craftions.gadgets.listeners;

import net.craftions.gadgets.Gadget;
import net.craftions.gadgets.Gadgets;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public class EventInteractInventory implements Listener {
    @EventHandler
    public void onInteractInventory(InventoryClickEvent e) {
        e.setCancelled(true);
        main: if (e.getClickedInventory().getMaxStackSize() == 1) {
            Gadget g = Gadgets.SLOT_TO_GADGET.get(e.getSlot());
            List<String> l = Gadgets.ACTIVE_GADGETS.get(e.getWhoClicked().getUniqueId());
            if (l.contains(g.getKey())) {
                l.remove(g.getKey());
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage("§cDeaktivated " + g.getName() + "!");
                g.getUnapplier().apply((Player) e.getWhoClicked());
            } else {
                for (String s : Gadgets.ACTIVE_GADGETS.get(e.getWhoClicked().getUniqueId())) {
                    if (Gadgets.KEY_TO_GADGET.get(s).getNot_allowed_gadgets().contains(g.getKey())) {
                        e.getWhoClicked().closeInventory();
                        e.getWhoClicked().sendMessage("§cUnable to apply.");
                        break main;
                    }
                }
                l.add(g.getKey());
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage("§aActivated " + g.getName());
                g.getApplier().apply((Player) e.getWhoClicked());
            }
            Gadgets.ACTIVE_GADGETS.put(e.getWhoClicked().getUniqueId(), l);
        }
    }
}
