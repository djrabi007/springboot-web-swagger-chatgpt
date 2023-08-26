package com.javatpoint;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardSimulation {
	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		while (true) {
			// Simulate typing a paragraph
			//String st = "I am writing a Java program for keyboard simulation. This program uses the Robot class to simulate key presses and releases. It can be used for various automation tasks that involve keyboard input. In this example, I am typing a paragraph using Java.";
			String st = "I like to work in Truist  Bank and open account";
			typeParagraph(robot,
					st);

			// Delay for 10 seconds before typing again
			Thread.sleep(10000);


		}
	}

	// Helper method to type a paragraph
	private static void typeParagraph(Robot robot, String text) {
		for (char c : text.toCharArray()) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

			if (keyCode != KeyEvent.VK_UNDEFINED) {
				robot.keyPress(keyCode);
				robot.keyRelease(keyCode);
			} else {
				// Handle special characters, like spaces and newline
				if (c == ' ') {
					robot.keyPress(KeyEvent.VK_SPACE);
					robot.keyRelease(KeyEvent.VK_SPACE);
				} else if (c == '\n') {
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
				}
			}

			// Pause briefly between each key press
			try {
				Thread.sleep(50);

				ctrl_S_to_Save_File(robot);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void ctrl_S_to_Save_File(Robot robot) {
		// Press and hold the Ctrl key
		robot.keyPress(KeyEvent.VK_CONTROL);

		// Press the 'S' key
		robot.keyPress(KeyEvent.VK_S);

		// Release the 'S' key
		robot.keyRelease(KeyEvent.VK_S);

		// Release the Ctrl key
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
}
