package com.stackpulse.selenium.page;

import com.stackpulse.selenium.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ToDoMVC extends BasePageObject {

    @FindBy(className = "new-todo")
    private WebElement newToDoInput;
    @FindBy(className = "destroy")
    private List<WebElement> deleteTaskBtn;
    @FindBy(className = "view")
    private List<WebElement> taskDivs;
    @FindBy(className = "toggle-all")
    private WebElement togglAll;
    @FindBy(xpath = "//a[contains(text(), 'All')]")
    private WebElement showAllBtn;
    @FindBy(xpath = "//a[contains(text(), 'Active')]")
    private WebElement showActive;
    @FindBy(xpath = "//a[contains(text(), 'Completed')]")
    private WebElement completedBtn;
    @FindBy(xpath = "//a[contains(text(), 'Clear completed')]")
    private WebElement clearCompleted;
    @FindBy(className = "todo-count")
    private WebElement todoCountLbl;
//    @FindBy(css = "todo-count")
//    private WebElement todoCountLbl;
    public ToDoMVC(WebDriver driver) {
        super(driver);
    }
    public boolean addNewTask(String task){
        int tasksBefore = taskDivs.size();
        insertTask(task);
        return (webDriver.findElements(By.className("view")).size() == tasksBefore + 1);
    }
    public boolean completeTasks(){
        completedBtn.click();
        togglAll.click();
       return taskDivs.get(0).findElements(By.tagName("label")).get(0).getCssValue("text-decoration").contains("line-through solid rgb(217, 217, 217)");
    }
    public boolean activeTasks(){
        showActive.click();
        togglAll.click();
        return taskDivs.get(0).findElements(By.tagName("label")).get(0).getCssValue("text-decoration").contains("none solid rgb(77, 77, 77)");
    }
    public boolean taskCounter(String task){
        int taskCounterBefore = Integer.valueOf(todoCountLbl.findElement(By.tagName("strong")).getText());
        insertTask(task);
        return Integer.valueOf(todoCountLbl.findElement(By.tagName("strong")).getText()) == taskCounterBefore + 1;
    }
    private void insertTask(String task){
        newToDoInput.sendKeys(task);
        newToDoInput.sendKeys(Keys.ENTER);
    }
}
