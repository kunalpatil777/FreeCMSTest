package com.cms.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.cms.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigating to: '" + url + "'");

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigating to: '" + url + "'");

	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previos page");

	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previos page");

	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward tp the next page");

	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward tp the next page");

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find element by :" + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found element by :" + by.toString());

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on :" + element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Click on :" + element.toString());

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of the :" + element.toString() + "Before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println("Value of the :" + element.toString());
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured :" + error);
		try {
			TestUtil.takeScreenshotEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

}
