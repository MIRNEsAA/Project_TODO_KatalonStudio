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


/*Program constants*/
class Constants {
	static int ITEM_TYPE_ALL=0
	static int ITEM_TYPE_ACTIVE=1
	static int ITEM_TYPE_COMPLETED=2
}

WebDriver driver = DriverFactory.getWebDriver()


WebElement Table_after = driver.findElement(By.xpath("//div//ul[@class='todo-list']"))
List < WebElement > rows_table_after = Table_after.findElements(By.tagName('li'))
int rows_count_after = rows_table_after.size()

// Print out for debuging 
println(" Number of inserted items are :" + rows_count_after)


/*
 * Operation with  elements 
 * Check and destroy from list 
 * Desctroy function : To be visible "X" as destroy, we have to perform  MouseOver action
 */

String expected_item = "5. Open Window"

Loop:
for(int i = 1; i < rows_table_after.size(); i++)
{
	String celltext = rows_table_after.get(i).findElement(By.xpath(".//label")).getText()
	if (celltext == expected_item)
	{
		WebElement check_item =rows_table_after.get(i).findElement(By.xpath(".//input"))
		check_item.click()
		break Loop
	}
}




// Verification! Verify all filters All, Active and Completed

/*
 * Checkbox is not selected 
 * 
 */
int no_active_items = 0
int no_completed_items = 0
int no_all_items = 0
WebElement Items_2 = driver.findElement(By.xpath("//div//ul[@class='todo-list']"))

WebElement active_filter = driver.findElement(By.xpath("//footer//ul[@class='filters']/li/a[text()='Active']"))
active_filter.click()

 no_active_items += getNumberOfItems(Items_2,Constants.ITEM_TYPE_ACTIVE) 
 println ("NUMBER OF ACTIVE ITEMS : " + no_active_items )


/*
 * li with @class= completed and checkbox = ckecked 
 * 
 */
 
driver.sleep(5000)
WebElement completed_filter = driver.findElement(By.xpath("//footer//ul[@class='filters']/li/a[text()='Completed']"))
completed_filter.click()
no_completed_items += getNumberOfItems(Items_2,Constants.ITEM_TYPE_COMPLETED)
println ("NUMBER OF COMPLETED ITEMS : " + no_completed_items )


driver.sleep(5000)
WebElement all_filter = driver.findElement(By.xpath("//footer//ul[@class='filters']/li/a[text()='All']"))
all_filter.click();

no_all_items += getNumberOfItems(Items_2,Constants.ITEM_TYPE_ALL)
println ("NUMBER OF ALL ITEMS : " + no_all_items )






/*
 * Function with displayed list what can be called when  is nedded 
 */

int getNumberOfItems (WebElement Items, int itemType){
 	List<WebElement> list_items = Items.findElements(By.xpath(".//li"))	
	 
	 int total_no_of_list = list_items.size();
	 // debugging print out 
	 println("total no of displayed items :" + total_no_of_list )
	 
	 int sum = 0;
	 
	 String possible_value=""
	 
	 if (itemType==Constants.ITEM_TYPE_ACTIVE) {
		 possible_value=""
	 }
	 else if (itemType==Constants.ITEM_TYPE_COMPLETED) {
		 possible_value="completed"
	 }
	 else {
		 return list_items.size()
	 }
	 
	 for (int j = 0; j< list_items.size(); j++){
		 
		 String check_cell = list_items.get(j).getAttribute("class")
		 if (check_cell == possible_value)
		 {
			 sum++
		 }
		 
	 }	 
	 
	println("Desired items found : " + sum) 
    return sum
}