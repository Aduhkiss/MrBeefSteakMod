package net.angusbeefgaming.anticheat.handler;

import net.angusbeefgaming.mrbeefsteaksmod.util.Maths;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LivingAttackHandler {
	@SubscribeEvent
	public void attack(AttackEntityEvent e) {
		
		EntityPlayer player = e.getEntityPlayer();
		Entity ent = e.getEntity();

		double pl1X = player.posX;
		double pl1Z = player.posX;
		
		System.out.println("DEBUG: P1 Pos:" + Math.round(pl1Z) + "," + Math.round(pl1Z));
		
		double pl2X = ent.posX;
		double pl2Z = ent.posX;
		
		System.out.println("DEBUG: P2 Pos:" + Math.round(pl2Z) + "," + Math.round(pl2Z));
		
		double hold1 = pl1Z - pl2Z;
		double hold2 = pl1X - pl2X;
		
		int hold3 = (int) Maths.squareNum(hold1);
		int hold4 = (int) Maths.squareNum(hold2);
		
		int number = hold3 + hold4;
		
		int distance = (int) Math.sqrt(number);
		
		System.out.println("DISTANCE: " + distance);
		
		
	}
}
