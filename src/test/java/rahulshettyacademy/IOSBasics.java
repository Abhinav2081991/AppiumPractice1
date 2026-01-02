package rahulshettyacademy;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest{

	
	@Test
	public void IOSBasicsTest()
	{
		//Xpath, classname, IOS, iosClassCHain, IOSPredicateString, accessibility id, id
         /*🏆 Locator Priority(Best Practice Order)

        1️⃣ accessibilityId
        2️⃣ iOSNsPredicateString
        3️⃣ iOSClassChain
        4️⃣ id / name
        5️⃣ xpath (last option)*/
        /*
        Appium for iOS uses XCUITest, so locators are based on iOS UI elements exposed by Apple’s accessibility framework.
        1.1️⃣ Accessibility ID (MOST RECOMMENDED). Maps to accessibilityIdentifier OR accessibilityLabel
                driver.findElement(AppiumBy.accessibilityId("loginButton"));
                When to use Buttons:  Text fields , Icons,  Any element with developer-provided identifiers
                📌 Best practice: Ask developers to add accessibilityIdentifiers

        2. 2️⃣ iOS Class Chain (Fast XPath alternative). iOS-specific locator using UI hierarchy traversal
              //  driver.findElement(AppiumBy.iOSClassChain(" //XCUIElementTypeCell[`label == 'Settings'`]" ));
       // When to use : Lists / tables Complex hierarchies When Accessibility ID is missing

       3. 3️⃣ iOS Predicate String (Very Powerful). Uses NSPredicate (Apple’s query language)
            driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Login' AND enabled == 1" ));

       4. 4️⃣ XPath (Use as Last Resort)  driver.findElement(By.xpath(     "//XCUIElementTypeButton[@name='Login']" ));
       5. 5️⃣ iOS Class Name  driver.findElement(By.className("XCUIElementTypeButton"));
       6. 6️⃣ Name Locator driver.findElement(By.name("Login"));.  ⚠️ Less reliable than accessibilityId
       7. 7️⃣ ID Locator (Rarely Used) driver.findElement(By.id("login_button"));
            a. Internally maps to accessibility properties
            b. Less explicit than accessibilityId

        */
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		//Xpath -XMl language- App source
	//	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		//	driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"));
		//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'"));		
		driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
	    String text=	driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();
	    System.out.println(text);
		
		driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
		
		//longpress, scroll, swipe, slides, dropdowns

	}
}
