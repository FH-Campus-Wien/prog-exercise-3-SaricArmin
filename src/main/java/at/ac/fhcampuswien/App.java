package at.ac.fhcampuswien;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        oneMonthCalendar(31, 2);
//        lcg(12345);
//        guessingGame(12);
//        guessingGame(randomNumberBetweenOneAndHundred());
//        int[] input = new int[]{0, 0, 4, 4, 4, 8, 2, 9, 3};
//        System.out.print(checkDigit(input));
//        System.out.println(camelCase("AnY noise annoYs an oYster but a noisY noise annoYs an oYster more."));
//        System.out.print(camelCase("my name isn't Alice"));
    }
    public static void oneMonthCalendar(int days, int start)
    {
        int counter = start;
        for (int x = 1;x < start; x++)
        {
            System.out.print("   ");
        }
        for(int x = 1; x <= days; x++)
        {
            if (x <= 9)
            {
                System.out.print(" "+ x + " ");
            }
            else if (x >9)
            {
                System.out.print( x + " ");
            }
            if(counter == 7)
            {
                System.out.println();
                counter =0;
            }
            counter++;
        }
        if (days == 28)
        {
            System.out.println();
        }
    }
    public static long[] lcg(long seed)
    {
        long[] array = new long[10];
        long m = 2147483648L;
        long a = 1103515245L;
        long c = 12345;
        array[0] = ((a*seed)+c) % m;

        for (int x = 1; x < array.length; x++)
        {
            array[x] = (a*array[x-1]+c) % m;        //calc formula
        }
        return array;
    }

    public static void guessingGame(int numberToGuess)
    {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        boolean a = true;
        while(a)
        {
            System.out.print("Guess number " + counter + ": ");
            int nr = scanner.nextInt();

            if(numberToGuess < nr && counter != 10)
            {
                System.out.println("The number AI picked is lower than your guess.");
            }
            else if (numberToGuess > nr && counter != 10)
            {
                System.out.println("The number AI picked is higher than your guess.");
            }
            else if (numberToGuess == nr && counter != 10)
            {
                System.out.println("You won wisenheimer!");
                a = false;
            }
            if (counter == 10)
            {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                a = false;
            }
            counter++;
        }
    }
    public static int randomNumberBetweenOneAndHundred()
    {
        Random r = new Random();
        return r.nextInt(100)+1;
    }
    public static boolean swapArrays(int[] array1, int[] array2)
    {
        boolean a = false;
        if (array1.length == array2.length)
        {
            for(int x = 0; x < array1.length; x++)
            {
                array1[x] = array1[x] + array2[x];  // 9 + 3 = 12
                array2[x] = array1[x] - array2[x];  // 12 - 3 = 9
                array1[x] = array1[x] - array2[x];  // 12 - 9 = 3
            }
            a = true;
        }
        return a;
    }
    public static String camelCase(String str)
    {
        char c[] = str.toCharArray();
        String tmp = "";
        int ascii1 = c[0];
        if(c[0] >= 97 && c[0] <= 122)   //takes a lowercase char and makes it uppercase
        {
            c[0] = (char) (ascii1 - 32);
            tmp += c[0];
        }
        else
        {
            tmp += c[0];
        }
        for (int x = 1; x < c.length; x++)
        {
            int ascii = c[x];
            if (ascii == 33 || ascii == 34 || ascii == 39 || ascii == 44 || ascii == 46 || ascii == 63)     //checks if any special character
            {
                if(x+1 < c.length)      //checks if loop doesn't go out of bounds
                {
                    tmp = tmp + c[x+1];
                    x++;
                }
            }
            else if (ascii == 32)
            {
                if (c[x+1] >= 97 && c[x+1] <= 122)   //takes a lowercase char and makes it uppercase
                {
                    c[x+1] = (char)(c[x+1] - 32);   //calc for uppercase
                    if(x+1 < c.length)              //checks if loop doesn't go out of bounds
                    {
                        tmp = tmp + c[x+1];
                        x++;
                    }
                }
                else if (c[x+1] >= 65 && c[x+1] <= 90)      //if already uppercase
                {
                    {
                        tmp = tmp + c[x+1];
                        x++;
                    }
                }
            }
            else if (c[x] >= 65 && c[x] <= 90)      //takes an uppercase char and makes it lowercase
            {
                {
                    c[x] = (char) (c[x] + 32);      //calc for lowercase
                    tmp = tmp + c[x];
                }
            }
            else                                    //if none of the above apply just add to string
            {
                tmp = tmp + c[x];
            }
        }
        return tmp;
    }
    public static int checkDigit(int[] array)
    {
        int sum = 0;
        int diff = 0;
        for (int x =0; x < array.length; x++)
        {
            sum = sum + (2+x)*(array[x]);           //calc formula
        }
        int remainder = sum % 11;
        diff = (11 - remainder);
        if (diff == 11)
        {
            diff = 5;
        }
        if (diff == 10)
        {
            diff = 0;
        }
        return (diff);
    }

}