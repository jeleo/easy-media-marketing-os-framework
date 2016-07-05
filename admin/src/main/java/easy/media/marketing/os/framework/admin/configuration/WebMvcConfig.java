package easy.media.marketing.os.framework.admin.configuration;

import easy.media.marketing.os.framework.admin.controller.Controllers;
import easy.media.marketing.os.framework.admin.interceptor.GlobalInterceptor;
import easy.media.marketing.os.framework.admin.interceptor.Interceptors;
import easy.media.marketing.os.framework.commons.constants.Copyright;
import easy.media.marketing.os.framework.commons.web.config.CommonFreeMarkerConfiguration;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.validation.Validator;
import java.util.Arrays;
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
        converters.add(mappingJackson2HttpMessageConverter());
    }

    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_HTML, MediaType.APPLICATION_JSON_UTF8));
        return mappingJackson2HttpMessageConverter;
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

    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public Validator validator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setProviderClass(HibernateValidator.class);
        return validator;
    }

    @Autowired
    private GlobalInterceptor globalInterceptor;

}
