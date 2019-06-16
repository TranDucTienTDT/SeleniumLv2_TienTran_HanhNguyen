package com.logigear.test.ta_dashboard.testcases;

import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.PanelDialog;
import com.logigear.testfw.common.BaseTest;

public class PanelTest extends BaseTest{
	@Test
	public void DA_PANEL_TC031() {

//		Navigate to Dashboard login page
//		Login with valid account
//		Click on Administer/Panels link
//		Click on Add new link
//		VP: Verify that chart panel setting form is displayed with corresponding panel type selected
//		
//		Select Indicator type
//		VP: Verify that indicator panel setting form is displayed with corresponding panel type selected
//		
//		Select Report type
//		VP: Verify that report panel setting form is displayed with corresponding panel type selected
//		
//		Select Heat Maps type
//		VP: Verify that heatmap panel setting form is displayed with corresponding panel type selected
//		
		HomePage homePage = precondition();

		PanelDialog addNewPanelPage = homePage.selectPanel().clickLinkAddNew();

		addNewPanelPage.clickIndicatorRadioButton();
		
		addNewPanelPage.clickReportRadioButton();
		
		addNewPanelPage.clickHeatMapRadioButton();

	}
}
