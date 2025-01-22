package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomTestData {
    Faker faker = new Faker(new Locale("en"));

    public String randomFirstName = getRandomName(),
            randomLastName = getRandomLastName(),
            randomEmail = getRandomEmail(),
            randomGender = getRandomGender(),
            randomPhoneNumber = getRandomPhoneNumber(),
            randomYear = getRandomYear(),
            randomMonth = getRandomMonth(),
            randomDay = getRandomDay(),
            randomSubjects = getRandomSubjects(),
            randomHobbies = getRandomHobbies(),
            randomPicture = getRandomPicture(),
            randomAddress = getRandomAddress(),
            randomState = getRandomState(),
            randomCity = getRandomCity(randomState);

    private String getRandomName() {
        return faker.name().firstName();
    }

    private String getRandomLastName() {
        return faker.name().lastName();
    }

    private String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    private String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    private String getRandomPhoneNumber() {
        return faker.number().digits(10);
    }

    private String getRandomYear() {
        return String.format("%s", faker.number().numberBetween(1900, 2023));
    }

    private String getRandomMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    }

    private String getRandomDay() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    private String getRandomHobbies() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    private String getRandomSubjects() {
        return faker.options().option("Maths", "Art", "Accounting", "Physics", "Chemistry", "Economics", "English",
                "Biology", "History", "Civics", "Computer Science", "Social Studies", "Hindi", "Commerce");
    }

    private String getRandomPicture() {
        return faker.options().option("rr.jpg", "brain.jpg");
    }

    private String getRandomAddress() {
        return faker.address().fullAddress();
    }

    private String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public String getRandomCity(String state) {

        return switch (state) {
            case "NCR" -> randomCity = faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> randomCity = faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> randomCity = faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> randomCity = faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}