package giorno1;

public class Main {

	public static void main(String[] args) {
		
		DB db = new DB();
		db.connect();
		
		boolean insertStudent = true;
		if( insertStudent ) {
			Student s1 = new Student("ciccio", "bianchi","1992-03-02", "m",  7, 6, 9);	
			db.insertStudent(s1);
		}
		/*
		 *
		boolean updateStudent = false;
		if( updateStudent ) {
			db.updateStudent("Alba Rossi", 5);
		}
		*/
		boolean deleteStudent = false;
		if( deleteStudent ) {
			db.deleteStudent(6);
		}
		
		boolean getBest = false;
		if(getBest) {
			db.getBest();
		}
		/*
		boolean showStudents = true;
		if( showStudents ) {
			db.selectAllStudents();
		}
		*/
		
	    boolean getVoteRange = true;
	    if(getVoteRange) {
	    db.getVoteRange(2, 6);
	    }
	    
	    
	    
		db.disconnect();
	}

}
