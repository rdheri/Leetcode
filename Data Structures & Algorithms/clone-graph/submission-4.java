class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    public Node cloneGraph(Node node, HashMap<Node, Node> map) {
        if(map.containsKey(node)) return map.get(node);

        Node copyNode = new Node(node.val);

        map.put(node, copyNode);

        for(Node neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor, map));
        }

        return copyNode;
    }
}