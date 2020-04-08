import java.util.HashMap;
import java.util.Map;

class LRUCache {

  class DLLNode {
    int key;
    int value;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
    }
  }

  class DoublyLinkedList {
    DLLNode head, tail;

    DoublyLinkedList() {
      head = new DLLNode(-1,-1);
      tail = new DLLNode(-1,-1);
      head.prev = null;
      head.next = tail;
      tail.next = null;
      tail.prev = head;
    }

    void insertAtHead(DLLNode newNode) {
      newNode.next = head.next;
      head.next.prev = newNode;
      newNode.prev = head;
      head.next = newNode;
    }

    void moveNodeToFront(DLLNode node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      node.next = null;
      node.prev = null;
      insertAtHead(node);
    }

    DLLNode removeLastNode() {
      DLLNode removedNode = tail.prev;
      tail.prev = tail.prev.prev;
      tail.prev.next = tail;

      return removedNode;
    }
  }

  int capacity;
  Map<Integer, DLLNode> keyToNodeMap;
  DoublyLinkedList dll;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.keyToNodeMap = new HashMap();
    this.dll = new DoublyLinkedList();
  }

  public int get(int key) {
    if (!this.keyToNodeMap.containsKey(key)) {
      return -1;
    }

    DLLNode node = keyToNodeMap.get(key);
    this.dll.moveNodeToFront(node);
    return node.value;

  }

  public void put(int key, int value) {
    DLLNode node = keyToNodeMap.getOrDefault(key, null);
    if (node != null) {
      node.value = value;
      dll.moveNodeToFront(node);
    } else {
      if (this.keyToNodeMap.size() >= capacity) {
        DLLNode removedNode = dll.removeLastNode();
        this.keyToNodeMap.remove(removedNode.key);
      }
      DLLNode newNode = new DLLNode(key, value);
      dll.insertAtHead(newNode);
      this.keyToNodeMap.put(key, newNode);
    }

  }
}