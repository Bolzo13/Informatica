public class Passeggero extends Thread{
	private int stopNumber;
	private int destination;
	private String name;
	private Bus bus;
	public Passeggero(String name,int stopNumber, int destination){
		this.stopNumber = stopNumber;
		this.name = name;
		this.destination = destination;
	}
	public void setBus(Bus bus){
		this.bus = bus;
	}
	@Override
	public void run(){
		while(true) {
			try {
				sleep(100000000);
			} catch (InterruptedException e) {
				System.out.println("[" + getName() + "]Provo a salire");
				if(bus.sale(this)) System.out.println("[" + getName() + "]Sono salito");
				else System.out.println("[" + getName() + "]NON sono salito");
				break;
			}
		}
		while(true) {
			try {
				sleep(100000000);
			} catch (InterruptedException e) {
				if(bus.getStop() == destination){
					System.out.println("[" + getName() + "]Scendo");
					bus.scende(this);
					break;
				}
			}
		}
	}
	public boolean deveScendere(int stop){
		return stop == destination;
	}
}
