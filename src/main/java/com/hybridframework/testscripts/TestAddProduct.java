package com.hybridframework.testscripts;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridframework.pom.CreateProductPage;
import com.hybridframework.pom.ProductsListPage;
import com.hybridframework.pom.VtigerHomePage;
import com.hybridframework.pom.VtigerLoginPage;
import com.hybridframework.utils.Browser;
import com.hybridframework.utils.ExcelReader;

public class TestAddProduct
{
	Browser browser = Browser.getInstance();
//	Browser.getInstance();
	
	@Test(dataProvider="exceldata")
	public void test_AddProduct(String name, String pwd)
	{
		
		//Open Vtiget home page
		
		VtigerLoginPage vtigerLoginPage = new VtigerLoginPage(browser);
		
		//Get page title
		System.out.println(vtigerLoginPage.getPageTitle());
		//Enter username, password and click on Login
		vtigerLoginPage.login(name, pwd);
		
		VtigerHomePage vtigerHomePage = new VtigerHomePage(browser);
		
		System.out.println(vtigerHomePage.getPageTitle());
		vtigerHomePage.clickProducts();
		
		ProductsListPage productsListPage = new ProductsListPage(browser);
		
		System.out.println(productsListPage.getPageTitle());
		productsListPage.clickAddProduct();
		
		CreateProductPage createProductPage = new CreateProductPage(browser);
		
		System.out.println(createProductPage.getPageTitle());
		createProductPage.signOut();
		
		
	}
	
	@DataProvider(name="exceldata")
	public Object[][] readData()
	{
		Object[][] data = ExcelReader.readData("Sheet1");
		return data;
	}
}
