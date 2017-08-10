import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class ApplicationWindow {

	private JFrame frmSimpleGpuplotterHelper;

	/**
	 * Launch the application.
	 */
	
	private static String Hddrs[];
	public static long hddrspace[];
	public static int selectedHdd=0;
	
	public static JComboBox<String> comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtGigaBytes;
	private JTextField txtBytes;
	private JLabel labelGigaNonces;
	private JLabel lblByteNonces;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					File[] roots = File.listRoots();
					hddrspace=new long[roots.length];
					Hddrs=new String[roots.length];
					for(int i = 0; i < roots.length ; i++) {
					    Hddrs[i]=roots[i]+":\t\t-"+roots[i].getUsableSpace()+"\t bytes of usable space.";  
					   hddrspace[i]=roots[i].getUsableSpace();
					  //  System.out.println(HddrFreeSpace[i]);
					}
					
					ApplicationWindow window = new ApplicationWindow();
					window.frmSimpleGpuplotterHelper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimpleGpuplotterHelper = new JFrame();
		frmSimpleGpuplotterHelper.setTitle("Simple GpuPlotter Helper");
		frmSimpleGpuplotterHelper.setBounds(100, 100, 666, 551);
		frmSimpleGpuplotterHelper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmSimpleGpuplotterHelper.getContentPane().add(panel);
		
		JLabel lblhdd = new JLabel("Select Hard Drive to plot:");
		lblhdd.setBounds(10, 8, 212, 14);
		
		comboBox = new JComboBox<String>(Hddrs);
		//comboBox = new JComboBox<String>();
		comboBox.setBounds(232, 5, 396, 20);
		panel.setLayout(null);
		panel.add(lblhdd);
		panel.add(comboBox);
		comboBox.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println(comboBox.getSelectedItem());
				selectedHdd=comboBox.getSelectedIndex();
				String s=hddrspace[selectedHdd]+"";
				textField.setText(s);
				
				
			}

		});
		
		
		
		
		
		JLabel lblAmountToPlot = new JLabel("Amount to plot (bytes):");
		lblAmountToPlot.setBounds(10, 53, 212, 14);
		panel.add(lblAmountToPlot);
		
		textField = new JTextField();
		textField.setBounds(232, 50, 396, 20);
		panel.add(textField);
		textField.setColumns(10);
		String s=hddrspace[selectedHdd]+"";
		textField.setText(s);
		
		JLabel lblSizeOfPlot = new JLabel("Size of plot in nonces:");
		lblSizeOfPlot.setBounds(10, 107, 212, 14);
		panel.add(lblSizeOfPlot);
		
		textField_1 = new JTextField();
		textField_1.setText("4096000");
		textField_1.setColumns(10);
		textField_1.setBounds(232, 104, 396, 20);
		panel.add(textField_1);
		
		JLabel lblStartingNonce = new JLabel("Starting nonce:");
		lblStartingNonce.setBounds(10, 158, 212, 14);
		panel.add(lblStartingNonce);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(232, 155, 396, 20);
		panel.add(textField_2);
		
		JLabel lblBurstNumericId = new JLabel("Burst numeric ID:");
		lblBurstNumericId.setBounds(10, 218, 212, 14);
		panel.add(lblBurstNumericId);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(232, 215, 396, 20);
		panel.add(textField_3);
		
		JLabel lblAmountOfRam = new JLabel("Amount of RAM:");
		lblAmountOfRam.setBounds(10, 268, 212, 14);
		panel.add(lblAmountOfRam);
		
		textField_4 = new JTextField();
		textField_4.setText("32768");
		textField_4.setColumns(10);
		textField_4.setBounds(232, 265, 396, 20);
		panel.add(textField_4);
		
		txtGigaBytes = new JTextField();
		txtGigaBytes.setText("1000");
		txtGigaBytes.setBounds(10, 407, 312, 20);
		panel.add(txtGigaBytes);
		txtGigaBytes.setColumns(10);
		
		JButton btnCreate = new JButton("Create .bat Files");
		btnCreate.setForeground(Color.BLACK);
		btnCreate.setBounds(180, 296, 289, 37);
		panel.add(btnCreate);
		
		btnCreate.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // nrdi neki ko klikne button
			  try {
				createBatFiles();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  }
		});
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.setBounds(268, 438, 158, 23);
		panel.add(btnConvert);
		
		btnConvert.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
		    // nrdi neki ko klikne button
			  convert();
			 
		  }
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 344, 630, 2);
		panel.add(separator);
		
		JLabel lblNonceCalculator = new JLabel("Nonce Calculator");
		lblNonceCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		lblNonceCalculator.setBounds(223, 357, 203, 20);
		panel.add(lblNonceCalculator);
		
		txtBytes = new JTextField();
		txtBytes.setText("262144");
		txtBytes.setColumns(10);
		txtBytes.setBounds(10, 472, 312, 20);
		panel.add(txtBytes);
		
		JLabel lblGigabytes = new JLabel("GigaBytes");
		lblGigabytes.setBounds(10, 382, 91, 14);
		panel.add(lblGigabytes);
		
		JLabel lblBytes = new JLabel("Bytes");
		lblBytes.setBounds(10, 447, 91, 14);
		panel.add(lblBytes);
		
		lblByteNonces = new JLabel("1");
		lblByteNonces.setBounds(363, 475, 265, 14);
		panel.add(lblByteNonces);
		
		labelGigaNonces = new JLabel("4096000");
		labelGigaNonces.setBounds(363, 410, 265, 14);
		panel.add(labelGigaNonces);
		
		
	}

	protected void convert() {
		// TODO Auto-generated method stub
		 int gigaBytes=Integer.parseInt(txtGigaBytes.getText());
		 labelGigaNonces.setText(gigaBytes*4096+"");
		 
		 long bytes=Long.parseLong(txtBytes.getText());
		 lblByteNonces.setText(Math.floorDiv(bytes, 262144)+"");
	}

	protected void createBatFiles() throws Exception {
		String numberid="14746343823958034201";
		
		BigInteger zacetek=new BigInteger(textField_2.getText());
		String label=Hddrs[selectedHdd].split(":")[0];
		int sizeOfBlock=Integer.parseInt(textField_1.getText());//in nonces
		BigInteger space=new BigInteger(textField.getText());

		
		//1 nonce = 262144 bytes
		BigInteger[] allNonces=new BigInteger[2];
		 allNonces=space.divideAndRemainder(new BigInteger(262144+""));
		int stevilo_plotov=Integer.parseInt(allNonces[0].toString())/sizeOfBlock;
		
		int ostanek=Integer.parseInt(allNonces[0].toString())-stevilo_plotov*sizeOfBlock;
		ostanek-=stevilo_plotov;
		
		//neki z ostankom nrdit, nevem ce se mi da jebat s tem
		

		
		//System.out.println(ostanek+" "+stevilo_plotov);

		String rez="";
		for(int i=0;i<stevilo_plotov;i++) {
			zacetek=zacetek.add(new BigInteger("1"));
			String temp="gpuPlotGenerator generate buffer "+label+":\\"+numberid+"_"+(zacetek)+"_"+sizeOfBlock+"_"+Integer.parseInt(textField_4.getText());
			//tole u file "+label+"_plot"+i+;
			zacetek=zacetek.add(new BigInteger(sizeOfBlock+""));
			try (PrintStream out = new PrintStream(new FileOutputStream(label+"plot_"+i+".bat"))) {
			    out.print(temp);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(frmSimpleGpuplotterHelper, e.getMessage());

			}
			
			
			String temp2="@echo off\r\n" + 
					"echo starting new plot >>\"log+"+label+".txt\"\r\n" + 
					"echo starting "+label+"_plot"+i+" >>\"log"+label+".txt\"\r\n" + 
					"@echo on\r\n" + 
					"call "+label+"plot_"+i+"\r\n"+
					"echo Plotting successful, deleting .bat file. >>\"log+"+label+".txt\"\r\n" + 
					"del /f "+label+"plot_"+i+"\r\n";

			rez=rez+temp2;
			
			
		}
		
		//poplottat se ostanek
		if(ostanek>4096) {
			zacetek=zacetek.add(new BigInteger("1"));
			String temp="gpuPlotGenerator generate buffer "+label+":\\"+numberid+"_"+(zacetek)+"_"+sizeOfBlock+"_"+Integer.parseInt(textField_4.getText());
		//tole u file "+label+"_plot"+i+;
		zacetek=zacetek.add(new BigInteger(ostanek+""));
		try (PrintStream out = new PrintStream(new FileOutputStream(label+"plot_"+stevilo_plotov+".bat"))) {
		    out.print(temp);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(frmSimpleGpuplotterHelper, e.getMessage());

		}
		
		
		String temp2="@echo off\r\n" + 
				"echo Plotting the remainder >>\"log+"+label+".txt\"\r\n" + 
				"echo starting "+label+"_plot"+stevilo_plotov+" >>\"log"+label+".txt\"\r\n" + 
				"@echo on\r\n" + 
				"call "+label+"plot_"+stevilo_plotov+"\r\n"+
				"echo remainder plotted successfully, deleting .bat file >>\"log"+label+".txt\" \r\n"+
				"del /f "+label+"plot_"+stevilo_plotov+"\r\n";

		rez=rez+temp2;
		
		}
		
		try (PrintStream out = new PrintStream(new FileOutputStream(label+"_hdd_Plotter_Start_me.bat"))) {
		    out.print(rez);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(frmSimpleGpuplotterHelper, e.getMessage());

		}
		
		JOptionPane.showMessageDialog(frmSimpleGpuplotterHelper, ".bat files written successfully.\n To start plotting selected drive please run the "+label+"_hdd_Plotter_Start_me.bat\nDonations:\n Bitcoin : 1KufxtviWreqPYNV4Ffp6BRpyGRJyNU7p8\nBURST: BURST-QKST-LJBE-UEG2-EBEBT\n\ncontact : Ragnar1724@gmail.com");
		
	}
}
