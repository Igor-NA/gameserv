package org.morglen.intuit.gameserver.control;

import org.eclipse.jetty.server.Handler;
import org.morglen.intuit.gameserver.external.appserv.JetHandler;
import org.morglen.intuit.gameserver.external.appserv.JetServer;
import org.morglen.intuit.gameserver.external.appserv.JetServerInterface;

/**
 * Created by SEkaterina on 05.10.2016.
 */
public class AppServerController {

    private static AppServerController instance;
    private JetServerInterface jetServer;
    private Handler handler = null;
    static final Integer DEFAULT_PORT = 8080;

    /* ================================================================================= Constructors PART ===== */

    private AppServerController(){
        setHandler(new JetHandler());
        setJetServer(new JetServer(DEFAULT_PORT, getHandler()));
    }

    public static synchronized AppServerController getInstance() {
        if(instance == null)
            instance = new AppServerController();

        return instance;
    }

    /* ================================================================================= Regular methods PART ===== */

    public void start() throws Exception {
        getJetServer().start();
    }

    public void stop() throws Exception {
        getJetServer().stop();
    }


    /* ================================================================================= Getters / Setters PART ===== */

    protected JetServerInterface getJetServer() {
        return jetServer;
    }

    protected void setJetServer(JetServerInterface jetServer) {
        this.jetServer = jetServer;
    }

    protected Handler getHandler() {
        return handler;
    }

    protected void setHandler(Handler handler) {
        this.handler = handler;
    }

}
