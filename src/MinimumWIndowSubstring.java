import java.util.HashMap;
import java.util.Map;

/**
 * Created by ankujgup on 08-Feb-20.
 */
public class MinimumWIndowSubstring {

  public String minWindow(String s, String t) {

    Map<Character, Integer> frequencyMap = new HashMap();

    for (int i =0;i<t.length();i++) {
      Character ch = t.charAt(i);
      frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
    }
    int windowStart =0, windowEnd =0, minLength =-1, matched =0;
    int start =0, end =0;
    Map<Character, Integer> window = new HashMap();
    for (;windowEnd < s.length();windowEnd++) {
      Character ch = s.charAt(windowEnd);
      //System.out.println(ch);
      //if (frequencyMap.containsKey(ch) && frequencyMap.get(ch) > 0) {
      window.put(ch, window.getOrDefault(ch,0)+1);
      //System.out.println(matched);
      //}
      if (frequencyMap.containsKey(ch) && frequencyMap.get(ch) == window.get(ch)) {
        System.out.println("here");
        matched++;
      }


      while((windowStart <= windowEnd) && (matched == frequencyMap.size())) {
        Character chfromStart = s.charAt(windowStart);
        System.out.println("here");
        int length = windowEnd-windowStart+1;
        //System.out.println("here");
        if (minLength == -1 || length < minLength) {
          // System.out.println(length);
          System.out.println("here");
          minLength = length;
          start = windowStart;
          end = windowEnd;
        }

        window.put(chfromStart, window.get(chfromStart)-1);
        if (frequencyMap.containsKey(chfromStart) &&
          frequencyMap.get(chfromStart) > window.get(chfromStart)) {
          //System.out.println("here");
          matched--;
        }
        windowStart++;
      }
    }
    //System.out.println(minLength);
    return minLength == -1 ? "" : s.substring(start, end + 1);

  }
}
