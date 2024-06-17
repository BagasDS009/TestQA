import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.BaseUrl)

WebUI.waitForElementVisible(findTestObject('home/Login/login'), 0)

WebUI.click(findTestObject('home/Login/login'))

WebUI.verifyElementText(findTestObject('home/Login/Wording login'), GlobalVariable.wordinglogin)

WebUI.sendKeys(findTestObject('home/Login/login - username'), '123')

WebUI.sendKeys(findTestObject('home/Login/login - pass'), '123')

WebUI.click(findTestObject('home/Login/login - btn'))

WebUI.delay(2)

if (WebUI.verifyElementVisible(findTestObject('home/Login/Wording Berhasi Login welcom'))) {
    // Verifikasi teks alert sesuai dengan yang diharapkan
    WebUI.verifyMatch(WebUI.getText(findTestObject('home/Login/Wording Berhasi Login welcom')), GlobalVariable.verivikasiLogin, 
        false)
} else {
    println('No alert found.')
}

WebUI.verifyElementText(findTestObject('home/Kategori/Wording Kategori'), GlobalVariable.CATEGORIES)

//verify telpon
WebUI.verifyElementText(findTestObject('home/Kategori/Wording Kategori - phone'), GlobalVariable.Phones)

WebUI.click(findTestObject('home/Kategori/Wording Kategori - phone'))

WebUI.verifyElementText(findTestObject('home/Item on home/Wording item name - Copy'), GlobalVariable.titelItem)

WebUI.verifyElementText(findTestObject('home/Item on home/Wording price - Copy'), GlobalVariable.price)

//verify laptop
WebUI.verifyElementText(findTestObject('home/Kategori/Wording Kategori - Laptops'), GlobalVariable.Laptops)

WebUI.click(findTestObject('home/Kategori/Wording Kategori - Laptops'))

WebUI.verifyElementText(findTestObject('home/Item on home/Wording item name - Copy - Laptops'), GlobalVariable.itemLaptop)

WebUI.verifyElementText(findTestObject('home/Item on home/Wording price - Copy - Laptops'), GlobalVariable.priceLaptop)

//verify Monitor
WebUI.verifyElementText(findTestObject('home/Kategori/Wording Kategori - Monitor'), GlobalVariable.Monitors)

WebUI.click(findTestObject('home/Kategori/Wording Kategori - Monitor'))

WebUI.verifyElementText(findTestObject('home/Item on home/Wording item name - Copy - Monitors'), GlobalVariable.itemMonitor)

WebUI.verifyElementText(findTestObject('home/Item on home/Wording price - Copy - Monitors'), GlobalVariable.priceMonitor)

WebUI.closeBrowser()

