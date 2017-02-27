package qa.challenge.accepted;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by nikolay.stanoev on 2/23/2017.
 */
public class BrowserStack {

    public String getHubUrl(String username, String automateKey) {
        String server = "hub-cloud.browserstack.com";
        String user = username;
        String key = automateKey;
        return "http://" + user + ":" + key + "@" + server + "/wd/hub";
    }

    public DesiredCapabilities getIOSCapabilities(String browser, String device, String version) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "ios");
        capabilities.setCapability("browser", browser);
        capabilities.setCapability("device", device);
        capabilities.setCapability("version", version);
        capabilities.setCapability("browserstack.debug", "true");
        return capabilities;
    }

    public DesiredCapabilities getAndroidCapabilities(String browser, String device, String version) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "android");
        capabilities.setCapability("browser", browser);
        capabilities.setCapability("device", device);
        capabilities.setCapability("version", version);
        capabilities.setCapability("browserstack.debug", "true");
        return capabilities;
    }


}
