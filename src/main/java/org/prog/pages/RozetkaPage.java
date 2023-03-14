package org.prog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RozetkaPage {

    private final WebDriver driver;
    //  private final static By TOP_SALES_LABEL = By.xpath("//span[text()=' ТОП ПРОДАЖ ']");
    //   private final static By TOP_SALES_LABEL_BROKEN = By.xpath("//span[text()='ТОП ПРОДАЖ']");
    private final static By ELEMENT_CELL = By.className("catalog-grid__cell");

    //   private final static By APP_PAGINATION = By.tagName("app-paginator");


    public RozetkaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://rozetka.com.ua/network-equipment/c80111/");
    }

    public void switchToLeft() {
        scrollToAndClick(driver.findElements(By.xpath("//*[@href='#icon-angle-left']/../..")).get(0));
    }

    public void switchToRight() {
        scrollToAndClick(driver.findElements(By.xpath("//*[@href='#icon-angle-left']/../..")).get(1));
    }


    public void goToPage(String pageNumber) {
        List<WebElement> paginationBtns = driver.findElements(By.xpath("//*[@class='pagination__list']/li"));
        paginationBtns.stream().
                filter(btn -> btn.getText().equals(pageNumber))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void search(String value) {
        driver.findElement(By.name("search")).sendKeys(value);
        driver.findElement(By.className("search-form__submit")).click();
    }

    //  public WebElement verifySearchResult() {
     //   return new WebDriverWait(driver, Duration.ofSeconds(10))
     //           .until(ExpectedConditions.visibilityOfElementLocated(TOP_SALES_LABEL));}

    public WebElement getProductByLineAndIndex(int line, int index, int gridSize) {
        List<WebElement> cells = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(ELEMENT_CELL)); //0-59
        int elementIndex = (line - 1) * gridSize + index - 1;
        return cells.get(elementIndex);
    }
    private void scrollToAndClick(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.click();
    }
}

