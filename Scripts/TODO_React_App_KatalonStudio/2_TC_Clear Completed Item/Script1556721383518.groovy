import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.interactions.Actions;
import com.kms.katalon.core.util.KeywordUtil



WebDriver driver = DriverFactory.getWebDriver()

WebElement Table_after = driver.findElement(By.xpath("//div//ul[@class='todo-list']"))
List < WebElement > rows_table_after = Table_after.findElements(By.tagName('li'))
int rows_count_after = rows_table_after.size()

// Print out for debuging 
println(" Number of inserted items are :" + rows_count_after)


/*
 * Option "Clear Completed" will be visible only
 * if you have at  least one item selected
 */

	List<WebElement> footer = driver.findElements(By.xpath("//footer[@class='footer']"))
	
	for (int i=0;i<footer.size(); i++)
	{ 
	 String el_text = footer.get(i).getText();
	 if( el_text == "Clear completed")	
	 KeywordUtil.markFailed("Element should not have been displayed but it was! No any selected item");
	}
		
	
	
// lets select one item
Loop:
for(int i = 1; i < rows_table_after.size(); i++)
{
	
	if (i==1)
	{
		WebElement check_item =rows_table_after.get(i).findElement(By.xpath(".//input"))
		check_item.click()
		break Loop
	}
}

try {
	driver.findElement(By.xpath("//button[@class='clear-completed']")).isDisplayed();
	// Now remove completed item
	driver.findElement(By.xpath("//button[@class='clear-completed']")).click()
	}
	catch (NoSuchElementException e) {
	throw new RuntimeException("Element is not displayed");
	}


