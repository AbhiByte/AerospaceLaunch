
  <h3 align="center">Launch GO NO-GO Procedure + Projectile Displacement Calculator</h3>

  <p align="center">
    ICS3U0 ISU Final Artifact - Abhinav Ramesh
    <br />
    <a href=""><strong></strong></a>
    <br />
    <br />
    <a href=""></a>
    ·
    <a href=""></a>
    ·
    <a href=""></a>
  </p>
</p>



<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Developed Using](#developed-using)
* [Basics of CS integration in Astronautical Engineering](#basics-of-cs-integration-in-astronautical-engineering)
* [The Software](#the-software)
  * [Class Methods](#class-methods)
  * [Main Method](#main-method)
* [Usage and Execution](#usage-and-execution)
* [Final Thoughts](#final-thoughts)
* [References](#references)




<!-- ABOUT THE PROJECT -->
## About The Project

This project aims to demonstrate the skills learned in ICS3U0 and explore how CS is used in Aerospace Engineering (focus on         Astronautical Engineering). The code comprises of packages, conditional statements, loops, methods and user input and allows the user (fictional launch director) to determine if it is safe to launch, as well as the indealistic range of the rocket as predicted by basic projectile motion equations
### Developed Using
This project was developed using the Eclipse IDE. Of course, such a project can be created using any software that suits you.
* [Eclipse](https://www.eclipse.org/downloads/)


<!-- GETTING STARTED -->
## Basics of CS integration in Astronautical Engineering

Computer science is used in all aspects of rockets. Having the ability for computers to make split-second decisions based on pre determined parameters is crucial to the safety and success of the rocket. For example software enables:
* Precise control of oxidizer and fuel into the combustion chamber
* Guidance and control of the vehicle including thrust vector control (where the nozel is vectrored to change the direction of the vehicle)
* Trajectory and orbit calculations and corrections
* Pretty much anything that can be automated, is, as this reduces error due to human intervention

## The Software

### Class Methods

The launch parameter class methods allow the user to input mulitiple weather parameters into the system

```java
	 
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
//Code for delaying the program execution
	try {
	    Thread.sleep(2000);
	} catch (InterruptedException ie) {
	    Thread.currentThread().interrupt();
	}
}//sleep
public static double windLaunchpad (double windSpeed) {
//Code for determining if wind speed is acceptable
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
//Code for determining is wind shear is present or not
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
//Code for determining the cloud thickness and temp at top of cloud
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
//code for determining if cumulus clouds (which could spawn thunderstorms) are present
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
//Code for final evaluation by launch director if all conditions are met or not
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
```
NOTE: The first class method is the welcome method. This contains print statements to introduce the user to the program and tell the user what the software does. The second class method is code to delay the execution of the program

The following class methods contain parameters for wind, wind shear, cloud thickness and the distance to the cumulus clouds. These are just some of the parameters that engineers would look at before commiting to launch. Launching in bad weather is bad, so automatically pulling data from NOAA in the real world, would be tremedously usefull in having an up-to-date weather catalog

The trajectory class method allows the user to calculate the range of the projectile (rocket). Of course, this is heavily simplified, but serves as a demo to the type of software that is implemented in rockets
```java
public static double finalDisplacement (double velAtTop, double acceleration, double angle, double heightAtTop) {
//Determines the range of the projectile (rocket) using basic projectil motion equation(s)
	double Viy = Math.sin(angle * (Math.PI / 180)) * velAtTop;
	double time = (-1*Viy + Math.sqrt(Math.pow(Viy, 2)  - (4*0.5*acceleration*heightAtTop)))/(-1*acceleration);
	double Vx = Math.cos(angle *(Math.PI / 180)) * velAtTop;
	double displacementX = Vx * time * 2;

	System.out.println("The displacement of the rocket from the launch site is: " + Math.round(displacementX) + " meters");
	return displacementX;
```
This class method uses a basic projectile motion formula to solve for time, then calculates total displacement in the x axis. Time is calculated using the quadratic formula while Vx and Viy are calculated by breaking the vector "velAtTop" into its x and y components	
### Main Method
The main method is the heart of the program. This is where user input is taken, variables are assinged to those inputs and the class methods are called and ran

![Main Method](https://user-images.githubusercontent.com/64025335/84406797-0433a300-abd8-11ea-8fc0-d9c3562da8bc.gif)

The main method begins by defining the scanner input for user input. It then asks for specific user input for each of the class method parameters and assigns them to variables. Finally it calls on the class methods to be executed

## Usage and Execution

The program executes in the console as follows: 

![Console SS](https://user-images.githubusercontent.com/64025335/84409701-bf117000-abdb-11ea-9f0b-a821a589c0e0.png)

Observe how if the inputed parameter exceeds the limtitations set in the method (see full code for details), the user is told that the rocket is NOT go for launch. If however the inputed data is within the acceptable range, then they are told that the rocket is go for launch
For the real experience, copy the code into an IDE of your choice and run the code for yourself. You'll observe how the sleep() method adds a nice flow to the program (instead of it all being printed to the console at once)




## Final Thoughts
ICS3U0 was very fun and engaging. The course taught me the basics of java and helped improve my programming and problem solving skills. This code showcases some of the various skills and techniques learned throughout the course

Please refer to References section for additional reading and sources

Kindly also view the infographic made in conjunction with this project (linked below)


## Contact and Infographic

Abhinav Ramesh - [](632918@pdsb.net) 632918@pdsb.net

Project Link: [https://github.com/AbhiByte/ICS3U0-ISU-Artifact](https://github.com/AbhiByte/ICS3U0-ISU-Artifact)

Infographic: [https://create.piktochart.com/output/47262699-my-visual](https://create.piktochart.com/output/47262699-my-visual)




## References
* [NASA Launch Weather Criteria for Falcon 9](https://www.nasa.gov/pdf/649911main_051612_falcon9_weather_criteria.pdf)
* [Additional Reading on Launch Commit Criteria](https://en.wikipedia.org/wiki/Launch_commit_criteria)
* [README Format Adapted from othneildrew](https://github.com/othneildrew/Best-README-Template.git)







