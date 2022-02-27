package net.fabricmc.example.items;

import net.fabricmc.example.itemGroups.DivaroCraftItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cigar {
    public static final Logger LOGGER = LoggerFactory.getLogger("divaro");

    public static final String name = "cigar";

    public static final FabricItemSettings itemSettings = new FabricItemSettings().group(DivaroCraftItemGroup.itemGroup);

    public static final Item item = new Item(itemSettings);

    public void registerItem() {
        LOGGER.info("ITEM REGISTERED: " + name);

        Registry.register(Registry.ITEM, new Identifier("divaro", name), item);
    }
}
