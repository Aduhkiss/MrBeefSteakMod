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

public class ResetListsCommand implements ICommand
{

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "resetlists";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/resetlists";
	}

	@Override
	public List<String> getAliases() {
		List<String> alieses = new ArrayList<String>();
		alieses.add("resetlists");
		return alieses;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		UserManager.devRanked.clear();
		UserManager.youtubeRanked.clear();
		UserManager.defaultRanked.clear();
		sender.sendMessage(new TextComponentString("All Lists have been reset!"));
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