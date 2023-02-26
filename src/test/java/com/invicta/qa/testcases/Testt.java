package com.invicta.qa.testcases;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.invicta.qa.base.Innitialization;
import com.invicta.qa.pages.EmployeeImportPage;

public class Testt extends Innitialization{
	
	static EmployeeImportPage Import = new EmployeeImportPage();
	static Delivery DeliveryForm = new Delivery();
	static EmployeeImportTest UIProperties = new EmployeeImportTest();
	
	
@Test
	public static void EmployeeImport() throws InterruptedException, AWTException, IOException {
		
		PageFactory.initElements(driver, Import);
		PageFactory.initElements(driver, UIProperties);
		PageFactory.initElements(driver, DeliveryForm);
		
			
		
		/** Login **/
			UIProperties.Login();
			
		/** Step1: Material Import Button **/
			UIProperties.MaterialImportButton();
					
		/**	Step2:Employee Export Button **/
			UIProperties.MaterialExportButton();
			
		/** Step3:Material Export CSV **/
			UIProperties.ExportCSV();
			
						
		/** Step4:Delivery Button **/
	     	UIProperties.DeliveryButton();
	     	
	    /** Step5:Delivery Form Field Visible**/	
	     	DeliveryForm.fieldvisible();
	    
	    /** Step6:Delivery Form Add Data  **/	
			DeliveryForm.deliveryadddata();
			
		/** Step7:Delivery **/		
			DeliveryForm.deliveryEdit();
			
		/**	Pagination **/
			//Step8:Pagination page Visible
				UIProperties.DefaultIndexPage();
					
			//Pagination Next page 
				UIProperties.RefreshDefaultPage();
					
			//Pagination Click on 2nd page 
				UIProperties.PageRedrict();
					
			//Click on Previous page
				UIProperties.PreButtonDispaly();
					
			//Next Button Page visible
				UIProperties.NextButtonDispaly();
					
			//Next Button Enable
				UIProperties.NextButtonEanble();
					
			//PAGINATION-PREVIOUS-BUTTON-DISABLE-BEFORE MOVE THE 2ND PAGE
				UIProperties.SecPagepreButDisable();
					
			//After move to 2nd page, previous button Enable
				UIProperties.AfterMovetoSecPagepreButEnable();
					
			//Page select
				UIProperties.TotalPage();
 
		
				
				/*		
				    //Step1: Login 
						UI.EmployeeImport();
					
					//Employee Import Button
						UI.EmployeeImportButton();
					
					//Employee Export Button
						UI.EmployeeExportButton();	
				*/
				
				/*			
					//Material SBU CSV File Export
						UIProperties.MaterialSBUFilter();
						
					//MAterial Plant CSV File Export
						UIProperties.MaterialPlantFilter();
						
					// Step4:Import CSV 
						UIProperties.ImportCSV();
				*/		
				
	}

	
}
