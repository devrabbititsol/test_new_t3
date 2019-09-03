package web.test.web_module.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class Login_screen extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":99,\"executed_user_id\":99,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"http://devrabbitdev.com\",\"report_upload_url\":\"https://smartqe.io:443/UploadReportFile\",\"project_name\":\"test\",\"project_description\":\"desc\",\"project_id\":434,\"module_name\":\"web_module\",\"module_description\":\"desc\",\"sub_module_id\":0,\"module_id\":722,\"testcase_name\":\"TC\",\"testcase_id\":583,\"testset_id\":0,\"executed_timestamp\":-174002627,\"browser_type\":\"chrome\",\"testcase_overwrite\":true,\"client_timezone_id\":\"Asia/Calcutta\"}";

	public static String projectName = "test";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public Login_screen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='username']")	
	private WebElement	Username_408534input;
	public void fillinputUsername_408534(String varInputValue) {
		waitForExpectedElement(driver, Username_408534input);
		Username_408534input.sendKeys(varInputValue);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='password']")	
	private WebElement	Password_408538input;
	public void fillinputPassword_408538(String varInputValue) {
		waitForExpectedElement(driver, Password_408538input);
		Password_408538input.sendKeys(varInputValue);
	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Log in')]")	
	private WebElement	LogIn_408547button;
	public String clkbuttonLogIn_408547() {
		waitForExpectedElement(driver, LogIn_408547button);		
		String text = LogIn_408547button.getText();
		LogIn_408547button.click();
		return text;
	}

}