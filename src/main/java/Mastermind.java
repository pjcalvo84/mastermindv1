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

        do {
            secretPlayer.prepare();
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
        System.out.print("Do you want to continue? (s/n): ");

        Scanner sc = new Scanner(System.in);

        // String input
        String nextPlay = sc.nextLine();
        if(nextPlay.equals("s"))
            return true;
        else
            return false;
    }
}
