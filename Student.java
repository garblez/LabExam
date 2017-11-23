package labExam1;

import java.util.*;


/**
 * Represents a student, based on their student number and a list of time slots
 * where they have a commitment.
 */
public class Student {


    private int number;
    private ArrayList<String> labDays = new ArrayList<>();

    private ArrayList<TimeSlot> labSlots = new ArrayList<>();
	/**
	 * Creates a new Student object based on the input parameters.
	 * 
	 * @param number
	 *            The student number
	 * @param slotSpecs
	 *            A list of time-slot specifications
	 */
	public Student(String number, List<String> slotSpecs) {
	    this.number = Integer.parseInt(number);

	    for (String slot: slotSpecs){
	        labSlots.add(new TimeSlot(slot));
        }

        for (TimeSlot time: labSlots){
            labDays.add(time.getDay());
        }

	}


    public int getStudentNumber() {
        return number;
    }




    public List<String> getLabGroups(Course course){
	    List<String> eligibleLabs = new ArrayList<>();
        List<LabGroup> courseLabs = course.getLabs();


        //System.out.println(labDays);

	    for (LabGroup courseLab: courseLabs){
	        for (TimeSlot time: labSlots){

	            if (!labDays.contains(courseLab.getDay()) && !eligibleLabs.contains(courseLab.getLabel())){
                    eligibleLabs.add(courseLab.getLabel());
                }

                else if (time.hasNoOverlap(courseLab.getTimes())){
                    eligibleLabs.add(courseLab.getLabel());
                }

            }
        }

	    return eligibleLabs;
    }
}