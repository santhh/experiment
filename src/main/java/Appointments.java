import com.google.common.collect.ImmutableList;
import java.util.List;
//https://g3doc.corp.google.com/company/teams/sre/hiring/interview-questions/
// L6-code-review/appointments.md?cl=head
class Appointment{
  long start;
  long end;
  boolean hasConflict;
  public Appointment(long start, long end) throws Exception {
    // check start <= end
    if(start > end) throw new Exception("Start can't be later tha End");
    this.start=start;
    this.end = end;
    hasConflict = false;
  }
}
public class Appointments {
  public static void findConflicts(List<Appointment> appointments) {

    for (int i =0; i< appointments.size()-1; i++){
      if(appointments.get(i).end > appointments.get(i+1).start){
        appointments.get(i).hasConflict = true;
        appointments.get(i+1).hasConflict = true;

      }
    }
  }

  public static void main (String args[]) throws Exception {
    List<Appointment> appts = ImmutableList.of(new Appointment(1,9),new Appointment(15,20),
        new Appointment(20,25), new Appointment(21,50));
      findConflicts(appts);
    for (Appointment appt: appts) {
      System.out.println(appt.start+" "+appt.end+" "+appt.hasConflict);
    }

  }
}
