package qa.challenge.accepted;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by nikolay.stanoev on 2/23/2017.
 */
public class LocalEnvironment {

    public DesiredCapabilities getIOSCapabilities(String browser, String device, String version) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability("launchTimeout", 180);
        return capabilities;
    }

    public DesiredCapabilities getAndroidCapabilities(String browser, String device, String version) {
        DesiredCapabilities capabilities = new DesiredCapabilities().android();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
        capabilities.setCapability("fastReset", true);
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("ignore-certificate-errors");
            options.addArguments("disable-translate");
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }
        return capabilities;
    }

    public String getHubUrl() {

        return "http://172.24.64.226:4444/wd/hub";
    }

}
