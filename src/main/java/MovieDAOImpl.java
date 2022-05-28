import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDAOImpl implements MovieDAO{
    Connection connection;
    String connectionUrl = "jdbc:mysql://localhost:3306/cinema";
    String user = "root";
    String password = "asdfg12345";

    public MovieDAOImpl() {
        try {
            connection = DriverManager.getConnection(connectionUrl, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTable() {
        try {
            String query = "CREATE TABLE movies(id int(11) AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), genre VARCHAR(255), yearOfRelease INT(11));";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e ){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTable() {
        try {
            String query= "DROP TABLE IF EXISTS movies";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createMovie(Movie movie) {
        try {
            String query = "INSERT INTO movies(title, genre, yearOfRelease) VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(3, movie.yearOfRelease);
            preparedStatement.setString(2, movie.genre);
            preparedStatement.setString(1, movie.title);

            preparedStatement.execute();
            preparedStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteMovie(int id) {
        try {
            String query = "DELETE FROM movies WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateMoviesTitle(int id, String newTitle) {
        try {
            String query = "UPDATE movies SET title=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newTitle);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Movie> findMovieById(int id) {
        try {
            String query = "SELECT * FROM movies where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet result = preparedStatement.getResultSet();
            Movie movie = new Movie();
            if(result.next()) {
                movie.title = result.getString("title");
                movie.genre = result.getString("genre");
                movie.yearOfRelease = result.getInt("yearOfRelease");
                movie.id = result.getInt("id");
            }

            return Optional.of(movie);
        } catch (SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Movie> findAll() {
        try {

            String query = "SELECT * FROM movies";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(query);

            List<Movie> movies = new ArrayList<>();
            while (result.next()) {
                Movie movie = new Movie();
                movie.title = result.getString("title");
                movie.genre = result.getString("genre");
                movie.yearOfRelease = result.getInt("yearOfRelease");
                movie.id = result.getInt("id");

                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
