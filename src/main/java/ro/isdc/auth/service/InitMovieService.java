package ro.isdc.auth.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.isdc.auth.domain.Movie;
import ro.isdc.auth.repository.MovieRepository;

@Service("initMovieService")
public class InitMovieService {

	private static final Logger log = Logger.getLogger(InitMovieService.class);

	@Autowired
	MovieRepository movieRepository;

	public final String[] genreList = { "Action", "Comedy", "Family", "History", "Sci-Fi", "Adventure", "Animation", "Drama", "Thriller", "Film-Noir", "Horror" };
	public final String[] directorList = { "J.J. Abrams", "Alfred Hitchcock", "Woody Allen", "Ron Howard", "Wes Andersen", "John Hughes", "M. Night Shyamalan", "Judd Apatow",
			"Peter Jackson", "George Lucas", "Quentin Tarantino" };
	public final String[] castList = { "Robert De Niro", "Nicolas Cage", "Al Pacino", "Jean Reno", "Tom Cruise", "Johnny Depp", "John Travolta", "Bruce Willis", "Will Smith",
			"Denzel Washington", "Morgan Freeman" };
	public final String[] peopleList = { "Paul Tamas", "Elemer Zagoni", "Felix Cosma", "Timea Balint", "Dan Cirja", "Ioana Mocan" };

	public void init() {

		List<Movie> movieList = new ArrayList<Movie>();
		Movie aMovie;
		/*
		 * Calendar loanDateCal; Calendar returnDateCal;
		 */

		for (int i = 0; i < 100; i++) {

			/*
			 * loanDateCal = new GregorianCalendar(randomNumGenerator(2006,
			 * 2013), randomNumGenerator(1, 12), randomNumGenerator(1, 28));
			 * returnDateCal = new
			 * GregorianCalendar(loanDateCal.get(Calendar.YEAR) + i,
			 * randomNumGenerator(1, 12), randomNumGenerator(1, 28));
			 */
			aMovie = new Movie();
			aMovie.setTitle("MovieTitle" + i);
			aMovie.setCast(castList[randomNumGenerator(0, castList.length - 1)] + ", " + castList[randomNumGenerator(0, castList.length - 1)]);
			aMovie.setDescription("This is a test movie description..."); // the
																			// same
			aMovie.setDirector(directorList[randomNumGenerator(0, directorList.length - 1)]); // random
			aMovie.setGenre(genreList[randomNumGenerator(0, genreList.length - 1)]); // random
			aMovie.setIdOnSite("testIdOnSite"); // the same
			aMovie.setLentTo(peopleList[randomNumGenerator(0, peopleList.length - 1)]); // random
			aMovie.setLoanDate(String.valueOf(System.currentTimeMillis())); // the
																			// //
																			// same
			aMovie.setMovieStatus(String.valueOf(randomNumGenerator(0, 3))); // random
			aMovie.setOwnMovieNotes("This is a test note for the movie " + i);
			aMovie.setRate(String.valueOf(randomNumGenerator(1, 10)));
			aMovie.setReturnDate(String.valueOf(Long.parseLong(aMovie.getLoanDate()) + randomLongNumGenerator(604800000l, 7889000000l))); // the
			// same
			aMovie.setRuntime(String.valueOf(randomNumGenerator(100, 120)));
			aMovie.setShelfLocation(String.valueOf(i)); // the iteration value
			aMovie.setSite("testSite");
			aMovie.setUserId("511b5517966284da3060fcc5");
			aMovie.setUserRating(String.valueOf(randomNumGenerator(0, 4)));
			aMovie.setYear(String.valueOf(randomNumGenerator(1990, 2012)));

			movieList.add(aMovie);
		}
		this.movieRepository.save(movieList);

	}

	public int randomNumGenerator(int min, int max) {
		return (min + (int) (Math.random() * ((max - min) + 1)));
	}

	// TODO: Delete this later
	public long randomLongNumGenerator(long min, long max) {
		return (min + (long) (Math.random() * ((max - min) + 1)));
	}
}
