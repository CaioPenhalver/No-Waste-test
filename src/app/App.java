package app;

import support.page_objects.HomePage;

public class App {

	public static void main(String... args){
		
		HomePage page = new HomePage();
		
		System.out.println(page.setPassword("112628").setUsername("CPR").login());
	}

}
