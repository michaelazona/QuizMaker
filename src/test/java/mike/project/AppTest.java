package mike.project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{

    public void testQuestionHasQuestionMark() throws Exception
    {
    	String question = "This doesn't have a question mark.";
		String[] options = new String[4];

		options[0] = "Apples";
		options[1] = "Oranges";
		options[2] = "Bananas";
		options[3] = "Mangos";

		try
		{
			Question newQuestion = new Question(question, options, 'a');
			fail("Needs to be a question");
		}

		catch(Exception exception)
		{
			assertNotNull("Exception thrown when trying to create question without a question mark.");
		}
    }

    public void testQuestionIsNotEmpty() throws Exception
    {
    	String question = "";
		String[] options = new String[4];

		options[0] = "Apples";
		options[1] = "Oranges";
		options[2] = "Bananas";
		options[3] = "Mangos";

		try
		{
			Question newQuestion = new Question(question, options, 'a');
			fail("Needs to fail because there is no text in question.");
		}

		catch(Exception exception)
		{
			assertNotNull("Exception thrown creating question with no question.");
		}
    }

    public void testOptionsAreOfLengthFour() throws Exception
    {
    	String question = "Is this a valid question?";
		String[] options = new String[5];

		options[0] = "Apples";
		options[1] = "Oranges";
		options[2] = "Bananas";
		options[3] = "Mangos";
		options[4] = "Watermelon";

		try
		{
			Question newQuestion = new Question(question, options, 'a');
			fail("Needs to fail because there is more than four options.");
		}

		catch(Exception exception)
		{
			assertNotNull("Exception thrown when trying to pass option array with more than 4 elements.");
		}
    }

    public void testLettersOtherThanABCD() throws Exception
    {
    	String question = "";
		String[] options = new String[4];

		options[0] = "Apples";
		options[1] = "Oranges";
		options[2] = "Bananas";
		options[3] = "Mangos";

		try
		{
			Question newQuestion = new Question(question, options, 'e');
			fail("Needs to fail because it is a letter e.");
		}

		catch(Exception exception)
		{
			assertNotNull("Exception thrown since only letters a-d are allowed.");
		}
    }

    public void checkIfCorrectAnswerFunctionWorks() throws Exception
    {
    	String question = "Is this a valid question?";
		String[] options = new String[4];

		options[0] = "Apples";
		options[1] = "Oranges";
		options[2] = "Bananas";
		options[3] = "Mangos";
		
		char correctAnswer = 'a';

		Question myQuestion = new Question(question, options, 'a');

		assertEquals(myQuestion.getCorrectAnswer(), 'a');
    }

    public void testScoreFunctionsForPlayer()
    {
    	Player bob = new Player("bob");

    	assertEquals(bob.getScore(), 0);
    	bob.increaseScore();
    	assertEquals(bob.getScore(), 1);
    }

    public void testEarningsAfterTenYears() throws Exception
    {
    	int salary = 100000;
    	Employee joe = new Employee("Joseph", "Zona", 10000);

    	assertEquals(salary, joe.getEarningsAfterTenYears());
    }

    public void testQuizNameGetter()
    {
    	Quiz myQuiz = new Quiz("myQuiz");

    	assertEquals("myQuiz", myQuiz.getName());
    }

    public void testQuizAddQuestionFunction() throws Exception
    {
    	Quiz myQuiz = new Quiz("myQuiz");

    	String question = "Is this a valid question?";
		String[] options = new String[4];

		options[0] = "Apples";
		options[1] = "Oranges";
		options[2] = "Bananas";
		options[3] = "Mangos";
		
		char correctAnswer = 'a';

		Question myQuestion = new Question(question, options, 'a');

		myQuiz.addQuestion(myQuestion);

		assertEquals(myQuiz.getQuestionNumber(1), myQuestion);

    }
}
