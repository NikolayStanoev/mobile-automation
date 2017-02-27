package qa.challenge.accepted;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by nikolay.stanoev on 2/23/2017.
 */
public class SauceLabs {

    public String getHubUrl(String username, String accessKey) {
        String server = "ondemand.saucelabs.com:443";
        String user = username;
        String key = accessKey;
        return "https://" + user + ":" + key + "@" + server + "/wd/hub";
    }

    public DesiredCapabilities getIOSCapabilities(String browser, String device, String version) {
        DesiredCapabilities capabilities = DesiredCapabilities.iphone();
        capabilities.setCapability("appiumVersion", "1.6.3");
        capabilities.setCapability("deviceName", device);
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("browserName", browser);
        return capabilities;
    }

    public DesiredCapabilities getAndroidCapabilities(String browser, String device, String version) {
        DesiredCapabilities capabilities = new DesiredCapabilities().android();
        capabilities.setCapability("appiumVersion", "1.5.3");
        capabilities.setCapability("deviceName", device);
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("platformName", "Android");
        return capabilities;
    }


}
