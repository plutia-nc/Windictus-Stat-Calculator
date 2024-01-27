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

        System.out.println("-----------------");
        System.out.println("Final gear score without the scroll(s) is \u001B[33m" + oldStats.getFinalDamage() + "\u001B[0m.");
        System.out.println("Final gear score with the scroll(s) is \u001B[35m" + base.getFinalDamage() + "\u001B[0m.");
        double difference = Math.round(((double) base.getFinalDamage() / oldStats.getFinalDamage() * 100.0 - 100) * 100) / 100.0;
        String differenceText = switch ((int) (difference / Math.abs(difference))) {
            case 1 -> "increased by \u001B[32m" + difference + "\u001B[0m%";
            case -1 -> "decreased by \u001B[31m" + Math.abs(difference) + "\u001B[0m%";
            default -> "\u001B[36mnot changed\u001B[0m";
        };
        System.out.println("\nOverall damage has " + differenceText + ".");

    }
}
