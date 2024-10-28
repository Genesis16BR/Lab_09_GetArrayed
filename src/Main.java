import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        // Declare an array of type int named dataPoints with a length of 100
        int[] dataPoints = new int[100];

        Random random = new Random();
        for (int i = 0; i < dataPoints.length; i++)
        {
            dataPoints[i] = random.nextInt(100) + 1;
        }

        // Printing the array to verify the random values
        System.out.println("Randomly initialized dataPoints array:");
        for (int i = 0; i < dataPoints.length; i++)
        {
            System.out.print(dataPoints[i] + " ");
        }


        // Displaying the dataPoints values separated by " | "
        System.out.println("DataPoints values: ");
        for (int i = 0; i < dataPoints.length; i++)
        {
            System.out.printf("%d", dataPoints[i]); // Print the value
            if (i < dataPoints.length - 1)
            {
                System.out.print(" | "); // Print separator if not the last element
            }
        }

        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++)
        {
            sum += dataPoints[i];
        }

        // Calculate the average of values in the dataPoints array
        double average = (double) sum / dataPoints.length;

        // Output the sum and average with descriptive sentences
        System.out.println("Calculating sum and average of the dataPoints array:");
        System.out.printf("The sum of the random array dataPoints is: %d%n", sum);
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        Scanner in = new Scanner(System.in);
        int userInput = SafeInput.getRangedInt(in,"Please enter an integer between 1 and 100: ", 1, 100);
        System.out.println("You entered: " + userInput);

        // Count how many times the user's value is found within the array
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++)
        {
            if (dataPoints[i] == userInput)
            {
                count++;
            }
        }

        // Output the count of the user's value found within the array
        System.out.printf("The value %d was found %d times in the dataPoints array.%n", userInput, count);

        // Prompt the user to input a value
        int userValue = SafeInput.getRangedInt(in,"Enter an integer between 1 and 100: ", 1, 100);

        // Iterate through the dataPoints array to find the user's value
        int foundIndex = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                foundIndex = i;
                break; // Short circuit the loop if the value is found
            }
        }

        // Output the result based on whether the value was found or not
        if (foundIndex != -1) {
            System.out.printf("The value %d was found at array index %d.%n", userValue, foundIndex);
        } else {
            System.out.printf("The value %d was not found in the dataPoints array.%n", userValue);
        }

        // Initialize min and max with the first element of the array
        int min = dataPoints[0];
        int max = dataPoints[0];

        // Iterate through the rest of the array to find the minimum and maximum values
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i]; // Update min if a smaller value is found
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i]; // Update max if a larger value is found
            }
        }

        // Display the minimum and maximum values to the user
        System.out.printf("The minimum value in the dataPoints array is: %d%n", min);
        System.out.printf("The maximum value in the dataPoints array is: %d%n", max);

        double[] values = {23.5, 45.2, 12.8, 67.4, 89.9}; // Sample array of double values

        // Call the getAverage method and store the result
        double mainAverage = getAverage(values);

        // Display the calculated average to the user
        System.out.printf("The average of the array is: %.2f%n", mainAverage);
    }

    public static double getAverage(double[] values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.length;
    }
}