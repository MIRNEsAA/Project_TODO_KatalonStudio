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

WebElement Table_after = driver.findElement(By.xpath("//div//ul[@class='todo-list']"))
List < WebElement > rows_table_after = Table_after.findElements(By.tagName('li'))
int rows_count_after = rows_table_after.size()
// Print out for debuging 
println(" Number of inserted items are :" + rows_count_after)



WebElement given_value= driver.findElement(By.xpath("//footer/span[@class='todo-count']"))
String given_value_text_1 = given_value.getText()
println("GIVEN VALUE TEXT BEFORE " + given_value_text_1)

String Expected_text = "No items left"
//driver.findElement(By.xpath("//label[text()='LABEL TEXT']/../input")).click();
WebElement select_all = driver.findElement(By.xpath("//input[@class='toggle-all']/../label"))
select_all.click();

String given_value_text_2 = given_value.getText()
println("GIVEN VALUE TEXT AFTER" + given_value_text_2)


