/*
 * Noah Gathings
 * Dr. Fadi Wedyan
 * Assignment 5
 */

public class Node {

    private int x;
    private int y;
    private static final int MIN_RANGE_= -100;
    private static final int MAX_RANGE = 100;

    // Constructor that initializes x and y to 0
    public Node(){
        this(0, 0);
    }

    
    // Copy constructor that creates new Node with the same x and y values as the given Node
    public Node(Node other){
        this(other.getX(), other.getY());
    }

    
    // Constructor with x and y parameters.
    public Node(int x, int y){
        setX(x);
        setY(y);
    }

    // Getter method to get x-coordinate
    public int getX(){
        return x;
    }

    // Setter method for x-coordinate
    // @throws IllegalArguementException if the x-coordinate is out of bounds
    public void setX(int x) throws IllegalArgumentException{
        if(x < MIN_RANGE_ || x > MAX_RANGE){
            throw new IllegalArgumentException("X-coordinate must be in the range [-100, 100]");
        }
        this.x = x;
    }

    // Getter method to get y coordinate
    public int getY(){
        return y;
    }


    // Setter method for y-coordinate
    // @throws IllegalArguementException if the y coordinate is out of bounds
    public void setY(int y) throws IllegalArgumentException{
        if(y < MIN_RANGE_ || y > MAX_RANGE){
            throw new IllegalArgumentException("Y-coordinate must be in the range [-100, 100]");
        }
        this.y = y;
    }

    // Adds the coordinates of another Node to this Node's coordinates
    // @throws an ArithmeticException if the result is out of bounds
    public void add(Node other){
        int newX = this.x + other.getX();
        int newY = this.y + other.getY();

        // Checking if coordinates are within range
        if(newX < MIN_RANGE_ || newX > MAX_RANGE || newY < MIN_RANGE_ || newY > MAX_RANGE){
            throw new ArithmeticException("Additional result is out of bounds");
        }

        // Updating coordinates if they are in range
        this.x = newX;
        this.y = newY;
    }

    
    // Override toString method and get string representative
    public String toString(){
        return "Node{" + "x = " + x +  "y= " + y + "}";
    }

  
    // Override equals method to check if the node is equal
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(object == null|| getClass() != object.getClass()){
            return false;
        }
        Node node = (Node) object;
        return x == node.x && y == node.y;

    }       
    
}