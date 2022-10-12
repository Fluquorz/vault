import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.*;
import org.json.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FinalMoney {
	
	private Euro finalEuro;
	private Dolar finalDolar;
	private AltinGr finalGramAltin;
	private AltinCeyrek finalCeyrekAltin;
	private AltinYarım finalYarimAltin;
	private AltinTam finalTamAltin;
	private AltinAta finalAtaAltin;
	
	private float Euro;
	private float Eurotl;
	private float Dolar;
	private float Dolartl;
	private float graltin;
	private int graltinadet;
	private float caltin;
	private int caltinadet;
	private float yaltin;
	private int yaltinadet;
	private float taltin;
	private int taltinadet;
	private float aaltin;
	private int aaltinadet;
	private float toplamPara;
	private Kur kur;
	
	
	public boolean jsoncreated = false;
	
	
	public FinalMoney(Euro finalEuro, Dolar finalDolar, AltinGr finalGramAltin, AltinCeyrek finalCeyrekAltin,
			AltinYarım finalYarimAltin, AltinTam finalTamAltin, AltinAta finalAtaAltin) {
		this.finalEuro = finalEuro;
		this.finalDolar = finalDolar;
		this.finalGramAltin = finalGramAltin;
		this.finalCeyrekAltin = finalCeyrekAltin;
		this.finalYarimAltin = finalYarimAltin;
		this.finalTamAltin = finalTamAltin;
		this.finalAtaAltin = finalAtaAltin;
		
		
	}
	
	

	
	public void updateJSON() throws IOException, ParseException
	{
		kur = new Kur();
		kur.scrapeALTIN();
		kur.scrapeEURODOLAR();

        JSONObject jsonObj = new JSONObject();	
        JSONParser parser=new JSONParser();
      
        try 
        {      	
            String obj = parser.parse(new FileReader("C:\\Users\\Ahmet Emin Kahraman\\eclipse-workspace\\Vault\\vault.json")).toString(); //converting Object to String
            jsonObj = new JSONObject(obj); // org.json.JSONObject constructor accepts String as an argument
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
			
		
        Euro = jsonObj.getFloat("Euro") + finalEuro.getEuroValue();
		jsonObj.put("Euro", Euro);
		
		
		 Eurotl = (jsonObj.getFloat("Euro")*kur.getEuro());
		jsonObj.put("Euro-TL", Eurotl);
		
		
		 Dolar = jsonObj.getFloat("Dolar") + finalDolar.getDolarValue();
		//System.out.println(jsonObj.getFloat("Dolar"));		
		jsonObj.put("Dolar", Dolar);
		//System.out.println("getdolar:"+getDolar());
		
		
		 Dolartl = (jsonObj.getFloat("Dolar")*kur.getDolar());
		jsonObj.put("Dolar-TL", Dolartl);
		
		//System.out.println("dolartl:"+Dolartl);
		//System.out.println(jsonObj.getFloat("Dolar-TL"));
		//System.out.println(kur.getDolar());
		//System.out.println(jsonObj.getFloat("Dolar")*kur.getDolar());
				
		graltinadet = jsonObj.getInt("Gram Altin Adet") + finalGramAltin.getAltinGrAdet();
		jsonObj.put("Gram Altin Adet", graltinadet);
			
		 graltin = (jsonObj.getInt("Gram Altin Adet")*kur.getGramAltin());
		jsonObj.put("Gram Altin", graltin);
		
		
		caltinadet = jsonObj.getInt("Ceyrek Altin Adet") + finalCeyrekAltin.getAltinCeyrekAdet();
		jsonObj.put("Ceyrek Altin Adet", caltinadet);
		
		 caltin = (jsonObj.getInt("Ceyrek Altin Adet")*kur.getCeyrekAltin());
		jsonObj.put("Ceyrek Altin", caltin);

		
		yaltinadet = jsonObj.getInt("Yarim Altin Adet") + finalYarimAltin.getAltinCeyrekAdet();
		jsonObj.put("Yarim Altin Adet", yaltinadet);
		
		 yaltin =  (jsonObj.getInt("Yarim Altin Adet")*kur.getYarimAltin());
		jsonObj.put("Yarim Altin", yaltin);
		
		taltinadet = jsonObj.getInt("Tam Altin Adet") + finalTamAltin.getAltinTamAdet();
		jsonObj.put("Tam Altin Adet", taltinadet);
		
		
		 taltin =  (jsonObj.getInt("Tam Altin Adet")*kur.getTamAltin());
		jsonObj.put("Tam Altin", taltin);
		
		aaltinadet = jsonObj.getInt("Ata Altin Adet") + finalAtaAltin.getAltinAtaAdet();
		jsonObj.put("Ata Altin Adet", aaltinadet);
		
		
		 aaltin =  (jsonObj.getInt("Ata Altin Adet")*kur.getAtaAltin());
		jsonObj.put("Ata Altin", aaltin);
		

		 toplamPara =jsonObj.getFloat("Euro-TL") + jsonObj.getFloat("Dolar-TL") + jsonObj.getFloat("Gram Altin") + 
				 jsonObj.getFloat("Ceyrek Altin") + jsonObj.getFloat("Yarim Altin") + jsonObj.getFloat("Tam Altin") + 
				 jsonObj.getFloat("Ata Altin");
		jsonObj.put("Toplam Para", toplamPara);
		
		
		PrintWriter pw = new PrintWriter("C:\\Users\\Ahmet Emin Kahraman\\eclipse-workspace\\Vault\\vault.json");
        pw.write(jsonObj.toString());   
        pw.flush();
        pw.close();
		
		
	}
	
	public void updateExchangeInJson()
	{
		
	}
	
	
	
	
	
	
	public float getEuro() {
		return Euro;
	}




	public void setEuro(float euro) {
		Euro = euro;
	}




	public float getEurotl() {
		return Eurotl;
	}




	public void setEurotl(float eurotl) {
		Eurotl = eurotl;
	}




	public float getDolar() {
		return Dolar;
	}




	public void setDolar(float dolar) {
		Dolar = dolar;
	}




	public float getDolartl() {
		return Dolartl;
	}




	public void setDolartl(float dolartl) {
		Dolartl = dolartl;
	}




	public float getGraltin() {
		return graltin;
	}




	public void setGraltin(float graltin) {
		this.graltin = graltin;
	}




	public float getCaltin() {
		return caltin;
	}




	public void setCaltin(float caltin) {
		this.caltin = caltin;
	}




	public float getYaltin() {
		return yaltin;
	}




	public void setYaltin(float yaltin) {
		this.yaltin = yaltin;
	}




	public float getTaltin() {
		return taltin;
	}




	public void setTaltin(float taltin) {
		this.taltin = taltin;
	}




	public float getAaltin() {
		return aaltin;
	}




	public void setAaltin(float aaltin) {
		this.aaltin = aaltin;
	}




	public float getToplamPara() {
		return toplamPara;
	}




	public void setToplamPara(float toplamPara) {
		this.toplamPara = toplamPara;
	}



	public int getGraltinadet() {
		return graltinadet;
	}




	public void setGraltinadet(int graltinadet) {
		this.graltinadet = graltinadet;
	}




	public int getCaltinadet() {
		return caltinadet;
	}




	public void setCaltinadet(int caltinadet) {
		this.caltinadet = caltinadet;
	}




	public int getYaltinadet() {
		return yaltinadet;
	}




	public void setYaltinadet(int yaltinadet) {
		this.yaltinadet = yaltinadet;
	}




	public int getTaltinadet() {
		return taltinadet;
	}




	public void setTaltinadet(int taltinadet) {
		this.taltinadet = taltinadet;
	}




	public int getAaltinadet() {
		return aaltinadet;
	}




	public void setAaltinadet(int aaltinadet) {
		this.aaltinadet = aaltinadet;
	}

	

}
