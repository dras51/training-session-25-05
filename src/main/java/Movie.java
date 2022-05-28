public class Movie {
    int id;
    String title;
    String genre;
    int yearOfRelease;

    public Movie(int id, String title, String genre, int yearOfRelease) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }

    public Movie() {
    }

    public Movie(String title, String genre, int yearOfRelease) {
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }
}
