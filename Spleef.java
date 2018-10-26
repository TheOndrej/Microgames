package me.TheOndra.MicroGames.Games;

import me.TheOndra.MicroGames.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Spleef implements Listener{

    private void onEnd(){
        Main.getPlugin().getMinigame().remove("spleef");
        for (Player players : Bukkit.getOnlinePlayers()){
            if (players.getGameMode() == GameMode.SURVIVAL){
                // Savesi, dodělat přidání bodů + ukončovací metodu !!!
            }
        }
    }
    private void onSpleef(){
        Bukkit.getServer().getScheduler().runTaskLater(Main.getPlugin(), () -> this.onEnd(), 1200);
        for (Player players : Bukkit.getOnlinePlayers()){
            //!!! Savesi, dodělat zprávu !!!
            Location loc = new Location(Bukkit.getWorld(""),0,0,0);
            players.teleport(loc);

            Main.getPlugin().getMinigame().add("spleef");
            ItemStack shovel = new ItemStack(Material.IRON_SPADE);
            players.getInventory().addItem(shovel);
        }
    }

    @EventHandler
    public void onDestroy(BlockBreakEvent e){
        Player p = e.getPlayer();

        if (Main.getPlugin().getMinigame().contains("spleef")) {
            e.getBlock().getDrops().clear();
            Location blockLocation = e.getBlock().getLocation();

            p.getWorld().spawnParticle(Particle.CLOUD, blockLocation, 50);

            if (e.getBlock().getType() == Material.TNT) {
                Location locDestroy1 = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ() - 1);
                Location locDestroy2 = new Location(blockLocation.getWorld(), blockLocation.getBlockX(), blockLocation.getBlockY(), blockLocation.getBlockZ() + 1);
                Location locDestroy3 = new Location(blockLocation.getWorld(), blockLocation.getBlockX() - 1, blockLocation.getBlockY(), blockLocation.getBlockZ());
                Location locDestroy4 = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 1, blockLocation.getBlockY(), blockLocation.getBlockZ());
                Location locDestroy5 = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 1, blockLocation.getBlockY(), blockLocation.getBlockZ() + 1);
                Location locDestroy6 = new Location(blockLocation.getWorld(), blockLocation.getBlockX() - 1, blockLocation.getBlockY(), blockLocation.getBlockZ() + 1);
                Location locDestroy7 = new Location(blockLocation.getWorld(), blockLocation.getBlockX() - 1, blockLocation.getBlockY(), blockLocation.getBlockZ() - 1);
                Location locDestroy8 = new Location(blockLocation.getWorld(), blockLocation.getBlockX() + 1, blockLocation.getBlockY(), blockLocation.getBlockZ() - 1);

                Material air = Material.AIR;
                locDestroy1.getBlock().setType(air);
                locDestroy2.getBlock().setType(air);
                locDestroy3.getBlock().setType(air);
                locDestroy4.getBlock().setType(air);
                locDestroy5.getBlock().setType(air);
                locDestroy6.getBlock().setType(air);
                locDestroy7.getBlock().setType(air);
                locDestroy8.getBlock().setType(air);

                p.getWorld().spawnParticle(Particle.CLOUD, locDestroy1, 10);
                p.getWorld().spawnParticle(Particle.CLOUD, locDestroy2, 10);
                p.getWorld().spawnParticle(Particle.CLOUD, locDestroy3, 10);
                p.getWorld().spawnParticle(Particle.CLOUD, locDestroy4, 10);
                p.getWorld().spawnParticle(Particle.CLOUD, locDestroy5, 10);
                p.getWorld().spawnParticle(Particle.CLOUD, locDestroy6, 10);
                p.getWorld().spawnParticle(Particle.CLOUD, locDestroy7, 10);
                p.getWorld().spawnParticle(Particle.CLOUD, locDestroy8, 10);
            }
        }
    }

    @EventHandler
    public void onDead(PlayerDeathEvent e){
        Player p = e.getEntity();

        if (Main.getPlugin().getMinigame().contains("spleef")){
            //!!! Savesi, dodělat metodu na hození hráče jako SPECTORA !!!
        }
    }
}
