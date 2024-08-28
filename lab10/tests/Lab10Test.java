package labs.lab10.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import labs.lab10.*;


public class Lab10Test {
	
	
	List<Movie> moviesList;
	
	//This method will be executed before all the other methods.
	@Before
	public void before() {
		String path = "res/"; //<- Assign the path of movies.txt to this variable. Do not include the file's name, it will be added below.
		moviesList = MoviesReader.readMovies(path + "movies.txt");	
	}

	@Test
	public void problem1() {
		assertEquals(23000, MoviesStats.problem1_countMovies(moviesList.stream())); // returns 23000
	}

	@Test
	public void problem2() {
		assertEquals(652,MoviesStats.problem2_countMoviesThatStartWith(moviesList.stream(), "A ")); 
		assertEquals(60,MoviesStats.problem2_countMoviesThatStartWith(moviesList.stream(), "An ")); 
		assertEquals(4806,MoviesStats.problem2_countMoviesThatStartWith(moviesList.stream(), "The ")); 
		assertEquals(112,MoviesStats.problem2_countMoviesThatStartWith(moviesList.stream(), "My ")); 
		assertEquals(116,MoviesStats.problem2_countMoviesThatStartWith(moviesList.stream(), "I ")); 
		assertEquals(4,MoviesStats.problem2_countMoviesThatStartWith(moviesList.stream(), "Nobody ")); 
	}

	@Test
	public void problem3() {
		String expectedResult = "The Assassination of Jesse James by the Coward Robert Ford, The Last Confederate: The Story of Robert Adams, FDR: Robert Vaughn One-Man Show, After Roberto, Debating Robert Lee, Bob Roberts, Mister Roberts, The Secret Passion of Robert Clayton, Master Spy: The Robert Hanssen Story";
		assertEquals(expectedResult,MoviesStats.problem3_getMoviesThatContainString(moviesList.stream(), "Robert"));		
	}

	@Test
	public void problem4() {
		String result = MoviesStats.problem4_countMoviesByYear(moviesList.stream(), 2000, 2005).toString();
		assertEquals("{2000=450, 2001=458, 2002=455, 2003=460, 2004=497, 2005=509}", result);
		result = MoviesStats.problem4_countMoviesByYear(moviesList.stream(), 1890, 1910).toString();
		assertEquals("{1896=1, 1901=1, 1904=1, 1905=1, 1906=1, 1908=21, 1909=27, 1910=25}", result);
	}

	@Test
	public void problem5_getMoviesWithActor() {
		String result = MoviesStats.problem5_getMoviesWithActor(moviesList.stream(), "Whitney Houston").toString(); 
		String expected = "[Name: Waiting to Exhale, Year: 1995, Directed by: [Forest Whitaker], Produced by: [Ronald Bass, Terry McMillan, Deborah Schindler, Ezra Swerdlow], " +
				"Actors: [Whitney Houston, Angela Bassett, Loretta Devine, Lela Rochon, Mykelti Williamson, Dennis Haysbert, Brandon Hammond, Michael Beach, Kenya Moore, Donald Faison, Wendell Pierce, Gregory Hines, Wesley Snipes, Kelly Preston, Jeffrey D. Sams, Jazz Raycole, E. Lamont Johnson, Wren T. Brown, Leon Robinson, Theo, Ken Love, Graham Galloway, Starletta Dupois, Shari L. Carpenter, Thomas R. Leander, Cordell Conway, Lee Wells Jr., Hope Brown, Delaina Mitchell, Joseph S. Myers, Luis Sharpe, Ezra Swerdlow, Ellin La Var, Patricia Anne Fox, Wally Bujack, Brenda Baldwin-Davis, Kacee DeMasi, Giancarlo Esposito, Wanda-Lee Evans, Tom Hedrick, Donyell Hinton, Bob Huff, Jose Rosete]" +
				", Name: The Bodyguard, " + 
				"Year: 1992, " + 
				"Directed by: [Mick Jackson], " + 
				"Produced by: [Kevin Costner, Lawrence Kasdan, Jim Wilson], " + 
				"Actors: [Kevin Costner, Whitney Houston, Gary Kemp, Bill Cobbs, Tomas Arana, Ralph Waite, Mike Starr, Robert Wuhl, Debbie Reynolds, Richard Schiff, Nathaniel Parker, Michele Lamar Richards, Christopher Birt, DeVaughn Nixon, Gerry Bamman, Joe Urla, Tony Pierce, Charles Keating, Danny Kamin, Ethel Ayler, Sean Cheesman, Chris Connelly, Bert Remsen, Donald Hotton, Nita Whitaker, Patricia Healy, Blumen Young, Rob Sullivan, Jennifer Lyon-Buchanan, Stephen Shellen, Victoria Bass, Abbey Vine, Phil Redrow, Joe Hess, Marta Velasco, Joe Unger, Gwen Seliger, Susan Traylor, Pat Van Patten, Shelley A. Hill, Amy Lou Dempsey, Rosie Lee Hooks, Ken Myles, Robert L. Feist, Charles Bazaldua, Tracye Logan, Art Spaan, Douglas Price, Ellin La Var, Joseph Zabrosky, Rollin Jarrett, David M. Morano, Carla Lizzette Mejia, Linda Thompson, David Foster, Towanna King, Shaun Earl, John Hartman, Al Kamarr, Dan Koko, David Joseph Martinez, L.A. Rothman, John Tesh, Mark Thomason]" +
				", Name: The Preacher's Wife, " + 
				"Year: 1996, " + 
				"Directed by: [Penny Marshall], " + 
				"Produced by: [Samuel Goldwyn Jr.], " + 
				"Actors: [Denzel Washington, Whitney Houston, Jenifer Lewis, Loretta Devine, Courtney B. Vance, Gregory Hines, Darvel Davis Jr., William James Stiggers Jr., Lex Monson, Paul Bates, Marcella Lowery, Cissy Houston, Justin Pierre Edmund, Lionel Richie]" + 
				", Name: Sparkle, " + 
				"Year: 2012, " + 
				"Directed by: [Salim Akil], " +
				"Produced by: [Debra Martin Chase, T. D. Jakes, Curtis Wallace, Mara Brock Akil, Salim Akil], " + 
				"Actors: [Tika Sumpter, Whitney Houston, Mike Epps, Carmen Ejogo, Cee Lo Green, Omari Hardwick, Derek Luke, Tamela Mann, Terrence J, Jordin Sparks, Michael Beach, Curtis Armstrong, Brely Evans, Brittany Perry-Russell, Linda Boston, Michael W. Campbell Jr., Sidi Henderson, Erika Hoveland, Debra Port, Kem, Doug Mingo, Mark Rademacher, David Regal, Cory Pritchett, Howard Rosenman, Robert Forte Shannon III, Margaret Scott, Goapele, Fatima Morris, Keeley Morris, Charmaine Jordan, Dalibor Stolevski, Tiffany Alexander, Temecha Myers, Stephanie Moseley, Ruth E. Carter, Melora Rivera, Delaney Baynham II, Deborah Claybaugh, Deborah Claybaugh, Arnold Agee, Lynn Anderson, Toya D. Brazell, Michael Stephen Bryant, Michael B. Clark, Andrew Dow, Sabrina Dungan, Tiffani Elise Edwards, Helena Ellison, James Feaheny, Jacqueline Forton, Steve Gast, Pam German, David Glahn, Ron Heisler, Tim Jenkins, Krystal Katz, Abe Larkin, Norine Marsh, Ralph H. Meyer, Mikal, Da'Ron Mitchell, Da'Ron Mitchell, Jill Opal Oliver, Terri Partyka, Krishawn Peace, Ryan Pearson, Vincent Pelligrino, Jeff Ponders, DaJuan Rippy, Nicholas Ritz, Julie Ariane Russell, Stephanie Schaberg, Kristyn Shelley, Gary Lee Simpson, Nikki Smith, Eric Adam Swenson, Eric Tuchelske, Mark Allan White, Mozi Zhuli, Sarah Hansen, Shirley Moon Koebbe, Connie Sonnenberg]" + 
				"]";
		assertEquals(expected, result);		
	}

	@Test
	public void problem5_getMoviesDirectedBy() {
		String result = MoviesStats.problem5_getMoviesDirectedBy(moviesList.stream(), "J.J. Abrams").toString(); 
		String expected = "[Name: Anatomy of Hope, Year: 2009, Directed by: [J.J. Abrams], Produced by: [], Actors: [Joey King, Deepti Daryanani]" + 
				", Name: Super 8, Year: 2011, Directed by: [J.J. Abrams], Produced by: [J.J. Abrams, Bryan Burk, Steven Spielberg], Actors: [Elle Fanning, AJ Michalka, Kyle Chandler, Ron Eldard, Noah Emmerich, Gabriel Basso, Zach Mills, Joel Courtney, Riley Griffiths, James HÃ©bert, Thomas F. Duffy, Katie Lowes, Ryan Lee, Marco Sanchez, Teri Clark, Joel McKinnon Miller, Jessica Tuck, David Gallagher, Jade Griffiths, Andrew Miller, Jakob Miller, Britt Flatmo, Bruce Greenwood, Glynn Turman, Richard T. Jones, Amanda Foreman, Brett Rice, Michael Giacchino, Beau Knapp, Dale Dickey, Jack Axelrod, Dan Castellaneta, Ben Gavin, Jay Scully, Michael Hitchcock, Tom Quinn, Kate Yerves, Caitriona Balfe, Koa Melvin, Tom Williams, Bingo O'Malley, Tony Guma, Robert B. Quiroz, Jason Brooks, Tim Griffin, Emerson Brooks, Jonathan Dixon, Patrick St. Esprit, Greg Grunberg, Daniel Aldema, Michael Guy Allen, Barrett Carnahan, Graham Clarke, Andrew Constantini, Matthew Crawley, Mike DeMille, Mel Fair, Danielle Laudise, Sara Lindsey, Bill Martin, Scott A. Martin, Tiffany Sander McKenzie, Jake McLaughlin, Alex Nevil, Sadie, Tom Shafer, Zoltan Zilai]]";
		assertEquals(expected, result);	
		
	}

	@Test
	public void problem5_getMoviesProducedBy() {
		String result = MoviesStats.problem5_getMoviesProducedBy(moviesList.stream(), "Gail Mutrux").toString();
		String expected = "[Name: Kinsey, " + 
				"Year: 2004, " + 
				"Directed by: [Bill Condon], " + 
				"Produced by: [Gail Mutrux], " +
				"Actors: [Liam Neeson, Laura Linney, Peter Sarsgaard, Chris O'Donnell, Timothy Hutton, Julianne Nicholson, Dylan Baker, John Lithgow, Oliver Platt, William Sadler, Tim Curry, Luke Macfarlane, Heather Goldenhersh, Veronica Cartwright, Kathleen Chalfant, John Krasinski, John McMartin, Dagmara DomiÅ„czyk, Arden Myrin, Harley Cross, Susan Blommaert, Benjamin Walker, Matthew Fahey, Will Denton, Romulus Linney, Katharine Houghton, David Harbour, Judith J.K. Polson, Leigh Spofford, Jenna Gavigan, Mike Thurstlic, Jarlath Conroy, Bill Buell, Michelle Federer, Alvin Keith, Amy Wilson, Maryellen Owens, Roderick Hill, Peg Small, Don Sparks, Joe Zaloom, Kate Reinders, Mara Hobel, Lindsay Schmidt, Jason Patrick Sands, Marcel Simoneau, Bobby Steggert, Johnny Pruitt, John Epperson, Jefferson Mays, Mark Mineart, Martin Murphy, Kate Jennings Grant, Barry Del Sherman, Fred Burrell, Michael Arkin, Dan Ziskie, Tuck Milligan, Edwin McDonough, John Ellison Conlee, Arthur French, Chandler Williams, Jaime Roman Tirelli, Draper Shreeve, Philip Kushner, Joseph Badalucco Jr., Henrietta Mantooth, Doris Smith, Reno, Pascale Armand, Sean Skelton, Steven Edward Hart, Clifford David, Randy Redd, Lynn Redgrave, Beth Adubato, Michael L. Bash, Maria Bianco, David E. Fischer, Brute Force, Christy Lee Hughes, Deric McNish, Kevin Kean Murphy, Katherine O'Sullivan, Amber Paul, Dina Plotch, Richard Preshong, Cameron Stevens, Alexander Wraith, Liam Neeson]" + 
				", Name: Donnie Brasco, " + 
				"Year: 1997, " + 
				"Directed by: [Mike Newell], " + 
				"Produced by: [Louis DiGiaimo, Gail Mutrux, Barry Levinson, Mark Johnson], " + 
				"Actors: [Johnny Depp, Al Pacino, Michael Madsen, Anne Heche, Bruno Kirby, Å½eljko Ivanek, James Russo, Paul Giamatti, Robert Miano, Gerry Becker, Brian Tarantina, Rocco Sisto, Zach Grenier, Ronnie Farer, Walt MacPherson, Terry Serpico, Tim Blake Nelson, James Michael McCauley, James Bulleit, Andrew Parks, Keenan Shimizu, Rocco Musacchia, Joe Francis, Gretchen Mol, Tony Lip, George Angelica, Val Avery, Madison Arnold, Delanie Fitzpatrick, Katie Sagona, Sara Gold, Larry Romano, Sal Jenco, Billy Capucilli, Laura Cahill, Doreen Murphy, Elle Alexander, Denise Faye, Elaine del Valle, John Horton, Dan Brennan, LaJuan Carter, Sandy B, Joyce Stovall, Frank Pesce, Randy Jurgensen, John Di Benedetto, Richard Zavaglia, Tony Ray Rossi, Edward Black, Gaetano LoGiudice, Carmelo Musacchia, Pat Vecchio, Caleb, Frank Bonsangue, Christopher Del Gaudio, Jim Lavin, Jeff Millstein, Lisa Marie Panagos, Garry Pastore, Larry Tobias, Edward Williams, Barry Hirschberg]" + 
				", Name: Nurse Betty, " + 
				"Year: 2000, " + 
				"Directed by: [Neil LaBute], " + 
				"Produced by: [Steve Golin, Gail Mutrux], " + 
				"Actors: [RenÃ©e Zellweger, Chris Rock, Greg Kinnear, Sung-Hi Lee, Morgan Freeman, Pruitt Taylor Vince, Tia Texada, Allison Janney, Aaron Eckhart, Crispin Glover, Elizabeth Mitchell]" + 
				", Name: A Cool, Dry Place, " + 
				"Year: 1999, " + 
				"Directed by: [John N. Smith], " + 
				"Produced by: [Katie Jacobs, Gail Mutrux], " + 
				"Actors: [Vince Vaughn, Joey Lauren Adams, Monica Potter, Chris Bauer, Nicholas Campbell, Todd Louiso, Jenny Robertson, Devon Sawa, Siobhan Fallon Hogan, Bobby Moat]" + 
				", Name: The Shape of Things, " + 
				"Year: 2003, " + 
				"Directed by: [Neil LaBute], " + 
				"Produced by: [Neil LaBute, Tim Bevan, Eric Fellner, Rachel Weisz, Philip Steuer, Gail Mutrux], " + 
				"Actors: [Gretchen Mol, Paul Rudd, Rachel Weisz, Fred Weller]" + 
				", Name: Number 13, " + 
				"Year: 2011, " + 
				"Directed by: [Chase Palmer], " + 
				"Produced by: [Gail Mutrux], " + 
				"Actors: [Ben Kingsley, Emily Mortimer]" + 
				", Name: The Danish Girl, " + 
				"Year: 0, " + 
				"Directed by: [Lasse HallstrÃ¶m], " + 
				"Produced by: [Nicole Kidman, Linda Reisman, Gail Mutrux], " + 
				"Actors: [Nicole Kidman, Uma Thurman, Rachel Weisz]" + 
				"]";
		assertEquals(expected, result);	
	}

	@Test
	public void problem6_countActors() {
		long expected = 136993;
		long result = MoviesStats.problem6_countActors(moviesList.stream()); // returns 136993
		assertEquals(expected, result);	
	}

	@Test
	public void problem6_countDirectors() {
		long expected = 10295;
		long result = MoviesStats.problem6_countDirectors(moviesList.stream()); // returns 10295
		assertEquals(expected, result);	
	}

	@Test
	public void problem6_countProducers() {
		long expected = 13741;
		long result = MoviesStats.problem6_countProducers(moviesList.stream()); // returns 13741
		assertEquals(expected, result);	
	}

	@Test
	public void problem7_averageNumActors() {
		double result = MoviesStats.problem7_averageNumActors(moviesList.stream()); // returns 13.066478260869566
		assertEquals(true, result>13.0 && result <13.1);
	}

	@Test
	public void problem7_averageNumDirectors() {
		double result = MoviesStats.problem7_averageNumDirectors(moviesList.stream()); // returns 1.071652173913043
		assertEquals(true, result>1.0 && result <1.1);
	}

	@Test
	public void problem7_averageNumProducers() {
		double result = MoviesStats.problem7_averageNumProducers(moviesList.stream()); // returns 1.5232608695652174
		assertEquals(true, result>1.5 && result <1.6);
	}

	@Test
	public void problem8() {
		String result = MoviesStats.problem8_moviesWithNWordsInTitle(moviesList.stream(), 13).toString(); 
		String expected = "[Name: In the Kingdom of the Blind, the Man with One Eye Is King, " +
				"Year: 1995, " + 
				"Directed by: [Nick Vallelonga], " + 
				"Produced by: [], " + 
				"Actors: [William Petersen, Michael Biehn, Khalil Kain, Paul Winfield, Leo Rossi, Kristian Alfonso, Tony DiBenedetto, Nick Vallelonga, Michael Cavalieri, Tony Lip]" + 
				"]";
		assertEquals(expected, result);	
	}

	@Test
	public void problem9() {
		Optional<Movie> oldest = MoviesStats.problem9_oldestMovie(moviesList.stream());
		assertEquals(true, oldest.isPresent());
		if (oldest.isPresent()) {
			Movie result = oldest.get();
			String expected = "Name: Rip Van Winkle, " + 
					"Year: 1896, " +  
					"Directed by: [William Kennedy Dickson], " +  
					"Produced by: [], " +  
					"Actors: [Joseph Jefferson]"; 
			assertEquals(expected, result.toString());
		}
	}

	@Test
	public void problem10() {
		Optional<Movie> newest = MoviesStats.problem10_newestMovie(moviesList.stream());
		assertEquals(true, newest.isPresent());
		
		if (newest.isPresent()) {
			Movie result = newest.get();
			String expected = "Name: Avatar 3, " +  
					"Year: 2017, " +  
					"Directed by: [James Cameron], " +  
					"Produced by: [James Cameron, Jon Landau], " +  
					"Actors: [Zoe Saldana]"; 
			assertEquals(expected, result.toString());
		}
	}

}
