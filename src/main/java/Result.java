class Result {
    private int deads;
    private int damaged;

    public Result(int deads, int damaged){
        this.damaged = damaged;
        this.deads = deads;
    }

    public void write(){
        System.out.println(deads + " blacks and " + damaged + " whites");
    }

    public boolean isWinner(){
        return deads == 4;
    }
}
