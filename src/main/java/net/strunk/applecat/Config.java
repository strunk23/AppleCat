package net.strunk.applecat;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.ConfigValue<Float> SHADOW_RADIUS = BUILDER
            .define("shadowRadius", 0.4f);

    public static final ModConfigSpec.ConfigValue<String> TEXTURE_PATH = BUILDER
            .define("texturePath", "textures/entity/apple_cat.png");

    static final ModConfigSpec SPEC = BUILDER.build();
}
