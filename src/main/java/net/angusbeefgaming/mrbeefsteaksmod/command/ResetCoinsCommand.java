package net.angusbeefgaming.mrbeefsteaksmod.command;

import java.util.ArrayList;
import java.util.List;

import net.angusbeefgaming.mrbeefsteaksmod.events.Coins;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class ResetCoinsCommand implements ICommand
{

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "resetcoins";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/resetcoins";
	}

	@Override
	public List<String> getAliases() {
		List<String> alieses = new ArrayList<String>();
		alieses.add("resetcoins");
		alieses.add("resetcointer");
		return alieses;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		sender.sendMessage(new TextComponentString("You have reset your coin counter!"));
		Coins.totalCoins = 0;
		return;
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