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
	    // Produce a list of specifications of the time slot [day, start time, end time].
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
        return other.getEnd().precedesOrEquals(this.getStart()) && other.getEnd().precedes(this.getEnd());
    }

    public boolean hasNoOverlap(TimeSlot other){
        return this.getDay().equals(other.getDay()) && (this.isBefore(other) || this.isAfter(other));
    }


    @Override
    public String toString() {
        return day + " "+ start + " - " + end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSlot timeSlot = (TimeSlot) o;

        if (day != null ? !day.equals(timeSlot.day) : timeSlot.day != null) return false;
        if (start != null ? !start.equals(timeSlot.start) : timeSlot.start != null) return false;
        return end != null ? end.equals(timeSlot.end) : timeSlot.end == null;
    }

    @Override
    public int hashCode() {
        int result = day != null ? day.hashCode() : 0;
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }
}
