package mike.project;

public class Question
{
	private String question;
	private String[] options;
	private char correctAnswer;

	public Question(String question, String[] options, char correctAnswer) throws Exception
	{
		if(question != "" && question.indexOf('?') > 0){ this.question = question; }
		else{ throw new Exception("Needs to be a question");}

		if(options.length == 4){ this.options = options; }
		else{ throw new Exception("Please have the correct number of options."); }

		if(correctAnswer == 'a' || correctAnswer == 'b' || correctAnswer == 'c' || correctAnswer == 'd'){ this.correctAnswer = correctAnswer; }
		else{ throw new Exception("Need to use either a, b, c, or d."); }
	}

	public String getQuestion()
	{
		return this.question;
	}

	public String[] getOptions()
	{
		return this.options;
	}

	public char getCorrectAnswer()
	{
		return this.correctAnswer;
	}

	public void setQuestion(String question) throws Exception
	{
		if(question == "" || question.indexOf('?') > 0){ this.question = question; }
		else{ throw new Exception("Needs to be a question");}
	}

	public void setOptions(String[] options) throws Exception
	{
		if(options.length == 4){ this.options = options; }
		else{ throw new Exception("Please have the correct number of options."); }
	}

	public void setCorrectAnswer(char correctAnswer) throws Exception
	{
		if(correctAnswer == 'a' || correctAnswer == 'b' || correctAnswer == 'c' || correctAnswer == 'd'){ this.correctAnswer = correctAnswer; }
		else{ throw new Exception("Need to use either a, b, c, or d."); }
	}

	public boolean isCorrect(char answer)
	{
		return (this.correctAnswer == answer);
	}

	public void printQuestion()
	{
		System.out.println(this.question);
		System.out.println("\na) " + this.options[0]);
		System.out.println("b) " + this.options[1]);
		System.out.println("c) " + this.options[2]);
		System.out.println("d) " + this.options[3]);
	}
}