package web.test.web_module.webpageclasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.utilities.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("unused")
public class Dashboard_screen extends BaseClass {
	
	public static String primaryInfo  = "{\"user_id\":99,\"executed_user_id\":99,\"is_generate\":false,\"is_execute\":false,\"is_web\":true,\"project_url\":\"http://devrabbitdev.com\",\"report_upload_url\":\"https://smartqe.io:443/UploadReportFile\",\"project_name\":\"test\",\"project_description\":\"desc\",\"project_id\":434,\"module_name\":\"web_module\",\"module_description\":\"desc\",\"sub_module_id\":0,\"module_id\":722,\"testcase_name\":\"TC\",\"testcase_id\":583,\"testset_id\":0,\"executed_timestamp\":-174002627,\"browser_type\":\"chrome\",\"testcase_overwrite\":true,\"client_timezone_id\":\"Asia/Calcutta\"}";

	public static String projectName = "test";
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;
	public static final int datasetsLength = 1;

	public Dashboard_screen(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='tracking_number']")	
	private WebElement	TrackingNumber_408699input;
	public void fillinputTrackingNumber_408699(String varInputValue) {
		waitForExpectedElement(driver, TrackingNumber_408699input);
		TrackingNumber_408699input.sendKeys(varInputValue);
	}

	@FindBy(how = How.XPATH, using = "//textarea[@name='custom_message']")	
	private WebElement	Custom_message_408559textarea;
	public void filltextareaCustom_message_408559(String varInputValue) {
		waitForExpectedElement(driver, Custom_message_408559textarea);
		Custom_message_408559textarea.sendKeys(varInputValue);
	}

}