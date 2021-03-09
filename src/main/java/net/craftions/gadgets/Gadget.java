package net.craftions.gadgets;

import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gadget {
    private final Material material;
    private final String key;
    private final String name;
    private final List<String> not_allowed_gadgets = new ArrayList<>();

    public Gadget(@NotNull Material material, @NotNull String key, @NotNull String name, @NotNull Applyer applyer, String... not_allowed_gadgets) {
        this.material = material;
        this.key = key;
        this.name = name;
        this.not_allowed_gadgets.addAll(Arrays.asList(not_allowed_gadgets));
        Gadgets.GADGETS.add(this);
        Gadgets.KEY_TO_GADGET.put(key, this);
    }

    public final Material getMaterial() {
        return material;
    }

    public final String getName() {
        return name;
    }

    public final String getKey() {
        return key;
    }
}
