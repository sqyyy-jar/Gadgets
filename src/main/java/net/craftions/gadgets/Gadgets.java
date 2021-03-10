package net.craftions.gadgets;

import net.craftions.gadgets.listeners.EventInteract;
import net.craftions.gadgets.listeners.EventInteractInventory;
import net.craftions.gadgets.listeners.EventJoin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class Gadgets extends JavaPlugin {

    public static final Material MATERIAL = Material.PAPER;
    public static final List<Gadget> GADGETS = new ArrayList<>();
    public static final Map<String, Gadget> KEY_TO_GADGET = new HashMap<>();
    public static final Map<Integer, Gadget> SLOT_TO_GADGET = new HashMap<>();
    public static final Map<UUID, List<String>> ACTIVE_GADGETS = new HashMap<>();

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new EventInteractInventory(), this);
        this.getServer().getPluginManager().registerEvents(new EventInteract(), this);
        this.getServer().getPluginManager().registerEvents(new EventJoin(), this);


        Gadget speedBoots = new Gadget(Material.GOLDEN_BOOTS, "speed_boots", ChatColor.GOLD + "Speed Boots", p -> {
            ItemStack item = new ItemStack(Material.GOLDEN_BOOTS);
            ItemMeta meta = item.getItemMeta();
            meta.addItemFlags(ItemFlag.values());
            meta.setDisplayName(ChatColor.GOLD + "Speed Boots");
            meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, new AttributeModifier("generic.movementSpeed", 0.4, AttributeModifier.Operation.ADD_NUMBER));
            item.setItemMeta(meta);
            p.getInventory().setBoots(item);
        }, p -> p.getInventory().setBoots(new ItemStack(Material.AIR)));
        // End
        for (int i = 0; i < Gadgets.GADGETS.size(); i++) {
            Gadgets.SLOT_TO_GADGET.put(i, Gadgets.GADGETS.get(i));
        }
    }

    @Override
    public void onDisable() {
    }
}
