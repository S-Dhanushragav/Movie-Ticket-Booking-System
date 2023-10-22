import java.util.*;

class User {
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class UserManager {
    private final Map<String, User> users;

    public UserManager() {
        users = new HashMap<>();
    }

    public void registerUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    public boolean loginUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}

class Movie {
    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class Seat {
    private final int seatNumber;
    private final int row;
    private final int column;
    private boolean isAvailable;

    public Seat(int seatNumber, int row, int column) {
        this.seatNumber = seatNumber;
        this.row = row;
        this.column = column;
        this.isAvailable = true;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void book() {
        isAvailable = false;
    }
}

class SeatSelection {
    private final List<Seat> seats;

    public SeatSelection(List<Seat> seats) {
        this.seats = seats;
    }

    public void displayAvailableSeats() {
        System.out.println("\nAvailable Seats:");
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                System.out.println("Seat Number: " + seat.getSeatNumber() +
                        ", Row: " + seat.getRow() +
                        ", Column: " + seat.getColumn());
            }
        }
    }

    public boolean bookSeat(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber && seat.isAvailable()) {
                seat.book();
                System.out.println("Seat booked successfully!");
                return true;
            }
        }
        System.out.println("Seat not available or invalid seat number.");
        return false;
    }
}

class Booking {
    private final String username;
    private final Movie movie;
    private final Seat seat;
    private final long timestamp;

    public Booking(String username, Movie movie, Seat seat) {
        this.username = username;
        this.movie = movie;
        this.seat = seat;
        this.timestamp = System.currentTimeMillis();
    }

    public String getUsername() {
        return username;
    }

    public Movie getMovie() {
        return movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

class BookingHistory {
    private final List<Booking> bookings;

    public BookingHistory() {
        bookings = new ArrayList<>();
    }

    public void addBooking(String username, Movie movie, Seat seat) {
        bookings.add(new Booking(username, movie, seat));
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}

public class MovieTicketBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // SignUp
        System.out.print("SignUp to start your booking --->");
        UserManager userManager = new UserManager();
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userManager.registerUser(username, password);
        System.out.println("User registered successfully.");

        // Login
        System.out.println();
        System.out.println("Login to your account --->");
        System.out.print("Enter your username to login: ");
        String loginUsername = scanner.nextLine();
        System.out.print("Enter your password to login: ");
        String loginPassword = scanner.nextLine();

        if (userManager.loginUser(loginUsername, loginPassword)) {
            System.out.println("Login successful. Welcome, " + loginUsername + "!");
        } else {
            System.out.println("Invalid username or password. Login failed.");
            System.exit(0);
        }

        // Available Movies
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Jailer"));
        movies.add(new Movie("Leo"));
        movies.add(new Movie("Pathaan"));

        // Movie Selection
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i + 1) + ". " + movies.get(i).getTitle());
        }
        System.out.print("Enter the number of the movie you want to watch: ");
        int selectedMovieIndex = scanner.nextInt();
        Movie selectedMovie = movies.get(selectedMovieIndex - 1);

        // Seat Selection
        List<Seat> seats = new ArrayList<>();
        // Create seats and add them to the list
        System.out.println("\nRow 1 Starts from the Screen.");
        seats.add(new Seat(1, 1, 1));
        seats.add(new Seat(2, 1, 2));
        seats.add(new Seat(3, 2, 2));
        seats.add(new Seat(4, 2, 3));
        seats.add(new Seat(5, 3, 3));
        seats.add(new Seat(6, 3, 4));
        seats.add(new Seat(7, 4, 1));
        seats.add(new Seat(8, 4, 4));

        SeatSelection seatSelection = new SeatSelection(seats);

        // Display available seats
        seatSelection.displayAvailableSeats();

        // Get user input for seat selection
        System.out.print("Enter the seat number you want to book: ");
        int selectedSeatNumber = scanner.nextInt();

        // Book the selected seat
        seatSelection.bookSeat(selectedSeatNumber);

        // Add the booking to the booking history
        BookingHistory bookingHistory = new BookingHistory();
        bookingHistory.addBooking(loginUsername, selectedMovie, seats.get(selectedSeatNumber - 1));

        // Display updated available seats
        seatSelection.displayAvailableSeats();

        // Display Booking History
        System.out.println("\nBooking History:");
        List<Booking> userBookings = bookingHistory.getBookings();
        for (Booking userBooking : userBookings) {
            System.out.println("Username: " + userBooking.getUsername());
            System.out.println("Movie: " + userBooking.getMovie().getTitle());
            System.out.println("Seat Number: " + userBooking.getSeat().getSeatNumber() +
                    ", Row: " + userBooking.getSeat().getRow() +
                    ", Column: " + userBooking.getSeat().getColumn());
            System.out.println("Booking Time: " + userBooking.getTimestamp());
            System.out.println();
        }
    }
}
