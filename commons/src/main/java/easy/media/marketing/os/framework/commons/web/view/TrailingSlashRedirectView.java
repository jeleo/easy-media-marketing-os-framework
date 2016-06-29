package easy.media.marketing.os.framework.commons.web.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.RedirectView;

public class TrailingSlashRedirectView extends RedirectView {
	public TrailingSlashRedirectView(String url) {
		super(url, true);
		super.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
	}
}
