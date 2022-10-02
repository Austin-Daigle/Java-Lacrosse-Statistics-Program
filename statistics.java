import java.text.DecimalFormat;
import java.util.Scanner;

public class statistics {
	public static void main(String[] args)
	{
		String playername;
		String gamenumberprompt = "Null";
		double sportsdata[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		System.out.println("==========================================");
		System.out.println("Enter Player Name:");
		System.out.print("»» ");
		Scanner nameInput = new Scanner(System.in);
		playername = nameInput.next();
		System.out.println("==========================================");

		for(int primarycount = 0; primarycount<3; primarycount++)
		{
			switch(primarycount)
			{
			case 0:gamenumberprompt = "first";
			break;
			case 1:gamenumberprompt = "second";
			break;
			case 2:gamenumberprompt = "third";
			break;
			}	
			for(int count = 0; count<3; count++)
			{
				switch(count){
				case 0: System.out.println("Enter Number of shots for the "+
				gamenumberprompt+" game.");
				break;
				case 1: System.out.println("Enter Number of goals for the "+
				gamenumberprompt+" game.");
				break;
				case 2: System.out.println("Enter Number of assists for the "+
				gamenumberprompt+" game.");
				break;
			}
			System.out.print("» ");
			Scanner statisticsinput = new Scanner(System.in);
			sportsdata[primarycount][count] = statisticsinput.nextDouble();	
			}
		} 

		//Math Operation
		for(int element = 0; element <sportsdata.length-1; element++)
		{
			for(int table = 0; table <sportsdata.length-1; table++)
			{	
				//Add all statistics row into statistics average entry.
				sportsdata[3][element] = sportsdata[3][element]+sportsdata[table][element];
				//Add Goals and Assists to the points entry.
				sportsdata[element][3] = sportsdata[element][1]+sportsdata[element][2];
			}
			//Divide average element entry by three.
			sportsdata[3][element] = sportsdata[3][element]/(sportsdata.length-1);
			//Add all score rows together to make the total.
			sportsdata[3][3] = sportsdata[3][3] +sportsdata[element][3];
		}
		System.out.println("");	
		System.out.println("");	
		System.out.println("");	
		System.out.println("lacrosse statistics - "+playername);
		System.out.println("Game:\t  Shots:   Goals:  Assists:  Points:");
		for(int columns = 0; columns<sportsdata.length; columns++)
		{
				if(columns<sportsdata.length-1)
				{
					System.out.print(1+columns+"\t  ");	
				}
				else 
				{
					System.out.print("Average:  ");	
				}
			for(int rows = 0; rows<sportsdata.length; rows++)
			{
				System.out.print(numberFormat.format(sportsdata[columns][rows])+"     ");	
			}
			System.out.println("");	
		}
	}
}