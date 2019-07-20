public class TestSingle{
	public static void main(String[] args){
		Single single = null;
		single = Single.getSingle();
		//single.print();
	}
}

class Single{
	//恶汉式
	private static Single single;
	private Single(){
		
	}
	public static Single getSingle(){
		if(single == null){
		  single =  new Single();
		}
		return single;
	}
	public void print(){
		System.out.println("完美世界");
	}
}