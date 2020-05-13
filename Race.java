class Bike
{
	void fin(){
		System.out.println("Bike");
	}
	class TVS extends Bike{
		void fin(){
			super.fun();
			System.out.println("TVS Apache");
		}
	}
	class Race{
		public static void main(String args[]){
			TVS t=new TVS();
			t.fun();
			t=new Bike();
			t.fun();
		}
	}
}