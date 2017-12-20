package LRU;

public interface Cache {
	/**
	 * Gets the value of the key x if the key exists in the cache otherwise returns -1
	 * @param x
	 * @return
	 */
	 int get(int x);
	 
	 /**
	  * set the value of key x as y in the Cache
	  * @param x
	  * @param y
	  */
	 void set(int x, int y);
}
