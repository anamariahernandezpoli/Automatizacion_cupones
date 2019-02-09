package util;

import java.util.Random;

public class DataCustomer {
	
	private String [] name = {"Ana", "Bibiana", "Carlos", "Daniel", "Estefania", "Fabio", "Girlesa", "Hector", "Ismael", "Juan", 
			"Katherin", "Luis", "Mauricio","Nelson","Oscar","Pedro","Arturo","Rosa","Sara","Tatiana","Ursula","Victor","Wilson",
			"Ximena","Yeison","Zulma" };
	private String [] lastName = {"Alvarez", "Soto", "Cruz", "Diaz", "Escobar", "Franco", "Giraldo", "Villa", "Cespedes", "Jimenez", 
			"Osorio", "Lozano", "Marquez","Nieto","Osorno","Perez","Quiroz","Ruiz","Sanchez","Tabares","Usma","Valencia",
			"Granada", "Henao","Rivera","Zuluaga" };
	private String [] birthDate = {"3/05/1993", "23/05/1990", "1/07/1991", "30/08/1989", "7/12/1987", "3/03/1990", "22/09/1992", "12/11/1994",
			"01/01/1985", "01/01/1983"};
	private String addres;
	private String email;
	private String [] city = {"Medellin", "Cali", "Pereira", "Tunja", "Riohacha", "Manizalez", "Pasto", "Neiva", "Villavicencio", "Bogota"};
	private String [] state = {"Antioquia", "Valle del cauca", "Boyaca", "Cundinamarca", "Caldas", "Risaralda", "Nariño", "Meta", 
			"Guajira", "Huila"};
	private String number;
	private String [] pin = {"111111", "222222", "333333", "444444", "555555", "666666", "777777", "888888", "999999", "101010", 
			"121212", "131313", "141414", "151515", "161616", "171717", "181818", "191919", "202020", "212121"};
	private String [] password = {"aqzswsxec", "qwsxercdc", "effvdvfri", "ccecedvrp", "aaaaaaaaa", "bbbbbbbbb", "ccccccccc", "iiiiiiiii", "ooooooooo", "lllllllll"};
    Random rnd = rnd = new Random();
	int numRandon;
	
	
	public String getName() {	
		numRandon = (int) Math.round(Math.random() * 26 ) ;	
		return name[numRandon];
	}
	public String getLastName() {
		numRandon = (int) Math.round(Math.random() * 26 ) ;	
		return lastName[numRandon];
	}
	public String getAddres() {
		numRandon = (int) Math.round(Math.random() * 26 ) ;
		this.addres = "Calle " + numRandon + "  " + numRandon + " " + numRandon;
		return addres;
	}
	public String getEmail() {
		numRandon = (int) Math.round(Math.random() * 26 ) ;
		this.email = "prueba" + numRandon + "@hotmail.com";
		return email;
	}
	public String getCity() {
		numRandon = (int) Math.round(Math.random() * 10 ) ;
		return city[numRandon];
	}
	public String getState() {
		numRandon = (int) Math.round(Math.random() * 10 ) ;
		return state[numRandon];
	}
	public String getNumber() {
		numRandon = (int) Math.round(Math.random() * 299999999 ) + 999999999;
		this.number = Integer.toString(numRandon);
		return number;
	}
	public String getPin() {
		numRandon = (int) Math.round(Math.random() * 20 );
		return pin[numRandon];
	}
	public String getPassword() {
		numRandon = (int) Math.round(Math.random() * 10 ) ;		
		return password[numRandon];
	}
	
	public String getInitialDeposit() {
		String initialDeposit;		
		double numRandon = (double) Math.round(Math.random() * 100000 ) + 5000000 ;	
		initialDeposit = Double.toString(numRandon);
		return initialDeposit;
	}
	
	public String getIntoBirthDate() {
		numRandon = (int) Math.round(Math.random() * 10 ) ;		
		return birthDate[numRandon];
	}
	

	
	
	

}
