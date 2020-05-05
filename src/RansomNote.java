import java.util.HashMap;
import java.util.Map;

/**
 * Created by ankujgup on 03-May-20.
 */
class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> noteChars = new HashMap();
        Map<Character, Integer> magazineChars = new HashMap();

        if (ransomNote.length() == 0)
            return true;

        if (magazine.length() == 0 && ransomNote.length() != 0)
            return false;

        for (int idx = 0;idx<ransomNote.length();idx++) {
            Character ch = ransomNote.charAt(idx);
            noteChars.put(ch, noteChars.getOrDefault(ch, 0) + 1);
        }

        for (int idx = 0;idx<magazine.length();idx++) {
            Character ch = magazine.charAt(idx);
            magazineChars.put(ch, magazineChars.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> pair : noteChars.entrySet()) {
            System.out.println(pair.getKey());
            System.out.println(pair.getValue());
            if (!magazineChars.containsKey(pair.getKey()) ||
                    magazineChars.get(pair.getKey()) != pair.getValue()) {
                return false;
            }
        }

        return true;
    }
}