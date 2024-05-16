import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

interface INode {
	// Method to add node
    void add(INode node) throws IllegalArgumentException;
}


class Node implements INode {
	// Declaring coordinate variables
    private int x;
    private int y;

    // Constructors
    public Node() {
        this(0, 0);
    }

    public Node(int x, int y) {
        setX(x);
        setY(y);
    }

    public Node(Node node) {
        this(node.getX(), node.getY());
    }

    // Getter for x
    public int getX() {
        return x;
    }

    // Getter for y
    public int getY() {
        return y;
    }

    // Setters for x and y
    public void setX(int x) {
    	// Checking if within range
        if (x < -100 || x > 100) {
            throw new IllegalArgumentException("Invalid value for x.");
        }
        this.x = x;
    }

    public void setY(int y) {
        if (y < -100 || y > 100) {
            throw new IllegalArgumentException("Invalid value for y.");
        }
        this.y = y;
    }

    // Method to add another node
    @Override
    public void add(INode node) throws IllegalArgumentException {
        if (node instanceof Node) {
            Node n = (Node) node;
            setX(getX() + n.getX());
            setY(getY() + n.getY());
        } else {
            throw new IllegalArgumentException("Cannot add different types of nodes.");
        }
    }

    // String rep of node
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Checking for 3D nodes
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node other = (Node) obj;
        return this.x == other.x && this.y == other.y;
    }
}

// Representing 3D node
class ThreeDNode extends Node {
   // Declaring another coordinate
	private int z;

	// Constructors
    public ThreeDNode() {
        this(0, 0, 0);
    }

    public ThreeDNode(int x, int y, int z) {
        super(x, y); // Calling superclass constructor
        setZ(z);
    }

    public ThreeDNode(ThreeDNode node) {
        this(node.getX(), node.getY(), node.getZ());
    }

    // Getter for z
    public int getZ() {
        return z;
    }

    // Setter for z
    public void setZ(int z) {
    	// Checking if within range
        if (z < -100 || z > 100) {
            throw new IllegalArgumentException("Invalid value for z");
        }
        this.z = z;
    }

    // Method to add node
    @Override
    public void add(INode node) throws IllegalArgumentException {
        if (node instanceof ThreeDNode) {
        	// Casting node to ThreeDNode type
            ThreeDNode n = (ThreeDNode) node;
            super.add(n);
            setZ(getZ() + n.getZ());
        } else {
            throw new IllegalArgumentException("Cannot add different types of nodes");
        }
    }

    // String rep of node
    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }

    // Check for equality
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ThreeDNode)) {
            return false;
        }
        ThreeDNode other = (ThreeDNode) obj;
        // Checking for superclass equality + z coordinate
        return super.equals(obj) && this.z == other.z;
    }
}

// Factory class to create nodes
class NodeFactory {
    private static final Random rand = new Random();

    // Random 2D Node
    public static Node createRandomNode() {
        return new Node(rand.nextInt(201) - 100, rand.nextInt(201) - 100);
    }

    // Random 3D Node
    public static ThreeDNode createRandomThreeDNode() {
        return new ThreeDNode(rand.nextInt(201) - 100, rand.nextInt(201) - 100, rand.nextInt(201) - 100);
    }
}

// Class rep a collection of nodes
class Nodes {
    private ArrayList<INode> nodeList;

    // Constructor
    public Nodes() {
        nodeList = new ArrayList<>(); // Initializing the ArrayList
    }

    public void fill(int size) {
        nodeList.clear();
        // Random number generator
        Random rand = new Random();
        // Filling list with random nodes
        for (int i = 0; i < size; i++) {
            if (rand.nextBoolean()) {
                nodeList.add(NodeFactory.createRandomNode());
            } else {
                nodeList.add(NodeFactory.createRandomThreeDNode());
            }
        }
    }

    // Clearing list
    public void clear() {
        nodeList.clear();
    }

    // Counting 2D nodes
    public int countNodes() {
        int count = 0;
        for (INode node : nodeList) {
            if (node instanceof Node) {
                count++;
            }
        }
        return count;
    }

    // Counting 3D nodes
    public int countThreeDNodes() {
        int count = 0;
        for (INode node : nodeList) {
            if (node instanceof ThreeDNode) {
                count++;
            }
        }
        return count;
    }

    // Sorting list according to sum of coordinates
    public void sort() {
        nodeList.sort(new NodeComparator());
    }

    // String rep of the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (INode node : nodeList) {
            sb.append(node).append("\n");
        }
        return sb.toString();
    }

    
    private static class NodeComparator implements Comparator<INode> {
        @Override
        public int compare(INode o1, INode o2) {
            int sum1 = sum(o1);
            int sum2 = sum(o2);
            return Integer.compare(sum1, sum2);
        }

        // Calculating sum of coordinates
        private int sum(INode node) {
            if (node instanceof ThreeDNode) {
                ThreeDNode threeDNode = (ThreeDNode) node;
                return threeDNode.getX() + threeDNode.getY() + threeDNode.getZ();
            } else {
                Node n = (Node) node;
                return n.getX() + n.getY();
            }
        }
    }
}

class Sorter {
	// Handling user input
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        Nodes nodes = new Nodes();
        int choice;
        do {
        	// Displaying menu options
            System.out.println("Menu:");
            System.out.println("1. Fill");
            System.out.println("2. Clear");
            System.out.println("3. Count Nodes");
            System.out.println("4. Count ThreeDNodes");
            System.out.println("5. Sort");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            // Switch statement to perform actions based on user choice
            switch (choice) {
                case 1:
                    System.out.print("Enter size: ");
                    int size = scan.nextInt();
                    nodes.fill(size);
                    break;
                case 2:
                    nodes.clear();
                    break;
                case 3:
                    System.out.println("Number of Nodes: " + nodes.countNodes());
                    break;
                case 4:
                    System.out.println("Number of ThreeDNodes: " + nodes.countThreeDNodes());
                    break;
                case 5:
                    nodes.sort();
                    break;
                case 6:
                    System.out.println(nodes);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 7);
    }
}
