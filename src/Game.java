import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;


public class Game extends KeyAdapter implements ActionListener{
	
	 
	 //private Grids grids;
	 private GamePanel gamePanel;
	
 	 
 	public Game(){
 		
	 	super();
	 	System.out.println("dsgggggggggggggggggggggggggggg");
		initGame();	
		this.gamePanel=new GamePanel();
		gamePanel.addKeyListener(this);
		gamePanel.resetButton.addActionListener(this);
	} 

	public  void  keyPressed(KeyEvent e) {
		 System.out.println("dsgggggggggggggggggggggggggggg");
		switch(e.getKeyCode()){
 		case KeyEvent.VK_UP:
			new Thread(
	 			new Runnable(){
	 				public void run(){
	 					for(int i=0;i<4;i++){
	 						try{
								Thread.sleep(50);
	 						}
	 						catch(Exception ex){}
	 						gamePanel.grids.moveUp();
							gamePanel.redisply();
						}
	 					if(!gamePanel.grids.isGameOver()){
	 						gamePanel.grids.createOneNum();
	 						gamePanel.redisply();
	 					}else gamePanel=null;
					}
				}).start();
		
			break;
			
		case KeyEvent.VK_DOWN:
			new Thread(
					new Runnable(){
						public void run(){
							for(int i=0;i<4;i++){
								try{
									Thread.sleep(50);
								}
								catch(Exception ex){}
								gamePanel.grids.moveDown();
								gamePanel.redisply();
							}
							if(!gamePanel.grids.isGameOver()){
								gamePanel.grids.createOneNum();
								gamePanel.redisply();
							}else gamePanel=null;
						}
					}).start();
		
			break;
		case KeyEvent.VK_LEFT:
			new Thread(
					new Runnable(){
						public void run(){
							for(int i=0;i<4;i++){
								try{
									Thread.sleep(50);
								}
								catch(Exception ex){}
								gamePanel.grids.moveLeft();
								gamePanel.redisply();
							}
							if(!gamePanel.grids.isGameOver()){
								gamePanel.grids.createOneNum();
								gamePanel.redisply();
							}else gamePanel=null;
						}
					}).start();
		
			break;
			
		case KeyEvent.VK_RIGHT:
			new Thread(
					new Runnable(){
						public void run(){
							for(int i=0;i<4;i++){
								try{
									Thread.sleep(50);
								}
								catch(Exception ex){}
								gamePanel.grids.moveRight();
								gamePanel.redisply();
							}
							if(!gamePanel.grids.isGameOver()){
								gamePanel.grids.createOneNum();
								gamePanel.redisply();
							}else gamePanel=null;
						}
					}).start();
			
			break;
		}
	}
	public void initGame(){
		
//		gamePanel.setFocusable(true);
	}
	public void actionPerformed(ActionEvent e){
		newGame();
	}
	public void newGame(){
		gamePanel.grids.initMap();
		gamePanel.redisply();
		
	}
	
	public static void main(String args []){
		Game game=new Game();
	}
}
