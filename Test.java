package labExam1;

/**
 * @author Max A. Kolle
 */
public class Test {
    public static void main(String[] args){
        TimeSlot maths = new TimeSlot("Mon 14:00 17:00");
        TimeSlot compSci= new TimeSlot("Mon 15:00 17:00");
        System.out.println(maths.hasNoOverlap(compSci)? "Conflict!" : "All good!");
    }

}
