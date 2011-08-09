package com.edtheloon.UselessTools;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class UTServerListener extends PlayerListener {
	
	public void onPlayerInteract(PlayerInteractEvent event)
	{		
		int itemID = event.getItem().getTypeId();
		if (UTMain.config.tools.contains(itemID)) {
			event.setCancelled(true);
			UTMain.log.info("[UselessTools] Prevented " + event.getPlayer().getName() + " from using item " + itemID);
		}
	}
}
