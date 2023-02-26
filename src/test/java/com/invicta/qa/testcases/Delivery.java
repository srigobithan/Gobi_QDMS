//***********************************************************************************
//* Description
//*------------
//* Delivery functionaltiy
//***********************************************************************************
//*
//* Author           : Sriharan Gobithan
//* Date Written     : 23/02/2023
//* 
//*
//* 
//* Test Case Number       Date         Intis        Comments
//* ================       ====         =====        ========
//*                        23/02/2023   Gobithan     Orginal Version
//*
//************************************************************************************

package com.invicta.qa.testcases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import com.aventstack.extentreports.Status;
import com.invicta.qa.base.Innitialization;
import com.invicta.qa.pages.EmployeeImportPage;

public class Delivery extends Innitialization {
	static EmployeeImportPage delivery = new EmployeeImportPage();
	
/******************************************************************************
 * 					Data Search Function
 ******************************************************************************/
public static void DataSearch(String Name,String NameXpath_firstPart,String NameXpath_lastPart,String EditXpath_firstPart,String EditXpath_lastPart) throws InterruptedException, IOException {
			
	 boolean clickNextPage = true;
	    boolean sbuExist = false;
	    while (clickNextPage) {
	        for (int i = 2; i < 103; i++) {
	            try {
	                String text = driver.findElement(By.xpath(NameXpath_firstPart + i + NameXpath_lastPart)).getText();
	                System.out.println(text);
	                if (text.equals(Name)) {
	                    sbuExist = true;
	                    driver.findElement(By.xpath(EditXpath_firstPart + i + EditXpath_lastPart)).click();
	                    Thread.sleep(2000);	                    
	                    clickNextPage = false;
	                    break;
	                }
	            } catch (Exception e) {
	            }
	        }
	        if (clickNextPage == true) {
	            clickNextPage = driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']"))
	                    .isEnabled();
	            driver.findElement(By.xpath("//li[@title='Next Page']//button[@type='button']")).click();
	            Thread.sleep(2000);
	        } else {
	            break;
	        }
	    }
	    if (sbuExist = false) {
	        System.out.println("No such Element" + sbuExist);
	    }
}

/******************************************************************************
 * 						Field Value Check Function
 ******************************************************************************/
	static boolean Visible = true;
	static boolean Enable = true;
	
	
  public static void EnableDisablecheckMethod(WebElement field,String testCasedetail,String displaypass, String displayfail, String enablepass, String enablefail) throws InterruptedException {
	
    testCase = extent.createTest(testCasedetail);
    String expecteddata ="true";
    try {
        Assert.assertEquals(field.isDisplayed(), true);
        testCase.log(Status.INFO, "Actual Data :- " + Visible);
        testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
        testCase.log(Status.PASS, displaypass);
    } catch (AssertionError e) {
        Visible=false;
        testCase.log(Status.INFO, "Actual Data :- " + Visible);
        testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
        testCase.log(Status.FAIL, displayfail);
    }
    catch (NoSuchElementException e) {
        Visible=false;
        testCase.log(Status.FAIL, "Wrong last added data");
    }
    if(Visible) {
        try {
            Assert.assertEquals(field.isEnabled(), true);
            testCase.log(Status.INFO, "Actual Data :- " + Enable);
            testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
            testCase.log(Status.PASS, enablepass);
        } catch (AssertionError e) {
            Enable=false;
            testCase.log(Status.INFO, "Actual Data :- " + Enable);
            testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
            testCase.log(Status.FAIL, enablefail);
        }
    }
    
    /*    if (Visible) {
        USE THE OTHER METHODS
    }*/
}

  /**********************************************************************************************
   * 									Delivery Add Form Visible & Enable
   **********************************************************************************************/
public static void fieldvisible() throws InterruptedException, IOException {
	//Click On Delivery Form Add Button
		delivery.deliveryaddbtn.click();
	//Delivery Form Delivery Field Visible & Enable
		testCase = extent.createTest("Step:4 VISIBLE & ENABLE in DELIVERY FIELD");
		Thread.sleep(2000);
		EnableDisablecheckMethod(delivery.enterdeliverycycle,"1.ADD DELIVERY FORM DELIVERY FIELD VISIBLE & ENABLE ","Correct Delivery Field Visibled","Wrong Delivery Field Not Visibled","Correct Delivery Field Enabled","Wrong Delivery Field Not Enabled");
		Thread.sleep(2000);
	//Delivery Form Project Field Visible & Enable
		EnableDisablecheckMethod(delivery.dropdown,"2.ADD DELIVERY FORM PROJECT FIELD VISIBLE & ENABLE ","Correct Project Field Visibled","Wrong Project Field Not Visibled","Correct Project Field Enabled","Wrong Project Field Not Enabled");
		Thread.sleep(2000);	
	//Delivery Form Description Field Visible & Enable
		EnableDisablecheckMethod(delivery.textarea,"3.ADD DELIVERY FORM DESCRIPTION FIELD VISIBLE & ENABLE ","Correct Description Field Visibled","Wrong Description Field Not Visibled","Correct Description Field Enabled","Wrong Description Field Not Enabled");
		Thread.sleep(2000);
	//Delivery Form Save Button Visible & Enable
		EnableDisablecheckMethod(delivery.Savebtn,"4.ADD DELIVERY FORM SAVE BUTTON VISIBLE & ENABLE ","Correct Add Delivery Form Save Button Visibled","Wrong Add Delivery Form Save Button Not Visibled","Correct Add Delivery Form Save Button Enabled","Wrong Add Delivery Form Save Button Not Enabled");	
}
     
/**********************************************************************************************
 * 									Add Method for Delivery
 **********************************************************************************************/	

public static void deliveryadddata() throws InterruptedException, IOException {
	
		Thread.sleep(1500);
		delivery.enterdeliverycycle.sendKeys("Testing");
		
		Thread.sleep(1500);
		delivery.selectproject.sendKeys("Domestic");
		
		Thread.sleep(3000);
		delivery.dropdownfield.click();
		
		Thread.sleep(1500);
		delivery.textarea.sendKeys("Testingtesting");
		
		Thread.sleep(1500);
		delivery.Savebtn.click();
		
		driver.navigate().refresh();
		Thread.sleep(2000);

			    
           
        Thread.sleep(2000);
        String actualdata = EmployeeImportPage.firstaddeddata.getText();
        System.out.println("First row of table : " + actualdata);

    
            String expecteddata ="Testing";
        
            boolean firstdata = true;
            testCase = extent.createTest("1. CHECK THE ENTERED VALUE HAS SAVED IN FIRST OF THE TABLE");
            try {
                AssertJUnit.assertEquals(actualdata, expecteddata);
        
            } catch (AssertionError e) {
                firstdata = false;
            }
            if (firstdata) {
                testCase.log(Status.INFO, "Actual Data :- " + actualdata);
                testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
                testCase.log(Status.PASS, "Correct last data added in first row");
            } else {
                testCase.log(Status.INFO, "Actual Data :- " + actualdata);
                testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
                testCase.log(Status.FAIL, "Wrong Last Data Not Added in first row");
    }
          
		
/*		AddDataSearch("Delivery 47","//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[","]/td[1]",
				   "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[","]/td[5]/span/a[1]");
	*/
			
		/*	
		// locate the table element
		WebElement table = driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody"));

		// get all rows of the table
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
					    
		// loop through each row
		for (WebElement row : rows) {
		    // get all cells in the row
		    List<WebElement> cells = row.findElements(By.tagName("td"));
		    

		    for (int i = 0; i < 2; i++) {
		    
		    	// check if this is the 8th cell
		    	//if (i == 8) {
		    		// print the text of the 8th cell			    	
			    	String delivery=cells.get(i).getText();
			    	
			    	System.out.println("delivery"+ delivery);
			    	//break;
		    	//}
		    }
		    
		}
		*/	
}



/**********************************************************************************************
 * 									Edit Method for Delivery
 **********************************************************************************************/
public static void deliveryEdit() throws InterruptedException, IOException {
	
/*Data Search Method for find the Element*/    
   DataSearch("Delivery 47","//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[","]/td[1]",
		   "//*[@id=\"root\"]/div/section/section/main/div/div/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[","]/td[5]/span/a[1]");
    
    Thread.sleep(1500);
    delivery.DeliveryFieldEdit.sendKeys(Keys.CONTROL + "a" , Keys.DELETE);
	delivery.DeliveryFieldEdit.sendKeys("Domestic new");   
	Thread.sleep(2000);
	delivery.EditSavebtn.click();
    
    
    Thread.sleep(1500);
	String actualdata = delivery.DeliveryFieldEdit.getText();
    String expecteddata ="Domestic new";
    testCase = extent.createTest("Step5: DELIVERY EDIT FORM");
    boolean firstdata = true;
    testCase = extent.createTest("1.CHECK THE EDIT VALUE HAS UPDATED IN FIRST OF THE TABLE");
    try {
        AssertJUnit.assertEquals(actualdata, expecteddata);

    } catch (AssertionError e) {
        firstdata = false;
    }
    if (firstdata) {
        testCase.log(Status.INFO, "Actual Data :- " + actualdata);
        testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
        testCase.log(Status.PASS, "Correct last Edited data added in first row");
    } else {
        testCase.log(Status.INFO, "Actual Data :- " + actualdata);
        testCase.log(Status.INFO, "Expected Data :- " + expecteddata);
        testCase.log(Status.FAIL, "Wrong Last Edited Data Not Added in first row");

}

 // Edit Button Visible & Enable
     
    EnableDisablecheckMethod(delivery.enterdeliverycycle,"1.EDIT DELIVERY BUTTON VISIBLE & ENABLE ","Correct Delivery Edit Button Visibled","Wrong Delivery Edit Button Not Visibled","Correct Delivery Edit Button Enabled","Wrong Delivery Edit Button Not Enabled");
    Thread.sleep(2000);
    

   
 }


}



