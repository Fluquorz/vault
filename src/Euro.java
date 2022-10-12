
public class Euro {
	private String name;
	private float EuroValue;
	private Kur kur;
	
	
	
	public Euro(float EuroValue) {
		this.EuroValue = EuroValue;			
		
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getEuroValue() {
		return EuroValue;
	}
	public void setEuroValue(float euroValue) {
		EuroValue = euroValue;
	}
	public Kur getKur() {
		return kur;
	}
	public void setKur(Kur kur) {
		this.kur = kur;
	}

	
	
	
}
