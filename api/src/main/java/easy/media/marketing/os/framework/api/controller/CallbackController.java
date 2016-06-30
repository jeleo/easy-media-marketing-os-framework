package easy.media.marketing.os.framework.api.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

public abstract class CallbackController {

    protected static class CallbackXmlInput implements HttpInputMessage {
        private HttpEntity<String> entity;

        public CallbackXmlInput(HttpEntity<String> entity) {
            this.entity = entity;
        }

        @Override
        public InputStream getBody() throws IOException {
            // 这里要设置编码格式，否则后面做xml转换会出错
            return new ByteArrayInputStream(this.entity.getBody().getBytes("UTF-8"));
        }

        @Override
        public HttpHeaders getHeaders() {
            return this.entity.getHeaders();
        }
    }

}
