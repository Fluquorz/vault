import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

import org.json.simple.*;
import org.json.simple.parser.ParseException;

public class VaultGUIInterface {
		
	private JFrame frame;
	private JTextField textField_Euro;
	private JTextField textField_Dolar;
	private JTextField textField_AltınGram;
	private JTextField textField_AltınCeyrek;
	private JTextField textField_AltınYarım;
	private JTextField textField_AltınTam;
	private JTextField textField_AltınAta;
	private JLabel MevcutDolar;
	private JLabel MevcutCeyrek;
	private JLabel MevcutYarim;
	private JLabel MevcutTam;
	private JLabel MevcutAta;
	private JLabel ToplamPara;
	private JLabel ToplamParalbl;
	private JLabel MevcutEuro_tl;
	private JLabel MevcutDolar_tl;
	private JLabel MevcutGram;
	private JLabel lblNewLabel;
	private JButton UpdateJson;
	private JLabel MevcutEuro;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel MevcutGram_adet;
	private JLabel MevcutCeyrek_adet;
	private JLabel MevcutYarim_adet;
	private JLabel MevcutTam_adet;
	private JLabel MevcutAta_adet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VaultGUIInterface window = new VaultGUIInterface();
					window.frame.setVisible(true);
								
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	
	public VaultGUIInterface() {
		initialize();
		getStoredValue();
		
		
	}
	
	public void getStoredValue()
	{
		Euro euro = new Euro(0);
		Dolar dolar = new Dolar(0);
		AltinGr agram = new AltinGr(0);
		AltinCeyrek aceyrek = new AltinCeyrek(0);
		AltinYarım ayarim = new AltinYarım(0);
		AltinTam atam = new AltinTam(0);
		AltinAta ata = new AltinAta(0);
		FinalMoney fm = new FinalMoney(euro,dolar,agram,aceyrek,ayarim,atam,ata);
		
		try {
			fm.updateJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MevcutEuro_tl.setText(String.valueOf(fm.getEurotl()));
		MevcutDolar_tl.setText(String.valueOf(fm.getDolartl()));
		MevcutGram.setText(String.valueOf(fm.getGraltin()));
		MevcutCeyrek.setText(String.valueOf(fm.getCaltin()));
		MevcutYarim.setText(String.valueOf(fm.getYaltin()));
		MevcutTam.setText(String.valueOf(fm.getTaltin()));
		MevcutAta.setText(String.valueOf(fm.getAaltin()));
		ToplamParalbl.setText(String.valueOf(fm.getToplamPara()));
		
		//get stored value
		MevcutEuro.setText(String.valueOf(fm.getEuro()));
		MevcutDolar.setText(String.valueOf(fm.getDolar()));
		MevcutGram_adet.setText(String.valueOf(fm.getGraltinadet()));
		MevcutCeyrek_adet.setText(String.valueOf(fm.getCaltinadet()));
		MevcutYarim_adet.setText(String.valueOf(fm.getYaltinadet()));
		MevcutTam_adet.setText(String.valueOf(fm.getTaltinadet()));
		MevcutAta_adet.setText(String.valueOf(fm.getAaltinadet()));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 896, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton SaveButton = new JButton("Kaydet");		
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				Euro euro = new Euro(Float.parseFloat(textField_Euro.getText()));
				Dolar dolar = new Dolar(Float.parseFloat(textField_Dolar.getText()));
				AltinGr agram = new AltinGr(Integer.parseInt(textField_AltınGram.getText()));
				AltinCeyrek aceyrek = new AltinCeyrek(Integer.parseInt(textField_AltınCeyrek.getText()));
				AltinYarım ayarim = new AltinYarım(Integer.parseInt(textField_AltınYarım.getText()));
				AltinTam atam = new AltinTam(Integer.parseInt(textField_AltınTam.getText()));
				AltinAta ata = new AltinAta(Integer.parseInt(textField_AltınAta.getText()));
				FinalMoney fm = new FinalMoney(euro,dolar,agram,aceyrek,ayarim,atam,ata);			
				try {
					fm.updateJSON();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//get stored value			
				MevcutEuro_tl.setText(String.valueOf(fm.getEurotl()));
				MevcutDolar_tl.setText(String.valueOf(fm.getDolartl()));
				MevcutGram.setText(String.valueOf(fm.getGraltin()));
				MevcutCeyrek.setText(String.valueOf(fm.getCaltin()));
				MevcutYarim.setText(String.valueOf(fm.getYaltin()));
				MevcutTam.setText(String.valueOf(fm.getTaltin()));
				MevcutAta.setText(String.valueOf(fm.getAaltin()));
				ToplamParalbl.setText(String.valueOf(fm.getToplamPara()));
				
				//get stored value
				MevcutEuro.setText(String.valueOf(fm.getEuro()));
				MevcutDolar.setText(String.valueOf(fm.getDolar()));
				MevcutGram_adet.setText(String.valueOf(fm.getGraltinadet()));
				MevcutCeyrek_adet.setText(String.valueOf(fm.getCaltinadet()));
				MevcutYarim_adet.setText(String.valueOf(fm.getYaltinadet()));
				MevcutTam_adet.setText(String.valueOf(fm.getTaltinadet()));
				MevcutAta_adet.setText(String.valueOf(fm.getAaltinadet()));
				
				
							
				
							
			}
		});		
		SaveButton.setBounds(754, 513, 114, 53);
		frame.getContentPane().add(SaveButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 68, 858, 429);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Euro_Text = new JLabel("Euro");
		Euro_Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Euro_Text.setHorizontalAlignment(SwingConstants.CENTER);
		Euro_Text.setBounds(10, 0, 120, 60);
		panel.add(Euro_Text);
		
		JLabel Dolar_Text = new JLabel("Dolar");
		Dolar_Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Dolar_Text.setHorizontalAlignment(SwingConstants.CENTER);
		Dolar_Text.setBounds(10, 60, 120, 60);
		panel.add(Dolar_Text);
		
		JLabel AltınGram_Text = new JLabel("Altın Gram");
		AltınGram_Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AltınGram_Text.setHorizontalAlignment(SwingConstants.CENTER);
		AltınGram_Text.setBounds(10, 120, 120, 60);
		panel.add(AltınGram_Text);
		
		JLabel AltınÇeyrek_Text = new JLabel("Altın Çeyrek");
		AltınÇeyrek_Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AltınÇeyrek_Text.setHorizontalAlignment(SwingConstants.CENTER);
		AltınÇeyrek_Text.setBounds(10, 180, 120, 60);
		panel.add(AltınÇeyrek_Text);
		
		JLabel AltınYarım_Text = new JLabel("Altın Yarım");
		AltınYarım_Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AltınYarım_Text.setHorizontalAlignment(SwingConstants.CENTER);
		AltınYarım_Text.setBounds(10, 240, 120, 60);
		panel.add(AltınYarım_Text);
		
		JLabel AltınTam_Text = new JLabel("Altın Tam");
		AltınTam_Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AltınTam_Text.setHorizontalAlignment(SwingConstants.CENTER);
		AltınTam_Text.setBounds(10, 300, 120, 60);
		panel.add(AltınTam_Text);
		
		JLabel AltınAta_Text = new JLabel("Altın Ata");
		AltınAta_Text.setFont(new Font("Tahoma", Font.PLAIN, 16));
		AltınAta_Text.setHorizontalAlignment(SwingConstants.CENTER);
		AltınAta_Text.setBounds(10, 360, 120, 60);
		panel.add(AltınAta_Text);
		
		textField_Euro = new JTextField();
		textField_Euro.setBounds(140, 18, 120, 30);
		panel.add(textField_Euro);
		textField_Euro.setColumns(10);
		textField_Euro.setText("0");
		
		textField_Dolar = new JTextField();
		textField_Dolar.setColumns(10);
		textField_Dolar.setBounds(140, 78, 120, 30);
		panel.add(textField_Dolar);
		textField_Dolar.setText("0");
		
		textField_AltınGram = new JTextField();
		textField_AltınGram.setColumns(10);
		textField_AltınGram.setBounds(140, 138, 120, 30);
		panel.add(textField_AltınGram);
		textField_AltınGram.setText("0");
		
		textField_AltınCeyrek = new JTextField();
		textField_AltınCeyrek.setColumns(10);
		textField_AltınCeyrek.setBounds(140, 198, 120, 30);
		panel.add(textField_AltınCeyrek);
		textField_AltınCeyrek.setText("0");
		
		textField_AltınYarım = new JTextField();
		textField_AltınYarım.setColumns(10);
		textField_AltınYarım.setBounds(140, 258, 120, 30);
		panel.add(textField_AltınYarım);
		textField_AltınYarım.setText("0");
		
		textField_AltınTam = new JTextField();
		textField_AltınTam.setColumns(10);
		textField_AltınTam.setBounds(140, 318, 120, 30);
		panel.add(textField_AltınTam);
		textField_AltınTam.setText("0");
		
		textField_AltınAta = new JTextField();
		textField_AltınAta.setColumns(10);
		textField_AltınAta.setBounds(140, 378, 120, 30);
		panel.add(textField_AltınAta);
		textField_AltınAta.setText("0");
		
		
		MevcutDolar = new JLabel("");
		MevcutDolar.setOpaque(true);
		MevcutDolar.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutDolar.setForeground(Color.BLACK);
		MevcutDolar.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutDolar.setBackground(Color.WHITE);
		MevcutDolar.setBounds(453, 77, 120, 30);
		panel.add(MevcutDolar);
		
		MevcutCeyrek = new JLabel("");
		MevcutCeyrek.setOpaque(true);
		MevcutCeyrek.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutCeyrek.setForeground(Color.BLACK);
		MevcutCeyrek.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutCeyrek.setBackground(Color.WHITE);
		MevcutCeyrek.setBounds(314, 198, 120, 30);
		panel.add(MevcutCeyrek);
		
		MevcutYarim = new JLabel("");
		MevcutYarim.setOpaque(true);
		MevcutYarim.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutYarim.setForeground(Color.BLACK);
		MevcutYarim.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutYarim.setBackground(Color.WHITE);
		MevcutYarim.setBounds(314, 258, 120, 30);
		panel.add(MevcutYarim);
		
		MevcutTam = new JLabel("");
		MevcutTam.setOpaque(true);
		MevcutTam.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutTam.setForeground(Color.BLACK);
		MevcutTam.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutTam.setBackground(Color.WHITE);
		MevcutTam.setBounds(314, 318, 120, 30);
		panel.add(MevcutTam);
		
		MevcutAta = new JLabel("");
		MevcutAta.setOpaque(true);
		MevcutAta.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutAta.setForeground(Color.BLACK);
		MevcutAta.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutAta.setBackground(Color.WHITE);
		MevcutAta.setBounds(314, 378, 120, 30);
		panel.add(MevcutAta);
		
		ToplamParalbl = new JLabel("Toplam Para");
		ToplamParalbl.setOpaque(true);
		ToplamParalbl.setHorizontalAlignment(SwingConstants.CENTER);
		ToplamParalbl.setForeground(Color.BLACK);
		ToplamParalbl.setBorder(BorderFactory.createLineBorder(Color.black));
		ToplamParalbl.setBackground(Color.WHITE);
		ToplamParalbl.setBounds(615, 17, 189, 43);
		panel.add(ToplamParalbl);
		
		MevcutEuro_tl = new JLabel("");
		MevcutEuro_tl.setOpaque(true);
		MevcutEuro_tl.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutEuro_tl.setForeground(Color.BLACK);
		MevcutEuro_tl.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutEuro_tl.setBackground(Color.WHITE);
		MevcutEuro_tl.setBounds(314, 18, 120, 30);
		panel.add(MevcutEuro_tl);
		
		MevcutDolar_tl = new JLabel("");
		MevcutDolar_tl.setOpaque(true);
		MevcutDolar_tl.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutDolar_tl.setForeground(Color.BLACK);
		MevcutDolar_tl.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutDolar_tl.setBackground(Color.WHITE);
		MevcutDolar_tl.setBounds(314, 78, 120, 30);
		panel.add(MevcutDolar_tl);
		
		MevcutGram = new JLabel("");
		MevcutGram.setOpaque(true);
		MevcutGram.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutGram.setForeground(Color.BLACK);
		MevcutGram.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutGram.setBackground(Color.WHITE);
		MevcutGram.setBounds(314, 138, 120, 30);
		panel.add(MevcutGram);
		
		lblNewLabel = new JLabel("TL");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(813, 18, 45, 42);
		panel.add(lblNewLabel);
		
		MevcutEuro = new JLabel("");
		MevcutEuro.setOpaque(true);
		MevcutEuro.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutEuro.setForeground(Color.BLACK);
		MevcutEuro.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutEuro.setBackground(Color.WHITE);
		MevcutEuro.setBounds(453, 17, 120, 30);
		panel.add(MevcutEuro);
		
		lblNewLabel_1 = new JLabel("TL");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(433, 9, 45, 42);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("EU");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(574, 9, 45, 42);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("DL");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(574, 69, 45, 42);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("TL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(433, 69, 45, 42);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("TL");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(433, 129, 45, 42);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("TL");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(433, 189, 45, 42);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("TL");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(433, 249, 45, 42);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("TL");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(433, 309, 45, 42);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("TL");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(433, 369, 45, 42);
		panel.add(lblNewLabel_9);
		
		MevcutGram_adet = new JLabel("");
		MevcutGram_adet.setOpaque(true);
		MevcutGram_adet.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutGram_adet.setForeground(Color.BLACK);
		MevcutGram_adet.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutGram_adet.setBackground(Color.WHITE);
		MevcutGram_adet.setBounds(453, 138, 120, 30);
		panel.add(MevcutGram_adet);
		
		MevcutCeyrek_adet = new JLabel("");
		MevcutCeyrek_adet.setOpaque(true);
		MevcutCeyrek_adet.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutCeyrek_adet.setForeground(Color.BLACK);
		MevcutCeyrek_adet.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutCeyrek_adet.setBackground(Color.WHITE);
		MevcutCeyrek_adet.setBounds(453, 198, 120, 30);
		panel.add(MevcutCeyrek_adet);
		
		MevcutYarim_adet = new JLabel("");
		MevcutYarim_adet.setOpaque(true);
		MevcutYarim_adet.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutYarim_adet.setForeground(Color.BLACK);
		MevcutYarim_adet.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutYarim_adet.setBackground(Color.WHITE);
		MevcutYarim_adet.setBounds(453, 258, 120, 30);
		panel.add(MevcutYarim_adet);
		
		MevcutTam_adet = new JLabel("");
		MevcutTam_adet.setOpaque(true);
		MevcutTam_adet.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutTam_adet.setForeground(Color.BLACK);
		MevcutTam_adet.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutTam_adet.setBackground(Color.WHITE);
		MevcutTam_adet.setBounds(453, 318, 120, 30);
		panel.add(MevcutTam_adet);
		
		MevcutAta_adet = new JLabel("");
		MevcutAta_adet.setOpaque(true);
		MevcutAta_adet.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutAta_adet.setForeground(Color.BLACK);
		MevcutAta_adet.setBorder(BorderFactory.createLineBorder(Color.black));
		MevcutAta_adet.setBackground(Color.WHITE);
		MevcutAta_adet.setBounds(453, 378, 120, 30);
		panel.add(MevcutAta_adet);
		
		JLabel EklenilcekDeger = new JLabel("Ekle");
		EklenilcekDeger.setHorizontalAlignment(SwingConstants.CENTER);
		EklenilcekDeger.setFont(new Font("Tahoma", Font.PLAIN, 14));
		EklenilcekDeger.setBounds(145, 10, 124, 34);
		frame.getContentPane().add(EklenilcekDeger);
		
		JLabel MevcutPara = new JLabel("Mevcut Para");
		MevcutPara.setHorizontalAlignment(SwingConstants.CENTER);
		MevcutPara.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MevcutPara.setBounds(382, 10, 124, 34);
		frame.getContentPane().add(MevcutPara);
		
		ToplamPara = new JLabel("Toplam Para");
		ToplamPara.setHorizontalAlignment(SwingConstants.CENTER);
		ToplamPara.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ToplamPara.setBounds(643, 10, 156, 34);
		frame.getContentPane().add(ToplamPara);
		
		
	}
}
