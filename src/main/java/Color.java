import java.util.Random;

public enum Color {
    RED('r'), BLUE('b'), YELLOW('y'), GREEN('g'), ORANGE('o'), PURPLE('p');
    private char color;

    Color(char c){
        color = c;
    }

    char getColor(){
        return color;
    }

    public static Color getRandomColor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
