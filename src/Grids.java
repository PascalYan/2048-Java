import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class Grids {
	
	private int[][] map=new int[4][4];
	private Font font=new Font("Arial",Font.BOLD,30);
	private int fontX;
	private int moveTime=0;
	
	public static final int NONUM=0;
	public static final int GRIDWIDTH=110,GRIDHEIGHT=110;
	
	
	
	public Grids(){
		initMap();
	}
	
	public void initMap(){
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				map[i][j]=NONUM;
		createOneNum();
		createOneNum();
	}
	public void createOneNum(){
		int num=(Math.random()<0.5)?4:2;
		int randomI, randomJ;
		do{
			randomI=(int)(Math.random()*4);
			randomJ=(int)(Math.random()*4);
		}while(map[randomI][randomJ]!=NONUM);
		map[randomI][randomJ]=num;	
	}
	
	
	public void drawGrids(Graphics g){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if(map[i][j]==NONUM){
					g.setColor(new ColorOfGrid(0).getColor());
					g.fillRect(20+130*j, 20+130*i, GRIDWIDTH, GRIDHEIGHT);
				}
				else{
					g.setColor(new ColorOfGrid(map[i][j]).getColor());
					g.fillRect(20+130*j, 20+130*i, GRIDWIDTH, GRIDHEIGHT);
					/*
					 * 画完矩形，在上面显示数字
					 */
					g.setColor(Color.black);
					g.setFont(font);
					if(String.valueOf(map[i][j]).length()==1){
						fontX=70;
					}
					else if(String.valueOf(map[i][j]).length()==2) {
						fontX=60;
					}
					else if(String.valueOf(map[i][j]).length()==3) {
						fontX=50;
					}
					else fontX=40;
					g.drawString(String.valueOf(map[i][j]),fontX+130*j, 80+130*i);
				}
			}
		}
		
	}
	
	public void moveUp(){
		System.out.println("moveUp");
		
					for(int j=0;j<4;j++){
						for(int i=1;i<4;i++){
							if(map[i][j]!=0){
								if(map[i-1][j]==0){
									map[i-1][j]=map[i][j];
									map[i][j]=0;
									
								}
								else if(map[i-1][j]==map[i][j])
								{
									map[i-1][j]=map[i-1][j]+map[i][j];
									map[i][j]=0;
								}
								
							}
						}
						
					}
	}
	public void moveRight(){
		System.out.println("moveRight");
		
		for(int i=0;i<4;i++){
			for(int j=2;j>=0;j--){
				if(map[i][j]!=0){
					if(map[i][j+1]==0){
						map[i][j+1]=map[i][j];
						map[i][j]=NONUM;
					}
					else if(map[i][j+1]==map[i][j])
							{
								map[i][j+1]=map[i][j]+map[i][j+1];
								map[i][j]=NONUM;
							}
					
				}
			}
			
		}
	}
	public void moveLeft(){
		moveTime++;
		System.out.println("moveLeft"+moveTime);
		for(int i=0;i<4;i++){
			for(int j=1;j<4;j++){
				if(map[i][j]!=0){
					if(map[i][j-1]==NONUM){
						map[i][j-1]=map[i][j];
						map[i][j]=NONUM;
					}else if(map[i][j-1]==map[i][j])
					{
						map[i][j-1]=map[i][j-1]+map[i][j];
						map[i][j]=0;
					}
				}
			}	
		}
		
		
	}
	public void moveDown(){
		System.out.println("moveDown");
		for(int j=0;j<4;j++){
			for(int i=2;i>=0;i--){
				if(map[i][j]!=0){
					if(map[i+1][j]==0){
						map[i+1][j]=map[i][j];
						map[i][j]=NONUM;
					}
					else if(map[i+1][j]==map[i][j])
					{
						map[i+1][j]=map[i+1][j]+map[i][j];
						map[i][j]=0;
					}
					
				}
			}
			
		}
	}
	public boolean  isGameOver(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
			{
				if(map[i][j]==0){
					System.out.println("!GameOver");
					return false;
				}
			}
		}
		System.out.println("GameOver!!!!!!!");
		return true;
	}
	public Font getFont() {
		return font;
	}
	public void setFont(Font font) {
		this.font = font;
	}
}
