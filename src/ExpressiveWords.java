import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankujgup on 25-Mar-20.
 */
class ExpressiveWords {
  class RLE {
    String key;
    List<Integer> counts;

    RLE(String word) {

      counts = new ArrayList();
      StringBuilder builder = new StringBuilder();
      for (int i=0;i<word.length();) {
        Character ch = word.charAt(i);
        int j = i+1;

        while(j <word.length() && word.charAt(j) == ch)
          j++;
        counts.add(j-i);
        builder.append(ch);
        i =j;
      }
      key = builder.toString();

    }
  }

  public int expressiveWords(String S, String[] words) {
    RLE r = new RLE(S);
    int count =0;

    for (String word: words) {
      RLE r2 = new RLE(word);
      boolean isMatching = true;
      if (!r.key.equals(r2.key)) continue;
      for (int i=0;i<r.key.length();i++) {
        int count1 = r.counts.get(i);
        int count2 = r2.counts.get(i);

        if (count1 <3 && count1 != count2 || count1< count2) {
          isMatching = false;
          break;
        }
      }
      if (isMatching)
        count++;

    }

    return count;

  }

   /* private Map<Character, Interval> getIntervals(String word) {

      Map<Character, Interval> charToInterval = new HashMap();

      for (int i=0;i<word.length();) {
        Character  ch = word.charAt(i);

        int j = i+1;

        while(j < word.length() && word.charAt(j) == ch)
          j++;

        if (j!=i && j-i > 2) {
          charToInterval.put(ch, new Interval(i, j-1));
        }
        i =j;
      }

      return charToInterval;

    }*/
}
