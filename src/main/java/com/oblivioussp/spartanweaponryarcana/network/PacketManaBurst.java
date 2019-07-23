package com.oblivioussp.spartanweaponryarcana.network;

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
import com.oblivioussp.spartanweaponry.util.LogHelper;
import com.oblivioussp.spartanweaponryarcana.util.ManaBurstHelper;
import com.oblivioussp.spartanweaponryarcana.weaponproperty.WeaponPropertySWA;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import vazkii.botania.common.core.handler.ModSounds;
import vazkii.botania.common.core.helper.ItemNBTHelper;
import vazkii.botania.common.entity.EntityManaBurst;
import vazkii.botania.common.item.equipment.tool.ToolCommons;

public class PacketManaBurst extends PacketBase<PacketManaBurst>
{
	public PacketManaBurst() {}
	
	@Override
	public void fromBytes(ByteBuf buf)
	{
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
	}

	@Override
	public void handleClientSide(PacketManaBurst message, EntityPlayer player) 
	{
	}

	@Override
	public void handleServerSide(PacketManaBurst message, EntityPlayerMP player)
	{
		ItemStack mainStack;
		
		//LogHelper.info("Received Mana Burst Packet! Processing...");
		
		if(player == null)	return;
		
		mainStack = player.getHeldItem(EnumHand.MAIN_HAND);
		
		if(!mainStack.isEmpty() && mainStack.getItem() instanceof IWeaponPropertyContainer)
		{
			IWeaponPropertyContainer container = ((IWeaponPropertyContainer)mainStack.getItem());
			
			if(container.hasWeaponProperty(WeaponPropertySWA.TerraSlash))
			{
				ManaBurstHelper.trySpawnBurst(player);
				//LogHelper.info("Spawned Mana Burst!");
			}
		}
	}

}
