package com.logigear.testfw.element;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.google.common.base.Stopwatch;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.TestExecutor;
import com.logigear.testfw.conf.LogWrapper;

abstract class BaseElement{

	private static final Logger LOG = LogWrapper.createLogger(BaseElement.class.getName());
	//protected WebElement _element = null;
	//protected List<WebElement> _elements = null;

	private By _byLocator;

	public BaseElement(By locator) {
		this._byLocator = locator;
	}

	public BaseElement(String xpath) {
		this._byLocator = By.xpath(xpath);
	}

	protected By getLocator() {
		return this._byLocator;
	}

	protected WebElement getElement() {
		return waitForDisplay(Common.ELEMENT_TIMEOUT);
	}

	protected List<WebElement> getWebElements() {
		return waitForAllElementsDisplay(Common.ELEMENT_TIMEOUT);
	}

	protected WebElement waitForPresent(int timeOutInSeconds) {
		LOG.info(String.format("Wait for control %s to be present in DOM with timeOut %s", getLocator().toString(),
				timeOutInSeconds));
		return TestExecutor.getInstance().getCurrentDriver().waitForPresent(getLocator(), timeOutInSeconds);
	}

	protected List<WebElement> waitForAllElementsPresent(int timeOutInSeconds) {
		LOG.info(String.format("Wait for all controls %s to be present in DOM with timeOut %s", getLocator().toString(),
				timeOutInSeconds));
		return TestExecutor.getInstance().getCurrentDriver().waitForAllElementsPresent(getLocator(), timeOutInSeconds);
	}
	
	protected List<WebElement> waitForAllElementsDisplay(int timeOutInSeconds) {
		LOG.info(String.format("Wait for all controls %s to be present in DOM with timeOut %s", getLocator().toString(),
				timeOutInSeconds));
		return TestExecutor.getInstance().getCurrentDriver().waitForAllElementsDisplay(getLocator(), timeOutInSeconds);
	}

	public WebElement waitForDisplay(int timeOutInSeconds) {
		LOG.info(String.format("Wait for control %s to be displayed with timeOut: %s", getLocator().toString(),
				timeOutInSeconds));
		return TestExecutor.getInstance().getCurrentDriver().waitForDisplay(getLocator(), timeOutInSeconds);
	}

	public WebElement waitForClickable(int timeOutInSeconds) {
		LOG.info(String.format("Wait for control %s to be clickabled", getLocator().toString()));
		return TestExecutor.getInstance().getCurrentDriver().waitForClickable(getLocator(), timeOutInSeconds);
	}
//
//	@Deprecated
//	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
//		throw new UnsupportedOperationException("This method is not supported");
//	}
//
//	@Deprecated
//	public List<WebElement> findElements(By by) {
//		throw new UnsupportedOperationException("This method is not supported");
//	}
//
//	@Deprecated
//	public WebElement findElement(By by) {
//		throw new UnsupportedOperationException("This method is not supported");
//	}
//
//	@Deprecated
//	public Rectangle getRect() {
//		throw new UnsupportedOperationException("This method is not supported");
//	}

	public void click(int timeOutInSeconds) {
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Click control %s with timeOut %s", getLocator().toString(), timeOutInSeconds));
			waitForClickable(timeOutInSeconds).click();
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to click control %s again", getLocator().toString()));
				click(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Cannot click on control '%s'because of some errors %s", getLocator().toString(),
					error.getMessage()));
			throw error;
		}
	}

	public void click() {
		click(Common.ELEMENT_LONG_TIMEOUT);
	}

	public void submit(int timeOutInSeconds) {
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Submit control %s", getLocator().toString()));
			waitForDisplay(timeOutInSeconds).submit();
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to submit control %s again", getLocator().toString()));
				submit(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
	}

	public void submit() {
		submit(Common.ELEMENT_LONG_TIMEOUT);
	}

	public void sendKeys(int timeOutInSeconds, CharSequence... keysToSend) {
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Send keys to the control %s without clearing", getLocator().toString()));
			waitForDisplay(timeOutInSeconds).sendKeys(keysToSend);
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to send key to the control %s again", getLocator().toString()));
				sendKeys(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS), keysToSend);
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
	}

	public void sendKeys(CharSequence... keysToSend) {
		sendKeys(Common.ELEMENT_LONG_TIMEOUT, keysToSend);
	}

	public void clear(int timeOutInSeconds) {
		LOG.info(String.format("Clear the control %s with timeOut %s", getLocator().toString(), timeOutInSeconds));
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			waitForDisplay(timeOutInSeconds).clear();
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to clear the control %s again", getLocator().toString()));
				clear(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
	}

	public void clear() {
		clear(Common.ELEMENT_TIMEOUT);
	}

	public String getTagName(int timeOutInSeconds) {
		LOG.info(String.format("Get the tag name of the control %s with timeOut %s", getLocator().toString(),
				timeOutInSeconds));
		String tag = null;
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return tag;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			tag = getElement().getTagName();
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to get the tag name of the control %s again", getLocator().toString()));
				getTagName(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
		return tag;
	}

	public String getTagName() {
		return getTagName(Common.ELEMENT_LONG_TIMEOUT);
	}

	public String getAttribute(int timeOutInSeconds, String attributeName) {
		String attribute = null;
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return attribute;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Get the attribute of the control %s", getLocator().toString()));
			attribute = getElement().getAttribute(attributeName);
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to get the attribute of the control %s again", getLocator().toString()));
				getAttribute(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS), attributeName);
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
		return attribute;
	}

	public String getAttribute(String attributeName) {
		return getAttribute(Common.ELEMENT_LONG_TIMEOUT, attributeName);
	}

	public String getText(int timeOutInSeconds) {
		String text = null;
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return text;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Get the inner text of the control %s with timeOut: %s", getLocator().toString(),
					timeOutInSeconds));
			text = getElement().getText();
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(

						String.format("Try to get the inner text of the control %s again", getLocator().toString()));
				return getText(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
		return text;
	}

	public String getText() {
		return getText(Common.ELEMENT_LONG_TIMEOUT);
	}

	public Point getLocation(int timeOutInSeconds) {
		Point location = null;
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return location;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Get the location of the control %s", getLocator().toString()));
			location = getElement().getLocation();
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to get the location of the control %s again", getLocator().toString()));
				getLocation(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
		return location;
	}

	public Point getLocation() {
		return getLocation(Common.ELEMENT_LONG_TIMEOUT);
	}

	public Dimension getSize(int timeOutInSeconds) {
		Dimension size = null;
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return size;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Get the size of the control %s", getLocator().toString()));
			size = getElement().getSize();
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to get the size of the control %s again", getLocator().toString()));
				getSize(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
		return size;
	}

	public Dimension getSize() {
		return getSize(Common.ELEMENT_LONG_TIMEOUT);
	}

	public String getCssValue(int timeOutInSeconds, String propertyName) {
		String value = null;
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return value;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Get the css value of the control %s", getLocator().toString()));
			value = getElement().getCssValue(propertyName);
		} catch (StaleElementReferenceException ex) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to get the css value of the control %s again", getLocator().toString()));
				getCssValue(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS), propertyName);
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
		return value;
	}

	public String getCssValue(String propertyName) {
		return getCssValue(Common.ELEMENT_LONG_TIMEOUT, propertyName);
	}

	public boolean isDisplayed(int timeOutInSeconds) {
		boolean isDisplayed = false;
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return isDisplayed;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Check if the control %s is displayed with timeOut %s", getLocator().toString(),
					timeOutInSeconds));
			isDisplayed = getElement().isDisplayed();
		} catch (StaleElementReferenceException e) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to check if the control the control %s is displayed again",
						getLocator().toString()));
				return isDisplayed(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Cannot Check isDisplayed on control '%s': %s", getLocator().toString(),
					error.getMessage()));
			throw error;
		}
		return isDisplayed;
	}

	public boolean isDisplayed() {
		return isDisplayed(Common.ELEMENT_TIMEOUT);
	}

	public boolean isEnabled(int timeOutInSeconds) {
		boolean isEnabled = false;
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return isEnabled;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Check if the control %s is enabled", getLocator().toString()));
			isEnabled = waitForDisplay(timeOutInSeconds).isEnabled();
		} catch (StaleElementReferenceException e) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to check if the control the control %s is enabled again",
						getLocator().toString()));
				isEnabled(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
		return isEnabled;
	}

	public boolean isEnabled() {
		return isEnabled(Common.ELEMENT_LONG_TIMEOUT);
	}

	public boolean isSelected(int timeOutInSeconds) {
		boolean isSelected = false;
		if (timeOutInSeconds <= 0) {
			LOG.severe("The time out is invalid. It must greater than 0");
			return isSelected;
		}
		Stopwatch sw = Stopwatch.createStarted();
		try {
			LOG.info(String.format("Check if the control %s is selected", getLocator().toString()));
			isSelected = waitForDisplay(timeOutInSeconds).isSelected();
		} catch (StaleElementReferenceException e) {
			if (sw.elapsed(TimeUnit.SECONDS) < (long) timeOutInSeconds) {
				LOG.warning(String.format("Try to check if the control the control %s is selected again", getLocator().toString()));
				isSelected(timeOutInSeconds - (int) sw.elapsed(TimeUnit.SECONDS));
			}
		} catch (Exception error) {
			LOG.severe(String.format("Has error with control '%s': %s", getLocator().toString(), error.getMessage()));
			throw error;
		}
		return isSelected;
	}

	public boolean isSelected() {
		return isSelected(Common.ELEMENT_LONG_TIMEOUT);
	}
}
