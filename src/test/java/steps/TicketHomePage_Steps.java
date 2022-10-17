package steps;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages_actions.TicketHomePage_Actions;

public class TicketHomePage_Steps {

	TicketHomePage_Actions ticketHomePage_Actions;
	// TicketHome_Elements ticketHome_Elements;

	public TicketHomePage_Steps(TicketHomePage_Actions ticketHomePage_Actions) {

		this.ticketHomePage_Actions = ticketHomePage_Actions;
		// this.ticketHome_Elements = ticketHome_Elements;
	}

	@Given("I am on home page")
	public void i_am_on_home_page() throws InterruptedException {

		ticketHomePage_Actions.gotothelandingpage();
		Thread.sleep(3000);
	}

	@When("I click on the login link")
	public void i_click_on_the_login_link() throws InterruptedException {

		ticketHomePage_Actions.clickonloginlink();

	}

	@When("I entered the valid {string} and {string} and clicked on the login button")
	public void i_entered_the_valid_and_and_clicked_on_the_login_button(String username, String password,
			DataTable dataTable) throws InterruptedException {

		username = dataTable.cell(0, 0);
		password = dataTable.cell(0, 1);

		ticketHomePage_Actions.login(username, password);

	}

	@Then("I validate the {string} on home page")
	public void i_validated_the_on_home_page(String msg, DataTable dataTable) throws InterruptedException {

		msg = dataTable.cell(0, 0);
		String expectedmsg = ticketHomePage_Actions.gettextafterlogin();
		if (msg.equalsIgnoreCase(expectedmsg)) {
			Assert.fail("User not logged in successfully");
		}

	}

	@When("I entered the invalid {string} and {string} and clicked on the login button")
	public void i_entered_the_invalid_and_and_clicked_on_the_login_button(String username, String password)
			throws InterruptedException {

		ticketHomePage_Actions.login(username, password);

	}

	@Then("I validate the {string} or {string} on screen")
	public void i_validate_the_on_screen(String error, String error1) {
		String expectedmsg = ticketHomePage_Actions.gettextforinvalidlogin();

		error = error.trim().toLowerCase();
		error1 = error1.trim().toLowerCase();

		System.out.println(error + " " + error1);
		// expectedmsg = expectedmsg.trim().toLowerCase();

		// expectedmsg2 = expectedmsg2.trim().toLowerCase();
		if (expectedmsg.length() < 35) {
			if (!expectedmsg.equalsIgnoreCase(error)) {
				Assert.fail("Invalid user validation message is not displayed");
			}
		}
		else {
			if (!expectedmsg.contains(error1)) {
				Assert.fail("Invalid user validation message is not displayed");
			}
		}

	}

}
