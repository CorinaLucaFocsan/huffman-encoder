// @author Corina Luca
public class HuffmanNode implements Comparable<Object>{

    private String letter;
    private Double frequency;
    private HuffmanNode left, right;


    public HuffmanNode(String letter, Double frequency){ // Constructor 1
        this.left = null;
        this.right = null;

        this.letter = letter;
        this.frequency = frequency;
    }

    public HuffmanNode(HuffmanNode left, HuffmanNode right){ // Constructor 2
        this.left = left;
        this.right = right;

        this.letter = left.letter + right.letter;
        this.frequency = left.frequency + right.frequency;
    }

    public int compareTo(Object o){
        HuffmanNode huff = (HuffmanNode) o;
        return frequency.compareTo(huff.frequency);

    }
    public String toString(){
        return "<"+this.letter+", "+this.frequency+">";
    }

    // Getters
    public String getLetter() {
        return this.letter;
    }

    public Double getFrequency() {
        return this.frequency;
    }

    public HuffmanNode getLeft() {
        return this.left;
    }

    public HuffmanNode getRight() {
        return this.right;
    }


}
