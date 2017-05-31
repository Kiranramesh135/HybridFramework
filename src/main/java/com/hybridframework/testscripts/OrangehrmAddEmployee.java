package com.hybridframework.testscripts;

import org.testng.annotations.Test;

import com.hybridframework.orangehrm.pom.OrangehrmAddEmployeePage;
import com.hybridframework.orangehrm.pom.OrangehrmEmployeeListPage;
import com.hybridframework.orangehrm.pom.OrangehrmHomePage;
import com.hybridframework.orangehrm.pom.OrangehrmLoginPage;

public class OrangehrmAddEmployee extends BaseTestNG {

	@Test
	public void addEmployee() {

		OrangehrmLoginPage orangecrmLoginPage = new OrangehrmLoginPage(driver);
		logger.info("---------Opening Login Page---------");
		orangecrmLoginPage.login("Admin", "admin");
		OrangehrmHomePage orangehrmHomePage = new OrangehrmHomePage(driver);
		orangehrmHomePage.clickPimTab();
		OrangehrmEmployeeListPage orangehrmEmployeeListPage = new OrangehrmEmployeeListPage(driver);
		orangehrmEmployeeListPage.clickAddButton();
		OrangehrmAddEmployeePage orangehrmAddEmployeePage = new OrangehrmAddEmployeePage(driver);
		orangehrmAddEmployeePage.addEmployee("Mahesh", "Ram", "Indian Development Center");

	}

}
