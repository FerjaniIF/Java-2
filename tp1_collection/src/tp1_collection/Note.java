package tp1_collection;

public class Note implements Statisticable, Comparable<Note> {
	private String cours;
	private float note;
	
	public Note(String cours, float note) {
        this.cours = cours;
        this.note = note;
    }

    public String getCours() {
        return cours;
    }

    public float getNote() {
        return note;
    }
    
    public void setCours(String cours) {
        this.cours = cours;
    }

    public void setNote(float note) {
        this.note = note;
    }
    
    @Override
	public float getValue() {
		return this.getNote();
	}
    
    @Override
	public int compareTo(Note n) {
		if(this.getValue() == n.getValue()) {
			return 0;
		}
		else if (this.getValue() > n.getValue()) {
			return 1;
		}
		else
			return -1;
	}
    
    @Override
    public String toString() {
    	return " cours =" + cours + "| note =" + note;
    }
}

