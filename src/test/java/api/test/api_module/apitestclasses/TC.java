package api.test.api_module.apitestclasses;

import com.restassured.services.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;import com.utilities.BaseClass;
import com.utilities.ConfigFilesUtility;
import com.configurations.*;
import api.test.api_module.apipageclasses.GetDataset;
public class TC extends BaseClass {
	ExtentReports reports;
	ExtentTest test;
	ITestResult result;
	private Logger logger;
	private ConfigFilesUtility configFileObj;
	String projectPath = System.getProperty("user.dir");
	String reportsPath = projectPath + "/APIReports/" + ReportPaths.reportPathName;

	public TC() throws Exception {
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(TC.class);
		configFileObj= new ConfigFilesUtility();
		configFileObj.loadPropertyFile("apiconfig.properties");
	}

	@Test(priority = 1)
	public void doRequest() throws Exception { 

		String primaryInfo = GetDataset.primaryInfo;
		Constants.PRIMARY_INFO = primaryInfo;
		reports = ExtentConfigurations.getExtentInstance(reportsPath, projectPath ,GetDataset.projectName);
		test = reports.startTest("Verifying TC API");
		int datasetLength = GetDataset.datasetLength; 
		for(int i = 1; i <= datasetLength; i++) {

			boolean isExecutionFlag = true;			
		/*--------------------- GET --------------------- */

			if(isExecutionFlag) {
 			 	Object object = (Object) new GetDataset();
				Class<?> c = object.getClass();
				String urlParams = (String) c.getField("urlParams" + i).get(object);
				if(urlParams == null) return;
				String headers = (String) c.getField("headers" + i).get(object);
				String body = (String) c.getField("body" + i).get(object);
				String datasetHeader = (String) c.getField("datasetHeader" + i).get(object);
				String datasetResources = (String) c.getField("datasetResources" + i).get(object);
				int reqType = (Integer) c.getField("requestType" + i).get(object);
				int bodyType = (Integer) c.getField("bodyType" + i).get(object);
			 	Constants.testName = Constants.testName + datasetHeader;
				String response = APIService.callRequest(primaryInfo, urlParams, headers, reqType, bodyType, body, datasetHeader, datasetResources, test, logger);
			}
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		reports.endTest(test);
		reports.flush();
	}
}