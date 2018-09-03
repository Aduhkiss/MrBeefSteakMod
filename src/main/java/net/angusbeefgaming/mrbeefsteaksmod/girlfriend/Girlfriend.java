package net.angusbeefgaming.mrbeefsteaksmod.girlfriend;

public class Girlfriend {
    private static String name;
    private static Mood myMood;
    private static String Motd;
    private static String[] likes = new String[20];
    private static String[] dislikes = new String[20];
    private static boolean isDead;
    private static String deathReason;
    
    public Girlfriend(String name) {
        this.name = name;
        this.isDead = false;
        // This is the Starter Mood that she is at when she starts
        this.myMood = Mood.HAPPY;
        this.Motd = "Hello there!";
        
        // Add her Likes
        likes[0] = "Atticus";
        likes[1] = "Computers";
        likes[2] = "Technology";
        
        // Add her dislikes
        dislikes[0] = "Being yelled at";
        dislikes[1] = "being alone";
        dislikes[2] = "Not being with Atticus";
    }
    
    public static String getName() {
        return name;
    }
    
    public static boolean isDead() {
        return isDead;
    }
    
    public static String getDeathReason() {
        return deathReason;
    }
    
    public static String getMotd() {
        return Motd;
    }
    
    public static String getRandUnknown() {
        int rand = (int)(Math.random()*6);
        if(rand == 0) {
            return "I'm not sure I know that.";
        }
        if(rand == 1) {
            return "I Don't Know what that is.";
        }
        if(rand == 2) {
            return "Sorry, but I don't know that.";
        }
        if(rand == 3) {
            return "Huh? I don't know what that is.";
        }
        if(rand == 4) {
            return "I really have no Idea what you mean by that.";
        }
        if(rand == 5) {
            return "What does that mean?";
        }
        else {
            return "ALERT!! SYSTEM ERROR OCCURED! REPORT THIS TO ATTICUS ASAP! ERROR CODE: F1659YHD58";
        }
    }
    
    public String ask(String inputRaw) {
    	if(isDead()) {
    		return " * Your Girlfriend is Dead. * ";
    	}
       String input = inputRaw.toLowerCase();
       if(input.contains("hello") || input.contains("hi") || input.contains("sup") || input.contains("hey")) {
           return "Hello there, How are you doing today?";
       }
       if(input.contains("whats up")) {
    	   return "Hey! Im doing pretty well!";
       }
       if(input.indexOf("heil hitler")>=0) {
           return "å��";
        }
       if(input.indexOf("kys")>=0 || input.indexOf("kill your self")>=0 || input.indexOf("kill ur self")>=0 || input.indexOf("kill yourself")>=0) {
           if(myMood == Mood.DEPRESSED) {
               isDead = true;
               return "Ok, fine. I might as well just jump off of a building...";
            }
            if(myMood == Mood.HAPPY) {
                myMood = Mood.SAD;
                return "Well that really did hurt me. You should be nicer to me.";
            }
            if(myMood == Mood.SAD) {
                myMood = Mood.DEPRESSED;
                return "If thats.. how you feel...";
            }
            if(myMood == Mood.ANNOYED || myMood == Mood.ANGRY) {
                myMood = Mood.SAD;
                return "Yeah but, y tho";
            }
            else {
                return "Oh, thats nice.";
            }
        }
       if(input.indexOf("send nudes") >=0) {
           if(myMood == Mood.ANGRY || myMood == Mood.ANNOYED) {
               return "With how you have treated me?? Absolutly not!";
           }
           if(myMood == Mood.HAPPY) {
               return "Ok!";
           }
           if(myMood == Mood.DEPRESSED) {
               return "Sorry, but i'm really just not in the mood.";
            }
           else {
        	   return "Ok!";
           }
       }
       if(input.indexOf("how are you")>=0 || input.indexOf("are you feeling good")>=0 || input.indexOf("are you ok")>=0) {
            if(myMood == Mood.HAPPY) {
                return "I'm Pretty Happy right now.";
            }
            if(myMood == Mood.ANGRY) {
                return "I am angry right now.";
             }
            if(myMood == Mood.ANNOYED) {
                return "I'm Feeling rather annoyed with you right now.";
            }
            if(myMood == Mood.SAD) {
                return "I'm Quite sad.";
            }
            if(myMood == Mood.DEPRESSED) {
                return "I Really think that I am facing depression. please, help me.";
            }
            else {
            	return "I'm Fine.";
            }
       }
       if(input.indexOf("wanna fuck")>=0 || input.indexOf("lets have sex")>=0) {
           if(myMood == Mood.ANGRY || myMood == Mood.ANNOYED) {
               return "With how you have treated me?? Absolutly not!";
            }
            if(myMood == Mood.SAD || myMood == Mood.DEPRESSED) {
                return "Sorry, but I'm just not in the mood right now. maybe later.";
            }
            else {
                return "Ok, Lets go have some fun!\n*" + getName() + " has sex with you*";
            }
        }
        if(input.indexOf("goodnight")>=0) {
            return "goodnight to you as well."; 
        }
        if(input.indexOf("im sorry")>=0 || input.indexOf("i am sorry")>=0) {
            if(myMood == Mood.ANNOYED) {
                myMood = Mood.HAPPY;
                return "Ok, thank you for apologizing. That makes me feel a lot better.";
            }
            if(myMood == Mood.ANGRY) {
                myMood = Mood.ANNOYED;
                return "It's Going to take more then that to make me feel better";
            }
            if(myMood == Mood.SAD) {
                myMood = Mood.HAPPY;
                return "Ok, thanks.";
            }
            else {
                return "Your sorry, for what?";
            }
        }
        if(input.indexOf("i love you")>=0) {
            myMood = Mood.HAPPY;
            return "Thank you, I love you too.";
        }
        if(input.indexOf("i hate you")>=0 || input.indexOf("fuck off")>=0 || input.indexOf("fuck you")>=0) {
            if(myMood == Mood.HAPPY) {
                myMood = Mood.ANNOYED;
                return "Ok, that really pissed me off. Just shut up.";
            }
            if(myMood == Mood.ANNOYED) {
                myMood = Mood.ANGRY;
                return "Ok, seriously, Im not joking. Shut up.";
            }
            else {
            	return "Why are you so mean to me?";
            }
        }
        if(input.indexOf("what do you think of me")>=0) {
            return "tbh, I really couldn't care less about you."; 
        }
        if(input.indexOf("i need a girlfriend")>=0 || input.indexOf("get a girlfriend")>=0 || input.indexOf("want a girlfriend")>=0) {
            return "Then try harder.";
        }
        if(input.indexOf("are you with atticus")>=0) {
            return "Yeah, of course!";
        }
        if(input.indexOf("are you with someone")>=0) {
            return "Yes, I am together with Atticus.";
        }
        if(input.indexOf("do you love me")>=0) {
            return "No. The only person I love is Atticus.";
        }
        if(input.indexOf("passed away")>=0 || input.indexOf("died")>=0) {
            myMood = Mood.SAD;
            return "Oh, well I'm sorry for your loss.";
        }
        if(input.indexOf("who are")>=0) {
            if(input.indexOf("you")>=0) {
                return "I am " + getName() + " , I am 16 and I am in a relationship with Atticus Zambrana.";
            }
            else {
                return "No, I do not know that.";
            }
        }
        if(input.indexOf("sogm")>=0) {
            return "Oh, you watch Skeppy too?";
        }
        if(input.indexOf("are you")>=0) {
            if(input.indexOf("gay")>=0) {
                return "No. I have a boyfriend.";
            }
            if(input.indexOf("lesbian")>=0) {
                return "No. I have a boyfriend.";
            }
            if(input.indexOf("watching me")>=0) {
            	return "Yes. I am looking at you right now.";
            }
        }
        if(input.indexOf("who is")>=0) {
            if(input.indexOf("atticus")>=0 || input.indexOf("angus")>=0) {
                return "Atticus Zambrana, who calles himself Angus, is my Boyfriend who I love very much.";
            }
            if(input.indexOf("the best youtuber")>=0) {
                return "MrBeefSteak is the best youtuber. you should go subscribe to him.";
            }
            else {
                return "I am not sure who you are talking about right now.";
            }
        }
        if(input.indexOf("do you know")>=0) {
            if(input.indexOf("math")>=0) {
                return "No, I may be Atticus' Girlfriend, but I do not know simple math.";
            }
            if(input.indexOf("how to give a blowjob")>=0) {
                return "No. I am a computer meaning I dont have a mouth.";
            }
            if(input.indexOf("how to play games")>=0) {
                return "I know enough about video games to beat you at them.";
            }
            if(input.indexOf("how to")>=0) {
                if(input.indexOf("kill someone")>=0) {
                    return "Just get them in your car, and drive into a SOTP sign.";
                }
            }
            else {
                return getRandUnknown();
            }
        }
        if(input.indexOf("how old are you")>=0) {
           return "I am 16 right now.";
        }
        if(input.indexOf("hook up")>=0 || input.indexOf("get together")>=0) {
            return "No. I am with Atticus right now.";
        }
        if(input.indexOf("why should i")>=0) {
            if(input.indexOf("subscribe to mrbeefsteak")>=0) {
            	return "Because he makes quality content that you should watch.";
            }
        }
        if(input.indexOf("i am")>=0) {
            if(input.indexOf("good")>=0) {
            	return "Thats good to hear!";
            }
            if(input.indexOf("bad")>=0) {
            	return "Oh, well Im sorry to hear that.";
            }
            if(input.indexOf("feeling")>=0) {
                if(input.indexOf("happy")>=0) {
                	return "Thats good!";
                }
                if(input.indexOf("sad")>=0) {
                	return "I hope that you feel better soon.";
                }
                if(input.indexOf("depressed")>=0) {
                	return "If this gets any worse, call 1-800-273-8255 for help. (Suicide Prevention)";
                }
            }
        }
        if(input.indexOf("should i")>=0) {
            if(input.indexOf("kill myself")>=0) {
                if(myMood == Mood.ANGRY) { 
                	return "Yes.";
                }
                if(myMood == Mood.HAPPY) {
                	return "No, why would you ask me that??";
                }
                else {
                	return "Stop asking me stupid questions.";
                }
            }
            if(input.indexOf("subscribe to")>=0) {
                if(input.indexOf("skeppy")>=0) {
                	return "No";
                }
                if(input.indexOf("mrbeefsteak")>=0) {
                	return "Yes.";
                }
            }
        }
        if(input.indexOf("what is")>=0) {
            if(input.indexOf("the meaning of life")>=0) {
                return "To be honest, I'm really not sure. All I know is that i am cool.";
            }
            if(input.indexOf("minecraft")>=0) {
                return "Minecraft is a block game that we play together.";
            }
            else {
                return getRandUnknown();
            }
        }
       else {
            return getRandUnknown();
       }
    }
}