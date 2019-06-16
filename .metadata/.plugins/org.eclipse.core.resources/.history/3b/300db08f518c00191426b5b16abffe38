package com.logigear.test.ta_dashboard.testcases;

import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.AddNewPanelPage;
import com.logigear.test.ta_dashboard.pom.GeneralPage;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.test.ta_dashboard.pom.PanelListPage;
import com.logigear.testfw.common.BaseTest;

public class PanelTest extends BaseTest{
	@Test
	public void DA_PANEL_TC031() {
		
		String USERNAME = "administrator";
		String PASSWORD = "";
		String SAMPLE_REPO = "SampleRepository";

		LoginPage loginpage = new LoginPage();
		GeneralPage homePage = loginpage.login(USERNAME, PASSWORD, SAMPLE_REPO);

		PanelListPage panelListPage = new PanelListPage();
		AddNewPanelPage addNewPanelPage = panelListPage.clickLinkAddNew();
		addNewPanelPage.clickIndicatorRadioButton();

	}
}
