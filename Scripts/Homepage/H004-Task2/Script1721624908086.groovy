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

WebUI.callTestCase(findTestCase('Homepage/H001 - Login'), [('username') : username, ('password') : password, ('close') : '0'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('login_page/Page_CURA Healthcare Service/new_dropdown', [('dropdown') : facility]))

WebUI.selectOptionByValue(findTestObject('login_page/Page_CURA Healthcare Service/new_dropdown'), facility, false)

WebUI.verifyOptionPresentByValue(findTestObject('login_page/Page_CURA Healthcare Service/new_dropdown'), facility, false, 
    0)

WebUI.check(findTestObject('login_page/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospital_readmission'))

WebUI.verifyElementChecked(findTestObject('login_page/Page_CURA Healthcare Service/input_Apply for hospital readmission_hospital_readmission'), 
    0)

WebUI.click(findTestObject('login_page/Page_CURA Healthcare Service/radiobutton_Medicare', [('program') : healthcareprogram]))

WebUI.setText(findTestObject('login_page/Page_CURA Healthcare Service/Pilih_visit_date'), visitdate)

WebUI.click(findTestObject('login_page/Page_CURA Healthcare Service/textarea_Comment_comment'))

WebUI.setText(findTestObject('login_page/Page_CURA Healthcare Service/textarea_Comment_comment'), comment)

cekbuttonbookappointment = WebUI.verifyElementPresent(findTestObject('login_page/Page_CURA Healthcare Service/button_Book Appointment'), 
    0, FailureHandling.OPTIONAL)

WebUI.comment(cekbuttonbookappointment.toString())

if (cekbuttonbookappointment == true) {
    WebUI.comment('Present')
} else {
    WebUI.comment('Not Present')
} 

WebUI.click(findTestObject('login_page/Page_CURA Healthcare Service/button_Book Appointment'))

WebUI.verifyElementVisible(findTestObject('login_page/Page_CURA Healthcare Service/h2_Appointment Confirmation'))

URL_Confirmation = WebUI.getUrl()

if (URL_Confirmation.equals('https://katalon-demo-cura.herokuapp.com/appointment.php#summary')) {
    WebUI.verifyMatch('true', 'true', true)
} else {
    WebUI.verifyMatch('false', 'true', false)
}

WebUI.closeBrowser()

