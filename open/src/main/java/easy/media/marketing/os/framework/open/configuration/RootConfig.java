package easy.media.marketing.os.framework.open.configuration;

import easy.media.marketing.os.framework.open.service.Services;
import easy.media.marketing.os.framework.open.utils.Utils;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@PropertySource(value = {"classpath:settings.properties"})
@EnableAspectJAutoProxy
@EnableScheduling
@Import({PersistenceConfig.class, SecurityConfig.class})
@ComponentScan(basePackageClasses = {Utils.class, Services.class})
public class RootConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
