package me.TheOndra.MicroGames.Games;

import me.TheOndra.MicroGames.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Parkour implements Listener{

    private void onEnd(){

        for (Player players : Bukkit.getOnlinePlayers()){
            players.setWalkSpeed(0);
            Location loc = players.getLocation();
            Location blockLocation = new Location(players.getWorld(), loc.getBlockX(), loc.getBlockY() - 1, loc.getBlockZ());
            Block block = blockLocation.getBlock();
            Material item = block.getType();
            if (item == Material.GOLD_PLATE){
                //!!! Savesi, dodělat přidání bodů + resetovací metodu!!!
            } else {
                //!!! Savesi, dodělat metodu na to, aby to člověka hodilo do SPECTATORU!!!
            }
        }
    }

    private void onParkour(){
        Location location = new Location(Bukkit.getWorld(""),0,0,0);

        for (Player players : Bukkit.getOnlinePlayers()){
            players.teleport(location);

            //!!!!! Dodělat zprávu Savesi!!!!!!!
        }

        Bukkit.getServer().getScheduler().runTaskLater(Main.getPlugin(), () -> this.onEnd(), 400);
    }


}
