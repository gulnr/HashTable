
public class HashEntry {
	
    private int key = 0;
    private String value = null;
    private HashEntry next = null;

    HashEntry(int key, String value) {
          this.key = key;
          this.value = value;
          this.next = null;
    }

    public String getValue() {
          return value;
    }

    public void setValue(String value) {
          this.value = value;
    }

    public int getKey() {
          return key;
    }

    public HashEntry getNext() {
          return next;
    }

    public void setNext(HashEntry next) {
          this.next = next;
    }
    public String toString(){
    	return value;
    }
}
