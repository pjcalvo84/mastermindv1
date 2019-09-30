import java.util.Scanner;

public class Mastermind {

    public static void main (String[] args){

        Mastermind mastermind = new Mastermind();
        mastermind.play();
    }

    public void play(){

        ProposedPlayer proposedPlayer = new ProposedPlayer();
        SecretPlayer secretPlayer = new SecretPlayer(proposedPlayer);

        this.writeStartMessage();
        secretPlayer.prepare();
        do {
            secretPlayer.write();
            proposedPlayer.propose();
            secretPlayer.answer();
            proposedPlayer.writeAttemps();
            proposedPlayer.writeProposedCombinations();
        }
        while(!proposedPlayer.isLooser() && !proposedPlayer.isWinner());
        writeFinalMessage(proposedPlayer);
        if(read())
            play();

    }

    private void writeStartMessage(){
        System.out.println("---- MASTERMIND ----");
    }

    private void writeFinalMessage(ProposedPlayer proposedPlayer){
        if(proposedPlayer.isWinner()){
            System.out.println("You've won!!! ;-)");
        }
        else{
            System.out.println("You've lost!!! :-(");
        }
    }

    private boolean read(){
        boolean goodAnswer;
        String nextPlay="";
        do{
            goodAnswer = false;
            System.out.print("Do you want to continue? (s/n): ");

            Scanner sc = new Scanner(System.in);

            nextPlay = sc.nextLine();

            if(nextPlay.equals("s") || nextPlay.equals("n")){
                goodAnswer = true;
            }
            else{
                System.out.println("Wrong response, they must be: s/n");
            }

        }
        while(!goodAnswer);
        
        if(nextPlay.equals("s"))
            return true;
        else
            return false;
    }
}
