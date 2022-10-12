
public class Dolar {
	private String name;
	private float DolarValue;
	private Kur kur;
	
	public Dolar(float dolarValue) {

		DolarValue = dolarValue;
		
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getDolarValue() {
		return DolarValue;
	}

	public void setDolarValue(float dolarValue) {
		DolarValue = dolarValue;
	}

	public Kur getKur() {
		return kur;
	}

	public void setKur(Kur kur) {
		this.kur = kur;
	}

	
	

}
