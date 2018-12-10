package Assignment6;


public class ForeignStockHolding extends StockHolding
{
	float conversionRate;
	
	ForeignStockHolding(float purchasePrice, float currentPrice, int noOfShare, String cname, float conRate) 
	{
		super(purchasePrice, currentPrice, noOfShare, cname);
		conversionRate = conRate;
	}
	
	float costInDollars()
	{
		return conversionRate*purchaseSharePrice*numberOfShares;
	}
	
	float valueInDollars()
	{
		return conversionRate*currentSharePrice*numberOfShares;
	}
	
	
}
