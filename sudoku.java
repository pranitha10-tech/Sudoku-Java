public class Main
{ 
	public static void main(String[] args) {
	    int a[][]={{3, 0, 6, 5, 0, 8, 4, 0, 0},
{5, 2, 0, 0, 0, 0, 0, 0, 0},
{0, 8, 7, 0, 0, 0, 0, 3, 1},
{0, 0, 3, 0, 1, 0, 0, 8, 0},
{9, 0, 0, 8, 6, 3, 0, 0, 5},
{0, 5, 0, 0 ,9, 0, 6, 0 ,0},
{1, 3, 0, 0, 0, 0, 2, 5, 0},
{0, 0, 0, 0, 0, 0, 0, 7, 4},
{0, 0, 5, 2, 0, 6, 3, 0, 0}}; 
/*
Scanner sc=new Scanner(System.in);
for(int i=0;i<9;i++){
    for(int j=0;j<9;j++){
        a[i][j]=sc.nextInt();
    }
}
*/
	    int k,l=1; 
	    sudoku(a,0,0); 
	}
	static void display(int a[][]){
	    for(int i=0;i<9;i++){
	        for(int j=0;j<9;j++){
	            System.out.print(a[i][j]+" ");
	        }
	        System.out.println();
	    }
	}
	static void sudoku(int a[][],int i,int j){  
	    if(i>=8 && j>=9){
	        display(a);
	        return;
	    }
	    if(j==9){
	        i=i+1;
	        j=0;
	    }  
	    if(a[i][j]==0){
	        for(int k=1;k<=9;k++){
	            if(isSafe(a,i,j,k)){
	                a[i][j]=k;
	                sudoku(a,i,j+1);
	                a[i][j]=0;
	            }
	        }
	    }
	    else{
	        sudoku(a,i,j+1);
	    }
	} 
	static boolean isSafe(int a[][],int i,int j,int l){
	 
	    for(int k=0;k<9;k++){ 
	        if(a[i][k]==l){
	            return false;
	        }
	    }
	    for(int k=0;k<9;k++){
	        if(a[k][j]==l){
	            return false;
	        }
	    }
	    int x=(i/3)*3;
	    int y=(j/3)*3;
	    for(int k=x;k<(x+3);k++){
	        for(int m=y;m<(y+3);m++){
	            if(a[k][m]==l){
	                return false;
	            }
	        }
	    }
	    return true;
	}
}
