package easy.media.marketing.os.framework.admin.configuration;

import easy.media.marketing.os.framework.admin.service.Services;
import easy.media.marketing.os.framework.admin.utils.Utils;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@PropertySource(value = {"classpath:settings.properties"})
@EnableScheduling
@Import({PersistenceConfig.class, SecurityConfig.class})
@ComponentScan(basePackageClasses = {Utils.class, Services.class})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
