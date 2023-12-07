package unl.soc;

import java.sql.Connection;

public class Screens {
	Connection connection = Database.SQLconnect();
	static int users = Database.getnumberOfRows(null, null, null, null);
	static Class<User> Username = User.class;

	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_Green = "\u001B[32m";

	public static final String ANSI_Yellow = "\u001B[33m";

	public static final String ANSI_Blue = "\u001B[34m";

	public static final String ANSI_Cyan = "\u001B[36m";

	public static void mainWindow() {
		System.out.println(ANSI_Blue + " ========================================");
		System.out.println("|         Welcome to Jstgram!            |");
		System.out.println("|                                        |");
		System.out.println("|              *************             |");
		System.out.println("|                    *                   |");
		System.out.println("|                    *                   |");
		System.out.println("|                    *                   |");
		System.out.println("|                    *                   |");
		System.out.println("|              *     *                   |");
		System.out.println("|              *******                   |");
		System.out.println("|                                        |");
		System.out.println("|                                        |");
		System.out.println("|                                        |");
		System.out.println("|Current Number of users in database (" + users + ")  |");
		System.out.println("|                                        |");
		System.out.println("|                                        |");
		System.out.println(" ========================================" + ANSI_RESET);
	}

	public static void accountWindow() {
		System.out.println(ANSI_Green + " ========================================");
		System.out.println("|                                        |");
		System.out.println("| (P) Post                               |");
		System.out.println("| (V) Post Visibility                    |");
		System.out.println("| (Q) Quit                               |");
		System.out.println("|                                        |");

		System.out.println(" ========================================" + ANSI_RESET);
	}

	public static void postWindow() {
		System.out.println(" ========================================");
		System.out.println("|  My post and visible posts             |");
		System.out.println("|                                        |");
		System.out.println("|                                        |");
		System.out.println("|                                        |");
		System.out.println("| (+) Publish a new post                 |");
		System.out.println("| (B) Back                               |");
		System.out.println("|                                        |");

	}

	public static void visibilityWindow() {
		System.out.println(" ========================================");
		System.out.println("|                                        |");
		System.out.println("|   Your Posts are Visible to:           |");
		System.out.println("|                                        |");
		System.out.println("|   (+) Add a user                       |");
		System.out.println("|   (-) Delete a user                    |");
		System.out.println("|   (B) Back                             |");
		System.out.println("|                                        |");

	}

}