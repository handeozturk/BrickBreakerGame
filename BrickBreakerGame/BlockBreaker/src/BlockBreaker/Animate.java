package BlockBreaker;;

public class Animate implements Runnable {
	GamePanel gp;
		Animate(GamePanel g){
			gp = g;
		}
		
		public void run(){
			while(true){
				gp.update();
				try{
					Thread.sleep(10);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		
	
}
