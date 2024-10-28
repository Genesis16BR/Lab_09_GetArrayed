import java.util.Scanner;

public class SafeInput
{
    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; //Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" + prompt + ": "); //show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int num = 0;
        boolean validInput = false;
        while (!validInput)
        {
            System.out.print(prompt);
            if (pipe.hasNextInt())
            {
                num = pipe.nextInt();
                validInput = true;
            } else
            {
                System.out.println("Invalid input. Please enter an integer.");
                // Clear the pipe by reading and discarding the trash
                pipe.next();
            }
        }
        // Clear the pipe after reading the value (the newline fix)
        pipe.nextLine();
        return num;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double num = 0.0;
        boolean validInput = false;
        while (!validInput)
        {
            System.out.print(prompt);
            if (pipe.hasNextDouble())
            {
                num = pipe.nextDouble();
                validInput = true;
            } else
            {
                System.out.println("Invalid input. Please enter a double value.");
                // Clear the pipe by reading and discarding the trash
                pipe.next();
            }
        }
        // Clear the pipe after reading the value (the newline fix)
        pipe.nextLine();
        return num;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int num = 0;
        boolean validInput = false;
        while (!validInput)
        {
            System.out.print(prompt);
            if (pipe.hasNextInt())
            {
                num = pipe.nextInt();
                if (num >= low && num <= high)
                {
                    validInput = true;
                } else
                {
                    System.out.println("Invalid input. Please enter an integer within the range [" + low + " - " + high + "].");
                }
            } else
            {
                System.out.println("Invalid input. Please enter an integer.");
                // Clear the pipe by reading and discarding the trash
                pipe.next();
            }
        }
        // Clear the pipe after reading the value (the newline fix)
        pipe.nextLine();
        return num;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double num = 0.0;
        boolean validInput = false;
        while (!validInput)
        {
            System.out.print(prompt);
            if (pipe.hasNextDouble())
            {
                num = pipe.nextDouble();
                if (num >= low && num <= high)
                {
                    validInput = true;
                } else
                {
                    System.out.println("Invalid input. Please enter a double value within the range [" + low + " - " + high + "].");
                }
            } else
            {
                System.out.println("Invalid input. Please enter a double value.");
                // Clear the pipe by reading and discarding the trash
                pipe.next();
            }
        }
        // Clear the pipe after reading the value (the newline fix)
        pipe.nextLine();
        return num;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean confirmed = false;
        boolean validInput = false;
        while (!validInput)
        {
            System.out.print(prompt);
            String input = pipe.next().trim().toLowerCase();
            if (input.equals("y"))
            {
                confirmed = true;
                validInput = true;
            } else if (input.equals("n"))
            {
                confirmed = false;
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter Y for Yes or N for No.");
            }
        }
        return confirmed;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String input = "";
        boolean validInput = false;
        while (!validInput)
        {
            System.out.print(prompt);
            input = pipe.nextLine().trim(); // Trim leading and trailing whitespaces
            if (input.matches(regEx))
            {
                validInput = true;
            } else
            {
                System.out.println("Invalid input. Please enter a string matching the pattern \"" + regEx + "\".");
            }
        }
        return input;
    }

    public static void prettyHeader(String msg)
    {
        int totalWidth = 60;
        int msgWidth = msg.length();
        int sideStars = (totalWidth - msgWidth - 6) / 2; // 6 stars for the padding on either side of the message

        // Print top row of stars
        for (int i = 0; i < totalWidth; i++)
        {
            System.out.print("*");
        }
        System.out.println();

        // Print second row with centered message
        System.out.print("***");
        for (int i = 0; i < sideStars; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < sideStars; i++)
        {
            System.out.print(" ");
        }
        // If the message length is odd, add one more space to maintain total width
        if (msgWidth % 2 != 0)
        {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print bottom row of stars
        for (int i = 0; i < totalWidth; i++)
        {
            System.out.print("*");
        }
        System.out.println();
    }

}