package leila.mymci;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by leila on 4/8/2017.
 */
public class ApplicationStrat {
    public static void main(String args[]) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "C:/Users/leila/Desktop/Ap/SeliniumWeb/geckodriver-v0.15.0-win64/geckodriver.exe");

        WebDriver driver =new FirefoxDriver();

        driver.navigate().to("https://my.mci.ir/user/login.xhtml");

        Thread.sleep(5000);

        //homePopupClose(driver);

        Thread.sleep(5000);

        //loginTest(driver);


        //logOutTest(driver);

        homePopupClose(driver);

        loginTest(driver);

       // loginTestWrongUserName(driver);

        Thread.sleep(5000);

//        WebElement errorMessage= driver.findElement(By.xpath("//*[@id=\"fm:message\"]/li"));
//       String errorMessageText =errorMessage.getText();
//
//
//
//        System.out.println(errorMessageText);
//
//       if (errorMessageText.equals("شماره موبایل نامعتبر است."))
//        {
//            System.out.println("pass");
//        }
//       else
//       {
//           System.out.println("fail");
//       }

        Thread.sleep(5000);

       // readList(driver);










       // System.out.print("Exit application");

        Thread.sleep(10000);

        driver.quit();

    }

    private static void homePopupClose(WebDriver driver) {
        //Close the popup
        WebElement crossButton =driver.findElement(By.xpath("//*[@id=\"notrino-popup\"]/div/div/div[1]/button/span/i"));
        crossButton.click();
    }

    private static void logOutTest(WebDriver driver) throws InterruptedException {
        WebElement logoutButton= driver.findElement(By.xpath("//*[@id=\"navHome\"]/ul/li[2]/a"));
        logoutButton.click();
        Thread.sleep(5000);

        WebElement yesButton= driver.findElement(By.xpath("//*[@id=\"j_idt375:acceptLogoutModal\"]"));
        yesButton.click();
        Thread.sleep(2000);
    }

    private static void loginTest(WebDriver driver) throws InterruptedException {
        //Login Functionality valid User
        WebElement phoneText=driver.findElement(By.id("fm:mobileNumber"));
        phoneText.sendKeys("123029533");
        WebElement passText=driver.findElement(By.className("user-password"));
        passText.sendKeys("leila@456");




        WebElement loginButton= driver.findElement(By.id("fm:loginBTN"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
        Thread.sleep(500);

        loginButton.click();

        Thread.sleep(20000);

        driver.findElement(By.xpath("//*[@id=\"item-2\"]/a/img")).click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"middle-sub\"]/li[2]/a")).click();

        Thread.sleep(10000);

        ((JavascriptExecutor) driver).executeScript("scroll(0,350);");

          WebElement StarImage =driver.findElement(By.xpath("//*[@id=\"favoritesForm:j_idt426\"]/img"));

          String src=StarImage.getAttribute("src");

          System.out.println("the source is"+src );
          if(src.contains("fav.png"))
          {
              System.out.print("It is favorite");
          }
          //String fav = FilenameUtils.getName(src);
          //System.out.println("The main word is"+fav);
    }

    private static void loginTestWrongUserName(WebDriver driver) throws InterruptedException {
        //Login Functionality valid User
        WebElement phoneText=driver.findElement(By.id("fm:mobileNumber"));
        phoneText.sendKeys("00912");
        WebElement passText=driver.findElement(By.className("user-password"));
        passText.sendKeys("leila@456");

        WebElement loginButton= driver.findElement(By.xpath("//*[@id=\"fm:loginBTN\"]"));
        loginButton.click();

        Thread.sleep(10000);
    }

    private static void LoginTestWrongPasswordCaptcha(WebDriver driver) throws InterruptedException {

        //login with the wrong password

        WebElement phoneText=driver.findElement(By.id("fm:mobileNumber"));

        phoneText.sendKeys("9123029533");

        WebElement passText=driver.findElement(By.xpath("//*[@id=\"fm\"]/span[1]/input"));

        passText.sendKeys("leila@789");

        WebElement loginButon=driver.findElement(By.id("fm:loginBTN"));

        loginButon.click();

        Thread.sleep(10000);

        passText.sendKeys("leila@789");

        loginButon.click();
        Thread.sleep(10000);




    }
 private static void readList(WebDriver driver)
 {

     List<WebElement> webElements =driver.findElements(By.xpath("//*[@id=\"right-sub\"]/li/a"));
     System.out.println("The list has -"+webElements.size());
     for(int i=0;i<webElements.size();i++)
     {
         String listText=webElements.get(i).getText();
         System.out.println("The text of list--->"+listText);
     }


 }

}
