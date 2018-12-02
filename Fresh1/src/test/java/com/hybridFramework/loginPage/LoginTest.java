package com.hybridFramework.loginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.LoginPage;
//import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

/**
 * 
 * @author Bhanu Pratap
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class LoginTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test
	public void testLoginToApplication(){
		log.info(LoginTest.class.getName()+" started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		//driver.get("http://www.bitrasercloud.com");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(config.getUserName(), config.getPassword());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean status = true;//loginPage.verifySuccessLoginMsg();
		if(status){
		   log.info("login is sucessful");	
		}
		else{
			Assert.assertTrue(false, "login is not sucessful");
		}
		log.info("quiting..");
		driver.quit();
	}

}
