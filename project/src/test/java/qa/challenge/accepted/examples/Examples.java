package qa.challenge.accepted.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import qa.challenge.accepted.BrowserStack;
import qa.challenge.accepted.LocalEnvironment;
import qa.challenge.accepted.SauceLabs;
import qa.challenge.accepted.configs.Configs;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;

/**
 * Created by nikolay.stanoev on 2/23/2017.
 */
public class Examples {

    WebDriver webDriver;
    BrowserStack browserStackConfig;
    SauceLabs sauceLabsConfig;
    LocalEnvironment localEnvConfig;


    public Examples() {
        this.webDriver = null;
        this.browserStackConfig = new BrowserStack();
        this.sauceLabsConfig = new SauceLabs();
        this.localEnvConfig = new LocalEnvironment();
    }

    private String getBrowserVersion() {
        webDriver.get("https://www.whatismybrowser.com/");
        String result = webDriver.findElement(By.cssSelector(".string-major")).getText();
        webDriver.quit();
        System.out.println(result);
        return result;
    }

    private String generateErrorMsg(String expected, String actual) {
        return "Expected: " + expected + " but Found: " + actual;
    }

    @Test
    public void browserStackIPhoneExample() throws MalformedURLException {
        String expectedResult = "Safari 9 on iOS 9.1";
        DesiredCapabilities capabilities = browserStackConfig.getIOSCapabilities("iPhone", "iPhone 6S Plus", "9.1");
        webDriver = new RemoteWebDriver(new URL(browserStackConfig.getHubUrl(Configs.BROWSERSTACK_USERNAME,
                Configs.BROWSERSTACK_AUTOMATE_KEY)), capabilities);
        String result = getBrowserVersion();
        assertTrue(expectedResult.equals(result), generateErrorMsg(expectedResult, result));
    }

    @Test
    public void browserStackAndroidExample() throws MalformedURLException {
        String expectedResult = "Chrome 37 on Android (Lollipop)";
        DesiredCapabilities capabilities = browserStackConfig.getAndroidCapabilities("Android", "Google Nexus 5", "5");
        webDriver = new RemoteWebDriver(new URL(browserStackConfig.getHubUrl(Configs.BROWSERSTACK_USERNAME,
                Configs.BROWSERSTACK_AUTOMATE_KEY)), capabilities);
        String result = getBrowserVersion();
        assertTrue(expectedResult.equals(result), generateErrorMsg(expectedResult, result));
    }

    @Test
    public void sauceLabsIPhoneExample() throws MalformedURLException {
        String expectedResult = "Safari 10 on iOS 10";
        DesiredCapabilities capabilities = sauceLabsConfig.getIOSCapabilities("Safari", "iPhone 7 Simulator", "10.0");
        webDriver = new RemoteWebDriver(new URL(sauceLabsConfig.getHubUrl(Configs.SAUCELABS_USERNAME,
                Configs.SAUCELABS_ACCESS_KEY)), capabilities);
        String result = getBrowserVersion();
        assertTrue(expectedResult.equals(result), generateErrorMsg(expectedResult, result));
    }

    @Test
    public void sauceLabsAndroidExample() throws MalformedURLException {
        String expectedResult = "Safari 10 on iOS 10";
        DesiredCapabilities capabilities = sauceLabsConfig.getAndroidCapabilities("Browser", "LG Nexus 4 GoogleAPI Emulator", "4.4");
        webDriver = new RemoteWebDriver(new URL(sauceLabsConfig.getHubUrl(Configs.SAUCELABS_USERNAME,
                Configs.SAUCELABS_ACCESS_KEY)), capabilities);
        String result = getBrowserVersion();
        assertTrue(expectedResult.equals(result), generateErrorMsg(expectedResult, result));
    }

    @Test
    public void sauceLabsAndroidExample2() throws MalformedURLException {
        String expectedResult = "Safari 10 on iOS 10";
        DesiredCapabilities capabilities = sauceLabsConfig.getAndroidCapabilities("Chrome", "LG Nexus 4 GoogleAPI Emulator", "4.4");
        webDriver = new RemoteWebDriver(new URL(sauceLabsConfig.getHubUrl(Configs.SAUCELABS_USERNAME,
                Configs.SAUCELABS_ACCESS_KEY)), capabilities);
        String result = getBrowserVersion();
        assertTrue(expectedResult.equals(result), generateErrorMsg(expectedResult, result));
    }

    @Test
    public void localEnvIPhoneExample() throws MalformedURLException {
        String expectedResult = "Safari 10 on iOS 10.2";
        DesiredCapabilities capabilities = localEnvConfig.getIOSCapabilities("safari", "iPhone 7", "10.2");
        webDriver = new RemoteWebDriver(new URL(localEnvConfig.getHubUrl()), capabilities);
        String result = getBrowserVersion();
        assertTrue(expectedResult.equals(result), generateErrorMsg(expectedResult, result));
    }

    @Test
    public void localEnvAndroidGMExample() throws MalformedURLException {
        String expectedResult = "Chrome 56 on Android (Marshmallow)";
        DesiredCapabilities capabilities = localEnvConfig.getAndroidCapabilities("Chrome", "Samsung Galaxy S7", "6.0");
        webDriver = new RemoteWebDriver(new URL(localEnvConfig.getHubUrl()), capabilities);
        String result = getBrowserVersion();
        assertTrue(expectedResult.equals(result), generateErrorMsg(expectedResult, result));
    }

    @Test
    public void localEnvAndroidGMExample2() throws MalformedURLException {
        String expectedResult = "Chrome 44 on Android (Marshmallow)";
        DesiredCapabilities capabilities = localEnvConfig.getAndroidCapabilities("Browser", "Samsung Galaxy S7", "6.0");
        webDriver = new RemoteWebDriver(new URL(localEnvConfig.getHubUrl()), capabilities);
        String result = getBrowserVersion();
        assertTrue(expectedResult.equals(result), generateErrorMsg(expectedResult, result));
    }

    @Test
    public void localEnvAndroidAVDExample() throws Exception {
        String expectedResult = "Chrome 56 on Android (Nougat)";
        DesiredCapabilities capabilities = localEnvConfig.getAndroidCapabilities("Chrome", "Android Emulator", "7.0");
        webDriver = new RemoteWebDriver(new URL(localEnvConfig.getHubUrl()), capabilities);
        String result = getBrowserVersion();
        assertTrue(expectedResult.equals(result), generateErrorMsg(expectedResult, result));
    }

}
