package net.angusbeefgaming.mrbeefsteaksmod.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommunicationMessage implements IMessage {


    public CommunicationMessage() { }

    @Override
    public void fromBytes(ByteBuf byteBuf) {

    }

    @Override
    public void toBytes(ByteBuf byteBuf) {

    }


    public static class Handler implements IMessageHandler<CommunicationMessage, IMessage> {

        @Override
        public IMessage onMessage(CommunicationMessage message, MessageContext ctx) {
            System.out.println(String.format("Recived Login Packet"));
            return null; // no response in this case
        }
    }
}