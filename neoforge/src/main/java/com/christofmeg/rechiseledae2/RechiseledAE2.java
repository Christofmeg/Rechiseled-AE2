package com.christofmeg.rechiseledae2;

import com.christofmeg.rechiseledae2.common.init.BlockRegistry;
import com.christofmeg.rechiseledae2.common.init.CreativeModeTabRegistry;
import com.christofmeg.rechiseledae2.common.init.ItemRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

@SuppressWarnings("unused")
@Mod(RechiseledAE2.MOD_ID)
public class RechiseledAE2 {

    public static final String MOD_ID = "rechiseledae2";
    public static final String MOD_NAME = "Rechiseled: AE2";
    @SuppressWarnings("unused")
    public static final Logger LOGGER = LogManager.getLogger();

    public RechiseledAE2() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        init(bus);
    }

    private void init(@Nonnull IEventBus modEventBus) {
        MinecraftForge.EVENT_BUS.register(this);
        BlockRegistry.init(modEventBus);
        ItemRegistry.init(modEventBus);
        CreativeModeTabRegistry.REGISTRY.register(modEventBus);
    }

}
