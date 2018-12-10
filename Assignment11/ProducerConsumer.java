package ProducerConsumer;

import java.util.LinkedList;

public class ProducerConsumer {
	
	private LinkedList<Integer> buffer = new LinkedList<Integer>();
	private int capacity = 10;
	
	//producer function which produces item
	public void produce() throws InterruptedException{
		
		int itemInBuffer = 0;
		
		//run forever
		while(true){
			
			//synchronize the thread to avoid race condition
			synchronized(this)
			{
				//wait for the buffer to empty 
				while(buffer.size()==capacity)
					wait();
				
				//print the item produced by producer
				System.out.println("Producer produced the item: "+ itemInBuffer % capacity);
				
				//add produced item to buffer
				buffer.add(itemInBuffer++);
				
				//notify the consumer that item is present in buffer
				notify();
				
				//sleep the producer for 1 sec for better visualization
				Thread.sleep(1000);
			}
		}
	}
	
	//consumer function which consume item from buffer
	public void consume() throws InterruptedException{
		
		int itemInBuffer;
		
		//run forever
		while(true){
			
			//synchronize the thread to avoid race condition
			synchronized(this)
			{
				//wait for the producer to produce  
				while(buffer.size()==0)
					wait();
				
				//remove the item from buffer
				itemInBuffer = buffer.removeFirst();
				
				//print the item consumed by consumer
				System.out.println("Consumer consumed the item: "+ itemInBuffer % capacity);
				
				//notify the producer that item is consumed from buffer
				notify();
				
				//sleep the consumer thread for 1 sec for better visualization
				Thread.sleep(1000);
			}
		}
	}
}
