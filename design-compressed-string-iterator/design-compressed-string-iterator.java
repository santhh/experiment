public class StringIterator {
    int i;
    String[] arr;
    int[] counts;

    public StringIterator(String str) {
        arr = str.split("\\d+");
        counts = Arrays.stream(str.substring(1).split("[a-zA-Z]+")).mapToInt(Integer::parseInt).toArray();
    }
    
    public char next() {
        if(!hasNext()) return ' ';
        char ch = arr[i].charAt(0);
        if(--counts[i] == 0) ++i;
        return ch;
    }

    public boolean hasNext() {
        if(i == arr.length) return false;
        return true;
    }
}


// class StringIterator {
//     Deque<Character> input;
//     public StringIterator(String compressedString) {
//          input = new ArrayDeque<>();
//          char [] charArray = compressedString.toCharArray();
//          int index =0;
//          while(index<charArray.length){
//          char c = charArray[index];
//           if(!Character.isDigit(c)){
//             input.addFirst(c);
//             index +=1;
//           }else{
//              StringBuilder sb = new StringBuilder();
//             char temp  = input.peek();
//              while (index<charArray.length && Character.isDigit(charArray[index])){
//                  sb.append(charArray[index]);
//                  index +=1;
//              }
//         for (int i =1; i<Integer.parseInt(sb.toString()); i++){
//            input.addFirst(temp);
//         }
//       }

//     }
// }
    
//     public char next() {
//        return !input.isEmpty()?input.pollLast() : ' ';
     
//     }
    
//     public boolean hasNext() {
//         return !input.isEmpty();
//     }
// }

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */