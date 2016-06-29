package easy.media.marketing.os.framework.commons.web.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import kr.pe.kwonnam.freemarker.inheritance.BlockDirective;
import kr.pe.kwonnam.freemarker.inheritance.ExtendsDirective;
import kr.pe.kwonnam.freemarker.inheritance.PutDirective;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

public class CommonFreeMarkerConfiguration extends FreeMarkerConfigurer {

    public CommonFreeMarkerConfiguration() {
        this(true);
    }

    public CommonFreeMarkerConfiguration(boolean enableTemplateInheritance) {
        super.setDefaultEncoding("utf-8");
        super.setPreferFileSystemAccess(false);

        if (enableTemplateInheritance) {
            this.addLayoutTemplateInheritance();
        }
    }

    @Override
    protected Configuration newConfiguration() throws IOException, TemplateException {
        return new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    }

    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        this.configure();

        super.afterPropertiesSet();
        super.getTaglibFactory().setObjectWrapper(super.getConfiguration().getObjectWrapper());
    }

    protected void configure() {
        this.configureSettings(this.freemarkerSettings);
        super.setFreemarkerSettings(this.freemarkerSettings);
        this.configureVariables(this.freemarkerVariables);
        super.setFreemarkerVariables(this.freemarkerVariables);
    }

    protected void configureSettings(Properties freemarkerSettings) {
    }

    protected void configureVariables(Map<String, Object> freemarkerVariables) {
    }

    private void addLayoutTemplateInheritance() {
        Map<String, Object> directives = new HashMap<>();

        directives.put("extends", new ExtendsDirective());
        directives.put("block", new BlockDirective());
        directives.put("put", new PutDirective());

        this.freemarkerVariables.put("layout", directives);
    }

    private Properties freemarkerSettings = new Properties();

    private Map<String, Object> freemarkerVariables = new HashMap<>();

}
