package labExam1;

/**
 * Represents a time slot: a day of the week, and a starting time and 
 * ending time.
 */
public class TimeSlot {

    private String day;
	private Time start;
	private Time end;

	/**
	 * Creates a new TimeSlot based on the specification.
	 * 
	 * @param spec The TimeSlot specification: a day, a starting time, and an ending time,
	 * separated by space characters
	 */
	public TimeSlot(String spec) {
	    String[] specs = spec.trim().split(" ");
	    day = specs[0];
	    start = new Time(specs[1]);
	    end = new Time(specs[2]);
	}

	public Time getStart(){
	    return start;
    }

    public Time getEnd(){
	    return end;
    }

    public String getDay() {
        return day;
    }

    // Checks if this time slot starts before the other slot and ends before or when the other starts
    public boolean isBefore(TimeSlot other){
        return this.getStart().precedes(other.getStart()) && this.getEnd().precedesOrEquals(other.getStart());
    }

    // Checks if this time slot starts after the other.
    public boolean isAfter(TimeSlot other){
        //return !this.getStart().precedes(other.getEnd()) && !this.getEnd().precedesOrEquals(other.getEnd());
        return other.getEnd().precedesOrEquals(this.getStart()) && other.getEnd().precedes(this.getEnd());
    }

    public boolean hasNoOverlap(TimeSlot other){
        if (this.getDay().equals(other.getDay()))
            return (this.isBefore(other) || this.isAfter(other));
        return false;
    }
}
