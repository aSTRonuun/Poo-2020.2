package entities;

public class Phone {
    
    private String label;
    private String number;

    public Phone(String label, String number){
        this.label = label;
        this.number = number;
    }

    public String getLabel() {
        return label;
    }

    public String getNumber() {
        return number;
    }
    
    public static boolean validate(String number){
        //Inser valid character string
        String valids = "0123456789()-";
        for(int i=0;i<number.length();i++){
            if(valids.indexOf(number.charAt(i)) == -1)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        exit.append(label + ":" + number);
        return exit.toString();
    }

}
