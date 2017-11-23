package labExam1;

/**
 * Represents a single lab group, consisting of a group label and a time slot.
 */
public class LabGroup {

    private String label;
    private TimeSlot slot;

	/**
	 * Creates a new LabGroup based on the given specification: a single-character label,
	 * a space, and then a time-slot specification.
	 * 
	 * @param line The lab group specification in the above format
	 */
	public LabGroup(String line) {
	    label = line.substring(0,1);
	    slot = new TimeSlot(line.substring(1).trim());
	}

    public TimeSlot getTimes() {
        return slot;
    }

    public String getLabel() {
        return label;
    }

    public Time getStart(){
	    return slot.getStart();
    }

    public Time getEnd(){
        return slot.getEnd();
    }

    public String getDay(){
        return slot.getDay();
    }

}