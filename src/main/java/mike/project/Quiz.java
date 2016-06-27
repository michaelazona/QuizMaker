package mike.project;

public class Quiz
{
	private String name = "";
	private Question[] questions = new Question[0];
	private int numberOfQuestions = 0;

	public Quiz(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void addQuestion(Question question)
	{
		int newLength = this.questions.length + 1;
		Question[] newQuestions = new Question[newLength];

		for(int i = 0; i < this.questions.length; i++)
		{
			newQuestions[i] = this.questions[i];
		}

		newQuestions[newLength-1] = question;
		this.questions = newQuestions;
		this.numberOfQuestions++;
	}

	public Question[] getAllQuestions()
	{
		return this.questions;
	}

	public Question getQuestionNumber(int num)
	{
		return this.questions[num - 1];
	}

	public int getNumberOfQuestions()
	{
		return this.numberOfQuestions;
	}

}