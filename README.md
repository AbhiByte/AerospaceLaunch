
  <h3 align="center">Launch GO NO-GO Procedure + Projectile Displacement Calculator</h3>

  <p align="center">
    ICS3U0 ISU Final Artifact!
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
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)



<!-- ABOUT THE PROJECT -->
## About The Project

This project aims to demonstrate the skills learned in ICS3U0 and explore how CS is used in Aerospace Engineering (focus on         Astronautical Engineering). The code comprises of packages, conditional statements, loops, methods and user input and allows the user (fictional launch director) to determine if it is safe to launch, as well as the indealistic range of the rocket as predicted by basic projectile motion equations
### Developed Using
This project was developed using the Eclipse IDE. Of course, such as project can be created using and software that suits you.
* [Eclipse](https://www.eclipse.org/downloads/)


<!-- GETTING STARTED -->
## Basic of CS integration in Astronautical Engineering

Computer science is used in all aspects of rockets. Having the ability for computers to make split-second decisions based on pre determined parameters is crucial to the safety and success of the rocket. For example software enables:
* Precise control of oxidizer and fuel into the combustion chamber
* Guidance and control of the vehicle including thrust vector control (where the nozel is vectrored to change the direction of the vehicle)
* Trajectory and orbit calculations and corrections
* Pretty much anything that can be automated, is, as this reduces error due to human intervention

## The Software

### CLass Methods

The launch parameter class methods allow the user to input mulitiple weather parameters into the system

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
		try {
		    Thread.sleep(2000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}//sleep
	public static double windLaunchpad (double windSpeed) {
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
NOTE: The first class method is the welcome method. This contains print statements to introduce the user to the program and tell the user what the software does. The second class method is code to delay the execution of the program

The following class methods contain parameters for wind, wind shear, cloud thickness and the distance to the cumulus clouds. These are just some of the parameters that engineers would look at before commiting to launch. Launching in bad weather is bad, so automatically pulling data from NOAA in the real world, would be tremedously usefull in having an up-to-date weather catalog

The trajectory class method allows the user to calculate the range of the projectile (rocket). Of course, this is heavily simplified, but serves as a demo to the type of software that is implemented in rockets

	public static double finalDisplacement (double velAtTop, double acceleration, double angle, double heightAtTop) {
		double Viy = Math.sin(angle * (Math.PI / 180)) * velAtTop;
		double time = (-1*Viy + Math.sqrt(Math.pow(Viy, 2)  - (4*0.5*acceleration*heightAtTop)))/(-1*acceleration);
		double Vx = Math.cos(angle *(Math.PI / 180)) * velAtTop;
		double displacementX = Vx * time * 2;
		
		System.out.println("The displacement of the rocket from the launch site is: " + Math.round(displacementX) + " meters");
		return displacementX;
This class method uses a basic projectile motion formula to solve for time, then calculates total displacement in the x axis. Time is calculated using the quadratic formula while Vx and Viy are calculated by breaking the vector "velAtTop" into its x and y components	
### Main Method
The main method is the heart of the program. This is where user input is taken, variables are assinged to those inputs and the class methods are called and ran

![Main Method](https://user-images.githubusercontent.com/64025335/84406797-0433a300-abd8-11ea-8fc0-d9c3562da8bc.gif)

The main method begins by defining the scanner input for user input. It then asks for specific user input for each of the class method parameters and assigns them to variables. Finally it calls on the class methods to be executed

## Usage

The program executes in the console as follows: 

![Console SS](https://user-images.githubusercontent.com/64025335/84409701-bf117000-abdb-11ea-9f0b-a821a589c0e0.png)

Observe how if the inputed parameter exceeds the limtitations set in the method (see full code for details), the user is told that the rocket is NOT go for launch. If however the inputed data is within the acceptable range, then they are told that the rocket is go for launch
For the real experience, copy the code into an IDE of your choice and run the code for yourself. You'll observe how the sleep() method adds a nice flow to the program (instead of it all being printed to the console at once)



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.



<!-- CONTACT -->
## Contact

Your Name - [@your_twitter](https://twitter.com/your_username) - email@example.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Img Shields](https://shields.io)
* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Pages](https://pages.github.com)
* [Animate.css](https://daneden.github.io/animate.css)
* [Loaders.css](https://connoratherton.com/loaders)
* [Slick Carousel](https://kenwheeler.github.io/slick)
* [Smooth Scroll](https://github.com/cferdinandi/smooth-scroll)
* [Sticky Kit](http://leafo.net/sticky-kit)
* [JVectorMap](http://jvectormap.com)
* [Font Awesome](https://fontawesome.com)





<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=flat-square
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=flat-square
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=flat-square
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=flat-square
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=flat-square
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png

