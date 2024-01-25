package com.windictus.objects;

import com.windictus.enums.StatNames;

import java.util.Scanner;

import static com.windictus.enums.StatNames.*;

abstract class Stats {

    /**
     *  att stat is unused
     *  could be expanded later to contain other stats
     */
    int att, spd, bal, addmg, crit;
    double cdmg;
    final double addmgConstant = 0.0005864098448;
    final int balCap = 90;
    private final Scanner s = new Scanner(System.in);

    /**
     *  get stat values from console, if it's 0 it goes to default value
     *  +20 base if on base stats
     *  0 if on scroll stats
     */
    public void getStats(){

        //att = assignIntStat(ATT, att);
        spd = assignIntStat(SPD, spd);
        bal = assignIntStat(BAL, bal);
        addmg = assignIntStat(ADDMG, addmg);
        crit = assignIntStat(CRIT, crit);
        cdmg = assignDoubleStat(CDMG, cdmg);

    }

    int assignIntStat(StatNames statName, int baseStat) {
        System.out.print("Input the stat for " + statName.getDescription() + " (leave blank for default): ");
        String line = s.nextLine();
        return line.isEmpty() ? baseStat : Integer.parseInt(line);
    }

    double assignDoubleStat(StatNames statName, double baseStat) {
        System.out.print("Input the stat for " + statName.getDescription() + " (leave blank for default): ");
        String line = s.nextLine();
        return line.isEmpty() ? baseStat : Double.parseDouble(line);
    }

}
