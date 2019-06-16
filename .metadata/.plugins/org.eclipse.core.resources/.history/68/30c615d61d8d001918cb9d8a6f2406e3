package com.logigear.test.ta_dashboard.testcases;

import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.PanelDialog;
import com.logigear.test.ta_dashboard.pom.PanelListPage;
import com.logigear.testfw.common.BaseTest;
import com.logigear.testfw.element.Element;

public class PanelTest extends BaseTest{
	@Test
	public void DA_PANEL_TC031() {
		
		precondition();
		
		Element element1 = new Element("//a[@href='#Administer']");
		element1.click();
		Element element2 = new Element("//a[@href='panels.jsp']");
		element2.click();

		PanelListPage panelListPage = new PanelListPage();
		PanelDialog addNewPanelPage = panelListPage.clickLinkAddNew();
		
		addNewPanelPage.clickIndicatorRadioButton().clickReportRadioButton();

	}
}
