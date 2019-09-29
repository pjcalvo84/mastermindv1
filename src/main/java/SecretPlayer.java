public class SecretPlayer {

    private ProposedPlayer proposedPlayer;
    private SecretCombination secretCombination;

    public SecretPlayer(ProposedPlayer proposedPlayer){
        this.proposedPlayer = proposedPlayer;
    }

    public void prepare(){
        secretCombination = new SecretCombination();
    }

    public void answer(){
        ProposedCombination proposedCombination = proposedPlayer.getLastProposedPlayer();
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

    public void write(){
        secretCombination.write();
    }
}
