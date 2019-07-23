package com.oblivioussp.spartanweaponryarcana.util;

/**
 * Copyright (C) 2019  ObliviousSpartan
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses.
*/

import com.oblivioussp.spartanweaponry.api.IWeaponPropertyContainer;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.item.ItemThrowingWeapon;
import com.oblivioussp.spartanweaponryarcana.network.NetworkHandler;
import com.oblivioussp.spartanweaponryarcana.network.PacketManaBurst;
import com.oblivioussp.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber
public class EventHandler 
{
	protected static int tickCounter = 0;
	
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent ev)
	{
		if(ev.side == Side.SERVER && ev.phase == Phase.END)
		{
			tickCounter++;
			if(tickCounter == 20)
			{
				tickCounter = 0;
			}
		}
	}
	
	public static int getTickCounter()
	{
		return tickCounter;
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onAttackMiss(PlayerInteractEvent.LeftClickEmpty ev)
	{
		if(ev.getEntityPlayer() != null)
		{
			EntityPlayer player = ev.getEntityPlayer();
			if(!ev.getItemStack().isEmpty() && ev.getItemStack().getItem() instanceof IWeaponPropertyContainer && !(ev.getItemStack().getItem() instanceof ItemThrowingWeapon))
			{
				WeaponProperty prop = ((IWeaponPropertyContainer)ev.getItemStack().getItem()).getFirstWeaponPropertyWithType(WeaponPropertySWA.TYPE_TERRA_SLASH);
				
				if(prop != null)
				{
					NetworkHandler.sendPacketToServer(new PacketManaBurst());
					//LogHelper.info("Sent Mana Burst Packet!");
				}
				//LogHelper.info(player.getCooledAttackStrength(0.0f));
				/*if(prop != null && player.getCooledAttackStrength(0.0f) == 1.0f)
				{
					LogHelper.info("Terra Slash spawned! (SOON^TM)");
				}*/
			}
		}
	}
}
