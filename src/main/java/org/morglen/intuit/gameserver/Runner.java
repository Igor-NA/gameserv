package org.morglen.intuit.gameserver;

import org.morglen.intuit.gameserver.control.AppServerController;


import java.util.Scanner;

/**
 * Created by SEkaterina on 05.10.2016.
 */
public class Runner {

    private AppServerController appServerController;

    public Runner() {
        setAppServerController(AppServerController.getInstance());
    }


    public static void main(String[] args) {
        Runner runner = new Runner();

        try{

            runner.getAppServerController().start();



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                runner.getAppServerController().stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public AppServerController getAppServerController() {
        return appServerController;
    }

    public void setAppServerController(AppServerController appServerController) {
        this.appServerController = appServerController;
    }
}
