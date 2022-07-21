package tests;

import com.newtours.pages.FlightDetailsPage;
import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.RegistrationPage;
import model.RegisterUser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTourTest extends TestBase {

    private RegistrationPage registrationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;
    private FlightDetailsPage flightDetailsPage;



    @BeforeMethod
    public void setUp() {
        registrationPage = new RegistrationPage(wd);
        registrationConfirmationPage = new RegistrationConfirmationPage(wd);
        flightDetailsPage = new FlightDetailsPage(wd);
    }

    @Test
    public void testBookingFlights() throws InterruptedException {
        registrationPage.goTo();
        registrationPage.rodoDismiss();
        RegisterUser validUser = new RegisterUser().withFirstName("name").withLastName("lastname").withUserName("validUser").withPassword("pass");
        registrationPage.fillRegisterForm(validUser);
        registrationConfirmationPage.waitForConfirmationUser();
        registrationConfirmationPage.clickFlightsBtn();
        flightDetailsPage.setPassengerNO("2");
        flightDetailsPage.submitFlightDetailsPage();
        flightDetailsPage.clickBackHomeBtn();
    }
}
