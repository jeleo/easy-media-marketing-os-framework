package easy.media.marketing.os.framework.commons.web.customizer;

import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public class JacksonObjectMapperCustomizer {
	public static List<HttpMessageConverter<?>> customize(List<HttpMessageConverter<?>> converters) {
		for (HttpMessageConverter<?> converter : converters) {
			if (converter instanceof AbstractJackson2HttpMessageConverter) {
				customize((AbstractJackson2HttpMessageConverter) converter);
			}
		}

		return converters;
	}

	public static <E extends AbstractJackson2HttpMessageConverter> E customize(E converter) {
		customize(converter.getObjectMapper());
		return converter;
	}

	public static ObjectMapper customize(ObjectMapper objectMapper) {
		objectMapper.registerModules(ObjectMapper.findModules());
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return objectMapper;
	}
}
