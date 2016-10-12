package org.morglen.intuit.gameserver.external.appserv;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;

/**
 * Created by SEkaterina on 05.10.2016.
 */
public class JetServer implements JetServerInterface {
    private Server server = null;

    public JetServer(Integer port, Handler handler) {
        server = new Server(port);
        server.setHandler(handler);
    }

    public void start() throws Exception {
        server.start();
        server.join();
    }

    public void stop() throws Exception {
        server.stop();
        server.destroy();
    }
}
