// Isaac Hartzell
// February 21, 2017
// This program converts Arabic numerals to Roman numerals.

import java.util.Scanner;
public class ConvertArabicNumerals 
{

	public static void main(String[] args) 
	{
		double arabic; 						// Made as a double so I can use it for my decimal cast and cast as an int later.
		int arabicDoubleConversionToInt;			// This will be used to conver arabic back to an integer
		Scanner input = new Scanner (System.in);
		
		do
		{
			System.out.print("Enter an integer (-1 to quit):  ");
			arabic = input.nextDouble();
			arabicDoubleConversionToInt = (int)arabic;			// Cast arabic of type double to an int
			caseValidations(arabic,arabicDoubleConversionToInt);
			
			if (arabicDoubleConversionToInt < 4000)			// As long as the number chosen is less than 4,000 it'll run as it 
			{												// should and won't print Roman number past 4,000.
				System.out.print(arabicToRoman((int)arabic));
				System.out.print("\n");
			}
			else
			{
				System.out.println ("This is above the expected range.");
			}
			System.out.print("\n");
			
			
		}while((arabic <= 0 || arabic == 3999 || arabic !=0) && arabic !=-1);
		
	}
	
	public static String arabicToRoman (int arabic)
	{
		
		StringBuilder roman = new StringBuilder("");// Roman is assigned as a string with nothing inherently coded for it to be,
													//  so it can be any Roman letter
	
	    while (arabic >= 1000) 						// For these loops, basically how it works is
	    {											// arabic is the number chosen that is deleted with say arabic -= 1000;
	        roman.append ("M"); 					// The only thing that is then left is the Roman Numeral.
	        arabic -= 1000;    						// If the user picks 3000, roman.append picks M,
	    }											// Then arabic = 3000 - 1000 which gives the remainder,
	    while (arabic >= 900) 						// This means that there is 2000 left to play with which means it'll print
	    {											// two more M's.
	    	roman.append ("CM");					// This is essentially how all the loops work.
	        arabic -= 900;							// The loops work by priority, so even though I picked say 1000,	
	    }											// that is greater or equal to 900, however it looks at the biggest number
	    while (arabic >= 500) 						// first which is 1000. The Key is that they're (Pre test loops).
	    {
	    	roman.append ("D");
	        arabic -= 500;
	    }
	    while (arabic >= 400) 
	    {
	    	roman.append ("CD");
	        arabic -= 400;
	    }
	    while (arabic >= 100)
	    {
	    	roman.append ("C");
	        arabic -= 100;
	    }
	    while (arabic >= 90) 
	    {
	    	roman.append ("XC");
	        arabic -= 90;
	    }
	    while (arabic >= 50)
	    {
	    	roman.append("L");
	        arabic -= 50;
	    }
	    while (arabic >= 40) 
	    {
	    	roman.append ("XL");
	        arabic -= 40;
	    }
	    while (arabic >= 10) 
	    {
	    	roman.append ("X");
	        arabic -= 10;
	    }
	    while (arabic >= 9) 
	    {
	    	roman.append ("IX");
	        arabic -= 9;
	    }
	    while (arabic >= 5) 
	    {
	    	roman.append ("V");
	        arabic -= 5;
	    }
	    while (arabic >= 4) 
	    {
	    	roman.append ("IV");
	        arabic -= 4;
	    }
	    while (arabic >= 1) 
	    {
	    	roman.append ("I");
	        arabic -= 1;
	        
	    }    
	    return roman.toString();
	}
	
	public static void caseValidations(double arabic, int arabicDoubleConversionToInt)	// Function takes care of all cases
	{																					// for validation	
		if(arabic % arabicDoubleConversionToInt !=0 && arabic !=0)						// I.E Fraction, Zero, Negative,
		{																				// Above range and ending the program.
			System.out.println("Fractional/Decimal Values aren't allowed, You choose: " + arabic);	 
		}
		else if (arabic == -1)
		{
			System.out.println ("Goodbye!");
		}
		
		else if (arabic <= 0 && arabic !=-1 )
		{
			System.out.println("The Romans didn't have a way to represent negative numbers or zero.");
		}
		
	}
	
}

/* Testing Plan.
// Case 1. Normal Case: I picked three numbers, 1 7 and 345, the reason I choose these is because they're good numbers
// within the allowed range and there's some variety from 1 to 7 to 345. The results were I, VII, CCCXLV
// 
// Case 2. Invalid Case: I again picked three numbers, 0, -6, -0.7, and 4,000, my reasons for this was because 0 and  
// -6 account for one of my cases, -0.7 accounts for the fractional case and the negative/zero case. 4,000 Tests the case
// where it's over the acceptable range. The results I got were, 
// "The Romans didn't have a way to represent negative numbers or zero,"
// "Fractional/Decimal Values aren't allowed, You choose whatever fractional value was choosen positive or negative.
// " This is above the expected range." After each of these it allowed the user to loop through the program.
//
// Case 3. Boundary Case: The range I'm restriced to is [1,3999], I picked the minimum and maximum values, and I recieved
// I and MMMCMXCIX
*/
