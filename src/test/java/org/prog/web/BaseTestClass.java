package org.prog.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.dto.PersonDto;
import org.prog.dto.RootDto;
import org.prog.pages.GooglePage;
import org.prog.pages.RozetkaPage;

public class BaseTestClass {

    public static WebDriver driver;
    private static GooglePage googlePage;


    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);

    }
    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    //@Test
    //public void testPaginationWithPageNumber() throws InterruptedException {
      // rozetkaPage.loadPage();
        //driver.manage().window().fullscreen();
            // rozetkaPage.goToPage("3");
       //Thread.sleep(5000);
        //WebElement productItem = rozetkaPage.getProductByLineAndIndex(1, 2, 5);
      //System.out.println(productItem.getText());
    //}

    //@Test
            //public void testPaginationWithArrows() throws InterruptedException{
            //rozetkaPage.loadPage();
            //driver.manage().window().fullscreen();
            //rozetkaPage.switchToRight();
            //Thread.sleep(5000);
            //WebElement productItem = rozetkaPage.getProductByLineAndIndex(1, 2, 5);
            //Assertions.assertNotNull(productItem.getText(), "Element text expected not to be empty! ");
            //System.out.println(productItem.getText());
            //}

    @Test
    public void searchForPerson(){
        Response response = RestAssured.get("https://randomuser.me/api/?inc=gender,name,nat");

        RootDto rootDto = response.body().as(RootDto.class);

        PersonDto person = rootDto.getResults().stream()
                .filter(p-> p.getGender().equals("male"))
                .findFirst().get();

        String searchQuery = person.getName().getFirst() + "" + person.getName().getLast();

        googlePage.loadPage();
        driver.manage().window().fullscreen();
        googlePage.setSearchValue(searchQuery);
        googlePage.search(false);
        Assertions.assertTrue(
                googlePage.getSearchHeaders().stream().anyMatch(elementText->elementText.contains(searchQuery))
                );

    }

}
