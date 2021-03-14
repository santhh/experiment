import java.util.ArrayDeque;
import java.util.Deque;

public class StringIterator {

  Deque<Character> input;
  public StringIterator(String compressedString){
    input = new ArrayDeque<>();
    char [] charArray = compressedString.toCharArray();
    int index =0;
    while(index<charArray.length){
     char c = charArray[index];
      if(!Character.isDigit(c)){
        input.addFirst(c);
        index +=1;
      }else{
        StringBuilder sb = new StringBuilder();
        char temp  = input.peek();
        while (index<charArray.length && Character.isDigit(charArray[index])){
            sb.append(charArray[index]);
            index +=1;
        }
        for (int i =1; i<Integer.parseInt(sb.toString()); i++){
           input.addFirst(temp);
        }
      }

    }
  }

  public static void main(String args[]){
    StringIterator itr = new StringIterator("L10e2t1C1o1d1e2");
    while(!itr.input.isEmpty()){
      System.out.println(itr.input.poll());
    }
  }
}
