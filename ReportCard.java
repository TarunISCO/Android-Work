/*	Class to store the Result Card of Students.
 *	Name of Student is stored in a string variable
 *	Grades are integer value varying from 0 to 10 
 */


class ReportCard {
	private String studentName;
	private int physicsGrade;
	private int chemistryGrade;
	private int mathematicsGrade;
	private int englishGrade;
	private int computerGrade;

	// Constructor used when only name of student is provided while creating the object
	public ReportCard(String name) {
		this.studentName = name;
	}


	// Constructor used when grades are also provided while creating object
	public ReportCard(String name, int phGrade, int chGrade, int maGrade, int enGrade, int csGrade) {
		this.studentName = name;
		this.physicsGrade = phGrade;
		this.chemistryGrade = chGrade;
		this.mathematicsGrade = maGrade;
		this.englishGrade = enGrade;
		this.computerGrade = csGrade;
	}


	// Method to change the name of student
	public void changeName(String newName) {
		this.studentName = newName;
	}
	

	// Methods to set the grades
	public void setPhysicsGrade(int grade) {
		this.physicsGrade = grade;
	}

	public void setChemistryGrade(int grade) {
		this.chemistryGrade = grade;
	}

	public void setMathematicsGrade(int grade) {
		this.mathematicsGrade = grade;
	}

	public void setEnglishGrade(int grade) {
		this.englishGrade = grade;
	}

	public void setComputerGrade(int grade) {
		this.computerGrade = grade;
	}


	//Methods to get the grades
	public int getPhysicsGrade() {
		return this.physicsGrade;
	}

	public int getChemistryGrade() {
		return this.chemistryGrade;
	}

	public int getMathematicsGrade() {
		return this.mathematicsGrade;
	}

	public int getEnglishGrade() {
		return this.englishGrade;
	}

	public int getComputerGrade() {
		return this.computerGrade;
	}

	@Override
	public String toString() {
		String result = "";
		result = result + "Name : " + this.studentName + "; ";
		result = result + "Physics Grade : "  + this.physicsGrade + "; ";
		result = result + "Chemistry Grade : "  + this.chemistryGrade + "; ";
		result = result + "Mathematics Grade : "  + this.mathematicsGrade + "; ";
		result = result + "English Grade : "  + this.englishGrade + "; ";
		result = result + "Computer Grade : "  + this.computerGrade + "; ";

		return result;
	}
}