package entities;

public class ContactPlus extends Contact{

    private boolean starred;

    public ContactPlus(String name) {
        super(name);
        starred = false;
    }
    public boolean getStarred(){
        return this.starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }
    @Override
    public String toString() {
        StringBuilder exit = new StringBuilder();
        exit.append(this.starred ? "@" + this.name : "-" + this.name);
        int i=0;
        for(Phone phone : phones){
            exit.append(" [" + i + ":" + phone.toString() + "]");
            i++;
        }
        return exit.toString();
    }
    
}
