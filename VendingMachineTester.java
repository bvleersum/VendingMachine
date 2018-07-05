package Vending;

import static org.junit.Assert.*;
import org.junit.Test;

public class VendingMachineTester {
	
	@Test(expected = ImproperCoinsException.class)
	public void improperCoinTest1() {
		VendingMachine v = new VendingMachine (5,5,5);
		v.insertCents(156);
	}
	
	@Test(expected = ImproperSelectionException.class)
	public void improperSelectionTest2() {
		VendingMachine v = new VendingMachine (5,5,5);
		v.makeSelection(5);
	}
	
	@Test(expected = ImproperSelectionException.class)
	public void improperSelectionTest3() {
		VendingMachine v = new VendingMachine (0,5,5);
		v.makeSelection(0);
	}
	
	@Test(expected = ImproperPurchaseException.class)
	public void improperPurchaseTest4() {
		VendingMachine v = new VendingMachine (5,5,5);
		v.insertCents(200);
		v.purchaseSelection();
	}
	
	@Test(expected = ImproperPurchaseException.class)
	public void improperPurchaseTest5() {
		VendingMachine v = new VendingMachine (5,5,5);
		v.insertCents(50);
		v.makeSelection(1);
		v.purchaseSelection();
	}
	
	@Test
	public void correctAmountTest6() {
		VendingMachine v = new VendingMachine (5,5,5);
		v.insertCents(200);
		v.makeSelection(0);
		assertEquals(v.purchaseSelection(), 100);
	}
	
	@Test
	public void correctAmountTest7() {
		VendingMachine v = new VendingMachine (5,5,5);
		v.insertCents(200);
		v.makeSelection(0);
		assertEquals(v.returnUnspentCents(), 200);
	}
	
	@Test
	public void profitTest8() {
		VendingMachine v = new VendingMachine (5,5,5);
		v.insertCents(200);
		v.makeSelection(0);
		v.purchaseSelection();
		v.insertCents(200);
		v.makeSelection(1);
		v.purchaseSelection();
		v.insertCents(200);
		v.makeSelection(2);
		v.purchaseSelection();
		assertEquals(v.getProfits(), 345);
	}
	
	@Test(expected = ImproperSelectionException.class)
	public void improperSelectionTest4() {
		VendingMachine v = new VendingMachine (1,5,5);
		v.insertCents(500);
		v.makeSelection(0);
		v.purchaseSelection();
		v.makeSelection(0);
	}
}
