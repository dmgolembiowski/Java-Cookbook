// CreditKarma/Project.java
// by David
//
/* This program prompts the user to enter a credit card
	number as a long integer and display whether that card is valid or invalid.

	# Credit card numbers have 13-16 digits, btw
	Steps:
	1. Double every second digit from R to L. If doubling of a digit
		results in a two-digit number, add up the two digits to get a single-
		digit number (like for: 12: 1+2, 18: 1+8)
	2. Add all single-digit numbers from Step 1
	3. Add all digits in the odd places from R to L in the card number;
	4. Sum the results from (2) and (3).
	5. If result(4) % 10 == 0: return True, else False
*/
import java.util.Arrays;

class List {
    Object[] elements;
    Object newElement;
    Object[] secondList;

    List(Object[] elements, Object newElement,
            Object[] secondList) {
        this.elements = elements;
        this.newElement = newElement;
        this.secondList = secondList;
    }
    
    private void append(Object newSlice) {
       this.elements[this.elements.length] = newSlice;
       System.out.print(this.elements.toString());
    }
}

class Card {
    String creditCardno;
    String name;
    String expDate;
    String cvc;

    public static String get_cardNo() {
        System.out.print("Enter the credit card number: ");
        String credCardNo = System.console().readLine();
        return credCardNo;
    }

    public static String get_Name() {       
        System.out.print("Enter the cardholder's name: ");
        String _name = System.console().readLine();
        return _name;
    }

    public static String expirationDate() {
        System.out.print("Enter the expiration date: ");
        String _date = System.console().readLine();
        return _date;
    }

    public static String getCVC() {
        System.out.print("Enter the holder's CVC (3-digit code): ");
        String _cvc = System.console().readLine();
        return _cvc;
    }
    private static boolean validate() {
        boolean isValid;
        Container container = new Container();
        return true;
    }

    Card() {
        this.creditCardno = Card.get_cardNo();
        this.name = Card.get_Name();
        this.expDate = Card.expirationDate();
        this.cvc = Card.getCVC();
    }
}

class Container {
    // The length of the credit card
    int len;

    // The card no as a string
    String numbers;

    // The even-positioned digits
    int[] evens;

    // The odd-positioned digits
    int[] odds; 

    Container(int... numbers) {
        this.numbers = numbers.toString();
    }

    // Containers for migrating types
    int[] intDigits = new int[len];
    char[] strDigits = numbers.toCharArray();
 
}

class Project {
    public static void main(String[] args) {
        Card creditCard = new Card();
        System.out.println(creditCard.toString());
    }
}
