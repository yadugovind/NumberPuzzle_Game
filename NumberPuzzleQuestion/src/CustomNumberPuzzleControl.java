import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here	
		int buttonClickedId=-1;
		for(int i=0;i<=15;++i){
			if(buttons[i]==buttonClicked)
				buttonClickedId=i;
				}
		System.out.println(buttonClickedId);		
		if(Math.abs(buttonClickedId-emptyCellId)==1||emptyCellId+4==buttonClickedId||emptyCellId-4==buttonClickedId){
			swapButton(buttons[emptyCellId],buttonClicked);
			emptyCellId=buttonClickedId;
		}	
		
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		//Your logic here
		

		int c=-1;
		int check;
		
		while(c<14){
			check=0;
			int a = getRandomNumber();
			if(a%16==0)
				continue;

			a = a % 16;
			
			for(int i=0;i<=c;++i){
				if(arr[i]==a)
				{check=1;break;}
			}
			if(check!=1)
				{arr[c+1]=a;c++;}
		}
		
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int[] buttonId=getIntegerArrayOfButtonIds(buttons);
		for(int i=0;i<15;++i){
			if(buttonId[i]!=i+1)
				winner=false;
		}

		return winner;
	}
}