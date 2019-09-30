import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProposedCombination  extends Combination{

    private Result result;

    public void read(){
        String combinationString;
        boolean goodProposal;
        do {
            goodProposal = true;
            System.out.print("Propose a combination: ");

            Scanner sc = new Scanner(System.in);

            combinationString = sc.nextLine();
            if(combinationString.length()> combination.length){
                System.out.println("Wrong proposed combination length");
                goodProposal=false;
            }
            Set<Character> colors = new HashSet();

            for(int x =0; x< combinationString.length(); x++){
                colors.add(combinationString.charAt(x));

            }
            if(colors.size()!= combinationString.length()){
                System.out.println("Repeated colors");
                goodProposal=false;
            }

            for(int x =0; x< combinationString.length(); x++){
                if(!exitsColor(combinationString.charAt(x))){
                    System.out.println("Wrong colors, they must be: rbygop");
                    goodProposal=false;
                    break;
                }
            }
        }
        while(!goodProposal);
        setCombination(combinationString);
    }

    private void setCombination(String combinationString){
        Color[] color = new Color[4];
        for(int x =0; x< combinationString.length(); x++){
            color[x] = getColor(combinationString.charAt(x));
        }
        combination = color;
    }
    private Color getColor(char color){
        for(Color c:Color.values()){
            if(c.getColor() == color){
                return c;
            }
        }
        return null;
    }
    private  boolean exitsColor(char charColor){
        for(Color color: Color.values()){
            if(color.getColor() == charColor){
                return true;
            }
        }
        return false;
    }
    public boolean contains(Color color, int position){
        return combination[position] == color;
    }

    public boolean contains(Color color){
        return getCombinationrStringFormat().contains(String.valueOf(color.getColor()));
    }

    private String getCombinationsStringFormat(){
        String combinationStringFormat="";
        for(int x=0; x<combination.length;x++){
            combinationStringFormat+=combination[x].getColor();
        }
        return combinationStringFormat;
    }

    public void setResult(Result result){
        this.result = result;
    }

    public void write(){
        result.write();
    }

    public boolean isWinner(){
        return result.isWinner();
    }

}
