import java.util.Comparator;
// Class
class Node implements Comparator<Node>
{
    public String node;
    public int CostTime;
    public Node()
    {
    }
    // Set the node and their cost
    public Node(String node, int CostTime)
    {
        this.node = node;
        this.CostTime = CostTime;
    }
    // Compare the nodes.
    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.CostTime < node2.CostTime)
            return -1;
        if (node1.CostTime > node2.CostTime)
            return 1;
        return 0;
    }
}