public class ProposedPlayer {

    private final int TOTAL_ATTEMTS = 10;
    private ProposedCombination[] proposedCombinations = new ProposedCombination[TOTAL_ATTEMTS];
    private int attemts=0;

    public void propose(){
        ProposedCombination proposedCombination = new ProposedCombination();
        proposedCombination.read();
        proposedCombinations[attemts]= proposedCombination;
        attemts++;
    }

    public ProposedCombination getLastProposedPlayer(){
        return proposedCombinations[attemts-1];
    }
    public void writeAttemps(){
        System.out.println(attemts + " attempt(s):");
    }
    public void writeProposedCombinations(){
        for(int x=0 ; x < attemts; x++) {
            for (Color color : proposedCombinations[x].combination) {
                System.out.print(color.getColor());
            }
            System.out.print(" --> ");

            proposedCombinations[x].write();
        }
    }

    public boolean isLooser(){
        return attemts == TOTAL_ATTEMTS;
    }
    public boolean isWinner(){
        return getLastProposedPlayer().isWinner();
    }

}
