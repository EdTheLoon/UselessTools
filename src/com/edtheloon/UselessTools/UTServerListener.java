package com.edtheloon.UselessTools;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class UTServerListener extends PlayerListener {
	
	public void onPlayerInteractEvent(PlayerInteractEvent event)
	{		
		int itemID = event.getItem().getTypeId();
		if (UTMain.config.tools.contains(itemID)) {
			event.setCancelled(true);
			UTMain.log.info("[UselessTools] Prevented item: " + itemID);
		}
		
	}
}
