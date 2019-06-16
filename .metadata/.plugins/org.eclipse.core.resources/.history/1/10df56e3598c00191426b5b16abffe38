package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.element.Element;

public class AddNewPanelPage extends PanelListPage{

	protected Element tabDisplaySetting;
	protected Element radChart;
	protected Element radIndicator;
	protected Element radReport;
	protected Element txtDisplayName;
	protected Element txtIndicatorTitle;
	
	public AddNewPanelPage() {
		super();
	}

	@Override
	public void initPageElements() {
		this.tabDisplaySetting = new Element(getLocator("tabDisplaySetting").getBy());
		this.radIndicator = new Element(getLocator("radIndicator").getBy());
		this.txtDisplayName = new Element(getLocator("txtDisplayName").getBy());
		this.txtIndicatorTitle = new Element(getLocator("txtIndicatorTitle").getBy());
	}
	
	/*
	 * Author: Tien Tran
	 * Method name: clickRadioButton()
	 * Purpose/Description: click all radio button on the page
	 * 
	 * */
	
	public void clickIndicatorRadioButton() {
		radIndicator.waitForClickable(60).click();
	}	
}
