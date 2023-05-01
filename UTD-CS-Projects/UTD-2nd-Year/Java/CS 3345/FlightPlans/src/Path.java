import java.util.ArrayList;
import java.util.List;
// Create the class
class Path
{
    private List<String> path;
    private String Node;
    //Create the arrayList
    public Path()
    {
        path = new ArrayList<String>();
    }
    // Set the node
    public void setNode(String Node)
    {
        this.Node = Node;
    }
    // Get the node
    public String getNode()
    {
        return this.Node;
    }
    // Check if the node exist or not
    public Boolean exists(String node)
    {
        if(path.contains(node))
            return true;
        return false;
    }
    // Add the node in the array List
    public void add(String node)
    {
        path.add(node);
    }
    //Delete the node from the list
    public void delete(String node)
    {
        path.remove(node);
    }
}