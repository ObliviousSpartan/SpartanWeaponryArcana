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

import com.oblivioussp.spartanweaponryarcana.util.Reference;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler
{
	protected static SimpleNetworkWrapper instance;
	protected static int currentId = 0;

	public static void init()
	{
		instance = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.ModID.toLowerCase());

		instance.registerMessage(PacketManaBurst.class, PacketManaBurst.class, getNextPacketId(), Side.SERVER);
	}
	
	public static int getNextPacketId()
	{
		int id = currentId;
		currentId++;
		return id;
	}

	public static void sendPacketToAll(PacketBase packet)
	{
		instance.sendToAll(packet);
	}

	public static void sendPacketTo(PacketBase packet, EntityPlayerMP player)
	{
		instance.sendTo(packet, player);
	}

	public static void sendPacketToAllAround(PacketBase packet, TargetPoint point)
	{
		instance.sendToAllAround(packet, point);
	}
	
	/*public static void sendPacketToAllAround(PacketBlockPos packet, World world)
	{
		instance.sendToAllAround(packet, new TargetPoint(world.provider.getDimension(), packet.pos.getX(), packet.pos.getY(), packet.pos.getZ(), 64.0));
	}*/

	public static void sendPacketToDimension(PacketBase packet, int dimensionId)
	{
		instance.sendToDimension(packet, dimensionId);
	}

	public static void sendPacketToServer(PacketBase packet)
	{
		instance.sendToServer(packet);
	}

}
