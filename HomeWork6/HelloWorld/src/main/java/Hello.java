import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class Hello extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    private String message;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Get request");
        resp.setContentType("text/html");
        resp.getWriter().printf("<h1>" + message + "</h1>");
    }

     @Override
    public void init() {
        message = "Hello World";
    }

    @Override
    public void destroy() {
        logger.info("Servlet deleted");
    }
}
