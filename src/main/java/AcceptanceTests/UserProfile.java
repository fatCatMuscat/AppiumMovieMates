package AcceptanceTests;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UserProfile extends GoogleLogin {


    @Test
    public void changeName() {
         MobileElement hamburger = (MobileElement) driver.findElements(By.id("btnHamburger"));
         hamburger.click();
    }



}
