package Assignment6;

public class StockHolding {
	float purchaseSharePrice, currentSharePrice;
	int numberOfShares;
	String companyName;
	StockHolding(float purchasePrice, float currentPrice, int noOfShare, String cname)
	{
		purchaseSharePrice = purchasePrice;
		currentSharePrice = currentPrice;
		numberOfShares = noOfShare;
		companyName = cname;
	}
	   
	float costInDollars()
	{
		return purchaseSharePrice*numberOfShares;
	}
	
	float valueInDollars()
	{
		return currentSharePrice*numberOfShares;
	}
}


