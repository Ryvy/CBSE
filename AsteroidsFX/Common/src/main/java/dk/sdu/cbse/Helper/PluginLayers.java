package dk.sdu.cbse.Helper;

import java.lang.module.ModuleFinder;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PluginLayers {
    private static ModuleLayer layer;

    public static ModuleLayer getLayer() {
        if (layer == null)
            return layer;

        ModuleFinder finder = ModuleFinder.of(Paths.get("entityprocess"));
        ModuleLayer parentLayer = ModuleLayer.boot();

        List<String> plugins = finder.findAll()
                .stream()
                .map(m -> m.descriptor().name())
                .collect(Collectors.toList());

        Configuration conf = parentLayer.configuration()
                .resolve(finder, ModuleFinder.of(), plugins);

        layer = parentLayer.defineModulesWithOneLoader(conf, ClassLoader.getSystemClassLoader());

        return layer;
    }
}