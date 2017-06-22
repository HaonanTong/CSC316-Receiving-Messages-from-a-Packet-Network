/**
 * This program organizes data with type Message number, Packet number,
 * and Message into an organized linked list in order to print out all input
 * data in an organized format.
 * @author Ezra Zerihun, Zewdu Beshah, Haonan Tong
 */
public class SinglyLinkedList{
	/**
	 * ADT to make a single list
	 */
	private static class Node{
		private int PN = 0;//Package number arbitrary num; message number;
		private int ON = 0;//Order number of a package start from 1; package number;
		private String MS = null;//Message information;
		private Node next = null;
		/**
		 * Instantiates all the linked list variables.
		 * @param PN message number (package number)
		 * @param ON packet number (order number)
		 * @param MS message
		 * @param n node object
		 */
		public Node(int PN, int ON, String MS, Node n){
			this.PN = PN;
			this.ON = ON;
			this.MS = MS;
			this.next = n;
		}
		
		/**
		 * Method to get message number.
		 * @return message number.
		 */
		public int getPN(){ 
			return PN; 
		}
		
		/**
		 * Method to get packet number.
		 * @return packet number.
		 */
		public int getON(){ 
			return ON; 
		}
		
		/**
		 * Method to get message.
		 * @return message.
		 */
		public String getMS(){ 
			return MS; 
		}
		
		/**
		 * Method to get the next Node.
		 * @return next node.
		 */
		public Node getNext(){ 
			return next; 
		}
		
		/**
		 * Method to set the message.
		 * @param message.
		 */
		public void setMessage(String Message){ 
			this.MS = Message;
		} 

		/**
		 * Set the next node.
		 * @param the next node.
		 */
		public void setNext(Node n) {
			this.next = n;
		}
	}
	
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	public SinglyLinkedList(){}
	
	/**
	 * Return the size of the list.
	 * @return the size.
	 */
	public int size(){ 
		return size; 
	}
	
	/**
	 * Return whether the size is empty.
	 * @return whether the size is empty or not.
	 */
	public boolean isEmpty(){ 
		return size == 0; 
	}
	
	/**
	* Method to check first input.
	* @return if input is empty or not.
	*/
	public boolean first(){
		if( isEmpty() )
			return false;
		System.out.println(this.head.getPN());
		System.out.println(this.head.getON());
		System.out.println(this.head.getMS());
		return true;
	}
	
	/**
	 * Method to check last input.
	 * Return whether the input is empty or not.
	 */
	public boolean last(){
		if( isEmpty() )
			return false;
		System.out.println(this.head.getPN());
		System.out.println(this.head.getON());
		System.out.println(this.head.getMS());
		return true;
	}
	
	/**
	 * Adds the first input.
	 * @param PN message number.
	 * @param ON packet number.
	 * @param MS message.
	 */
	public void addFirst(int PN, int ON, String MS){
		head = new Node(PN, ON, MS, head);
		if(size == 0){
			tail = head;
		}
		size ++;
	}
	
	/**
	 * Adds the last input.
	 * @param PN message number.
	 * @param ON packet number.
	 * @param MS message.
	 */
	public void addLast(int PN, int ON, String MS){
		Node tmp = new Node(PN, ON, MS, null);
		if (isEmpty()) 
			head = tail = tmp;
		else
			{
				tail.setNext(tmp);
				tail = tmp;
			}
		size ++;
	}
	
	/**
	 * Converts the list into string format.
	 * @return list in string format.
	 */
	public String print(){
		String data = "";
		for (Node tmp = head; tmp != null; tmp = tmp.next )
		{
			if(tmp != head)
				data += (tmp.getMS() + "\n");

			if(tmp.next != null && (tmp.next.getPN() == tmp.getPN()) && ((tmp.getON() + 1) != tmp.next.getON())) {
				int counter = tmp.next.getON() - tmp.getON();
				for ( int i = 1 ; i < counter ; i ++){
					data += ("WARNING: packet " + (tmp.getON() + i) + " of message " + tmp.getPN() + " is missing" + "\n");
				}
			}
			if(tmp.next != null && tmp.getPN() != tmp.next.getPN()) {
				if( tmp != head ){
					data += ("--- End Message " + tmp.getPN() + "\n");
					data += ("\n");
				}
				data += ("--- Message " + tmp.next.getPN() + "\n");
				if(tmp.next != null  && (tmp.next.getON() != 1)) {	//first package of a message is missing			
					int counter = tmp.next.getON();
					for ( int i = 1 ; i < counter ; i ++){
						data += ("WARNING: packet " + i + " of message " + tmp.next.getPN() + " is missing" + "\n");
					}
				} 
			} 
			
			if(tmp.next == null && tmp != head){
				data += ("--- End Message " + tmp.getPN());
			}
		}
		return data;
	}

	/**
	 * Adds the input.
	 * @param PN message number.
	 * @param ON packet number.
	 * @param MS message.
	 */
	public void addNode(int PN, int ON, String MS) {// add nodes in our sequeces;
		int t_Cover = 0;// To test if there is a cover on the package;
		int tmp1 = this.size();
		if (head == null) {
			Node tmp = new Node(PN, ON, MS, null);
			//head.setNext(tmp);
			head = new Node(0, 0, null, tmp);
			size ++;
			size ++;
		} else {
			Node current = head;
			Node current_pre = current;
			// while (current.getNext() != null && current.next.getPN() < PN
			// && current.next.getON() < ON) {
			// current = current.getNext();
			// }
			// Node tmp = new Node(PN, ON, MS, current.getNext());
			// current.setNext(tmp);
			// size++;
			while (this.size == tmp1) {	
				if ( current.getPN() < PN ) {
					if (current.next == null) {
						Node tmp = new Node(PN, ON, MS, current.getNext());
						current.setNext(tmp);
						size++;
					}
					current_pre = current;
					current = current.next;
				} else if (current.getPN() == PN) {
					if (current.getON() < ON) {
						if (current.next == null) {
							Node tmp = new Node(PN, ON, MS, current.getNext());
							current.setNext(tmp);
							size++;
						}
						current_pre = current;
						current = current.next;
					} else if (current.getON() == ON) {//cover happens
						Node tmp = new Node(PN, ON, MS, current.next);
						current_pre.setNext(tmp);
						size++;
						t_Cover = 1;//there is cover of node happens;
						//current.setMessage(MS);
					} else {//>ON
						Node tmp = new Node(PN, ON, MS, current);
						if (current_pre != null) {
							current_pre.setNext(tmp);
						}
						size++;
					}
				} else {//current.getPN() > PN
					Node tmp = new Node(PN, ON, MS, current);
					if (current_pre != null) {
						current_pre.setNext(tmp);
					}
					size++;
				}
			}
			if(t_Cover == 1){
				size --;
			}
			
			//tmp1++;
		}
	}
	
	/**
	 * Removes the first input.
	 * @param PN message number.
	 * @param ON packet number.
	 * @param MS message.
	 */
	public boolean removeFirst(){
		if(isEmpty()) return false;
		Node tmp = head;
		head = head.getNext();
		size--;
		return true;
	}	
}