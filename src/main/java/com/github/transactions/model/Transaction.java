package com.github.transactions.model;


/*Se trataría de guardar una lista de transacciones de bitcoins (o dinero).
En http://localhost:8080/transactions veríamos por ejemplo:
Bitcoin transactions
1- Pepe gives 10 bitcoins to Mary
2- Lucy gives 5 bitcoins to Johny
3- Mary gives 7 bitcoins to Pepe
etc.

detalle de la transacción, donde se mostrarían más datos
(si está verificada o no, la fecha, etc).*/
public class Transaction {

    private int id;
    private boolean validate;
    private String beneficiary; //receptor
    private String transmitter; //emisor
    private double amount;

    public Transaction (int id, boolean validate, String beneficiary, String transmitter, double amount) {
        this.id = id;
        this.validate = validate;
        this.beneficiary = beneficiary;
        this.transmitter = transmitter;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public boolean isValidate() {
        return this.validate;
    }

    public String getBeneficiary() {
        return this.beneficiary;
    }

    public String getTransmitter() {
        return this.transmitter;
    }

    public double getAmount() {
        return this.amount;
    }
}
