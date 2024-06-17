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

String randomName = getRandomName()

String randomText = getRandomSentence()

String randomEmail = getRandomEmail()

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

WebUI.click(findTestObject('home/Kontak/kontak'))

WebUI.sendKeys(findTestObject('home/Kontak/kontak - email'), randomEmail)

WebUI.sendKeys(findTestObject('home/Kontak/kontak - name'), randomName)

WebUI.sendKeys(findTestObject('home/Kontak/kontak - pesan'), randomText)

WebUI.click(findTestObject('home/Kontak/kontak - btn')) 

WebUI.delay(1)

if (WebUI.waitForAlert(1)) {
	
		// Verifikasi teks alert sesuai dengan yang diharapkan
		WebUI.verifyMatch(WebUI.getAlertText(), GlobalVariable.textThanks, false)
	
		// Terima alert untuk menutupnya
		WebUI.acceptAlert()
}else {
    println('No alert found.')
}

WebUI.closeBrowser()

def getRandomString(int length) {
    String chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'

    Random rand = new Random()

    StringBuilder sb = new StringBuilder()

    for (int i = 0; i < length; i++) {
        sb.append(chars.charAt(rand.nextInt(chars.length())))
    }
    
    return sb.toString()
}

def getRandomEmail() {
    String randomString = getRandomString(10)

    return randomString + '@example.com'
}

def getRandomName() {
    return getRandomString(8)
}

def getRandomSentence() {
    String[] words = ['the', 'quick', 'brown', 'fox', 'jumps', 'over', 'lazy', 'dog']

    Random rand = new Random()

    StringBuilder sentence = new StringBuilder()

    for (int i = 0; i < 10; i++) {
        sentence.append(words[rand.nextInt(words.length)]).append(' ')
    }
    
    return sentence.toString().trim()
}

