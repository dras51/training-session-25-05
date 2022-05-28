import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //To create connection: connectionUrl, username, password
//        try{
//            String connectionUrl = "jdbc:mysql://localhost:3306/shop";
//            String user = "root";
//            String password = "asdfg12345";
//
//            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
//            System.out.println("Connection to database successful");
//
//            //Create table movies
////            String createTableQuery = "CREATE TABLE movies(id int(11) AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), genre VARCHAR(255), yearOfRelease INT(11));";
////
////            PreparedStatement preparedStatement = connection.prepareStatement(createTableQuery);
////            preparedStatement.execute();
//
//            //Add 3 records to the table
////            String query = "INSERT INTO movies(title, genre, yearOfRelease) VALUES('Doctor Strange', 'sci-fi', 2022),('Iron Man','Sci-fi',2019),('See for me', 'romance', 2021)";
//
//            //Update one selected record
////            String query = "UPDATE movies SET title='Dr Strange' WHERE id=1";
//
//            //DELETE record with specified ID
////            String query = "DELETE FROM movies WHERE id=1";
//
//            //Display all records in movies table
//            String query = "SELECT * FROM movies";
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.execute();
//
//            ResultSet result = preparedStatement.getResultSet();
//
//            while(result.next()) {
//                System.out.print(result.getInt("id") + " ");
//                System.out.print(result.getString("title") + " ");
//                System.out.print(result.getString("genre") + " ");
//                System.out.println(result.getInt("yearOfRelease"));
//
//            }


//            System.out.println("deleted successfully");
//        } catch (SQLException e){
//            e.printStackTrace();
//        }

        MovieDAOImpl movieDAOImpl = new MovieDAOImpl();
        movieDAOImpl.deleteTable();
    }
}
