
package collegecostapi.model;

public final class College {
    private String collegeName;
    private int tuitionInState;
    private int tuitionOutOfState;
    private int roomAndBoard;
    
    public College(){
        
    }
    
        public College(String collegeName, int tuitionInState, int tuitionOutOfState, 
            int roomAndBoard) {
        this.setCollegeName(collegeName);
        this.setTuitionInState(tuitionInState);
        this.setTuitionOutOfState(tuitionOutOfState);
        this.setRoomAndBoard(roomAndBoard);
    }
        
      public void setCollegeName(String collegeName) throws IllegalArgumentException{
        if(collegeName == null || collegeName.isEmpty()){
            throw new IllegalArgumentException("College name cannot be null or empty.");
        }
        this.collegeName = collegeName;
    }

    public void setTuitionInState(int tuitionInState){
        this.tuitionInState = tuitionInState;
    }

    public void setTuitionOutOfState(int tuitionOutOfState) {
        this.tuitionOutOfState = tuitionOutOfState;
    }

    public void setRoomAndBoard(int roomAndBoard){
        this.roomAndBoard = roomAndBoard;
    }
    
    public String getCollegeName(){
        return collegeName;
    }
    
    public int getTuitionInState(){
        return tuitionInState;
    }
    
    public int getTuitionOutOfState(){
        return tuitionOutOfState;
    }
    
    public int getRoomAndBoard(){
        return roomAndBoard;
    }
    
   
}
