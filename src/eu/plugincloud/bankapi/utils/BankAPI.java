package eu.plugincloud.bankapi.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import eu.plugincloud.core.utils.MySQL;

public class BankAPI {
    public static void registerPlayer(OfflinePlayer p){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO BankCoins(UUID,COINS) VALUES (?,?);");
            ps.setString(1, p.getUniqueId().toString());
            ps.setInt(2, 0);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static double getCoins(OfflinePlayer p){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT COINS FROM BankCoins WHERE UUID = ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                double clouds = rs.getDouble("COINS");
                return clouds;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        registerPlayer(p);
        return -1;
    }
    public static void setCoins(OfflinePlayer p, double amount){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE BankCoins SET COINS = ? WHERE UUID = ?");
            ps.setDouble(1, amount);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void resetCoins(OfflinePlayer p){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE BankCoins SET COINS = ? WHERE UUID = ?");
            ps.setDouble(1, 0);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void addCoins(OfflinePlayer p, double amount){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE BankCoins SET COINS = ? WHERE UUID = ?");
            ps.setDouble(1, getCoins(p)+amount);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void removeCoins(OfflinePlayer p, double amount){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE BankCoins SET COINS = ? WHERE UUID = ?");
            ps.setDouble(1, getCoins(p)-amount);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void registerPlayer(Player p){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("INSERT INTO BankCoins(UUID,COINS) VALUES (?,?);");
            ps.setString(1, p.getUniqueId().toString());
            ps.setDouble(2, 0);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static double getCoins(Player p){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("SELECT COINS FROM BankCoins WHERE UUID = ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                double clouds = rs.getDouble("COINS");
                return clouds;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        registerPlayer(p);
        return -1;
    }
    public static void setCoins(Player p, double amount){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE BankCoins SET COINS = ? WHERE UUID = ?");
            ps.setDouble(1, amount);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void resetCoins(Player p){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE BankCoins SET COINS = ? WHERE UUID = ?");
            ps.setDouble(1, 0);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void addCoins(Player p, double amount){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE BankCoins SET COINS = ? WHERE UUID = ?");
            ps.setDouble(1, getCoins(p)+amount);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void removeCoins(Player p, double amount){
        try {
            PreparedStatement ps = MySQL.con.prepareStatement("UPDATE BankCoins SET COINS = ? WHERE UUID = ?");
            ps.setDouble(1, getCoins(p)-amount);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}