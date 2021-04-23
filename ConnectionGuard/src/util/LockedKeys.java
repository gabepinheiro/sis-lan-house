/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author logon
 */
import java.awt.Robot;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class LockedKeys implements Runnable {

    private boolean working = true;
    private JFrame frame;

    public LockedKeys(JFrame frame) {
        this.frame = frame;
    }

    public void stop() {
        working = false;
    }

    public static LockedKeys create(JFrame frame) {
        LockedKeys stopper = new LockedKeys(frame);
        new Thread(stopper, "LockedKeys").start();
        return stopper;
    }

    public void run() {
        try {
            Robot robot = new Robot();
            while (working) {

                robot.keyRelease(KeyEvent.VK_ALT);

                robot.keyRelease(KeyEvent.VK_TAB);

                robot.keyRelease(KeyEvent.VK_CONTROL);

                robot.keyRelease(KeyEvent.VK_DELETE);

                robot.keyPress(KeyEvent.VK_WINDOWS);
                robot.keyRelease(KeyEvent.VK_WINDOWS);
                

            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }        

    }
}
