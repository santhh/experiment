import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Sequence {
  private int start;
  private int end;

  public Sequence() {}

  public Sequence(int i) {
    this.start = i;
    this.end = i;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public boolean Contains(int i) {
    return start <= i && end >= i;
  }

  public boolean isJustAfter(int i) {
    return i == end + 1;
  }

  public boolean isJustBefore(int i) {
    return i == start - 1;
  }
}

class DenseArray {

  private List<Sequence> values;
  private PriorityQueue<Integer> minHeap;
  private Set<Integer> valueSet;


  public DenseArray(int start) {
    values = new ArrayList<Sequence>();
    minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a));
    valueSet = new HashSet<>();


  }
  public  void update(){
     List<Sequence> collapseValues  = new ArrayList<>();
    Collections.sort(values, Comparator.comparingInt(s->s.getStart()));
    for (int i =0; i< values.size()-1; i++){
      if(values.get(i).getEnd() +1 >= values.get(i+1).getStart()){
        Sequence temp = new Sequence();
        temp.setStart(values.get(i).getStart());
        temp.setEnd(values.get(i+1).getEnd());
        collapseValues.add(temp);
      }else{
        collapseValues.add(values.get(i));
      }
    }
    if(collapseValues.size()>0)
      values = collapseValues;
  }

  public void insert(int i) {

     if(!valueSet.contains(i)) {
       minHeap.add(i);
       valueSet.add(i);
     }
    boolean foundIt = false;
    for (Sequence s : values) {
      if (s.Contains(i)) {
        foundIt = true;
        break;
      } else if (s.isJustAfter(i)) {
        s.setEnd(i);
        foundIt = true;
        break;
      } else if (s.isJustBefore(i)) {
        s.setStart(i);
        foundIt = true;
        break;
      }
    }

    if (!foundIt) {
      Sequence s = new Sequence(i);
      values.add(s);

    }
  }

  public boolean test1(int i) {
    if(!minHeap.isEmpty() && minHeap.peek()==i){
        minHeap.poll();
        return true;
    }
    return false;
  }

  public boolean test(int i) {
    for (Sequence s : values) {
      System.out.println(s.getStart() + " "+s.getEnd());
      if (s.Contains(i)) {
        return true;
      }
    }
    return false;
  }
}

public class Watermark {

  private DenseArray clockStream;
  private int startWaterMark;

  public Watermark(int startWaterMark)
  {
    clockStream = new DenseArray(startWaterMark);
    this.startWaterMark = startWaterMark;
  }
  public int getStartWaterMark(){
    return startWaterMark;
  }

 public void collapseClockValues(){
   clockStream.update();
 }

  public void RecordClock(int i) {
    clockStream.insert(i);
  }

  public int Calculate(int start) {
    int clock = start;
    while (clockStream.test1(++clock))
      ;
    return clock-1;
  }


  public static void main (String args[]){
    Watermark wm = new Watermark(0);
    wm.RecordClock(2);
    wm.RecordClock(1);
    wm.RecordClock(3);
    wm.RecordClock(2);
    wm.RecordClock(4);
    wm.collapseClockValues();
    System.out.println(wm.Calculate(wm.getStartWaterMark()));

  }

}