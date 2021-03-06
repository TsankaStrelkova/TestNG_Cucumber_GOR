//Particular example class.
//It is intended to be used only as an example.

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import dataProviders.ConfigFileReader;

import managers.FileReaderManager;

public class HomePage {
    WebDriver driver;
    ConfigFileReader configFileReader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    public void perform_Search(String search) {
        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() + "/?s=" + search + "&post_type=product");
    }

    public void navigateTo_HomePage() {
        driver.get(configFileReader.getApplicationUrl());
    }

}