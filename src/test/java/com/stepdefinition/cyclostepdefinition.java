package com.stepdefinition;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class cyclostepdefinition {
	public static WebDriver driver;
	public static String name="Active Walking";
	public static String exp="The payment request was successfully sent";
	public static String sub1="Pay the due before this month";
	
	@Given("launch the url")
	public void launch_the_url() {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
	driver=new ChromeDriver(options);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://demo.cyclos.org/ui/home");
		}
	@When("I enter the username and password")
	public void i_enter_the_username_and_password() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("login-link")).click();
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='User']"));
		username.sendKeys("demo");
		WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		pass.sendKeys("1234");
		
	   
	}
	@When("click the submit button and selecting contact option")
	public void click_the_submit_button_and_selecting_contact_option() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(text(),' Quick access ')]//parent::div//following-sibling::div//descendant::div[contains(text(),' Directory ')]//parent::a//parent::div//following-sibling::div)[2]//child::div//following-sibling::div")).click();
	 
	}
	


@When("I select the Active Walking from the contact list")
public void i_select_the_active_walking_from_the_contact_list() {
	
   
		driver.findElement(By.xpath("//div[contains(text(),' Contact list ')]//ancestor::page-content//following-sibling::users-results//descendant::format-field-value[text()=' Active Walking ']")).click();
	}
	@When("Requesting for payment in the options")
	public void requesting_for_payment_in_the_options() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='actions-toolbar-container']//heading-actions//div//heading-action-button[3]/preceding-sibling::heading-action-button[1]//descendant::div")).click();
		Thread.sleep(3000);
		
	}
	

@When("enter the requested amount, requested date and also select payment method")
public void enter_the_requested_amount_requested_date_and_also_select_payment_method() {
	WebElement amount = driver.findElement(By.xpath("//div[@class='input-group']/input"));
	amount.sendKeys("20");
	WebElement date = driver.findElement(By.xpath("//div[@class='d-flex label-value-value']/input"));
	date.click();
	date.sendKeys("15-04-2023");
}
@When("enter the description and confirm")
public void enter_the_description_and_confirm() throws InterruptedException {
	WebElement des = driver.findElement(By.xpath("//div[@class='d-flex label-value-value']/textarea"));
	des.click();
	des.sendKeys("Make the payment ontime");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Confirm']")).click();
	
	

}
@Then("check whether request has been created successfully")
public void check_whether_request_has_been_created_successfully() {
	
	driver.findElement(By.xpath("(//action-button[@class='d-inline-block button']//span[text()='Confirm'])[2]")).click();
	
	WebElement findElement = driver.findElement(By.xpath("//div[contains(text(),'successfully')]"));
	String act = findElement.getText();
	assertEquals(exp, act);
	driver.close();
}


@When("I select the references from the options")
public void i_select_the_references_from_the_options() throws InterruptedException {
	
	driver.findElement(By.xpath("//div[contains(text(),' Contact list ')]//ancestor::page-content//following-sibling::users-results//descendant::format-field-value[text()=' Active Walking ']")).click();
	driver.findElement(By.xpath("//div[@class='heading-actions-plain-buttons']//descendant::div[contains(text(),'References')]")).click();
}
@When("by Clicking the Set reference")
public void by_clicking_the_set_reference() {
	driver.findElement(By.xpath("//div[contains(text(),'Set reference')]")).click();

}
@When("selecting very good from the options and adding the comments")
public void selecting_very_good_from_the_options_and_adding_the_comments() {
	driver.findElement(By.xpath("//div[@class='d-flex label-value-value']//child::div//child::button")).click();
	List<WebElement> list = driver.findElements(By.xpath("//div[@role='listbox']/a"));
	for (WebElement webElement : list) {
		System.out.println(webElement.getText());
		String text = webElement.getText();
		if(text.equalsIgnoreCase("Bad")){
			webElement.click();
			break;
		}
		
	}
	WebElement des = driver.findElement(By.tagName("textarea"));
	des.click();
	des.clear();
	des.sendKeys("very poor");
  
}
@Then("click on the submit button")
public void click_on_the_submit_button() {
	driver.findElement(By.xpath("//button/span[contains(text(),'Submit')]")).click();
	WebElement findElement = driver.findElement(By.xpath("(//table//tbody//tr//td//span[contains(text(),'Bad')]//parent::rating-stats//parent::td//following-sibling::td//div//child::span)[1]"));
	String text = findElement.getText();
	int parseInt = Integer.parseInt(text);
	assertEquals(parseInt, 1);
	driver.close();
  
}

@When("I select the Active Walking from Contacts")
public void i_select_the_active_walking_from_contacts() {
	driver.findElement(By.xpath("//div[contains(text(),' Contact list ')]//ancestor::page-content//following-sibling::users-results//descendant::format-field-value[text()=' Active Walking ']")).click();
}
@When("Click on the send message option")
public void click_on_the_send_message_option() {
	driver.findElement(By.xpath("//div[contains(text(),'Send message')]")).click();
    
}
@When("enter The Subject and select the font as Monospace and Bold")
public void enter_the_subject_and_select_the_font_as_monospace_and_bold() {
	WebElement subject = driver.findElement(By.xpath("//div[@class='d-flex label-value-value']/input"));
	subject.click();
	subject.sendKeys(sub1);
	WebElement font = driver.findElement(By.xpath("(//div[@class='toolbar-group']//select)[2]"));
	Select s= new Select(font);
	s.selectByIndex(2);
	driver.findElement(By.xpath("(//button[@class='btn btn-icon'])[3]")).click();

}
@When("enter the Message")
public void enter_the_message() {
	WebElement content = driver.findElement(By.xpath("//div[@class='editor']"));
	content.click();
	content.sendKeys("Hi your payment is pending over a long period kindly make payment as soon as possible");
 
}
@Then("click on the send button")
public void click_on_the_send_button() {
	driver.findElement(By.xpath("//button//span[contains(text(),'Send')]")).click();
    driver.findElement(By.xpath("(//icon-with-counter/icon)[1]")).click();
    driver.findElement(By.xpath("//label[contains(text(),'Sent')]")).click();
    WebElement sub = driver.findElement(By.xpath("//table//tbody//tr[1]/td[3]"));
    String check = sub.getText();
    WebElement recname = driver.findElement(By.xpath("//table//tbody//tr[1]/td[2]/span"));
    String recepientname = recname.getText();
    if(recepientname.equalsIgnoreCase(name)) {
    	assertEquals(check,sub1);
    }
    driver.close();
}


@When("I select the Active walking from contacts and select Make payment option")
public void i_select_the_active_walking_from_contacts_and_select_make_payment_option() {
	driver.findElement(By.xpath("//div[contains(text(),' Contact list ')]//ancestor::page-content//following-sibling::users-results//descendant::format-field-value[text()=' Active Walking ']")).click();
	driver.findElement(By.xpath("//div[contains(text(),'Make payment')]")).click();
}
@When("enter The Amount to be sent and also schedule the payment as now")
public void enter_the_amount_to_be_sent_and_also_schedule_the_payment_as_now() {
	WebElement amount = driver.findElement(By.xpath("//div[@class='input-group']/input"));
	amount.click();
	amount.sendKeys("10/n");

}
@When("enter The Description message and click on the next button and cofirm the same")
public void enter_the_description_message_and_click_on_the_next_button_and_cofirm_the_same() {
	WebElement des = driver.findElement(By.tagName("textarea"));
	des.sendKeys("made the payment for the month feb kindly check");
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();

}
@Then("check whether payment is done or exceeded the payment limit")
public void check_whether_payment_is_done_or_exceeded_the_payment_limit() {
	WebElement mess = driver.findElement(By.xpath("(//div[@class=\"d-flex flex-column flex-xs-row align-items-center\"]//div)[2]"));
	String text = mess.getText();
	if(text.contains("success")) {
		assertEquals(text, "payment success");
	}
		
	
	else {
		System.out.println("maximum limit exceeds");
  
}
	driver.close();
}
@When("I select the Active Walking from the contacts")
public void i_select_the_active_walking_from_the_contacts() {
	driver.findElement(By.xpath("//div[contains(text(),' Contact list ')]//ancestor::page-content//following-sibling::users-results//descendant::format-field-value[text()=' Active Walking ']")).click();
}
@When("select Remove from the Contacts option")
public void select_remove_from_the_contacts_option() {
	driver.findElement(By.xpath("//div[contains(text(),'Remove from contacts')]")).click();

}
@Then("go back to Contacts and check whether the contact has been removed")
public void go_back_to_contacts_and_check_whether_the_contact_has_been_removed() {
	driver.findElement(By.xpath("//div[@class='side-area']//descendant::nav//a//div[contains(text(),'Contacts')]")).click();
	List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='row tiled-results']//descendant::div[@class='card-title']"));
	for (WebElement webElement : findElements) {
		String text = webElement.getText();
		assertNotEquals(text,"Active Walking");
		
	}
	driver.close();
}
}