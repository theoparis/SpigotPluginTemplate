package me.creepinson.plugin.util;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;

import com.google.common.collect.Sets;

import net.minecraft.server.v1_12_R1.EntityInsentient;
import net.minecraft.server.v1_12_R1.PathfinderGoalSelector;


public class PathfinderUtil {
	
	public void removePathFinders(Entity entity) {
		net.minecraft.server.v1_12_R1.Entity nmsEntity = ((CraftEntity) entity).getHandle();
		try {
			Field bField = PathfinderGoalSelector.class.getDeclaredField("b");
			bField.setAccessible(true);
			Field cField = PathfinderGoalSelector.class.getDeclaredField("c");
			cField.setAccessible(true);
			bField.set(((EntityInsentient) nmsEntity).goalSelector, Sets.newLinkedHashSet());
			bField.set(((EntityInsentient) nmsEntity).targetSelector, Sets.newLinkedHashSet());
			cField.set(((EntityInsentient) nmsEntity).goalSelector, Sets.newLinkedHashSet());
			cField.set(((EntityInsentient) nmsEntity).targetSelector, Sets.newLinkedHashSet());
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
