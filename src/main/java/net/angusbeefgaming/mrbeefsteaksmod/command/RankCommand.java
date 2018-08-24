package net.angusbeefgaming.mrbeefsteaksmod.command;

import java.util.ArrayList;
import java.util.List;

import net.angusbeefgaming.backend.Rank;
import net.angusbeefgaming.backend.UserManager;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class RankCommand implements ICommand
{

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "rank";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/rank <Player>";
	}

	@Override
	public List<String> getAliases() {
		List<String> alieses = new ArrayList<String>();
		alieses.add("rank");
		return alieses;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		String invokerName = sender.getName();
		Rank invokerRank = UserManager.getRank(invokerName);
		
		if(invokerRank != Rank.ADMINISTRATOR) {
			sender.sendMessage(new TextComponentString("\2479Permissions> \2477This requires Permission Rank [\2479DEVELOPER\2477]"));
			return;
		}
		else {
			if(args.length < 1) {
				sender.sendMessage(new TextComponentString("Please enter a player name."));
				return;
			}
			
			sender.sendMessage(new TextComponentString(args[0] + " is a " + UserManager.getRank(args[0])));
			return;
		}
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		List<String> alieses = new ArrayList<String>();
		alieses.add("can");
		alieses.add("you");
		alieses.add("like");
		alieses.add("dont?");
		return alieses;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}
}