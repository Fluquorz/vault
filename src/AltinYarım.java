
public class AltinYarım {
	
	private String name;
	private int AltinYarimAdet;
	private Kur kur;
	
	public AltinYarım(int AltinAdet)
	{
		this.AltinYarimAdet = AltinAdet;
		
	}
	
	
	public int getAltinCeyrekAdet() {
		return AltinYarimAdet;
	}
	public void setAltinCeyrekAdet(int altinYarimAdet) {
		AltinYarimAdet = altinYarimAdet;
	}
	public Kur getKur() {
		return kur;
	}
	public void setKur(Kur kur) {
		this.kur = kur;
	}
	

}
