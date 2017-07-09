

import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.utility.generator.base.clazz.Person;
import com.utility.generator.base.clazz.SimpleMapper;
import com.utility.generator.classes.fixture.Fixture;
import com.utility.generator.exception.FixtureGeneratorException;
import com.utility.generator.validator.FixtureCandidateValidator;

public class FixtureCandidateValidatorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldNotThrowExceptionWhenClazzCanBeAFixture() {
		Class<?> clazz = Person.class;

		new FixtureCandidateValidator().validate(clazz);
	}

	@Test
	public void shouldThrowExceptionWhenClazzIsInTheDefaultPackage() {
		thrown.expect(FixtureGeneratorException.class);
		thrown.expectMessage(containsString("Unable to generate fixtures from the default package"));

		Class<?> clazz = Market.class;

		new FixtureCandidateValidator().validate(clazz);
	}

	@Test
	public void shouldThrowExceptionWhenClazzDoesNotHaveAParameterlessPublicConstructor() {
		thrown.expect(FixtureGeneratorException.class);
		thrown.expectMessage(containsString("Class does not contain at least one constructor without parameters"));

		Class<?> clazz = Fixture.class;

		new FixtureCandidateValidator().validate(clazz);
	}

	@Test
	public void shouldThrowExceptionWhenClazzDoesNotHaveLessOneSetterMethod() {
		thrown.expect(FixtureGeneratorException.class);
		thrown.expectMessage(containsString("Class does not contain at least one property to set method"));

		Class<?> clazz = SimpleMapper.class;

		new FixtureCandidateValidator().validate(clazz);
	}

}
