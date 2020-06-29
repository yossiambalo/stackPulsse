package com.stackpulse.test;

import com.stackpulse.TestBase;
import com.stackpulse.helper.Retry;
import com.stackpulse.selenium.page.ToDoMVC;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToDoMVCTest extends TestBase {

    //text-decoration,color
    ToDoMVC toDoMVC;
    @BeforeClass
    public void beforeClass(){
        toDoMVC = new ToDoMVC(driver);
    }
    @Test(retryAnalyzer = Retry.class)
    public void _001_valid_add_new_task(){
        Assert.assertTrue(toDoMVC.addNewTask("Test1"),"Failed to create new task!");
    }
    @Test(retryAnalyzer = Retry.class)
    public void _002_valid_complete_control(){
       Assert.assertTrue( toDoMVC.completeTasks(),"Complete control not working properly!");
    }
    @Test(retryAnalyzer = Retry.class)
    public void _003_valid_active_control(){
        Assert.assertTrue( toDoMVC.activeTasks(),"Active control not working properly!");
    }
    @Test(retryAnalyzer = Retry.class)
    public void _004_valid_task_counter_label(){
        Assert.assertTrue( toDoMVC.taskCounter("TestCounterLabel"),"Active control not working properly!");
    }
}
