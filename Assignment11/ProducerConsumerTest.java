package ProducerConsumer;
public class ProducerConsumerTest {

	public static void main(String[] args) throws InterruptedException{
		
		ProducerConsumer pc = new ProducerConsumer();
		
		//declaring producer thread and the anonymous class declaring the anonymous class 
		Thread producer = new Thread(new Runnable() {
			public void run(){
				try{
					pc.produce();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		//declaring consumer thread and the anonymous class declaring the anonymous class 
		Thread consumer = new Thread(new Runnable() {
			public void run(){
				try{
					pc.consume();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		//start producer and consumer thread
		producer.start();
		consumer.start();
		
		//producer must stop before consumer
		producer.join();
		consumer.join();
		
	}
}
