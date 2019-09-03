package web.test.web_module.webtestclasses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.configurations.Constants;
import com.configurations.ExtentConfigurations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import web.test.web_module.webpageclasses.Login_screen;
import web.test.web_module.webpageclasses.Dashboard_screen;
import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.utilities.Utilities;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class TC extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	ITestResult result;
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	private String browserName = "chrome";
	public boolean isElementDispalyed = false;
	public static final int datasetsLength = 1;

	public TC() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC.class);
		configFileObj = new ConfigFilesUtility();
		configFileObj.loadPropertyFile("tc.properties");
	}

	@BeforeTest
	@Parameters("browser")
	public void browserName(String browser) throws Exception {
		browserName = browser;
		reports = ExtentConfigurations.getExtentInstance(reportsPath, projectPath, Login_screen.projectName);
		test = reports.startTest(setTestcaseName(browserName, "TC"));
	}

	
	public void setUP() throws Exception {
		String primaryInfo = Login_screen.primaryInfo;
		Constants.PRIMARY_INFO = primaryInfo;
		driver = launchBrowser(browserName, configFileObj);
		printSuccessLogAndReport(test, logger, "Browser Name : " + browserName);
	}

	public void Login_screenTest(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 1;
		Login_screen objLogin_screen = PageFactory.initElements(driver, Login_screen.class);
		testLogHeader(test, "Verify Login_screen page");
		objLogin_screen.fillinputUsername_408534(configFileObj.getProperty("Username"+ i + datasetScreencount));
		printSuccessLogAndReport(test, logger,  "Entered Username : " + configFileObj.getProperty("Username"+ i + datasetScreencount));
		objLogin_screen.fillinputPassword_408538(configFileObj.getProperty("Password"+ i + datasetScreencount));
		printSuccessLogAndReport(test, logger,  "Entered Password : " + configFileObj.getProperty("Password"+ i + datasetScreencount));
	String text3 = objLogin_screen.clkbuttonLogIn_408547();
		if(text3.equalsIgnoreCase(configFileObj.getProperty("LogIn"+ i + datasetScreencount))){
			printSuccessLogAndReport(test, logger,  "Clicked on Button : " + configFileObj.getProperty("LogIn"+ i + datasetScreencount));
			printSuccessLogAndReport(test, logger,  "Validated Button Text : " + configFileObj.getProperty("LogIn"+ i + datasetScreencount));
		} else {
			printFailureLogAndReport(test, logger,  "Text is displayed as : " + configFileObj.getProperty("LogIn"+ i + datasetScreencount));
		}

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	

	public void Dashboard_screenTest(int i) throws Exception {

	 try{
		Constants.TOTAL_TC = Constants.TOTAL_TC + 1;
		Constants.IS_TESTCASE = true; Constants.iS_WEB = true;
		int datasetScreencount = 2;
		Dashboard_screen objDashboard_screen = PageFactory.initElements(driver, Dashboard_screen.class);
		testLogHeader(test, "Verify Dashboard_screen page");
		objDashboard_screen.fillinputTrackingNumber_408699(configFileObj.getProperty("TrackingNumber"+ i + datasetScreencount));
		printSuccessLogAndReport(test, logger,  "Entered TrackingNumber : " + configFileObj.getProperty("TrackingNumber"+ i + datasetScreencount));
		objDashboard_screen.filltextareaCustom_message_408559(configFileObj.getProperty("Custom_message"+ i + datasetScreencount));
		printSuccessLogAndReport(test, logger,  "Entered Custom_message : " + configFileObj.getProperty("Custom_message"+ i + datasetScreencount));

	   } catch (Exception e) {
		  isElementDispalyed = false;
		  printFailureLogAndReport(test, logger,  "Element is not found" + e.getLocalizedMessage());
		}
	}
	
	@Test
	public void screensTest() throws Exception {
		for(int datasets = 1; datasets <= Dashboard_screen.datasetsLength; datasets++) {
			isElementDispalyed = true;			
			setUP();
			if(isElementDispalyed) { Login_screenTest(datasets);}
			if(isElementDispalyed) { Dashboard_screenTest(datasets);}
			tearDown();
		}	}

	
	public void tearDown() throws Exception {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
}