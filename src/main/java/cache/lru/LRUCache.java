package cache.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private final Map<Integer, Node> map = new HashMap<>();
    private final int                capacity;
    private       int                count;
    private final Node               head;
    private final Node               tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        count = 0;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    /*
     * Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     */
    int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    /*
     * Set or insert the value if the key is not already present.
     * When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
     * For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
     * the least recently used key would be evicted.
     */
    void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
            }
            else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            addToHead(node);
        }
    }
}
