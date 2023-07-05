package earth.terrarium.chipped.datagen;

import earth.terrarium.chipped.Chipped;
import earth.terrarium.chipped.datagen.provider.client.*;
import earth.terrarium.chipped.datagen.provider.server.ModBlockTagProvider;
import earth.terrarium.chipped.datagen.provider.server.ModItemTagProvider;
import earth.terrarium.chipped.datagen.provider.server.ModLootTableProvider;
import earth.terrarium.chipped.datagen.provider.server.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Chipped.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ChippedDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Client
        var packOutput = generator.getPackOutput();
        ModBlockStateProvider stateProvider = new ModBlockStateProvider(packOutput, existingFileHelper);
        generator.addProvider(event.includeClient(), stateProvider);
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModLangProvider(packOutput));
        ModCtmTextureProvider textures = new ModCtmTextureProvider(packOutput, existingFileHelper);
        generator.addProvider(event.includeClient(), textures);
        generator.addProvider(event.includeClient(), new ModCtmModelProvider(packOutput, stateProvider, textures));

        // Server
        generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));

        var lookupProvider = event.getLookupProvider();
        ModBlockTagProvider blockTags = new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));

    }
}
