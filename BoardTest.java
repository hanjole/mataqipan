package com.han.kkkyx;

public class BoardTest {
	final static int N = 8;
	static int[][] board = new int[N][N];;
	int count = 0;
	int countAll = 0;
	 //���·��
	static int[] dx ={ -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy ={ 2, 1, -1, -2, -2, -1, 1, 2 };
    public static void main(String[] args) {
    	BoardTest t = new BoardTest();
    	   int i, j;
           //��ʼ������
           for(i=0; i<8; i++){
               for(j=0; j<8; j++){
            	   board[i][j] = 0;
               }
           }
           //��һ�����ñȽϣ���ֵ��һ��
           //x,y  0-7
           int x = 6;
           int y = 0;
           board[x][y] = 1;
           t. move(x, y, 2);      

	}  

     void move(int x ,int y ,int count){
    	 int mx ,my;
    	 HorseNode[]  h = new HorseNode[N];
    	 	
    	 if(count >N*N){
    		 //������ӡ���
    		  for(int i=0; i<N; i++){
                  for(int j=0; j<N; j++){
                      System.out.printf("%3d", board[i][j]);
                  }
                  System.out.println();
              }
    			 System.out.println(countAll);
    		 //����
    		  System.exit(0);
    	 }
    	 
    	 for(int i = 0; i<N;i++){
    		//ѭ����Χ��������λ�õ���Ϣ��������
			mx = x + dx[i];
    		my = y + dy[i];
//    		if(mx<0||my<0||mx>=N||my>=N){
//    			System.out.println("����"+mx+","+my);
//        		continue;
//        	}
    		
    		HorseNode hor = new HorseNode();
    		h[i] = hor;
    		h[i].x = mx;
    		h[i].y = my;
    		h[i].waysOutNum = getWays(mx,my);
    		
    	 }
    	 //����
    	 sort(h);

//		��ʽһ 	 
//    	 int a;
//    	 for(a=0;h[a].waysOutNum<0;++a);
//    	  	for(;a<N;++a){
//		        mx=h[a].x;
//		        my=h[a].y;
//		        board[mx][my]=count;
//		        move(mx,my,count+1);
//		        board[mx][my]=0;
//		 }
    	  //��ʽ��	
	  	for(int i = 0; i<h.length;i++){
	  		//ע�Ͳ����Ƿ�ʽһ����д��,��������������
//	  		if(h[i].waysOutNum<0){
//	  		    continue;
//	  		}
//  			 mx=h[i].x;
//   		     my=h[i].y;
//   		     board[mx][my]=count;
//	         move(mx,my,count+1);
//	         board[mx][my]=0;
	  		if(h[i].waysOutNum>=0){
	  			 mx=h[i].x;
	   		     my=h[i].y;
	   		     board[mx][my]=count;
		         move(mx,my,count+1);
		         //����ʱ��ǰ����״̬,��һ���Ѿ�û�ط�����,������ͼ
//		         for(int n=0; n<N; n++){
//	                  for(int m=0; m<N; m++){
//	                      System.out.printf("%3d", board[n][m]);
//	                  }
//	                  System.out.println();
//	              }
//		         System.exit(0);
		         
		         /*
		                                ����Ҫ
		          	board[mx][my]=0; 
		          	�����÷�
		        	���move(mx,my,count+1);������֮�����û��λ�ÿ���.
		        	���ε�forѭ��������ѭ��,
		        	���ǰ����Ƕ���ԭ
		          */
		         //����
		         board[mx][my]=0;
		         //��¼��ִ�д���
		         countAll++;
	  		}
	  	}
    	 
     }
     
     
     
     

     
     
     

     //���ݶ��ο���λ�ô�����������
     void sort(HorseNode[] arr ){
    	//for(int b = 0;b<arr.length;b++){
    	//	System.out.print(arr[b].x+","+arr[b].y+"--/"+arr[b].waysOutNum+"   ");
    	//}
    	int i;
    	HorseNode h; 
    	for(int s = 0;s<arr.length;s++){
        	for(i = 0;i<s;i++){
        		if(arr[i].waysOutNum>arr[i+1].waysOutNum){
        			h = arr[i];
        			arr[i]=arr[i+1];
        			arr[i+1] = h;
        		}
        	}
    	}

    	
    }
    
    
    
    
    
    

	int getWays(int x, int y){
    	
    	int mx ,my,c =0;
//    	System.out.println(x+","+y);
    	//�����߽�,������ռ��      x y   0-7
    	if(x<0||y<0||x>=N||y>=N||board[x][y]>0){
    		return -1;
    	}
    	
    	for(int i = 0;i<N;i++){
    		mx = x + dx[i];
    		my = y + dy[i];
    		if(mx<0||my<0||mx>=N||my>=N){
//    			System.out.println("����"+mx+","+my);
        		continue;
        	}
    		if(board[mx][my]==0){
    			//board[mx][my]==0  ����û����
    			c++;
    		}
    	}
//    	System.out.println(x+","+y+"---"+c);
		return c;
    }
	class HorseNode {  
	    int x;  
	    int y;  
	    int waysOutNum;  
	}  
}
