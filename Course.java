package labExam1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class to represent a course, including information on lab groups of the
 * course
 */
public class Course {
	private String name;
	// list of lab sessions for this course...
	private ArrayList<LabGroup> labs = new ArrayList<>();

	/**
	 * Creates a new Course based on the specification. The first element of the
	 * input list will represent the course name, and the rest will represent the
	 * lab groups.
	 * 
	 * @param lines
	 *            The lines read from the courses file.
	 */
	public Course(List<String> lines) {
        for (String line: lines){
            if (name == null) {
                name = line;
                continue;
            }
            labs.add(new LabGroup(line));
        }
	}



	public List<LabGroup> getLabs(){
	    return labs;
    }

    public String getName(){
	    return name;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append(name+"\n");
        for (LabGroup lab: labs){
            message.append(lab.getLabel() + " " + lab.getStart() + " - " + lab.getEnd() + "\n");
        }
        return message.toString();
    }
}