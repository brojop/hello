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
				/**
				 * This is where the first connection to the SQL database is formed
				 */
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
					ResultSet usernameResult = SQLcheck.executeQuery(); //Checks if user name exists in the table

					// Check if any rows are returned
					if (usernameResult.next()) {
					} else {
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
					ResultSet passwordResult = SQLcheck.executeQuery(); //checks if the password matches an existing one

					// Check if any rows are returned
					if (passwordResult.next()) {
						System.out.println("Successfully logged in!"); //if password matches, continues with the program
					} else {
						System.out.println("username or password is incorrect."); 
						//takes back to log in if incorrect credentials are entered
						continue;
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}

				while (true) {
					//once logged in, displays the account window
					Screens.accountWindow();
					userInput = s.next();

					switch (userInput) {

					//displays post window when selected
					case "P":
						
						//pulls data from Post table
						String statement3 = "SELECT * FROM Post";
						try {
							PreparedStatement SQLcheck = connection.prepareStatement(statement3);
							ResultSet postPrint = SQLcheck.executeQuery();
							while (postPrint.next()) {
								int columns = postPrint.getMetaData().getColumnCount();
								for (int i = 1; i <= columns; i++) {
									System.out.println(postPrint.getString(i));
								}
							}
						}

						catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Screens.postWindow();
						System.out.println("|  Current User :           " + Username + "         |");
						userInput = s.next();
						while (true) {
							switch (userInput) {
							case "+":
								//Adds new data into the Post table when the option is presented
								String postInsert = "INSERT INTO Post (username, postText, postTime) VALUES (?, ?, ?)";
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
								System.out.println("|  Current User :           " + Username + "         |");

								try {
									PreparedStatement SQLcheck = connection.prepareStatement(statement3);
									ResultSet postPrint = SQLcheck.executeQuery();
									while (postPrint.next()) {
										int columns = postPrint.getMetaData().getColumnCount();
										for (int i = 1; i <= columns; i++) {
											System.out.println(postPrint.getString(i));
										}
									}
								}

								catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								continue;

								//returns to previous window
							case "B":
								break;

								/**
								 * asks for a valid character if 
								 * a valid option isn't available
								 */
							default:
								System.out.println("Please enter a valid character: ");
								userInput = s.next();
								continue;
							}
							break;
						}
						continue;

						//properly displays visibility window
					case "V":
						Screens.visibilityWindow();
						System.out.println("|  Current User :           " + Username + "         |");
						userInput = s.next();
						while (true) {
							switch (userInput) {
							case "+":
								//adds new data into the Visibility table
								String visualInsert = "INSERT INTO Visibility ( username, visibleUsername) VALUES ( ?, ?)";
								System.out.println("Please decide who you want to see your posts ");
								String addVisual = s.next();
								try {
									PreparedStatement SQLInsert = connection.prepareStatement(visualInsert);

									SQLInsert.setString(1, Username);
									SQLInsert.setString(2, addVisual);
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

								break;

							case "-":
								//removes data from the Visibility table
								String sqlDelete = "DELETE FROM Visibility WHERE username = ? AND visibleUsername = ?";
								System.out.println("Who would you like to not see your posts");
								String deleteVisual = s.next();
								try {
									PreparedStatement SQLDelete = connection.prepareStatement(sqlDelete);
									SQLDelete.setString(1, Username);
									SQLDelete.setString(2, deleteVisual);
									int rowsDelete = SQLDelete.executeUpdate();
									if (rowsDelete > 0) {
										System.out.println("Data Deleted successfully!");
									} else {
										System.out.println("Failed to delete data.");
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;

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
					
						//returns to main window when current user is finished
					case "Q":
						break;

					default:
						System.out.println("Please enter a valid character.");
						userInput = s.next();
						continue;

					}
					close();
					break;
				}
			}
		}
	}

	private static void close() {
		return;
	}
}