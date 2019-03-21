package se.com.common;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataMock {

	Faker faker = new Faker();
	
    public final String firstName = faker.firstName();
    public final String lastName = faker.lastName();
    public final String fullName = faker.name();
    public final String address = faker.streetAddress(true);
    


    
	
}
