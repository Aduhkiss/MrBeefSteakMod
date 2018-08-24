package net.angusbeefgaming.mrbeefsteaksmod.command;

import java.util.ArrayList;
import java.util.List;

import net.angusbeefgaming.mrbeefsteaksmod.Main;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;

public class GirlfriendCommand implements ICommand
{

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "gf";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/gf <Message>";
	}

	@Override
	public List<String> getAliases() {
		List<String> alieses = new ArrayList<String>();
		alieses.add("girlfriend");
		return alieses;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

		if(args.length < 1) {
			sender.sendMessage(new TextComponentString("You must provide a message."));
			return;
		}
		
        StringBuilder message = new StringBuilder();

        for(int i = 0; i < args.length; ++i) {
        	message = message.append(args[i] + " ");
        }
        
        sender.sendMessage(new TextComponentString(Main.getGirlfriend().ask(message.toString())));
        
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