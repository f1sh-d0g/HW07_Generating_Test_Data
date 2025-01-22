package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomTestData;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomTestData rtd = new RandomTestData();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(rtd.randomFirstName)
                .setLastName(rtd.randomLastName)
                .setEmail(rtd.randomEmail)
                .setGender(rtd.randomGender)
                .setUserPhoneNumber(rtd.randomPhoneNumber)
                .setDateOfBirth(rtd.randomDay, rtd.randomMonth, rtd.randomYear)
                .setSubjects(rtd.randomSubjects)
                .setHobbiesWrapper(rtd.randomHobbies)
                .uploadPicture(rtd.randomPicture)
                .setAddress(rtd.randomAddress)
                .setState(rtd.randomState)
                .setCity(rtd.randomCity)
                .submitForm();

        registrationPage.checkResult("Student Name", String.format("%s %s", rtd.randomFirstName, rtd.randomLastName))
                .checkResult("Student Email", rtd.randomEmail)
                .checkResult("Gender", rtd.randomGender)
                .checkResult("Mobile", rtd.randomPhoneNumber)
                .checkResult("Date of Birth", String.format("%s %s,%s", rtd.randomDay, rtd.randomMonth, rtd.randomYear))
                .checkResult("Subjects", rtd.randomSubjects)
                .checkResult("Hobbies", rtd.randomHobbies)
                .checkResult("Picture", rtd.randomPicture)
                .checkResult("Address", rtd.randomAddress)
                .checkResult("State and City", String.format("%s %s", rtd.randomState, rtd.randomCity));
    }
}