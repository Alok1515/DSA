/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        // already cloned
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // create clone
        Node clone = new Node(node.val);

        // store mapping
        map.put(node, clone);

        // clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}