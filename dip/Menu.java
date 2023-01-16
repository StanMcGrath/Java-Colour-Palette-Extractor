package ie.gmit.dip;

import java.util.Scanner;

public class Menu {

	private Scanner s;
	private String filePath;
	private int thresholdChoice;
	private String saveFileName;
	private boolean keepRunning = true;
	private boolean keepRunning2 = false;
	private boolean keepRunning3 = false;

	/**
	 * @author Stan McGrath
	 * @version 1.0
	 * @since 1.8
	 * 
	 *        The Menu class prompts the user to specify parameters for the
	 *        PaletteMaker application. While loops and try-catches are used to
	 *        force correct input types. Once all parameters have been entered
	 *        correctly, the generatePalette() method is called.
	 */

	public Menu() {
		s = new Scanner(System.in);
	}

	public void start() throws Exception {
		System.out.println("");
		System.out.println("///////////////////////////////////");
		System.out.println("Welcome to Palette Extractor!");
		System.out.println("///////////////////////////////////");
		System.out.println("");

		while (keepRunning) {
			showOption1();
		}

		while (keepRunning2) {
			showOption2();
		}

		while (keepRunning3) {
			showOption3();
			generatePalette(thresholdChoice);

		}
	}

	/**
	 * The showOption1Text() method prompts the user to enter the filepath of the
	 * image file to be read from using a scanner to read input. The input is saved
	 * to the global string variable "filePath".
	 */

	private void showOption1() {
		System.out.println("[Sample FilePath Format:] C:\\Users\\PC\\Desktop\\FarahSolidGreen.png");
		System.out.println("");
		System.out.println("1) Please Enter the File Path of the Image you wish to generate a colour palette from, in the format shown above:");
		filePath = s.nextLine();
		System.out.println("");
		System.out.println("[INFO] Your chosen file path: " + filePath);
		System.out.println("");

		keepRunning = false;
		keepRunning2 = true;
	}

	private void showOption2() {
	    while (true) {
	        System.out.println("2) Please enter a threshold value between 10 and 100.");
	        System.out.println("The larger the value, the more extraneous pixel colours will be filtered out.");
	        System.out.println("Enter your threshold value now:");
	        try {
	            thresholdChoice = Integer.parseInt(s.nextLine());

	            if (thresholdChoice >= 10 && thresholdChoice <= 100) {
	                keepRunning2 = false;
	                keepRunning3 = true;
	                break;
	            } else {
	                System.out.println("[ERROR] Invalid input. Please enter a value between 10 and 100.");
	                System.out.println("");

	            }
	        } catch (NumberFormatException e) {
	            System.out.println("[ERROR] Invalid input. Please enter a numerical value.");
	            System.out.println("");

	            continue;
	        }
	    }
	}
	
	/**
	 * The method showOption3() prompts the user to specify the saved file name for
	 * the resultant Colour Palette. input is saved in the global variable
	 * "saveFileName".
	 */

	private void showOption3() {
		System.out.println("");
		System.out.println("3)Please Enter the File Name of the Colour Palette you wish to save:");
		saveFileName = s.nextLine();
		System.out.println("");
		System.out.println("[INFO] Your Colour Palette will be saved as: " + saveFileName);
		keepRunning3 = false;
	}

	/*
	 * The method generatePalette creates a new instance of the PaletteGenerator
	 * class and calls its method to generate the colour palette. After completion,
	 * the keepRunning variable is set to false so the menu closes.
	 */

	private void generatePalette(int thresholdChoice) throws Exception {

		System.out.println("[INFO] Generating Colour Palette... This may take a few moments...");

		PaletteGenerator pg = new PaletteGenerator();
		pg.setFilePath(filePath);
		pg.setSaveFileName(saveFileName);
		pg.generatePalette(thresholdChoice);

	}

}