package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomTestData.*;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(randomFirstName)
                .setLastName(randomLastName)
                .setEmail(randomEmail)
                .setGender(randomGender)
                .setUserPhoneNumber(randomPhoneNumber)
                .setDateOfBirth(randomDay, randomMonth, randomYear)
                .setSubjects(randomSubjects)
                .setHobbiesWrapper(randomHobbies)
                .uploadPicture(randomPicture)
                .setAddress(randomAddress)
                .setState(randomState)
                .setCity(randomCity)
                .submitForm();

        registrationPage.checkResult("Student Name", String.format("%s %s", randomFirstName, randomLastName))
                .checkResult("Student Email", randomEmail)
                .checkResult("Gender", randomGender)
                .checkResult("Mobile", randomPhoneNumber)
                .checkResult("Date of Birth", String.format("%s %s,%s", randomDay, randomMonth, randomYear))
                .checkResult("Subjects", randomSubjects)
                .checkResult("Hobbies", randomHobbies)
                .checkResult("Picture", randomPicture)
                .checkResult("Address", randomAddress)
                .checkResult("State and City", String.format("%s %s", randomState, randomCity));
    }
}