package design.statepattern.atm;

public interface AtmMachineState {
    void insertDebitCard();
    void ejectDebitCard();
    void enterPinAndWithdrawMoney();
}
