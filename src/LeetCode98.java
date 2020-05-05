import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankujgup on 04-May-20.
 */
class LeetCode98 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ipAddresses = new ArrayList();
        if (s.length() == 0)
            return ipAddresses;

        restoreIpAddressesUtil(s, 0, 0, ipAddresses, "");
        return ipAddresses;
    }

    private void restoreIpAddressesUtil(String s, int idx, int numlen, List<String>ipAddresses,
                                        String prefix) {
        if (numlen == 4 && idx == s.length()) {
            ipAddresses.add(prefix);
        }
        for (int i =1; i<=3;i++) {
            if (idx + i > s.length()) break;
            String part = s.substring(idx, idx+i);
            int num = Integer.valueOf(part);
            if ((part.length() > 1 && part.charAt(0) == '0') || part.length()==3 && num >= 256) continue;
            restoreIpAddressesUtil(s, idx+i,numlen +1 ,ipAddresses, prefix + part + ((numlen < 3) ? "." : ""));

        }
    }
}
