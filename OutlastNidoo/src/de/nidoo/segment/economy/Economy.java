package de.nidoo.segment.economy;

import org.bukkit.entity.Player;

import de.nidoo.segment.main.Main;

public class Economy {

    public static int getMoney(Player target) {

        int money = Main.getPlugin().getConfig().getInt("Economy." + target.getName());

        return money;

    }


    public static void addMoney(Player target, int amount) {

        int money = Main.getPlugin().getConfig().getInt("Economy." + target.getName());

        money = money + amount;

        Main.getPlugin().getConfig().set("Economy." + target.getName(), money);
        Main.getPlugin().saveConfig();

    }


    public static void removeMoney(Player target, int amount) {

        int money = Main.getPlugin().getConfig().getInt("Economy." + target.getName());

        money = money - amount;

        Main.getPlugin().getConfig().set("Economy." + target.getName(), money);
        Main.getPlugin().saveConfig();

    }


    public static void setMoney(Player target, int amount) {

        int money = Main.getPlugin().getConfig().getInt("Economy." + target.getName());

        money = amount;

        Main.getPlugin().getConfig().set("Economy." + target.getName(), money);
        Main.getPlugin().saveConfig();

    }



}
