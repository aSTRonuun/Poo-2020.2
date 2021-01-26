package entities;

public class Phone {
    
    private String id;
    private String number;

    public Phone(String id, String number){
        this.id = id;
        this.number = number;
    }

    public static boolean validate(String number){
        String validos = "0123456789()-";
        for(int i=0;i<number.length();i++){
            if(validos.indexOf(number.charAt(i)) == -1)
                return false;
        }
        return true;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return id + ":" + number;
    }
}
