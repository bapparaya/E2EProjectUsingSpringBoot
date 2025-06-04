package com.orangehrmdemo.springorangehrmdemo;

import com.orangehrmdemo.springorangehrmdemo.pages.EmloyeeList;
import com.orangehrmdemo.springorangehrmdemo.pages.HomePage;
import com.orangehrmdemo.springorangehrmdemo.pages.LoginPage;
import com.orangehrmdemo.springorangehrmdemo.pages.PIMPage;
import com.orangehrmdemo.utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

@SpringBootTest
@ActiveProfiles("prod")
//@Import(WebdriverCnfig.class)
public class TesNGTest extends AbstractTestNGSpringContextTests {

	@Autowired
	WebDriver driver;

	@Autowired
	LoginPage loginPage;

	@Autowired
	HomePage homePage;

	@Autowired
	PIMPage pimpage;

	@Autowired
	EmloyeeList emplist;

	@Test
	void contextLoads() {
		System.out.println("welcome!");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//LoginPage loginPage = new LoginPage(driver);
		loginPage.verifylogin("Admin","admin123");
		homePage.clickonPIM();
		List<String> random = Utilities.genaraterandom();
		pimpage.addEmployee(random.get(0),random.get(1),random.get(2));

	}

}
