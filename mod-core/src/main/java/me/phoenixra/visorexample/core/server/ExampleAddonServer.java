package me.phoenixra.visorexample.core.server;

import me.phoenixra.visor.api.common.addon.VisorAddon;
import me.phoenixra.visorexample.core.common.VisorExample;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExampleAddonServer implements VisorAddon {
    @Override
    public void onAddonLoad() {

    }

    @Override
    public @Nullable String getAddonPackagePath() {
        return "me.phoenixra.visorexample.core.server";
    }

    @Override
    public @NotNull String getAddonId() {
        return VisorExample.MOD_ID;
    }

    @Override
    public String getModId() {
        return VisorExample.MOD_ID;
    }
}
