import java.util.*;
public class AerospaceLaunch {
	// Abhinav Ramesh
    	// ICS3U0 ISU Artifact
	// Primitive launch go no-go calculator. User-inputed weather/climate parameters goes through methods and program will tell if it is safe to launch or not
	// June 12, 2020
	

	public static void main(String[] args) {
		// Will calculate if the launch is go or no-go based on user-inputed parameters
		
		//Define scanner input
		Scanner input = new Scanner (System.in);
		
		//Welcome message to user explaining how the program works
		welcome();
		sleep();
		System.out.println("\n");
		
		//Runs program while ALL parameters are met. If not met, program stops
	
		//Initial wind parameters (sustained wind at 49 m above launch pad and measured in knots)
		System.out.print("Input the sustained wind at 49 m above the launch pad (in knots): ");
		double windSpeed = input.nextDouble();
		windLaunchpad(windSpeed);
			
		//Upper level wind shear as provided by NOAA
		System.out.print("ENTER 'true' IF WIND SHEAR IS PRESENT. ENTER 'false' IF NOT PRESENT: ");
		boolean upperLvlWindShear = input.nextBoolean();
		windShear(upperLvlWindShear);
		
		//Checks for cloud layer greater than 4,500 feet (1,400 m) thick that extends into freezing temperatures. Do not launch if above given values
		System.out.print("Enter cloud thickness (meters): ");
		int cloudLayer = input.nextInt();
		sleep();
		System.out.print("Enter temperature at cloud top (celcius): ");
		int temp = input.nextInt();
		cloudThickness(cloudLayer, temp);
	
		//Distance to cumulus clouds (km)
		System.out.print("Enter distance to cumulus clouds from launch site (km): ");
		double cumulusDist = input.nextDouble();
		cumulusClouds(cumulusDist);
		
		//FinalEval
		System.out.print("Have you met ALL conditions (yes or no): ");
		String finalEval = input.next();
		finalCheck(finalEval);
		
		//Basic projectile motion calculator for rocket trajectory (real life is far more sophisticated)
		System.out.println("Enter velocity of rocket at top of ascent (m/s): ");
		double velAtTop = input.nextDouble();
		System.out.println("Enter acceleration due to gravity (m/s): ");
		double acceleration = input.nextDouble();
		System.out.println("Enter angle of elevation of rocket (deg): ");
		double angle = input.nextDouble();
		System.out.println("Enter maximum height (top of ascent) (m): ");
		double heightAtTop = input.nextDouble();
		finalDisplacement(velAtTop, acceleration, angle, heightAtTop);
		
	}//main
	
	//Launch parameter methods
	public static void welcome() {

		//Code for welcome message and explanation of program to user
		System.out.println("This is an official launch go no-go calculator");
		sleep();
		System.out.println("The following sequences will present parameters in accordance with S-301B launch weather criteria for the Falcon 9 ");
		sleep();
		System.out.println("It is your duty as launch director to accurately input and update data as provided by NOAA");
		sleep();
		System.out.println("Lets go!");
	}//welcome
	public static void sleep() {
		//code for delaying execution of program
		try {
		    Thread.sleep(2000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}//sleep
	public static double windLaunchpad (double windSpeed) {
		//Determines if wind speeds are acceptable or not
		if (windSpeed < 30)
		{
			System.out.println("Wind speed is within the acceptable range");
		}
		else if (windSpeed == 30)
		{
			System.out.println("Wind speed is acceptable but not prefered. Wait 10 mins and try again.");
		}
		else
		{
			System.out.println("DO NOT LAUNCH. WAIT 15 MINS AND TRY AGAIN");
		}
		return windSpeed;
	}
	public static boolean windShear (boolean upperLvlWindShear) {
		//Asks user if wind shear in upper atmosphere is present
		if (upperLvlWindShear == false)
		{
			System.out.println("Upper lvl wind shear does not pose threat to launch vehicle. Go for launch.");
		}
		else if (upperLvlWindShear == true)
		{
			System.out.println("Wind shear is present in the upper atmosphere. WAIT 30 MINS AND TRY AGAIN.");
		}
		return upperLvlWindShear;
	}
	public static int cloudThickness (int cloudLayer, int temp) {
		//Asks user for cloud thickness and temp at top of cloud
		if (cloudLayer < 1400 && temp > 0)
		{
			System.out.println("Conditions are go for launch");
		}
		else
		{
			System.out.println("CONDITIONS NOT MET. DO NOT LAUNCH");
		}
		return cloudLayer;
		
	}
	public static double cumulusClouds (double cumulusDist) {
		//Asks for distance to cumulus clouds
		if (cumulusDist <= 19)
		{
			System.out.println("DO NOT LAUNCH");
		}
		else
		{
			System.out.println("Condition met. Go for launch.");
		}
		return cumulusDist;
	}
	public static String finalCheck(String finalEval) {
		//Final check if all conditions are met or not
		if (finalEval.contentEquals("yes")) {
			System.out.println("Continue on to trajectory calculator...");
		}
		else if (finalEval.contentEquals("no")) {
			System.out.println("Conditions not met! NOT FO FOR LAUNCH");
		}
		else {
			System.out.println("Invalid data input...");
		}
		return finalEval;
	}
	
	//Trajectory method
	public static double finalDisplacement (double velAtTop, double acceleration, double angle, double heightAtTop) {
		//Determines trajectory of the rocket
		double Viy = Math.sin(angle * (Math.PI / 180)) * velAtTop;
		double time = (-1*Viy + Math.sqrt(Math.pow(Viy, 2)  - (4*0.5*acceleration*heightAtTop)))/(-1*acceleration);
		double Vx = Math.cos(angle *(Math.PI / 180)) * velAtTop;
		double displacementX = Vx * time * 2;
		
		System.out.println("The displacement of the rocket from the launch site is: " + Math.round(displacementX) + " meters");
		return displacementX;
	}
}//AerospaceLaunch
