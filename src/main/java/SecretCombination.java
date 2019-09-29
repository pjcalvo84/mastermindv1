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


}
