package com.christofmeg.rechiseledae2;

import com.christofmeg.rechiseledae2.common.init.BlockRegistry;
import com.christofmeg.rechiseledae2.common.init.CreativeModeTabRegistry;
import com.christofmeg.rechiseledae2.common.init.ItemRegistry;
import com.christofmeg.rechiseledae2.common.init.RecipeRegistration;
import com.supermartijn642.rechiseled.api.registration.RechiseledRegistration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
@Mod(RechiseledAE2.MOD_ID)
public class RechiseledAE2 {
    public static final String MOD_ID = "rechiseledae2";
    public static final String MOD_NAME = "Rechiseled: AE2";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final RechiseledRegistration REGISTRATION = RechiseledRegistration.get(MOD_ID);

    public RechiseledAE2(IEventBus modEventBus) {
        BlockRegistry.init(modEventBus);
        ItemRegistry.init(modEventBus);
        CreativeModeTabRegistry.CREATIVE_MODE_TABS.register(modEventBus);
        RecipeRegistration.init();
        REGISTRATION.registerDataProviders();
    }
}
