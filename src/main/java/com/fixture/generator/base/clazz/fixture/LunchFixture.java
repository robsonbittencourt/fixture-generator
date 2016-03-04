package com.fixture.generator.base.clazz.fixture;

import java.util.ArrayList;
import java.util.List;

import com.fixture.generator.base.clazz.Lunch;

public class LunchFixture {

	private static Lunch lunch = new Lunch();

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
}