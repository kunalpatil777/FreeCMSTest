package com.cms.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.cms.qa.base.TestBase;

public class SourcePage extends TestBase{
	public SourcePage() {
		PageFactory.initElements(driver, this);

	}

}
