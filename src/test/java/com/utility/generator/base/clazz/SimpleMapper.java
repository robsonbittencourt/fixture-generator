package com.utility.generator.base.clazz;


public class SimpleMapper extends AbstractMapper<ServicePerson, Person> {

	@Override
	public ServicePerson toType(Person person) {
		ServicePerson servicePerson = new ServicePerson();

		servicePerson.setAge(person.getAge());
		servicePerson.setName(person.getName());

		return servicePerson;
	}

}
