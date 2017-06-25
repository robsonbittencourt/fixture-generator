# utility-generator [![Build Status](https://travis-ci.org/robsonbittencourt/utility-generator.svg?branch=master)](https://travis-ci.org/robsonbittencourt/fixture-generator)
Generate utility class to use in your project

## Generate Jar File

To generate this project as a jar file you need to run a maven command with these parameters:
- clean compile assembly:single

## Usage

## To use the Fixture Generator Method
- The default method prefix is `with` but you can use any word.
- The default root path is `src/test/java/`, also you can use any path.

### Example:

Person:
```
class Person {
String name;
int age;
//getters and setters
}
```
You Generator class:
```
FixtureConfiguration config = new FixtureConfiguration();
config.setMethodPrefix("com");
config.setRootPath(loader.getAbsolutePath() + config.getRootPath());
ClassGenerator classGenerator = new ClassGenerator(config);
classGenerator.generateFixture(Person.class);
```
Expected Output:
```
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
```
## To use the Mapper Test Generator Method
- You must specify a `Class Name Suffix`
- You must specify a `Method Name` that will be used in your test method
- You must set your `TypeClass` and `EntityClass`, they are required in any mapper.

### Example:
