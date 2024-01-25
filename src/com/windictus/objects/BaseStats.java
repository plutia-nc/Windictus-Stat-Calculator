package com.windictus.objects;

public class BaseStats extends Stats{

    private int finalDamage = 0;

    /**
     *  constructors
     *  containing default values for +20
     *  capable of copying data from an existing stat sheet
     */
    public BaseStats(BaseStats stats){
        this.att = stats.att;
        this.bal = stats.bal;
        this.spd = stats.spd;
        this.addmg = stats.addmg;
        this.crit = stats.crit;
        this.cdmg = stats.cdmg;
    }

    public BaseStats() {
            att = 0;
            spd = 85;
            bal = 90;
            addmg = 2750;
            crit = 25;
            cdmg = 200;
    }

    /**
     *  takes prefix and suffix scroll stats
     *  adds onto base stats
     *  calculates new crit damage amount based on surplus balance
     */
    public void add(ScrollStats prefix, ScrollStats suffix){
        att += (prefix.att + suffix.att);
        spd += (prefix.spd + suffix.spd);
        bal += (prefix.bal + suffix.bal);
        addmg += (prefix.addmg + suffix.addmg);
        crit += (prefix.crit + suffix.crit);
        cdmg += (prefix.cdmg + suffix.cdmg);

        int balSurplus = bal < balCap ? 0 : bal - balCap;
        bal = Math.min(bal, balCap);
        cdmg = cdmg - 100 + (1 + balSurplus * (1.0/3) / 100) * 100;
    }


    public void calculateFinalDamage(){
        cdmg /= 100;
        double addDmg = Math.round(
                addmg * addmgConstant
                        * 100.0) / 100.0;

        double balDmg = Math.round(
                (bal + 100.0) / 2
                        * 100) / 100.0;

        double balPlusAddDmg = Math.round(
                (balDmg / 100 + addDmg)
                        * 100) / 100.0;

        double animSpeed = Math.round(
                1.0 / ((200.0 + spd) /200)
                        * 100) / 100.0;

        double dmgPlusSpeed = Math.round(
                balPlusAddDmg / animSpeed
                        * 100) / 100.0;

        double critMult = Math.round(
                (crit*(cdmg-1)/100 + 1)
                        * 100) / 100.0;

        finalDamage = (int) Math.round(
                dmgPlusSpeed * 100 * critMult);

        //System.out.println("addDmg " + addDmg);
        //System.out.println("balDmg " + balDmg);
        //System.out.println("balPlusAddDmg " + balPlusAddDmg);
        //System.out.println("animSpeed " + animSpeed);
        //System.out.println("dmgPlusSpeed " + dmgPlusSpeed);
        //System.out.println("critMult " + critMult);
    }

    public int getFinalDamage() {
        return finalDamage;
    }

}
