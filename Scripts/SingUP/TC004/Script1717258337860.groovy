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
import java.util.Random as Random

// Fungsi untuk menghasilkan string acak dengan panjang tertentu
// Menghasilkan username dan password acak

String randomUsername = generateRandomString(8)

//String randomPassword = generateRandomString(8)

WebUI.openBrowser(GlobalVariable.BaseUrl)

WebUI.waitForElementVisible(findTestObject('home/Sigin/signin'), 0)

WebUI.click(findTestObject('home/Sigin/signin'))

WebUI.verifyElementText(findTestObject('home/Sigin/Wording signin'), GlobalVariable.wordingSingUp)

WebUI.sendKeys(findTestObject('home/Sigin/signin - username'), randomUsername)

//WebUI.sendKeys(findTestObject('home/Sigin/signin - pass'), randomPassword)

WebUI.click(findTestObject('home/Sigin/signin - btn save'))

if (WebUI.waitForAlert(2)) {

    // Verifikasi teks alert sesuai dengan yang diharapkan
    WebUI.verifyMatch(WebUI.getAlertText(), GlobalVariable.ValidateUserandPass, false)

    // Terima alert untuk menutupnya
    WebUI.acceptAlert()
} else {
    println('No alert found.')
}

WebUI.closeBrowser()

def generateRandomString(int length) {
    String chars = (('a'..'z').join() + ('A'..'Z').join()) + ('0'..'9').join()

    new Random().with({ 
            (1..length).collect({ 
                    chars[nextInt(chars.length())]
                }).join()
        })
}

