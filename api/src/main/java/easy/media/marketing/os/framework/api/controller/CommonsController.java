package easy.media.marketing.os.framework.api.controller;

import easy.media.marketing.os.framework.commons.web.view.TrailingSlashRedirectView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class CommonsController {

	@RequestMapping(value = "")
	public TrailingSlashRedirectView trailingSlashRedirect() {
		return new TrailingSlashRedirectView("/");
	}

	@RequestMapping(value = "/")
	public void index(HttpServletResponse httpServletResponse) {
		try {
			PrintWriter writer = httpServletResponse.getWriter();
			writer.write("hello, this is easy media marketing os api.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}