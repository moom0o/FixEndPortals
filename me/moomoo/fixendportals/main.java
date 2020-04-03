package me.moomoo.fixendportals;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.JavaPlugin;
public class main extends JavaPlugin implements Listener {

    public void onEnable() {
        System.out.println("[ENABLED] moomoo's fixendportals plugin, originally made for 1b1t.tk");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);


    }
    public void onDisable() {
        System.out.println("[DISABLED] moomoo's fixendportals plugin, originally made for 1b1t.tk. Goodnight.");
    }
    @EventHandler
    private void onPlayerBucketEvent(PlayerBucketEmptyEvent evt) {
        String playerName = evt.getPlayer().getName();
        String type = evt.getBlockClicked().getType().toString();
        String face = evt.getBlockFace().toString();
        if(type == "ENDER_PORTAL_FRAME"){
            if(face == "NORTH" || face == "EAST" || face == "SOUTH" || face == "WEST"){
                evt.setCancelled(true);
                evt.getPlayer().sendMessage("Destroying end portals has been patched!");
                System.out.println("Prevented " + playerName + " from destroying a portal!");
            }
        }

    }

}
