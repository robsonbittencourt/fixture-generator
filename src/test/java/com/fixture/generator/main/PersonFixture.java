package com.fixture.generator.main;

import com.fixture.generator.main.Person;
import java.util.List;
import java.util.ArrayList;
public class PersonFixture {

	private Person person = new Person();

	public static PersonFixture get() {
		return new PersonFixture();
	}

	public Person build() {
		return person;
	}

	public List<Person> buildList(Integer amount) {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < amount; i++) {
			persons.add(this.build());
		}
		return persons;
	}

	public PersonFixture comName(String name) {
		this.person.setName(name);
		return this;
	}

	public PersonFixture comAge(int age) {
		this.person.setAge(age);
		return this;
	}
}