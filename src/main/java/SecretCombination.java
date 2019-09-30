import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SecretCombination extends Combination {

    public SecretCombination(){
        super.combination = generateRandomSecretCombination();
    }

    public void write(){
        System.out.println("****");
    }

    private Color[] generateRandomSecretCombination(){
        Set<Color> colors = new HashSet();
        Color[] colorsArray = new Color[4];
        while(colors.size()<4){
            colors.add(Color.getRandomColor());
        }
        Iterator<Color> it = colors.iterator();
        int x=0;
        while(it.hasNext()){
            colorsArray[x] = it.next();
            x++;
        }
        return colorsArray;
    }

    public void calculateResult(ProposedCombination proposedCombination){
        int damaged = 0;
        int deads = 0;
        for(int x =0; x < 4; x++){
            if(proposedCombination.contains(secretCombination.combination[x], x)){
                deads++;
            }
            else if(proposedCombination.contains(secretCombination.combination[x])){
                damaged++;
            }
        }

        proposedCombination.setResult(new Result(deads, damaged));
    }
}
