package org.morglen.intuit.gameserver.external.servlet;

import org.morglen.intuit.gameserver.model.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by SEkaterina on 05.10.2016.
 */
public class JetServlet extends HttpServlet {

    private PageGenerator pageGenerator = new PageGenerator();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        getPageGenerator().drowe(resp);

    }

    protected PageGenerator getPageGenerator() {
        return pageGenerator;
    }

    protected void setPageGenerator(PageGenerator pageGenerator) {
        this.pageGenerator = pageGenerator;
    }

}
