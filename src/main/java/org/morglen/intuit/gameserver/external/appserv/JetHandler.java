package org.morglen.intuit.gameserver.external.appserv;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.morglen.intuit.gameserver.model.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SEkaterina on 05.10.2016.
 */
public class JetHandler extends AbstractHandler {


    private PageGenerator pageGenerator = new PageGenerator();

    @Override
    protected void doHandle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        baseRequest.setHandled(getPageGenerator().drowe(response));
    }


    protected PageGenerator getPageGenerator() {
        return pageGenerator;
    }

    protected void setPageGenerator(PageGenerator pageGenerator) {
        this.pageGenerator = pageGenerator;
    }
}
