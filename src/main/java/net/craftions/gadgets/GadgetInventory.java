package net.craftions.gadgets;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GadgetInventory {
    public void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 54, "§4§lGadgets");
        if (Gadgets.GADGETS.size() > 54) {
            player.sendMessage("§cThere are too many gadgets!");
        } else {
            for (Gadget gadget : Gadgets.GADGETS) {
                ItemStack item = new ItemStack(gadget.getMaterial());
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName(gadget.getName());
                meta.addItemFlags(ItemFlag.values());
                item.setItemMeta(meta);
                inv.addItem(item);
            }
            inv.setMaxStackSize(1);
            player.openInventory(inv);
        }
    }
}