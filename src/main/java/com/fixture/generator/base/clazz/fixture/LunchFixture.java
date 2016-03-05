package com.fixture.generator.base.clazz.fixture;

import com.fixture.generator.base.clazz.Lunch;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
public class LunchFixture {

	private Lunch lunch = new Lunch();

	public static LunchFixture get() {
		return new LunchFixture();
	}

	public Lunch build() {
		return lunch;
	}

	public List<Lunch> buildList(Integer amount) {
		List<Lunch> lunchs = new ArrayList<Lunch>();
		for (int i = 0; i < amount; i++) {
			lunchs.add(this.build());
		}
		return lunchs;
	}

	public LunchFixture withName(String name) {
		this.lunch.setName(name);
		return this;
	}

	public LunchFixture withAge(int age) {
		this.lunch.setAge(age);
		return this;
	}

	public LunchFixture withBalance(BigDecimal balance) {
		this.lunch.setBalance(balance);
		return this;
	}
}