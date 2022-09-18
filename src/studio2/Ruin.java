package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
	Scanner in = new Scanner(System.in); 
	System.out.println("What is your starting amount?");
	int startMoney = in.nextInt();
	System.out.println("What is your win chance?");
	double winChance = in.nextDouble();
	System.out.println("What is your win limit?");
	int winLimit = in.nextInt ();
	double count = 0.0;
	int money = startMoney;
	System.out.println("How many days do you want to gamble?");
	int totalSimulations = in.nextInt();
	double ruin = 0.0;
	
	for(int i = 0; i < totalSimulations; i++)
		{
		while(money > 0 && money < winLimit)
			{
			if (Math.random() < winChance)
				{
				money += 1; 
				}
			else 
				{
				money -= 1;
				}
			count++; 
		
		
		
		
		
		
	
		}
		if (money > 0)
			{
			System.out.println("Success!");
			}
		else 
			{
			System.out.println("Ruin");
			ruin += 1;
			}
		System.out.println("Day: " + (i + 1));
		money = startMoney;
		}
	double ruinRate = (double)(ruin / totalSimulations);
	System.out.println("Ruin Rate" + Math.round(ruinRate * 100) + "%");
	
	double expectedRuin;
	double a = ((1.0 - winChance) / (winChance));
	
	if (winChance == 0.5)
		{
		expectedRuin = (double)(1.0 - (startMoney / winLimit));
		}
	else
		{
		expectedRuin = (double)(Math.pow(a, startMoney) - Math.pow(a, winLimit)) / (1.0 - Math.pow(a, winLimit));
		}
	System.out.println(expectedRuin);
	System.out.println("Expected Ruin Rate" + Math.round(expectedRuin * 100) + "%");


}
}
