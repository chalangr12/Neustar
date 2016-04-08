import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Work {

	private int person;
	private int place;
	private int animal;
	private int computer;
	private int other;
	private ArrayList<String[]> lineList = null;

	public Work(ArrayList<String[]> list) {
		this.lineList = list;

	}

	public Work() {
		lineList = new ArrayList<String[]>();
	}

	public void parseFile(File fileName) throws IOException {
		if (fileName != null) {
			String line = ".";
			String catSubArray[] = null;
			ArrayList<String> list = new ArrayList<String>();
			try {
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);

				while ((line = bufferedReader.readLine()) != null) {
					line=line.trim();
					if (line.length() != 0) {
						boolean inList = true;
						catSubArray = new String[2];
						if (!list.contains(line) && line.split(" ").length > 1) {
							list.add(line);
							catSubArray[0] = line.split(" ")[0].trim();
							catSubArray[1] = line.split(" ", 2)[1].trim();
							inList = false;
						}
						

						if (!inList)
							if (catSubArray[0].equals("PERSON")  || 
								catSubArray[0].equals("PLACE")   || 
								catSubArray[0].equals("ANIMAL")  || 
								catSubArray[0].equals("COMPUTER")|| 
								catSubArray[0].equals("OTHER")) {
								lineList.add(catSubArray);
							}
					}
				}

				bufferedReader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("FILE NOT FOUND");
			}
		}

	}

	public void printList() {
		for (int ii = 0; ii < lineList.size(); ii++) {
			for (String str : lineList.get(ii)) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

	public void count() {

		for (int ii = 0; ii < lineList.size(); ii++) {
			if (lineList.get(ii)[0].equals("PERSON")) {
				person = person + 1;
				setPerson(person);
			} else if (lineList.get(ii)[0].equals("PLACE")) {
				place = place + 1;
				setPlace(place);
			} else if (lineList.get(ii)[0].equals("ANIMAL")) {
				animal = animal + 1;
				setAnimal(animal);
			} else if (lineList.get(ii)[0].equals("COMPUTER")) {
				computer = computer + 1;
				setComputer(computer);

			} else if (lineList.get(ii)[0].equals("OTHER")) {
				other = other + 1;
				setOther(other);
			} 
		}
	}

	public void printCount() {
		System.out.println("PERSON " + getPerson());
		System.out.println("PLACE " + getPlace());
		System.out.println("ANIMAL " + getAnimal());
		System.out.println("COMPUTER " + getComputer());
		System.out.println("OTHER " + getOther());

	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public int getAnimal() {
		return animal;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}

	public int getComputer() {
		return computer;
	}

	public void setComputer(int computer) {
		this.computer = computer;
	}

	public int getOther() {
		return other;
	}

	public void setOther(int other) {
		this.other = other;
	}
	
	public ArrayList<String[]> getLineList() {
		return lineList;
	}

	public void setLineList(ArrayList<String[]> lineList) {
		this.lineList = lineList;
	}
}
