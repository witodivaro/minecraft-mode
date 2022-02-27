package net.fabricmc.example.blocks;

import net.fabricmc.example.itemGroups.DivaroCraftItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivaroBlock extends Block {
    public static final FabricBlockSettings blockSettings = FabricBlockSettings.of(Material.WOOD).strength(2.5F).sounds(BlockSoundGroup.SAND);

    public DivaroBlock() {
        super(blockSettings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        LOGGER.info("Block is used.");

        if (!world.isClient) {
            player.jump();
            player.sendMessage(new LiteralText("Hello, " + player.getName()), false);
        }

        return ActionResult.SUCCESS;
    }

    public static final Logger LOGGER = LoggerFactory.getLogger("divaro");

    public static final Block block = new Block(blockSettings);

    public static final BlockItem item = new BlockItem(block, new FabricItemSettings().group(DivaroCraftItemGroup.itemGroup));

    public static final String name = "divaro_block";

    public void registerBlock() {
        Registry.register(Registry.BLOCK, new Identifier("divaro", name), block);
    }

    public void registerItem() {
        Registry.register(Registry.ITEM, new Identifier("divaro", name), item);
    }

    public void register() {
        LOGGER.info("BLOCK REGISTERED: " + name);

        registerBlock();
        registerItem();
    }
}
