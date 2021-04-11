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
    }
}