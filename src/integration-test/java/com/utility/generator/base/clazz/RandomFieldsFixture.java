package com.utility.generator.base.clazz;

import java.util.List;
import java.util.ArrayList;
import com.utility.generator.base.clazz.RandomFields;
import static com.utility.generator.randomstuff.RandomStuff.getRandomString;
import static com.utility.generator.randomstuff.RandomStuff.getRandomInt;
import static com.utility.generator.randomstuff.RandomStuff.getRandomInteger;
import static com.utility.generator.randomstuff.RandomStuff.getRandomDouble;
import static com.utility.generator.randomstuff.RandomStuff.getRandomBigDecimal;
import static com.utility.generator.randomstuff.RandomStuff.getRandomBigInteger;
import static com.utility.generator.randomstuff.RandomStuff.getRandomBoolean;
import static com.utility.generator.randomstuff.RandomStuff.getRandomDate;
import static com.utility.generator.randomstuff.RandomStuff.getRandomLocalDate;
import static com.utility.generator.randomstuff.RandomStuff.getRandomFloat;
import static com.utility.generator.randomstuff.RandomStuff.getRandomLong;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.time.LocalDate;
public class RandomFieldsFixture {

	private RandomFields randomFields = new RandomFields();

	public static RandomFieldsFixture get() {
		return new RandomFieldsFixture();
	}

	public RandomFields build() {
		return randomFields;
	}

	public List<RandomFields> buildList(Integer amount) {
		List<RandomFields> randomFieldss = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			randomFieldss.add(this.build());
		}
		return randomFieldss;
	}

	public RandomFieldsFixture withStringField() {
		this.randomFields.setStringField(getRandomString());
		return this;
	}

	public RandomFieldsFixture withStringField(String stringField) {
		this.randomFields.setStringField(stringField);
		return this;
	}

	public RandomFieldsFixture withIntField() {
		this.randomFields.setIntField(getRandomInt());
		return this;
	}

	public RandomFieldsFixture withIntField(int intField) {
		this.randomFields.setIntField(intField);
		return this;
	}

	public RandomFieldsFixture withIntegerField() {
		this.randomFields.setIntegerField(getRandomInteger());
		return this;
	}

	public RandomFieldsFixture withIntegerField(Integer integerField) {
		this.randomFields.setIntegerField(integerField);
		return this;
	}

	public RandomFieldsFixture withDoubleField() {
		this.randomFields.setDoubleField(getRandomDouble());
		return this;
	}

	public RandomFieldsFixture withDoubleField(double doubleField) {
		this.randomFields.setDoubleField(doubleField);
		return this;
	}

	public RandomFieldsFixture withDoubleObjectField() {
		this.randomFields.setDoubleObjectField(getRandomDouble());
		return this;
	}

	public RandomFieldsFixture withDoubleObjectField(Double doubleObjectField) {
		this.randomFields.setDoubleObjectField(doubleObjectField);
		return this;
	}

	public RandomFieldsFixture withBigDecimalField() {
		this.randomFields.setBigDecimalField(getRandomBigDecimal());
		return this;
	}

	public RandomFieldsFixture withBigDecimalField(BigDecimal bigDecimalField) {
		this.randomFields.setBigDecimalField(bigDecimalField);
		return this;
	}

	public RandomFieldsFixture withBigIntegerField() {
		this.randomFields.setBigIntegerField(getRandomBigInteger());
		return this;
	}

	public RandomFieldsFixture withBigIntegerField(BigInteger bigIntegerField) {
		this.randomFields.setBigIntegerField(bigIntegerField);
		return this;
	}

	public RandomFieldsFixture withBooleanField() {
		this.randomFields.setBooleanField(getRandomBoolean());
		return this;
	}

	public RandomFieldsFixture withBooleanField(boolean booleanField) {
		this.randomFields.setBooleanField(booleanField);
		return this;
	}

	public RandomFieldsFixture withBooleanObjectField() {
		this.randomFields.setBooleanObjectField(getRandomBoolean());
		return this;
	}

	public RandomFieldsFixture withBooleanObjectField(Boolean booleanObjectField) {
		this.randomFields.setBooleanObjectField(booleanObjectField);
		return this;
	}

	public RandomFieldsFixture withDateField() {
		this.randomFields.setDateField(getRandomDate());
		return this;
	}

	public RandomFieldsFixture withDateField(Date dateField) {
		this.randomFields.setDateField(dateField);
		return this;
	}

	public RandomFieldsFixture withLocalDateField() {
		this.randomFields.setLocalDateField(getRandomLocalDate());
		return this;
	}

	public RandomFieldsFixture withLocalDateField(LocalDate localDateField) {
		this.randomFields.setLocalDateField(localDateField);
		return this;
	}

	public RandomFieldsFixture withFloatField() {
		this.randomFields.setFloatField(getRandomFloat());
		return this;
	}

	public RandomFieldsFixture withFloatField(float floatField) {
		this.randomFields.setFloatField(floatField);
		return this;
	}

	public RandomFieldsFixture withFloatObjectField() {
		this.randomFields.setFloatObjectField(getRandomFloat());
		return this;
	}

	public RandomFieldsFixture withFloatObjectField(Float floatObjectField) {
		this.randomFields.setFloatObjectField(floatObjectField);
		return this;
	}

	public RandomFieldsFixture withLongField() {
		this.randomFields.setLongField(getRandomLong());
		return this;
	}

	public RandomFieldsFixture withLongField(long longField) {
		this.randomFields.setLongField(longField);
		return this;
	}

	public RandomFieldsFixture withLongObjectField() {
		this.randomFields.setLongObjectField(getRandomLong());
		return this;
	}

	public RandomFieldsFixture withLongObjectField(Long longObjectField) {
		this.randomFields.setLongObjectField(longObjectField);
		return this;
	}
}