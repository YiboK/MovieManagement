package model;

/**
 * Movie Data Entity
 * @author 18223
 *
 */
public class MovieData {
	
	private String MovieID;
	private String MovieTitle;
	private String Description;
	private int Year;
	private int Runtime;
	private String IMDBid;
	private double Popularity;
	
	
	public MovieData() {
		super();
	}
	
	
	public MovieData(String movieID, String movieTitle, String description, int year, int runtime, String iMDBid, double popularity) {
		super();
		MovieID = movieID;
		MovieTitle = movieTitle;
		Description = description;
		Year = year;
		Runtime = runtime;
		IMDBid = iMDBid;
		Popularity = popularity;
	}



	public String getIMDBid() {
		return IMDBid;
	}


	public void setIMDBid(String iMDBid) {
		IMDBid = iMDBid;
	}


	public int getYear() {
		return Year;
	}


	public void setYear(int year) {
		Year = year;
	}


	public int getRuntime() {
		return Runtime;
	}


	public void setRuntime(int runtime) {
		Runtime = runtime;
	}


	public double getPopularity() {
		return Popularity;
	}


	public void setPopularity(double popularity) {
		Popularity = popularity;
	}


	public String getMovieID() {
		return MovieID;
	}





	public void setMovieID(String movieID) {
		MovieID = movieID;
	}





	public String getMovieTitle() {
		return MovieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		MovieTitle = movieTitle;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
