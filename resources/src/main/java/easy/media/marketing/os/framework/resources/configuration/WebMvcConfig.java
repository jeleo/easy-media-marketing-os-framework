package easy.media.marketing.os.framework.resources.configuration;

import easy.media.marketing.os.framework.commons.web.config.CommonFreeMarkerConfiguration;
import easy.media.marketing.os.framework.commons.web.customizer.JacksonObjectMapperCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
        configurer.setUseTrailingSlashMatch(false);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        JacksonObjectMapperCustomizer.customize(converters);
    }

    @Bean
    public FreeMarkerConfig freeMarkerConfig() {
        CommonFreeMarkerConfiguration config = new CommonFreeMarkerConfiguration();

        config.setTemplateLoaderPath("WEB-INF/templates");

        return config;
    }

    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();

        viewResolver.setSuffix(".ftl");
        viewResolver.setContentType("text/html; charset=utf-8");
        // 此变量值为pageContext.request, 页面使用方法：rc.contextPath
        viewResolver.setRequestContextAttribute("rc");
        return viewResolver;
    }

}
