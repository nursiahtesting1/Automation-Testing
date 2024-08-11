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

WebUI.callTestCase(findTestCase('Login/L001-Login Positif'), [('username') : username, ('password') : password, ('close') : '0'], 
    FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Login/Click Product - Sauce Labs Backpack'), 0)

Mobile.scrollToText('ADD TO CART', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Login/Button - ADD TO CART'), 0)

Mobile.tap(findTestObject('Login/CartTerisi - 1'), 0)

Mobile.tap(findTestObject('Login/Button - CHECKOUT'), 0)

Mobile.setText(findTestObject('Login/Input- First Name'), firstname, 0)

Mobile.setText(findTestObject('Login/Input - Last Name'), lastname, 0)

Mobile.setText(findTestObject('Login/Input - ZipPostal Code'), zippostalcode, 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Login/Button - CONTINUE'), 0)

Mobile.scrollToText('FINISH', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Login/Button - FINISH'), 0)

Mobile.verifyElementVisible(findTestObject('Login/Label - CHECKOUT COMPLETE'), 0)

Mobile.verifyElementVisible(findTestObject('Login/Wording- THANK YOU FOR YOU ORDER'), 0)

Mobile.closeApplication()

