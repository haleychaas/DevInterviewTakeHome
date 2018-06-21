package collegecostapi.controller;

public class EntityNotFoundException extends Exception{

    private static String msg = "Error: College not found";
    
    public EntityNotFoundException(){
        super(msg);
    }
}
