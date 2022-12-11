

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

class SimpleTest {
    @Test
    public void browserTest() throws AWTException {

        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\SeleniumDrivers\\chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://github.com/");
        waitTime(10000);
        System.out.println(">>>>");
        pressTab(7);
        SystemClipboard.copy("madhan4kmmr");
        SystemClipboard.paste();
        waitTime(3000);
        pressKey(KeyEvent.VK_ENTER);
        waitTime(10000);
        browser.close();

        assertTrue(true);
    }


    @Test
    public void windowTest() throws AWTException
    {

        String appPath = "C:\\Windows\\System32\\calc.exe";
        String windriverPath = "C:\\Tools\\SeleniumDrivers\\Winium.Desktop.Driver.exe";
        File driverPath = new File(windriverPath);

        WiniumDriverService service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true)
                .withSilent(false).buildDesktopService();

        DesktopOptions option = new DesktopOptions();


        option.setApplicationPath(appPath);
        // option.setDebugConnectToRunningApp(false);
        // option.setLaunchDelay(2);
        WiniumDriver driver = new WiniumDriver(service, option);
        waitTime(6000);
        System.out.println(">>>>");
        pressTab(16);
        pressKey(KeyEvent.VK_7);
        pressKey(KeyEvent.VK_ADD);
        pressKey(KeyEvent.VK_9);
        pressKey(KeyEvent.VK_ENTER);

        waitTime(10000);



        driver.quit();
        assertTrue(true);
    }


    public static void pressKey(int key) {
        Robot robot;
        try {
            robot = new Robot();
            robot.keyPress(key);
            robot.keyRelease(key);
            waitTime(300);
        } catch (AWTException e) {
            System.out.println("ERROR>>>pressKey>>>>"+ e);
        }
    }

    public static void waitTime(long milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            System.out.println("ERROR>>>waitTime>>>>"+ e);
        }
    }

    public static void pressTab(int times) {
        Robot robot;
        try {
            robot = new Robot();
            for (int i = 1; i <= times; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                waitTime(300);
            }

        } catch (AWTException e) {
            System.out.println("ERROR>>>pressTab>>>>"+ e);
        }
    }

}