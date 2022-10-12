import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Kur {
	private float euro;
	private float dolar;
	private float ataAltin;
	private float tamAltin;
	private float yarimAltin;
	private float ceyrekAltin;
	private float gramAltin;
	
	public Kur()
	{
		
	}
	public void scrapeALTIN()
	{
		final String URL_CEYREK = "https://altin.in/fiyat/ceyrek-altin";
		final String URL_GRAM = "https://altin.in/fiyat/gram-altin";
		final String URL_ATA = "https://altin.in/fiyat/cumhuriyet-altini";
		
		try {
			final Document doc_ceyrek = Jsoup.connect(URL_CEYREK).get();
			final Document doc_gram = Jsoup.connect(URL_GRAM).get();
			final Document doc_ata = Jsoup.connect(URL_ATA).get();
			
			//System.out.println(doc.outerHtml());
			
		//System.out.println(doc.select("Currency"));
			
			//System.out.println(doc_gram.select("li.midrow.satis").first().text());
			String ceyrekAltin = doc_ceyrek.select("li.midrow.satis").first().text();
			String gramAltin = doc_gram.select("li.midrow.satis").first().text();
			String ataAltin = doc_ata.select("li.midrow.satis").first().text();
			
			float GRAM_ALTIN = Float.parseFloat(gramAltin);
			float CEYREK_ALTIN = Float.parseFloat(ceyrekAltin);
			float ATA_ALTIN = Float.parseFloat(ataAltin);
			float YARIM_ALTIN = CEYREK_ALTIN*2;
			float TAM_ALTIN = YARIM_ALTIN*2;
			
			
			//System.out.println("gram: "+GRAM_ALTIN+"\nceyrek: "+CEYREK_ALTIN+"\nYarım: "+YARIM_ALTIN+"\ntam: "+TAM_ALTIN+"\nata: "+ATA_ALTIN);
			
			setGramAltin(GRAM_ALTIN);
			setCeyrekAltin(CEYREK_ALTIN);
			setYarimAltin(YARIM_ALTIN);
			setTamAltin(TAM_ALTIN);
			setAtaAltin(ATA_ALTIN);
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void scrapeEURODOLAR()
	{
		final String URL = "https://www.tcmb.gov.tr/kurlar/today.xml";
		
		try {
			final Document doc = Jsoup.connect(URL).get();
			/*System.out.println(doc.outerHtml());*/
			
		//System.out.println(doc.select("Currency"));
			
			
			for(Element rows : doc.select("Currency"))
			{
				if(rows.select("Isim").text().equals("ABD DOLARI"))
				{
					String deger =rows.select("ForexBuying").text();
					//System.out.println(rows.select("Isim").text()+" :"+deger );
					float ABD_DOLAR_KURU = Float.parseFloat(deger);
					setDolar(ABD_DOLAR_KURU);
				}
				if(rows.select("Isim").text().equals("EURO"))
				{
					String deger =rows.select("ForexBuying").text();
					//System.out.println(rows.select("Isim").text()+" :"+deger );
					float EURO_DOLAR_KURU = Float.parseFloat(deger);
					setEuro(EURO_DOLAR_KURU);
					
				}
				/*String ulkeIsmi = rows.select("Isim").text();
				String forexBuying = rows.select("ForexBuying").text();
				System.out.println(ulkeIsmi+": "+forexBuying);*/
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public float getEuro() {
		return euro;
	}

	public void setEuro(float euro) {
		this.euro = euro;
	}

	public float getDolar() {
		return dolar;
	}

	public void setDolar(float dolar) {
		this.dolar = dolar;
	}

	public float getAtaAltin() {
		return ataAltin;
	}

	public void setAtaAltin(float ataAltin) {
		this.ataAltin = ataAltin;
	}

	public float getTamAltin() {
		return tamAltin;
	}

	public void setTamAltin(float tamAltin) {
		this.tamAltin = tamAltin;
	}

	public float getYarimAltin() {
		return yarimAltin;
	}

	public void setYarimAltin(float yarimAltin) {
		this.yarimAltin = yarimAltin;
	}

	public float getCeyrekAltin() {
		return ceyrekAltin;
	}

	public void setCeyrekAltin(float ceyrekAltin) {
		this.ceyrekAltin = ceyrekAltin;
	}

	public float getGramAltin() {
		return gramAltin;
	}

	public void setGramAltin(float gramAltin) {
		this.gramAltin = gramAltin;
	}
	
	@Override
	public String toString() {
		return "Kur [euro=" + euro + ", dolar=" + dolar + ", ataAltin=" + ataAltin + ", tamAltin=" + tamAltin
				+ ", yarimAltin=" + yarimAltin + ", ceyrekAltin=" + ceyrekAltin + ", gramAltin=" + gramAltin + "]";
	}
	 public static void main(String[] args) {
		Kur kur = new Kur();
		kur.scrapeALTIN();
	}
	
	 

}
