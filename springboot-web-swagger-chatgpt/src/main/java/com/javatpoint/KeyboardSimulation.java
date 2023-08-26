package com.javatpoint;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardSimulation {
	public static void main(String[] args) throws Exception {
		Robot robot = new Robot();
		while (true) {
			// Simulate typing a paragraph
			//String st = "I am writing a Java program for keyboard simulation. This program uses the Robot class to simulate key presses and releases. It can be used for various automation tasks that involve keyboard input. In this example, I am typing a paragraph using Java.";
			// String st = "I like to work in Truist Bank and open account";
			String st = "The Truist Zelle application embodies the future of digital banking, where convenience, speed, and security are paramount. As consumers increasingly rely on mobile devices for financial management, this innovative solution provides a valuable tool for simplifying monetary transactions and fostering financial inclusion";
			typeParagraph(robot,
					st);

			// Delay for 10 seconds before typing again
			Thread.sleep(10000);

			deleteEntireLine(robot);


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

	private static void deleteEntireLine(Robot robot) {

		// Press and hold the Shift key
		robot.keyPress(KeyEvent.VK_SHIFT);

		// Press the Home key to select from the cursor to the beginning of the line
		robot.keyPress(KeyEvent.VK_HOME);
		robot.keyRelease(KeyEvent.VK_HOME);

		// Release the Shift key to select the entire line
		robot.keyRelease(KeyEvent.VK_SHIFT);

		// Press the Delete key to delete the selected line
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.keyRelease(KeyEvent.VK_DELETE);

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
