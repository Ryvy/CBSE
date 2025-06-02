package dk.sdu.mmmi.cbse.core;

import dk.sdu.cbse.common.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

@Configuration
public class SpringConfiguration {

    @Bean
    public Game game(){
        return new Game(EntityProcessings(), EntityPostProcessings(), Plugins());
    }

    @Bean
    public List<IEntityProcessing> EntityProcessings(){
        return ServiceLoader.load(IEntityProcessing.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }

    @Bean
    public List<IEntityPostProcessing> EntityPostProcessings(){
        return ServiceLoader.load(IEntityPostProcessing.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }

    @Bean
    public List<IPlugin> Plugins(){
        return ServiceLoader.load(IPlugin.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }
}
