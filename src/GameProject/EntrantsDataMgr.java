package GameProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import GameProject.GameObject.Type;

public class EntrantsDataMgr {
	private String filePath = "./GameData/entrants_data.csv";
	public boolean CriminalIn = false;
	private int criminalindex;
	public ArrayList<EntrantData> entrants = new ArrayList<EntrantData>();
	
	public EntrantsDataMgr() {
		LoadData();
	}
	
	public void LoadData() {
		File datafile = new File(filePath);
		Scanner fin = null;
		try {
			fin = new Scanner(new FileInputStream(datafile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("can not fine datafile of entrants");
			e.printStackTrace();
		}
		
		ReadCSV(fin);
		for(EntrantData en : entrants) {
			System.out.println(en.getName());
		}
	}
	
	public void ReadCSV(Scanner scnr) {
		scnr.nextLine();
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
			
			Scanner rowScanner = new Scanner(line);
			rowScanner.useDelimiter(",");
			
			String name = rowScanner.next();
			String country = rowScanner.next();
			String city = rowScanner.next();
			String sex = rowScanner.next();
			
			EntrantData newEntrant = new EntrantData(name, country, city, sex);
			entrants.add(newEntrant);
		}
	}

	public EntrantData getRandomEntrant() {
		return entrants.get((int)(Math.random()*(entrants.size())-1));
	}
	
	
	public void whoiscriminal() {
		criminalindex = (int)(Math.random()*entrants.size());
	}
	
	public void iscriminal(int entrantindex) {
		if(criminalindex == entrantindex) {
			
		}
	}
}
