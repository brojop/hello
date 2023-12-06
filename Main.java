package unl.soc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			while (true) {
				Connection connection = Database.SQLconnect();
				Screens.mainWindow();
				String userInput;
				System.out.println("Enter your username: ");
				String Username = s.next();
				// check for username
				String statement1 = "SELECT * FROM Users WHERE username = ?";
				try (PreparedStatement SQLcheck = connection.prepareStatement(statement1)) {
					// Set the parameter value
					SQLcheck.setString(1, Username);

					// Execute the query
					ResultSet usernameResult = SQLcheck.executeQuery();

					// Check if any rows are returned
					if (usernameResult.next()) {
						System.out.println("Your username is in the Database");
					} else {
						System.out.println("Your username isn't in the Database");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// check for password

				System.out.println("Enter your password: ");
				String Password = s.next();
				String statement2 = "SELECT * FROM Users WHERE password = ?";
				try (PreparedStatement SQLcheck = connection.prepareStatement(statement2)) {
					// Set the parameter value
					SQLcheck.setString(1, Password);

					// Execute the query
					ResultSet passwordResult = SQLcheck.executeQuery();

					// Check if any rows are returned
					if (passwordResult.next()) {
						System.out.println("Your Password is in the Database");
					} else {
						System.out.println("Your Password isn't in the Database");
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

				Screens.accountWindow();
				userInput = s.next();

				switch (userInput) {

				case "P":
					Screens.postWindow();
					String statement3 = "SELECT * FROM Post";
					try {
						PreparedStatement SQLcheck = connection.prepareStatement(statement3);
						ResultSet postPrint = SQLcheck.executeQuery();
						while (postPrint.next()) {
							int columns = postPrint.getMetaData().getColumnCount();
							for (int i = 1; i <= columns; i++) {
								System.out.println(postPrint.getString(i) + "/=)");
							}
						}
					}

					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					userInput = s.next();
					while (true) {
						switch (userInput) {
						case "+":
							String postInsert = "INSERT INTO Post (username, postText, postTime) VALUES (?, ?, ?)\"";
							System.out.println("Please write your post: ");
							String firstWord = s.next();
							String words = s.nextLine();
							String fullSentence = firstWord + words;
							// add fullSentence into Post table(sql)
							try {
								PreparedStatement SQLInsert = connection.prepareStatement(postInsert);
								SQLInsert.setString(1, Username);
								SQLInsert.setString(2, fullSentence);
								SQLInsert.setString(3, Post.getPostTime());
								int rowsAdded = SQLInsert.executeUpdate();
								if (rowsAdded > 0) {
									System.out.println("Data inserted successfully!");
								} else {
									System.out.println("Failed to insert data.");
								}

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							
							Screens.postWindow();
							
							try {
								PreparedStatement SQLcheck = connection.prepareStatement(statement3);
								ResultSet postPrint = SQLcheck.executeQuery();
								while (postPrint.next()) {
									int columns = postPrint.getMetaData().getColumnCount();
									for (int i = 1; i <= columns; i++) {
										System.out.println(postPrint.getString(i) + "/=)");
									}
								}
							}

							catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							continue;

						case "B":
							break;

						default:
							System.out.println("Please enter a valid character: ");
							userInput = s.next();
							continue;
						}
						break;
					}
					continue;

				case "V":
					Screens.visibilityWindow();
					userInput = s.next();
					while (true) {
						switch (userInput) {
						case "+":

							continue;

						case "-":

							continue;

						case "B":
							break;

						default:
							System.out.println("Please enter a valid character");
							userInput = s.next();
							continue;
						}
						break;
					}
					continue;
				/**
				 * Admin window
				 * 
				 * case "M":
				 */
				case "Q":
					break;

				default:
					System.out.println("Please enter a valid character.");
					userInput = s.next();
					continue;

				}
				close();
			}

		}
	}

	private static void close() {
		return;
	}
}