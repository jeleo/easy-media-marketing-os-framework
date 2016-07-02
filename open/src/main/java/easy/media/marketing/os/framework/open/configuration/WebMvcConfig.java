package easy.media.marketing.os.framework.open.configuration;

import easy.media.marketing.os.framework.commons.constants.Copyright;
import easy.media.marketing.os.framework.open.controller.Controllers;
import easy.media.marketing.os.framework.open.interceptor.GlobalInterceptor;
import easy.media.marketing.os.framework.open.interceptor.Interceptors;
import easy.media.marketing.os.framework.commons.web.config.CommonFreeMarkerConfiguration;
import easy.media.marketing.os.framework.commons.web.customizer.JacksonObjectMapperCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.List;

@Configuration
@ComponentScan(basePackageClasses = {Interceptors.class, Controllers.class})
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
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalInterceptor);
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
    public FreeMarkerViewResolver freeMarkerViewResolver(@Value("${static.resources.url}") String static_resources_url) {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();

        viewResolver.setSuffix(".ftl");
        viewResolver.setContentType("text/html; charset=utf-8");
        // 此变量值为pageContext.request, 页面使用方法：rc.contextPath
        viewResolver.setRequestContextAttribute("rc");
        // 传递静态资源根路径
        viewResolver.getAttributesMap().put("static_resources_url", static_resources_url);

        // 设置版权
        viewResolver.getAttributesMap().put("copyright", Copyright.INFO);
        return viewResolver;
    }

    @Autowired
    private GlobalInterceptor globalInterceptor;

}
