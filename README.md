# Movie-Ticket-Booking-System
INTRODUCTION:

The primary goal of this project was to design and implement a console-based movie ticket booking system using the Java programming language. The intention behind this endeavour was to create an intuitive, user-friendly interface that allows users to seamlessly interact with the system, providing them with the flexibility to choose movies, theatres, and specific seats for booking. The project aimed not only to fulfil these functional requirements but also to uphold essential software engineering principles such as modularity, simplicity, and educational value.

In the realm of software development, creating an interactive movie ticket booking system represents a quintessential challenge. It necessitates the harmonious integration of various programming concepts, ranging from object-oriented design principles to user input handling and data management. The significance of this project lies not only in its functionality but also in its potential educational value. By embracing best practices, employing modular coding techniques, and ensuring an intuitive user experience, the system can serve as a valuable learning resource for aspiring developers and enthusiasts alike.


OBJECTIVES AND SCOPE OF THE PROJECT:

Objectives:

	Develop a user-friendly movie ticket booking system to simplify the process of buying tickets for movies.
	Implement a secure user authentication system to ensure that only authorized users can access the booking platform.
	Provide a diverse selection of movies for users to choose from, including details such as movie title, genre, and duration.
	Enable users to view the available seats for a selected movie and choose their preferred seating arrangement.
	Simulate a payment gateway to allow users to make payments securely and confirm their bookings.
	Create a booking history feature to track and display users' past movie bookings.
	Ensure the system's scalability, allowing for easy addition of new movies and seats in the future.
	Implement error handling and validation mechanisms to enhance the robustness of the system.
	Provide a seamless and intuitive user experience, optimizing the system's usability and accessibility.

Scope:
	The project encompasses the development of a Java-based movie ticket booking application.
	The system will support user registration and login functionalities, ensuring secure access to the platform.
	Users can browse a catalog of available movies, displaying essential details about each film.
	The application will provide real-time information on seat availability for each movie screening.
	Users will have the flexibility to choose specific seats based on their preferences and availability.
	The system will simulate a payment gateway, allowing users to confirm their bookings securely.
	A booking history feature will be implemented to store and display users' past bookings.
	The project focuses on the backend logic and does not include extensive user interface design.
	The application will handle errors gracefully, providing appropriate feedback to users in case of invalid inputs or failed transactions.
	Future enhancements, such as integrating real payment gateways, can be considered but are not within the current scope of the project.

APPLICATION TOOLS

In a typical software development project like a movie ticket booking system, various tools and technologies are used to facilitate the development, testing, and deployment processes. Here are some common application tools that could be used for developing the project:

Programming Language:
Java: Java is the chosen programming language for this project due to its simplicity, portability, and extensive libraries, making it well-suited for building robust backend systems.

Integrated Development Environment (IDE):
IntelliJ IDEA: A powerful and user-friendly Java IDE that offers intelligent coding assistance, robust debugging capabilities, and excellent support for Java development. It is widely used by Java developers and provides a seamless development experience.



Version Control:
Git: Git is a distributed version control system that allows multiple developers to collaborate on a project. It tracks changes, enables branching and merging, and ensures version history is maintained effectively.
GitHub: GitHub is a web-based hosting service for Git repositories. It provides a platform for collaborative software development, offering features like issue tracking, pull requests, and project management tools.
Using Java as the programming language, IntelliJ IDEA as the IDE, and Git/GitHub for version control, developers can efficiently collaborate, write code, and maintain version history throughout the movie ticket booking system project.

METHODOLOGY

1. Requirement Analysis:
Identified core features: User registration, user authentication, movie selection, seat selection, booking, and booking history management.

2. Development:
User Management: Implemented user registration and authentication logic. Created the User and UserManager classes for managing user data and authentication processes.

Movie and Seat Management: Developed classes for managing movie data (Movie class) and seat availability (Seat class). Implemented seat selection and booking logic (SeatSelection class).

Booking and History: Created the Booking class to represent a booking, and BookingHistory class to manage booking history. Implemented logic to record and display user bookings.

Input Validation: Implemented input validation mechanisms to handle user inputs securely. Ensured the application can handle various input scenarios without crashing.

3. Execution and Output:
User Interaction: Enabled user interaction through the console interface. Users can register, log in, select movies, choose seats, and view booking history.

User Feedback: Provided feedback to users regarding successful operations, invalid inputs, and booking status. Ensured clear communication with the users throughout the booking process.

Error Handling: Implemented robust error handling to gracefully manage unexpected inputs and errors. Ensured the application does not crash and provides helpful error messages.

5. Documentation:
Code Documentation: Documented code extensively using comments to ensure readability and understanding for future developers.

6. Testing and Validation:
Conducted testing to validate individual components' functionality, ensuring each class works as intended. And made user(classmates) to test, gathered feedback and made necessary adjustments..

FLOWCHART
1.	Start

2.	User Registration:
	Get username and password from the user
	Register user in the system

3.	User Login:
	Get username and password from the user
	Validate user credentials
	If valid, proceed to movie selection; else, end the program

4.	Movie Selection:
	Display available movies
	Get user's choice of movie

5.	Seat Selection:
	Display available seats for the selected movie
	Get user's choice of seat
	If the seat is available, book the seat; else, ask for another choice

6.	Booking Confirmation:
	Confirm the booking
	Store the booking details

7.	Display Booking History:
	Display user's booking history

8.	End

Algorithm Implementation (Pseudocode):
1.	User Registration:

function registerUser():
    input username
    input password
    create new User object with username and password
    add User object to UserManager
    display "User registered successfully"

2.	User Login:

function loginUser():
    input username
    input password
    if UserManager.loginUser(username, password) is true:
        display "Login successful. Welcome, " + username + "!"
        return true
    else:
        display "Invalid username or password. Login failed."
        return false
3.	Movie Selection:

function selectMovie():
    display "Available Movies:"
    for each movie in movies:
        display movie.title
    input selectedMovieIndex
    return movies[selectedMovieIndex - 1]
4.	Seat Selection:

function selectSeat(seats):
    display "Available Seats:"
    for each seat in seats:
        if seat.isAvailable:
            display "Seat Number: " + seat.getSeatNumber() +
                    ", Row: " + seat.getRow() +
                    ", Column: " + seat.getColumn()
    input selectedSeatNumber
    if seats[selectedSeatNumber - 1].isAvailable:
        book the seat
        display "Seat booked successfully!"
        return seats[selectedSeatNumber - 1]
    else:
        display "Seat not available or invalid seat number."
        return null


5.	Booking Confirmation:

function confirmBooking(username, selectedMovie, selectedSeat):
    create new Booking object with username, selectedMovie, and selectedSeat
    add Booking object to BookingHistory

6.	Display Booking History:

function displayBookingHistory(bookingHistory):
    bookings = bookingHistory.getBookings()
    for each booking in bookings:
        display "Username: " + booking.getUsername()
        display "Movie: " + booking.getMovie().getTitle()
        display "Seat Number: " + booking.getSeat().getSeatNumber() +
                ", Row: " + booking.getSeat().getRow() +
                ", Column: " + booking.getSeat().getColumn()
        display "Booking Time: " + booking.getTimestamp()
