import java.util.Scanner;

import controller.WhatsappService;

public class App{

    public static void main(String[] args) {

        WhatsappService whatsapp = new WhatsappService();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Whatsapp 📞-----------");

        while(true){
            try{
                String line = sc.nextLine();
                String[] ui = line.split(" ");
                if(ui[0].equals("end")){
                    break;
                }else if(ui[0].equals("addUser")){
                    whatsapp.createUser(ui[1]);
                }else if(ui[0].equals("newChat")){
                    whatsapp.creatChat(ui[1], ui[2]);
                }else if(ui[0].equals("allUsers")){
                    System.out.println(whatsapp.allUsers());
                }else if(ui[0].equals("chats")){
                    System.out.println(whatsapp.getChatsUser(ui[1]));
                }else if(ui[0].equals("users")){
                    System.out.println(whatsapp.getUsersChat(ui[1]));
                }else if(ui[0].equals("invite")){
                    whatsapp.addByInvite(ui[1], ui[2], ui[3]);
                }else if(ui[0].equals("leave")){
                    whatsapp.removeUserChat(ui[1], ui[2]);
                }else if(ui[0].equals("zap")){
                    String message = "";
                    for(int i=3;i<ui.length;i++)
                        message += ui[i]+" ";
                    whatsapp.sendMessage(ui[1], ui[2], message);
                }else if(ui[0].equals("notify")){
                    System.out.println(whatsapp.getNotifyUser(ui[1]));
                }else if(ui[0].equals("read")){
                    System.out.println(whatsapp.readMessageUserChat(ui[1], ui[2]));
                }else if(ui[0].equals("readAll")){
                    System.out.println(whatsapp.readAllMessageUserChat(ui[1], ui[2]));
                }else{
                    System.out.println("❌ Error: command invalid");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("❌ Error: Insufficient parameters to complete the operation");
            }catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}