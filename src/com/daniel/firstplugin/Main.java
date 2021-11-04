package com.daniel.firstplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
	// when the plugin is ran for first time it will run this block of code.
		
		System.out.println("First plugin has worked!");
	}

	@Override
	public void onDisable() {
		
	}
}
