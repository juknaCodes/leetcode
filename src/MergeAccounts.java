import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by ankujgup on 17-Mar-20.
 */
/*class MergeAccounts {
  public List<List<String>> accountsMerge(List<List<String>> acts) {
    Map<String, String> owner = new HashMap<>();
    Map<String, String> parents = new HashMap<>();
    Map<String, TreeSet<String>> unions = new HashMap<>();
    for (List<String> a : acts) {
      for (int i = 1; i < a.size(); i++) {
        parents.put(a.get(i), a.get(i));
        owner.put(a.get(i), a.get(0));
      }
    }
    for (List<String> a : acts) {
      String p = find(a.get(1), parents);
      for (int i = 2; i < a.size(); i++)
        parents.put(find(a.get(i), parents), p);
    }
    for(List<String> a : acts) {
      String p = find(a.get(1), parents);
      if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
      for (int i = 1; i < a.size(); i++)
        unions.get(p).add(a.get(i));
    }
    List<List<String>> res = new ArrayList<>();
    for (String p : unions.keySet()) {
      List<String> emails = new ArrayList(unions.get(p));
      emails.add(0, owner.get(p));
      res.add(emails);
    }
    return res;
  }
  private String find(String s, Map<String, String> p) {
    return p.get(s) == s ? s : find(p.get(s), p);
  }
}*/
class MergeAccounts {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    DSU dsu = new DSU();
    Map<String, String> emailToName = new HashMap();
    Map<String, Integer> emailToID = new HashMap();
    int id = 0;
    for (List<String> account: accounts) {
      String name = "";
      for (String email: account) {
        if (name == "") {
          name = email;
          continue;
        }
        emailToName.put(email, name);
        if (!emailToID.containsKey(email)) {
          emailToID.put(email, id++);
        }
        dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
      }
    }

    Map<Integer, List<String>> ans = new HashMap();
    for (String email: emailToName.keySet()) {
      int index = dsu.find(emailToID.get(email));
      ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
    }
    for (List<String> component: ans.values()) {
      Collections.sort(component);
      component.add(0, emailToName.get(component.get(0)));
    }
    return new ArrayList(ans.values());
  }
}
class DSU {
  int[] parent;
  public DSU() {
    parent = new int[20];
    for (int i = 0; i <20; ++i)
      parent[i] = i;
  }
  public int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]);
    return parent[x];
  }
  public void union(int x, int y) {
    parent[find(x)] = find(y);
  }
}
