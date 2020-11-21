package com.example.a4017btcwallet.bean;

import java.util.List;

public class transhist {


    /**
     * chain : [{"index":0,"transactions":[{"sender":"Block_Reward","recipient":"30819f300d06092a864886f70d010101050003818d0030818902818100ac388dd12b77d9cfc4cf08127c194bc6b0a8113dfe8b17ff19ddf3543faa2b076a120cfd604ce2c71588fa76d5ef0b729c36cf7389c0fbe3af7cb28b0ff92dd8abcb5e1cb74c669fb05997aef4792666449aab4647b8385fa3819c75c4a45637a9a89198ec9d58c1d1cb44f2262c83837e19b41f1d0489699d4d0b3dc6a30bff0203010001","value":"5.0"}],"timestamp":"11/06/2020, 20:15:00","previous_hash":"0","hash":"3a788cb5d28e3e1447eca1789d597c622ac5c056ddd27acb80f4dae1c0665c62","nonce":0},{"index":1,"transactions":[{"sender":"Block_Reward","recipient":"30819f300d06092a864886f70d010101050003818d0030818902818100af4bd084d5d74412af39c8667ad6cc13e7e2c8b34f2bb894674f4e92ec3d70a24e3c3ac5b50aff6629e3829211649aa9abbef68f4eb168dc109520ed2de2d2071e611b2f8efbf176d45955208345772ade3861f6101e0a89044277e6b4eeeb77501175f1a75b0cc4d0b790b1b7351ac8187af09cebcf008aecd9db596c286b6f0203010001","value":"5.0"},{"sender":"30819f300d06092a864886f70d010101050003818d0030818902818100d2db4ecac72e6f0dcdd291a3782c48f15a80029106b643153ac47bdff2a7ddb35aeb6888127f51b6a411a4c5934f3b407d89ada1060c97694048e7440c54c42b09d9067fad2a6288ee365558773c3f90b569d0299eecffe50ff2137572632a5395dba77b81b95ea8e09323ca1b1cf9e7aa134c39b872cc723805d6c2769e3a4f0203010001","recipient":"30819f300d06092a864886f70d010101050003818d0030818902818100ac388dd12b77d9cfc4cf08127c194bc6b0a8113dfe8b17ff19ddf3543faa2b076a120cfd604ce2c71588fa76d5ef0b729c36cf7389c0fbe3af7cb28b0ff92dd8abcb5e1cb74c669fb05997aef4792666449aab4647b8385fa3819c75c4a45637a9a89198ec9d58c1d1cb44f2262c83837e19b41f1d0489699d4d0b3dc6a30bff0203010001","value":"5","signature":"36e8a676f77155c587654f198cdcc057822da4ee7c69112f7d02e7db148e7d56b4473f14ad9ef2ff7e7d1e40478a0ddd022025b3a878bd12990995e570ae12cd60f8646808cd146cd5fba8c2572cc7543074896231a6c527b8e94a402cbd1ea4d270ae308f40fe78d60fc8864dc163cdcc5c695774198c74b43cb49bdfb4cb7d"}],"timestamp":"11/06/2020, 20:17:21","previous_hash":"3a788cb5d28e3e1447eca1789d597c622ac5c056ddd27acb80f4dae1c0665c62","hash":"003827b13d59b0a0c5b23eaf78dbd63d5defa95b2dbdb5751d5dd81d22f46da8","nonce":214}]
     * length : 2
     */

    private int length;
    private List<ChainBean> chain;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<ChainBean> getChain() {
        return chain;
    }

    public void setChain(List<ChainBean> chain) {
        this.chain = chain;
    }

    public static class ChainBean {
        /**
         * index : 0
         * transactions : [{"sender":"Block_Reward","recipient":"30819f300d06092a864886f70d010101050003818d0030818902818100ac388dd12b77d9cfc4cf08127c194bc6b0a8113dfe8b17ff19ddf3543faa2b076a120cfd604ce2c71588fa76d5ef0b729c36cf7389c0fbe3af7cb28b0ff92dd8abcb5e1cb74c669fb05997aef4792666449aab4647b8385fa3819c75c4a45637a9a89198ec9d58c1d1cb44f2262c83837e19b41f1d0489699d4d0b3dc6a30bff0203010001","value":"5.0"}]
         * timestamp : 11/06/2020, 20:15:00
         * previous_hash : 0
         * hash : 3a788cb5d28e3e1447eca1789d597c622ac5c056ddd27acb80f4dae1c0665c62
         * +merkle_root
         * nonce : 0
         * +difficulty
         */

        private int index;
        private String timestamp;
        private String previous_hash;
        private String hash;
        private String merkle_root;
        private int nonce;
        private int difficulty;
        private List<TransactionsBean> transactions;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getPrevious_hash() {
            return previous_hash;
        }

        public void setPrevious_hash(String previous_hash) {
            this.previous_hash = previous_hash;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getMerkle_root() {
            return merkle_root;
        }

        public void setMerkle_root(String merkle_root) {
            this.merkle_root = merkle_root;
        }

        public int getNonce() { return nonce;}

        public void setNonce(int nonce) {this.nonce = nonce;}

        public int getDifficulty() { return difficulty;}

        public void setDifficulty(int difficulty) {this.difficulty = difficulty;}

        public List<TransactionsBean> getTransactions() {
            return transactions;
        }

        public void setTransactions(List<TransactionsBean> transactions) {
            this.transactions = transactions;
        }

        public static class TransactionsBean {
            /**
             * sender : Block_Reward
             * recipient : 30819f300d06092a864886f70d010101050003818d0030818902818100ac388dd12b77d9cfc4cf08127c194bc6b0a8113dfe8b17ff19ddf3543faa2b076a120cfd604ce2c71588fa76d5ef0b729c36cf7389c0fbe3af7cb28b0ff92dd8abcb5e1cb74c669fb05997aef4792666449aab4647b8385fa3819c75c4a45637a9a89198ec9d58c1d1cb44f2262c83837e19b41f1d0489699d4d0b3dc6a30bff0203010001
             * value : 5.0
             */

            private String sender;
            private String recipient;
            private String value;
            private String fee;


            public String getSender() {
                return sender;
            }

            public void setSender(String sender) {
                this.sender = sender;
            }

            public String getRecipient() {
                return recipient;
            }

            public void setRecipient(String recipient) {
                this.recipient = recipient;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getFee() {
                return fee;
            }

            public void setFee(String fee) {
                this.fee = fee;
            }
        }
    }
}

