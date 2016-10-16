package org.morglen.intuit.gameserver.model;


import org.eclipse.jetty.server.Response;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by SEkaterina on 05.10.2016.
 */
public class PageGenerator {

    private StringBuffer stringBuffer;

    private Boolean configure = false;

    public PageGenerator(Integer length){
        stringBuffer = length > 0 ? new StringBuffer(length) : new StringBuffer();

    }

    public PageGenerator() {
        this(0);
    }

    private void configure() {
        stringBuffer.append("<h1>Hello, server!</h1>");
        setConfigure(true);
    }

    public void append(CharSequence charSequence) {
        if(charSequence.length() < 0)
            return;

        if(!isConfigure())
            setConfigure(true);

        stringBuffer.append(charSequence);
    }

    public boolean drowe(HttpServletResponse response) throws IOException {
        if(!configure)
            configure();

        response.setIntHeader("Refresh", 1);
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        return !writeResponse(response.getWriter());
    }

    private boolean writeResponse(PrintWriter printWriter) {
        printWriter.write(getStringBuffer().toString());

        return printWriter.checkError();
    }

    protected StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    protected void setStringBuffer(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }

    public Boolean isConfigure() {
        return configure;
    }

    protected void setConfigure(Boolean configure) {
        this.configure = configure;
    }
}
