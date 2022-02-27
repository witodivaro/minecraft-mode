package net.fabricmc.example.itemGroups;

import net.fabricmc.example.blocks.DivaroBlock;
import net.fabricmc.example.items.Cigar;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class DivaroCraftItemGroup {
    public static String path = "divaro_craft";

    public static final ItemGroup itemGroup = FabricItemGroupBuilder.build(
            new Identifier("divaro", path),
            () -> new ItemStack(Cigar.item)
    );
}
