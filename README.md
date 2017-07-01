# utility-generator  
[![Build Status](https://travis-ci.org/robsonbittencourt/utility-generator.svg?branch=master)](https://travis-ci.org/robsonbittencourt/utility-generator) [![Quality Gate](https://sonarcloud.io/api/badges/gate?key=com.github.robsonbittencourt%3Autility-generator)](https://sonarcloud.io/dashboard?id=com.github.robsonbittencourt%3Autility-generator) [![Coverage](https://sonarcloud.io/api/badges/measure?key=com.github.robsonbittencourt%3Autility-generator&metric=coverage)](https://sonarcloud.io/component_measures/metric/coverage/list?id=com.github.robsonbittencourt%3Autility-generator) [![Vulnerabilities](https://sonarcloud.io/api/badges/measure?key=com.github.robsonbittencourt%3Autility-generator&metric=vulnerabilities)](https://sonarcloud.io/project/issues?id=com.github.robsonbittencourt%3Autility-generator&resolved=false&types=VULNERABILITY) [![Bugs](https://sonarcloud.io/api/badges/measure?key=com.github.robsonbittencourt%3Autility-generator&metric=bugs)](https://sonarcloud.io/project/issues?id=com.github.robsonbittencourt%3Autility-generator&resolved=false&types=BUG) [![Code Smells](https://sonarcloud.io/api/badges/measure?key=com.github.robsonbittencourt%3Autility-generator&metric=code_smells)](https://sonarcloud.io/project/issues?id=com.github.robsonbittencourt%3Autility-generator&resolved=false&types=CODE_SMELL)

> Generate utility class to use in your project

## Generate Jar File

To generate this project as a jar file you need to run a maven command with these parameters:
- clean compile assembly:single

## Usage

## To use the Fixture class
- You should instantiate a FixtureConfiguration.
- The default method prefix is `with` but you can use any word.
- The default root path is `src/test/java/`, also you can use any path.
- Instantiate the Fixture and call the generate method

### Example:

Person:
```java
public class Person {
  private String name;
  private int age;
  //getters and setters
}

```

You Generator class:
```java
FixtureConfiguration config = new FixtureConfiguration();
config.setMethodPrefix("with");
config.setRootPath(loader.getAbsolutePath() + config.getRootPath());

AbstractGeneratedClass fixture = new Fixture(Person.class, config);
fixture.generate();

```

Output:
```java
package com.utility.generator.main;

import com.utility.generator.main.Person;
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

  public PersonFixture withName(String name) {
	  this.person.setName(name);
	  return this;
  }

  public PersonFixture withAge(int age) {
	  this.person.setAge(age);
	  return this;
  }

}

```
## To use the Mapper Test Generator Method
- You must specify a `Class Name Suffix`
- You must specify a `Method Name` that will be used in your test method
- You must set your `TypeClass` and `EntityClass`, they are required in any mapper.
