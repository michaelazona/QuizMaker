package mike.project;

import java.io.*;

public class QuizDriver
{

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Quiz myQuiz = makeQuiz();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

		System.out.println("Hit 'enter' to start quiz!");
		br.readLine();

		System.out.print("Hello!  Please enter your name: ");
		String name = br.readLine();
		Player player = new Player(name);

		System.out.println("Good luck " + name + "!");

		for(int z = 0; z < myQuiz.getNumberOfQuestions(); z++)
		{
			br.readLine();
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			Question currentQuestion = myQuiz.getQuestionNumber(z+1);
			currentQuestion.printQuestion();

			System.out.print("\nEnter your answer: ");
			String answer = br.readLine();

			if(currentQuestion.isCorrect(answer.charAt(0)))
			{
				System.out.println("\nThat is correct!");
				player.increaseScore();
			}

			else
			{
				System.out.println("\nThat is wrong!");
			}
		}

		System.out.println("\n\nYour score is " + player.getScore() + " out of " + myQuiz.getNumberOfQuestions());
	}

	public static Quiz makeQuiz() throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Create your quiz.  Give your quiz a name: ");
		String quizName = br.readLine();

		Quiz myQuiz = new Quiz(quizName);
		int questionNumber = 1;

		String question = "";
		String correctAnswer = "";

		System.out.println("Type 'done' in the question field to finish entering questions!\n");

		while(true)
		{
			String[] options = new String[4];

			System.out.println("What is question number " + questionNumber + "?");
			System.out.print(" > ");
			question = br.readLine();

			if(question.equals("done"))
			{
				break;
			}

			System.out.println("\nPlease enter your options: ");

			for(int i = 0; i < 4; i++)
			{
				System.out.print(((char)(i+97)) + ": ");
				options[i] = br.readLine();
			}

			System.out.print("\nEnter correct question letter: ");
			correctAnswer = br.readLine();

			Question thisQuestion = new Question(question, options, correctAnswer.charAt(0));
			myQuiz.addQuestion(thisQuestion);

			questionNumber++;
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}

		return myQuiz;

	}

	public static void clearScreen() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
   }

}