package com.hybridframework.vtiger.pom;

class Alpha {
		int a = 1;
	}
	
	 class Beta extends Alpha {
		int a = 2;
		
	}
	
	public class Practice extends Beta {
		int a = 3;
		
//		public static void main(String[]args) {
//			
//			Alpha alpha = new Practice();
//			Beta beta = new Practice();
////			Practice practice = new Practice();
//			
//			System.out.println(alpha.a+" "+beta.a);
//			
//		}
		
		@SuppressWarnings("finally")
		public static int test() {
			try {
				
				return 0;
				
			}
			catch(Exception e) {
				return 1;
				
			}
			finally {
				return 2;
			}
			
		}
		
		public static void main(String[]args) {
			int i = test();
			System.out.println(i);
		}
		
		
	}


