package design.statepattern.atm;

public class AtmMachine {
    private AtmMachineState atmMachineState;
    public AtmMachine(){
        atmMachineState = new NoDebitCardState();
    }

    public AtmMachineState getAtmMachineState() {
        return atmMachineState;
    }

    public void setAtmMachineState(AtmMachineState atmMachineState) {
        this.atmMachineState = atmMachineState;
    }

    public void insertDebitCard() {
        atmMachineState.insertDebitCard();
    }

    public void ejectDebitCard() {
        atmMachineState.ejectDebitCard();
        if(atmMachineState instanceof HasDebitCardState){
            AtmMachineState noDebitCardState = new NoDebitCardState();
            setAtmMachineState(noDebitCardState);
            System.out.println("ATM Machine internal state has been moved to"+atmMachineState.getClass().getName());
        }
    }

    public void enterPinAndWithdrawMoney() {
        atmMachineState.enterPinAndWithdrawMoney();
    }
}
