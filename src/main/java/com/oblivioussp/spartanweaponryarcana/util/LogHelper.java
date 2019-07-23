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

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.FMLLog;

public class LogHelper
{
	private static final Logger LOG = LogManager.getLogger(Reference.ModName);
	
	public static void debug(Object object) {	LOG.debug(object); }

	public static void error(Object object) {	LOG.error(object); }

	public static void fatal(Object object) {	LOG.fatal(object); }

	public static void info(Object object) {	LOG.info(object); }

	public static void trace(Object object) {	LOG.trace(object); }

	public static void warn(Object object) {	LOG.warn(object); }
}
