package uz.pdp.model.transaction;

public enum TransactionState {
    CREATED(1),
    CHECK(2),
    CHECK_ERROR(3),
    PAYING(4),
    IN_PROCESS(5),
    SUCCESS(6),
    PAY_ERROR(7);


    private int stateId;

    TransactionState(int stateId) {
        this.stateId = stateId;
    }

    public int getStateId() {
        return stateId;
    }
}
