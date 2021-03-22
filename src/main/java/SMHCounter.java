import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SMHCounter {
  private List<Integer> values;
  private int offset;
  private int minute;
  private int total;
  private final int MINUTE_COUNTER = 60;
  private final int HOUR_COUNTER = 3600;
  private enum Frequency{
    MINUTE,
    SECOND
  }

  public SMHCounter() {
    values = new ArrayList<>(HOUR_COUNTER);
    Collections.fill(values, 0);
    offset = 0;
    minute =0;
    total =0;
  }

  public void advance() {
    minute += values.get(offset);
    minute -=  values.get(offset - MINUTE_COUNTER);
    total += values.get(offset);
    offset = (offset + 1) % HOUR_COUNTER;
    total -= values.get(offset);
    values.set(offset, 0);

  }

  public void inc() {
    values.set(offset, values.get(offset) + 1);
  }

  public int getCounter(String v) {
    int result =0;
    if (v.equals(Frequency.SECOND)) {
      result =values.get(offset-1);
    }
    else if (v.equals(Frequency.MINUTE)) {
      result = minute;
    }else{
      result = total;
    }
    return result;
  }
}
