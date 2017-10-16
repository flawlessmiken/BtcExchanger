package com.a5.ngenemichael.btcexchanger;

/**
 * Created by Flawless on 10/12/2017.
 */
public class Countries {
        private String name, Btc, Eth;
        private  int cFlag, coinFlag;
    public Countries(){
    }
    public Countries(String name, String Btc, String Eth, int cFlag, int coinFlag){
        this.name = name;
        this.Btc = Btc;
        this.Eth = Eth;
        this.cFlag = cFlag;
        this.coinFlag = coinFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBtc() {
        return Btc;
    }

    public void setBtc(String btc) {
        Btc = btc;
    }

    public String getEth() {
        return Eth;
    }

    public void setEth(String eth) {
        Eth = eth;
    }

    public int getcFlag() {
        return cFlag;
    }

    public void setcFlag(int cFlag) {
        this.cFlag = cFlag;
    }

    public int getCoinFlag() {
        return coinFlag;
    }

    public void setCoinFlag(int coinFlag) {
        this.coinFlag = coinFlag;
    }
}
