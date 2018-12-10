package Assignment6;


import java.util.*;

public class Stock 
{
	//function to display StockHolding in ascending order
	static void displayAscending(StockHolding array[])
	{
		//selection sort
		for(int i=0; i<array.length; i++)
		{
			//temp is a variable used to swap 2 object in array
			StockHolding temp;
			for(int j=i+1; j<array.length; j++)
			{
				//if value at index j is lexicographically smaller than that at i swap them
				if((array[j].companyName.compareTo(array[i].companyName)) < 0)
				{
					temp = array[j];
					array[j]=array[i];
					array[i]=temp;
				}
			}
		}
		
		//print all the details on screen
		//System.out.println(" ");
		
		System.out.println("Display of stock in ascending order by name : ");
		for(int i=0; i<array.length; i++)
		{
			if(array[i] instanceof ForeignStockHolding) {
				 System.out.println(" ForeignStockHolding! ");
			   }
			else
			  {
				 System.out.println("StockHolding! ");
				}
			System.out.println("Company Name : "+array[i].companyName);
			System.out.println("Purchase Share Price : "+array[i].purchaseSharePrice);
			System.out.println("Current Share Price : "+array[i].currentSharePrice);
			System.out.println("Number of Shares : "+array[i].numberOfShares);
			System.out.println();
		}
		
	}
	
	//function to display ForeignStockHolding in descending order
	static void displayDescending(ForeignStockHolding array[])
	{
		//selection sort
		for(int i=0; i<array.length; i++)
		{
			ForeignStockHolding temp;
			for(int j=i+1; j<array.length; j++)
			{
				//if value at index j is lexicographically greater than that at i swap them
				if((array[j].companyName.compareTo(array[i].companyName)) > 0)
				{
					temp = array[j];
					array[j]=array[i];
					array[i]=temp;
				}
			}
		}
		
		//printing the stock in descending order
		System.out.println("Display of stock in descending order by name : ");
		for(int i=0; i<array.length; i++)
		{
			if(array[i] instanceof ForeignStockHolding) {
				 System.out.println(" ForeignStockHolding! ");
			   }
			else
			  {
				 System.out.println("StockHolding! ");
				}
			
			System.out.println("Company Name : "+array[i].companyName);
			System.out.println("Purchase Share Price : "+array[i].purchaseSharePrice);
			System.out.println("Current Share Price : "+array[i].currentSharePrice);
			System.out.println("Number of Shares : "+array[i].numberOfShares);
			System.out.println("Conversion Rate : "+array[i].conversionRate);
			System.out.println();
		}
		
	}
	
	//function to display ForeignStockHolding in ascending order
	static void displayAscending(ForeignStockHolding array[])
	{
		//selection sort
		for(int i=0; i<array.length; i++)
		{
			ForeignStockHolding temp;
			for(int j=i+1; j<array.length; j++)
			{
				//if value at index j is lexicographically less than that at i swap them
				if((array[j].companyName.compareTo(array[i].companyName)) < 0)
				{
					temp = array[j];
					array[j]=array[i];
					array[i]=temp;
				}
			}
		}
		
		//printing the stock in ascending order
	
		System.out.println("Display of stock in ascending order by name : ");
		for(int i=0; i<array.length; i++)
		{
			if(array[i] instanceof ForeignStockHolding) {
				 System.out.println(" ForeignStockHolding! ");
			   }
			else
			  {
				 System.out.println("StockHolding! ");
				}
			System.out.println("Company Name : "+array[i].companyName);
			System.out.println("Purchase Share Price : "+array[i].purchaseSharePrice);
			System.out.println("Current Share Price : "+array[i].currentSharePrice);
			System.out.println("Number of Shares : "+array[i].numberOfShares);
			System.out.println("Conversion Rate : "+array[i].conversionRate);
			System.out.println();
		}
		
	}	
	
	//function to display minimum value stock
	static void displayMinValue (ForeignStockHolding array[])
	{
		//temp object of ForeignStockHolding to store minimum value stock
		ForeignStockHolding temp = array[0];
		
		//traversing the array to find the minimum value stock
		for(int i=1; i<array.length; i++)
		{
			if(temp.valueInDollars() > array[i].valueInDollars())
			{
				temp = array[i];
			}
		}
		
		//printing the minimum value stock
		System.out.println("Minimum Value Stock :");
		System.out.println("Company Name : "+temp.companyName);
		System.out.println("Purchase Share Price : "+temp.purchaseSharePrice);
		System.out.println("Current Share Price : "+temp.currentSharePrice);
		System.out.println("Number of Shares : "+temp.numberOfShares);
		System.out.println("Conversion Rate : "+temp.conversionRate);
		System.out.println();
	}
	
	static void displayMaxValue (ForeignStockHolding array[])
	{
		//temp object of ForeignStockHolding to store max value stock
		ForeignStockHolding temp = array[0];
		
		//traversing the array to find the max value stock
		for(int i=1; i<array.length; i++)
		{
			if(temp.valueInDollars() < array[i].valueInDollars())
			{
				temp = array[i];
			}
		}
		
		//printing the maximum value stock
		System.out.println("Maximum Value Stock :");
		System.out.println("Company Name : "+temp.companyName);
		System.out.println("Purchase Share Price : "+temp.purchaseSharePrice);
		System.out.println("Current Share Price : "+temp.currentSharePrice);
		System.out.println("Number of Shares : "+temp.numberOfShares);
		System.out.println("Conversion Rate : "+temp.conversionRate);
		System.out.println();
	}
	
	static void displayMaxProfitableStock(ForeignStockHolding array[])
	{
		//temp object of ForeignStockHolding to store max profitable stock
		ForeignStockHolding temp = array[0];
		
		//traversing the array to find the max profitable stock
		for(int i=1; i<array.length; i++)
		{
			if((temp.valueInDollars()-temp.costInDollars()) < (array[i].valueInDollars()-array[i].costInDollars()))
			{
				temp = array[i];
			}
		}
		
		//printing the maximum profitable stock
		System.out.println("Maximum Profitable Stock :");
		System.out.println("Company Name : "+temp.companyName);
		System.out.println("Purchase Share Price : "+temp.purchaseSharePrice);
		System.out.println("Current Share Price : "+temp.currentSharePrice);
		System.out.println("Number of Shares : "+temp.numberOfShares);
		System.out.println("Conversion Rate : "+temp.conversionRate);
		System.out.println();
	}
	
	static void displayMinProfitableStock(ForeignStockHolding array[])
	{
		//temp object of ForeignStockHolding to store min profitable stock
		ForeignStockHolding temp = array[0];
		
		//traversing the array to find the min profitable stock
		for(int i=1; i<array.length; i++)
		{
			if((temp.valueInDollars()-temp.costInDollars()) > (array[i].valueInDollars()-array[i].costInDollars()))
			{
				temp = array[i];
			}
		}
		
		//printing the minimum profitable stock
		System.out.println("Minimum Profitable Stock :");
		System.out.println("Company Name : "+temp.companyName);
		System.out.println("Purchase Share Price : "+temp.purchaseSharePrice);
		System.out.println("Current Share Price : "+temp.currentSharePrice);
		System.out.println("Number of Shares : "+temp.numberOfShares);
		System.out.println("Conversion Rate : "+temp.conversionRate);
		System.out.println();
	}
	
	static void displayInSortedValueOrder (ForeignStockHolding array[])
	{
		//selection sort
		for(int i=0; i<array.length; i++)
		{
			ForeignStockHolding temp;
			for(int j=i+1; j<array.length; j++)
			{
				//if value at index j is lexicographically less than that at i swap them
				if(array[j].valueInDollars() < array[i].valueInDollars())
				{
					temp = array[j];
					array[j]=array[i];
					array[i]=temp;
				}
			}
		}
		
		//print in the stock in ascending order
		System.out.println("Display of stock in ascending order by value : ");
		for(int i=0; i<array.length; i++)
		{
			System.out.println("Company Name : "+array[i].companyName);
			System.out.println("Purchase Share Price : "+array[i].purchaseSharePrice);
			System.out.println("Current Share Price : "+array[i].currentSharePrice);
			System.out.println("Number of Shares : "+array[i].numberOfShares);
			System.out.println("Conversion Rate : "+array[i].conversionRate);
			System.out.println();
		}		
	}
	
	public static void main (String[] args)
	{
		//array of StockHolding
		StockHolding stockHoldingArray[] = new StockHolding[3];
		
		stockHoldingArray[0] = new StockHolding((float)2.30, (float)4.50, (int)40, "XYZ limited");
		stockHoldingArray[1] = new StockHolding((float)12.19, (float)10.56, (int)90, "ABC Pvt Limited");
		stockHoldingArray[2] = new StockHolding((float)45.10, (float)49.51, (int)210, "United States Limited");
		
		//function to display in alphabetical order
		displayAscending(stockHoldingArray);
		
		//array of ForeignStockHolding
		ForeignStockHolding foreignStockHoldingArray[] = new ForeignStockHolding[3];
		
		foreignStockHoldingArray[0] = new ForeignStockHolding((float)2.30, (float)4.50, (int)40, "XYZ limited", (float)0.94);
		foreignStockHoldingArray[1] = new ForeignStockHolding((float)12.19, (float)10.56, (int)90, "ABC Pvt Limited", (float)1.10);
		foreignStockHoldingArray[2] = new ForeignStockHolding((float)45.10, (float)49.51, (int)210, "United States Limited", (float)1.25);
		
		//function to display in reverse alphabetical order
		displayDescending(foreignStockHoldingArray);
		
		
		//modifying the application according to the user 
		
		//taking no of stock from user
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter no of stocks(not more than 8) : ");
		
		//no of stock user want to access
		int noOfStocks = input.nextInt();
		
		//declaring array of ForeignStockHolding  as  per user requirement 
		ForeignStockHolding userStockHoldingArray[] = new ForeignStockHolding[noOfStocks];
		
		for(int i=0; i<noOfStocks; i++)
		{
			//to take the type of stock user want to enter
			int typeOfStock;
			
			System.out.print("Press 1 for StockHolding \n 2 for ForeignStockHolding \n");
			
			//taking the type of stock
			typeOfStock = input.nextInt();
			
			//declaring the variable to take input for purchaseSharePrice, currentSharePrice, conversionRate
			float purchasePrice,currentPrice, conRate;
			
			//declaring the variable to take input for numberOfShares
			int noOfShare;
			
			//declaring the variable to take input for companyName
			String cname;
			
			//taking input from user for each field specified in stock
			System.out.print("Enter the purchaseSharePrice for stock : ");
			purchasePrice = input.nextFloat();
			System.out.print("Enter the currentSharePrice for stock : ");
			currentPrice = input.nextFloat();
			System.out.print("Enter the noOfShares for stock : ");
			noOfShare = input.nextInt();
			System.out.print("Enter the companyName for stock : ");
			cname = input.next();
			
			//if the stock is of type StockHolding then conversion rate is 1 else take input from user
			if(typeOfStock == 1)
			{
				conRate = 1;
			}
			else 
			{
				System.out.print("Enter the conversion Rate for foreign stock");
				conRate = input.nextFloat();
			}
			
			//initialize the stock type as per user requirement
			userStockHoldingArray[i] = new ForeignStockHolding(purchasePrice, currentPrice, noOfShare, cname, conRate);
		}
		
		//a variable of boolean type
		boolean value = true;
		
		//continue loop until user do not command to exit
		while(value)
		{
			System.out.println("Enter your choice : \n    1) Display stock information with the lowest value\r\n" + 
					"    2) Display stock with the highest value\r\n" + 
					"    3) Display the most profitable stock\r\n" + 
					"    4) Display the least profitable stock\r\n" + 
					"    5) List all stocks sorted by company name (A-Z)\r\n" + 
					"    6) List all stocks sorted from the lowest value to the highest value\r\n" + 
					"    7) Exit");
			
			//variable to take choice of user
			int choice = input.nextInt();
			
			switch(choice)
			{
				case 1: 
				{
					displayMinValue(userStockHoldingArray);
					break;
				}
				case 2:
				{
					displayMaxValue(userStockHoldingArray);
					break;
				}
				case 3:
				{
					displayMaxProfitableStock(userStockHoldingArray);
					break;
				}
				case 4:
				{
					displayMinProfitableStock(userStockHoldingArray);
					break;
				}
				case 5:
				{
					displayAscending(userStockHoldingArray);
					break;
				}
				case 6:
				{
					displayInSortedValueOrder(userStockHoldingArray);
					break;
				}
				case 7:
				{
					value = false;
				}
			}
			
		}
		System.out.println("Over. Thank you");
	}

}

