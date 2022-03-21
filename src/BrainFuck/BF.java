package BrainFuck;

import java.util.*;
public class BF {
	Scanner in=new Scanner(System.in);
//length of working array
	static int lgth=257;
///i chose 2^8 here

///array of "memory" cells for operations
	static int memory[]=new int[lgth];
	
/// array of chars to "keep" the input code
	char code[]=new char[10000];
	
	public BF() {
		System.out.print("Input the code: ");
		this.code=in.next().toCharArray();
	}
	
	static public void BFA(char code[]) {
		Scanner in=new Scanner(System.in);
		int number=code.length;
		int i=0;
		int position=0;
		while(i<number) {
			switch(code[i]) {
			case ',': 
				System.out.print("Input: ");
				memory[position]=(int)in.next().charAt(0);
				break;
				
			case '.':
				System.out.print((char)memory[position]);
				break;
			case '+':
				if(memory[position]+1>255)
					memory[position]=0;
				else
					memory[position]++;
				break;
			case '-':
				if(memory[position]-1<0)
					memory[position]=255;
				else
					memory[position]--;
				break;
			case '>':
				if(position+1>lgth)
					position=0;
				else
					position++;
				break;
			case '<':
				if(position-1<0)
					position=lgth;
				else
					position--;
				break;
			case '[':
				if(memory[position]==0)
					while(code[i]!=']')
						i++;
				break;
			case ']':
				if(memory[position]!=0)
					while(code[i]!='[')
						i--;
				break;
			}
			i++;
		}
		in.close();
	}
	
	static public void BFN(char code[]) {
		Scanner in=new Scanner(System.in);
		int number=code.length;
		int i=0;
		int position=0;
		while(i<number) {
			switch(code[i]) {
			case ',': 
				System.out.print("Input: ");
				memory[position]=in.nextByte();
				break;
				
			case '.':
				System.out.print(memory[position]);
				break;
			case '+':
				if(memory[position]+1>255)
					memory[position]=0;
				else
					memory[position]++;
				break;
			case '-':
				if(memory[position]-1<0)
					memory[position]=255;
				else
					memory[position]--;
				break;
			case '>':
				if(position+1>lgth)
					position=0;
				else
					position++;
				break;
			case '<':
				if(position-1<0)
					position=lgth;
				else
					position--;
				break;
			case '[':
				if(memory[position]==0)
					while(code[i]!=']')
						i++;
				break;
			case ']':
				if(memory[position]!=0)
					while(code[i]!='[')
						i--;
				break;
			}
			i++;
		}
		in.close();
	}
	
	
	public static void main(String[] args) {
		BF input=new BF();
		Scanner in=new Scanner(System.in);
		System.out.println("Choose: 1.BFA \t 2.BFN");
		int choice=in.nextInt();
		switch(choice) {
		case 1:BFA(input.code);
			break;
		case 2:
			BFN(input.code);
			break;
		}
		in.close();
	}
}
