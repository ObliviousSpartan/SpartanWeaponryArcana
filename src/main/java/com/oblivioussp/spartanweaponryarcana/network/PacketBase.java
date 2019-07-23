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

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public abstract class PacketBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ>
{
	@Override
	public REQ onMessage(final REQ message, final MessageContext ctx)
	{
		IThreadListener mainThread;
		if (ctx.side.isServer())
		{
			//mainThread = ctx.getServerHandler().player.getServer();
			EntityPlayerMP player = ctx.getServerHandler().player;
			player.server.addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					handleServerSide(message, player);
				}
			});
			
		}
		else
		{
			mainThread = Minecraft.getMinecraft();
			mainThread.addScheduledTask(new Runnable()
			{
				@Override
				public void run()
				{
					handleClientSide(message, Minecraft.getMinecraft().player);
				}
			});
		}
		return null;
	}

	/**
	 * Handle a packet on the client side. Note this occurs after decoding has completed.
	 * 
	 * @param message
	 * @param player
	 *            Reference to the Player
	 */
	public abstract void handleClientSide(REQ message, EntityPlayer player);

	/**
	 * Handle a packet on the server side. Note this occurs after decoding has completed.
	 * 
	 * @param message
	 * @param player
	 *            Reference to the Player
	 */
	public abstract void handleServerSide(REQ message, EntityPlayerMP player);
}
