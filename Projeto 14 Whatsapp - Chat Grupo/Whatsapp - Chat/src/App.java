import controller.WhatsappService;

public class App{

    public static void main(String[] args) {
        WhatsappService whatsapp = new WhatsappService();
        whatsapp.createUser("goku");
        whatsapp.createUser("sara");
        whatsapp.createUser("tina");
        System.out.println(whatsapp.allUsers());
        whatsapp.creatChat("goku", "guerreiros");
        whatsapp.creatChat("goku", "homens");
        whatsapp.creatChat("sara", "familia");
        System.out.println(whatsapp.getChatsUser("goku"));
        System.out.println(whatsapp.getChatsUser("sara"));
        System.out.println(whatsapp.getChatsUser("tina"));
        whatsapp.addByInvite("goku", "sara", "guerreiros");
        whatsapp.addByInvite("sara", "tina", "guerreiros");
        System.out.println(whatsapp.getChatsUser("sara"));
        System.out.println(whatsapp.getChatsUser("tina"));
        System.out.println(whatsapp.getChatsUser("goku"));
        System.out.println(whatsapp.getUsersChat("guerreiros"));
        System.out.println(whatsapp.getUsersChat("familia"));
        whatsapp.removeUserChat("sara", "guerreiros");
        System.out.println(whatsapp.getUsersChat("guerreiros"));
        System.out.println(whatsapp.getChatsUser("sara"));
        whatsapp.sendMessage("goku", "guerreiros", "oi, eu sou o goku");
        whatsapp.sendMessage("tina", "guerreiros", "oi goku");
        System.out.println(whatsapp.getNotifyUser("goku"));
        System.out.println(whatsapp.getNotifyUser("tina"));
        System.out.println(whatsapp.readMessageUserChat("goku", "guerreiros"));
        System.out.println(whatsapp.readMessageUserChat("tina", "guerreiros"));
        whatsapp.sendMessage("goku", "guerreiros", "vamos sair tina?");
        whatsapp.sendMessage("tina", "guerreiros", "voce ta com fome goku?");
        whatsapp.sendMessage("goku", "guerreiros", "to com saudade de voce.");
        System.out.println(whatsapp.getNotifyUser("tina"));
        System.out.println(whatsapp.getNotifyUser("goku"));
        System.out.println(whatsapp.readMessageUserChat("goku", "guerreiros"));
        System.out.println(whatsapp.readMessageUserChat("tina", "guerreiros"));
    }
}