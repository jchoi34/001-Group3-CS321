import static org.junit.Assert.*;

import org.junit.Test;

public class BankingSystemTests {

	public static void failFmt(String fmt, Object... args){
	    fail(String.format(fmt,args));
	  }
	
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest1(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  
	  ccType = "Visa";
	  ccNumber = "4916799574132157";
	  ccExpiration = "5/2016";
	  try {valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);}
	  catch (RuntimeException  e) {valid = false;}
	  if(!valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "Expect: "+"RuntimeException n" +"\n"+
	               "Actual: "+"RuntimeException not thrown"+"\n"+"");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest2(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  
	  ccType = "Visa";
	  ccNumber = "916799574132157";
	  ccExpiration = "5/2016";
	  try {valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);}
	  catch (RuntimeException  e) {valid = true;}
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "Expect: "+"RuntimeException n" +"\n"+
	               "Actual: "+"RuntimeException not thrown"+"\n"+"");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest3(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  
	  ccType = "MasterCard";
	  ccNumber = "6011166055322138";
	  ccExpiration = "5/2016";
	  try {valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);}
	  catch (RuntimeException  e) {valid = false;}
	  if(!valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "Expect: "+"RuntimeException n" +"\n"+
	               "Actual: "+"RuntimeException not thrown"+"\n"+"");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest4(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean thrown = false;
	  
	  ccType = "MasterCard";
	  ccNumber = "5435546026874590558";
	  ccExpiration = "5/2014";
	  try {bank.validateCreditCard(ccType, ccNumber, ccExpiration);}
	  catch (RuntimeException  e) {thrown = true;}
	  if(!thrown) {
	       failFmt("validateCreditCard(null):\n"+
	               "Expect: "+"RuntimeException n" +"\n"+
	               "Actual: "+"RuntimeException not thrown"+"\n"+"");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest5(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Visa";
	  ccNumber = "4716001921994146670";
	  ccExpiration = "5/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest6(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "isa";
	  ccNumber = "4716001921994146670";
	  ccExpiration = "5/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
		  
	  }
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest7(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Visa";
	  ccNumber = "343569810633644";
	  ccExpiration = "5/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(!valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest8(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Visa";
	  ccNumber = "343569810633644";
	  ccExpiration = "5/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(!valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest9(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Card";
	  ccNumber = "343569810633644";
	  ccExpiration = "5/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest10(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Visa";
	  ccNumber = "1111111111111";
	  ccExpiration = "5/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
}
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest11(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Visa";
	  ccNumber = "343569810633644";
	  ccExpiration = "5/10";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest12(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Discovery";
	  ccNumber = "343569810633644";
	  ccExpiration = "1/2016";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest13(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Discover";
	  ccNumber = "343569810633644";
	  ccExpiration = "1/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(!valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest14(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Discover";
	  ccNumber = "343569810633644";
	  ccExpiration = "1/1990";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest15(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Discoverrrrrrrr";
	  ccNumber = "343569810633644";
	  ccExpiration = "1/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest16(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "";
	  ccNumber = "343569810633644";
	  ccExpiration = "1/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest17(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Discover";
	  ccNumber = "34356981063364411111111111";
	  ccExpiration = "1/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest18(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "mstercd";
	  ccNumber = "343569810633644";
	  ccExpiration = "1/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest19(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "Visa";
	  ccNumber = "343569810633644";
	  ccExpiration = "2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
	  @SuppressWarnings("unchecked")
	  @Test(timeout=1000) public void BankingSystemTest20(){
	  // Check LinkedArrayNode.remove(x) where x is null throws exception
	  BankingSystem bank = new BankingSystem();
	  String ccType;
	  String ccNumber;
	  String ccExpiration;
	  boolean valid = false;
	  ccType = "MasterCard";
	  ccNumber = "379088125417814";
	  ccExpiration = "1/2019";
	  try {
		  valid = bank.validateCreditCard(ccType, ccNumber, ccExpiration);
		  
		  }
	  catch (RuntimeException  e)   {
		  valid = false;
	  }
	  
	  if(!valid) {
	       failFmt("validateCreditCard(null):\n"+
	               "RuntimeException n");
	    }
	  }
}
