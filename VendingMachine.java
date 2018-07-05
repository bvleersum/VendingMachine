package Vending;

public class VendingMachine implements VendingMachineInterface {
	
	private int snicker, twix, reeses, money, profit = 0;
	private String selected = "";

	
	
	public VendingMachine(int s, int t, int r) {
		snicker = s;
		twix = t;
		reeses = r;
		
	}
	
	public void insertCents(int c) {
		if (c%5 == 0)
			money += c;
		else
			throw new ImproperCoinsException();
	}
	
	public void makeSelection(int s) {
		if (s == 0)
			if (snicker > 0)
				selected = "Snicker";
			else
				throw new ImproperSelectionException("Snicker");
		
		else if (s == 1)
			if (twix > 0)
				selected = "Twix";
			else
				throw new ImproperSelectionException("Twix");
			
		else if (s == 2)
			if (reeses > 0)
				selected = "Reeses";
			else
				throw new ImproperSelectionException("Reeses");
		else
			throw new ImproperSelectionException();
		
	}
	
	public int purchaseSelection() {
		if (selected.equals("Snicker")) {
			if (money >= 100) {
				money -= 100;
				profit += 100;
				snicker -= 1;
				return money;	
			}
			else
				throw new ImproperPurchaseException(100-money);	
		}
		else if (selected.equals("Twix")) {
			if (money >= 115) {
				money -= 115;
				profit += 115;
				twix -=1;
				return money;
			}
			else
				throw new ImproperPurchaseException(115-money);
		}
		else if (selected.equals("Reeses")) {
			if (money >= 130) {
				money -= 130;
				profit += 130;
				reeses -=1;
				return money;
			}
			else
				throw new ImproperPurchaseException(130-money);
		}
		else
			throw new ImproperPurchaseException();
	}
	
	public int returnUnspentCents() {
		return money;
	}
	
	public int getProfits() {
		return profit;
	}

}
