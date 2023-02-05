import java.util.Scanner;
// @author Corina Luca
public class HuffmanTree {
    private HuffmanNode root;

    public HuffmanTree(HuffmanNode huff){ // Constructor
        this.root = huff;
    }

    public void printLegend(){
        printLegend(this.root, "");
    }

    private void printLegend(HuffmanNode t, String s){
        if(t.getLetter().length() > 1){  // recurse
            printLegend(t.getLeft(), s + "0");
            printLegend(t.getRight(), s + "1");
        }

        else if(t.getLetter().length() == 1){ // base case, once length is equal to 1, break recursion.
            System.out.println(t.getLetter()+ "=" + s);
        }
    }

    public static BinaryHeap legendToHeap(String legend){
        BinaryHeap bh = new BinaryHeap<>();
        String[] split = legend.split(" ");

        for(int i = 0; i < split.length; i+=2){
            String ch = split[i];
            Double freq = Double.parseDouble(split[i+1]);
            HuffmanNode node = new HuffmanNode(ch,freq);
            bh.insert(node);
        }

        return bh;
    }

    public static HuffmanTree createFromHeap(BinaryHeap b){
        HuffmanNode newestRoot = null; // filler for zeroth entry;

        while(!b.isEmpty()){
            newestRoot = (HuffmanNode) b.deleteMin();
            if(!b.isEmpty()){
                HuffmanNode secondSmall = (HuffmanNode) b.deleteMin();

                // New node merging root and second smallest;
                HuffmanNode newest = new HuffmanNode(newestRoot,secondSmall);

                b.insert(newest);
            }

        }

        return new HuffmanTree(newestRoot);

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter data: ");

        String legend = scn.nextLine();
        // check this

        BinaryHeap bh = HuffmanTree.legendToHeap(legend);
        HuffmanTree node = HuffmanTree.createFromHeap(bh);
        node.printLegend();
    }

}
