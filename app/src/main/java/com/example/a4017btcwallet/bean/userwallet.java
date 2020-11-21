package com.example.a4017btcwallet.bean;

public class userwallet {


    /**
     * balance : 10
     * public_key : 30819f300d06092a864886f70d010101050003818d0030818902818100af4bd084d5d74412af39c8667ad6cc13e7e2c8b34f2bb894674f4e92ec3d70a24e3c3ac5b50aff6629e3829211649aa9abbef68f4eb168dc109520ed2de2d2071e611b2f8efbf176d45955208345772ade3861f6101e0a89044277e6b4eeeb77501175f1a75b0cc4d0b790b1b7351ac8187af09cebcf008aecd9db596c286b6f0203010001
     */

    private float balance;
    private String public_key;

    public float getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }
}
