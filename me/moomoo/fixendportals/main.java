package me.moomoo.fixendportals;

import com.sun.istack.internal.NotNull;
import net.minecraft.server.v1_12_R1.SourceBlock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.HandlerList;

import org.bukkit.event.entity.ProjectileLaunchEvent;
public class main extends JavaPlugin implements Listener {
    private static final HandlerList handlers = new HandlerList();

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
