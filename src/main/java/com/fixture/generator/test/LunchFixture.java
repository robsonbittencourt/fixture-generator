package com.fixture.generator.test;

import com.fixture.generator.base.clazz.Lunch;
public class LunchFixture {

	private static Lunch lunch = new Lunch();

	public static LunchFixture get() {
		return new LunchFixture();
	}

	public Lunch build() {
		return lunch;
	}
}