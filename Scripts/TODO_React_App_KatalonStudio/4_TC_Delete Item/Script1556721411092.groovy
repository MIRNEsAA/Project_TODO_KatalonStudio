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






WebDriver driver = DriverFactory.getWebDriver()

/* Verify elements in the list 
 * Number of element in the list is changed 
 * Verify that all element  are  displayed in the list
 */

WebElement Table_after = driver.findElement(By.xpath("//div//ul[@class='todo-list']"))
List < WebElement > rows_table_after = Table_after.findElements(By.tagName('li'))
int rows_count_after = rows_table_after.size()

// Print out for debuging 
println(" Number of inserted items are :" + rows_count_after)


/*
 * Operation with  elements 
 * Delete or destroy from list 
 * Desctroy function : To be visible "X" as destroy, we have to perform  MouseOver action
 */

String destroy_item = "3. Make Coffee"

Loop:
for(int i = 1; i < rows_table_after.size(); i++)
{
	String celltext = rows_table_after.get(i).findElement(By.xpath(".//label")).getText()
	if (celltext == destroy_item)
	{
		//   MouseOver Action 
	//	Actions action = new Actions(driver);
		WebElement elemnt = rows_table_after.get(i)
	//	action.moveToElement(elemnt).perform();
		
		// Destroy X should be visible
		
		//destroy_btn.click()
		//break Loop
		
		Actions builder = new Actions(driver);
		builder.moveToElement(elemnt).perform();
		driver.sleep(5000)  // To show action
		WebElement destroy_btn =rows_table_after.get(i).findElement(By.xpath(".//button[@class='destroy']"))
		destroy_btn.click()
		break Loop;
		
		
	}
}


// to do validation check  no of items in list before and after deleting  it should be size -1



