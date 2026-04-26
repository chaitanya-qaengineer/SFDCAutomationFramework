package tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Listeners.TestListener;
import Pages.CreateAccountPage;
import Pages.LoginPage;
import utils.CommonUtils;
import utils.DataUtils;
import utils.FileHandlingMethods;

@Listeners(TestListener.class)

public class CreateAccountTest extends BaseTest {

	@BeforeMethod
	public void preConditions(Method name) {
		System.out.println("Pre condition - Launching browser for: " + name.getName());
		BaseTest.setDriver("chrome", false);
	}

	@AfterMethod
	public void postConditions() {
		System.out.println("Post condition - Closing browser");
		BaseTest.getDriver().close();
	}

	// ============================================================
	// SMOKE TESTS - Core account creation functionality
	// ============================================================

	@Test(groups = { "smoke", "regression" }, description = "Verify new account can be created successfully")
	public void createAccountTC_10() throws IOException {

		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		CreateAccountPage ap = new CreateAccountPage(driver);

		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().window().maximize();
		test.log(Status.INFO, "SFDC Login page is opened");

		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		test.log(Status.INFO, "Entered valid username");

		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		test.log(Status.INFO, "Entered valid password");

		lp.loginButton.click();
		test.log(Status.INFO, "Clicked Login button");

		ap.allTabs();
		ap.accountTab();
		ap.selectNewContact(driver);
		test.log(Status.INFO, "Navigated to Create Account page");

		Assert.assertTrue(
				ap.isAccountNameDisplayed(driver,
						FileHandlingMethods.readAccountTestData("account.name"),
						FileHandlingMethods.readAccountTestData("account.type"),
						FileHandlingMethods.readAccountTestData("account.priority")),
				"Newly created account should be displayed in the list");
	}

	// ============================================================
	// REGRESSION TESTS - Account views and management
	// ============================================================

	@Test(groups = { "regression" }, description = "Verify new account list view can be created")
	public void accountsTest_TC11(Method name) throws IOException {

		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		CreateAccountPage ap = new CreateAccountPage(driver);

		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().window().maximize();
		test.log(Status.INFO, "SFDC Login page is opened");

		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		test.log(Status.INFO, "Entered username");

		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		test.log(Status.INFO, "Entered password");

		lp.loginButton.click();
		test.log(Status.INFO, "Clicked Login button");

		ap.allTabs();
		CommonUtils.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		ap.createNewViewAccount(driver);
		test.log(Status.INFO, "Created new account view");

		Assert.assertTrue(
				ap.isViewAccountDisplayed(driver,
						FileHandlingMethods.readAccountTestData("view.name"),
						FileHandlingMethods.readAccountTestData("view.uniquename")),
				"New account view should be displayed");
	}

	@Test(groups = { "regression" }, description = "Verify account list view can be edited with filters")
	public void accountsTest_TC12(Method name) throws IOException {

		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		CreateAccountPage ap = new CreateAccountPage(driver);

		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().window().maximize();
		test.log(Status.INFO, "SFDC Login page is opened");

		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		test.log(Status.INFO, "Entered username");

		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		test.log(Status.INFO, "Entered password");

		lp.loginButton.click();
		test.log(Status.INFO, "Clicked Login button");

		ap.allTabs();
		CommonUtils.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		test.log(Status.INFO, "Navigated to Accounts tab");

		Assert.assertTrue(
				ap.isEditViewAccountDisplayed(driver,
						FileHandlingMethods.readAccountTestData("selectview.name"),
						FileHandlingMethods.readAccountTestData("edit.name"),
						FileHandlingMethods.readAccountTestData("filter.Field"),
						FileHandlingMethods.readAccountTestData("filter.Operator"),
						FileHandlingMethods.readAccountTestData("filter.Value")),
				"Edited account view should be displayed with correct filters");
	}

	@Test(groups = { "regression" }, description = "Verify accounts can be merged successfully")
	public void accountsTest_TC13(Method name) throws IOException {

		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		CreateAccountPage ap = new CreateAccountPage(driver);

		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().window().maximize();
		test.log(Status.INFO, "SFDC Login page is opened");

		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		test.log(Status.INFO, "Entered username");

		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		test.log(Status.INFO, "Entered password");

		lp.loginButton.click();
		test.log(Status.INFO, "Clicked Login button");

		ap.allTabs();
		CommonUtils.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		test.log(Status.INFO, "Navigated to Accounts tab");

		Assert.assertTrue(
				ap.isMergeAccountsDisplayed(driver,
						FileHandlingMethods.readAccountTestData("merge.accountname")),
				"Merge Accounts page should be displayed");
	}

	@Test(groups = { "regression" }, description = "Verify account activity report can be created")
	public void accountsTest_TC14(Method name) throws IOException {

		ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		CreateAccountPage ap = new CreateAccountPage(driver);

		driver.get(DataUtils.readLoginTestData("app.url"));
		driver.manage().window().maximize();
		test.log(Status.INFO, "SFDC Login page is opened");

		lp.username.sendKeys(DataUtils.readLoginTestData("valid.username"));
		test.log(Status.INFO, "Entered username");

		lp.password.sendKeys(DataUtils.readLoginTestData("valid.password"));
		test.log(Status.INFO, "Entered password");

		lp.loginButton.click();
		test.log(Status.INFO, "Clicked Login button");

		ap.allTabs();
		CommonUtils.waitForElement(driver, ap.AllTabs);
		ap.accountTab();
		test.log(Status.INFO, "Navigated to Accounts tab");

		Assert.assertTrue(
				ap.isReportDisplayed(driver,
						FileHandlingMethods.readAccountTestData("report.date"),
						FileHandlingMethods.readAccountTestData("report.name"),
						FileHandlingMethods.readAccountTestData("report.uniquename")),
				"Account report should be displayed with correct details");
	}
}


