package com.windictus;

import com.windictus.objects.BaseStats;
import com.windictus.objects.ScrollStats;

public class Main {

    public static void main(String[] args) {

        //create objects for each class
        BaseStats base = new BaseStats();
        ScrollStats prefix = new ScrollStats();
        ScrollStats suffix = new ScrollStats();

        //requesting the values via console
        System.out.println("\nFirst, the character base stats:");
        base.getStats();
        System.out.println("\nThen, the stats of the prefix scroll:");
        prefix.getStats();
        System.out.println("\nLastly, the stats of the suffix scroll:");
        suffix.getStats();

        //keep the old stats for comparison purposes
        BaseStats oldStats = new BaseStats(base);
        oldStats.calculateFinalDamage();

        //add the stats onto the character base stats and perform the calculation for final damage
        base.add(prefix, suffix);
        base.calculateFinalDamage();

        System.out.println("\nFinal damage without the scroll(s) is " + oldStats.getFinalDamage() + "%");
        System.out.println("Final damage with the scroll(s) is " + base.getFinalDamage() + "%");

    }
}
