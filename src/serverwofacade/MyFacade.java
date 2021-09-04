/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverwofacade;

/**
 *
 * @author boom3
 */
public class MyFacade {
    private static MyFacade myFacadeObj = null;
    private static ScheduleServer scheduleServer = null;
        private MyFacade() {}
        public static MyFacade getMyFacadeObject() {
            if (myFacadeObj == null) {
                myFacadeObj = new MyFacade();
                scheduleServer = new ScheduleServer();
            } 
            return myFacadeObj;
        }
        public void startServer() {
            scheduleServer.startBooting();
            scheduleServer.readSystemConfigFile();
            scheduleServer.init();
            scheduleServer.initializeContext();
            scheduleServer.initializeListeners();
            scheduleServer.createSystemObjects();
        }
        public void stopServer() {
            scheduleServer.releaseProcesses();
            scheduleServer.destory();
            scheduleServer.destroySystemObjects();
            scheduleServer.destoryListeners();
            scheduleServer.destoryContext();
            scheduleServer.shutdown();
        }
}
