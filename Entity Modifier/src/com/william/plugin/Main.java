package com.william.plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener{

	@Override
	public void onEnable() {
		System.out.println("Entity Modifier plugin has worked (sorta)");
		
		//Spawn blaze (entity) at -214, 80, 270:
		Entity theBlaze = Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), -214, 80, 270), EntityType.BLAZE);
		
		//Entity can't be harmed:
		theBlaze.setInvulnerable(true);
		
		//Each entity is different and therefore has it's own methods, we need to tell Java that out entity is a blaze to use blaze methods:
		Blaze blaze = (Blaze) theBlaze;
		
		//Give the blaze a name:
		blaze.setCustomName("Flamey");
		
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("Entity Modifier disabled");
	}
	
	@EventHandler
	public void entity(EntityDeathEvent e) {
		Entity ent = e.getEntity();
		World world = Bukkit.getWorld("world");
		
		//Plays the horse dying sound for whenever any mob dies:
		world.playSound(ent.getLocation(), Sound.ENTITY_HORSE_DEATH, 10, 1);
	}
	
}
