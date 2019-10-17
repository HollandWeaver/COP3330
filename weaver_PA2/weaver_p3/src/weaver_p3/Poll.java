package weaver_p3;
import java.util.Scanner;

public class Poll {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String[] topics = {"Health care", "Education", "Climate change", "Religion", "Taxes"};
		int[][] scores = new int[5][10];
		int userScore, i, j;
		int maxTopic = 0;
		int minTopic = 0;
		int users = 0;
		int maxScore = Integer.MIN_VALUE;
		int minScore = Integer.MAX_VALUE;
		double  sumScore = 0;
		String userContinue = "";
		boolean areMoreUsers = true;
		
		System.out.println("Hello! This is a polling program for important topics.");
		System.out.print("The topics include the following:\n");
		for (i = 0; i < topics.length - 1; i++) {							//prints out all five topics
			System.out.print("" + topics[i] + ", ");
		}
		System.out.println("and " + topics[i] + ".\n");
		
		while (areMoreUsers) {												//takes in scores so long as more users poll
			users ++;
			for (i = 0; i < topics.length; i++) {							//assigns userScore for each topic
				System.out.print("Rate from 1 (least) to 10 (most) the importance of " + topics[i].toLowerCase() + " to you: ");
				userScore = scnr.nextInt();
				while ((userScore < 1) || (userScore > 10)) {				//ensures user only inserts valid entries
					System.out.println("Please only enter values from 1 to 10.");
					userScore = scnr.nextInt();
				}
				scores[i][userScore - 1] ++;								//assigns userScore to appropriate score column
			}
			
			System.out.print("Are there more users? (y / n) ");				//checks to continue program
			userContinue = scnr.next();
			userContinue = userContinue.toLowerCase();
			
			if (userContinue.matches("n")) {
				areMoreUsers = false;
				System.out.println("\nThank you for your input! Here are the results:\n");
			}
			else {
				System.out.println();
			}
			
		}
		
		System.out.printf("\t\t Score\t\t\t\t\t\t\t\t\t\tAverage");			//prints header of table
		System.out.printf("\nTopic\t\t 1\t 2\t 3\t 4\t 5\t 6\t 7\t 8\t 9\t 10\n");
		
		for (i = 0; i < topics.length; i++) {								//prints results
			System.out.printf("\n%s", topics[i]);

			if (i == 4) {
				System.out.printf("\t");									//the taxes row requires an add'l \t for formatting
			}
			for (j = 0; j < 10; j++) {
				if (scores[i][j] == 0) {
					System.out.printf("\t ");
				}
				else {
					System.out.printf("\t %d", scores[i][j]);				//if index != 0, multiply counter by score to increase sumScore for topic
					sumScore += (j + 1) * scores[i][j];
				}
				
			}
			System.out.printf("\t%.1f", (sumScore / users));				//prints average
			
			if (sumScore > maxScore) {										//searches for topic with most points
				maxScore = (int)sumScore;
				maxTopic = i;
			}
			if (sumScore < minScore) {										//searches for topic with least points
				minScore = (int)sumScore;
				minTopic = i;
			}
			
			sumScore = 0;													//resets topic total to prepare for next topic
		}
		
		System.out.println();
		if (maxScore == minScore) {											//prints topics with most and least points
			System.out.println("\nAccording to the polls, all topics are equally important!");
		}
		else {
				System.out.println("\nAccording to the polls, the highest priority topic was " + topics[maxTopic] + " at " + maxScore + " points.");
				System.out.println("According to the polls, the lowest priority topic was " + topics[minTopic] + " at " + minScore + " points.");
		}
		
		
	}

}
