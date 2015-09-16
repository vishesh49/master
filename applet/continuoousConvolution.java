import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.net.URL;
import java.util.HashMap;
import javax.swing.JTextPane;
import javax.swing.text.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;




import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.awt.geom.*;


/*
<applet code="continuousConvolution" width=1000 height=600>
</applet>
*/

public class continuousConvolution extends JApplet implements MouseListener,ActionListener,ItemListener,ChangeListener,Runnable//,TableCellRenderer
{	
	
	
	 Point pt;
	 
	 JComponent container1;
	
	 JButton btnPlay, btnStop,btnPause,btnLabel1,btnlabel2;  
	 JLabel selSignal,selSignal1,text_image;
	 
	 Thread animator;
	 Graphics g;
	 //int temp1, temp2,numMove=10,numMove_temp = 0;
	 int numMove = 10;
	 double pix = 0.0,tempy = 0,temp  = 210,temp31 = 210, yval = 0,yval1 = 0,yval2 = 0,y = 350,val = 0,y1 =350;
	
	 double equY=0,timeShiftValue=0;
	// int counteri = 0,counterj = 0,counterk=0;
	 int counteri = 0,counterj = 0;
	 int option1 = 0,option2 = 0,ex = 1;
	 int option11 = 0,option21 = 0;
	 boolean visited=false;
	// int comboOption = 0;
	//aruna
	JTextPane jtp1,jtp2;
	Cursor handCursor,normalCursor;
	TextArea ta = null;
	TextArea th = null;
	TextArea ins = null;
	JLabel lbl,lbl1;
	JLabel info,info1;
	
	JLabel lblT1,lblT2;
	JFrame glos,hel,frl1;
	
	volatile Thread current = null;
	boolean paused = true;
	boolean animationrunning = false,stopf1=false,clearScreen = false,signal_one_selected = false,signal_two_selected = false;
	
	int i= 0;
	Dimension d;		
	/*  variable declaration for convolution */
	// GraphicsUtil graphicsUtil;
	
	ImageIcon imageOption1,imageOption2,imageOption3,imageLabel1,imageLabel2;
	JButton btnOption1,btnOption2,btnOption3;
	JButton btnOption12,btnOption22,btnOption32;
	
	int counter =1 ,flagC = 0,graphCounter=0;
	 //int methodFlag = 0,tempCount = 0,ci = 0 ,graphNo=0,shiftCount=0,flagC1=0;
	 int ci = 0;
	 int [] xaxpoints1R, xaypoints1R, yaxpoints1R, yaypoints1R, xaxpoints2R, xaypoints2R, yaxpoints2R, yaypoints2R,xaxpoints2a,xaypoints2a;
	 int [] xaxpoints1, xaypoints1, yaxpoints1, yaypoints1, xaxpoints2, xaypoints2, yaxpoints2, yaypoints2;   // used for the axis display
	double  xpointsCircle,ypointsCircle;
	 double [] xpoints1, ypoints1, xpoints2, ypoints2,xpoints1O1, ypoints1O1, xpoints2O1, ypoints2O1; // first graph 		
	 double [] xpoints1O2, ypoints1O2, xpoints2O2, ypoints2O2,xpoints1O3, ypoints1O3, xpoints2O3, ypoints2O3;
	 double [] xpointsArea,ypointsArea, xpointsFinal,ypointsFinal,xpointsIntegrate,ypointsIntegrate;
	 double [] xpoints1R, ypoints1R, xpoints2R, ypoints2R,xpoints1RO1, ypoints1RO1, xpoints2RO1, ypoints2RO1; // first graph 
	 double [] xpoints1RO2, ypoints1RO2, xpoints2RO2, ypoints2RO2,xpoints1RO3, ypoints1RO3, xpoints2RO3, ypoints2RO3;
	 int [] xaxpoints21,xaypoints21,yaxpoints21,yaypoints21,xaxpoints31,xaypoints31,yaxpoints31,yaypoints31;
	 double [] xpointsOption1, xpointsOption2,xpointsOption3,ypointsOption1,ypointsOption2,ypointsOption3;
	 double [] xpointsAreaI,ypointsAreaI,xpointsArea12,ypointsArea12,xpointsArea22,ypointsArea22,xpointsArea23,ypointsArea23;
	
	// JRadioButton rb1,rb2;
	 //ButtonGroup rbGroup1;
	 
	 JLabel demo_sigma,lbl_multSignal_image,lbl_integrateSignal_image;
	 // second method
	// int [] xaxpointsM2g1, xaypointsM2g1, yaxpointsM2g1, yaypointsM2g1,xaxpointsM2g2, xaypointsM2g2, yaxpointsM2g2, yaypointsM2g2,xaxpointsM2gfo, xaypointsM2gfo, yaxpointsM2gfo, yaypointsM2gfo,YnoutputSignalX,YnoutputSignalY;
	double[] YnoutputSignalX1,YnoutputSignalY1;
	/* end of variable declaration for convolution */
	
	JLabel lbl_subject,lbl_topic,lbl_oscar_image,lbl_home,lbl_openingscreen; //for Header part
	JButton but_Theory,but_Demo,but_Interaction,but_Glossary,but_Exercise,but_Help,but_Links,but_Analogy,but_credits,but_home; //Different tabs
	JButton but_go_links,but_go1_links,but_close_links; //for FurtherReadingTab
	JButton fr_exercise_but1,fr_exercise_but2,fr_exercise_but3,fr_exercise_but4,fr_exercise_but5; //for ExerciseTab
	JFrame fr_credits,fr_links; //Now not using
	JLabel fr_links_Message,fr_links_Message1;//for Furtherreading tab
	JLabel fr_help_head,fr_help_Message; //for HelpTab
	JLabel fr_exercise_Message,fr_exercise_Message1;//for Exercise[Questionare]Tab
	JLabel lblHeader_glossary,lblMessage_glossary;//For GlossaryTab
	JTable tblLeftIndex_glossary;//for Glossarytable tab
	HashMap map = null; //For Glossarytab
	JTextPane txtPaneDescription_glossary; //For Glossarytab
	JTable table_help; //for HelpTab
	
	
	JCheckBox cb,cb2,cb3,cb4,cb5;
	
	JTextPane txtPane_explanation,txtPane_credits,txtPane_theory,txtPane_Analogy,txtPane_interaction,opening_screen,opening_screen1,opening_screen_message;//Display Area of Demo,credits,theory,interaction etc.
	JTextPane txtPane_Exercise1,txtPane_Exercise2,txtPane_Exercise3,txtPane_Exercise4,txtPane_Exercise5,fr_exercise_answer,txtPane_ref;//For Questions and Answer for QuestionareTab
	
	ButtonGroup group1;// for InteractivityTab.[Table --putting all 0 to 7 buttons into one group]
	JRadioButton q11,q12,q13,q14,q21,q22,q23,q24,q31,q32,q33,q34,q41,q42,q43,q44,q51,q52,q53,q54;
	ButtonGroup q1,q2,q3,q4,q5;//For ExerciseTab.[Answer choices]
	
	JButton but_Pause,but_Resume; // for DemoTab
	
	JLabel fr_credits_author,fr_credits_mentor,fr_credits_developer,fr_credits_designer; //for Credits Tab

	JLabel lbl_Analogy,demo_image1; //For Anlogy tab
	JTable table; //For Interactivity Tab[radioButton including]
	
	ImageIcon im_play,im_pause,im_theory,im_demo,im_interaction,im_analogy,im_glossary,im_help,im_exercise,im_reference,im_credits,im_home,im_reset;//images for tabs
	JPanel panel1,panel2,panel3,panel4,panel5,opening_screen_logo;//for ExerciseTab[includes question and answer choices ---not answer.]
	JPanel paneltemp,lbl_opening_screen_left,demo_selection_panel;
	JPanel theory1,theory2,theory3;
	JButton theory_button1,theory_button2,theory_button3;
	JScrollPane theory1_scrollPane,theory2_scrollPane,theory3_scrollPane;
	
	//for HelpTab.
	String colnames_help[]={"Button","Description"};
	
	boolean blhome=true,blPHY_MEMcheck=false,blPAGETABLEcheck=false,blSEC_MEMcheck=false;
	
	int nAppRowHeight = 24;
	int x = (nAppRowHeight/2);
	

	
	Color yellow = new Color(238,211,65);
	Color yellow_dark = new Color(174,152,49);
	Color grey = new Color(108,108,107);
	Color color1 = new Color(255,204,204);
	Color color2 = new Color(204,255,204);
	Color color3 = new Color(153,153,153);
	
	Color color4 = new Color(149,181,242);
	Color color5 = new Color(0,153,153);
	Color color6 = new Color(255,228,225);
	Color color7 = new Color(0,255,255);
	Color color8 = new Color(244,164,96);
	
	Color color9 = new Color(228,175,61);
	
	Color color10 = new Color(158,205,51);
	Color color11 = new Color(100,100,255);
	Color color12=new Color(227,207,87);
	Color orange1=new Color(102,0,51);
	Color help_color=new Color(236,167,167);
	Color links_color=new Color(125,164,198);
	Color exercise_color=new Color(179,156,132);
	Color glossary_color=new Color(250, 162, 73);
	Color analogy_color=new Color(228,177,203);
	
	Color theory_color=new Color(227, 177, 202);
	Color lightgrey = new Color(200,200,200);
	
	Color demo_color = new Color(133, 157, 217);
	Color demo_color_new = new Color(102,153,204);
	Color interaction_color = new Color(166,223,244);
	
	Color home_color = new Color(204, 222, 138);
	// for interaction screen color
	Color transmiter = new Color(193,167,134);
	
	Color transtext = new Color(238,111,77);
	Color receiver = new Color(218,201,157);
	
	Color recetext = new Color(244,194,0);
	Color buttonPanel = new Color(196,209,181);
	Color textPanel = new Color(132,156,104);
	Color timingBox = new Color(228,228,190);
	Color playbut = new Color(132,156,104);
	
	Color timeoutBox = new Color(226,234,226);
	Color frame1 = new Color(123,115,173);
	Color frame2 = new Color(156,99,99);
	Color frame3 = new Color(156,148,99);
	Color frame4 = new Color(115,148,173);
	Color new_head_color = new Color(58, 58, 58);
	
	Color header_color = new Color(58,58,58);
	Color highlight = new Color(230,230,250);

	Border thickBorder_theory = new LineBorder(theory_color, 6);
	Border thickBorder_demo = new LineBorder(demo_color, 6);
	Border thickBorder_interaction = new LineBorder(interaction_color, 6);
	Border thickBorder_analogy = new LineBorder(analogy_color, 6);
	Border thickBorder_glossary = new LineBorder(glossary_color, 6);
	Border thickBorder_exercise = new LineBorder(exercise_color, 6);
	Border thickBorder_links = new LineBorder(links_color, 6);
	Border thickBorder_help = new LineBorder(help_color, 6);
	Border thickBorder_home = new LineBorder(new Color(0xFFAA73), 6);
	
	Border theoryBorder = new LineBorder(color2,2);
	Border interactionBorder = new LineBorder(yellow_dark,1);
	
	Border line_border = BorderFactory.createLineBorder(Color.black,2);
	
	boolean exercise=false,demo=false,demo_zero=false,demo_first=false,demo_second=false,demo_third=false,demo_forth=false,demo_fifth=false,demo_sixth=false,demo_seventh=false,demo_eighth=false,demo_nineth=false,demo_tenth=false,demo_eleventh=false,demo_twelvth=false,demo_thirteenth=false,demo_forteenth=false;
	boolean demo_fifteenth=false,demo_sixteenth=false,demo_seventeenth=false,demo_eighteenth=false,demo_nineteenth=false,demo_twentieth=false;
	boolean demo_21=false,demo_22=false,demo_23=false,demo_24=false,demo_25=false,demo_26=false,demo_27=false,demo_28=false,demo_29=false,demo_30=false,demo_31=false,demo_32=false;
	boolean interaction_first=false,interaction_second=false,interaction_third=false,interaction_forth=false,interaction_fifth=false;
	boolean blTheory=false,blAnalogy=false,blInteraction=false,blGlossary=false,blExercise=false,blHelp=false,blLinks=false;
	boolean stopf=false;
	boolean flag=false;
	boolean thisone,thistwo;
	int demo_incr=-1,interaction_incr=0;
	int demo_sleeptime=3000;
	int interaction_sleeptime=3000;


	class mypaint extends JPanel
	{
		private static final long serialVersionUID = 1L;
		
		public void paintComponent(Graphics g)
		{
			/*Graphics2D g = (Graphics2D)gg;
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			super.paintComponent(g);*/
			System.out.println("NOW PAINT METHOD HAS STARTED");	
			try
			{
				
				g.setColor(header_color);
				g.fillRect(2,2,998,75);	
				
				g.setColor(grey);//Applet panel
				g.drawRect(2,77,998,503);			
				
				g.setColor(grey);//footer
				g.fillRect(2,580,998,20);
				g.setColor(Color.white);
				g.drawString("The contents in this page are licensed under Creative Commons Attribution-NonCommercial-ShareAlike 2.5 India license.",5,592);
				
				/*if(blInteraction==true)
				{	hex to rgb color code
					
					
					
					
				}//end of if interaction
				*/
				//show here analogy
				if(blAnalogy==true)
				{
					
				}//end of analogy
				
				
			/*	if(blGlossary==true)
				{
					Graphics2D g2d = (Graphics2D)g;
				    Color s1 = glossary_color;
				    Color e = Color.white;
				    GradientPaint gradient = new GradientPaint(2,77,s1,7,550,e,true);
				    g2d.setPaint(gradient);
					g.fillRect(2,77,998,10);
					g.fillRect(2,77,10,500);
					g.fillRect(990,77,10,500);
				}*/
				
				if(blLinks==true)
				{
					Graphics2D g2d = (Graphics2D)g;
				    Color s1 = links_color;
				    Color e = Color.white;
				    GradientPaint gradient = new GradientPaint(2,77,s1,7,550,e,true);
				    g2d.setPaint(gradient);
					g.fillRect(2,77,998,10);
					g.fillRect(2,77,10,500);
					g.fillRect(990,77,10,500);
				}
			
				if(blExercise==true)
				{
					Graphics2D g2d = (Graphics2D)g;
				    Color s1 = exercise_color;
				    Color e = Color.white;
				    GradientPaint gradient = new GradientPaint(2,77,s1,7,550,e,true);
				    g2d.setPaint(gradient);
					g.fillRect(2,77,998,10);
					g.fillRect(2,77,10,500);
					g.fillRect(990,77,10,500);			
				}
				if(blHelp==true)
				{
					Graphics2D g2d = (Graphics2D)g;
				    Color s1 = help_color;
				    Color e = Color.white;
				    GradientPaint gradient = new GradientPaint(2,77,s1,7,550,e,true);
				    g2d.setPaint(gradient);
					g.fillRect(2,77,998,10);
					g.fillRect(2,77,10,500);
					g.fillRect(990,77,10,500);				
			
				}
				if(blhome==true)
				{
					  Graphics2D g2d = (Graphics2D)g;
				      Color s1 = home_color;
				      Color e = Color.white;
				      GradientPaint gradient = new GradientPaint(2,77,s1,7,450,e,true);
				      g2d.setPaint(gradient);
				      g.fillRect(2,77,998,10);
				      g.fillRect(2,77,10,500);
				      g.fillRect(990,77,10,500);	
			
				}
				if(blTheory==true)
				{
					Graphics2D g2d = (Graphics2D)g;
				    Color s1 = theory_color;
				    Color e = Color.white;
				    GradientPaint gradient = new GradientPaint(2,77,s1,7,550,e,true);
				    g2d.setPaint(gradient);
					g.fillRect(2,77,998,10);
					g.fillRect(2,77,10,500);
					g.fillRect(990,77,10,500);
													
				}
						
				//if demo button is pressed
				//if(stopf==false)
				//{			
				if(blInteraction==true)	//START OF INTERACTION
				{
					System.out.println("Start of Interaction");
					clearPannel(g);
					Graphics2D g2d = (Graphics2D)g;
				    Color s1 = interaction_color;
				    Color e = Color.white;
				    GradientPaint gradient = new GradientPaint(2,77,s1,7,550,e,true);
				    g2d.setPaint(gradient);
					g.fillRect(2,77,998,10);
					g.fillRect(2,77,10,500);
					g.fillRect(990,77,10,500);
					
					
					//--------------------------
					 
					g.setColor(demo_color_new);
					g.fillRect(12,87,980,40);
					g.setColor(Color.WHITE);
					g.setFont(new Font("Arial",Font.BOLD,20));
					g.drawString("Please select the signal by clicking on the signal images on the right side.",10,110 );
					
					g.setFont(new Font("Arial",Font.PLAIN,12));
					g.setColor(demo_color_new);	
					
					//g.drawLine(600,125,600,580);
					g.drawLine(400,125,400,580);
					// to display text or instructions
					g.setColor(demo_color_new);
					//g.drawLine(600,360,0,360);
					g.drawLine(400,360,0,360);
					
					g.setColor(Color.black);
					g.setFont(new Font("Arial",Font.BOLD,13));
					g.drawString("Explanation", 100,375);
					g.setFont(new Font("Arial",Font.PLAIN,12));
					
					Graphics2D ga = (Graphics2D)g;
					ga.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
					ga.setStroke(new BasicStroke(2));
					
					//drawCurve( g, 355,235);
						// start here right panel
					

					if(cb4.isEnabled())
					{
						graphCounter=7;
						drawGraph(g,xaxpoints2a,xaypoints2a,yaxpoints2,yaypoints2);// graph 1 in right pane
					}
					
						graphCounter=0;
						drawGraph(g,xaxpoints1R,xaypoints1R,yaxpoints1R,yaypoints1R);// graph 1 in right panel
						graphCounter=2;
						drawGraph(g,xaxpoints2R,xaypoints2R,yaxpoints2R,yaypoints2R);// graph 2 in right panel
					
					String temp="";
					
					if(signal_one_selected == true)
					{
				//	if(thisone==true){
				//	 if((e.getSource() == btnOption1)||(e.getSource() == btnOption2)||(e.getSource() == btnOption3)){
						System.out.println("RAHJASDKALSMDKSDMLSAD:LASDASDKASSNDKSADNJASDJASNDASDA");
						g.setColor(Color.red);// first signal
						if(option1 == 1){
							
							drawSignal(ga,xpoints2RO1,ypoints2RO1);
							g.setColor(Color.black);
							g.setFont(new Font("Arial",Font.BOLD,24));
							temp="t";
							if(cb2.isSelected())
								temp="\u03C4";
							g.drawString("x("+temp+")=1", 510, 320);
							g.drawString("0\u2264"+temp+"\u22641", 585, 320);
						}
						if(option1 == 2){
							drawSignal(ga,xpoints2RO2,ypoints2RO2);
							g.setColor(Color.black);
							g.setFont(new Font("Arial",Font.BOLD,24));
							g.drawString("-1 :0\u2264"+temp+"\u22641 ", 530, 320);
							g.drawString("x("+temp+")=  ", 490, 320);
							g.drawString(" 1 :1\u2264"+temp+"\u22642", 530, 375);
						}
						if(option1  == 3){
							//drawCurve(g,650,235,xpoints2RO3,ypoints2RO3);
							drawCurve(g,30,235,xpoints2RO3,ypoints2RO3);
							drawSignal(ga,xpoints2RO3,ypoints2RO3);
							g.setColor(Color.black);
							g.setFont(new Font("Arial",Font.BOLD,24));
							g.drawString("f("+temp+")=e", 510,320);
							g.drawString("-"+temp+"", 535,310);
							g.drawString("0\u2264"+temp+"\u22642", 615, 320);
						}
					//	signal_one_selected=false;
					//	thisone=false;
					}
				
					if(signal_two_selected == true){
			//		if(thistwo==true){
					// if((e.getSource() == btnOption12)||(e.getSource() == btnOption22)||(e.getSource() == btnOption32)){
					
						System.out.println(" in paint method-----------------------------");
						g.setColor(Color.BLUE);// second signal
						if(option2 == 1){
							
							drawSignal(ga,xpoints1RO1,ypoints1RO1);
							g.setColor(Color.black);
							g.setFont(new Font("Arial",Font.BOLD,24));
							g.drawString("g("+temp+")=1", 765, 320);
							g.drawString("0\u2264"+temp+"\u22641", 840, 320);
							
						}
						if(option2 == 2){
							drawSignal(ga,xpoints1RO2,ypoints1RO2);
							g.setColor(Color.black);
							g.setFont(new Font("Arial",Font.BOLD,24));
							g.drawString("-1 :0\u2264"+temp+"\u22641 ", 805, 320);
							g.drawString("g("+temp+")=  ", 745, 320);
							g.drawString("  1 :1\u2264"+temp+"\u22642", 805, 375);
						}
						if(option2 == 3){
						//	drawCurve(g,885,235,xpoints1RO3,ypoints1RO3);
							drawCurve(g,295,235,xpoints1RO3,ypoints1RO3);
							drawSignal(ga,xpoints1RO3,ypoints1RO3);
							g.setColor(Color.black);
							g.setFont(new Font("Arial",Font.BOLD,24));
							g.drawString("g("+temp+")=e", 765, 320);
							g.drawString("-"+temp+"", 825, 305);
							g.drawString("0\u2264"+temp+"\u22642", 860, 320);
						}
				//	signal_two_selected=false;
					//	thistwo=false;
					}
					ga.setStroke(new BasicStroke(1));
					g.setColor(Color.black);
					g.setFont(new Font("Arial",Font.BOLD,13));
				//	g.drawString("g(t)",680,200);
					g.drawString("g(t)",60,150);
				//	g.drawString("f(t)",908,200);
					g.drawString("f(t)",243,150);
					
					// end right panel---------------------------------------------------------------------
					
					// start left panel 
					
										if(flagC  == 0){
						/*cb=new JCheckBox("Select the Signal");
						container1.add(cb);
						cb.setBounds(25,395,350,30);
						//g.drawString("-  f(t) and g(t) are the two continuous signals to ", 63,400);
						cb2=new JCheckBox("Change the time variable from t to tau");
						container1.add(cb2);
						cb2.setBounds(25,425,350,30);
						//g.drawString("   be convolved.", 63,420);
						cb3=new JCheckBox("Reverse the signal h(tau)");
						container1.add(cb3);
						cb3.setBounds(25,455,350,30);
						//g.drawString("-  The convolution of the signals is denoted by " , 63,450);
						cb4=new JCheckBox("Shift the signal h(t-tau) and compute the integral");
						container1.add(cb4);
						cb4.setBounds(25,485,350,30);*/

						//g.drawString("    y(t) = f(t)*g(t)    which means", 63,470);
						
						
					/*	g.drawString("y(t) = âˆ«     f(Ï„)g(t-Ï„)dÏ„ ", 83, 500);
						g.drawString("â�»âˆž", 103, 510);
						g.drawString("â�ºâˆž", 103, 490);
						
					g.drawString("       where Ï„ is a dummy variable", 63, 530);*/
					
					}
					
					
					
					g.setColor(Color.LIGHT_GRAY);
					ga.setStroke(new BasicStroke(1));
					if(cb.isSelected()==true)
					{
					}
					else if(flagC >=2)
					{
						graphCounter  = 7;
						/*xaxpoints2[0] = 35;
						xaxpoints2[1] = 540;*/
						xaxpoints2[0] = 440;
						xaxpoints2[1] = 950;
						drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);// graph 1 in left panel
					}
					else
					{
						graphCounter=2;
						System.out.println(" -----------------graphCounter = "+graphCounter);
						//graphCounter=5;
						Graphics gxx=getGraphics();
					//	drawGraph(g,xaxpoints1,xaypoints1,yaxpoints1,yaypoints1);// graph 1 in left panel
						//graphCounter=1;
						graphCounter=5;
					//	drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);// graph 2 in right panel
					}
				//	System.out.println("graphCounter = ============="+graphCounter);
					ga.setStroke(new BasicStroke(2));
					//graphCounter=6;
					//graphCounter=5;
					// first signal
				if(signal_one_selected == true){
			//	if(thisone==true){
			//		 if((e.getSource() == btnOption1)||(e.getSource() == btnOption2)||(e.getSource() == btnOption3)){
			
						System.out.println(" signal one selected =  = "+signal_one_selected);
						if(option1 == 1){
							if(!cb4.isEnabled())
							drawGraph(g,xaxpoints1,xaypoints1,yaxpoints1,yaypoints1);
							ga.setColor(Color.red);
							drawSignal(ga,xpoints2O1,ypoints2O1);
						}
						if(option1 == 2){
							if(!cb4.isEnabled())
							drawGraph(g,xaxpoints1,xaypoints1,yaxpoints1,yaypoints1);
							ga.setColor(Color.red);
							drawSignal(ga,xpoints2O2,ypoints2O2);
						}
						if(option1 == 3){
							if(!cb4.isEnabled())
							drawGraph(g,xaxpoints1,xaypoints1,yaxpoints1,yaypoints1);
							//System.out.println("  signal 1 option2 ================3");
							//drawSignal(ga,xpoints2O3,ypoints2O3);
							//drawCurve(g,550,235,xpoints2O3,ypoints2O3);
							ga.setColor(Color.red);
							drawSignal(ga,xpoints2O3,ypoints2O3);
						}
					//	signal_one_selected=false;
					//	thisone=false;
					}
				
					if(signal_two_selected == true){
			//		if(thistwo==true){
				//	 if((e.getSource() == btnOption12)||(e.getSource() == btnOption22)||(e.getSource() == btnOption32)){
					
						//ga.setColor(Color.BLUE);// second signal
						if(option2 == 1)
						{
							if(!cb4.isEnabled())
							drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);
							ga.setColor(Color.BLUE);// second signal
							drawSignal(ga,xpoints1O1,ypoints1O1);
						}
						if(option2 == 2){
							if(!cb4.isEnabled())
							drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);
							ga.setColor(Color.BLUE);
							drawSignal(ga,xpoints1O2,ypoints1O2);
						}
						if(option2 == 3){
							if(!cb4.isEnabled())
							drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);
							ga.setColor(Color.BLUE);
							System.out.println(" option2 ================3");
							//drawSignal(ga,xpoints1O3,ypoints1O3);
							drawCurve(g,775,235,xpoints1O3,ypoints1O3);
							drawSignal(ga,xpoints1O3,ypoints1O3);
						}
						//signal_two_selected=false;
					//	thistwo=false;
					}
							
					
					
					//ga.draw(new Line2D.Double(xpoints2[0], ypoints2[0],xpoints2[1], ypoints2[1]));
					ga.setStroke(new BasicStroke(1));
					
					//g.drawLine(35,315, 550, 315);
					//g.drawLine( 340,175,340,335);
					//g.setColor(Color.gray);
					
					
					
					//2nd row
					g.setColor(Color.LIGHT_GRAY);
				
					if(flagC >=2){
						graphCounter = 7;
					}else{
						graphCounter = 6;
					}
					if(cb4.isSelected())
					{
						drawGraph(g,xaxpoints21,xaypoints21,yaxpoints21,yaypoints21);	
						g.setColor(Color.BLACK);
						g.setFont(new Font("Arial",Font.BOLD,14));
						lbl_multSignal_image.setBounds(550,295,88,26);
						lbl_multSignal_image.setVisible(true);
					}
					
					
					
					
					//lbl_multSignal_image=new JLabel("");
					//lbl_multSignal_image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/multSignals.png")));
					//lbl_multSignal_image.setBounds(550,295,88,26);
					//lbl_multSignal_image.setVisible(true);
					//container1.add(lbl_multSignal_image);
					
					//3rd row
					graphCounter = 6;
					
					if(cb4.isSelected())
					{
						drawGraph(g,xaxpoints31,xaypoints31,yaxpoints31,yaypoints31);
						g.setColor(Color.LIGHT_GRAY);
						lbl_integrateSignal_image.setBounds(460,430,187,51);
						lbl_integrateSignal_image.setVisible(true);	
					}

					
					
					//lbl_integrateSignal_image=new JLabel("");
					//lbl_integrateSignal_image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/integrateSignals1.png")));
					
					//lbl_integrateSignal_image.setBounds(50,430,187,51);
					
					//container1.add(lbl_integrateSignal_image);
					
					
					// end graph in 3rd row
					
					//System.out.println("graphCounter = "+graphCounter);
					// draw area in second row
					g.setColor(Color.black);
					ga.setStroke(new BasicStroke(2));
					
					if((option1 == 1)&&(option2 == 1)){
						GeneralPath polylineArea = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
								xpointsAreaI.length);
						polylineArea.moveTo (xpointsAreaI[0], ypointsAreaI[0]);
						for ( int index = 1; index < xpointsAreaI.length; index++ ) {
							polylineArea.lineTo(xpointsAreaI[index], ypointsAreaI[index]);
						};
						ga.draw(polylineArea);
					}else if((option1 == 1)&&(option2 ==2)){
						GeneralPath polylineArea = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
								xpointsArea12.length);
						polylineArea.moveTo (xpointsArea12[0], ypointsArea12[0]);
						for ( int index = 1; index < xpointsArea12.length; index++ ) {
							polylineArea.lineTo(xpointsArea12[index], ypointsArea12[index]);
						};
						ga.draw(polylineArea);
					}
					else if((option1 == 1)&&(option2 ==3)){
						GeneralPath polylineArea = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
								xpointsArea22.length);
						polylineArea.moveTo (xpointsArea22[0], ypointsArea22[0]);
						for ( int index = 1; index < xpointsArea22.length; index++ ) {
							polylineArea.lineTo(xpointsArea22[index], ypointsArea22[index]);
						};
						ga.draw(polylineArea);
					}
					else if((option1 == 2)&&(option2 ==1)){
						
						//drawSignal(ga,xpointsArea12,ypointsArea12);
						
						GeneralPath polylineArea = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
								xpointsArea12.length);
						polylineArea.moveTo (xpointsArea12[0], ypointsArea12[0]);
						for ( int index = 1; index < xpointsArea12.length; index++ ) {
							polylineArea.lineTo(xpointsArea12[index], ypointsArea12[index]);
						};
						ga.draw(polylineArea);
					}
					else if((option1 == 2)&&(option2 ==2)){
						
						drawSignal(ga,xpointsArea22,ypointsArea22);
						
					}
					else if((option1 == 2)&&(option2 == 3)){
						//drawSignal(ga,xpointsArea12,ypointsArea12);
						drawSignal(ga,xpointsArea23,ypointsArea23);
					}
					else if((option1 == 3)&&(option2 == 1)){
						//drawSignal(ga,xpointsAreaI,ypointsAreaI);
						drawSignal(ga,xpointsArea22,ypointsArea22);
					}
					else if((option1 == 3)&&(option2 == 2)){
						//drawSignal(ga,xpointsArea12,ypointsArea12);
						drawSignal(ga,xpointsArea23,ypointsArea23);
					}
					else if((option1 == 3)&&(option2 == 3)){
						drawSignal(ga,xpointsAreaI,ypointsAreaI);
					}
					xpointsFinal[0] =  355;
			    	xpointsFinal[1] =   355;
					xpointsIntegrate[0] = 500;
					ypointsIntegrate[0] = 500;
					
					
					for(int ic = 0;ic<counteri;ic++){
						ga.draw(new Line2D.Double(xpointsIntegrate[ic], ypointsIntegrate[ic],xpointsIntegrate[ic+1], ypointsIntegrate[ic+1]));
						ga.fill(new Ellipse2D.Double(xpointsCircle-5, ypointsCircle-5,10,10));
					}
					
					
					
					
					ga.setStroke(new BasicStroke(1));
					// end left panel
								//drawTau(g,50,200);
								//ga.setStroke(new BasicStroke(1));	
					g.setColor(Color.black);
					g.setFont(new Font("Arial",Font.BOLD,12));
					//g.drawString("f(t)",390,145);
					if(cb.isSelected()==true)
					{
					}
					
					else if(flagC <=1){
						
						//g.drawString("g(t)",600,175);
						//g.drawString("f(t)",840,175);
						
						}
					 	
					else if(flagC <3){	
							g.setColor(Color.black);
							g.setFont(new Font("Arial",Font.BOLD,14));
							drawTau(g,185,136);
							g.drawString("g(-", 160,145);
							g.drawString(")", 195,145);
							g.drawString("f(", 390, 145);
							drawTau(g,405,136);
							g.drawString(")", 415, 145);
							
						}
					else if(flagC >=3){
						//graphCounter = 5;
						graphCounter = 7;
						drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);
						g.setColor(Color.black);
						g.setFont(new Font("Arial",Font.BOLD,14));
						drawTau(g,190,136);
						g.drawString("g(t-", 160,145);
						g.drawString(")", 200,145);
						g.drawString("f(", 390, 145);
						drawTau(g,405,136);
						g.drawString(")", 415, 145);
						if(option1 == 1){
							g.drawString("t", (int)xpoints2O1[0]-10+ci, (int)ypoints2O1[0]+15);
							g.drawString("-1+t", (int)xpoints2O1[3]-35+ci, (int)ypoints2O1[3]+15);
						}
						if(option1 == 2){
							g.drawString("t", (int)xpoints2O2[0]-10+ci, (int)ypoints2O2[0]-10);
							g.drawString("-1+t", (int)xpoints2O2[5]-35+ci, (int)ypoints2O2[5]+15);
						}
						if(option1 == 3){
							g.drawString("t", (int)xpoints2O3[0]-10+ci, (int)ypoints2O3[0]+15);
							g.drawString("-1+t", (int)xpoints2O3[12]-35+ci, (int)ypoints2O3[12]+15);
						}
						//System.out.println("graphCounter = "+graphCounter);
						
						
					}
					
					// text explanation 
					
					g.setColor(Color.black);
					
					g.setFont(new Font("Arial",Font.PLAIN,14));
			/*		if(flagC  == 0){
						cb=new JCheckBox("Select the Signal");
						container1.add(cb);
						cb.setBounds(25,395,350,30);
						//g.drawString("-  f(t) and g(t) are the two continuous signals to ", 63,400);
						cb2=new JCheckBox("Change the time variable from t to tau");
						container1.add(cb2);
						cb2.setBounds(25,425,350,30);
						//g.drawString("   be convolved.", 63,420);
						cb3=new JCheckBox("Reverse the signal h(tau)");
						container1.add(cb3);
						cb3.setBounds(25,455,350,30);
						//g.drawString("-  The convolution of the signals is denoted by " , 63,450);
						cb4=new JCheckBox("Shift the signal h(t-tau) and compute the integral");
						container1.add(cb4);
						cb4.setBounds(25,285,350,30);
						//g.drawString("    y(t) = f(t)*g(t)    which means", 63,470);
						
						
						g.drawString("y(t) = âˆ«     f(Ï„)g(t-Ï„)dÏ„ ", 83, 500);
						g.drawString("â�»âˆž", 103, 510);
						g.drawString("â�ºâˆž", 103, 490);
						
					g.drawString("       where Ï„ is a dummy variable", 63, 530);
					
					}*/
					
					
					
					
		/*			if((flagC ==1)||(flagC==2)){
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed version of  g(Ï„)  i.e., g(-Ï„) is shown", 63,430);
						
					}
					if(flagC==3){
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
						g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
						g.drawString("-  Two functions do not overlap ", 63,480);
						
					}
					if(flagC == 4){
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
						g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
						g.drawString("-  Two functions do not overlap ", 63,480);
					}
					if(flagC == 5){
						
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
						g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
						
						g.drawString("-  Part of g(t-Ï„) overlaps part of  f(Ï„) ", 63,480);
						
						
						
						
					}
					if(flagC==6){
						
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
						g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
						if((option1 == 1)&&(option2 == 1)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						
						else if((option1 == 2)&&(option2 == 2)){
							g.drawString("-  Part of g(t-Ï„)  overlaps part of f(Ï„) ", 63,480);
						}else if((option1 == 2)&&(option2 == 3)){
							g.drawString("-  Part of g(t-Ï„)  overlaps part of f(Ï„) ", 63,480);
						}else if((option1 == 3)&&(option2 == 1)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 3)&&(option2 == 2)){
							g.drawString("-  Part of g(t-Ï„)  overlaps part of f(Ï„) ", 63,480);
						}
						else if((option1 == 1)&&(option2 == 2)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 1)&&(option2 == 3)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}else if((option1 == 2)&&(option2 == 1)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						else{
							g.drawString("-   Part of g(t-Ï„)  overlaps part of f(Ï„)  ", 63,480);
						}
						
					}
					if((flagC==7)){
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
						g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
						if((option1 == 1)&&(option2 == 1)){
							g.drawString("-   Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}else if((option1 == 2)&&(option2 == 1)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 2)&&(option2 == 2)){
							g.drawString("-   Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}else if((option1 == 2)&&(option2 == 3)){
							g.drawString("-   Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}else if((option1 == 3)&&(option2 == 2)){
							g.drawString("-   Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}else if((option1 == 3)&&(option2 == 3)){
							g.drawString("-   Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}
						else{
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						
					}if((flagC==8)){
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
						g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
						if((option1 == 1)&&(option2 == 1)){
							g.drawString("-   Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}else if((option1 == 2)&&(option2 == 1)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 2)&&(option2 == 2)){
							g.drawString("-  Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}
						else if((option1 == 2)&&(option2 == 3)){
							g.drawString("-  Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}
						else if((option1 == 3)&&(option2 == 1)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 3)&&(option2 == 2)){
							g.drawString("-  Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}else if((option1 == 3)&&(option2 == 3)){
							g.drawString("-  Part of g(t-Ï„) overlaps part of f(Ï„)", 63,480);
						}
						else{
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						
					}
					if((flagC==9)){
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
						g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
						if((option1 == 1)&&(option2 == 1)){
							g.drawString("-   Part of g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
						}else if((option1 == 2)&&(option2 == 2)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}else if((option1 == 3)&&(option2 == 1)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 3)&&(option2 == 2)){
							g.drawString("-  g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 3)&&(option2 == 3)){
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						else{
							g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
						}
						
					}
					
					if((flagC==10)||(flagC==11)){
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
						g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
						
						if((option1 == 1)&&(option2 == 2)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}else if((option1 == 1)&&(option2 == 3)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}else if((option1 == 2)&&(option2 == 1)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 2)&&(option2 == 2)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}else if((option1 == 2)&&(option2 == 3)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 3)&&(option2 == 1)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}else if((option1 == 3)&&(option2 == 2)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}else if((option1 == 3)&&(option2 == 3)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}
						else
							g.drawString("-  Two functions do not overlap ", 63,480);
					}
					if((flagC==12)||(flagC==13)){
						g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
						g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
						g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
						//g.drawString("-  Two functions do not overlap ", 63,480);
						if((option1 == 2)&&(option2 == 2)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 2)&&(option2 == 3)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 3)&&(option2 == 2)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}
						else if((option1 == 3)&&(option2 == 3)){
							g.drawString("-   g(t-Ï„) Partly overlaps f(Ï„) ", 63,480);
						}
						else
							g.drawString("-  Two functions do not overlap ", 63,480);
						
					}
					if(flagC==14){
						g.drawString(" Signal y(t) is shown", 63, 400);
						
						g.drawString("y(t) = f(t)*g(t)=", 63, 485);
						if((option1==1)&&(option2==1)){
							g.drawString("0              for t < 0", 735, 430);
							g.drawString("t               for 0 â‰¼ t< 1 ", 735, 460);
							g.drawString(" -t+2       for 1 â‰¼t â‰¤ 2", 735,485);
							g.drawString(" 0            for  t > 2", 735,515);
							
						}
						else if((option1==1)&&(option2==2)){
							g.drawString("0                for t < 0", 735, 430);
							g.drawString("-t               for 0 â‰¼ t< 1 ", 735, 460);
							g.drawString("2t-3          for 1 â‰¼t â‰¤ 2", 735,485);
							g.drawString("-t+3          for  2 â‰¼t < 3", 735,515);
							g.drawString(" 0               for t â‰½ 3",735,545);
							
						}
						else if((option1==1)&&(option2==3)){
							g.drawString("0              for t < 0", 735, 430);
							
							g.drawString("1-eâ�»           for 0 â‰¼ t< 1 ", 735, 460);
							g.drawString("t", 766,457);
							g.drawString(" eâ�»              for 1 â‰¼t â‰¤ 2", 735,485);
							g.drawString("t", 754,482);
							g.drawString("(e-1)", 759, 485);
							g.drawString(" 0            for  2 â‰¼t < 3", 735,515);
							g.drawString(" 0             for t â‰½ 3",735,545);
						}
						else{
						
							g.drawString("0              for t <-2", 735, 430);
							g.drawString("-t -2t          for -1 â‰¼ t< -1 ", 735, 460);
							g.drawString("â‚‚ ", 747, 453);
							g.drawString(" 1             for -1 â‰¼t < 2", 735,485);
							g.drawString(" t -6t+9    for 2 â‰¼t < 3", 735,515);
							g.drawString("â‚‚ ", 743, 505);
							g.drawString(" 0             for t â‰½ 3",735,545);
						}
						g.drawLine(724,408,724,556);
						g.drawLine(724,408,724+5,408);
						g.drawLine(724,556,724+5,556);
						
					}			*/
					System.out.println("End of Interaction");
					
					
				}	// END OF INTERACTION
				
			if(demo==true)
			{	
				clearPannel(g);
				Graphics2D g2d = (Graphics2D)g;
			    Color s1 = demo_color;
			    Color e = Color.white;
			    GradientPaint gradient = new GradientPaint(2,77,s1,7,550,e,true);
			    g2d.setPaint(gradient);
				g.fillRect(2,77,998,10);
				g.fillRect(2,77,10,500);
				g.fillRect(990,77,10,500);
				
				
				
				 
				g.setColor(demo_color_new);
				g.fillRect(12,87,980,40);
				g.setColor(Color.WHITE);
				g.setFont(new Font("Arial",Font.BOLD,20));
				g.drawString("Continuous Time Convolution",10,110 );
				
				g.setFont(new Font("Arial",Font.PLAIN,12));
				g.setColor(demo_color_new);	
				
				//g.drawLine(600,125,600,580);
				g.drawLine(400,125,400,580);
				// to display text or instructions
				g.setColor(demo_color_new);
				g.drawLine(600,360,989,360);
				
				// line seperater between three stages in left side
				//g.drawLine(10,275,599,275);// 1st divider
				//g.drawLine(10,425,599,425);// second divider
				
				g.setColor(Color.black);
				
				g.setFont(new Font("Arial",Font.BOLD,13));
				g.drawString("Explanation", 756,375);
				
				
				g.setFont(new Font("Arial",Font.PLAIN,12));
				
				Graphics2D ga = (Graphics2D)g;
				ga.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
				ga.setStroke(new BasicStroke(2));
				
					// start here right panel
				graphCounter=0;
				drawGraph(g,xaxpoints1R,xaypoints1R,yaxpoints1R,yaypoints1R);// graph 1 in right panel
				graphCounter=2;
				drawGraph(g,xaxpoints2R,xaypoints2R,yaxpoints2R,yaypoints2R);// graph 2 in right panel
				g.setColor(Color.red);// first signal
				ga.setStroke(new BasicStroke(2));
				GeneralPath polylineR = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
						xpoints2R.length);
				polylineR.moveTo (xpoints2R[0], ypoints2R[0]);
				for ( int index = 1; index < xpoints2R.length; index++ ) {
					polylineR.lineTo(xpoints2R[index], ypoints2R[index]);
				};
				ga.draw(polylineR);
				
				//g.drawLine(650,210, 675,235);
				g.setColor(Color.BLUE);// second signal
				GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
						xpoints1R.length);
				polyline.moveTo (xpoints1R[0], ypoints1R[0]);
				for ( int index = 1; index < xpoints1R.length; index++ ) {
					polyline.lineTo(xpoints1R[index], ypoints1R[index]);
				};
				ga.draw(polyline);
				ga.setStroke(new BasicStroke(1));
				g.setColor(Color.black);
				g.setFont(new Font("Arial",Font.BOLD,13));
				g.drawString("g(t)=-t+1",680,200);
				g.drawString("for 0â‰¤tâ‰¤1", 685, 185);
				g.drawString("f(t)=2",912,180);
				g.drawString("for -2â‰¤tâ‰¤2", 912, 165);
				// end right panel---------------------------------------------------------------------
				// start left panel 
				g.setColor(Color.LIGHT_GRAY);
				ga.setStroke(new BasicStroke(1));
				if(flagC >=2){
					graphCounter  = 7;
					/*xaxpoints2[0] = 35;
					xaxpoints2[1] = 540;*/
					xaxpoints2[0] = 440;
					xaxpoints2[1] = 950;
					drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);// graph 1 in left panel
				}else
				{
					graphCounter=2;
					System.out.println(" -----------------graphCounter = "+graphCounter);
					//graphCounter=5;
					drawGraph(g,xaxpoints1,xaypoints1,yaxpoints1,yaypoints1);// graph 1 in left panel
					//graphCounter=1;
					graphCounter=5;
					drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);// graph 2 in right panel
				}
				System.out.println("graphCounter = ============="+graphCounter);
				ga.setStroke(new BasicStroke(2));
				//graphCounter=6;
				//graphCounter=5;
				g.setColor(Color.BLUE);// second signal
				GeneralPath polylineL = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
						xpoints1.length);
				polylineL.moveTo (xpoints1[0], ypoints1[0]);
				for ( int index = 1; index < xpoints1.length; index++ ) {
					polylineL.lineTo(xpoints1[index], ypoints1[index]);
				};
				ga.draw(polylineL);
				// first signal
				g.setColor(Color.red);
				GeneralPath polylineL2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
						xpoints2.length);
				polylineL2.moveTo (xpoints2[0], ypoints2[0]);
				for ( int index = 1; index < xpoints2.length; index++ ) {
					polylineL2.lineTo(xpoints2[index], ypoints2[index]);
				};
				ga.draw(polylineL2);
				
				
				
				
				
				//ga.draw(new Line2D.Double(xpoints2[0], ypoints2[0],xpoints2[1], ypoints2[1]));
				ga.setStroke(new BasicStroke(1));
				
				//g.drawLine(35,315, 550, 315);
				//g.drawLine( 340,175,340,335);
				//g.setColor(Color.gray);
				
				
				
				//2nd row
				g.setColor(Color.LIGHT_GRAY);
				if(flagC >=2){
					graphCounter = 7;
				}else{
					graphCounter = 6;
				}
				drawGraph(g,xaxpoints21,xaypoints21,yaxpoints21,yaypoints21);
				g.setColor(Color.BLACK);
				g.setFont(new Font("Arial",Font.BOLD,14));
				
				//lbl_multSignal_image=new JLabel("");
				//lbl_multSignal_image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/multSignals.png")));
				lbl_multSignal_image.setBounds(50,295,88,26);
				lbl_multSignal_image.setVisible(true);
				//container1.add(lbl_multSignal_image);
				
				//3rd row
				graphCounter = 6;
				g.setColor(Color.LIGHT_GRAY);
				drawGraph(g,xaxpoints31,xaypoints31,yaxpoints31,yaypoints31);
				
				//lbl_integrateSignal_image=new JLabel("");
				//lbl_integrateSignal_image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/integrateSignals1.png")));
				lbl_integrateSignal_image.setBounds(50,430,187,51);
				lbl_integrateSignal_image.setVisible(true);
				//container1.add(lbl_integrateSignal_image);
				
				
				// end graph in 3rd row
				
				System.out.println("graphCounter = "+graphCounter);
				// draw area in second row
				g.setColor(Color.black);
				ga.setStroke(new BasicStroke(2));
				GeneralPath polylineArea = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
						xpointsArea.length);
				polylineArea.moveTo (xpointsArea[0], ypointsArea[0]);
				for ( int index = 1; index < xpointsArea.length; index++ ) {
					polylineArea.lineTo(xpointsArea[index], ypointsArea[index]);
				};
				ga.draw(polylineArea);
				
				xpointsIntegrate[0] = 305;
				ypointsIntegrate[0] = 500;
				
				
				for(int ic = 0;ic<counteri;ic++){
					ga.draw(new Line2D.Double(xpointsIntegrate[ic], ypointsIntegrate[ic],xpointsIntegrate[ic+1], ypointsIntegrate[ic+1]));
					ga.fill(new Ellipse2D.Double(xpointsCircle-5, ypointsCircle-5,10,10));
				}
				
				/*GeneralPath polylineIntegrate = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
						xpointsIntegrate.length);
				polylineIntegrate.moveTo (xpointsIntegrate[0], ypointsIntegrate[0]);
				for ( int index = 1; index < xpointsIntegrate.length; index++ ) {
					polylineIntegrate.lineTo(xpointsIntegrate[index], ypointsIntegrate[index]);
				};
				ga.draw(polylineIntegrate);
				*/
				
				
				ga.setStroke(new BasicStroke(1));
				// end left panel
							//drawTau(g,50,200);
							//ga.setStroke(new BasicStroke(1));	
				g.setColor(Color.black);
				g.setFont(new Font("Arial",Font.BOLD,12));
				//g.drawString("f(t)",390,145);
				if(flagC <=1){
					
					g.drawString("g(t)",160,100);
					g.drawString("f(t)",390,100);
					
					}
				 	
				else if(flagC <3){	
						g.setColor(Color.black);
						g.setFont(new Font("Arial",Font.BOLD,14));
						drawTau(g,185,136);
						g.drawString("g(-", 160,145);
						g.drawString(")", 195,145);
						g.drawString("f(", 390, 145);
						drawTau(g,405,136);
						g.drawString(")", 415, 145);
						
					}
				else if(flagC >=3){
					//graphCounter = 5;
					graphCounter = 7;
					drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);
					g.setColor(Color.black);
					g.setFont(new Font("Arial",Font.BOLD,14));
					drawTau(g,190,136);
					g.drawString("g(t-", 160,145);
					g.drawString(")", 200,145);
					g.drawString("f(", 390, 145);
					drawTau(g,405,136);
					g.drawString(")", 415, 145);
					g.drawString("t", (int)xpoints2[0]-10+ci, (int)ypoints2[0]+15);
					g.drawString("-1+t", (int)xpoints2[2]-35+ci, (int)ypoints2[2]+15);
					//System.out.println("graphCounter = "+graphCounter);
					
					
				}
				g.setFont(new Font("Arial",Font.PLAIN,14));
				if(flagC  == 0){
					g.drawString("-  f(t) and g(t) are the two continuous signals to ", 63,400);
					g.drawString("   be convolved.", 63,420);
					g.drawString("-  The convolution of the signals is denoted by " , 63,450);
					g.drawString("    y(t) = f(t)*g(t)    which means", 63,470);
					
					
					g.drawString("y(t) = âˆ«     f(Ï„)g(t-Ï„)dÏ„ ", 83, 500);
					g.drawString("â�»âˆž", 88, 510);
					g.drawString("â�ºâˆž", 88, 490);
					
				g.drawString("       where Ï„ is a dummy variable", 63, 530);
				
				}
				if((flagC ==1)||(flagC==2)){
					g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
					g.drawString("-  The reversed version of  g(Ï„)  i.e., g(-Ï„) is shown", 63,430);
					
				}
				if(flagC==3){
					g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
					g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
					g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
					g.drawString("-  Two functions do not overlap ", 63,480);
					g.drawString("-  Area under the product of the functions is zero ", 63,510);
				}
				if(flagC == 4){
					g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
					g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
					g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
					g.drawString("-  Two functions do not overlap ", 63,480);
					g.drawString("-  Area under the product of the functions is zero ", 63,510);
				}
				if(flagC == 5){
					
					g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
					g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
					g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
					g.drawString("-  Part of g(t-Ï„) overlaps part of  f(Ï„) ", 63,480);
					g.drawString("-  Area under the product  ", 63,510);
					g.drawString("   y(t) = âˆ«     2[-(t-Ï„)+1]dÏ„ ", 83, 535);
					g.drawString("â�»â‚‚", 705, 545);
					g.drawString("â�ºt", 705, 522);
					
				}
				if(flagC==6){
					g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
					g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
					g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
					g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
					g.drawString("-  Area under the product  ", 63,510);
					g.drawString("   y(t) = âˆ«     2[-(t-Ï„)+1]dÏ„ ", 83, 535);
					g.drawString("-â‚�â�ºt", 705, 545);
					g.drawString("â�ºt", 705, 522);
					
				}
				if((flagC==7)||(flagC==8)||(flagC==9)){
					g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
					g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
					g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
					g.drawString("-   g(t-Ï„) completely overlaps f(Ï„) ", 63,480);
					g.drawString("-  Area under the product  ", 63,510);
					g.drawString("   y(t) = âˆ«     2[-(t-Ï„)+1]dÏ„ ", 83, 535);
					g.drawString("-â‚�â�ºt", 705, 545);
					g.drawString("â‚‚", 705, 522);
				}
				if((flagC==10)||(flagC==11)){
					g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
					g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
					g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
					g.drawString("-   Part if g(t-Ï„) overlaps part of f(Ï„) ", 63,480);
					g.drawString("-  Area under the product  ", 63,510);
					g.drawString("   y(t) = âˆ«     2[-(t-Ï„)+1]dÏ„ ", 83, 535);
					g.drawString("-â‚�â�ºt", 705, 545);
					g.drawString("â‚‚", 705, 522);
				}
				if((flagC==12)||(flagC==13)){
					g.drawString("-  The  signal  f(Ï„)  is shown ", 63,400);
					g.drawString("-  The reversed and shifted version of g(-Ï„) ", 63,430);
					g.drawString("-   i.e., g(t-Ï„)   is shown", 63,450);
					g.drawString("-  Two functions do not overlap ", 63,480);
					g.drawString("-  Area under the product of the functions is zero ", 63,510);
				}
				if(flagC==14){
					g.drawString(" Signal y(t) is shown", 63, 400);
					
					g.drawString("y(t) = f(t)*g(t)=", 63, 485);
					g.drawString("0              for t <-2", 735, 430);
					g.drawString("-t-2t        for -1 â‰¼ t< -1 ", 735, 460);
					g.drawString("â‚‚ ", 745, 453);
					g.drawString(" 1             for -1 â‰¼t < 2", 735,485);
					g.drawString(" t-6t+9    for 2 â‰¼t < 3", 735,515);
					g.drawString("â‚‚ ", 743, 503);
					g.drawString(" 0             for t â‰½ 3",735,545);
					
					g.drawLine(724,408,724,556);
					g.drawLine(724,408,724+5,408);
					g.drawLine(724,556,724+5,556);
					
				}
					      	if (!clearScreen){
								//System.out.println(" inside repaint function------==-----");
								
							}
							else {
								System.out.println(" in clear ------------");
								g.setColor(Color.white);
								g.fillRect(12,347, 588,232);
								g.fillRect(602,361,387,218);
								
								// line seperater between three stages in left side
								g.drawLine(10,275,599,275);// 1st divider
								g.drawLine(10,425,599,425);// second divider
								
								g.setColor(Color.gray);
								
								
								//2nd row
								//g.drawLine(35,350,550,350);
								g.drawLine(455,350,970,350);
								//g.drawLine(355,285, 355,410 );
								g.drawLine(675,285, 675,410 );
								
								
								System.out.println("Holaaaaaaaaaaaaaaaaaaaaaaa");
								// 3rd row
								//g.drawLine(35,500,550,500);
								g.drawLine(455,500,970,500);
								//g.drawLine(355,435, 355,560 );
								g.drawLine(675,435, 675,560 );
								//clearScreen=false;
							}
			}//end of if demo
			
			}
			catch(Exception e)
			{
				
			}//end of catch
		}
		
	}

	

public void init()
	{
	//animator = null;
	System.out.println("INIT STARTED");
		d = getSize();
		container1 = new mypaint();
		container1.setBounds(0, 0, d.width, d.height);
		setContentPane(container1);
		//System.out.println(" in init()++++++++++++++");
		container1.setLayout(null);		
		// System.out.println(" in init()-----------------------------");
		// Glossary Tab ........START............
		
		TableModel tblLeftIndexModel = new DefaultTableModel(new String[][] {
				{ "Signal " }, { " Signal Transformation "  }, { " Shifting " },{" Delaying "},
				{ " Advancing " }, {"Scaling"}, {"Compression"},{"Expansion"},{"Reversal"} },
				new String[] { "Index Index Index" });
		
		tblLeftIndex_glossary = new JTable();
		tblLeftIndex_glossary.setModel(tblLeftIndexModel);
		tblLeftIndex_glossary.setBounds(125,200, 170, nAppRowHeight*tblLeftIndex_glossary.getRowCount());
		tblLeftIndex_glossary.setBackground(lightgrey);
		tblLeftIndex_glossary.setVisible(false);
		tblLeftIndex_glossary.setRowHeight(nAppRowHeight);
		tblLeftIndex_glossary.setForeground(Color.black);	
		//tblLeftIndex_glossary.sete	
		add(tblLeftIndex_glossary);	
		
		lblHeader_glossary = new JLabel();
		lblHeader_glossary.setText("Index");		
		add(lblHeader_glossary);
		lblHeader_glossary.setVisible(false);
		lblHeader_glossary.setBounds(tblLeftIndex_glossary.getBounds().x+4, tblLeftIndex_glossary.getBounds().y-25, 48, 22);
		
		lblMessage_glossary = new JLabel();
		lblMessage_glossary.setText("Choose a topic from left, the definition will appear on the right.");		
		add(lblMessage_glossary);
		lblMessage_glossary.setVisible(false);		
		lblMessage_glossary.setBounds(tblLeftIndex_glossary.getBounds().x+4, tblLeftIndex_glossary.getBounds().y-70, 500, 22);
		
		txtPaneDescription_glossary = new JTextPane();
		StyledDocument docglossary = txtPaneDescription_glossary.getStyledDocument();
		MutableAttributeSet standardglossary = new SimpleAttributeSet();
		StyleConstants.setAlignment(standardglossary, StyleConstants.ALIGN_RIGHT);
		StyleConstants.setLineSpacing(standardglossary, 2);
		add(txtPaneDescription_glossary);
		txtPaneDescription_glossary.setText("Select the keyword from the left menu list.");	
		txtPaneDescription_glossary.setBackground(lightgrey);
		txtPaneDescription_glossary.setForeground(Color.black);
		txtPaneDescription_glossary.setBounds(300, 200, 295,nAppRowHeight*tblLeftIndex_glossary.getRowCount());
		txtPaneDescription_glossary.setVisible(false);		
		
		tblLeftIndex_glossary.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent evt) {
				tblLeftIndexMouseClicked(evt);
			}
			public void mouseEntered(MouseEvent arg0) {	}
			public void mouseExited(MouseEvent arg0) { }
			public void mousePressed(MouseEvent arg0) {	}
			public void mouseReleased(MouseEvent arg0) { }
		});
		
		// Glossary Tab ........STOP............
		
		
		// Header.............START..........
		lbl_subject=new JLabel("Continuous Time Convolution ");
		lbl_subject.setBounds(260,5,600,28);
		lbl_subject.setForeground(Color.white);
		lbl_subject.setFont(new Font("Helvetica",Font.BOLD,25));
		container1.add(lbl_subject);
		
		lbl_topic=new JLabel(" Electrical Engineering > Signals and Systems");
		lbl_topic.setBounds(252,35,400,35);
		
		lbl_topic.setForeground(Color.white);
		lbl_topic.setFont(new Font("Helvetica",Font.BOLD,14));
		container1.add(lbl_topic);
		
		lbl_oscar_image=new JLabel("");
		lbl_oscar_image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/oscarlogo.png")));
		lbl_oscar_image.setBounds(5,5,250,75);
		container1.add(lbl_oscar_image);
		
	//	System.out.println(" in init()  before label1------------------");
		
		// Header.............STOP..........
		
		// Different Tabs ...........START.................
		//im_home=new ImageIcon(getClass().getClassLoader().getResource("images/home.png"));
		im_home=new ImageIcon(getClass().getClassLoader().getResource("images/1_home.png"));
		but_home = new JButton("");
		//but_home.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/home.png")));
		but_home.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/1_home.png")));
		but_home.setFont(new Font("",Font.PLAIN,13));
		but_home.setBackground(new_head_color);//(yellow);	
		
		but_home.setBounds(650,37,50,40);
		but_home.setToolTipText("Home");
		 but_home.setBorderPainted(false);
		container1.add(but_home);
		but_home.addActionListener(this);
		
		//im_theory=new ImageIcon(getClass().getClassLoader().getResource("images/theory.png"));	
		im_theory=new ImageIcon(getClass().getClassLoader().getResource("images/5_Theory.png"));	
		but_Theory=new JButton(im_theory);
		but_Theory.setFont(new Font("",Font.PLAIN,13));
		but_Theory.setForeground(Color.white);
		
		but_Theory.setBounds(700,37,50,40);
		but_Theory.setToolTipText("Click Here To View the Theory.");
		container1.add(but_Theory);
		but_Theory.addActionListener(this);
		
		
		im_demo=new ImageIcon(getClass().getClassLoader().getResource("images/2_demo.png"));
		but_Demo=new JButton(im_demo);
		but_Demo.setFont(new Font("",Font.PLAIN,13));
		but_Demo.setForeground(grey);
		but_Demo.setBackground(Color.white);
		
		but_Demo.setBounds(750,37,50,40);
		but_Demo.setToolTipText("Click Here To View the Demo.");
		container1.add(but_Demo);
		but_Demo.addActionListener(this);
		
		im_interaction=new ImageIcon(getClass().getClassLoader().getResource("images/3_interactivity.png"));
		but_Interaction=new JButton(im_interaction);
		but_Interaction.setFont(new Font("",Font.PLAIN,13));
		but_Interaction.setForeground(grey);		
		
		but_Interaction.setBounds(800,37,50,40);
		but_Interaction.setToolTipText("Click Here To interact.");
		container1.add(but_Interaction);
		but_Interaction.addActionListener(this);
	
		/*im_analogy=new ImageIcon(getClass().getClassLoader().getResource("images/analogy.png"));
		but_Analogy=new JButton(im_analogy);
		but_Analogy.setFont(new Font("",Font.PLAIN,13));
		but_Analogy.setForeground(grey);		
		but_Analogy.setBounds(750,37,50,40);
		but_Analogy.setToolTipText("Click Here To view Analogy");
		container1.add(but_Analogy);
		but_Analogy.addActionListener(this);
		*/
	/*	im_glossary=new ImageIcon(getClass().getClassLoader().getResource("images/6_Glossary.png"));
		but_Glossary=new JButton(im_glossary);
		but_Glossary.setFont(new Font("",Font.PLAIN,13));
		but_Glossary.setForeground(grey);
		//but_Glossary.setBackground(Color.white);
		but_Glossary.setBounds(800,37,50,40);
		but_Glossary.setToolTipText("Click Here To view Definitions.");		
		container1.add(but_Glossary);
		but_Glossary.addActionListener(this);
*/
		im_exercise=new ImageIcon(getClass().getClassLoader().getResource("images/7_Quiz.png"));
		but_Exercise=new JButton(im_exercise);
		but_Exercise.setFont(new Font("",Font.PLAIN,13));
		but_Exercise.setForeground(grey);
		but_Exercise.setBackground(Color.white);	
		but_Exercise.setBounds(850,37,50,40);
		but_Exercise.setToolTipText("Click Here To view Questionare");
		container1.add(but_Exercise);
		but_Exercise.addActionListener(this);

		im_reference=new ImageIcon(getClass().getClassLoader().getResource("images/8_Reference.png"));
		but_Links=new JButton(im_reference);
		but_Links.setFont(new Font("",Font.PLAIN,13));
		but_Links.setForeground(grey);
		but_Links.setBackground(Color.white);
		but_Links.setBounds(900,37,50,40);
		but_Links.setToolTipText("Click Here To view Links for further Reading");		
		container1.add(but_Links);
		but_Links.addActionListener(this);

		im_help=new ImageIcon(getClass().getClassLoader().getResource("images/9_Help.png"));
		but_Help=new JButton(im_help);
		but_Help.setFont(new Font("",Font.PLAIN,13));
		but_Help.setForeground(grey);	
		but_Help.setBackground(Color.white);
		but_Help.setBounds(950,37,50,40);
		but_Help.setToolTipText("Click Here To view Help");
		container1.add(but_Help);
		but_Help.addActionListener(this);
		
		addMouseListener(this);

		// Different Tabs ...........STOP.................
		
		//im_credits=new ImageIcon(getClass().getClassLoader().getResource("images/credits.jpg"));
		im_credits=new ImageIcon(getClass().getClassLoader().getResource("images/10_Credits.png"));
		but_credits=new JButton(im_credits);
		but_credits.setFont(new Font("",Font.PLAIN,13));
		but_credits.setForeground(grey);
		//but_credits.setBackground(color8);
		but_credits.setBounds(935,580,63,20);
		but_credits.setToolTipText("Click Here To view author,mentor");
		container1.add(but_credits);
		but_credits.addActionListener(this);
		
		// For DemoTab ............START.............		
	/*	im_pause=new ImageIcon("images/pause.jpg");
		but_Pause=new JButton(im_pause);
		but_Pause.setFont(new Font("",Font.PLAIN,13));
		but_Pause.setForeground(Color.white);		
		but_Pause.setBounds(674,130,30,25);
		but_Pause.setToolTipText("Click Here To pause the Demo");
		but_Pause.setVisible(false);
		container1.add(but_Pause);
		but_Pause.addActionListener(this);
		*/
		
		im_pause=new ImageIcon(getClass().getClassLoader().getResource("images/pause.png"));
		im_reset=new ImageIcon(getClass().getClassLoader().getResource("images/reset_button.png"));
		im_play=new ImageIcon(getClass().getClassLoader().getResource("images/play_button.png"));
		/*im_play=new ImageIcon("images/play.jpg");
		but_Resume=new JButton(im_play);
		but_Resume.setFont(new Font("",Font.PLAIN,13));
		but_Resume.setForeground(Color.white);
		but_Resume.setBackground(color10);
		but_Resume.setBounds(674,130,30,25);
		but_Resume.setToolTipText("Click Here To Resume the Demo");
		but_Resume.setVisible(false);
		container1.add(but_Resume);
		but_Resume.addActionListener(this);
		*/
		
	
		// For DemoTab ............STOP.............
		
		// Opening Screen .....START .........
		/*opening_screen=new JTextPane();		
		opening_screen.setFont(new Font("Monospaced",Font.PLAIN,16));
		opening_screen.setForeground(grey);		
		opening_screen.setBounds(180,280,700,100);		
		opening_screen.setVisible(true);
		opening_screen.setText("Details of Stop And Wait ARQ:;;  ");
		container1.add(opening_screen);*/
		
		//blhome = true;
		
		lbl_opening_screen_left = new JPanel() ;
		//lbl_opening_screen_left.setBounds(30, 125, 470, 315);
		lbl_opening_screen_left.setBounds(30, 150, 400, 200);
        lbl_opening_screen_left.setVisible(true);
        container1.add(lbl_opening_screen_left);
        
        // put image
        ImageIcon image_home = new ImageIcon(getClass().getClassLoader().getResource("images/signal_home.png"));// change the image
		JLabel home_image1 = new JLabel(image_home);
		//home_image1.setBounds(30,150,300,230);
		home_image1.setBounds(30,150,370,171);
		lbl_opening_screen_left.add(home_image1);
        
		
		opening_screen_message=new JTextPane();
		opening_screen_message.setFont(new Font("Arial", Font.PLAIN, 12));
		opening_screen_message.setForeground(Color.darkGray);
		opening_screen_message.setBackground(highlight);
		
		opening_screen_message.setBounds(30,100,600,20);
		opening_screen_message.setVisible(true);
		opening_screen_message.setText("Click on the Icons on the top right corner to go to the relevent" +
				" section of the learning Object(LO).");
		
		
		container1.add(opening_screen_message);
		
		
		opening_screen=new JTextPane();	
		
		
		opening_screen.setBounds(480, 150, 470, 100);
        opening_screen.setVisible(true);
        opening_screen.setFont(new Font("Arial", Font.PLAIN, 13));
        opening_screen.setEditable(false);
        opening_screen.setBorder(null);
       	opening_screen.setForeground(Color.BLACK);
		
		StyledDocument doc_open = opening_screen.getStyledDocument();
		MutableAttributeSet standard_open = new SimpleAttributeSet();
		StyleConstants.setAlignment(standard_open, StyleConstants.ALIGN_JUSTIFIED);	
		//StyleConstants.setFontSize(standard_open, 18);
		//StyleConstants.setForeground(standard_open,Color.BLACK);
		//StyleConstants.setFontFamily(standard_open, "Arial");
		//doc_open.setParagraphAttributes(0, 0, standard_open, true);
		//opening_screen.setFont(new Font("",Font.PLAIN,12));
		//opening_screen.setForeground(Color.black);		
		//opening_screen.setBounds(100,200,700,200);		
		//opening_screen.setVisible(true);
		opening_screen.setText("In this animation, the continuous time convolution of signals is discussed. Convolution is the" +
				" operation to obtain response of a linear system to input x(t). The output y(t) is given as a weighted " +
				"superposition of impulse responses, time shifted by Ï„.");
		container1.add(opening_screen);
		
		lbl_openingscreen=new JLabel("Learning Objectives ");
		//lbl_openingscreen.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/home.png")));
		lbl_openingscreen.setBounds(480,230,470,50);
		lbl_openingscreen.setFont(new Font("",Font.BOLD,14));
		lbl_openingscreen.setForeground(Color.BLACK);
		container1.add(lbl_openingscreen);
		lbl_openingscreen.setVisible(true);
		
		
		opening_screen1=new JTextPane();	
		
		
		opening_screen1.setBounds(480, 280, 470, 100);
        opening_screen1.setVisible(true);
        opening_screen1.setFont(new Font("Arial", Font.PLAIN, 13));
        opening_screen1.setEditable(false);
        opening_screen1.setBorder(null);
       	opening_screen1.setForeground(Color.BLACK);
       	
       	opening_screen1.setText("After interacting with this Learning Object, the learner will be able to:\n\n"+
				" - Explain the convolution of two continuous time signals.");
       	container1.add(opening_screen1);
       	
		opening_screen_logo = new JPanel();  
		opening_screen_logo.setLayout(null);		
		opening_screen_logo.setVisible(true);
		opening_screen_logo.setBackground(Color.LIGHT_GRAY);
		opening_screen_logo.setBounds(2,450,998,130);
		add(opening_screen_logo);
		
		JLabel by = new JLabel("Sponsored by :");
		by.setBounds(5, 1, 120, 25);
		by.setFont(new Font("",Font.BOLD,14));
		by.setForeground(Color.BLACK);
		opening_screen_logo.add(by);
		
		JLabel at = new JLabel("Developed by :");
		at.setBounds(865, 1, 120, 25);
		at.setFont(new Font("",Font.BOLD,14));
		at.setForeground(Color.BLACK);
		opening_screen_logo.add(at);
		
		//im_mhrd = new ImageIcon("images/mhrd.png");
		JLabel mhrd=new JLabel("");
		mhrd.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/mhrd.png")));
		mhrd.setBounds(5, 27, 97, 97);		
		opening_screen_logo.add(mhrd);
		
		//im_iit = new ImageIcon("images/iit.png");
		JLabel iit=new JLabel("");
		iit.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/iitb.png")));
		iit.setBounds(865, 27, 97, 97);
		opening_screen_logo.add(iit);

		// testing.............................
	//	ImageIcon image_sigma = new ImageIcon(getClass().getClassLoader().getResource("images/sigma2.png"));// change the image
	//	demo_image1 = new JLabel(image_sigma);
	//	demo_image1.setBounds(730,340,300,250);
	//	container1.add(demo_image1);
		
		//demo_image1.setVisible(true);
		// end testing............................
		
		
		// Opening Screen .....STOP.........		
		
		
		/*fr_credits = new JFrame("Credits : Stop And Wait ARQ");
		fr_credits.setBounds(6,92,400,400);
		fr_credits.setBackground(color8);
		fr_credits.getContentPane().setLayout(null);
		
		txtPane_credits=new JTextPane();	
		txtPane_credits.setText("\n\n\n\n\tAuthor        :  Aruna Adil\n\n\tMentor        :  Prof.Saravanan Vijayakumaran\n\n\tDeveloper  :  Aruna Adil\n\n\tDesigner    :  Amita Shinde");
		txtPane_credits.setBounds(20,30,350,300);		
		txtPane_credits.setBackground(color8);	
		txtPane_credits.setForeground(orange1);
		txtPane_credits.setEditable(false);
		fr_credits.getContentPane().add(txtPane_credits);	
		*/
		
		fr_credits = new JFrame("Credits : ");
		fr_credits.setBounds(12,87,500,400);
		//fr_credits.setBackground(color8);
		fr_credits.getContentPane().setLayout(null);
		
		txtPane_credits=new JTextPane();
		
		
		txtPane_credits.setFont(new Font("",Font.PLAIN,15));
		txtPane_credits.setText("\nWe would like to thank IIT Bombay, MHRD and following people for their contribution in "
								 +"creating this Learning Object (LO).\n\n\tAuthor        :  Phani Swathi Chitta\n\n\tMentor        :  Prof. Saravanan Vijayakumaran\n\n\tDeveloper    :  Aruna Adil\n\n\tDesigner     :  Sameer S Sahasrabudhe ");
		txtPane_credits.setBounds(10,20,450,250);		
		txtPane_credits.setBackground(Color.WHITE);	
		txtPane_credits.setForeground(Color.BLACK);
		txtPane_credits.setVisible(false);
		txtPane_credits.setEditable(false);
		fr_credits.getContentPane().add(txtPane_credits);	
		//container1.add(txtPane_credits);
		
		StyledDocument doc_credit = txtPane_credits.getStyledDocument();
		
		Style style_bold = txtPane_credits.addStyle("iitb", null);		
		StyleConstants.setForeground(style_bold, new Color(0xA31717));
		StyleConstants.setBold(style_bold,true);
		doc_credit.setCharacterAttributes(24, 16, txtPane_credits.getStyle("iitb"), true);
		
		Style style_color = txtPane_credits.addStyle("color", null);
		StyleConstants.setBold(style_color,true);
		StyleConstants.setForeground(style_color, new Color(0xA31717));
		doc_credit.setCharacterAttributes(142, 20, txtPane_credits.getStyle("color"), true);
		doc_credit.setCharacterAttributes(181, 30, txtPane_credits.getStyle("color"), true);
		doc_credit.setCharacterAttributes(228, 15, txtPane_credits.getStyle("color"), true);
		doc_credit.setCharacterAttributes(257, 27, txtPane_credits.getStyle("color"), true);
		
		
		
		
		//For DemoExplanation
		txtPane_explanation=new JTextPane();
		StyledDocument doc = txtPane_explanation.getStyledDocument();
		MutableAttributeSet standard = new SimpleAttributeSet();
		StyleConstants.setAlignment(standard, StyleConstants.ALIGN_JUSTIFIED);		
		doc.setParagraphAttributes(0, 0, standard, true);	
		MutableAttributeSet TLB = new SimpleAttributeSet();
		StyleConstants.setForeground(TLB, Color.red);
		StyleConstants.setItalic(TLB, true);
		//txtPane_explanation.setBounds(750,200,230,300);			
		txtPane_explanation.setVisible(false);
		txtPane_explanation.setEditable(false);
		container1.add(txtPane_explanation);
		
		//For Interaction Explanation
		txtPane_interaction=new JTextPane();
		StyledDocument docinteraction = txtPane_interaction.getStyledDocument();
		MutableAttributeSet standardinteraction = new SimpleAttributeSet();
		StyleConstants.setAlignment(standardinteraction, StyleConstants.ALIGN_JUSTIFIED);
		StyleConstants.setForeground(standardinteraction, grey);
		docinteraction.setParagraphAttributes(0, 0, standard, true);	
		MutableAttributeSet TLBinteraction = new SimpleAttributeSet();
		StyleConstants.setForeground(TLB, Color.red);
		StyleConstants.setItalic(TLBinteraction, true);
		//txtPane_interaction.setBounds(700,200,280,350);	
		txtPane_interaction.setText("For Interaction Explanation");
		txtPane_interaction.setVisible(false);
		txtPane_interaction.setEditable(false);
		container1.add(txtPane_interaction);
		
		//For Theory Explanation
		txtPane_theory=new JTextPane();
		StyledDocument doctheory = txtPane_theory.getStyledDocument();
		MutableAttributeSet standardtheory = new SimpleAttributeSet();
		StyleConstants.setAlignment(standardtheory, StyleConstants.ALIGN_JUSTIFIED);		
		doctheory.setParagraphAttributes(0, 0, standardtheory, true);
		txtPane_theory.setBounds(475,220,400,300);	
		txtPane_theory.setText("For Theory Explanation");
		txtPane_theory.setVisible(false);
		txtPane_theory.setEditable(false);
		container1.add(txtPane_theory);	
		
		//For Analogy explanation
		txtPane_Analogy=new JTextPane();
		StyledDocument docAnalogy = txtPane_Analogy.getStyledDocument();
		Style style = txtPane_Analogy.addStyle("Red", null); 
		StyleConstants.setForeground(style, Color.red); 		
		MutableAttributeSet standard8 = new SimpleAttributeSet();
		MutableAttributeSet keyWord8 = new SimpleAttributeSet();
		StyleConstants.setForeground(keyWord8, Color.red);
		docAnalogy = txtPane_Analogy.getStyledDocument();		             
		docAnalogy.setCharacterAttributes(3,14,keyWord8, true);
		docAnalogy.setCharacterAttributes(5, 2, txtPane_Analogy.getStyle("Red"), true); 				
		txtPane_Analogy.setBounds(550,210,350,260);		
		txtPane_Analogy.setText("For Analogy explanation");
		txtPane_Analogy.setVisible(false);
		txtPane_Analogy.setEditable(false);
		container1.add(txtPane_Analogy);	
		
		//For Demo Tab

		//Further Reading ............START...........
		but_go_links = new JButton("http://en.wikipedia.org/wiki/virtual _ memory");
		but_go_links.setBounds(150,160,350,30);		
		but_go_links.addActionListener(this);		
		add(but_go_links);
		but_go_links.setVisible(false);
		
		but_go1_links = new JButton("http://en.wikipedia.org/wiki/Page_table");
		but_go1_links.setBounds(150,210,350,30);		
		but_go1_links.addActionListener(this);		
		add(but_go1_links);
		but_go1_links.setVisible(false);
		
		/*
		fr_links_Message = new JLabel("Click below for further reading : ");
		fr_links_Message.setBounds(130,100,350,30);
		fr_links_Message.setBackground(color12);		
		add(fr_links_Message);
		fr_links_Message.setVisible(false);
		*/
		fr_links_Message = new JLabel("References");
		fr_links_Message.setBounds(130,150,350,30);
		fr_links_Message.setForeground(links_color);
		fr_links_Message.setFont(new Font("",Font.BOLD,30));
		add(fr_links_Message);
		fr_links_Message.setVisible(false);
		
		fr_links_Message1 = new JLabel("Books:");
		fr_links_Message1.setBounds(130,190,350,30);
		fr_links_Message1.setForeground(Color.BLACK);
		fr_links_Message1.setFont(new Font("",Font.BOLD,20));
		add(fr_links_Message1);
		fr_links_Message1.setVisible(false);
		
		txtPane_ref = new JTextPane();
		txtPane_ref.setBounds(130,230,600,200);			
		txtPane_ref.setVisible(false);
		txtPane_ref.setEditable(false);
		container1.add(txtPane_ref);
		
		txtPane_ref.setFont(new Font("",Font.PLAIN,15));
		txtPane_ref.setText("1. Signals & Systems â€“ Alan V. Oppenheim, Alan S. Willsky, S. Hamid Nawab, PHI learning, Second edition." +
				"\n\n2. Signals and Systems â€“ Simon Haykin, Barry Van Veen, John Wiley & Sons, Inc. ");
		
		paneltemp = new JPanel();
		paneltemp.setLayout(null);
		add(paneltemp);
		paneltemp.setVisible(false);
		paneltemp.setBackground(Color.white);
		paneltemp.setBounds(40,90,63,55);
		
		
		panel1=new JPanel();			
		panel1.setLayout(null);		
		add(panel1);
		panel1.setVisible(false);
		panel1.setBounds(40,145,63,370);		
		
		panel2=new JPanel(); 
		panel2.setLayout(null);		
		add(panel2);
		panel2.setVisible(false);		
		panel2.setBounds(40,145,63,370);
		
		panel3=new JPanel();  
		panel3.setLayout(null);		
		add(panel3);
		panel3.setVisible(false);		
		panel3.setBounds(40,145,63,370);
		
		panel4=new JPanel();  
		panel4.setLayout(null);		
		add(panel4);
		panel4.setVisible(false);		
		panel4.setBounds(40,145,63,370);
		
		panel5=new JPanel();  
		panel5.setLayout(null);		
		add(panel5);
		panel5.setVisible(false);		
		panel5.setBounds(40,145,63,370);
		
		fr_exercise_Message=new JLabel("Check your understanding :  ");
		fr_exercise_Message.setBounds(5,5, 230, 15);		
		paneltemp.add(fr_exercise_Message);
		fr_exercise_Message.setVisible(false);
		
		fr_exercise_Message1=new JLabel("Click buttons 1,2...5 to view questions ");
		fr_exercise_Message1.setBounds(5,25, 275, 15);
		fr_exercise_Message1.setFont(new Font("",Font.PLAIN,12));		
		paneltemp.add(fr_exercise_Message1);
		fr_exercise_Message1.setVisible(false);
		
		fr_exercise_but1=new JButton("1");
		fr_exercise_but1.setBounds(300,15,42,20);			
		paneltemp.add(fr_exercise_but1);
		fr_exercise_but1.setVisible(false);
		fr_exercise_but1.setBackground(lightgrey);
		fr_exercise_but1.addActionListener(this);
		
		fr_exercise_but2=new JButton("2");
		fr_exercise_but2.setBounds(342,15,42,20);		
		paneltemp.add(fr_exercise_but2);
		fr_exercise_but2.addActionListener(this);
		fr_exercise_but2.setBackground(lightgrey);
		fr_exercise_but2.setVisible(false);
		
		fr_exercise_but3=new JButton("3");
		fr_exercise_but3.setBounds(384,15,42,20);		
		paneltemp.add(fr_exercise_but3);
		fr_exercise_but3.addActionListener(this);
		fr_exercise_but3.setBackground(lightgrey);
		fr_exercise_but3.setVisible(false);
		
		fr_exercise_but4=new JButton("4");
		fr_exercise_but4.setBounds(426,15,42,20);		
		paneltemp.add(fr_exercise_but4);
		fr_exercise_but4.addActionListener(this);
		fr_exercise_but4.setBackground(lightgrey);
		fr_exercise_but4.setVisible(false);
		
		fr_exercise_but5=new JButton("5");
		fr_exercise_but5.setBounds(468,15,42,20);		
		paneltemp.add(fr_exercise_but5);
		fr_exercise_but5.addActionListener(this);
		fr_exercise_but5.setBackground(lightgrey);
		fr_exercise_but5.setVisible(false);

		txtPane_Exercise1=new JTextPane();				
		txtPane_Exercise1.setBounds(20,30,550,40);		
		txtPane_Exercise1.setVisible(true);
		txtPane_Exercise1.setText("1.  If the unit-impulse response of an LTI system and the input signal both are rectangular pulses, then the output will be a  ");		
		panel1.add(txtPane_Exercise1);
		
		/*ImageIcon que_1 = new ImageIcon(getClass().getClassLoader().getResource("images/que_con.png"));
		JLabel que_image1 = new JLabel(que_1);
		que_image1.setBounds(20, 20, 500, 170);
		panel1.add(que_image1);
		
		ImageIcon que_1_ans = new ImageIcon(getClass().getClassLoader().getResource("images/ans1.png"));
		JLabel que_image1_ans = new JLabel(que_1_ans);
		que_image1_ans.setBounds(5, 170, 600, 160);
		panel1.add(que_image1_ans);
		 */
		
		txtPane_Exercise2=new JTextPane();				
		txtPane_Exercise2.setBounds(20,10,550,40);		
		txtPane_Exercise2.setVisible(true);		
		txtPane_Exercise2.setText("2. Find Convolution");
		panel2.add(txtPane_Exercise2);
		
		ImageIcon que_2 = new ImageIcon(getClass().getClassLoader().getResource("images/que2.png"));
		JLabel que_image2 = new JLabel(que_2);
		que_image2.setBounds(120, 53, 272, 116);
		panel2.add(que_image2);
		
		ImageIcon que_2_ans = new ImageIcon(getClass().getClassLoader().getResource("images/que2_ans.png"));
		JLabel que_image2_ans = new JLabel(que_2_ans);
		que_image2_ans.setBounds(80, 190, 375, 121);
		panel2.add(que_image2_ans);
		
		
		txtPane_Exercise3=new JTextPane();				
		txtPane_Exercise3.setBounds(20,20,550,40);		
		txtPane_Exercise3.setVisible(true);		
		txtPane_Exercise3.setText("3. If impulse response and input signal both are unit step responses, then the output will be");
		panel3.add(txtPane_Exercise3);
		
		ImageIcon que_3 = new ImageIcon(getClass().getClassLoader().getResource("images/que3.png"));
		JLabel que_image3 = new JLabel(que_3);
		que_image3.setBounds(120, 63, 360, 102);
		panel3.add(que_image3);
		
		/*ImageIcon que_3_ans = new ImageIcon(getClass().getClassLoader().getResource("images/ans3.png"));
		JLabel que_image3_ans = new JLabel(que_3_ans);
		que_image3_ans.setBounds(5, 180, 600, 150);
		panel3.add(que_image3_ans);
		 */
		
		txtPane_Exercise4=new JTextPane();				
		txtPane_Exercise4.setBounds(20,10,550,20);		
		txtPane_Exercise4.setVisible(true);		
		txtPane_Exercise4.setText("4.  The convolution integral is given by");
		panel4.add(txtPane_Exercise4);
		
		ImageIcon que_4 = new ImageIcon(getClass().getClassLoader().getResource("images/que4.png"));
		JLabel que_image4 = new JLabel(que_4);
		que_image4.setBounds(30, 35, 530, 109);
		panel4.add(que_image4);


		/*ImageIcon que_4_ans = new ImageIcon(getClass().getClassLoader().getResource("images/ans4.png"));
		JLabel que_image4_ans = new JLabel(que_4_ans);
		que_image4_ans.setBounds(5, 180, 600, 160);
		panel4.add(que_image4_ans);

		*/
		txtPane_Exercise5=new JTextPane();				
		txtPane_Exercise5.setBounds(20,30,550,40);		
		txtPane_Exercise5.setVisible(true);		
		txtPane_Exercise5.setText("5. If h(t) is a unit-step function and x(t) is a unit-ramp function, then the output y(t) will be a");
		panel5.add(txtPane_Exercise5);
		
		/*ImageIcon que_5 = new ImageIcon(getClass().getClassLoader().getResource("images/que5_con.png"));
		JLabel que_image5 = new JLabel(que_5);
		que_image5.setBounds(20, 5, 550, 230);
		panel5.add(que_image5);
		
		ImageIcon que_5_ans = new ImageIcon(getClass().getClassLoader().getResource("images/ans5.png"));
		JLabel que_image5_ans = new JLabel(que_5_ans);
		que_image5_ans.setBounds(5, 180, 600, 160);
		panel5.add(que_image5_ans);
	*/
		q11 = new JRadioButton("a.  Rectangular pulse");		
		q11.setBounds(25, 130, 200, 20);
		q11.addItemListener(this);
		
		q12 = new JRadioButton("b.  Triangular pulse");			
		q12.setBounds(25, 170, 200, 20);
		q12.addItemListener(this);
		
		q13 = new JRadioButton("c.  Ramp function ");		
		q13.setBounds(25, 210, 200, 20);		
		q13.addItemListener(this);
		
		q14 = new JRadioButton("d.  None of the above");		
		q14.setBounds(25, 250, 200, 20);		
		q14.addItemListener(this);
		
		
		q1 = new ButtonGroup();
		q1.add(q11);
		q1.add(q12);
		q1.add(q13);
		q1.add(q14);
		panel1.add(q11);
		panel1.add(q12);
		panel1.add(q13);
		panel1.add(q14);
		
		q21 = new JRadioButton("1.  a ");		
		q21.setBounds(50, 330, 100, 20);
		q21.addItemListener(this);		
		
		
		q22 = new JRadioButton("2.  b");		
		q22.setBounds(150, 330, 100, 20);		
		q22.addItemListener(this);
		
		//q23 = new JRadioButton("3.  a and b");		
		//q23.setBounds(220, 330, 100, 20);		
		//q23.addItemListener(this);
		
		
		//q24 = new JRadioButton("4. either a or b");		
		//q24.setBounds(225, 330, 120, 20);		
		//q24.addItemListener(this);
		
		
		q2 = new ButtonGroup();
		q2.add(q21);
		q2.add(q22);
		//q2.add(q23);
		//q2.add(q24);
		panel2.add(q21);
		panel2.add(q22);
		//panel2.add(q23);
		//panel2.add(q24);
		
		q31 = new JRadioButton("a.  Triangular pulse");		
		q31.setBounds(25, 200, 200, 20);
		q31.addItemListener(this);
		
		q32 = new JRadioButton("b.  Unit step function");		
		q32.setBounds(25, 240, 200, 20);
		q32.addItemListener(this);		
		
		q33 = new JRadioButton("c.  Ramp function");	
		q33.setBounds(25, 280, 200, 20);
		q33.addItemListener(this);	
		
		q34 = new JRadioButton("d.  None of the above");	
		q34.setBounds(25, 320, 200, 20);
		q34.addItemListener(this);
		
		q3 = new ButtonGroup();
		q3.add(q31);
		q3.add(q32);
		q3.add(q33);
		q3.add(q34);
		
		panel3.add(q31);
		panel3.add(q32);
		panel3.add(q33);
		panel3.add(q34);
		
		q41 = new JRadioButton("a.  i )");		
		q41.setBounds(25, 200, 200, 20);
		q41.addItemListener(this);
		
		q42 = new JRadioButton("b.  ii )");		
		q42.setBounds(25, 240, 200, 20);
		q42.addItemListener(this);		
		
		q43 = new JRadioButton("c.  Both i ) and ii )");	
		q43.setBounds(25, 280, 200, 20);
		q43.addItemListener(this);
		
		q44 = new JRadioButton("d.  Either i ) or ii )");	
		q44.setBounds(25, 320, 200, 20);
		q44.addItemListener(this);
		
		q4 = new ButtonGroup();
		q4.add(q41);
		q4.add(q42);
		q4.add(q43);
		q4.add(q44);
		
		panel4.add(q41);
		panel4.add(q42);
		panel4.add(q43);
		panel4.add(q44);
		
		q51 = new JRadioButton("a.  Step function");		
		q51.setBounds(25, 130, 200, 20);
		q51.addItemListener(this);
		
		q52 = new JRadioButton("b.  Ramp function");		
		q52.setBounds(25, 170, 200, 20);
		q52.addItemListener(this);		
		
		q53 = new JRadioButton("c.   Triangular pulse");	
		q53.setBounds(25, 210, 200, 20);
		q53.addItemListener(this);	
		
		q54 = new JRadioButton("d.  Quadratic functionâ€�");	
		q54.setBounds(25, 250, 200, 20);
		q54.addItemListener(this);	

		q5 = new ButtonGroup();
		q5.add(q51);
		q5.add(q52);
		q5.add(q53);
		q5.add(q54);
		
		panel5.add(q51);
		panel5.add(q52);
		panel5.add(q53);
		panel5.add(q54);
		
		fr_exercise_answer=new JTextPane();
		fr_exercise_answer.setText("");
		fr_exercise_answer.setBounds(40,400,63,50);		
		add(fr_exercise_answer);
		fr_exercise_answer.setVisible(false);
		
		TitledBorder Answer = BorderFactory.createTitledBorder(line_border, "Answer");		
		fr_exercise_answer=new JTextPane();
		fr_exercise_answer.setText("");
		fr_exercise_answer.setBounds(40,520,63,50);
		fr_exercise_answer.setBackground(Color.white);
		fr_exercise_answer.setBorder(Answer);
		//fr_exercise_answer.setFont(new Font("",Font.BOLD,15));
		fr_exercise_answer.setLayout(new BoxLayout(fr_exercise_answer, BoxLayout.Y_AXIS));
		add(fr_exercise_answer);
		fr_exercise_answer.setVisible(false);
		fr_exercise_answer.setEditable(false);
		
		// *****************************   EXERCISE STOP ***************************

		//Help............START.......	
		//Object data_help[][]={{im_demo," This will give a demonstartion of different cases in Stop And Wait ARQ."},{im_play," This will Play the animation."},{im_pause," This will Pause the animation."},{im_glossary," This will display the terms and definitions related to ARQ."},{im_exercise," User can check their understanding by going through questionare"},{im_reference," User will get some links and books related to the topic."},{im_home," This Button will take user to the Home Page."}};
		//DefaultTableModel model_help = new DefaultTableModel(data_help,colnames_help);
		
		Object data_help[][]={{im_theory," This button will take the user to the 'Theory' section of the Learning Object(LO)."},{im_demo," This button will take the user to the 'Demo' section of the Learning Object(LO)."},{im_play," This button will Play Demo/Interaction."},{im_reset," This button will Reset Demo/Interaction."},{im_pause," This button will Pause the Demo/Interaction."},{im_interaction," This button will take the user to the 'Interaction' section of the Learning Object(LO)."},{im_exercise," This button will take the user to the 'Quiz' section of the Learning Object(LO)."},{im_reference," This button will take the user to the 'References' section of the Learning Object(LO) that contains the referances about the concept."},{im_home," This Button will take user to the Home Page of the Learning Object(LO)."}};
		DefaultTableModel model_help = new DefaultTableModel(data_help,colnames_help);

		
		table_help=new JTable(model_help){
			//  Returning the Class of each column will allow different
			//  renderers to be used based on Class
			public Class getColumnClass(int column)
			{
				return getValueAt(0, column).getClass();
			}
		};
		
		table_help.setBounds(150,180,750,380);//nAppRowHeight*table_help.getRowCount());
		//table_help.setRowHeight(nAppRowHeight+18);
		table_help.setRowHeight(nAppRowHeight+18);
		table_help.setFont(new Font("",Font.PLAIN,14));
		TableColumn col = table_help.getColumnModel().getColumn(1);
		col.setPreferredWidth(700);
		table_help.enable(false);		
		table_help.setBackground(lightgrey);	
		container1.add(table_help);
		table_help.setVisible(false);
		
		fr_help_head=new JLabel(" Button                         Description");
		fr_help_head.setBounds(table_help.getBounds().x+5,table_help.getBounds().y-20, 400, 15);		
		add(fr_help_head);
		fr_help_head.setVisible(false);
		
		fr_help_Message=new JLabel("Explanation of different buttons used in animation is given below.");
		fr_help_Message.setBounds(table_help.getBounds().x-10,table_help.getBounds().y-65, 500, 15);		
		add(fr_help_Message);
		fr_help_Message.setVisible(false);
		
		//Help............STOP.......
		
		
		
		//aruna
		
	 	
	 
	 	
	 	
	 	
	 	
	 	
	 	 // Theory Label on Left Side 
	 	lbl = new JLabel("Theory");
	 	//lbl.setBounds(8,162,150,20);
	 	//lbl.setFont(new Font("Arial",Font.BOLD,15));
	 	//lbl.setForeground(Color.black);
	 	
	  // Instruction Label on Left Side
	 	lbl1 = new JLabel("Instructions");
	 	//lbl1.setBounds(8,438,150,20);
	 	//lbl1.setFont(new Font("Arial",Font.BOLD,15));
	 	//lbl1.setForeground(Color.black);
		
	 	  //Buttons
	 	
	 	
	 	
	 	
	 	
	 	
	 
	 	
	 	 // Copyright label
	 info=new JLabel("The contents in this page are licensed under");
	 	//info.setForeground(Color.black);
	 	//info.setFont(new Font("Arial",0,12));
	 	//info.setBackground(footer);
	 	//info.setBounds(713,597,270,18);
	    
	 	info1=new JLabel("Creative Commons Attribution-NonCommercial-ShareAlike 2.5 India license.");
	 	//info1.setForeground(Color.black);
	 	//info1.setFont(new Font("Arial",0,12));
	 	//info1.setBackground(footer);
	 	//info1.setBounds(544,615,438,20);
	 	
	 	
	
	 	
	 	//theory algoritham
	 	theory_button1 = new JButton("1");
		theory_button1.setFont(new Font("",Font.PLAIN,13));
		theory_button1.setForeground(grey);		
		//theory_button1.setBounds(850,555,50,20);
		theory_button1.setBounds(790,555,50,20);
		theory_button1.setVisible(false);
		theory_button1.setToolTipText("Click Here To Theory");
		container1.add(theory_button1);
		theory_button1.addActionListener(this);
		
		/*theory_button2 = new JButton("2");
		theory_button2.setFont(new Font("",Font.PLAIN,13));
		theory_button2.setForeground(grey);	
		theory_button2.setVisible(false);
		//theory_button2.setBounds(910,555,50,20);
		theory_button2.setBounds(850,555,50,20);
		theory_button2.setToolTipText("Click Here To Theory");
		container1.add(theory_button2);
		theory_button2.addActionListener(this);
		
		// button to put timing diagram in theory section
		theory_button3 = new JButton("3");
		theory_button3.setFont(new Font("",Font.PLAIN,13));
		theory_button3.setForeground(grey);	
		theory_button3.setVisible(false);
		//theory_button3.setBounds(790,555,50,20);
		theory_button3.setBounds(910,555,50,20);
		theory_button3.setToolTipText("Click Here To Theory");
		container1.add(theory_button3);
		theory_button3.addActionListener(this);
	*/
		
		
		theory1 = new JPanel();			
				
		ImageIcon theory_image1 = new ImageIcon(getClass().getClassLoader().getResource("images/theory_con.png"));
		JLabel theory_label1 = new JLabel(theory_image1);
		theory_label1.setBounds(50, 15, 500, 445);
		theory1.add(theory_label1);
		
		Dimension scrollSize = new Dimension(400,600);
		theory1_scrollPane = new JScrollPane(theory1);
		theory1_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		theory1_scrollPane.setVisible(false);
		theory1_scrollPane.setPreferredSize(scrollSize);
		theory1_scrollPane.setBounds(22,97,957,453);
		
		add(theory1_scrollPane);
		
		/*theory2 = new JPanel();			
			
		ImageIcon theory_image2 = new ImageIcon(getClass().getClassLoader().getResource("images/theory2.png"));
		JLabel theory_label2 = new JLabel(theory_image2);
		theory_label2.setBounds(50, 5, 500, 445);
		theory2.add(theory_label2);
		
		theory2_scrollPane = new JScrollPane(theory2);
		theory2_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		theory2_scrollPane.setVisible(false);
		theory2_scrollPane.setPreferredSize(scrollSize);
		theory2_scrollPane.setBounds(22,97,957,453);
		
		add(theory2_scrollPane);

// for timing diagram in theory content
		theory3 = new JPanel();			
		
		ImageIcon theory_image3 = new ImageIcon(getClass().getClassLoader().getResource("images/123.png"));
		JLabel theory_label3 = new JLabel("This is image 3");
		theory_label3.setBounds(50, 5, 500, 445);
		theory3.add(theory_label3);
		
		theory3_scrollPane = new JScrollPane(theory3);
		theory3_scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		theory3_scrollPane.setVisible(false);
		theory3_scrollPane.setPreferredSize(scrollSize);
		theory3_scrollPane.setBounds(22,97,957,453);
		
		add(theory3_scrollPane);
*/
		// for interaction screen
		
		//System.out.println(" in init()------------1");
		
		//selSignal = new JLabel("Select signal for Graph 1");
		//selSignal.setVisible(false);
		
		lbl_multSignal_image=new JLabel("");
		lbl_multSignal_image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/multSignals.png")));
		//lbl_multSignal_image.setBounds(50,295,88,26);
		lbl_multSignal_image.setVisible(false);
		container1.add(lbl_multSignal_image);
		
		lbl_integrateSignal_image=new JLabel("");
		lbl_integrateSignal_image.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/integrateSignals1.png")));
		//lbl_integrateSignal_image.setBounds(50,430,187,51);
		lbl_integrateSignal_image.setVisible(false);
		container1.add(lbl_integrateSignal_image);
		
		
		//imageLabel1=new ImageIcon(getClass().getClassLoader().getResource("images/selectSignal1.png"));
		//System.out.println(" in init()  before label1");
		

		//hereee
		
		btnLabel1 = new JButton("Select signal 1:");
		//btnLabel1=new JButton(imageLabel1);
		btnLabel1.setFont(new Font("",Font.PLAIN,16));
	
		
		btnLabel1.setBackground(new Color(0xFFFFFF));
		btnLabel1.setForeground(new Color(0xEF3409));
		btnLabel1.setBorderPainted(false);
		//btnLabel1.setEnabled(false);
		container1.add(btnLabel1);
		//btnLabel1.setForeground(grey);	
		
		//System.out.println(" in init()  before label2");
		//selSignal1 = new JLabel("Select signal for Graph 2");
		//selSignal1.setVisible(false);
		//container1.add(selSignal1);
		//imageLabel2=new ImageIcon(getClass().getClassLoader().getResource("images/selectSignal2.png"));
		 btnlabel2 = new JButton("select signal 2:");
		 btnlabel2.setFont(new Font("",Font.PLAIN,16));
		// btnlabel2 = new JButton(imageLabel2);
		 
		 btnlabel2.setBackground(new Color(0xFFFFFF));
		 btnlabel2.setForeground(new Color(0x006400));
		 btnlabel2.setBorderPainted(false);
		 //btnlabel2.setEnabled(false);
		 container1.add(btnlabel2);
		// System.out.println(" in init()  after label1");
		imageOption1=new ImageIcon(getClass().getClassLoader().getResource("images/signalOption1.png"));
		btnOption1=new JButton(imageOption1);
		btnOption1.setFont(new Font("",Font.PLAIN,13));
		//btnOption1.setForeground(grey);		
		
		//btnOption1.setBounds(630,295,60,45);
		btnOption1.setToolTipText("Click Here To Select this is option 1.");
		container1.add(btnOption1);
		btnOption1.setVisible(true);
		btnOption1.setBorderPainted(false);
		btnOption1.addActionListener(this);
		
		
		btnOption12=new JButton(imageOption1);
		btnOption12.setFont(new Font("",Font.PLAIN,13));
		//btnOption1.setForeground(grey);		
		
		//btnOption1.setBounds(630,295,60,45);
		btnOption12.setToolTipText("Click Here To Select this is option 1.");
		container1.add(btnOption12);
		btnOption12.setVisible(true);
		btnOption12.setBorderPainted(false);
		btnOption12.addActionListener(this);
		
		
		
		imageOption2=new ImageIcon(getClass().getClassLoader().getResource("images/signalOption2.png"));
		btnOption2=new JButton(imageOption2);
		btnOption2.setFont(new Font("",Font.PLAIN,13));
		//btnOption2.setForeground(grey);		
		
		//btnOption2.setBounds(630,295,60,45);
		btnOption2.setToolTipText("Click Here To Select is option 2.");
		container1.add(btnOption2);
		btnOption2.setVisible(true);
		btnOption2.setBorderPainted(false);
		btnOption2.addActionListener(this);
		
		btnOption22=new JButton(imageOption2);
		btnOption22.setFont(new Font("",Font.PLAIN,13));
		//btnOption2.setForeground(grey);		
		
		//btnOption2.setBounds(630,295,60,45);
		btnOption22.setToolTipText("Click Here To Select is option 2.");
		container1.add(btnOption22);
		btnOption22.setVisible(true);
		btnOption22.setBorderPainted(false);
		btnOption22.addActionListener(this);
		
		imageOption3=new ImageIcon(getClass().getClassLoader().getResource("images/signalOption3.png"));
		btnOption3=new JButton(imageOption3);
		btnOption3.setFont(new Font("",Font.PLAIN,13));
		//btnOption3.setForeground(grey);		
		
		//btnOption2.setBounds(630,295,60,45);
		btnOption3.setToolTipText("Click Here To Select is option 3.");
		container1.add(btnOption3);
		btnOption3.setVisible(true);
		btnOption3.setBorderPainted(false);
		btnOption3.addActionListener(this);
		
		btnOption32=new JButton(imageOption3);
		btnOption32.setFont(new Font("",Font.PLAIN,13));
		//btnOption3.setForeground(grey);		
		
		//btnOption2.setBounds(630,295,60,45);
		btnOption32.setToolTipText("Click Here To Select is option 3.");
		container1.add(btnOption32);
		btnOption32.setVisible(true);
		btnOption32.setBorderPainted(false);
		btnOption32.addActionListener(this);
		
		
		
		//System.out.println(" in init()-----------------------2");
		
	//	xpoints1RO1 =  new double[] {885,885,910,910};// option2=1
		xpoints1RO1 =  new double[] {295,295,320,320};
		ypoints1RO1 =  new double[] {235,210,210,235};
		
	//	xpoints2RO1 = new double[] {650,650,675,675};// option1=1
		xpoints2RO1 = new double[] {30,30,55,55};
		ypoints2RO1 = new double[] {235,210,210,235};	
		
		
	//	xpoints1RO2 =  new double[] {885,885,910,910,935,935};// option2=2
		xpoints1RO2 =  new double[] {295,295,320,320,345,345};
		ypoints1RO2 =  new double[] {235,260,260,210,210,235};
		
	//	xpoints2RO2 = new double[] {650,650,675,675,700,700};// option1=2
		xpoints2RO2 = new double[] {30,30,55,55,80,80};
		ypoints2RO2 = new double[] {235,260,260,210,210,235};	
		
		//xpoints1RO3 =  new double[] {885,885,888,900,910,920,930,935};// option2=3
		//ypoints1RO3 =  new double[] {235,210,215,225,230,233,234,235};
		
		xpoints1RO3 =  new double[] {0,0,0,0,0,0,0,0,0,0,0,0,345};// option2=3//935
		ypoints1RO3 =  new double[] {0,0,0,0,0,0,0,0,0,0,0,0,235};
		
		//xpoints2RO3 = new double[] {650,650,653,665,675,685,695,700};// option1=3
		//ypoints2RO3 = new double[] {235,210,215,225,230,233,234,235};	
		
		xpoints2RO3 = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,80};// option1=3//700
		ypoints2RO3 = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,235};	
		
		
		// left panel start here for interaction
    	
    /*	xpoints1O1 =  new double[] {355,355,380,380};//option2 = 1
    	ypoints1O1 =  new double[] {235,210,210,235};*/
		xpoints1O1 =  new double[] {775,775,800,800};//option2 = 1
    	ypoints1O1 =  new double[] {235,210,210,235};
    	
    	/*xpoints2O1 = new double[] {130,130,155,155};//option1==1
    	ypoints2O1 = new double[] {235,210,210,235};*/
		xpoints2O1 = new double[] {550,550,575,575};//option1==1
    	ypoints2O1 = new double[] {235,210,210,235};
    	
    //	xpoints1O2 =  new double[] {355,355,380,380,405,405};//option2 = 2
		xpoints1O2 =  new double[] {775,775,800,800,825,825};
    	ypoints1O2 =  new double[] {235,260,260,210,210,235};
    	
   // 	xpoints2O2 = new double[] {130,130,155,155,180,180};//option1==2
		xpoints2O2 = new double[] {550,550,575,575,600,600};
    	ypoints2O2 = new double[] {235,260,260,210,210,235};
    	
    	xpoints1O3 = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,825};		//405
    	ypoints1O3 = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,235};
    	
    	
	//	xpoints2O3 = new double[] {130,130,135,140,145,150,155,160,165,170,175,180,180};
		xpoints2O3 = new double[] {550,550,555,560,565,570,575,580,585,590,595,600,600};
		//option1==3 // straight
    	ypoints2O3 = new double[] {235,210,214.53,218.24,221.27,223.76,225.80,227.47,228.83,229.95,230.86,231.61,235};
		
    //	xpointsAreaI = new double[] {355,355,355,355};
		xpointsAreaI = new double[] {775,775,775,775};
    	ypointsAreaI = new double[] {350,350,350,350};
		
    //	xpointsArea12 = new double[] {355,355,355,355,355,355,355};
		xpointsArea12 = new double[] {775,775,775,775,775,775,775};
    	ypointsArea12 = new double[] {350,350,350,350,350,350,350};
    	
    //	xpointsArea22 = new double[] {355,355,355,355,355,355,355,355};
		xpointsArea22 = new double[] {775,775,775,775,775,775,775,775};
    	ypointsArea22 = new double[] {350,350,350,350,350,350,350,350};
    	
    //	xpointsArea23 = new double[] {355,355,355,355,355,355,355,355,355,355};
		xpointsArea23 = new double[] {775,775,775,775,775,775,775,775,775,775};
    	ypointsArea23 = new double[] {350,350,350,350,350,350,350,350,350,350};
    	
		// end interaction
		// for demo screen--------------------------------------------------------------------------------------------------------
		
		// main panel graph data-----------------------------------------
		// right panel data

		//xaxpoints1R = new int[] {630,760};// graph1 in right panel
		xaxpoints1R = new int[] {10,140};
    	xaypoints1R = new int[] {235,235};

    	//yaxpoints1R = new int[] {650,650};
		yaxpoints1R = new int[] {30,30};
    	yaypoints1R = new int[] {135,250};
    	
    	//xaxpoints2R = new int[] {790,965};// graph2 in right panel
    	xaxpoints2R = new int[] {200,375};
		xaypoints2R = new int[] {235,235};

    	//yaxpoints2R = new int[] {885,885};
    	yaxpoints2R = new int[] {295,295};
		yaypoints2R = new int[] {135,250};
    	
    	
    	xpoints1R =  new double[] {835,835,935,935};
    	ypoints1R =  new double[] {235,185,185,235};
    	
    	xpoints2R = new double[] {650,650, 675};
    	ypoints2R = new double[] {235,210,235};	
    	
    	
// left panel starts here
    	
    	//xaxpoints1 = new int[] {35,215};// graph1 in left panel
    	//xaxpoints1 = new int[] {35,215};// graph1 in left panel
		xaxpoints1 = new int[] {455,735};
    	xaypoints1 = new int[] {235,235};

    	//yaxpoints1 = new int[] {130,130};
		yaxpoints1 = new int[] {550,550};
    	yaypoints1 = new int[] {135,250};
    	
    	//xaxpoints2 = new int[] {210,540};// graph2 in left panel
    	//xaxpoints2 = new int[] {235,540};// graph2 in left panel
		xaxpoints2 = new int[] {755,970};
    	xaypoints2 = new int[] {235,235};

    	//yaxpoints2 = new int[] {355,355};
		yaxpoints2 = new int[] {775,775};
    	yaypoints2 = new int[] {135,250};
    	
    	xaxpoints2a = new int[] {455,970};
    	xaypoints2a = new int[] {235,235};
    	
    	
    	// 2nd row NICHE WALA GRAPH
    	//xaxpoints21 = new int[] {35,550};// graph1 in left panel
		xaxpoints21 = new int[] {455,970};
    	xaypoints21 = new int[] {350,350};

    	//yaxpoints21 = new int[] {355,355};
		yaxpoints21 = new int[] {675,675};
    	yaypoints21 = new int[] {285,410};
    	
    	//3rd row
    	//xaxpoints31 = new int[] {35,550};// graph2 in left panel
		xaxpoints31 = new int[] {455,970};
    	xaypoints31 = new int[] {500,500};

    	//yaxpoints31 = new int[] {355,355};
		yaxpoints31 = new int[] {675,675};
    	yaypoints31 = new int[] {435,560};
    	
    	
    	
    	
    	
    	
    	
    	xpoints1 =  new double[] {305,305,405,405};
    	ypoints1 =  new double[] {235,185,185,235};
    	
    	
    	xpoints2 = new double[] {130,130,155};
    	ypoints2 = new double[] {235,210,235};
    	
    	
    	
    	
    	
    	xpointsArea = new double[] {305,305,305,305};
    	ypointsArea = new double[] {235+115,235+115,235+115,235+115};
	
    	xpointsFinal = new double[] {305,305};
    	ypointsFinal =  new double[] {500,500};
    	xpointsIntegrate = new double[250];
    	ypointsIntegrate= new double[250];
    	for(int x = 0;x<250;x++){
    		xpointsIntegrate[x] = 305; //  it was 0 before
    		ypointsIntegrate[x] = 500; //it was 0 before
    	}
    	xpointsCircle = 305;
    	ypointsCircle = 500;
	// end of main panel
	
	
    
	
	
	
	Font myFont= new Font("Helvetica", Font.BOLD, 15);
	
	
	
	// play and stop button
	 btnPlay = new JButton("PLAY");
	 btnPlay.setToolTipText("Press here to play the animation");
	 btnPlay.setEnabled(false);
	// btnPlay.setBounds(767,430,80,20);
	
	 //btnPlay.setBackground(new Color (0xc0fd68));
	 container1.add(btnPlay);
	 
	 btnPause = new JButton("PAUSE");
	 btnPause.setToolTipText("Click Here To Pause");
	 //btnPause.setBackground(new Color (0xc0fd68));
	 container1.add(btnPause);
	 btnPause.setEnabled(false);
	 
	 btnStop = new JButton("RESET");
	 btnStop.setToolTipText("Press here to Stop the animation");
	
	 //btnStop.setBackground(new Color (0xff4500));
	 btnStop.setForeground(new Color (0xa52a2a));
	 container1.add(btnStop);
	 btnStop.setEnabled(false);
	 // end if play and stop button
	
	  /*----------ADD ACTION LISTENERS---------------*/
     btnPlay.addActionListener(this);
     btnStop.addActionListener(this);
     btnPause.addActionListener(this);
     
     btnOption1.addActionListener(new ActionListener()
		{			    

			    public void actionPerformed(ActionEvent e) {
			    	try
			    	{
			    		//Thread.sleep(1000);
			    		System.out.println("In btnoption1 listener");
			    	}
			    	catch(Exception axc)
			    	{}
			    	System.out.println(" signal_one_selected = "+signal_one_selected);
			    	if(signal_one_selected == false){
			    		
						option1 = 1;
						signal_one_selected = true;
					//	signal_two_selected = false;
						//thisone=true;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
				    	//selSignal.setVisible(false);
				    	
				    	//selSignal1.setVisible(true);
				    	
				    	//System.out.println(" signal_one_selected = "+signal_one_selected+selSignal.isVisible());
			    	}
			    	else  if(signal_one_selected == true){
			    		System.out.println(" signal_one_selected  in else = "+signal_one_selected);
			    		option1 = 1;
						signal_one_selected = true;
					//	signal_two_selected = false;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
						System.out.println(" signal_two_selected  in else = "+signal_two_selected);
				    	//selSignal.setVisible(false);
				    	//selSignal1.setVisible(false);
			    	}
			    	if((signal_one_selected ==true)&&(signal_two_selected == true)){
			    		btnPlay.setEnabled(true);
			    	}else{
			    		btnPlay.setEnabled(false);
			    	}
					btnStop.setEnabled(true);
			    	
					
				}
			
		});
     btnOption2.addActionListener(new ActionListener()
		{			    

			    public void actionPerformed(ActionEvent e) {
					
			    	if(signal_one_selected == false){
						option1 = 2;
						signal_one_selected = true;
					//	signal_two_selected = false;
						thisone=true;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
				    	//selSignal.setVisible(false);
				    	//selSignal1.setVisible(true);
			    	}
			    	else if(signal_one_selected == true){
			    		option1 = 2;
						signal_one_selected = true;
					//	signal_two_selected = false;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
				    	//selSignal.setVisible(false);
				    	//selSignal1.setVisible(false);
			    	}
			    	if((signal_one_selected ==true)&&(signal_two_selected == true)){
			    		btnPlay.setEnabled(true);
			    	}else{
			    		btnPlay.setEnabled(false);
			    	}
					btnStop.setEnabled(true);
					
					
				}
			
		});
     btnOption3.addActionListener(new ActionListener()
		{			    
    	 	
			    public void actionPerformed(ActionEvent e) {
			    	System.out.println(" inside action listener==============================");
			    	if(signal_one_selected == false){
						option1 = 3;
						signal_one_selected = true;
					//	signal_two_selected = false;
						thisone=true;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
						System.out.println(" inside action listener===========after===================");
				    	///selSignal.setVisible(false);
				    	//selSignal1.setVisible(true);
			    	}
			    	else if(signal_one_selected == true){
			    		option1 = 3;
						signal_one_selected = true;
					//	signal_two_selected = false;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
				    	//selSignal.setVisible(false);
				    	//selSignal1.setVisible(false);
						System.out.println(" inside action listener==== in else======after===================");
			    	}
			    	if((signal_one_selected ==true)&&(signal_two_selected == true)){
			    		btnPlay.setEnabled(true);
			    	}else{
			    		btnPlay.setEnabled(false);
			    	}
					btnStop.setEnabled(true);
					
					
				}
			
		});
    	btnOption12.addActionListener(new ActionListener()
		{			    

			    public void actionPerformed(ActionEvent e) {
			    	System.out.println(" signal_one_selected = "+signal_one_selected);
			    	if(signal_two_selected == false){
			    		
						option2 = 1;
						signal_two_selected = true;
					//	signal_one_selected = false;
						thistwo=true;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
				    	//selSignal.setVisible(false);
				    	
				    	//selSignal1.setVisible(true);
				    	
				    	//System.out.println(" signal_one_selected = "+signal_one_selected+selSignal.isVisible());
			    	}
			    	else  if(signal_two_selected == true){
			    		System.out.println(" signal_one_selected  in else = "+signal_one_selected);
			    		option2 = 1;
					
						signal_two_selected = true;
					//	signal_one_selected = false;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
						System.out.println(" signal_two_selected  in else = "+signal_two_selected);
				    	//selSignal.setVisible(false);
				    	//selSignal1.setVisible(false);
			    	}
			    	if((signal_one_selected ==true)&&(signal_two_selected == true)){
			    		btnPlay.setEnabled(true);
			    	}else{
			    		btnPlay.setEnabled(false);
			    	}
					btnStop.setEnabled(true);
			    	
					
				}
			
		});
     btnOption22.addActionListener(new ActionListener()
		{			    

			    public void actionPerformed(ActionEvent e) {
					
			    	if(signal_two_selected == false){
						option2 = 2;
						
						signal_two_selected = true;
					//	signal_one_selected = false;
						thistwo=true;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
				    	//selSignal.setVisible(false);
				    	//selSignal1.setVisible(true);
			    	}
			    	else if(signal_two_selected == true){
			    		option2 = 2;
					
						signal_two_selected = true;
					//	signal_one_selected = false;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
				    	//selSignal.setVisible(false);
				    	//selSignal1.setVisible(false);
			    	}
			    	if((signal_one_selected ==true)&&(signal_two_selected == true)){
			    		btnPlay.setEnabled(true);
			    	}else{
			    		btnPlay.setEnabled(false);
			    	}
					btnStop.setEnabled(true);
					
					
				}
			
		});
     btnOption32.addActionListener(new ActionListener()
		{			    
    	 	
			    public void actionPerformed(ActionEvent e) {
			    	System.out.println(" inside action listener==============================");
			    	if(signal_two_selected == false){
						option2 = 3;
						signal_two_selected = true;
					//	signal_one_selected = false;
						thistwo=true;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
						System.out.println(" inside action listener===========after===================");
				    	///selSignal.setVisible(false);
				    	//selSignal1.setVisible(true);
			    	}
			    	else if(signal_two_selected == true){
			    		option2 = 3;
						signal_two_selected = true;
					//	signal_one_selected = false;
						btnLabel1.setVisible(true);
						btnlabel2.setVisible(true);
				    	//selSignal.setVisible(false);
				    	//selSignal1.setVisible(false);
						System.out.println(" inside action listener==== in else======after===================");
			    	}
			    	if((signal_one_selected ==true)&&(signal_two_selected == true)){
			    		btnPlay.setEnabled(true);
			    	}else{
			    		btnPlay.setEnabled(false);
			    	}
					btnStop.setEnabled(true);
					
					
				}
			
		});
    	
     		
		btnPlay.addActionListener(new ActionListener()
		{			    

			    public void actionPerformed(ActionEvent e) {
			    	//setAnimation(true);
					
					btnPlay.setEnabled(false);
					btnStop.setEnabled(true);
					
				}
			
		});
		

		btnStop.addActionListener(new ActionListener()
		{			    

			    public void actionPerformed(ActionEvent e) {
			    /*	//setAnimation(false);
					btnPlay.setEnabled(false);
					btnStop.setEnabled(false);
					btnPause.setEnabled(false);*/
								myStop();
			System.out.println("button Interaction clicked.");
			init();
			btnLabel1.setBounds(10,270,150,30);				//100 prev
			//btnlabel2.setBounds(100,290,200,30);
			btnOption1.setBounds(150,270,40,30);
			btnOption2.setBounds(190,270,40,30);			//150 prev
			btnOption3.setBounds(230,270,40,30);
			
			btnlabel2.setBounds(10,320,150,30);
			btnOption12.setBounds(150,320,40,30);
			btnOption22.setBounds(190,320,40,30);
			btnOption32.setBounds(230,320,40,30);
			
			
			
			/*btnPause.setBounds(715,330,80,25);
			btnStop.setBounds(840,330,80,25);
			btnPlay.setBounds(715,330,80,25);*/
			btnPause.setBounds(35,550,80,25);
			btnStop.setBounds(160,550,80,25);
			btnPlay.setBounds(35,550,80,25);
			btnLabel1.setVisible(false);
			btnlabel2.setVisible(false);
			//selSignal.setVisible(true);
			//selSignal1.setVisible(false);
			btnOption1.setVisible(false);
			btnOption2.setVisible(false);
			btnOption3.setVisible(false);
			btnOption12.setVisible(false);
			btnOption22.setVisible(false);
			btnOption32.setVisible(false);
					
			blAnalogy=false;
			blTheory=false;			
			demo=false;
			blInteraction=true;
			blHelp=false;
			blhome = false;
			blExercise=false;
			blGlossary=false;
			blLinks=false;
			
			txtPane_interaction.setText("\n\nHere you can view the explanation of what is going on leftside as animation.");
			txtPane_interaction.setVisible(true);
			opening_screen.setVisible(false);
			opening_screen1.setVisible(false);
			lbl_openingscreen.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			opening_screen_message.setVisible(false);
			opening_screen_logo.setVisible(false);
			
			but_Interaction.setBorder(thickBorder_interaction);
			System.out.println("interaction_first :"+interaction_first);
			//repaint();
			System.out.println("after repaint interaction_first :"+interaction_first);
			
			cb=new JCheckBox("Select the Signal");
			event ee=new event();
			container1.add(cb);
			cb.setBounds(25,395,350,30);
			cb.addItemListener(ee);
			//g.drawString("-  f(t) and g(t) are the two continuous signals to ", 63,400);
			cb2=new JCheckBox("Change the time variable from t to tau");
			container1.add(cb2);
			cb2.setBounds(25,425,350,30);
			cb2.addItemListener(ee);
			//g.drawString("   be convolved.", 63,420);
			cb3=new JCheckBox("Reverse the signal h(tau)");
			container1.add(cb3);
			cb3.setBounds(25,455,350,30);cb3.addItemListener(ee);
			//g.drawString("-  The convolution of the signals is denoted by " , 63,450);
			cb4=new JCheckBox("Shift the signal h(t-tau) and compute the integral");
			container1.add(cb4);
			cb4.setBounds(25,485,350,30);
			cb4.addItemListener(ee);
			System.out.println("interaction_first :"+interaction_first);
			//repaint();
			System.out.println("after repaint interaction_first :"+interaction_first);
			 
			cb2.setEnabled(false);cb3.setEnabled(false);cb4.setEnabled(false);
			System.out.println("interaction_first :"+interaction_first);
			repaint();
				}
			
		});
		
		btnPause.addActionListener(new ActionListener()
		{			    

			    public void actionPerformed(ActionEvent e) {
					
					btnPlay.setEnabled(true);
					btnStop.setEnabled(false);
					btnPause.setEnabled(false);
				}
			
		});
		
	System.out.println("INIT HAS ENDED");
		
}//end of init
//aruna


	
public void actionPerformed(ActionEvent e){	
		
		//System.out.println("MAZA SATAKLI RE:"+e.getSource());
		if(e.getSource()==but_Demo){
			
			myStop();
			init();
			
			/*btnPause.setBounds(715,320,80,25);
			btnStop.setBounds(840,320,80,25);
			btnPlay.setBounds(715,320,80,25);*/
			btnPause.setBounds(35,550,80,25);
			btnStop.setBounds(160,550,80,25);
			btnPlay.setBounds(35,550,80,25);
			btnPlay.setEnabled(true);	
			blTheory=false;
			blAnalogy=false;
			blInteraction=false;
			blGlossary=false;
			blExercise=false;
			blHelp=false;
			blhome = false;
			blLinks=false;
			demo=true;
			demo_zero=true;
			if(blInteraction==true)
			{
			//t_interaction.stop();
			}
			txtPane_explanation.setVisible(true);
			opening_screen.setVisible(false);
			opening_screen1.setVisible(false);
			lbl_openingscreen.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			opening_screen_message.setVisible(false);
			opening_screen_logo.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			but_Demo.setBorder(thickBorder_demo);
		}//end of Demo Button
		
		if(e.getSource() == btnPlay)
		{
				if(cb.isEnabled()&&cb.isSelected())
				{
						//action for check 1
						/*drawGraph(g,xaxpoints1,xaypoints1,yaxpoints1,yaypoints1);// graph 1 in left panel
						drawGraph(g,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);// graph 2 in right panel
						*/
					Graphics gx=getGraphics();
				//	drawGraph(gx,xaxpoints1,xaypoints1,yaxpoints1,yaypoints1);// graph 1 in left panel
				//	drawGraph(gx,xaxpoints2,xaypoints2,yaxpoints2,yaypoints2);// graph 2 in right panel
					System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
					try
					{
						System.out.println("Jaikant is waitinh");
					//	Thread.sleep(1000);
					}
					catch(Exception exx)
					{
					}
					btnOption1.setVisible(true);
					btnOption2.setVisible(true);
					btnOption3.setVisible(true);
					btnOption12.setVisible(true);
					btnOption22.setVisible(true);
					btnOption32.setVisible(true);
					btnLabel1.setVisible(true);
					btnlabel2.setVisible(true);
					cb.setEnabled(false);
					//myStart();
					repaint();
					//myPause();
				}
				if(cb2.isEnabled()&&cb2.isSelected())
				{
					try
					{
						System.out.println("variable changing from t to tau");
						repaint();//Thread.sleep(5000);
						cb2.setEnabled(false);
						cb3.setEnabled(true);
						btnPlay.setEnabled(false);
					}
					catch(Exception exx)
					{
					}
				}
				if(cb3.isEnabled()&&cb3.isSelected())
				{
					myStart();
					repaint();
					cb3.setEnabled(false);
					btnPlay.setVisible(false);
					btnPlay.setEnabled(false);
				}
				if(cb4.isEnabled()&&cb4.isSelected())
				{
					myPause();	//This resumes the animation
					btnPlay.setVisible(false);
					btnPlay.setEnabled(false);	
				}
		}
		if(e.getSource()== but_home)
		{
			myStop();
			System.out.println("Inside Home");
			init();
			demo=false;
			blAnalogy=false;
			blInteraction=false;
			blTheory=false;	
			blGlossary=false;
			blExercise=false;
			blHelp=false;
			blLinks=false;
			blhome = true;
			opening_screen.setVisible(true);
			opening_screen1.setVisible(true);
			lbl_openingscreen.setVisible(true);
			lbl_opening_screen_left.setVisible(true);
			opening_screen_message.setVisible(true);
			opening_screen_logo.setVisible(true);
			lbl_opening_screen_left.setVisible(true);
			lblHeader_glossary.setVisible(false);
			lblMessage_glossary.setVisible(false);
			tblLeftIndex_glossary.setVisible(false);
			txtPaneDescription_glossary.setVisible(false);
			repaint();
		}
		
		if(e.getSource()==btnPause)
		{	
			System.out.println("PAUSE");
			repaint();
			myPause();
			
		}
		
		if(e.getSource()==but_Resume)
		{	
			System.out.println("Resume");
			but_Resume.setVisible(false);
			but_Pause.setVisible(true);
			//stopf=false;
			//t_demo=new Thread(this);
			//t_demo.resume();//start();	
		}
		
		if(e.getSource()==but_Theory)
		{
			myStop();
			init();				
			blGlossary=false;
			blExercise=false;
			blHelp=false;
			blhome = false;
			blLinks=false;			
			demo=false;
			blAnalogy=false;
			blInteraction=false;
			blTheory=true;
			//table_theoryApplnPrg.setVisible(true);
			//table_theoryPhymem.setVisible(true);
			//table_theorySecmem.setVisible(true);
			opening_screen.setVisible(false);
			opening_screen1.setVisible(false);
			lbl_openingscreen.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			opening_screen_message.setVisible(false);
			opening_screen_logo.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			//txtPane_theory.setVisible(true);
			but_Theory.setBorder(thickBorder_theory);
			//txtPane_theory.setText("Write Theory Here");
			//txtPane_theory.setText("\t\t\t\t\t\t\t\t\t\tVirtual Memory Concept\nVirtual memory is a technique which gives an application program the impression that it has contiguous working memory, while in fact it may be physically fragmented and may overflow on to disk storage.\nPrograms use virtualÂ addressesÂ than real addresses to store data. When the program is actually executed, the virtual addresses are converted into real memory addresses. When a process requests access to its memory, it is the responsibility of the operating system to map the virtual address to the physical address. A page table is used to store mapping between virtual addresses and physical addresses.\nWhen a virtual address needs to be translated into a physical address, the TLB is searched first. If a match is found (TLB hit), the physical address is returned and memory access can continue. However, if there is no match (TLB miss),will be searched in page table to see whether a mapping exists (a Page Walk). If one exists, it is written back to the TLB  and the faulting instruction is restarted.\nThe page table lookup may fail for two reasons.1) The first is if there is no translation available for that address, meaning the memory access to that virtual address is invalid. This will typically occur because of a programming error, and the operating system must take some action to deal with the problem.2) The page table lookup may also fail if the page is not resident in physical memory. This will occur if the requested page has been swapped out of physical memory to make room for another page. In this case the page is swapped to a secondary store.Here the page to be brought back to physical  memory.\nWhen physical memory is full, one or more pages in physical memory will need to be swapped out to make room for the requested page. Which page to swap out is the subject of page replacement algorithms.");
			//theory_button1.setVisible(true);
			//theory_button2.setVisible(true);
			//theory_button3.setVisible(true);
			
			theory1_scrollPane.setVisible(true);
			//theory2_scrollPane.setVisible(false);
			//theory3_scrollPane.setVisible(false);
			repaint();
		}
		
		/*if(e.getSource()== theory_button1){
			
			theory1_scrollPane.setVisible(true);
			//theory2_scrollPane.setVisible(false);
			///theory3_scrollPane.setVisible(false);
		}*/
		
		/*if(e.getSource()== theory_button2){
			
			theory1_scrollPane.setVisible(false);
			theory2_scrollPane.setVisible(true);
			theory3_scrollPane.setVisible(false);
		}

		if(e.getSource()== theory_button3){
			
			theory1_scrollPane.setVisible(false);
			theory2_scrollPane.setVisible(false);
			theory3_scrollPane.setVisible(true);
		}*/
		/*if(e.getSource()==but_Glossary)
		{		
			init();
			demo=false;
			blAnalogy=false;
			blInteraction=false;
			blTheory=false;	
			blGlossary=true;
			blHelp=false;
			blLinks=false;
			blhome = false;
			blExercise=false;
			opening_screen.setVisible(false);
			opening_screen_logo.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			lblHeader_glossary.setVisible(true);
			lblMessage_glossary.setVisible(true);
			tblLeftIndex_glossary.setVisible(true);
			txtPaneDescription_glossary.setVisible(true);
			txtPane_Analogy.setVisible(false);
			but_Glossary.setBorder(thickBorder_glossary);
			FillHashMapObject();
			repaint();
		}*/
		
		if(e.getSource()==but_Links)
		{
			myStop();
			init();
			demo=false;
			blAnalogy=false;
			blInteraction=false;
			blTheory=false;	
			blGlossary=false;
			blExercise=false;
			blHelp=false;
			blhome = false;
			blLinks=true;
			opening_screen.setVisible(false);
			opening_screen1.setVisible(false);
			lbl_openingscreen.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			opening_screen_message.setVisible(false);
			opening_screen_logo.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			lblHeader_glossary.setVisible(false);
			lblMessage_glossary.setVisible(false);
			tblLeftIndex_glossary.setVisible(false);
			txtPaneDescription_glossary.setVisible(false);
			txtPane_Analogy.setVisible(false);
			//but_go_links.setVisible(true);
			//but_go1_links.setVisible(true);
			fr_links_Message.setVisible(true);
			fr_links_Message1.setVisible(true);
			txtPane_ref.setVisible(true);
			but_Links.setBorder(thickBorder_links);
			repaint();
		}
		
		if(e.getSource()==but_Exercise)
		{
			myStop();
			init();
			paneltemp.setVisible(true);
			fr_exercise_Message.setVisible(true);
			fr_exercise_Message1.setVisible(true);
			fr_exercise_but1.setVisible(true);
			fr_exercise_but2.setVisible(true);
			fr_exercise_but3.setVisible(true);
			fr_exercise_but4.setVisible(true);
			fr_exercise_but5.setVisible(true);
			fr_exercise_answer.setVisible(true);
			panel1.setVisible(true);					
			demo=false;
			blAnalogy=false;
			blInteraction=false;
			blTheory=false;	
			blGlossary=false;
			blExercise=true;
			blHelp=false;
			blhome = false;
			blTheory=false;
			blLinks=false;
			opening_screen.setVisible(false);
			opening_screen1.setVisible(false);
			lbl_openingscreen.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			opening_screen_message.setVisible(false);
			opening_screen_logo.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			lblHeader_glossary.setVisible(false);
			lblMessage_glossary.setVisible(false);
			tblLeftIndex_glossary.setVisible(false);
			txtPaneDescription_glossary.setVisible(false);
			txtPane_Analogy.setVisible(false);	
			but_Exercise.setBorder(thickBorder_exercise);
			repaint();
		}

		/*
		if(e.getSource()==but_close_links)
		{
			fr_links.setVisible(false);
		}
		if(e.getSource()== but_go_links)
		{
			try {
				getAppletContext().showDocument(new URL(but_go_links.getLabel()),"_blank");
			}
			catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		if(e.getSource()== but_go1_links)
		{
			try {
				getAppletContext().showDocument(new URL(but_go1_links.getLabel()),"_blank");
			}
			catch (Exception ee) {
				ee.printStackTrace();
			}
		}*/
		if(e.getSource()==but_Help)
		{
			myStop();
			
			System.out.println("INside Help");
			init();
			blHelp=true;
			blhome = false;
			//fr_exercise_Message.setVisible(false);
			//fr_exercise_Message1.setVisible(false);
			//fr_exercise_but1.setVisible(false);
			//fr_exercise_but2.setVisible(false);
			//fr_exercise_but3.setVisible(false);
			//fr_exercise_answer.setVisible(false);
			//panel1.setVisible(false);
			blTheory=false;
			demo=false;
			blAnalogy=false;
			blInteraction=false;
			blTheory=false;	
			blGlossary=false;
			blExercise=false;
			blLinks=false;
			opening_screen.setVisible(false);
			opening_screen1.setVisible(false);
			lbl_openingscreen.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			opening_screen_message.setVisible(false);
			opening_screen_logo.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			lblHeader_glossary.setVisible(false);
			lblMessage_glossary.setVisible(false);
			tblLeftIndex_glossary.setVisible(false);
			txtPaneDescription_glossary.setVisible(false);
			txtPane_Analogy.setVisible(false);	
			fr_help_Message.setVisible(true);
			fr_help_head.setVisible(true);
			table_help.setVisible(true);
			but_Help.setBorder(thickBorder_help);
			repaint();

		}
		if(e.getSource()==but_Analogy)
		{
			myStop();
			init();
			blAnalogy=true;
			blTheory=false;
			demo=false;
			blInteraction=false;
			blHelp=false;
			blhome = false;
			blExercise=false;
			blGlossary=false;
			blLinks=false;
			txtPane_Analogy.setVisible(true);
			opening_screen.setVisible(false);
			opening_screen1.setVisible(false);
			lbl_openingscreen.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			opening_screen_message.setVisible(false);
			opening_screen_logo.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			but_Analogy.setBorder(thickBorder_analogy);
			repaint();

		}
		if(e.getSource()==but_Interaction)
		{
			myStop();
			System.out.println("button LALABHAI Interaction clicked.");
			init();
			btnLabel1.setBounds(10,270,150,30);				//100 prev
			//btnlabel2.setBounds(100,290,200,30);
			btnOption1.setBounds(150,270,40,30);
			btnOption2.setBounds(190,270,40,30);			//150 prev
			btnOption3.setBounds(230,270,40,30);
			btnlabel2.setBounds(10,320,150,30);
			btnOption12.setBounds(150,320,40,30);
			btnOption22.setBounds(190,320,40,30);
			btnOption32.setBounds(230,320,40,30);
			
			
			
			/*btnPause.setBounds(715,330,80,25);
			btnStop.setBounds(840,330,80,25);
			btnPlay.setBounds(715,330,80,25);*/
			btnPause.setBounds(35,550,80,25);
			btnStop.setBounds(160,550,80,25);
			btnPlay.setBounds(35,550,80,25);
			btnLabel1.setVisible(false);
			btnlabel2.setVisible(false);
			//selSignal.setVisible(true);
			//selSignal1.setVisible(false);
			btnOption1.setVisible(false);
			btnOption2.setVisible(false);
			btnOption3.setVisible(false);
			btnOption12.setVisible(false);
			btnOption22.setVisible(false);
			btnOption32.setVisible(false);
					
			blAnalogy=false;
			blTheory=false;			
			demo=false;
			blInteraction=true;
			blHelp=false;
			blhome = false;
			blExercise=false;
			blGlossary=false;
			blLinks=false;
			
			txtPane_interaction.setText("\n\nHere you can view the explanation of what is going on leftside as animation.");
			txtPane_interaction.setVisible(true);
			opening_screen.setVisible(false);
			opening_screen1.setVisible(false);
			lbl_openingscreen.setVisible(false);
			lbl_opening_screen_left.setVisible(false);
			opening_screen_message.setVisible(false);
			opening_screen_logo.setVisible(false);
			but_Interaction.setBorder(thickBorder_interaction);
			cb=new JCheckBox("Select the Signal");
			container1.add(cb);
			cb.setBounds(25,395,350,30);
			event ee=new event();
			cb.addItemListener(ee);
			//g.drawString("-  f(t) and g(t) are the two continuous signals to ", 63,400);
			cb2=new JCheckBox("Change the time variable from t to tau");
			container1.add(cb2);
			cb2.setBounds(25,425,350,30);
			cb2.addItemListener(ee);
			//g.drawString("   be convolved.", 63,420);
			cb3=new JCheckBox("Reverse the signal h(tau)");
			container1.add(cb3);
			cb3.setBounds(25,455,350,30);
			cb3.addItemListener(ee);
			//g.drawString("-  The convolution of the signals is denoted by " , 63,450);
			cb4=new JCheckBox("Shift the signal h(t-tau) and compute the integral");
			container1.add(cb4);
			cb4.setBounds(25,485,350,30);
			cb4.addItemListener(ee);
			cb2.setEnabled(false);cb3.setEnabled(false);cb4.setEnabled(false);
			System.out.println("interaction_first :"+interaction_first);
			repaint();
			System.out.println("after repaint interaction_first :"+interaction_first);
		}
		if(e.getSource()== but_credits)
		{
			System.out.println("Inside Credits");
			
			//init();
			/*demo=false;*/
			blAnalogy=false;
			//blInteraction=false;
			/*blTheory=false;	
			blGlossary=false;
			blExercise=false;
			blHelp=false;
			blhome = false;
			blLinks=false;
			//blhome = true;
			opening_screen.setVisible(true);			
			opening_screen_logo.setVisible(true);
			opening_screen1.setVisible(true);
			lbl_openingscreen.setVisible(true);
			lbl_opening_screen_left.setVisible(true);
			opening_screen_message.setVisible(true);*/
			
			if(blTheory==true){
				theory1_scrollPane.setVisible(true);
				/*opening_screen.setVisible(false);			
				opening_screen_logo.setVisible(false);
				opening_screen1.setVisible(false);
				lbl_openingscreen.setVisible(false);
				lbl_opening_screen_left.setVisible(false);
				opening_screen_message.setVisible(false);
				*/
				
			}else if(blhome == true){
				opening_screen.setVisible(true);			
				opening_screen_logo.setVisible(true);
				opening_screen1.setVisible(true);
				lbl_openingscreen.setVisible(true);
				lbl_opening_screen_left.setVisible(true);
				opening_screen_message.setVisible(true);
			}else if(blGlossary==true){
				lblHeader_glossary.setVisible(true);
				lblMessage_glossary.setVisible(true);
				tblLeftIndex_glossary.setVisible(true);
				txtPaneDescription_glossary.setVisible(true);
				
				// home false
				/*opening_screen.setVisible(false);			
				opening_screen_logo.setVisible(false);
				opening_screen1.setVisible(false);
				lbl_openingscreen.setVisible(false);
				lbl_opening_screen_left.setVisible(false);
				opening_screen_message.setVisible(false);*/
				
			}else if(blHelp== true){
				fr_help_Message.setVisible(true);
				fr_help_head.setVisible(true);
				table_help.setVisible(true);
				//
				/*opening_screen.setVisible(false);			
				opening_screen_logo.setVisible(false);
				opening_screen1.setVisible(false);
				lbl_openingscreen.setVisible(false);
				lbl_opening_screen_left.setVisible(false);
				opening_screen_message.setVisible(false);*/
			}
			else if(demo== true){
				btnPause.setBounds(715,320,80,25);
				btnStop.setBounds(840,320,80,25);
				btnPlay.setBounds(715,320,80,25);
					
				
				txtPane_explanation.setVisible(true);
				/*
				opening_screen.setVisible(false);			
				opening_screen_logo.setVisible(false);
				opening_screen1.setVisible(false);
				lbl_openingscreen.setVisible(false);
				lbl_opening_screen_left.setVisible(false);
				opening_screen_message.setVisible(false);*/
			}else if(blInteraction==true){
			/*	btnPause.setBounds(715,330,80,25);
				btnStop.setBounds(840,330,80,25);
				btnPlay.setBounds(715,330,80,25);*/
				btnPause.setBounds(35,550,80,25);
				btnStop.setBounds(160,550,80,25);
				btnPlay.setBounds(35,550,80,25);
				
				
				
				
				
				txtPane_explanation.setVisible(true);
			}
			else if(blExercise==true){
				
				if(ex == 2){
					System.out.println(" ---in que 2");
					exercise = true;
					panel1.setVisible(false);
					panel2.setVisible(true);			
					panel3.setVisible(false);
					panel4.setVisible(false);
					panel5.setVisible(false);
					q2.clearSelection();
					fr_exercise_answer.setText(" ");
					q21.setSelected(false);
					q22.setSelected(false);
					//q23.setSelected(false);
					//q24.setSelected(false);
					fr_exercise_answer.setForeground(Color.red);
				}else if(ex == 3){
					System.out.println(" ---in que 2");
					exercise = true;
					panel1.setVisible(false);
					panel2.setVisible(false);			
					panel3.setVisible(true);
					panel4.setVisible(false);
					panel5.setVisible(false);
					q3.clearSelection();
					fr_exercise_answer.setText(" ");
					q31.setSelected(false);
					q32.setSelected(false);
					q33.setSelected(false);
					q34.setSelected(false);
					fr_exercise_answer.setForeground(Color.red);
				}else if(ex == 4){
					System.out.println(" ---in que 2");
					exercise = true;
					panel1.setVisible(false);
					panel2.setVisible(false);			
					panel3.setVisible(false);
					panel4.setVisible(true);
					panel5.setVisible(false);
					q4.clearSelection();
					fr_exercise_answer.setText(" ");
					q41.setSelected(false);
					q42.setSelected(false);
					q43.setSelected(false);
					q44.setSelected(false);
					fr_exercise_answer.setForeground(Color.red);
				}else if(ex == 5){
					System.out.println(" ---in que 2");
					exercise = true;
					panel1.setVisible(false);
					panel2.setVisible(false);			
					panel3.setVisible(false);
					panel4.setVisible(false);
					panel5.setVisible(true);
					q5.clearSelection();
					fr_exercise_answer.setText(" ");
					q51.setSelected(false);
					q52.setSelected(false);
					q53.setSelected(false);
					q54.setSelected(false);
					fr_exercise_answer.setForeground(Color.red);
				}else{
					fr_exercise_Message.setVisible(true);
					paneltemp.setVisible(true);
					
					fr_exercise_Message1.setVisible(true);
					fr_exercise_but1.setVisible(true);
					fr_exercise_but2.setVisible(true);
					fr_exercise_but3.setVisible(true);
					fr_exercise_but4.setVisible(true);
					fr_exercise_but5.setVisible(true);
					fr_exercise_answer.setVisible(true);
					
					panel1.setVisible(true);
				}
				
				
				
				
				
				
				
				
				
				
				/*fr_exercise_Message.setVisible(true);
				paneltemp.setVisible(true);
				fr_exercise_Message1.setVisible(true);
				fr_exercise_but1.setVisible(true);
				fr_exercise_but2.setVisible(true);
				fr_exercise_but3.setVisible(true);
				fr_exercise_but4.setVisible(false);
				fr_exercise_but5.setVisible(false);
				fr_exercise_answer.setVisible(true);
				
				panel1.setVisible(true);
				*/
			}else if(blLinks==true){
				fr_links_Message.setVisible(true);
				fr_links_Message1.setVisible(true);
				txtPane_ref.setVisible(true);
				//
			/*	opening_screen.setVisible(false);			
				opening_screen_logo.setVisible(false);
				opening_screen1.setVisible(false);
				lbl_openingscreen.setVisible(false);
				lbl_opening_screen_left.setVisible(false);
				opening_screen_message.setVisible(false);*/
			}
			
			
			
			//lbl_opening_screen_left.setVisible(false);
			//lblHeader_glossary.setVisible(false);
			//lblMessage_glossary.setVisible(false);
			//tblLeftIndex_glossary.setVisible(false);
			//txtPaneDescription_glossary.setVisible(false);
			//txtPane_Analogy.setVisible(false);
			//but_go_links.setVisible(true);
			//but_go1_links.setVisible(true);
			fr_credits.setVisible(true);
			txtPane_credits.setVisible(true);
			//repaint();
		}
		
		if(e.getSource()==fr_exercise_but1)
		{
			exercise = true;
			ex = 1;
			panel1.setVisible(true);
			panel2.setVisible(false);			
			panel3.setVisible(false);
			panel4.setVisible(false);			
			panel5.setVisible(false);
			q1.clearSelection();
			fr_exercise_answer.setText(" ");
			q11.setSelected(false);
			q12.setSelected(false);
			q13.setSelected(false);
			q14.setSelected(false);
			fr_exercise_but1.setBackground(frame3);
			fr_exercise_but2.setBackground(lightgrey);
			fr_exercise_but3.setBackground(lightgrey);
			fr_exercise_but4.setBackground(lightgrey);
			fr_exercise_but5.setBackground(lightgrey);
			fr_exercise_answer.setForeground(Color.red);
			//q13.setSelected(false);
			//q14.setSelected(false);
			repaint();
		}
		
		if(e.getSource()==fr_exercise_but2)
		{
			System.out.println(" in que 2");
			exercise = true;
			ex = 2;
			panel1.setVisible(false);
			panel2.setVisible(true);			
			panel3.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(false);
			q2.clearSelection();
			fr_exercise_but2.setBackground(frame3);
			fr_exercise_but1.setBackground(lightgrey);
			fr_exercise_but3.setBackground(lightgrey);
			fr_exercise_but4.setBackground(lightgrey);
			fr_exercise_but5.setBackground(lightgrey);
			fr_exercise_answer.setText(" ");
			q21.setSelected(false);
			q22.setSelected(false);
			//q23.setSelected(false);
			//q24.setSelected(false);
			fr_exercise_answer.setForeground(Color.red);
			repaint();
			
		}
		if(e.getSource()==fr_exercise_but3)
		{
			exercise = true;
			ex = 2;
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(true);
			panel4.setVisible(false);
			panel5.setVisible(false);			
			q3.clearSelection();
			fr_exercise_but3.setBackground(frame3);
			fr_exercise_but2.setBackground(lightgrey);
			fr_exercise_but1.setBackground(lightgrey);
			fr_exercise_but4.setBackground(lightgrey);
			fr_exercise_but5.setBackground(lightgrey);
			fr_exercise_answer.setText(" ");
			q31.setSelected(false);
			q32.setSelected(false);
			q33.setSelected(false);
			q34.setSelected(false);
			fr_exercise_answer.setForeground(Color.red);
			repaint();
		}
		
		if(e.getSource()==fr_exercise_but4)
		{
			exercise = true;
			ex = 4;
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(true);
			panel5.setVisible(false);
			q4.clearSelection();
			fr_exercise_but4.setBackground(frame3);
			fr_exercise_but2.setBackground(lightgrey);
			fr_exercise_but3.setBackground(lightgrey);
			fr_exercise_but1.setBackground(lightgrey);
			fr_exercise_but5.setBackground(lightgrey);
			fr_exercise_answer.setText(" ");
			q41.setSelected(false);
			q42.setSelected(false);
			q43.setSelected(false);
			q44.setSelected(false);
			fr_exercise_answer.setForeground(Color.red);
			repaint();
		}
		
		if(e.getSource()==fr_exercise_but5)
		{
			exercise = true;
			ex = 5;
			panel1.setVisible(false);
			panel2.setVisible(false);
			panel3.setVisible(false);
			panel4.setVisible(false);
			panel5.setVisible(true);
			q5.clearSelection();
			fr_exercise_but5.setBackground(frame3);
			fr_exercise_but2.setBackground(lightgrey);
			fr_exercise_but3.setBackground(lightgrey);
			fr_exercise_but4.setBackground(lightgrey);
			fr_exercise_but1.setBackground(lightgrey);
			fr_exercise_answer.setText(" ");
			q51.setSelected(false);
			q52.setSelected(false);
			q53.setSelected(false);
			q54.setSelected(false);
			fr_exercise_answer.setForeground(Color.red);
			repaint();
		}
		
		 if(e.getSource()== btnPlay) 
	 		{	
			 System.out.println(" in Play");
			 
			 	repaint();
			// 	myStart();
			
	 		}
		
		
		 if(e.getSource()== btnStop)
	 		{	
	 			repaint();
	 			myStop();
	 			
	 			
	 		}
		 if((e.getSource() == btnOption1)||(e.getSource() == btnOption2)||(e.getSource() == btnOption3)){
			 System.out.println(" btnOption3=++++++++++++++++++++++++++++++");
			 repaint();
		 }
		 if((e.getSource() == btnOption12)||(e.getSource() == btnOption22)||(e.getSource() == btnOption32)){
			 System.out.println(" btnOption32=++++++++++++++++++++++++++++++");
			 repaint();
		 }
		 
		 if(signal_one_selected&&signal_two_selected&&!visited)
		 {
		 	cb2.setEnabled(true);
		 	btnPlay.setEnabled(false);
		 	btnOption1.setVisible(false);
			btnOption2.setVisible(false);
			btnOption3.setVisible(false);
			btnOption12.setVisible(false);
			btnOption22.setVisible(false);
			btnOption32.setVisible(false);
			btnLabel1.setVisible(false);
			btnlabel2.setVisible(false);
		 	visited=true;
		 }
	}


public void FillHashMapObject()
{
	map = new HashMap();
	//map.put("0", "testing");
	
	map.put("0","Signal \n\n Any physical quantity that varies with time space, or any other variable."+ 
            "In signal processing, a time signal is electrical representation of a time varying quantity."); 
	map.put("1","Signal Transformation \n\n Arithmetic operations performed on signal amplitude or time that manipulate the signal.");
	map.put("2","Shifting \n\n The shifting of a signal in time.");
	map.put("3","Delaying \n\n Causing the signal to occur late (shift to right) by subtracting a positive constant from time parameter.");
	map.put("4","Advancing\n\n Causing the signal to occur early (shift to left) by adding a positive constant to time parameter.");
	map.put("5","Scaling\n\n Compressing or expanding a signal by multiplying the time variable by some quantity.");
	map.put("6","Compression\n\n Narrowing the signal in time, by multiplying time parameter by a positive constant grater than 1.");
	map.put("7","Expansion\n\n Widening the signal in time, by multiplying time parameter by a positive constant lower than 1.");
	map.put("8","Reversal\n\n Flipping the signal over amplitude axis by multiplying time parameter by -1.");

}



	public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
		 System.out.println(" selection box"+e.getItem());
		 if (exercise == true){
			 fr_exercise_answer.setFont(new Font("",Font.BOLD,16));
				fr_exercise_answer.setForeground(Color.red);
					if(e.getSource()==q11)		{
						
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
						
					}
					if(e.getSource()==q12)
					{
						fr_exercise_answer.setForeground(new Color(0x009900));
						fr_exercise_answer.setText("Correct");
					}
					if(e.getSource()==q13)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q14)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q21)
					{
						
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong.");
						
					}
					if(e.getSource()==q22)
					{
						fr_exercise_answer.setForeground(new Color(0x009900));
						fr_exercise_answer.setText("Correct");
						
					}
					if(e.getSource()==q23)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q24)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
						
					}
					if(e.getSource()==q31)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q32)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q33)
					{
						fr_exercise_answer.setForeground(new Color(0x009900));
						fr_exercise_answer.setText("Correct");
						
					}
					if(e.getSource()==q34)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q41)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q42)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q43)
					{
						fr_exercise_answer.setForeground(new Color(0x009900));
						fr_exercise_answer.setText("Correct");
						
					}
					if(e.getSource()==q44)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q51)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong.");
					}
					if(e.getSource()==q52)
					{

						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q53)
					{
						fr_exercise_answer.setForeground(Color.red);
						fr_exercise_answer.setText("Wrong");
					}
					if(e.getSource()==q54)
					{
						
						fr_exercise_answer.setForeground(new Color(0x009900));
						fr_exercise_answer.setText("Correct");
						
					}
		    }
		 /*	if(demo==true){
		    	if(e.getSource() == rb1){
		    		System.out.println(" in item stat change. method 1............");
		    		if(e.getStateChange() == ItemEvent.SELECTED){
		    			//methodFlag=0;
		    		}
		    	}
		    	
		    	if(e.getSource() == rb2){
		    		System.out.println(" in item stat change...method 2........");
		    		if(e.getStateChange() == ItemEvent.SELECTED){
		    			//methodFlag=1;
		    		}
		    	}
		    	
		   
		    }*/
} 
	
	public void myStart()
	{
		
		System.out.println("in mystart function");
		
		if (animator == null || ! animator.isAlive()) {  
			animator = new Thread(this);
			animator.start();
			animationrunning=true;
		}
		/*xpoints1 =  new double[] {305,305,405,405};
    	ypoints1 =  new double[] {235,185,185,235};
    	
    	xpoints2 = new double[] {130,130,155};
    	ypoints2 = new double[] {235,210,235};
		*/
		clearScreen=false;
		// added new below
		btnPlay.setVisible(false);
		btnPlay.setEnabled(false);
		btnPause.setVisible(true);
		btnPause.setEnabled(true);
		btnStop.setVisible(true);
		btnStop.setEnabled(true);
	}
	public void myPause(){
		
			stopf=!stopf;
			animator.suspend();
			if(stopf)
			{
				btnPause.setText("PLAY");
				btnPause.setToolTipText("Click Here To Play");
			}
			else if(!stopf)
			{
				animator.resume();
				btnPause.setText("PAUSE");
				btnPause.setToolTipText("Click Here To Pause");
			}
			btnPause.setVisible(true);
			btnPause.setEnabled(true);
			btnPlay.setVisible(false);
			btnPlay.setEnabled(false);
			btnStop.setEnabled(true);
		}
	
	/*public void start()
	{		
		super.start();
		container1.revalidate();		
	}*/
	
	public synchronized void myStop()
	{
		System.out.println(" in myStop function-----------");
		
		animator = null;
		notify();
		stopf=false;
		counter=0;
		
		if(demo == true){
		btnPlay.setEnabled(true);
		}else if(blInteraction==true){
			btnPlay.setEnabled(false);
		}
		btnPlay.setVisible(false);
		btnPause.setVisible(false);
		btnPause.setEnabled(false);
		animationrunning=false;
		btnLabel1.setVisible(true);
		btnlabel2.setVisible(true);
		//text_image.setVisible(false);
		//clearScreen = true;
		
		// reset the signals
		lbl_multSignal_image.setVisible(false);
		lbl_integrateSignal_image.setVisible(false);
		//counterj = 0;
		//counterk=0;
		option1 = 0;
		option2 = 0;
		//comboOption = 0;
		signal_one_selected = false;
		signal_two_selected = false;
		option1 = 0;
		visited=false;
		option2 = 0;
		//comboOption = 0;
		val = 0;
		y=350;
		y1 = 350;
		yval = 0;
		yval1 = 0;
		yval2 = 0;
		
		
		tempy = 0;temp  = 210;temp31 = 210; 
    	counteri = 0;
    	graphCounter = 0;
    	flagC = 0;
    	pix = 0;
    	i=0;ci=0;
    	equY=0;
    	timeShiftValue=0;
    	
    	
    	
    	xpoints1 =  new double[] {305,305,405,405};
    	ypoints1 =  new double[] {235,185,185,235};
    	
    	xpoints2 = new double[] {130,130,155};
    	ypoints2 = new double[] {235,210,235};
    	
    	xpointsArea = new double[] {305,305,305,305};
    	ypointsArea = new double[] {235+115,235+115,235+115,235+115};
    	
    	xpointsCircle = 305;
    	ypointsCircle = 500;
	
    	xpointsFinal = new double[] {305,305};
    	ypointsFinal =  new double[] {500,500};
    	
    	xpointsIntegrate = new double[250];
    	ypointsIntegrate= new double[250];
    	
    	for(int x = 0;x<250;x++){
    		xpointsIntegrate[x] = 305;// it was 0 before
    		ypointsIntegrate[x] = 500;// it was 0 before
    	}
    	
    	
	    	xpoints1O1 =  new double[] {355,355,380,380};//option2 = 1
	    	ypoints1O1 =  new double[] {235,210,210,235};
	    	
	    	xpoints2O1 = new double[] {550,550,575,575};//option1==1
	    	ypoints2O1 = new double[] {235,210,210,235};
	    	
	    	xpoints1O2 =  new double[] {355,355,380,380,405,405};//option2 = 2
	    	ypoints1O2 =  new double[] {235,260,260,210,210,235};
	    	
	    	xpoints2O2 = new double[] {130,130,155,155,180,180};//option1==2
	    	ypoints2O2 = new double[] {235,260,260,210,210,235};
	    	
	    	xpoints1O3 = new double[] {0,0,0,0,0,0,0,0,0,0,0,0,775};//option2 = 3
	    	ypoints1O3 = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,235};
	    	
	    	
	    	xpoints2O3 = new double[] {130,130,135,140,145,150,155,160,165,170,175,180,180};//option1==3 
	    	ypoints2O3 = new double[] {235,210,214.53,218.24,221.27,223.76,225.80,227.47,228.83,229.95,230.86,231.61,235};
			
			
	    	xpointsAreaI = new double[] {355,355,355,355};
	    	ypointsAreaI = new double[] {350,350,350,350};
			
	    	xpointsArea12 = new double[] {355,355,355,355,355,355,355};
	    	ypointsArea12 = new double[] {350,350,350,350,350,350,350};
	    	
	    	xpointsArea22 = new double[] {355,355,355,355,355,355,355,355};
	    	ypointsArea22 = new double[] {350,350,350,350,350,350,350,350};
	    	
	    	xpointsArea23 = new double[] {355,355,355,355,355,355,355,355,355,355};
	    	ypointsArea23 = new double[] {350,350,350,350,350,350,350,350,350,350};
    	
	    	
	    	//-----------------
	    	
	    	
	    	
			

			//xaxpoints1R = new int[] {630,760};// graph1 in right panel
			xaxpoints1R = new int[] {10,140};
	    	xaypoints1R = new int[] {235,235};

	    	//yaxpoints1R = new int[] {650,650};
			yaxpoints1R = new int[] {30,30};
	    	yaypoints1R = new int[] {135,250};
	    	
	    	//xaxpoints2R = new int[] {790,965};// graph2 in right panel
			xaxpoints2R = new int[] {200,375};
	    	xaypoints2R = new int[] {235,235};

	    	//yaxpoints2R = new int[] {885,885};
			yaxpoints2R = new int[] {295,295};
	    	yaypoints2R = new int[] {135,250};
	    	
	    	
	    	xpoints1R =  new double[] {835,835,935,935};
	    	ypoints1R =  new double[] {235,185,185,235};
	    	
	    	xpoints2R = new double[] {650,650, 675};
	    	ypoints2R = new double[] {235,210,235};	
	    	
	    	
	// right panel starts here
	    	//xaxpoints1 = new int[] {35,215};// graph1 in right panel
			xaxpoints1 = new int[] {455,735};
	    	xaypoints1 = new int[] {235,235};

	    	//yaxpoints1 = new int[] {130,130};
			yaxpoints1 = new int[] {550,550};
	    	yaypoints1 = new int[] {135,250};
	    	
	    	
	    	//xaxpoints2 = new int[] {235,540};// graph2 in right panel
			xaxpoints2 = new int[] {755,970};
	    	xaypoints2 = new int[] {235,235};

			//yaxpoints2 = new int[] {355,355};
			yaxpoints2 = new int[] {775,775};
	    	yaypoints2 = new int[] {135,250};
	    	
	    	System.out.println(" at the end of myStop function-----------");
	    	//--------------------
	    	repaint();
	}
	
	public void run()
	{
     
		if(demo == true) 
		{
			//numMove = 10;
			
			
				while (Thread.currentThread() == animator){
					while(animationrunning){	
						System.out.println(" inside while in run");
						try {
							
							
							if(stopf)
								break;
							
							
							next();
							
							
							animator.sleep(100);
							if(animationrunning == false){
							synchronized(this) {
			                    while (animationrunning==false)
			                        wait();
			                	}
							}
							counter++;
							
						} catch (InterruptedException e){}
				
						
					}// while	
				}//while
		}//demo
		else if(blInteraction==true)
		{
			
				while (Thread.currentThread() == animator)
				{
					while(animationrunning)
					{	
						System.out.println(" inside while in run in interaction");
						try 
						{
							if(stopf)
								break;
							next();
							System.out.println("counter:"+counter);
							animator.sleep(100);
							counter++;
							if(counter>31)
								break;
						} 
						catch (InterruptedException e){}
					}
					if(counter>31)
						{
							animator.suspend();
							myStop();
							cb4.setEnabled(false);
							repaint();
						}
				}//while
			
			
			
         }//end of if interaction
			
      
	}//end of run
	
	
	
	
	public void next()throws InterruptedException{
		
		if(counter ==0)
		{
			flagC = counter;
			for(int i = 0;i<10;i++){
				
				
				repaint();
				animator.sleep(200);
			}
		}
		if(counter ==1){
			flagC = counter;
			Graphics g = getGraphics(); 
			rotateFigure(g);
			System.out.println("MY GOD THIS IS IT....");
			try
			{
				Thread.sleep(1000);
			}
			catch(Exception eeeee){}
			System.out.println("ITS ALL OVER");
			
			btnPlay.setVisible(true);
			btnPlay.setEnabled(false);
			btnPause.setVisible(false);
			cb4.setEnabled(true);
			myPause();
		}
		if(counter ==2){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics();   
			for(int i = 0;i<10;i++){
				if(stopf)
					break;
				repaint();
				animator.sleep(200);
			}
		}
		if(counter ==3){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics(); 
			if(demo == true){
				timeShiftValue=4;
			}else if(blInteraction == true){
				if(option1 == 1){
					timeShiftValue=4;
				}else if(option1 == 2){
					timeShiftValue=4;
				}else if(option1 == 3){
					timeShiftValue=4;
				}
			}
			shiftFigure( g, timeShiftValue);
			//integrationFigure(g);
			for(int i = 0;i<10;i++){
				
				repaint();
				animator.sleep(200);
			}
		}
		if(counter==4){
			flagC = counter;
			graphCounter = 5;
			Graphics g = getGraphics(); 
			if(demo == true){
				timeShiftValue=3;
			}else if(blInteraction == true){
				if(option1 == 1){
					timeShiftValue=5;
				}else if(option1 == 2){
					timeShiftValue=5;
				}else if(option1 == 3){
					timeShiftValue=5;
				}
			}
			shiftFigure( g, timeShiftValue);
			System.out.println("flag = "+flagC+"counter = "+counter+" before draw area----------------");
			
			
			
			for(int i = 0;i<10;i++){
				
				
				repaint();
				animator.sleep(200);
			}
		}
		if(counter==5){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics(); 
			if(demo == true){
				timeShiftValue=.5;
			}else if(blInteraction == true){
				if(option1 == 1){
					timeShiftValue=.5;
				}else if(option1 == 2){
					timeShiftValue=.5;
				}else if(option1 == 3){
					timeShiftValue=.5;
				}
			}
			
			shiftFigure( g, timeShiftValue);
			System.out.println(" after shift---------------");
			
			
			
			for(int i = 0;i<10;i++){
				
				
				repaint();
				animator.sleep(200);
			}
			
		}
		if(counter ==6){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics();       
			timeShiftValue=.5;
			shiftFigure( g, timeShiftValue);
			System.out.println(" after shift---------------");
			for(int i = 0;i<10;i++){
				
				
				repaint();
				animator.sleep(200);
			}
			
		}
		if(counter==7){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics();     
			//timeShiftValue=2;
			
			if(demo == true){
				timeShiftValue= 2;
			}else if(blInteraction == true){
				if(option1 == 1){
					timeShiftValue=.5;
				}else if(option1 == 2){
					timeShiftValue=.5;
				}else if(option1 == 3){
					timeShiftValue=.5;
				}
			}
			
			
			shiftFigure( g, timeShiftValue);
			
		}
		
		
		if(counter==8){
			flagC = counter;
			
			Graphics g = getGraphics();   
			for(int i = 0;i<10;i++){
				
				
				repaint();
				animator.sleep(200);
			}
		}
		if(counter==9){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics();        
			//timeShiftValue=2;
			//timeShiftValue=1;
			if(demo == true){
				timeShiftValue= 1;
			}else if(blInteraction == true){
				if(option1 == 1){
					timeShiftValue=.5;
				}else if(option1 == 2){
					timeShiftValue=.5;
				}else if(option1 == 3){
					timeShiftValue=.5;
				}
			}
			
			
			shiftFigure( g, timeShiftValue);
			for(int i = 0;i<10;i++){
				
				
				repaint();
				animator.sleep(200);
			}
			
		}
		
		if(counter == 10){
			flagC = counter;
			Graphics g = getGraphics();
			timeShiftValue=.5;
			shiftFigure( g, timeShiftValue);
			for(int i = 0;i<10;i++){
				
				
				repaint();
				animator.sleep(200);
			}
				
			
		}
		if(counter==11){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics();        
			//timeShiftValue=1.5;
			timeShiftValue=.5;
			shiftFigure( g, timeShiftValue);
			//drawArea(g);
			for(int i = 0;i<10;i++){
				
				
				repaint();
				animator.sleep(200);
			}
				
		}
		if(counter == 12){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics(); 
			
			if(demo == true){
				timeShiftValue=1;
			}else if(blInteraction == true){
				if(option1 == 1){
					timeShiftValue=.5;
				}else if(option1 == 2){
					timeShiftValue=.5;
				}else if(option1 == 3){
					timeShiftValue=.5;
				}
			}
			
			
			shiftFigure( g, timeShiftValue);
			for(int i = 0;i<10;i++){
				
				repaint();
				animator.sleep(200);
			}
		}
		if(counter==13){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics();  
			

			if(demo == true){
				//timeShiftValue=1;
			}else if(blInteraction == true){
				
				if(option1 == 3){
					timeShiftValue=.5;
				}
			}
			
			
			shiftFigure( g, timeShiftValue);
			
			
			
			for(int i = 0;i<10;i++){
				
				repaint();
				animator.sleep(200);
			}
		}
		
		if(counter==14){
			flagC = counter;
			System.out.println("flag = "+flagC+"counter = "+counter);
			Graphics g = getGraphics();  
			

			if(demo == true){
				//timeShiftValue=1;
			}else if(blInteraction == true){
				
				if(option1 == 3){
					timeShiftValue=1;
				}
			}
			
			
			shiftFigure( g, timeShiftValue);
			
			
			
			for(int i = 0;i<10;i++){
				repaint();
				animator.sleep(200);
			}
		}
		
		
		
	}// end of function
	
	public void buttons() throws InterruptedException
	{
		try
		{
			
			table.enable(false);
			blPHY_MEMcheck=false;
			blPAGETABLEcheck=false;
			blSEC_MEMcheck=false;	
			interaction_incr=0;		
			//t_demo=null;
			//t_interaction=new Thread(this);
		    //t_interaction.start();
		}
		catch(Exception e)
		{
			
		}
	}
	
	
	public void stop()
	{
		
		System.out.println(" min stop function------------------------");
		current = null;	
		
		// counter = 0;
		container1.removeAll();

	}	
	
	// calculate the y coordinate for initail values of signal for t=1,2 and 3
	 public double x(double t){
		 if(t<0){
			 return 0;
		 }
		 else if(t>3){
			 return 0;
		 }
		 else {
			 return t-2;
		 }
		
	}
	 
	// equation used to draw the graph
	// calculates y coordinates for different values of t depending upon the values of a, b ,c and k
	 // ax(kbt-c); bt is for slope, a amplitude c for shifting k is reversal
	 public double y(double a, double b,double k, double c, double t){
		 // equationis ax(kbt-c) where 
		 // a = amplitude; b = scaling
		 // c = shifting; k = reversal
		 double output;
		 double temp;
		 temp = (k*b*t)-c;
		  output = a*temp;
		 return output;
	 }
	 
	public void disableSelection(){
		// disable the selected options
	/**/
	}

	public void mouseReleased(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	

	public void mouseClicked(MouseEvent me)
	{		
		Point point= new Point(me.getX(),me.getY());
		showStatus("x1 : "+point.x+"   y1 :"+point.y);
		System.out.println(point.x);	
	}
	
	// for glossary table
	public void tblLeftIndexMouseClicked(MouseEvent evt) {
		//txtPaneDescription_glossary.setText(map.get(tblLeftIndex_glossary.getSelectedRow()).toString());
		txtPaneDescription_glossary.setText(map.get(String.valueOf(tblLeftIndex_glossary.getSelectedRow())).toString());
	}
	// draw graph
	public void drawGraph(Graphics g, int[] xx1,int[] xy1,int[] yx1,int[] yy1){
		g.setColor(Color.LIGHT_GRAY);		
		g.drawPolyline(xx1,xy1,2);
		g.drawPolyline(yx1,yy1,2);
		
		
		
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Arial",Font.BOLD,12));
		
      		//g.drawString("TIME (t) ---->",145,365);
      		g.setFont(new Font("Arial",Font.PLAIN,12));
      		int a=0;
      		if(graphCounter==1){
      			a=-5;
      		}
      		if(graphCounter==2){
      			a=-3;
      		}
      		if(graphCounter == 5){
      			a = -4;
      		}
      		if(graphCounter ==6){
      			 a = -12;
      		}
      		if(graphCounter == 7){
      			a = -12;
      		}
      		for(int i=xx1[0]+19;i<=xx1[1];i=i+25)
      		{
      			if(graphCounter==5){
      				//System.out.println("graph counter=5------------------"+a);
      				g.drawString("|",i,xy1[0]+5 );
          			g.setColor(Color.LIGHT_GRAY);
          			if((a==-2)||(a==2)){
          				//System.out.println("graph counter=5---in if loop---------------"+a);
          				g.drawString(""+a,i,xy1[0]+13);
          			}else{
          				//System.out.println("graph counter=5---in else loop---------------"+a);
          				g.drawString("",i,xy1[0]+13);	
          			}
          			//System.out.println("val of a=== = "+a);
          			//g.drawString("0",i,xy1[0]+13);
          			//a++;
      			}else if((graphCounter ==6)||(graphCounter==7)){
      				g.drawString("|",i,xy1[0]+5 );
          			g.setColor(Color.LIGHT_GRAY);
          			if((a==-2)||(a==2)){
          				//System.out.println("graph counter=5---in if loop---------------"+a);
          				g.drawString(""+a,i,xy1[0]+13);
          			}else{
          				//System.out.println("graph counter=5---in else loop---------------"+a);
          				g.drawString("",i,xy1[0]+13);	
          			}
      			}
      			else{
      			g.drawString("|",i,xy1[0]+5 );
      			g.setColor(Color.LIGHT_GRAY);
      			g.drawString(""+a,i,xy1[0]+13);
      			//a++;
      			}
      			a++;
      		}
      		//g.setFont(new Font("Arial",Font.BOLD,12));
      		//g.drawString("X(t) ",95,150);
      		g.setFont(new Font("Arial",Font.PLAIN,12));
      		g.setColor(Color.LIGHT_GRAY);
      		//System.out.println("xx1[3]="+xx1[3]+"xy1[3]="+xy1[3]);
      		//g.drawString("Time(n)--->", xx1[3], (xy1[3]+50));
      		
      		
      		a=0;
      		
      		for(int i=xy1[0]-1;i>=yy1[0];i=i-25)
      		{
      		
      			g.drawString("__",yx1[0]-5,i );

      			if(a==0)
      			{
      				g.drawString("",yx1[0]+8,i);
      				
      					a++;
      			}else{
      				g.setColor(Color.LIGHT_GRAY);
      				
      				//System.out.println("--------------a="+a);
      				g.drawString(""+a,yx1[0]+6,i);
      				a++;
      				
      			
      			}
      		}
      		
      		g.setFont(new Font("Arial",Font.BOLD,10));
      		if(graphCounter==2){
      			g.drawString("TIME (t) --->",xx1[0]+125,xy1[0]+28);
      		}else if(graphCounter==1){
      			g.drawString("TIME (t) --->",xx1[0]+250,xy1[0]+28);
      		}else if(graphCounter ==6){
      			g.drawString("TIME (t) --->",xx1[0]+450,xy1[0]+28);
      		}
      		else if(graphCounter ==5){
      			g.drawString("TIME (t) --->",xx1[0]+275,xy1[0]+28);
      		}
      		else if(graphCounter ==7){
      			g.drawString("TIME (",xx1[0]+450,xy1[0]+28);
      			drawTau(g,xx1[0]+484,xy1[0]+20);
      			g.drawString(") --->",xx1[0]+495,xy1[0]+28);
      		}
      		else{
      			g.drawString("TIME (t) --->",xx1[0]+75,xy1[0]+28);
      		}	
      		
      		
	}
	public void drawTau( Graphics g,int x,int y){
		
		g.drawLine(x,y,x-2,y+2);
		g.drawLine(x,y,x+6,y);		
		//g.drawArc(x+1,y,7,13,90,230);
		g.drawArc(x+1,y,4,8,90,230);
	}
	
	
	
	

	/*
	void drawSigma(Graphics g,int x1,int y1){
		
  		
  		g.drawLine(x1+20,y1,x1+20,y1+3);
		g.drawLine(x1,y1,x1+20,y1);
  		g.drawLine(x1,y1,x1+15,y1+20);
  		g.drawLine(x1+15, y1+20, x1,y1+40);
  		g.drawLine(x1,y1+40,x1+20,y1+40);
  		g.drawLine(x1+20,y1+40,x1+20,y1+37);
  		//drawSigma(g,800,360);
		
  		
	}
	*/
	
	
	public void rotateFigure(Graphics g){
		 g = getGraphics();   
		equY = y( 1,  1, -1,  0, 1);
		System.out.println("equY = "+equY);
		double j = 0;
		
		double k = 25*equY;
		System.out.println("k="+k);
		j = (k-25)/10;
		
		System.out.println("j="+j+"numMove = "+numMove+" option2 = "+option2);
		for(int i = 0;i< numMove;i++){
			
			if(demo == true){
				System.out.println(" in demo rotate---------------------");
			/*xpoints1[0] = xpoints1[0] - j;
			xpoints1[1] = xpoints1[1] - j;
			xpoints1[2] = xpoints1[2] + j;
			xpoints1[3] = xpoints1[3] + j;*/
			xpoints2[2] = xpoints2[2]+j;
				
			}
			else if(blInteraction == true){
				if(option1 == 1){
					System.out.println(" in option 2 rotate---------------------");
					//xpoints2[0] = xpoints2[0] - j;
					//xpoints2[1] = xpoints2[1] - j;
					xpoints2O1[2] = xpoints2O1[2] + j;
					xpoints2O1[3] = xpoints2O1[3] + j;
				}
				else if(option1 == 2){
					//xpoints2[0] = xpoints2[0] - j;
					//xpoints2[1] = xpoints2[1] - j;
					xpoints2O2[2] = xpoints2O2[2] + j;
					xpoints2O2[3] = xpoints2O2[3] + j;
					xpoints2O2[4] = xpoints2O2[4] + 2*j;
					xpoints2O2[5] = xpoints2O2[5] + 2*j;
				}
				else  if(option1 == 3){
					/*xpoints2O3[2] = xpoints2O3[2] + j*.2;
					xpoints2O3[3] = xpoints2O3[3] + j*.4;
					xpoints2O3[4] = xpoints2O3[4] + j*.6;
					xpoints2O3[5] = xpoints2O3[5] + j*1;
					xpoints2O3[6] = xpoints2O3[6] + j*1.4;
					xpoints2O3[7] = xpoints2O3[7] + 1.8*j;
					//xpoints2O3[8] = xpoints2O3[8] + 2*j;
					*/
					/*xpoints2O3[2] = xpoints2O3[2] + j*.2;
					xpoints2O3[3] = xpoints2O3[3] + j*.6;
					xpoints2O3[4] = xpoints2O3[4] + j*1;
					xpoints2O3[5] = xpoints2O3[5] + j*1.4;
					xpoints2O3[6] = xpoints2O3[6] + j*1.8;
					xpoints2O3[7] = xpoints2O3[7] + 2*j;
					*/
					xpoints2O3[2] = xpoints2O3[2] + j*.2;
					xpoints2O3[3] = xpoints2O3[3] + j*.4;
					xpoints2O3[4] = xpoints2O3[4] + j*.6;
					xpoints2O3[5] = xpoints2O3[5] + j*.8;
					xpoints2O3[6] = xpoints2O3[6] + j*1;
					xpoints2O3[7] = xpoints2O3[7] + j*1.2;
					xpoints2O3[8] = xpoints2O3[8] + j*1.4;
					xpoints2O3[9] = xpoints2O3[9] + j*1.6;
					xpoints2O3[10] = xpoints2O3[10] + j*1.8;
					xpoints2O3[11] = xpoints2O3[11] + j*2;
					xpoints2O3[12] = xpoints2O3[12] + j*2;
					
					
				}
			}
			//Graphics g = getGraphics();   
			
			repaint();
			try {
		        animator.sleep(100);
		        if(animationrunning == false){
					try {
						synchronized(this) {
		                    while (animationrunning==false)
		                       wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (InterruptedException e){}
		            				
			
			        
		}//for
	}
	public void shiftFigure(Graphics g,double timeShiftValue){
		equY = y( 1,  1, 1,  timeShiftValue, 1);
		//System.out.println("equY = "+equY);
		double j = 0;
		//System.out.println("timeShiftValue in run="+timeShiftValue);
		
		double k = 25*timeShiftValue;
		//System.out.println("k="+k);
		
		j = (k)/10;
		//System.out.println("j="+j+"numMove = "+numMove);
		for(int i = 0;i< numMove;i++){
			
			if(demo == true){
				for(int incr = 0;incr<xpoints2.length;incr++){

					xpoints2[incr] = xpoints2[incr] + j;
					System.out.println("------"+xpoints2[incr]);
					
				}
				drawArea(g);
				integrationFigure(g);
			}else if(blInteraction==true){
				if(option1 ==1){
					for(int incr = 0;incr<xpoints2O1.length;incr++){
						xpoints2O1[incr] = xpoints2O1[incr] + j;
						System.out.println("------"+xpoints2O1[incr]);
						
					}
					if(option2 == 1){
						System.out.println(" both are square pulse");
						drawArea_interact11(g,xpoints2O1,ypoints2O1);
						integrationFigure_interaction(g,xpoints2O1,ypoints2O1);
					}else if(option2 == 2){
						System.out.println(" one square and one double square pulse");
						drawArea_interact12(g,xpoints2O1,ypoints2O1);
						integrationFigure_interaction(g,xpoints2O1,ypoints2O1);
					}
					else if(option2 == 3){
						drawArea_interact13(g,xpoints2O1,ypoints2O1);
						integrationFigure_interaction(g,xpoints2O1,ypoints2O1);
					}
				}else if(option1 == 2){
					System.out.println(" in option 2--------------------------shift"+xpoints2O2.length);
					for(int incr = 0;incr<xpoints2O2.length;incr++){
						xpoints2O2[incr] = xpoints2O2[incr] + j;
						System.out.println("------"+xpoints2O2[incr]);
						
					}
					if(option2 == 1){
						System.out.println(" one square and one double square pulse---");
						drawArea_interact21(g,xpoints2O2,ypoints2O2);
						integrationFigure_interaction(g,xpoints2O2,ypoints2O2);
					}else if(option2 == 2){
						System.out.println(" both are double square pulse");
						drawArea_interact22(g,xpoints2O2,ypoints2O2);
						integrationFigure_interaction(g,xpoints2O2,ypoints2O2);
					}
					else if(option2 == 3){
						drawArea_interact23(g,xpoints2O2,ypoints2O2);
						integrationFigure_interaction(g,xpoints2O2,ypoints2O2);
					}
				}else if(option1 == 3){
					for(int incr = 0;incr<xpoints2O3.length;incr++){
						xpoints2O3[incr] = xpoints2O3[incr] + j;
						System.out.println("------"+xpoints2O3[incr]);
						
					}
					if(option2 == 1){
						System.out.println(" one square and one double square pulse---");
						drawArea_interact31(g,xpoints2O3,ypoints2O3);
						integrationFigure_interaction(g,xpoints2O3,ypoints2O3);
					}else if(option2 == 2){
						System.out.println(" both are double square pulse");
						drawArea_interact32(g,xpoints2O3,ypoints2O3);
						integrationFigure_interaction(g,xpoints2O3,ypoints2O3);
					}
					else if(option2 == 3){
						drawArea_interact33(g,xpoints2O3,ypoints2O3);
						integrationFigure_interaction(g,xpoints2O3,ypoints2O3);
					}
				}
				
			}
			
			g = getGraphics(); 
			repaint();
			try {
		        animator.sleep(100);
		        if(animationrunning == false){
					try {
						synchronized(this) {
		                    while (animationrunning==false)
		                       wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (InterruptedException e){}
		         
			
			
			ci = i;        
		}//for
		
		
	}
	
	public void integrationFigure(Graphics g){
		int a = 265;
		//double pix = 1.25;
		double t=-2+pix;
		double res = 0;
		double y = 235+a;
		double temp1=305,temp2=235+a;
		
		
		System.out.println("inside integration figure-----------counteri = "+counteri);
		//for(int c = 0;c<xpointsIntegrate.length;c++){
			//System.out.println(" xpointsIntegrate[c] = "+xpointsIntegrate[c]+"ypointsIntegrate[c]="+ypointsIntegrate[c]);
		//}
		
		//for(int i = 305;i<455;i++){
		System.out.println(" temp1 = "+temp1+"xpoints2[0] ="+xpoints2[0]);
		if((int)xpoints2[0] == 305){
				//System.out.println("<305--xpointsFinal[0] = "+xpointsFinal[0]+"ypointsFinal[0]="+ypointsFinal[0]);
				//System.out.println("<305--xpointsFinal[1] = "+xpointsFinal[1]+"ypointsFinal[1]="+ypointsFinal[1]);
				
				System.out.println(" temp1 = "+temp1+"xpoints2[0] ="+xpoints2[0]+"t = "+t+" counter = ========"+counter);
				
				xpointsFinal[0] = temp1;
				ypointsFinal[0] = temp2;
				xpointsFinal[1] = xpoints2[0];
				ypointsFinal[1] = 235+a;
				//temp1 = xpointsFinal[1];
				//temp2 = ypointsFinal[1];
				xpointsIntegrate[counter] = xpointsFinal[0];
				ypointsIntegrate[counter] = ypointsFinal[0];
				xpointsCircle =xpointsIntegrate[counter];
				ypointsCircle = ypointsIntegrate[counter];
				t++; counteri++;
				//pix = pix+.1;
				pix = pix+.05;
				xpointsIntegrate[counteri] = xpointsFinal[1];
				ypointsIntegrate[counteri] = ypointsFinal[1];
				xpointsCircle =xpointsIntegrate[counteri];
				ypointsCircle = ypointsIntegrate[counteri];
			}
		
			else if(((int)xpoints2[0]>305)&&((int)xpoints2[0]<=318)){
				System.out.println("xpoints2[0] ="+xpoints2[0]);
				System.out.println(">305- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				//System.out.println("<318--xpointsFinal[1] = "+xpointsFinal[1]+"ypointsFinal[1]="+ypointsFinal[1]);
				System.out.println( "xpoints2[0] ="+xpoints2[0]+"t = "+t+"pix = "+pix);
				res = -(t*t)-2*t;
				//y = 475;
				//res = ypointsIntegrate[counteri]-2.5;
				t++;counteri++;
				pix = pix+.05;
				
				xpointsIntegrate[counteri] = xpoints2[0];
				ypointsIntegrate[counteri] = y-res*25;
				xpointsCircle =xpointsIntegrate[counteri];
				ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">305- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
			/*	xpointsFinal[0] = temp1;
				ypointsFinal[0] = temp2;
				xpointsFinal[1] = xpoints2[0];
				ypointsFinal[1] = y-(res*25);
				temp1 = xpointsFinal[1];
				temp2 = ypointsFinal[1];
				xpointsIntegrate[counter] = xpointsFinal[1];
				ypointsIntegrate[counter] = ypointsFinal[1];
				*/
			}
			else if(((int)xpoints2[0]>318)&&((int)xpoints2[0]<=330)){
				System.out.println("xpoints2[0] ="+xpoints2[0]);
				System.out.println(">305- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				//System.out.println("<318--xpointsFinal[1] = "+xpointsFinal[1]+"ypointsFinal[1]="+ypointsFinal[1]);
				System.out.println( "xpoints2[0] ="+xpoints2[0]+"t = "+t+"pix = "+pix);
				res = -(t*t)-2*t;
				//y = 475;
				//res = ypointsIntegrate[counteri]-2.5;
				t++;counteri++;
				pix = pix+.05;
				
				xpointsIntegrate[counteri] = xpoints2[0];
				ypointsIntegrate[counteri] = y-res*25;
				xpointsCircle =xpointsIntegrate[counteri];
				ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">305- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
			/*	xpointsFinal[0] = temp1;
				ypointsFinal[0] = temp2;
				xpointsFinal[1] = xpoints2[0];
				ypointsFinal[1] = y-(res*25);
				temp1 = xpointsFinal[1];
				temp2 = ypointsFinal[1];
				xpointsIntegrate[counter] = xpointsFinal[1];
				ypointsIntegrate[counter] = ypointsFinal[1];
				*/
			}
		
			else  if(((int)xpoints2[0] > 330)&&((int)xpoints2[0]<=405)){
				 System.out.println( "xpoints2[0] ="+xpoints2[0]+"t = "+t);
				 System.out.println(">330- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				//System.out.println("<405--xpointsFinal[1] = "+xpointsFinal[1]+"ypointsFinal[1]="+ypointsFinal[1]);
				//System.out.println(" temp1 = "+temp1+"xpoints2[0] ="+xpoints2[0]+"t = "+t);
				//xpointsFinal[0] = temp1;
				//ypointsFinal[0] = temp2;
				//xpointsFinal[1] = xpoints2[0];
				res = 1;
				pix = 0;
				//ypointsFinal[1] = y-(res*25);
				//temp1 = xpointsFinal[1];
				//temp2 = ypointsFinal[1];
				t++;counteri++;
				xpointsIntegrate[counteri] = xpoints2[0];
				ypointsIntegrate[counteri] = y-res*25;
				xpointsCircle =xpointsIntegrate[counteri];
				ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">330- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				if((int)xpoints2[0]== 405){
					pix = .05;
				}
			}
			//else  if(((int)xpoints2[0]>405)&&((int)xpoints2[2]<=405)){
			else  if(((int)xpoints2[0]>405)&&((int)xpoints2[0]<=418)){
				 System.out.println(">405- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
				 t = 2+pix;
				 System.out.println(">405 point2 --t= "+t+"pix = "+pix);
				 res = t*t-6*t+9;
				 System.out.println(" res = "+res);
				 System.out.println(">405 after point2 --t= "+t+"pix = "+pix+"counteri = "+counteri);
				//xpointsFinal[0] = temp1;
				//ypointsFinal[0] = temp2;
				//xpointsFinal[1] = xpoints2[0];
				//ypointsFinal[1] = y-(res*25);
				//temp1 = xpointsFinal[1];
				//temp2 = ypointsFinal[1];
				
				t++;counteri++;
				pix = pix+.05;
				xpointsIntegrate[counteri] = xpoints2[0];
				 if((int)res == 1){
					 ypointsIntegrate[counteri] = 475*res;
				 }else{
					 ypointsIntegrate[counteri] = ypointsIntegrate[counteri-1]+(res*4);
				 }
				 
				 xpointsCircle =xpointsIntegrate[counteri];
					ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">405- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
			}
			else  if(((int)xpoints2[0]>418)&&((int)xpoints2[0]<=430)){
				 System.out.println(">418- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				 
				 t = 2+pix;
				 System.out.println(">418 point2 --t= "+t+"pix = "+pix);
				 res = t*t-6*t+9;
				 System.out.println(" res = "+res);
				 System.out.println(">418 after point2 --t= "+t+"pix = "+pix+"counteri = "+counteri);
				//xpointsFinal[0] = temp1;
				//ypointsFinal[0] = temp2;
				//xpointsFinal[1] = xpoints2[0];
				//ypointsFinal[1] = y-(res*25);
				//temp1 = xpointsFinal[1];
				//temp2 = ypointsFinal[1];
				
				t++;counteri++;
				pix = pix+.05;
				xpointsIntegrate[counteri] = xpoints2[0];
				
					 ypointsIntegrate[counteri] = ypointsIntegrate[counteri-1]+(res*4);
					 xpointsCircle =xpointsIntegrate[counteri];
						ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">405- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
			}
			else if((int)xpoints2[0]>430){
				 
				//System.out.println(">405--xpointsFinal[1] = "+xpointsFinal[1]+"ypointsFinal[1]="+ypointsFinal[1]);
				//xpointsFinal[0] = temp1;
				//ypointsFinal[0] = temp2;
				//xpointsFinal[1] = xpoints2[0];
				//ypointsFinal[1] = 235+a;
				counteri++;
				xpointsIntegrate[counteri] = xpoints2[0];;
				ypointsIntegrate[counteri] = 235+a;
				xpointsCircle =xpointsIntegrate[counteri];
				ypointsCircle = ypointsIntegrate[counteri];
				System.out.println("> both  405 after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
			}
		//}
	}
 
	public void integrationFigure_interaction(Graphics g,double[] xpoints,double[] ypoints){
		int a = 265;
		//double pix = 1.25;
		double t=pix;
		double res = 0;
		double y = 235+a;
		double temp1=775,temp2=235+a;
		
		
		System.out.println("inside integration figure-----------counteri = "+counteri);
		
		System.out.println(" temp1 = "+temp1+"xpoints[0] ="+xpoints[0]);
		if((int)xpoints[0] == 775){
				//System.out.println("<305--xpointsFinal[0] = "+xpointsFinal[0]+"ypointsFinal[0]="+ypointsFinal[0]);
				//System.out.println("<305--xpointsFinal[1] = "+xpointsFinal[1]+"ypointsFinal[1]="+ypointsFinal[1]);
				
				System.out.println(" temp1 = "+temp1+"xpoints[0] ="+xpoints[0]+"t = "+t);
				
				xpointsFinal[0] = temp1;
				ypointsFinal[0] = temp2;
				xpointsFinal[1] = xpoints[0];
				ypointsFinal[1] = 235+a;
				//temp1 = xpointsFinal[1];
				//temp2 = ypointsFinal[1];
				xpointsIntegrate[counter] = xpointsFinal[0];
				ypointsIntegrate[counter] = ypointsFinal[0];
				xpointsCircle =xpointsIntegrate[counter];
				ypointsCircle = ypointsIntegrate[counter];
				t++;
				counteri++;
				//pix = pix+.1;
				pix = pix+.05;
				xpointsIntegrate[counteri] = xpointsFinal[1];
				ypointsIntegrate[counteri] = ypointsFinal[1];
				xpointsCircle =xpointsIntegrate[counteri];
				ypointsCircle = ypointsIntegrate[counteri];
			}
		
			else if(((int)xpoints[0]>775)&&((int)xpoints[0]<=800)){
				System.out.println("xpoints[0] ="+xpoints[0]);
				System.out.println(">305- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				//System.out.println("<318--xpointsFinal[1] = "+xpointsFinal[1]+"ypointsFinal[1]="+ypointsFinal[1]);
				System.out.println( "xpoints[0] ="+xpoints[0]+"t = "+t+"pix = "+pix);
				if((option1 == 1)&&(option2 == 1)){
					res = t;
				}
				else if((option1 ==  1)&&(option2 == 2)){
					res = -t;
				}
				else if((option1 ==  1)&&(option2 == 3)){
					res = 1-Math.exp(-t);
				}
				else if((option1 == 2)&&(option2 == 1)){
					res = -t;
				}
				else if((option1 == 2)&&(option2 == 2)){
					res = t;
				}
				else if((option1 == 2)&&(option2 == 3)){
					res = Math.exp(-t)-1;
				}else if((option1 ==  3)&&(option2 == 1)){
					res = 1-Math.exp(-t);
				}else if((option1 == 3)&&(option2 == 2)){
					res = Math.exp(-t)-1;
				}
				else if((option1 == 3)&&(option2 == 3)){
					res = t*Math.exp(-t);
				}
				//y = 475;
				//res = ypointsIntegrate[counteri]-2.5;
				t++;
				counteri++;
				if((int)xpoints[0]==800){
					pix  = 1;
				}else
					pix = pix+.05;
				
				xpointsIntegrate[counteri] = xpoints[0];
				ypointsIntegrate[counteri] = y-res*25;
				xpointsCircle =xpointsIntegrate[counteri];
				ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">305- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
			/*	xpointsFinal[0] = temp1;
				ypointsFinal[0] = temp2;
				xpointsFinal[1] = xpoints2[0];
				ypointsFinal[1] = y-(res*25);
				temp1 = xpointsFinal[1];
				temp2 = ypointsFinal[1];
				xpointsIntegrate[counter] = xpointsFinal[1];
				ypointsIntegrate[counter] = ypointsFinal[1];
				*/
			}
			else if(((int)xpoints[0]>800)&&((int)xpoints[0]<=825)){
				System.out.println("xpoints[0] ="+xpoints[0]);
				System.out.println(">305- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				//System.out.println("<318--xpointsFinal[1] = "+xpointsFinal[1]+"ypointsFinal[1]="+ypointsFinal[1]);
				System.out.println( "xpoints[0] ="+xpoints[0]+"t = "+t+"pix = "+pix);
				if((option1 == 1)&&(option2 == 1)){
					res = -t+2;
				}else if((option1 == 1)&&(option2 == 2)){
					res = 2*t-3;
				}else if((option1 == 1)&&(option2 == 3)){
					res = Math.exp(-t)*(Math.exp(1)-1);
				}
				else if((option1 == 2)&&(option2 == 1)){
					res = 2*t-3;
				}
				else if((option1 == 2)&&(option2 == 2)){
					res = -2*t+3;
				}
				else if((option1 == 2)&&(option2 == 3)){
					res = 1+Math.exp(-t)-(2*Math.exp(-t+1));
				}else if((option1 == 3)&&(option2 == 1)){
					res = Math.exp(-t)*(Math.exp(1)-1);
				}else if((option1 == 3)&&(option2 == 2)){
					res = 1+Math.exp(-t)-(2*Math.exp(-t+1));
				}
				else if((option1 == 3)&&(option2 == 3)){
					res = t*Math.exp(-t);
				}
				System.out.println(" Res = "+res);
				//y = 475;
				//res = ypointsIntegrate[counteri]-2.5;
				t++;
				counteri++;
				pix = pix+.05;
				
				xpointsIntegrate[counteri] = xpoints[0];
				ypointsIntegrate[counteri] = y-res*25;
				xpointsCircle =xpointsIntegrate[counteri];
				ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">305- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
			
			}
		
			else  if(((int)xpoints[0] > 825)&&((int)xpoints[0]<=850)){
				 System.out.println( "xpoints[0] ="+xpoints[0]+"t = "+t);
				 System.out.println(">330- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				//System.out.println("<405--xpointsFinal[1] = "+xpointsFinal[1]+"ypointsFinal[1]="+ypointsFinal[1]);
				//System.out.println(" temp1 = "+temp1+"xpoints2[0] ="+xpoints2[0]+"t = "+t);
				//xpointsFinal[0] = temp1;
				//ypointsFinal[0] = temp2;
				//xpointsFinal[1] = xpoints2[0];
				 if((option1 == 1)&&(option2 == 1)){
					 res = 0;
				 }else if((option1 == 1)&&(option2 == 2)){
					 res = -t+3;
					 t++;
					pix = pix+.05;
				 }else if((option1 == 1)&&(option2 == 3)){
					 res = Math.exp(-t)*(Math.exp(1)-1);
					 t++;
					pix = pix+.05;
				 }
				 else if((option1 == 2)&&(option2 == 1)){
					 res = -t+3;
					 t++;
					pix = pix+.05;
				 }
				 else if((option1 == 2)&&(option2 == 2)){
					 res = 2*t-5;
					 t++;
					pix = pix+.05;
					}
				 else if((option1 == 2)&&(option2 == 3)){
					 res = Math.exp(-t)+Math.exp(-t+2)-(2*Math.exp(-t+1));
					 t++;
					pix = pix+.05;
					}else if((option1 == 3)&&(option2 == 1)){
						 res = Math.exp(-t)*(Math.exp(1)-1);
						 t++;
						pix = pix+.05;
					 }
				else if((option1 == 3)&&(option2 == 2)){
						 res = Math.exp(-t)+Math.exp(-t+2)-(2*Math.exp(-t+1));
						 t++;
						pix = pix+.05;
						}
				else if((option1 == 3)&&(option2 == 3)){
					res = t*Math.exp(-t);
					 t++;
					pix = pix+.05;
				}
				//pix = pix+.05;;
				//ypointsFinal[1] = y-(res*25);
				//temp1 = xpointsFinal[1];
				//temp2 = ypointsFinal[1];
			//	t++;
				counteri++;
				//pix = pix+.05;
				xpointsIntegrate[counteri] = xpoints[0];
				ypointsIntegrate[counteri] = y-res*25;
				xpointsCircle =xpointsIntegrate[counteri];
				ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">330- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
			}
			else  if(((int)xpoints[0]>850)&&((int)xpoints[0]<= 875)){
				 System.out.println(">405- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
				// t = 2+pix;
				 System.out.println(">405 point2 --t= "+t+"pix = "+pix);
				 if((option1 == 2)&&(option2 == 2)){
					 res = -t+4;
					 t++;
					pix = pix+.05;
				}else if((option1 == 2)&&(option2 == 3)){
					 res = Math.exp(-t)+Math.exp(-t+2)-(2*Math.exp(-t+1));;
					 t++;
					pix = pix+.05;
				}
				else if((option1 == 3)&&(option2 == 2)){
					 res = Math.exp(-t)+Math.exp(-t+2)-(2*Math.exp(-t+1));;
					 t++;
					pix = pix+.05;
				}
				else if((option1 == 3)&&(option2 == 3)){
					res = t*Math.exp(-t);
					 t++;
					pix = pix+.05;
				}
				 else{
				 res = 0;
				}
				 System.out.println(" res = "+res);
				 System.out.println(">405 after point2 --t= "+t+"pix = "+pix+"counteri = "+counteri);
				
				//t++;
				 counteri++;
				//pix = pix+.05;
				xpointsIntegrate[counteri] = xpoints[0];
				 
				ypointsIntegrate[counteri] = y-res*25;
				 
				 
				 xpointsCircle =xpointsIntegrate[counteri];
					ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">405- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
			}
			//else  if(((int)xpoints2[0]>405)&&((int)xpoints2[2]<=405)){
			else  if(((int)xpoints[0]>875)){
				 System.out.println(">405- before calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
				// t = 2+pix;
				 System.out.println(">405 point2 --t= "+t+"pix = "+pix);
				 res = 0;
				 System.out.println(" res = "+res);
				 System.out.println(">405 after point2 --t= "+t+"pix = "+pix+"counteri = "+counteri);
				//xpointsFinal[0] = temp1;
				//ypointsFinal[0] = temp2;
				//xpointsFinal[1] = xpoints2[0];
				//ypointsFinal[1] = y-(res*25);
				//temp1 = xpointsFinal[1];
				//temp2 = ypointsFinal[1];
				
				//t++;
				 counteri++;
				//pix = pix+.05;
				xpointsIntegrate[counteri] = xpoints[0];
				 
				ypointsIntegrate[counteri] = y-res*25;
				 
				 
				 xpointsCircle =xpointsIntegrate[counteri];
					ypointsCircle = ypointsIntegrate[counteri];
				System.out.println(">405- after calc  -xpointsIntegrate["+counteri+"] = "+xpointsIntegrate[counteri]+"ypointsIntegrate["+counteri+"]="+ypointsIntegrate[counteri]);
				
			}
			/*
			*/
		//}
	}
 
public void drawArea(Graphics g){
	int a = 115;
	//System.out.println(" after 1st loop--------------");
	//for(int i =0;i<numMove;i++){
	for(int i = 305;i<450;i++){
		if(i<=405){
			for(int ia = 305;ia < 405 ;ia++){
				//System.out.println(" ia = "+ia);
				//System.out.println("xpoints2[0] "+xpoints2[0]+"xpoints2[1] = "+xpoints2[1]+"xpoints2[2] = "+xpoints2[2]);
				if((int)xpoints2[0] ==ia){
					//System.out.println("for index = 0"+xpoints2[0]);
					xpointsArea[0] = xpoints2[0];
					ypointsArea[0] = ypoints2[0]+a;
					
				}
				if((int)xpoints2[1] ==ia){
					//System.out.println("for index = 1"+xpoints2[1]);
					xpointsArea[1] = xpoints2[1];
					ypointsArea[1] = ypoints2[1]+a-25;
					
				}
			}
		}// if
		else if(((int)xpoints2[0]> 405)&&(xpoints2[2]<=405)){
				int  temp =(int)ypoints2[1]; 
				for(int ic = (int)xpoints2[1];ic >(int)xpoints2[2];ic--){
					temp ++;
					System.out.println(" indise > 405 for loop---------------temp ="+temp);
					//System.out.println(" ic = "+ic+"xpoints2[1] = "+(int)xpoints2[1]);
					if( ic == 405){
						if(temp>233){
							//System.out.println("for index = 2   temp = "+temp);
							xpointsArea[0] = 405;
							ypointsArea[0] = 235+a;
							
							xpointsArea[1] = 405;
							ypointsArea[1] = temp+a;
						}else{
						//System.out.println("for index = 2");
							xpointsArea[0] = 405;
							ypointsArea[0] = 235+a;
							
							xpointsArea[1] = 405;
							ypointsArea[1] = temp+a-25;
						
						}
						
					}
				}
		}
	
	}//for main	
			
			
			
		//}
	//}
			
		//System.out.println(" after first  for loop----------------");
		int  temp =(int)ypoints2[1]; 
		for(int ic = (int)xpoints2[1];ic >(int)xpoints2[2];ic--){
			temp ++;
			//System.out.println(" indise second for loop---------------temp ="+temp);
			//System.out.println(" ic = "+ic+"xpoints2[1] = "+(int)xpoints2[1]);
			if( ic == 305){
				//System.out.println("for index = 2");
				xpointsArea[2] = ic;
				ypointsArea[2] = temp+a;
				
				
			}
		}
		 if((int)xpoints2[2] >305){
				xpointsArea[2] = xpoints2[2];
				ypointsArea[2] = ypoints2[2]+a;
				xpointsArea[3] = xpoints2[2];
				ypointsArea[3] = ypoints2[2]+a;
			}
				
			
			
		//}
		
		 if((int)xpoints2[2] > 405){
			 xpointsArea[0] = xpoints2[0];
				ypointsArea[0] = 235+a;
				
				xpointsArea[1] = xpoints2[0];
				ypointsArea[1] = 235+a;
				xpointsArea[2] = xpoints2[0];
				ypointsArea[2] = 235+a;
				
				xpointsArea[3] = xpoints2[0];
				ypointsArea[3] = 235+a;
				
				
				
		 }
		
		//System.out.println(" xpointsArea[0]="+xpointsArea[0]+"xpointsArea[1] =  "+xpointsArea[1]+"xpointsArea[2] = "+xpointsArea[2]+"xpointsArea[3] = "+xpointsArea[3]);
		//System.out.println(" ypointsArea[0]="+ypointsArea[0]+"ypointsArea[1] =  "+ypointsArea[1]+"ypointsArea[2] = "+ypointsArea[2]+"ypointsArea[3] = "+ypointsArea[3]);
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	//}
}

public void drawArea_interact11(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	//System.out.println(" after 1st loop--------------");
	//for(int i =0;i<numMove;i++){
	for(int i = 775;i<870;i++){
		if(i<=800){
			//System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
			for(int ia = 775;ia < 800 ;ia++){
				//System.out.println(" ia = "+ia);
				
				if((int)xpoints[0] ==ia){
					//System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
					xpointsAreaI[0] = xpoints[0];
					ypointsAreaI[0] = ypoints[0]+a;
					
					//System.out.println(" xpointsAreaI[0]==== = "+xpointsAreaI[0]);
				}
				if((int)xpoints[1] ==ia){
					//System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]);
					xpointsAreaI[1] = xpoints[1];
					ypointsAreaI[1] = ypoints[1]+a;
					//System.out.println("for index = 1   after  "+xpoints[1]+"xpointsAreaI[1] = "+ypointsAreaI[1]);
				}
			}
		}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[2]<=800)){
				int  temp =(int)ypoints[1]; 
				for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
					temp ++;
					//System.out.println(" indise > 405 for loop---------------temp ="+xpoints[1]);
					//System.out.println(" ic = "+ic+"xpoints2[1] = "+(int)xpoints2[1]);
					if( ic == 800){
						//if(temp>233){
							//System.out.println("for index = 2   temp = "+temp);
							xpointsAreaI[0] = 800;
							ypointsAreaI[0] = 235+a;
							
							xpointsAreaI[1] = 800;
							ypointsAreaI[1] = 235+a;
					}else{
						//System.out.println("for index = 2");
							xpointsAreaI[0] = 800;
							ypointsAreaI[0] = 235+a;
							
							xpointsAreaI[1] = 800;
							ypointsAreaI[1] = ypoints[1]+a;
						
						}
						
					//}
				}
		}
	
	}//for main	
			
			
			
		//}
	//}
			
		//System.out.println(" after first  for loop----------------");
		//int  temp =(int)ypoints[1]; 
		for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
			//temp ++;
			//System.out.println(" indise second for loop---------------temp ="+temp);
			//System.out.println(" ic = "+ic+"xpoints2[1] = "+(int)xpoints2[1]);
			if( ic == 775){
				//System.out.println("for index = 2");
				xpointsAreaI[2] = ic;
				ypointsAreaI[2] = ypoints[2]+a;
				
				
			}
		}
		 if(((int)xpoints[2] >775)&&((int)xpoints[2]<800)){
				xpointsAreaI[2] = xpoints[2];
				ypointsAreaI[2] = ypoints[2]+a;
				xpointsAreaI[3] = xpoints[3];
				ypointsAreaI[3] = ypoints[3]+a;
			}
				
			
			
		//}
		
		 if((int)xpoints[2] > 800){
			 xpointsAreaI[0] = xpoints[0];
				ypointsAreaI[0] = 235+a;
				
				xpointsAreaI[1] = xpoints[0];
				ypointsAreaI[1] = 235+a;
				xpointsAreaI[2] = xpoints[0];
				ypointsAreaI[2] = 235+a;
				
				xpointsAreaI[3] = xpoints[0];
				ypointsAreaI[3] = 235+a;
				
				
				
		 }
		
		//System.out.println(" xpointsArea[0]="+xpointsArea[0]+"xpointsArea[1] =  "+xpointsArea[1]+"xpointsArea[2] = "+xpointsArea[2]+"xpointsArea[3] = "+xpointsArea[3]);
		//System.out.println(" ypointsArea[0]="+ypointsArea[0]+"ypointsArea[1] =  "+ypointsArea[1]+"ypointsArea[2] = "+ypointsArea[2]+"ypointsArea[3] = "+ypointsArea[3]);
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	//}
}


public void drawArea_interact12(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	System.out.println("interact 12-----------------------------------");
	
	for(int i = 775;i<870;i++){
		if(i<=800){
			System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
			for(int ia = 775;ia < 800 ;ia++){
				//System.out.println(" ia = "+ia);
				
				if((int)xpoints[0] ==ia){
					System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
					xpointsArea12[0] = xpoints[0];
					ypointsArea12[0] = ypoints[0]+a;
					
					System.out.println(" xpointsArea12[0]==== = "+xpointsArea12[0]);
				}
				if((int)xpoints[1] ==ia){
					System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]);
					xpointsArea12[1] = xpoints[1];
					ypointsArea12[1] = ypoints[1]+a+50;
					System.out.println("for index = 1   after  "+xpoints[1]+"xpointsArea12[1] = "+ypointsArea12[1]);
				}
			}
			
			if( xpoints[0] == 800){
				xpointsArea12[0] = xpoints[0];
				ypointsArea12[0] = ypoints[0]+a-25;
			}
			if(xpoints[1] == 800){
				xpointsArea12[1] = xpoints[0];
				ypointsArea12[1] = ypoints[0]+a+25;
			}
		}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[2]<=800)){
				int  temp =(int)ypoints[1]; 
				for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
					temp ++;
					//System.out.println(" indise > 405 for loop---------------temp ="+xpoints[1]);
					//System.out.println(" ic = "+ic+"xpoints2[1] = "+(int)xpoints2[1]);
					if( ic == 800){
						//if(temp>233){
							//System.out.println("for index = 2   temp = "+temp);
							//xpointsArea12[0] = 380;
							//ypointsArea12[0] = 235+a;
							
							//xpointsArea12[1] = 380;
							//ypointsAreaI[1] = 235+a;
					}else{
						//System.out.println("for index = 2");
						
						
							xpointsArea12[0] = xpoints[0];
							ypointsArea12[0] = 235+a;
							
							xpointsArea12[1] = xpoints[1];
							ypointsArea12[1] = ypoints[1]+a;
							
							
						
						}
					if(ic == 800){
						System.out.println("  in 380-------------------------------");
						xpointsArea12[0] = xpoints[0];
						ypointsArea12[0] = 235+a;
						
						xpointsArea12[1] = xpoints[1];
						ypointsArea12[1] = 235+a-25;
						xpointsArea12[2] = 800;
						ypointsArea12[2] = 235+a-25;
						
						xpointsArea12[3] = 800;
						ypointsArea12[3] = 235+a+25;
						
						xpointsArea12[4] = xpoints[2];
						ypointsArea12[4] = 235+a+25;
						xpointsArea12[5] = xpoints[3];
						ypointsArea12[5] = 235+a+25;
						
						xpointsArea12[6] = xpoints[3];
						ypointsArea12[6] = 235+a;
						
					}
						
					//}
				}
		}
		else if(((int)xpoints[2]> 800)&&(xpoints[2]<=825)){
			
			System.out.println("  in 380-------------------------------");
			
			xpointsArea12[0] = 825;
			ypointsArea12[0] = 235+a;
			
			xpointsArea12[1] = 825;
			ypointsArea12[1] = 235+a-25;
			
			xpointsArea12[2] = xpoints[2];
			ypointsArea12[2] = 235+a-25;
			
			xpointsArea12[3] = xpoints[3];
			ypointsArea12[3] = 235+a;
			
			xpointsArea12[4] = xpoints[3];
			ypointsArea12[4] = 235+a;
			xpointsArea12[5] = xpoints[3];
			ypointsArea12[5] = 235+a;
			
			xpointsArea12[6] = xpoints[3];
			ypointsArea12[6] = 235+a;
		}
		else if((int)xpoints[2]> 825){
			for(int k = 0;k< 7;k++){
				xpointsArea12[k] = xpoints[1];
				ypointsArea12[k] = 235+a;
			}
			
		}
	
	}//for main	
			
			
	
		//int  temp =(int)ypoints[1]; 
		for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
			//temp ++;
			//System.out.println(" indise second for loop---------------temp ="+temp);
			//System.out.println(" ic = "+ic+"xpoints2[1] = "+(int)xpoints2[1]);
			if( ic == 775){
				System.out.println("for index = 2++++++++++++++++++++");
				xpointsArea12[2] = ic;
				ypointsArea12[2] = ypoints[2]+a+50;
				
				
			}
			
		}
		
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}


public void drawArea_interact13_temp(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	System.out.println("interact 13-----------------------------------");
	double tempy = 0,tempy1 = 0;
	for(int i = 775;i<870;i++){
		if(i<=800){
			System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
			if((int)xpoints[0] == 775){
				xpointsAreaI[0] = xpoints[0];
				ypointsAreaI[0] = ypoints[0]+a;
				xpointsAreaI[1] = xpoints[1];
				ypointsAreaI[1] = ypoints[1]+a;
				xpointsAreaI[2] = xpoints[1];
				ypointsAreaI[2] = ypoints[1]+a;
				xpointsAreaI[3] = xpoints[1];
				ypointsAreaI[3] = ypoints[1]+a;
				
				
				
				
			}
			double  temp = ypoints[1]; 
			for(int ia = 776;ia <800 ;ia++){
				//System.out.println(" ia = "+ia);
				
				temp = temp+.5;
				
				if((int)xpoints[0] ==ia){
					System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
					xpointsAreaI[0] = xpoints[0];
					ypointsAreaI[0] = ypoints[0]+a;
					
					System.out.println(" xpointsAreaI[0]==== = "+xpointsAreaI[0]);
				}
				
				if((int)xpoints[1] ==ia){
					System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]);
					xpointsAreaI[1] = xpoints[1];
					ypointsAreaI[1] = temp+a;
					
					
					xpointsAreaI[2] = 775;
					ypointsAreaI[2] = 235+a-25;
					xpointsAreaI[3] = 775;
					ypointsAreaI[3] = 235+a;
					
					System.out.println("for index = 1   after  "+xpoints[1]+"xpointsAreaI[1] = "+ypointsAreaI[1]);
				}
			}
			
			if( xpoints[0] == 800){
				xpointsAreaI[0] = xpoints[0];
				ypointsAreaI[0] = ypoints[0]+a;
			}
			if(xpoints[1] == 800){
				xpointsAreaI[1] = xpoints[0];
				ypointsAreaI[1] = temp+a;
				xpointsAreaI[2] = 800;
				ypointsAreaI[2] = 235+a-25;
				xpointsAreaI[3] = 800;
				ypointsAreaI[3] = 235+a;
				
			}
			tempy = temp;
		}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[2]<=800)){
				double  temp = tempy; 
				double temp1 = ypoints[2];
				System.out.println("temp = "+temp);
				for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
					temp =temp+.2;
					if(xpoints[2]<790){
						temp1 = temp1+.2;
					}
					else if(xpoints[2] >= 790){
						temp1 = temp1+.5;
					}
					//System.out.println(" indise > 405 for loop---------------temp ="+xpoints[1]);
					//System.out.println(" ic = "+ic+"xpoints2[1] = "+(int)xpoints2[1]);
					if( ic == 800){
						//if(temp>233){
							//System.out.println("for index = 2   temp = "+temp);
							//xpointsArea12[0] = 380;
							//ypointsArea12[0] = 235+a;
							
							//xpointsArea12[1] = 380;
							//ypointsAreaI[1] = 235+a;
					}else{
						//System.out.println("for index = 2");
						
						
							xpointsAreaI[0] = xpoints[0];
							ypointsAreaI[0] = 235+a;
							
							xpointsAreaI[1] = xpoints[1];
							ypointsAreaI[1] = temp+a;
							xpointsAreaI[2] = xpoints[2];
							ypointsAreaI[2] = temp1+a;
							xpointsAreaI[3] = xpoints[2];
							ypointsAreaI[3] = 235+a;
							
							
						
						}
					if(ic == 800){
						System.out.println("  in 380-------------------------------");
						xpointsAreaI[0] = xpoints[0];
						ypointsAreaI[0] = 235+a;
						
						xpointsAreaI[1] = xpoints[1];
						ypointsAreaI[1] = temp+a;
						xpointsAreaI[2] = xpoints[2];
						ypointsAreaI[2] = temp1+a;
						
						xpointsAreaI[3] = xpoints[2];
						ypointsAreaI[3] = 235+a;
						
						
						
						
						
					}
					//tempy = temp;
					//tempy1 = temp1;
						
					//}
				}
				//tempy = temp;
				//tempy1 = temp1;
		}
		else if(((int)xpoints[2]> 800)&&(xpoints[2]<=825)){
			double temp1 = 350-12;			//idhar
			double temp = 235+a-1;
			for(int ij = 801;ij<=825;ij++){
				temp1 = temp1+.25;
				//temp = temp+.1;
				System.out.println("  in 380-------------------------------");
			}
			xpointsAreaI[0] = 825;
			ypointsAreaI[0] = 235+a;
			
			xpointsAreaI[1] = 825;
			ypointsAreaI[1] = temp;
			
			xpointsAreaI[2] = xpoints[2];
			ypointsAreaI[2] = temp1;
			
			xpointsAreaI[3] = xpoints[3];
			ypointsAreaI[3] = 235+a;
			
			
		}
		else if((int)xpoints[2]> 825){
			for(int k = 0;k< 4;k++){
				xpointsAreaI[k] = xpoints[1];
				ypointsAreaI[k] = 235+a;
			}
			
		}
	
	}//for main	
			
			
	
		//int  temp =(int)ypoints[1]; 
		/*
			
		*/
		
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}

public void drawArea_interact13(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	double res = 0;
	double res1= 0;
	//double y1 = 0;
	System.out.println("interact 13-----------------------------------");
	double tempy = 0,tempy1 = 0;
	for(int i = 775;i<870;i++){
		if(i<=800){
			//System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
			if((int)xpoints[0] == 775){
				xpointsArea22[0] = xpoints[0];
				ypointsArea22[0] = ypoints[0]+a;
				xpointsArea22[1] = xpoints[1];
				ypointsArea22[1] = ypoints[1]+a;
				xpointsArea22[2] = xpoints[1];
				ypointsArea22[2] = ypoints[1]+a;
				xpointsArea22[3] = xpoints[1];
				ypointsArea22[3] = ypoints[1]+a;
				xpointsArea22[4] = xpoints[1];
				ypointsArea22[4] = ypoints[1]+a;
				xpointsArea22[5] = xpoints[1];
				ypointsArea22[5] = ypoints[1]+a;
				xpointsArea22[6] = xpoints[1];
				ypointsArea22[6] = ypoints[1]+a;
				xpointsArea22[7] = xpoints[1];
				ypointsArea22[7] = ypoints[1]+a;
				
				
			}
			if(((int)xpoints[0]>775)&&(xpoints[0]<=800)){
				xpointsArea22[0] = xpoints[0];
				ypointsArea22[0] = 235+a;
				
				
					//System.out.println(" in function >355 ,<380-------------------------");
					val = val+0.002;
					res = Math.exp(-val)*1;
					//System.out.println(" res === "+res);
					
					
					
					y = 350 - (res*25);			//idhar
					//System.out.println(" y === "+y+ "avg = "+(y+325)/2+"xavg = "+(xpoints[1]+xpoints[2])/2);
					xpointsArea22[1] = xpoints[1];
					ypointsArea22[1] = y;
					if(xpoints[0]>788){
						for(int j = 0;j<xpoints1O3.length;j++){
							if((xpoints1O3[j]<=800)&&(xpoints1O3[j]>788)){
								xpointsArea22[2] = xpoints1O3[j-1];
								ypointsArea22[2] = ypoints1O3[j-1]+a;
								xpointsArea22[3] = xpoints1O3[j-2];
								ypointsArea22[3] = ypoints1O3[j-2]+a;
								xpointsArea22[4] = xpoints1O3[j-3];
								ypointsArea22[4] = ypoints1O3[j-3]+a;
								break;
							}
						}
					
					
					//System.out.println("x3 = "+xpointsArea22[3]+"y3 = "+ypointsArea22[3]+"x4 = "+xpointsArea22[4]+"y4 = "+ypointsArea22[4]);
					}else{
						xpointsArea22[2] = xpoints[1];
						ypointsArea22[2] = y;
						xpointsArea22[3] = xpoints[1];
						ypointsArea22[3] = y;
						xpointsArea22[4] = xpoints[1];
						ypointsArea22[4] = y;
					}
					xpointsArea22[5] = 775;
					ypointsArea22[5] = 235+a-25;
					//System.out.println(" xpointsArea22[1] == "+xpointsArea22[1]+"ypointsArea22[1] == "+ypointsArea22[1]);
				
				
				xpointsArea22[6] = 775;
				ypointsArea22[6] = 235+a;
				xpointsArea22[7] = 775;
				ypointsArea22[7] = 235+a;
				
			}
				
			
		}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[0]<=825)){
			
			xpointsArea22[0] = xpoints[0];
			ypointsArea22[0] = 235+a;
			
			
				System.out.println(" in function  ,>380 and < 405-------------------------");
				val = val+0.001;
				res = Math.exp(-val)*1;
				//System.out.println(" res === "+res);
				yval = yval+0.0005;
				res1 = Math.exp(-yval)*1;
				
				y = 350 - (res*25);				//idhar 350
				y1 = 350 - (res1*25);
				//System.out.println(" y === "+y);
				xpointsArea22[1] = xpoints[1];
				ypointsArea22[1] = y;
				System.out.println("ypointsArea22[1] === "+ypointsArea22[1]+"xpointsArea22[1] = "+xpoints[1]+"xpoints[0] = "+xpoints[0]);
				for(int k=0;k<xpoints1O3.length;k++){
					if((xpoints1O3[k]>800)&&(xpoints1O3[k]>=xpoints[1])){
						
						
							xpointsArea22[2] = xpoints1O3[k-1];
							ypointsArea22[2] = ypoints1O3[k-1]+a;
							xpointsArea22[3] = xpoints1O3[k-2];
							ypointsArea22[3] = ypoints1O3[k-2]+a;
							
							xpointsArea22[4] = xpoints1O3[k-3];
							
							
							ypointsArea22[4] = ypoints1O3[k-3]+a;
						
						
						
						break;
					}
					
					
				}
				System.out.println("ypointsArea22[2] === "+ypointsArea22[2]+"   xpointsArea22[2] === "+xpointsArea22[2]);
				System.out.println("ypointsArea22[3] === "+ypointsArea22[3]+"   xpointsArea22[3] === "+xpointsArea22[3]);
				System.out.println("ypointsArea22[4] === "+ypointsArea22[4]+"   xpointsArea22[4] === "+xpointsArea22[4]);
				//xpointsAreaI[2] = (xpoints[2]-xpoints[1])/2;
				//ypointsAreaI[2] = (y+y1)/2;
				xpointsArea22[5] = xpoints[3];
				ypointsArea22[5] = y1;
				System.out.println("ypointsArea22[5] === "+ypointsArea22[5]+"  xpointsArea22[5] === "+xpointsArea22[5]);
				//System.out.println(" xpointsAreaI[1] == "+xpointsAreaI[1]+"ypointsAreaI[1] == "+ypointsAreaI[1]);
			
			
			
			xpointsArea22[6] = xpoints[3];
			ypointsArea22[6] = 235+a;
			xpointsArea22[7] = xpoints[3];
			ypointsArea22[7] = 235+a;
			
			
		}
		else if(((int)xpoints[0]> 825)&&(xpoints[0]<=850)){
			xpointsArea22[0] = 825;
			ypointsArea22[0] = 235+a;
			
			
				System.out.println(" in function >405 ,<380-------------------------");
				val = val+0.001;
				res = Math.exp(-val)*1;
				System.out.println(" res === "+res);
				yval = yval+0.001;
				res1 = Math.exp(-yval)*1;
				
				y = 350 - (res*25);					//idhar
				y1 = 350 - (res1*25);
				System.out.println(" y === "+y);
				xpointsArea22[1] = 825;
				ypointsArea22[1] = y;
				//xpointsArea22[2] = xpoints[2];
				//ypointsArea22[2] = y1;
				//System.out.println(" xpointsAreaI[1] == "+xpointsAreaI[1]+"ypointsAreaI[1] == "+ypointsAreaI[1]);
			
				
				for(int k=0;k<xpoints1O3.length;k++){
					if((xpoints1O3[k]>825)&&(xpoints1O3[k]>=xpoints[1])&&(xpoints1O3[k]<837)){
						
						
							xpointsArea22[2] = xpoints1O3[k-1];
							ypointsArea22[2] = ypoints1O3[k-1]+a;
							xpointsArea22[3] = xpoints1O3[k-2];
							ypointsArea22[3] = ypoints1O3[k-2]+a;
							
							xpointsArea22[4] = xpoints1O3[k-3];
							
							
							ypointsArea22[4] = ypoints1O3[k-3]+a;
							xpointsArea22[5] = xpoints[3];
							ypointsArea22[5] = y1;
						
						
						break;
					}else {
						xpointsArea22[2] = xpoints[2];
						ypointsArea22[2] = y1;
						xpointsArea22[3] = xpoints[3];
						ypointsArea22[3] = 235+a;
						xpointsArea22[4] = xpoints[3];
						ypointsArea22[4] = 235+a;
						xpointsArea22[5] = xpoints[3];
						ypointsArea22[5] = 235+a;
					}
					
					
				}
				
				System.out.println("ypointsArea22[2] === "+ypointsArea22[2]+"   xpointsArea22[2] === "+xpointsArea22[2]);
				System.out.println("ypointsArea22[3] === "+ypointsArea22[3]+"   xpointsArea22[3] === "+xpointsArea22[3]);
				System.out.println("ypointsArea22[4] === "+ypointsArea22[4]+"   xpointsArea22[4] === "+xpointsArea22[4]);
				
				
				
				
				
			
			//xpointsArea22[3] = xpoints[3];
			//ypointsArea22[3] = 235+a;
			//xpointsArea22[4] = xpoints[3];
			//ypointsArea22[4] = 235+a;
			
			xpointsArea22[6] = xpoints[3];
			ypointsArea22[6] = 235+a;
			xpointsArea22[7] = xpoints[3];
			ypointsArea22[7] = 235+a;
			System.out.println("ypointsArea22[5] === "+ypointsArea22[5]+"  xpointsArea22[5] === "+xpointsArea22[5]);
		}
		else if((int)xpoints[0]> 850){
			for(int k = 0;k< 8;k++){
				xpointsArea22[k] = xpoints[0];
				ypointsArea22[k] = 235+a;
			}
			
		}
	
	}//for main	
			
			
	
		
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}




public void drawArea_interact21(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	System.out.println("interact 21-----------------------------------");
	
	for(int i = 775;i<870;i++){
		if(i<=800){
			System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
			for(int ia = 775;ia < 800 ;ia++){
				//System.out.println(" ia = "+ia);
				
				if((int)xpoints[0] ==ia){
					System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
					xpointsArea12[0] = xpoints[0];
					ypointsArea12[0] = ypoints[0]+a;
					
					System.out.println(" xpointsArea12[0]==== = "+xpointsArea12[0]);
				}
				if((int)xpoints[1] ==ia){
					System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]);
					xpointsArea12[1] = xpoints[1];
					ypointsArea12[1] = ypoints[1]+a;
					System.out.println("for index = 1   after  "+xpoints[1]+"xpointsArea12[1] = "+ypointsArea12[1]);
				}
			}
			
			if( xpoints[0] == 800){
				xpointsArea12[0] = xpoints[0];
				ypointsArea12[0] = ypoints[0]+a;
			}
			if(xpoints[1] == 800){
				xpointsArea12[1] = xpoints[0];
				ypointsArea12[1] = ypoints[0]+a+25;
				
				xpointsArea12[2] = 775;
				ypointsArea12[2] = 235+a+25;
				xpointsArea12[3] = 775;
				ypointsArea12[3] = 235+a-25;
				xpointsArea12[4] = 775;
				ypointsArea12[4] = 235+a-25;
				xpointsArea12[5] = 775;
				ypointsArea12[5] = 235+a-25;
				
			}
		}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[2]<=800)){
				//int  temp =(int)ypoints[1]; 
				for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
					//temp ++;
					//System.out.println(" indise > 405 for loop---------------temp ="+xpoints[1]);
					//System.out.println(" ic = "+ic+"xpoints2[1] = "+(int)xpoints2[1]);
					if( ic == 800){
						
					}else{
						System.out.println("for index = >800   else loop++++++++++++++++++++++++++++++++++++++++++++");
						
						
							xpointsArea12[0] =800;
							ypointsArea12[0] = 235+a;
							
							xpointsArea12[1] = 800;
							ypointsArea12[1] = ypoints[1]+a;
							
							xpointsArea12[2] = xpoints[2];
							ypointsArea12[2] = 235+a+25;
							
							xpointsArea12[3] = xpoints[2];
							ypointsArea12[3] = 235+a-25;
							
							xpointsArea12[4] = 775;
							ypointsArea12[4] = 235+a-25;
							
							xpointsArea12[5] = 775;
							ypointsArea12[5] = 235+a;
							
							xpointsArea12[6] = 775;
							ypointsArea12[6] = 235+a;
						
						}
					if(ic == 800){
						System.out.println("  in 800-------------------------------");
						xpointsArea12[0] = xpoints[0];
						ypointsArea12[0] = 235+a;
						
						xpointsArea12[1] = xpoints[1];
						ypointsArea12[1] = 235+a-25;
						
						xpointsArea12[2] = 800;
						ypointsArea12[2] = 235+a-25;
						
						xpointsArea12[3] = 800;
						ypointsArea12[3] = 235+a+25;
						
						xpointsArea12[4] = xpoints[2];
						ypointsArea12[4] = 235+a+25;
						xpointsArea12[5] = xpoints[3];
						ypointsArea12[5] = 235+a+25;
						
						xpointsArea12[6] = xpoints[3];
						ypointsArea12[6] = 235+a;
						
					}
						
					
				}
		}
		else if(((int)xpoints[2]> 800)&&(xpoints[2]<=825)){
			
			//System.out.println("  in 800-------------------------------");
			xpointsArea12[0] = 800;
			ypointsArea12[0] = 235+a;
			
			xpointsArea12[1] = 800;
			ypointsArea12[1] = 235+a-25;
			
			xpointsArea12[2] = 800;
			ypointsArea12[2] = 235+a-25;
			
			xpointsArea12[3] = 800;
			ypointsArea12[3] = 235+a-25;
			
			xpointsArea12[4] = xpoints[4];
			ypointsArea12[4] = 235+a-25;
			xpointsArea12[5] = xpoints[4];
			ypointsArea12[5] = 235+a;
			
			xpointsArea12[6] = xpoints[4];
			ypointsArea12[6] = 235+a;
		}
		else if((int)xpoints[2]> 825){
			for(int k = 0;k< 7;k++){
				xpointsArea12[k] = xpoints[1];
				ypointsArea12[k] = 235+a;
			}
			
		}
	
	}//for main	
	for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
			if( ic == 775){
				System.out.println("for index = 2++++++++++++++++++++");
				xpointsArea12[2] = ic;
				ypointsArea12[2] = ypoints[2]+a;
				
			}
		}
		
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}

public void drawArea_interact22(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	System.out.println("interact 22-----------------------------------");
	
	for(int i = 775;i<870;i++){
		if(i<=800){
			System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
			for(int ia = 775;ia < 800 ;ia++){
				//System.out.println(" ia = "+ia);
				
				if((int)xpoints[0] ==ia){
					System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
					xpointsArea22[0] = xpoints[0];
					ypointsArea22[0] = ypoints[0]+a;
					
					System.out.println(" xpointsArea22[0]==== = "+xpointsArea22[0]);
				}
				if((int)xpoints[1] ==ia){
					System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]);
					xpointsArea22[1] = xpoints[1];
					ypointsArea22[1] = ypoints[1]+a-50;
					System.out.println("for index = 1   after  "+xpoints[1]+"xpointsArea22[1] = "+ypointsArea22[1]);
				}
			}
			
			if( xpoints[0] == 800){
				xpointsArea22[0] = xpoints[0];
				ypointsArea22[0] = ypoints[0]+a;
			}
			if(xpoints[1] == 800){
				xpointsArea22[1] = xpoints[0];
				ypointsArea22[1] = ypoints[0]+a-25;
				
				xpointsArea22[2] = 775;
				ypointsArea22[2] = 235+a-25;
				xpointsArea22[3] = 775;
				ypointsArea22[3] = 235+a-25;
				xpointsArea22[4] = 775;
				ypointsArea22[4] = 235+a-25;
				xpointsArea22[5] = 775;
				ypointsArea22[5] = 235+a-25;
				
			}
		}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[2]<=800)){
				
				for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
					if( ic == 800){
					//	
					}else{
						//System.out.println("for index = >800   else loop++++++++++++++++++++++++++++++++++++++++++++");
						
						
							xpointsArea22[0] =xpoints[0];
							ypointsArea22[0] = 235+a;
							
							xpointsArea22[1] = xpoints[0];
							ypointsArea22[1] = ypoints[1]+a;
							
							xpointsArea22[2] = 800;
							ypointsArea22[2] = 235+a+25;
							
							xpointsArea22[3] = 800;
							ypointsArea22[3] = 235+a-25;
							
							xpointsArea22[4] = xpoints[3];
							ypointsArea22[4] = 235+a-25;
							
							xpointsArea22[5] = xpoints[3];
							ypointsArea22[5] = 235+a+25;
							
							xpointsArea22[6] = 775;
							ypointsArea22[6] = 235+a+25;
							xpointsArea22[7] = 775;
							ypointsArea22[7] = 235+a;
						
						}
					//if(ic == 800){
					if(xpoints[0]==825){
						System.out.println("  in 800-------------------------------"+ic);
						xpointsArea22[0] = xpoints[0];
						ypointsArea22[0] = 235+a;
						
						xpointsArea22[1] = xpoints[1];
						ypointsArea22[1] = ypoints[1]+a;
						
						xpointsArea22[2] = xpoints[4];
						ypointsArea22[2] = 235+a+25;
						
						xpointsArea22[3] = xpoints[4];
						ypointsArea22[3] = 235+a+25;
						
						xpointsArea22[4] = xpoints[4];
						ypointsArea22[4] = 235+a+25;
						xpointsArea22[5] = xpoints[4];
						ypointsArea22[5] = 235+a+25;
						
						xpointsArea22[6] = xpoints[4];
						ypointsArea22[6] = 235+a+25;
						
						xpointsArea22[7] = 775;
						ypointsArea22[7] = 235+a;
						
					}
						
					
				}
		}
		else if(((int)xpoints[2]> 800)&&(xpoints[2]<=825)){
			if(xpoints[2]==825){
				xpointsArea22[0] = 825;
				ypointsArea22[0] = 235+a;
				
				xpointsArea22[1] = 825;
				ypointsArea22[1] = 235+a-25;
				
				xpointsArea22[2] = xpoints[4];
				ypointsArea22[2] = 235+a-25;
				
				xpointsArea22[3] = xpoints[4];
				ypointsArea22[3] = 235+a;
				
				xpointsArea22[4] = xpoints[4];
				ypointsArea22[4] = 235+a;
				xpointsArea22[5] = xpoints[4];
				ypointsArea22[5] = 235+a;
				
				xpointsArea22[6] = xpoints[4];
				ypointsArea22[6] = 235+a;
				
				xpointsArea22[7] = xpoints[4];
				ypointsArea22[7] = 235+a;
			}
			else{
			//System.out.println("  in 800-------------------------------");
				xpointsArea22[0] = 825;
				ypointsArea22[0] = 235+a;
				
				xpointsArea22[1] = 825;
				ypointsArea22[1] = 235+a+25;
				
				xpointsArea22[2] = xpoints[2];
				ypointsArea22[2] = 235+a+25;
				
				xpointsArea22[3] = xpoints[3];
				ypointsArea22[3] = 235+a-25;
				
				xpointsArea22[4] = 800;
				ypointsArea22[4] = 235+a-25;
				xpointsArea22[5] = 800;
				ypointsArea22[5] = 235+a+25;
				
				xpointsArea22[6] = xpoints[4];
				ypointsArea22[6] = 235+a+25;
				
				xpointsArea22[7] = xpoints[4];
				ypointsArea22[7] = 235+a;
				}
		}
		else if(((int)xpoints[2]> 825)&&((int)xpoints[4]<= 825)){
			xpointsArea22[0] = 825;
			ypointsArea22[0] = 235+a;
			
			xpointsArea22[1] = 825;
			ypointsArea22[1] = 235+a-25;
			
			xpointsArea22[2] = xpoints[4];
			ypointsArea22[2] = 235+a-25;
			
			xpointsArea22[3] = xpoints[4];
			ypointsArea22[3] = 235+a;
			
			xpointsArea22[4] = xpoints[4];
			ypointsArea22[4] = 235+a;
			xpointsArea22[5] = xpoints[4];
			ypointsArea22[5] = 235+a;
			
			xpointsArea22[6] = xpoints[4];
			ypointsArea22[6] = 235+a;
			
			xpointsArea22[7] = xpoints[4];
			ypointsArea22[7] = 235+a;
			
		}
		else if((int)xpoints[4]> 825){
			for(int k = 0;k<8;k++){
				xpointsArea22[k] = xpoints[1];
				ypointsArea22[k] = 235+a;
			}
			
		}
	
	}//for main	
	for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
			if( ic == 775){
				System.out.println("for index = 2++++++++++++++++++++");
				xpointsArea22[2] = ic;
				ypointsArea22[2] = ypoints[2]+a-50;
				
			}
		}
		
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}


public void drawArea_interact23(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	double tempx = 0;
	double tempx1 = 0;
	double tempx2 = 0;
	System.out.println("interact 23-----------------------------------");
	
	for(int i= 0;i<xpoints1O3.length;i++){
		System.out.println(" xpoints1O3["+i+"] = "+xpoints1O3[i]);
		System.out.println(" ypoints1O3["+i+"] = "+ypoints1O3[i]);
	}
	//for(int i = 775;i<870;i++){
		 if((xpoints[0]<=788)&&(xpoints[0]>775)){
			//if(i<=800){
				double  temp = (int)ypoints[1]; 
				//System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
				for(int ia = 775;ia < 788 ;ia++){
					if((int)xpoints[0] ==ia){
							//System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
							xpointsArea23[0] = xpoints[0];
							ypointsArea23[0] = ypoints[0]+a;
							
					}
					if((int)xpoints[1] ==ia){
						//System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]+"temp================ =  "+temp);
						xpointsArea23[1] = xpoints[1];
						ypointsArea23[1] = temp+a;
						xpointsArea23[2] = 775;
						ypointsArea23[2] = 235+a+25;
						xpointsArea23[3] = 775;
						ypointsArea23[3] = 235+a;
						xpointsArea23[4] = 775;
						ypointsArea23[4] = 235+a;
						xpointsArea23[5] = 775;
						ypointsArea23[5] = 235+a;
						xpointsArea23[6] = 775;
						ypointsArea23[6] = 235+a;
						xpointsArea23[7] = 775;
						ypointsArea23[7] = 235+a;
						xpointsArea23[8] = 775;
						ypointsArea23[8] = 235+a;
						xpointsArea23[9] = 775;
						ypointsArea23[9] = 235+a;
						
					}
					temp = temp - .5;
				}
			/*	System.out.println("xpointsArea23[0] =  "+xpointsArea23[0]+"ypointsArea23[0] = ="+ypointsArea23[0]);	 
				 System.out.println("xpointsArea23[1] =  "+xpointsArea23[1]+"ypointsArea23[1] = ="+ypointsArea23[1]);	 
				 System.out.println("xpointsArea23[2] =  "+xpointsArea23[2]+"ypointsArea23[2] = ="+ypointsArea23[2]);	 
				 System.out.println("xpointsArea23[3] =  "+xpointsArea23[3]+"ypointsArea23[3] = ="+ypointsArea23[3]);	 
				 System.out.println("xpointsArea23[4] =  "+xpointsArea23[4]+"ypointsArea23[4] = ="+ypointsArea23[4]);	 
				 System.out.println("xpointsArea23[5] =  "+xpointsArea23[5]+"ypointsArea23[5] = ="+ypointsArea23[5]);	 
				 System.out.println("xpointsArea23[6] =  "+xpointsArea23[6]+"ypointsArea23[6] = ="+ypointsArea23[6]);	 
				 */
				
		 }
		 if(((int)xpoints[0]>=788)&&((int)xpoints[0]<=800)){
			 for(int j = 0;j<xpoints1O3.length;j++){
				 if(((int)xpoints1O3[j]>(int)xpoints[0])&&((int)xpoints1O3[j]>787)){
					 System.out.println("j = "+j);
					 
					 	xpointsArea23[0] = xpoints[0];
						ypointsArea23[0] = 235+a;
						xpointsArea23[1] = xpoints[0];
						ypointsArea23[1] = ypoints1O3[j-1]+a+(2*(235-ypoints1O3[j-1]));
						xpointsArea23[2] = xpoints1O3[j-2];
						ypointsArea23[2] = ypoints1O3[j-2]+a+(2*(235-ypoints1O3[j-2]));
						xpointsArea23[3] = xpoints1O3[j-3];
						ypointsArea23[3] = ypoints1O3[j-3]+a+(2*(235-ypoints1O3[j-3]));
						xpointsArea23[4] = xpoints1O3[j-4];
						ypointsArea23[4] = ypoints1O3[j-4]+a+(2*(235-ypoints1O3[j-4])); 
						if(j-5 > 0){
							xpointsArea23[5] = xpoints1O3[j-5];
							ypointsArea23[5] = ypoints1O3[j-5]+a+(2*(235-ypoints1O3[j-5]));
							xpointsArea23[6] = 775;
							ypointsArea23[6] = 235+a;
							xpointsArea23[7] = 775;
							ypointsArea23[7] = 235+a;
							
							xpointsArea23[8] = 775;
							ypointsArea23[8] = 235+a;
							xpointsArea23[9] = 775;
							ypointsArea23[9] = 235+a;
							
						}else{
						xpointsArea23[5] = 775;
						ypointsArea23[5] = 235+a;
						
						xpointsArea23[6] = 775;
						ypointsArea23[6] = 235+a;
						
						xpointsArea23[7] = 775;
						ypointsArea23[7] = 235+a;
						
						xpointsArea23[8] = 775;
						ypointsArea23[8] = 235+a;
						xpointsArea23[9] = 775;
						ypointsArea23[9] = 235+a;
						}
						
						if(xpoints[1] == 800){
							xpointsArea23[5] = 775;
							ypointsArea23[5] = 235+a+25;
							xpointsArea23[6] = 775;
							ypointsArea23[6] = 235+a-25;
							xpointsArea23[7] = 775;
							ypointsArea23[7] = 235+a;
							xpointsArea23[8] = 775;
							ypointsArea23[8] = 235+a;
							xpointsArea23[9] = 775;
							ypointsArea23[9] = 235+a;
							//tempy = temp;
							
							//System.out.println(" ----------------------------------tempy = "+tempy);
					}
						break;
				 }
			 }
			/* System.out.println("xpointsArea23[0] =  "+xpointsArea23[0]+"ypointsArea23[0] = ="+ypointsArea23[0]);	 
			 System.out.println("xpointsArea23[1] =  "+xpointsArea23[1]+"ypointsArea23[1] = ="+ypointsArea23[1]);	 
			 System.out.println("xpointsArea23[2] =  "+xpointsArea23[2]+"ypointsArea23[2] = ="+ypointsArea23[2]);	 
			 System.out.println("xpointsArea23[3] =  "+xpointsArea23[3]+"ypointsArea23[3] = ="+ypointsArea23[3]);	 
			 System.out.println("xpointsArea23[4] =  "+xpointsArea23[4]+"ypointsArea23[4] = ="+ypointsArea23[4]);	 
			 System.out.println("xpointsArea23[5] =  "+xpointsArea23[5]+"ypointsArea23[5] = ="+ypointsArea23[5]);	 
			 System.out.println("xpointsArea23[6] =  "+xpointsArea23[6]+"ypointsArea23[6] = ="+ypointsArea23[6]);	 
			 System.out.println("xpointsArea23[7] =  "+xpointsArea23[7]+"ypointsArea23[7] = ="+ypointsArea23[7]);	
			 
			*/
			 
		 }
		 
		 
		else if(((int)xpoints[0]> 800)&&(xpoints[0]<=825)){
				
			for(int k=0;k<xpoints1O3.length;k++){
				System.out.println(" k = "+k+" xpoints[0] = "+xpoints[0]+" 103 ==="+xpoints1O3[k]);
				if(((int)xpoints1O3[k]>=(int)xpoints[0])&&((int)xpoints1O3[k]>800)){
					System.out.println(" xpoints[0]----- = "+xpoints[0]);
					xpointsArea23[0] = xpoints[0];
					ypointsArea23[0] = 235+a;
					
					xpointsArea23[1] = xpoints[1];
					ypointsArea23[1] = ypoints1O3[k-1]+a+(2*(235-ypoints1O3[k-1]));
					
					xpointsArea23[2] = xpoints1O3[k-2];
					ypointsArea23[2] = ypoints1O3[k-2]+a+(2*(235-ypoints1O3[k-2]));
					
					xpointsArea23[3] = xpoints1O3[k-3];
					ypointsArea23[3] = ypoints1O3[k-3]+a+(2*(235-ypoints1O3[k-3]));
					
					xpointsArea23[4] = xpoints[3];
					ypointsArea23[4] = ypoints1O3[k-5]+a+(2*(235-ypoints1O3[k-5]));
					
					xpointsArea23[5] = xpoints[3];
					ypointsArea23[5] = ypoints1O3[k-5]+a;
					
					xpointsArea23[6] = xpoints1O3[k-6];
					ypointsArea23[6] = ypoints1O3[k-6]+a;
					
					xpointsArea23[7] = xpoints1O3[k-7];
					ypointsArea23[7] = ypoints1O3[k-7]+a;
					
					xpointsArea23[8] = 775;
					ypointsArea23[8] =  235+a-25;
					xpointsArea23[9] = 775;
					ypointsArea23[9] = 235+a;
					break;
				}
			}
			
			/*System.out.println("xpointsArea23[0] =  "+xpointsArea23[0]+"ypointsArea23[0] = ="+ypointsArea23[0]);	 
			 System.out.println("xpointsArea23[1] =  "+xpointsArea23[1]+"ypointsArea23[1] = ="+ypointsArea23[1]);	 
			 System.out.println("xpointsArea23[2] =  "+xpointsArea23[2]+"ypointsArea23[2] = ="+ypointsArea23[2]);	 
			 System.out.println("xpointsArea23[3] =  "+xpointsArea23[3]+"ypointsArea23[3] = ="+ypointsArea23[3]);	 
			 System.out.println("xpointsArea23[4] =  "+xpointsArea23[4]+"ypointsArea23[4] = ="+ypointsArea23[4]);	 
			 System.out.println("xpointsArea23[5] =  "+xpointsArea23[5]+"ypointsArea23[5] = ="+ypointsArea23[5]);	 
			 System.out.println("xpointsArea23[6] =  "+xpointsArea23[6]+"ypointsArea23[6] = ="+ypointsArea23[6]);	 
			 System.out.println("xpointsArea23[7] =  "+xpointsArea23[7]+"ypointsArea23[7] = ="+ypointsArea23[7]);	
			 */
		}
		
		else if(((int)xpoints[0]> 825)&&((int)xpoints[0]<=850)){
			System.out.println(">>>>>>>>>>>>>>>> in >825 and <=430");
			for(int l = 3;l<xpoints1O3.length;l++){
				//System.out.println(" l = "+l+" xpoints[3] = "+xpoints[3]+" 103 ==="+xpoints1O3[l]);
				if(((int)xpoints1O3[l]>= xpoints[3])&&((int)xpoints[3]<=850)){
					System.out.println("++++++++++++ l = "+l);
					xpointsArea23[0] = 825;
					ypointsArea23[0] = 235+a;
					
					xpointsArea23[1] = 825;
					//ypointsArea23[1] = ypoints1O3[l+3]+a+(2*(235-ypoints1O3[l+3]));
					ypointsArea23[1] = ypoints1O3[11]+a+(2*(235-ypoints1O3[11]));
					
					xpointsArea23[2] = xpoints1O3[l+1];
					ypointsArea23[2] = ypoints1O3[l+1]+a+(2*(235-ypoints1O3[l+1]));
					
					
					
					xpointsArea23[3] = xpoints[3];
					ypointsArea23[3] = ypoints1O3[l]+a+(2*(235-ypoints1O3[l]));
				
					xpointsArea23[4] = xpoints[3];
					ypointsArea23[4] = ypoints1O3[l]+a;
					
					xpointsArea23[5] = xpoints1O3[l-1];
					ypointsArea23[5] = ypoints1O3[l-1]+a;
					
					xpointsArea23[6] = xpoints1O3[l-2];
					ypointsArea23[6] = ypoints1O3[l-2]+a;
					
					xpointsArea23[7] = xpoints1O3[l-3];
					ypointsArea23[7] = ypoints1O3[l-3]+a;
					
					xpointsArea23[8] = xpoints[4];
					ypointsArea23[8] = ypoints1O3[l-4]+a;
						
					xpointsArea23[9] = xpoints[4];
					ypointsArea23[9] = 235+a;
					break;
				
				}
			}
			/*System.out.println("xpointsArea23[0] =  "+xpointsArea23[0]+"ypointsArea23[0] = ="+ypointsArea23[0]);	 
			 System.out.println("xpointsArea23[1] =  "+xpointsArea23[1]+"ypointsArea23[1] = ="+ypointsArea23[1]);	 
			 System.out.println("xpointsArea23[2] =  "+xpointsArea23[2]+"ypointsArea23[2] = ="+ypointsArea23[2]);	 
			 System.out.println("xpointsArea23[3] =  "+xpointsArea23[3]+"ypointsArea23[3] = ="+ypointsArea23[3]);	 
			 System.out.println("xpointsArea23[4] =  "+xpointsArea23[4]+"ypointsArea23[4] = ="+ypointsArea23[4]);	 
			 System.out.println("xpointsArea23[5] =  "+xpointsArea23[5]+"ypointsArea23[5] = ="+ypointsArea23[5]);	 
			 System.out.println("xpointsArea23[6] =  "+xpointsArea23[6]+"ypointsArea23[6] = ="+ypointsArea23[6]);	 
			 System.out.println("xpointsArea23[7] =  "+xpointsArea23[7]+"ypointsArea23[7] = ="+ypointsArea23[7]);
			 System.out.println("xpointsArea23[8] =  "+xpointsArea23[8]+"ypointsArea23[8] = ="+ypointsArea23[8]);	 
			 System.out.println("xpointsArea23[9] =  "+xpointsArea23[9]+"ypointsArea23[9] = ="+ypointsArea23[9]);	*/
			
		}
		else if(((int)xpoints[2]> 825)&&((int)xpoints[2]<=850)){
			for(int k = 7;k<12;k++){
				System.out.println("++++++++++++ k = "+k+"  4 = "+xpoints[4]+"   103    "+xpoints1O3[k]);
				if(((int)xpoints[4]<= 815)&&(xpoints1O3[k]>= xpoints[4])){
					System.out.println("++++++++++++ k = "+k);
					xpointsArea23[0] = 825;
					ypointsArea23[0] = 235+a;
					
					xpointsArea23[1] = 825;
					ypointsArea23[1] = ypoints1O3[11]+a;
					
					xpointsArea23[2] = 820;
					ypointsArea23[2] = ypoints1O3[k+2]+a;
					
					xpointsArea23[3] = xpoints[4]+5;
					ypointsArea23[3] = ypoints1O3[k+1]+a;
				
					xpointsArea23[4] = xpoints[4];
					ypointsArea23[4] = ypoints1O3[k]+a;
					xpointsArea23[5] = xpoints[4];
					ypointsArea23[5] = 235+a;
					
					xpointsArea23[6] = xpoints[4];
					ypointsArea23[6] = 235+a;
						
					xpointsArea23[7] = xpoints[4];
					ypointsArea23[7] = 235+a;
					xpointsArea23[8] = xpoints[4];
					ypointsArea23[8] = 235+a;
					xpointsArea23[9] = xpoints[4];
					ypointsArea23[9] = 235+a;
					
					break;
				}
				else if(((int)xpoints[4]>815)&&((int)xpoints1O3[k]>= (int)xpoints[4])) {
					System.out.println("++++++++in else ++++ k = "+k);
				xpointsArea23[0] = 825;
				ypointsArea23[0] = 235+a;
				
				xpointsArea23[1] = 825;
				ypointsArea23[1] = ypoints1O3[11]+a;
				
				xpointsArea23[2] = xpoints[4]+2;
				ypointsArea23[2] = ypoints1O3[k]+a;
				
				xpointsArea23[3] = xpoints[4]+1;
				ypointsArea23[3] = ypoints1O3[k]+a;
			
				xpointsArea23[4] = xpoints[4];
				ypointsArea23[4] = ypoints1O3[k]+a;
				xpointsArea23[5] = xpoints[4];
				ypointsArea23[5] = 235+a;
				
				xpointsArea23[6] = xpoints[4];
				ypointsArea23[6] = 235+a;
					
				xpointsArea23[7] = xpoints[4];
				ypointsArea23[7] = 235+a;
				xpointsArea23[8] = xpoints[4];
				ypointsArea23[8] = 235+a;
				xpointsArea23[9] = xpoints[4];
				ypointsArea23[9] = 235+a;
				break;
			}
			
		}
			/*System.out.println("xpointsArea23[0] =  "+xpointsArea23[0]+"ypointsArea23[0] = ="+ypointsArea23[0]);	 
			 System.out.println("xpointsArea23[1] =  "+xpointsArea23[1]+"ypointsArea23[1] = ="+ypointsArea23[1]);	 
			 System.out.println("xpointsArea23[2] =  "+xpointsArea23[2]+"ypointsArea23[2] = ="+ypointsArea23[2]);	 
			 System.out.println("xpointsArea23[3] =  "+xpointsArea23[3]+"ypointsArea23[3] = ="+ypointsArea23[3]);	 
			 System.out.println("xpointsArea23[4] =  "+xpointsArea23[4]+"ypointsArea23[4] = ="+ypointsArea23[4]);	 
			 System.out.println("xpointsArea23[5] =  "+xpointsArea23[5]+"ypointsArea23[5] = ="+ypointsArea23[5]);	 
			 System.out.println("xpointsArea23[6] =  "+xpointsArea23[6]+"ypointsArea23[6] = ="+ypointsArea23[6]);	 
			 System.out.println("xpointsArea23[7] =  "+xpointsArea23[7]+"ypointsArea23[7] = ="+ypointsArea23[7]);
			 System.out.println("xpointsArea23[8] =  "+xpointsArea23[8]+"ypointsArea23[8] = ="+ypointsArea23[8]);	 
			 System.out.println("xpointsArea23[9] =  "+xpointsArea23[9]+"ypointsArea23[9] = ="+ypointsArea23[9]);*/	
		}
		else if((int)xpoints[4]> 825){
			for(int k = 0;k<10;k++){
				xpointsArea23[k] = xpoints[1];
				ypointsArea23[k] = 235+a;
			}
		}
		 
	//}//for main	
	/*for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
			if( ic == 775){
				System.out.println("for index = 2++++++++++++++++++++");
				xpointsArea12[2] = ic;
				ypointsArea12[2] = ypoints[2]+a;
				
			}
		}*/
		
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}

public void drawArea_interact23_temp(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	double tempx = 0;
	double tempx1 = 0;
	double tempx2 = 0;
	System.out.println("interact 21-----------------------------------");
	
	for(int i = 775;i<870;i++){
		if(i<=800){
			double  temp = (int)ypoints[1]; 
			//System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
			for(int ia = 775;ia < 800 ;ia++){
				//System.out.println(" ia = "+ia);
				
				
					//System.out.println(" ia = "+ia);
					
					
					if((int)xpoints[0] ==ia){
						//System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
						xpointsArea12[0] = xpoints[0];
						ypointsArea12[0] = ypoints[0]+a;
						
						//System.out.println(" xpointsArea12[0]==== = "+xpointsArea12[0]);
						
					}
				
				
				if((int)xpoints[1] ==ia){
					//System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]+"temp================ =  "+temp);
					xpointsArea12[1] = xpoints[1];
					ypointsArea12[1] = temp+a;
					xpointsArea12[2] = 775;
					ypointsArea12[2] = 235+a+25;
					xpointsArea12[3] = 775;
					ypointsArea12[3] = 235+a;
					xpointsArea12[4] = 775;
					ypointsArea12[4] = 235+a;
					xpointsArea12[5] = 775;
					ypointsArea12[5] = 235+a;
					xpointsArea12[6] = 775;
					ypointsArea12[6] = 235+a;
					
					//System.out.println("for index = 1   after  "+xpoints[1]+"xpointsArea12[1] = "+ypointsArea12[1]);
				}
				temp = temp - .5;
			}
			
			if( xpoints[0] == 800){
				xpointsArea12[0] = xpoints[0];
				ypointsArea12[0] = ypoints[0]+a;
			}
			if(xpoints[1] == 800){
				xpointsArea12[1] = xpoints[0];
				ypointsArea12[1] = temp+a;
				
				xpointsArea12[2] = 775;
				ypointsArea12[2] = 235+a+25;
				xpointsArea12[3] = 775;
				ypointsArea12[3] = 235+a-25;
				xpointsArea12[4] = 775;
				ypointsArea12[4] = 235+a-25;
				xpointsArea12[5] = 775;
				ypointsArea12[5] = 235+a-25;
				xpointsArea12[6] = 775;
				ypointsArea12[6] = 235+a-25;
				tempy = temp;
				//System.out.println(" ----------------------------------tempy = "+tempy);
			}
			//tempP = temp;
		}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[2]<=800)){
				 //tempP = tempy;
			
				double  temp1 = ypoints[3]; 
				double  temp2 = ypoints[2]; 
				double tempP = 247.5;
				for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
					temp1 =temp1 +.5;
					temp2 = temp2 -.5;
					tempP = tempP - .2;
					
					//System.out.println(" indise > 825 for loop---------------temp ="+xpoints[1]);
					//System.out.println(" ic = "+ic+"xpoints2[1] = "+(int)xpoints2[1]);
					if( ic == 800){
						//System.out.println("  in 800-------------------------------");
						xpointsArea12[0] = xpoints[0];
						ypointsArea12[0] = 235+a;
						
						xpointsArea12[1] = xpoints[1];
						ypointsArea12[1] = 235+a-2;
						
						xpointsArea12[2] = 800;
						ypointsArea12[2] = 235+a-15;
						
						xpointsArea12[3] = 800;
						ypointsArea12[3] = 235+a+15;
						
						xpointsArea12[4] = xpoints[3];
						ypointsArea12[4] = 235+a-25;
						xpointsArea12[5] = xpoints[3];
						ypointsArea12[5] = 235+a;
						
						xpointsArea12[6] = xpoints[3];
						ypointsArea12[6] = 235+a;
						tempx = tempP;
						tempx1 = temp1;
						tempx2 = temp2;
						
						
						
					}else{
						//System.out.println("for index = >800   else loop++++++++++++++++++++++++++++++++++++++++++++tempP = "+tempP);
						
						//System.out.println(" tempP = ====================tempy = "+tempP);
							xpointsArea12[0] =xpoints[0];
							ypointsArea12[0] = ypoints[0]+a;
							
							xpointsArea12[1] = xpoints[1];
							ypointsArea12[1] = tempP+a;
							
							xpointsArea12[2] = xpoints[2];
							ypointsArea12[2] = temp2+a;
							
							xpointsArea12[3] = xpoints[3];
							ypointsArea12[3] = temp1+a;
							
							xpointsArea12[4] = 775;
							ypointsArea12[4] = 235+a-25;
							
							xpointsArea12[5] = 775;
							ypointsArea12[5] = 235+a;
							
							xpointsArea12[6] = 775;
							ypointsArea12[6] = 235+a;
						
						}
					
					//System.out.println(" after else-----------------"+ tempP);
					
				}// for
				System.out.println("  in 800-------------------------------tempx = "+tempx+" tempx1 = "+tempx1+"tempx2 = "+tempx2);
		}
		else if(((int)xpoints[2]> 800)&&(xpoints[2]<=825)){
			double county = ypoints[3];
			double county1 = 214;
			double county2 = 258;
			System.out.println("  in  > 800-------------------------------county = "+county+" county1 = "+county1+"county2 = "+county2);
			for(int yy = 381; yy<=405;yy++){
				county = county+.5;
				county1 = county1+.5;
				county2 = county2-.7;
			//System.out.println("  in 800-------------------------------county = "+county+" county1 = "+county1+"county2 = "+county2);
				xpointsArea12[0] = 825;
				ypointsArea12[0] = 235+a;
				
				xpointsArea12[1] = 825;
				ypointsArea12[1] = 237+a;
				
				xpointsArea12[2] = xpoints[2];
				ypointsArea12[2] = county2+a;
				
				xpointsArea12[3] = xpoints[3];
				ypointsArea12[3] = county1+a;
			
				xpointsArea12[4] = xpoints[4];
				ypointsArea12[4] = county+a;
				xpointsArea12[5] = xpoints[4];
				ypointsArea12[5] = 235+a;
				
				xpointsArea12[6] = xpoints[4];
				ypointsArea12[6] = 235+a;
			}
			
			
		}
		else if(((int)xpoints[2]> 825)&&((int)xpoints[4]< 825)){
			double county1 = 222;
			//double county2 = 248;
			county1 = county1+.7;
			
			xpointsArea12[0] = 825;
			ypointsArea12[0] = 235+a;
			
			xpointsArea12[1] = 825;
			ypointsArea12[1] = 237+a;
			
			xpointsArea12[2] = xpoints[4];
			ypointsArea12[2] = county1+a;
			
			xpointsArea12[3] = xpoints[4];
			ypointsArea12[3] = 235+a;
		
			xpointsArea12[4] = xpoints[4];
			ypointsArea12[4] = 235+a;
			xpointsArea12[5] = xpoints[4];
			ypointsArea12[5] = 235+a;
			
			xpointsArea12[6] = xpoints[4];
			ypointsArea12[6] = 235+a;
		}
		else if((int)xpoints[4]>= 825){
			for(int k = 0;k< 7;k++){
				xpointsArea12[k] = xpoints[1];
				ypointsArea12[k] = 235+a;
			}
			
		}
	
	}//for main	
	/*for(int ic = (int)xpoints[1];ic >(int)xpoints[2];ic--){
			if( ic == 775){
				System.out.println("for index = 2++++++++++++++++++++");
				xpointsArea12[2] = ic;
				ypointsArea12[2] = ypoints[2]+a;
				
			}
		}*/
		
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}

public void drawArea_interact31_temp(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	//double yval = 0;
	System.out.println("interact 31-----------------------------------");
	
			if(xpoints[0] <=800){
				System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
				if((int)xpoints[0] == 775){
					xpointsAreaI[0] = xpoints[0];
					ypointsAreaI[0] = ypoints[0]+a;
					xpointsAreaI[1] = xpoints[1];
					ypointsAreaI[1] = ypoints[1]+a;
					xpointsAreaI[2] = xpoints[1];
					ypointsAreaI[2] = ypoints[1]+a;
					xpointsAreaI[3] = xpoints[1];
					ypointsAreaI[3] = ypoints[1]+a;
					
				
				}else if((xpoints[0]>775)&&(xpoints[0]<800)){
				
					for(int k = 2;k<12;k++){
						System.out.println(" inside loop-------------"+xpoints[k]);
						if((int)xpoints[k] < 780){
							
							System.out.println(" ypoints[k] = "+ypoints[k]);
							yval = ypoints[k];
							break;
						}
							
					}
					
				//temp = temp+.8;
				System.out.println("yval =  = "+yval);
				
					//System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
					xpointsAreaI[0] = xpoints[0];
					ypointsAreaI[0] = ypoints[0]+a;
					
					//System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]);
					xpointsAreaI[1] = xpoints[1];
					ypointsAreaI[1] = ypoints[1]+a;
					
					
					xpointsAreaI[2] = 775;
					//ypointsAreaI[2] = temp+a;
					ypointsAreaI[2] = yval+a;
					xpointsAreaI[3] = 775;
					ypointsAreaI[3] = 235+a;
					
					
				}else if( xpoints[0] == 800){
				xpointsAreaI[0] = xpoints[0];
				ypointsAreaI[0] = ypoints[0]+a;
					
					
				xpointsAreaI[1] = xpoints[0];
				ypointsAreaI[1] = ypoints[1]+a;
				xpointsAreaI[2] = 775;
				//ypointsAreaI[2] = temp+a;
				ypointsAreaI[2] = yval+a;
				xpointsAreaI[3] = 775;
				ypointsAreaI[3] = 235+a;
				
					}
					tempy = temp;
			
			}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[0]<= 825)){
			System.out.println(" indise >308 for loop---------------temp ="+xpoints[7]);
			
				
			if(xpoints[0]<825){
				for(int k = 0;k<12;k++){
					System.out.println(" inside loop-------------"+xpoints[k]);
					if((int)xpoints[k] < 780){
						
						System.out.println(" ypoints[k] = "+ypoints[k]);
						yval = ypoints[k];
						break;
					}
						
				}
				
				for(int k1 = 2;k1<12;k1++){
					System.out.println(" inside loop-------------"+xpoints[k1]);
					if(((int)xpoints[k1] <=805)&&((int)xpoints[k1]>=795)){
						
						System.out.println(" ypoints["+k1+"] = "+ypoints[k1]);
						yval1 = ypoints[k1];
						break;
					}
						
				}
				//System.out.println("for index = 2");
				//temp =temp+.4;
				
					//temp31 = temp31+.8;
				
					xpointsAreaI[0] = 800;
					ypointsAreaI[0] = 235+a;
					
					xpointsAreaI[1] = 800;
					//ypointsAreaI[1] = temp31+a;
					ypointsAreaI[1] = yval1+a;
					xpointsAreaI[2] = 775;
					//ypointsAreaI[2] = temp+a;
					ypointsAreaI[2] = yval+a;
					xpointsAreaI[3] = 775;
					ypointsAreaI[3] = 235+a;
					
					//System.out.println("temp = "+tempP);
				
				}
			else if( xpoints[0] == 825){
						//System.out.println("  in 800-------------------------------");
						xpointsAreaI[0] = 800;
						ypointsAreaI[0] = 235+a;
						
						xpointsAreaI[1] = 800;
						//ypointsAreaI[1] = temp31+a;
						ypointsAreaI[1] = yval1+a;
						xpointsAreaI[2] = 775;
						//ypointsAreaI[2] = temp+a;
						ypointsAreaI[2] = yval+a;
						
						xpointsAreaI[3] = 775;
						ypointsAreaI[3] = 235+a;
						
						
					}
				
				
		}
		else if(((int)xpoints[0]>825)&&(xpoints[0]<=850)){
			for(int k1 = 2;k1<12;k1++){
				System.out.println(" inside loop-------------"+xpoints[k1]);
				if(((int)xpoints[k1] <=805)&&((int)xpoints[k1]>=795)){
					
					System.out.println(" ypoints["+k1+"] = "+ypoints[k1]);
					yval1 = ypoints[k1];
					break;
				}
					
			}
			
			System.out.println(" temp31======================= = "+temp31);
				//temp31 = temp31+.5;
				
			xpointsAreaI[0] = 800;
			ypointsAreaI[0] = 235+a;
			
			xpointsAreaI[1] = 800;
			//ypointsAreaI[1] = temp31+a;
			ypointsAreaI[1] = yval1+a;
			
			xpointsAreaI[2] = xpoints[11];
			ypointsAreaI[2] = 235+a;
			
			xpointsAreaI[3] = xpoints[11];
			ypointsAreaI[3] = 235+a;
			
			
		}
		else if((int)xpoints[2]> 850){
			for(int k = 0;k< 4;k++){
				xpointsAreaI[k] = xpoints[1];
				ypointsAreaI[k] = 235+a;
			}
			
		}
	
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}


public void drawArea_interact31(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	double res = 0;
	double res1 = 0;
	//double yval = 0;
	System.out.println("interact 31- current----------------------------------");
	//for(int c = 0;c<xpoints2O3.length;c++){
		//System.out.println("xpoints2O3["+c+"] ="+xpoints2O3[c]);
		//System.out.println("ypoints2O3["+c+"] ="+ypoints2O3[c]);
	//}
			if(xpoints[0] <=800){
				System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
				if((int)xpoints[0] == 775){
					xpointsArea22[0] = xpoints[0];
					ypointsArea22[0] = ypoints[0]+a;
					xpointsArea22[1] = xpoints[1];
					ypointsArea22[1] = ypoints[1]+a;
					xpointsArea22[2] = xpoints[1];
					ypointsArea22[2] = ypoints[1]+a;
					xpointsArea22[3] = xpoints[1];
					ypointsArea22[3] = ypoints[1]+a;
					xpointsArea22[4] = xpoints[1];
					ypointsArea22[4] = ypoints[1]+a;
					xpointsArea22[5] = xpoints[1];
					ypointsArea22[5] = ypoints[1]+a;
					xpointsArea22[6] = xpoints[1];
					ypointsArea22[6] = ypoints[1]+a;
					xpointsArea22[7] = xpoints[1];
					ypointsArea22[7] = ypoints[1]+a;
					
				
				}else if((xpoints[0]>775)&&(xpoints[0]<=800)){
				
				System.out.println("------------ >775 & <=800");
					
					val = val-0.05;
					res = Math.exp(val)*1;
					System.out.println(" res === "+res);
					
					
					
					y = 350 - (res*25);
					
				
					System.out.println("yval =  = "+yval);
				
					//System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
					xpointsArea22[0] = xpoints[0];
					ypointsArea22[0] = ypoints[0]+a;
					
					//System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]);
					
					
					
					
					//---
					if(xpoints[0]>788){
						System.out.println("------------ >368 & <=800");
						for(int j = 0;j<xpoints2O3.length;j++){
							if((xpoints2O3[j]<=800)&&(xpoints2O3[j]>788)){
								xpointsArea22[1] = xpoints[j];
								ypointsArea22[1] = ypoints2O3[j]+a;
								if(xpoints2O3[j+1]>=775){
									xpointsArea22[2] = xpoints2O3[j+1];
									ypointsArea22[2] = ypoints2O3[j+1]+a;
								}else{
									xpointsArea22[1] = xpoints[j];
									ypointsArea22[1] = ypoints2O3[j]+a;
								}
								if(xpoints2O3[j+2]>=775){
									xpointsArea22[3] = xpoints2O3[j+2];
									ypointsArea22[3] = ypoints2O3[j+2]+a;
								}else{
									if(xpoints2O3[j+1]>=775){
										xpointsArea22[1] = xpoints[j+1];
										ypointsArea22[1] = ypoints2O3[j+1]+a;
									}else{
										xpointsArea22[1] = xpoints[j];
										ypointsArea22[1] = ypoints2O3[j]+a;
									}
								}
								if(xpoints2O3[j+3]>=775){
									xpointsArea22[4] = xpoints2O3[j+3];
									ypointsArea22[4] = ypoints2O3[j+3]+a;	
								}else{
										if(xpoints2O3[j+2]>=775){
											xpointsArea22[3] = xpoints2O3[j+2];
											ypointsArea22[3] = ypoints2O3[j+2]+a;
										}else{
											if(xpoints2O3[j+1]>=775){
												xpointsArea22[1] = xpoints[j+1];
												ypointsArea22[1] = ypoints2O3[j+1]+a;
											}else{
												xpointsArea22[1] = xpoints[j];
												ypointsArea22[1] = ypoints2O3[j]+a;
											}
										}
								}
								
								break;
							}
						}
					}
						else{
						System.out.println("------------ <368 & <=800");
						xpointsArea22[1] = xpoints[1];
						ypointsArea22[1] = 235+a-25;
						xpointsArea22[2] = 775;
						ypointsArea22[2] = y;
						xpointsArea22[3] = 775;
						ypointsArea22[3] = y;
						xpointsArea22[4] = 775;
						ypointsArea22[4] = y;
					}
					//--
					xpointsArea22[5] = 775;
					ypointsArea22[5] = y;
					//System.out.println(" xpointsArea22[1] == "+xpointsArea22[1]+"ypointsArea22[1] == "+ypointsArea22[1]);
				
				
				xpointsArea22[6] = 775;
				ypointsArea22[6] = 235+a;
				xpointsArea22[7] = 775;
				ypointsArea22[7] = 235+a;
				}
				
		}// if <=800
		else if(((int)xpoints[0]> 800)&&(xpoints[0]<= 825)){
			System.out.println(" indise >308 for loop---------------temp ="+xpoints[7]);
			val = val-0.05;
			res = Math.exp(val)*1;
			System.out.println(" res === "+res);
			
			y = 350 - (res*25);
			System.out.println("val =  = "+val);
			
			xpointsArea22[0] = 800;
			ypointsArea22[0] = 235+a;
			//int ct = 0;
			
			
				
			//if(xpoints[0]<825){
				for(int k = 1;k<xpoints2O3.length;k++){
					System.out.println(" inside loop-------------"+xpoints[k]);
					if(((int)xpoints2O3[k]>800)&&((int)xpoints2O3[k]<=825)&&((int)xpoints2O3[k+1]<=800)){
						xpointsArea22[1] = 800;
						ypointsArea22[1] = ypoints2O3[k+1]+a;
						
						xpointsArea22[2] = xpoints2O3[k+2];
						ypointsArea22[2] = ypoints2O3[k+2]+a;
						
						xpointsArea22[3] = xpoints2O3[k+3];
						ypointsArea22[3] = ypoints2O3[k+3]+a;
						
						xpointsArea22[4] = xpoints2O3[k+4];
						ypointsArea22[4] = ypoints2O3[k+4]+a;
						
						xpointsArea22[5] = xpoints2O3[k+5];
						ypointsArea22[5] = ypoints2O3[k+5]+a;
						
						break;
					}
						
						
				}
						
				
				
			/*	
				System.out.println(" xpointsArea22[1] == "+xpointsArea22[1]+"ypointsArea22[1] == "+ypointsArea22[1]);
				System.out.println(" xpointsArea22[2] == "+xpointsArea22[2]+"ypointsArea22[2] == "+ypointsArea22[2]);
				System.out.println(" xpointsArea22[3] == "+xpointsArea22[3]+"ypointsArea22[3] == "+ypointsArea22[3]);
				System.out.println(" xpointsArea22[4] == "+xpointsArea22[4]+"ypointsArea22[4] == "+ypointsArea22[4]);
				System.out.println(" xpointsArea22[5] == "+xpointsArea22[5]+"ypointsArea22[5] == "+ypointsArea22[5]);*/
				
				xpointsArea22[6] = 775;
				ypointsArea22[6] = y;
				xpointsArea22[7] = 775;
				ypointsArea22[7] = 235+a;
				
				
				
			
				
				
		}
		else if(((int)xpoints[0]>825)&&(xpoints[0]<=850)){
			
			for(int k1 = 2;k1<12;k1++){
				System.out.println(" inside loop-------------"+xpoints[k1]);
				if(((int)xpoints2O3[k1] <=800)&&((int)xpoints2O3[k1]>=795)){
					
					System.out.println(" ypoints2O3["+k1+"] = "+ypoints2O3[k1]);
					yval1 = ypoints2O3[k1];
					break;
				}
					
			}
			
			
			xpointsArea22[0] = 800;
			ypointsArea22[0] = 235+a;
			
			xpointsArea22[1] = 800;
			ypointsArea22[1] = yval1+a;
			
			
			xpointsArea22[2] = 800;
			ypointsArea22[2] = yval1+a;
			
			
			xpointsArea22[3] = 800;
			ypointsArea22[3] = yval1+a;
			
			
			xpointsArea22[4] = 800;
			ypointsArea22[4] = yval1+a;
			
			
			xpointsArea22[5] = xpoints2O3[11];
			ypointsArea22[5] = ypoints2O3[11]+a;
			
			
			xpointsArea22[6] = xpoints2O3[11];
			ypointsArea22[6] = ypoints2O3[11]+a;
			
			
			xpointsArea22[7] = xpoints2O3[11];
			ypointsArea22[7] = 235+a;
			
			
			
			
			
			//--------------------------------------------
			
			/*System.out.println(" xpointsArea22[1] == "+xpointsArea22[1]+"ypointsArea22[1] == "+ypointsArea22[1]);
			System.out.println(" xpointsArea22[2] == "+xpointsArea22[2]+"ypointsArea22[2] == "+ypointsArea22[2]);
			System.out.println(" xpointsArea22[3] == "+xpointsArea22[3]+"ypointsArea22[3] == "+ypointsArea22[3]);
			System.out.println(" xpointsArea22[4] == "+xpointsArea22[4]+"ypointsArea22[4] == "+ypointsArea22[4]);
			System.out.println(" xpointsArea22[5] == "+xpointsArea22[5]+"ypointsArea22[5] == "+ypointsArea22[5]);
			System.out.println(" xpointsArea22[6] == "+xpointsArea22[6]+"ypointsArea22[6] == "+ypointsArea22[6]);
			System.out.println(" xpointsArea22[7] == "+xpointsArea22[7]+"ypointsArea22[7] == "+ypointsArea22[7]);*/
		}
			
			
			
		else if((int)xpoints[2]>850){
			for(int k = 0;k< 8;k++){
				xpointsArea22[k] = xpoints[1];
				ypointsArea22[k] = 235+a;
			}
			
		}
	
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}


public void drawArea_interact32_temp(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	
	System.out.println("interact 32-----------------------------------");
	
			if(xpoints[0] <=800){
				System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
				if((int)xpoints[0] == 775){
					xpointsArea12[0] = xpoints[0];
					ypointsArea12[0] = ypoints[0]+a;
					xpointsArea12[1] = xpoints[1];
					ypointsArea12[1] = ypoints[1]+a+50;
					xpointsArea12[2] = xpoints[1];
					ypointsArea12[2] = ypoints[1]+a+50;
					xpointsArea12[3] = xpoints[1];
					ypointsArea12[3] = ypoints[1]+a+50;
					
				
				}else if((xpoints[0]>775)&&(xpoints[0]<800)){
				
				//temp = temp+.8;
				//System.out.println("temp = "+temp);
				
					System.out.println("for index = 0  "+xpoints[0]+"ypoints = ="+ypoints[0]);
					xpointsArea12[0] = xpoints[0];
					ypointsArea12[0] = ypoints[0]+a;
					
					System.out.println("for index = 1  "+xpoints[1]+"ypoints = "+ypoints[1]);
					xpointsArea12[1] = xpoints[1];
					ypointsArea12[1] = ypoints[1]+a+50;
					
					for(int k = 2;k<12;k++){
						System.out.println(" inside loop-------------"+xpoints[k]);
						if((int)xpoints[k] < 780){
							
							System.out.println(" ypoints[k] = "+ypoints[k]);
							yval = ypoints[k];
							break;
						}
							
					}
					xpointsArea12[2] = 775;
					//ypointsAreaI[2] = temp+a;
					double tempv = 2* (235-yval);
					
					ypointsArea12[2] = yval+a+tempv;
					xpointsArea12[3] = 775;
					ypointsArea12[3] = 235+a;
					
					
				}else if( xpoints[0] == 800){
				xpointsArea12[0] = xpoints[0];
				ypointsArea12[0] = ypoints[0]+a;
					
					
				xpointsArea12[1] = xpoints[0];
				ypointsArea12[1] = ypoints[1]+a+50;
				xpointsArea12[2] = 775;
				//ypointsArea12[2] = temp+a;
				double tempv = 2* (235-yval);
				ypointsArea12[2] = yval+a+tempv;
				xpointsArea12[3] = 775;
				ypointsArea12[3] = 235+a;
				
					}
					//tempy = temp;
			
			}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[0]<= 825)){
			System.out.println(" indise >308 for loop---------------temp ="+xpoints[7]);
			
			  for(int k = 0;k<12;k++){
					System.out.println(" inside loop-------------"+xpoints[k]);
					if((int)xpoints[k] < 780){
								
						System.out.println(" ypoints[k] = "+ypoints[k]);
						yval = ypoints[k];
						break;
						}
								
					}
						
					for(int k1 = 2;k1<12;k1++){
						System.out.println(" inside loop-------------"+xpoints[k1]);
						if(((int)xpoints[k1] <=805)&&((int)xpoints[k1]>=795)){
								
							System.out.println(" ypoints["+k1+"] = "+ypoints[k1]);
							yval1 = ypoints[k1];
							break;
						}
								
					}
					
					double tempv = 2* (235-yval);
					double tempv1 = 2* (235-yval1);
				
					xpointsArea12[0] = xpoints[0];
					ypointsArea12[0] = 235+a;
					
					xpointsArea12[1] = xpoints[1];
					ypointsArea12[1] = ypoints[1]+a;
					xpointsArea12[2] = 800;
					ypointsArea12[2] = yval1+a;
					xpointsArea12[3] = 800;
					ypointsArea12[3] = yval1+a+tempv1;
					xpointsArea12[4] = 775;
					ypointsArea12[4] = yval+a+tempv;
					
					
					
				
				}
			
		else if(((int)xpoints[0]>825)&&(xpoints[0]<=850)){
			
			for(int k = 0;k<12;k++){
				System.out.println(" inside loop-------------"+xpoints[k]);
				if((int)xpoints[k] < 780){
							
					System.out.println(" ypoints[k] = "+ypoints[k]);
					yval = ypoints[k];
					break;
					}
							
				}
					
				for(int k1 = 2;k1<12;k1++){
					System.out.println(" inside loop-------------"+xpoints[k1]);
					if(((int)xpoints[k1] <=805)&&((int)xpoints[k1]>=795)){
							
						System.out.println(" ypoints["+k1+"] = "+ypoints[k1]);
						yval1 = ypoints[k1];
						break;
					}
							
				}
				
				for(int k2 = 2;k2<12;k2++){
					System.out.println(" inside loop-------------"+xpoints[k2]);
					if(((int)xpoints[k2] <=830)&&((int)xpoints[k2]>=815)){
							
						System.out.println(" ypoints["+k2+"] = "+ypoints[k2]);
						yval2 = ypoints[k2];
						break;
					}
							
				}
				
				double tempv = 2* (235-yval);
				double tempv1 = 2* (235-yval1);
			
			//System.out.println(" temp31======================= = "+temp31);
				//temp31 = temp31+.5;
				
			xpointsArea12[0] = 825;
			ypointsArea12[0] = 235+a;
			
			xpointsArea12[1] = 825;
			ypointsArea12[1] = yval2+a;
			
			xpointsArea12[2] = 800;
			ypointsArea12[2] = yval1+a;
			
			xpointsArea12[3] = 800;
			ypointsArea12[3] = yval1+a+tempv1;
			xpointsArea12[4] = xpoints[11];
			ypointsArea12[4] = yval+a+tempv;
			xpointsArea12[5] = xpoints[12];
			ypointsArea12[5] = 235+a;
			xpointsArea12[6] = xpoints[12];
			ypointsArea12[6] = 235+a;
			//xpointsArea12[7] = xpoints[10];
			//ypointsArea12[7] = 235+a;
		}
		else if(((int)xpoints[0]>850)&&((int)xpoints[0]<=875)){
			for(int k1 = 2;k1<12;k1++){
				System.out.println(" inside loop-------------"+xpoints[k1]);
				if(((int)xpoints[k1] <=805)&&((int)xpoints[k1]>=795)){
						
					System.out.println(" ypoints["+k1+"] = "+ypoints[k1]);
					yval1 = ypoints[k1];
					break;
				}
						
			}
			
			for(int k2 = 2;k2<12;k2++){
				System.out.println(" inside loop-------------"+xpoints[k2]);
				if(((int)xpoints[k2] <=830)&&((int)xpoints[k2]>=815)){
						
					System.out.println(" ypoints["+k2+"] = "+ypoints[k2]);
					yval2 = ypoints[k2];
					break;
				}
						
			}
			xpointsArea12[0] = 825;
			ypointsArea12[0] = 235+a;
			
			xpointsArea12[1] = 825;
			ypointsArea12[1] = yval2+a;
			
			xpointsArea12[2] = xpoints[11];
			ypointsArea12[2] = yval1+a;
			
			xpointsArea12[3] = xpoints[11];
			ypointsArea12[3] = yval1+a;;
			xpointsArea12[4] = xpoints[12];
			ypointsArea12[4] = 235+a;
			xpointsArea12[5] = xpoints[12];
			ypointsArea12[5] = 235+a;
			xpointsArea12[6] = xpoints[12];
			ypointsArea12[6] = 235+a;
		}
		else if((int)xpoints[2]> 875){
			for(int k = 0;k< 7;k++){
				xpointsArea12[k] = xpoints[1];
				ypointsArea12[k] = 235+a;
			}
			
		}
	
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}


public void drawArea_interact32(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	
	System.out.println("interact 32-----------------------------------");
	for(int i= 0;i<xpoints2O3.length;i++){
		System.out.println(" xpoints2O3["+i+"] = "+xpoints2O3[i]);
		System.out.println(" ypoints2O3["+i+"] = "+ypoints2O3[i]);
	}
			if(xpoints[0] <=800){
				
				if((int)xpoints[0] == 775){
					xpointsArea23[0] = xpoints[0];
					ypointsArea23[0] = ypoints[0]+a;
					for(int i =1;i<10;i++){
						xpointsArea23[i] = xpoints[1];
						ypointsArea23[i] = ypoints[1]+a+50;
					}
					
				}else if((xpoints[0]>775)&&(xpoints[0]<788)){
					for(int j = 1;j<xpoints2O3.length;j++){
						System.out.println("j = ======="+j);
						if(xpoints2O3[j]>775){
							xpointsArea23[0] = xpoints[0];
							ypointsArea23[0] = 235+a;
							xpointsArea23[1] = xpoints2O3[0];
							ypointsArea23[1] = 235+a+25;
							if(xpoints2O3[j]<780){
								
								xpointsArea23[2] = xpoints[j];
								ypointsArea23[2] = ypoints2O3[j]+a+(2*(235-ypoints2O3[j]));
								xpointsArea23[3] = xpoints[j];
								ypointsArea23[3] = ypoints2O3[j]+a+(2*(235-ypoints2O3[j]));
								xpointsArea23[4] = xpoints[j];
								ypointsArea23[4] = ypoints2O3[j]+a+(2*(235-ypoints2O3[j]));
								xpointsArea23[5] = xpoints[j];
								ypointsArea23[5] = ypoints2O3[j]+a+(2*(235-ypoints2O3[j]));
								xpointsArea23[6] = xpoints[j];
								ypointsArea23[6] = ypoints2O3[j]+a+(2*(235-ypoints2O3[j]));
								xpointsArea23[7] = xpoints[j];
								ypointsArea23[7] = ypoints2O3[j]+a+(2*(235-ypoints2O3[j]));
								xpointsArea23[8] = 775;
								ypointsArea23[8] = ypoints2O3[j]+a+(2*(235-ypoints2O3[j]));
								xpointsArea23[9] = 775;
								ypointsArea23[9] = 235+a;
								
								break;
							}else if((xpoints2O3[j]>=780)&&(xpoints2O3[j]<785)){
								xpointsArea23[2] = xpoints[j];
								ypointsArea23[2] = ypoints2O3[j]+a+(2*(235-ypoints2O3[j]));
								xpointsArea23[3] = xpoints[j+1];
								ypointsArea23[3] = ypoints2O3[j+1]+a+(2*(235-ypoints2O3[j+1]));
								xpointsArea23[4] = xpoints[j+1];
								ypointsArea23[4] = ypoints2O3[j+1]+a+(2*(235-ypoints2O3[j+1]));
								xpointsArea23[5] = xpoints[j+1];
								ypointsArea23[5] = ypoints2O3[j+1]+a+(2*(235-ypoints2O3[j+1]));
								xpointsArea23[6] = xpoints[j+1];
								ypointsArea23[6] = ypoints2O3[j+1]+a+(2*(235-ypoints2O3[j+1]));
								xpointsArea23[7] = xpoints[j+1];
								ypointsArea23[7] = ypoints2O3[j+1]+a+(2*(235-ypoints2O3[j+1]));
								xpointsArea23[8] = 775;
								ypointsArea23[8] = ypoints2O3[j+1]+a+(2*(235-ypoints2O3[j+1]));
								xpointsArea23[9] = 775;
								ypointsArea23[9] = 235+a;
								break;
							}else if((xpoints2O3[j]>=785)&&(xpoints2O3[j]<788)){
								xpointsArea23[2] = xpoints[j];
								ypointsArea23[2] = ypoints2O3[j]+a+(2*(235-ypoints2O3[j]));
								xpointsArea23[3] = xpoints[j+1];
								ypointsArea23[3] = ypoints2O3[j+1]+a+(2*(235-ypoints2O3[j+1]));
								xpointsArea23[4] = xpoints[j+2];
								ypointsArea23[4] = ypoints2O3[j+2]+a+(2*(235-ypoints2O3[j+2]));
								xpointsArea23[5] = xpoints[j+2];
								ypointsArea23[5] = ypoints2O3[j+2]+a+(2*(235-ypoints2O3[j+2]));
								xpointsArea23[6] = xpoints[j+2];
								ypointsArea23[6] = ypoints2O3[j+2]+a+(2*(235-ypoints2O3[j+2]));
								xpointsArea23[7] = xpoints[j+2];
								ypointsArea23[7] = ypoints2O3[j+2]+a+(2*(235-ypoints2O3[j+2]));
								xpointsArea23[8] = 775;
								ypointsArea23[8] = ypoints2O3[j+2]+a+(2*(235-ypoints2O3[j+2]));
								xpointsArea23[9] = 775;
								ypointsArea23[9] = 235+a;
								break;
							}
							
							
						}
					}
					
		
				}else if(((int)xpoints[0]>=788)&&((int)xpoints[0]<=800)){
					System.out.println(" >=368 and <800-------------");
					for(int k = 1;k<12;k++){
						System.out.println(" k="+k+"xpoints2O3 = "+xpoints2O3[k]+" xpoints[0] = "+xpoints[0]);
						if((int)xpoints2O3[k]<= xpoints[0]){
							xpointsArea23[0] = xpoints[0];
							ypointsArea23[0] = 235+a;
							xpointsArea23[1] = xpoints[0];
							ypointsArea23[1] = 235+a+25;
							xpointsArea23[2] = xpoints2O3[k+1];
							ypointsArea23[2] = ypoints2O3[k+1]+a+(2*(235-ypoints2O3[k+1]));
							xpointsArea23[3] = xpoints2O3[k+2];
							ypointsArea23[3] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
							if((int)xpoints[0]<792){
								xpointsArea23[4] = xpoints2O3[k+2];
								ypointsArea23[4] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
								xpointsArea23[5] = xpoints2O3[k+2];
								ypointsArea23[5] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
								xpointsArea23[6] = 775;
								ypointsArea23[6] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
								xpointsArea23[7] = 775;
								ypointsArea23[7] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
							}else if((int)xpoints[0]<798){
								xpointsArea23[4] = xpoints2O3[k+3];
								ypointsArea23[4] = ypoints2O3[k+3]+a+(2*(235-ypoints2O3[k+3]));
								xpointsArea23[5] = xpoints2O3[k+3];
								ypointsArea23[5] = ypoints2O3[k+3]+a+(2*(235-ypoints2O3[k+3]));
								xpointsArea23[6] = 775;
								ypointsArea23[6] = ypoints2O3[k+3]+a+(2*(235-ypoints2O3[k+3]));
								xpointsArea23[7] = 775;
								ypointsArea23[7] = ypoints2O3[k+3]+a+(2*(235-ypoints2O3[k+3]));
							}else if(((int)xpoints[0]>798)&&((int)xpoints[0]<800)){
								xpointsArea23[4] = xpoints2O3[k+3];
								ypointsArea23[4] = ypoints2O3[k+3]+a+(2*(235-ypoints2O3[k+3]));
								xpointsArea23[5] = xpoints2O3[k+4];
								ypointsArea23[5] = ypoints2O3[k+4]+a+(2*(235-ypoints2O3[k+4]));
								xpointsArea23[6] = 775;
								ypointsArea23[6] = ypoints2O3[k+4]+a+(2*(235-ypoints2O3[k+4]));
								xpointsArea23[7] = 775;
								ypointsArea23[7] = ypoints2O3[k+4]+a+(2*(235-ypoints2O3[k+4]));
							}
							else if((int)xpoints[0] == 800){
								xpointsArea23[0] = xpoints[0];
								ypointsArea23[0] = 235+a-25;
								
							}
							xpointsArea23[8] = 775;
							ypointsArea23[8] = 235+a;
							xpointsArea23[9] = 775;
							ypointsArea23[9] = 235+a;
							
							break;
							
						}
					}
					

				}
					
			
			}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[0]<= 825)){
			System.out.println(" indise >800 and <= 825 for loop---");
			
			  for(int k = 1;k<12;k++){
				  System.out.println("k = "+k+"xpoints2O3[k] = "+xpoints2O3[k]+"xpoints[0] = "+xpoints[0]);
					if(((int)xpoints2O3[k]<=805 )&&((int)xpoints2O3[k]>800)){
						//System.out.println(" xpoints203[k+1] = "+xpoints2O3[k+1]);
						
							xpointsArea23[0] = xpoints[0];
							ypointsArea23[0] = 235+a;
							xpointsArea23[1] = xpoints[1];
							ypointsArea23[1] = ypoints[1]+a;
							if(xpoints2O3[0]<=805){//1
								xpointsArea23[2] = 800;
								ypointsArea23[2] = ypoints2O3[k]+a+2;
								xpointsArea23[3] = 800;
								ypointsArea23[3] = ypoints2O3[k]+a+(2*(235-ypoints2O3[k]))-2;
								
								xpointsArea23[4] = xpoints2O3[k+1];
								ypointsArea23[4] = ypoints2O3[k+1]+a+(2*(235-ypoints2O3[k+1]));
								xpointsArea23[5] = xpoints2O3[k+2];
								ypointsArea23[5] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
								xpointsArea23[6] = xpoints2O3[k+3];
								ypointsArea23[6] = ypoints2O3[k+3]+a+(2*(235-ypoints2O3[k+3]));
								xpointsArea23[7] = xpoints2O3[k+4];
								ypointsArea23[7] = ypoints2O3[k+4]+a+(2*(235-ypoints2O3[k+4]));
								xpointsArea23[8] = 775;
								ypointsArea23[8] = ypoints2O3[k+5]+a+(2*(235-ypoints2O3[k+5]));
								xpointsArea23[9] = 775;
								ypointsArea23[9] = 235+a;
								break;
							}else if(((int)xpoints2O3[0]>805)&&((int)xpoints2O3[0]<810)){//2
								System.out.println(" =====k+1========= xpoints203[k+1] = "+xpoints2O3[k+1]);
								xpointsArea23[2] = xpoints2O3[k];
								ypointsArea23[2] = ypoints2O3[k]+a;
								xpointsArea23[3] = 800;
								ypointsArea23[3] = ypoints2O3[k]+a+2;
								xpointsArea23[4] = 800;
								ypointsArea23[4] = ypoints2O3[k]+a+(2*(235-ypoints2O3[k]))-2;
								xpointsArea23[5] = xpoints2O3[k+1];
								ypointsArea23[5] = ypoints2O3[k+1]+a+(2*(235-ypoints2O3[k+1]));
								xpointsArea23[6] = xpoints2O3[k+3];
								ypointsArea23[6] = ypoints2O3[k+3]+a+(2*(235-ypoints2O3[k+3]));
								xpointsArea23[7] = xpoints2O3[k+4];
								ypointsArea23[7] = ypoints2O3[k+4]+a+(2*(235-ypoints2O3[k+4]));
								xpointsArea23[8] = 775;
								ypointsArea23[8] = ypoints2O3[k+5]+a+(2*(235-ypoints2O3[k+5]));
								xpointsArea23[9] = 775;
								ypointsArea23[9] = 235+a;
								break;
							}else if(((int)xpoints2O3[0]>=810)&&((int)xpoints2O3[0]<815)){//3
							
								xpointsArea23[2] = xpoints2O3[k-1];
								ypointsArea23[2] = ypoints2O3[k-1]+a;
								xpointsArea23[3] = xpoints2O3[k];
								ypointsArea23[3] = ypoints2O3[k]+a;
								xpointsArea23[4] = 800;
								ypointsArea23[4] = ypoints2O3[k]+a+2;
								xpointsArea23[5] = 800;
								ypointsArea23[5] = ypoints2O3[k]+a+(2*(235-ypoints2O3[k]))-2;
								xpointsArea23[6] = xpoints2O3[k+2];
								ypointsArea23[6] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
								xpointsArea23[7] = xpoints2O3[k+4];
								ypointsArea23[7] = ypoints2O3[k+4]+a+(2*(235-ypoints2O3[k+4]));
								xpointsArea23[8] = 775;
								ypointsArea23[8] = ypoints2O3[k+5]+a+(2*(235-ypoints2O3[k+5]));
								xpointsArea23[9] = 775;
								ypointsArea23[9] = 235+a;
								break;
						}else if(((int)xpoints2O3[0]>=815)&&((int)xpoints2O3[0]<820)){//4
							
							xpointsArea23[2] = xpoints2O3[k-2];
							ypointsArea23[2] = ypoints2O3[k-2]+a;
							xpointsArea23[3] = xpoints2O3[k-1];
							ypointsArea23[3] = ypoints2O3[k-1]+a;
							xpointsArea23[4] = 800;
							ypointsArea23[4] = ypoints2O3[k]+a;
							
							xpointsArea23[5] = 800;
							ypointsArea23[5] = ypoints2O3[k]+a+(2*(235-ypoints2O3[k]));
							xpointsArea23[6] = xpoints2O3[k+2];
							ypointsArea23[6] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
							
							xpointsArea23[7] = xpoints2O3[k+3];
							ypointsArea23[7] = ypoints2O3[k+3]+a+(2*(235-ypoints2O3[k+3]));
							xpointsArea23[8] = 775;
							ypointsArea23[8] = ypoints2O3[k+5]+a+(2*(235-ypoints2O3[k+5]));
							xpointsArea23[9] = 775;
							ypointsArea23[9] = 235+a;
							
							break;
					}else if(((int)xpoints2O3[0]>=820)&&((int)xpoints2O3[0]<825)){//5
						
						xpointsArea23[2] = xpoints2O3[k-2];
						ypointsArea23[2] = ypoints2O3[k-2]+a;
						xpointsArea23[3] = xpoints2O3[k-1];
						ypointsArea23[3] = ypoints2O3[k-1]+a;
						xpointsArea23[4] = 800;
						ypointsArea23[4] = ypoints2O3[k]+a;
						
						xpointsArea23[5] = 800;
						ypointsArea23[5] = ypoints2O3[k]+a+(2*(235-ypoints2O3[k]));
						xpointsArea23[6] = xpoints2O3[k+2];
						ypointsArea23[6] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
						
						xpointsArea23[7] = xpoints2O3[k+4];
						ypointsArea23[7] = ypoints2O3[k+4]+a+(2*(235-ypoints2O3[k+4]));
						xpointsArea23[8] = 775;
						ypointsArea23[8] = ypoints2O3[k+6]+a+(2*(235-ypoints2O3[k+6]));
						xpointsArea23[9] = 775;
						ypointsArea23[9] = 235+a;
						
						break;
					}
					else if((int)xpoints2O3[0]==825){//5
						
						xpointsArea23[2] = xpoints2O3[k-3];
						ypointsArea23[2] = ypoints2O3[k-3]+a;
						xpointsArea23[3] = xpoints2O3[k-2];
						ypointsArea23[3] = ypoints2O3[k-2]+a;
						xpointsArea23[4] = 800;
						ypointsArea23[4] = ypoints2O3[k]+a;
						
						xpointsArea23[5] = 800;
						ypointsArea23[5] = ypoints2O3[k]+a+(2*(235-ypoints2O3[k]));
						xpointsArea23[6] = xpoints2O3[k+2];
						ypointsArea23[6] = ypoints2O3[k+2]+a+(2*(235-ypoints2O3[k+2]));
						
						xpointsArea23[7] = xpoints2O3[k+4];
						ypointsArea23[7] = ypoints2O3[k+4]+a+(2*(235-ypoints2O3[k+4]));
						xpointsArea23[8] = xpoints2O3[k+6];
						ypointsArea23[8] = ypoints2O3[k+6]+a+(2*(235-ypoints2O3[k+6]));
						xpointsArea23[9] = 775;
						ypointsArea23[9] = 235+a;
						
						break;
				}
					
					}
					
				
				}
			 /* System.out.println("xpointsArea23[0] =  "+xpointsArea23[0]+"ypointsArea23[0] = ="+ypointsArea23[0]);	 
				 System.out.println("xpointsArea23[1] =  "+xpointsArea23[1]+"ypointsArea23[1] = ="+ypointsArea23[1]);	 
				 System.out.println("xpointsArea23[2] =  "+xpointsArea23[2]+"ypointsArea23[2] = ="+ypointsArea23[2]);	 
				 System.out.println("xpointsArea23[3] =  "+xpointsArea23[3]+"ypointsArea23[3] = ="+ypointsArea23[3]);	 
				 System.out.println("xpointsArea23[4] =  "+xpointsArea23[4]+"ypointsArea23[4] = ="+ypointsArea23[4]);	 
				 System.out.println("xpointsArea23[5] =  "+xpointsArea23[5]+"ypointsArea23[5] = ="+ypointsArea23[5]);	 
				 System.out.println("xpointsArea23[6] =  "+xpointsArea23[6]+"ypointsArea23[6] = ="+ypointsArea23[6]);	 
				 System.out.println("xpointsArea23[7] =  "+xpointsArea23[7]+"ypointsArea23[7] = ="+ypointsArea23[7]);
				 System.out.println("xpointsArea23[8] =  "+xpointsArea23[8]+"ypointsArea23[8] = ="+ypointsArea23[8]);	 
				 System.out.println("xpointsArea23[9] =  "+xpointsArea23[9]+"ypointsArea23[9] = ="+ypointsArea23[9]);*/
		}
			
		else if(((int)xpoints[0]>825)&&(xpoints[0]<=850)){
			for(int j=1;j<xpoints2O3.length;j++){
				System.out.println("j ============== "+j);
				if(((int)xpoints2O3[j]>=825)&&((int)xpoints2O3[j]<830)){
					xpointsArea23[0] = 825;
					ypointsArea23[0] = 235+a;
					
					xpointsArea23[1] = 825;
					ypointsArea23[1] = ypoints2O3[j]+a;
					xpointsArea23[2] = xpoints2O3[j+1];
					ypointsArea23[2] = ypoints2O3[j+1]+a;
					
					xpointsArea23[3] = xpoints2O3[j+2];
					ypointsArea23[3] = ypoints2O3[j+2]+a;
					xpointsArea23[4] = xpoints2O3[j+3];
					ypointsArea23[4] = ypoints2O3[j+3]+a;
					if(xpoints2O3[0]<830){
					
					
					xpointsArea23[5] = 800;
					ypointsArea23[5] = ypoints2O3[j+5]+a;
					xpointsArea23[6] = 800;
					ypointsArea23[6] = ypoints2O3[j+5]+a+(2*(235-ypoints2O3[j+5]));
					xpointsArea23[7] = xpoints2O3[j+7];
					ypointsArea23[7] = ypoints2O3[j+7]+a+(2*(235-ypoints2O3[j+7]));
					xpointsArea23[8] = xpoints2O3[j+11];
					ypointsArea23[8] = ypoints2O3[j+10]+a+(2*(235-ypoints2O3[j+10]));
					xpointsArea23[9] = xpoints2O3[j+11];
					ypointsArea23[9] = 235+a;
					break;
					}else if((xpoints2O3[0]>=830)&&(xpoints2O3[0]<835)){
						
						xpointsArea23[5] = 800;
						ypointsArea23[5] = ypoints2O3[j+4]+a;
						xpointsArea23[6] = 800;
						ypointsArea23[6] = ypoints2O3[j+4]+a+(2*(235-ypoints2O3[j+4]));
						xpointsArea23[7] = xpoints2O3[j+6];
						ypointsArea23[7] = ypoints2O3[j+6]+a+(2*(235-ypoints2O3[j+6]));
						xpointsArea23[8] = xpoints2O3[j+9];
						ypointsArea23[8] = ypoints2O3[j+9]+a+(2*(235-ypoints2O3[j+9]));
						xpointsArea23[9] = xpoints2O3[j+9];
						ypointsArea23[9] = 235+a;
						break;
					}else if((xpoints2O3[0]>=835)&&(xpoints2O3[0]<840)){
						
						xpointsArea23[5] = xpoints2O3[j+4];
						ypointsArea23[5] = ypoints2O3[j+4]+a;
						xpointsArea23[6] = 800;
						ypointsArea23[6] = ypoints2O3[j+5]+a;
						xpointsArea23[7] = 800;
						ypointsArea23[7] = ypoints2O3[j+5]+a+(2*(235-ypoints2O3[j+5]));
						xpointsArea23[8] = xpoints2O3[j+8];
						ypointsArea23[8] = ypoints2O3[j+8]+a+(2*(235-ypoints2O3[j+8]));
						xpointsArea23[9] = xpoints2O3[j+9];
						ypointsArea23[9] = 235+a;
						break;
					}
					else if((xpoints2O3[0]>=840)&&(xpoints2O3[0]<845)){
						xpointsArea23[5] = xpoints2O3[j+4];
						ypointsArea23[5] = ypoints2O3[j+4]+a;
						xpointsArea23[6] = 800;
						ypointsArea23[6] = ypoints2O3[j+5]+a;
						xpointsArea23[7] = 800;
						ypointsArea23[7] = ypoints2O3[j+5]+a+(2*(235-ypoints2O3[j+5]));
						xpointsArea23[8] = xpoints2O3[j+7];
						ypointsArea23[8] = ypoints2O3[j+7]+a+(2*(235-ypoints2O3[j+7]));
						xpointsArea23[9] = xpoints2O3[j+8];
						ypointsArea23[9] = 235+a;
						break;
					}
					else if((xpoints2O3[0]>=845)&&(xpoints2O3[0]<850)){
						xpointsArea23[5] = xpoints2O3[j+4];
						ypointsArea23[5] = ypoints2O3[j+4]+a;
						xpointsArea23[6] = 800;
						ypointsArea23[6] = ypoints2O3[j+5]+a;
						xpointsArea23[7] = 800;
						ypointsArea23[7] = ypoints2O3[j+5]+a+(2*(235-ypoints2O3[j+5]));
						xpointsArea23[8] = xpoints2O3[j+6];
						ypointsArea23[8] = ypoints2O3[j+6]+a+(2*(235-ypoints2O3[j+6]));
						xpointsArea23[9] = xpoints2O3[j+7];
						ypointsArea23[9] = 235+a;
						break;
					}
					else if(xpoints2O3[0]==850){
						xpointsArea23[5] = xpoints2O3[j+4];
						ypointsArea23[5] = ypoints2O3[j+4]+a;
						xpointsArea23[6] = 800;
						ypointsArea23[6] = ypoints2O3[j+5]+a;
						xpointsArea23[7] = 800;
						ypointsArea23[7] = ypoints2O3[j+5]+a+(2*(235-ypoints2O3[j+5]));
						xpointsArea23[8] = xpoints2O3[j+6];
						ypointsArea23[8] = ypoints2O3[j+6]+a+(2*(235-ypoints2O3[j+6]));
						xpointsArea23[9] = xpoints2O3[j+6];
						ypointsArea23[9] = 235+a;
						break;
					}
				}
			}
			
			/*System.out.println("xpointsArea23[0] =  "+xpointsArea23[0]+"ypointsArea23[0] = ="+ypointsArea23[0]);	 
			 System.out.println("xpointsArea23[1] =  "+xpointsArea23[1]+"ypointsArea23[1] = ="+ypointsArea23[1]);	 
			 System.out.println("xpointsArea23[2] =  "+xpointsArea23[2]+"ypointsArea23[2] = ="+ypointsArea23[2]);	 
			 System.out.println("xpointsArea23[3] =  "+xpointsArea23[3]+"ypointsArea23[3] = ="+ypointsArea23[3]);	 
			 System.out.println("xpointsArea23[4] =  "+xpointsArea23[4]+"ypointsArea23[4] = ="+ypointsArea23[4]);	 
			 System.out.println("xpointsArea23[5] =  "+xpointsArea23[5]+"ypointsArea23[5] = ="+ypointsArea23[5]);	 
			 System.out.println("xpointsArea23[6] =  "+xpointsArea23[6]+"ypointsArea23[6] = ="+ypointsArea23[6]);	 
			 System.out.println("xpointsArea23[7] =  "+xpointsArea23[7]+"ypointsArea23[7] = ="+ypointsArea23[7]);
			 System.out.println("xpointsArea23[8] =  "+xpointsArea23[8]+"ypointsArea23[8] = ="+ypointsArea23[8]);	 
			 System.out.println("xpointsArea23[9] =  "+xpointsArea23[9]+"ypointsArea23[9] = ="+ypointsArea23[9]);
			
			*/
			
			
		}
		else if(((int)xpoints[0]>850)&&((int)xpoints[0]<=875)){
			
			for(int k = 6;k<12;k++){
				System.out.println("k ============== "+k+"xpoints2O3[k] = "+xpoints2O3[k]);
				if(((int)xpoints2O3[k]>=825)&&((int)xpoints2O3[k]< 830)){
					xpointsArea23[0] = 825;
					ypointsArea23[0] = 235+a;
					
					xpointsArea23[1] = 825;
					ypointsArea23[1] = ypoints2O3[k]+a;
					
					if(xpoints2O3[6]<830){//6
						xpointsArea23[2] = xpoints2O3[k+1];
						ypointsArea23[2] = ypoints2O3[k+1]+a;
						xpointsArea23[3] = xpoints2O3[k+2];
						ypointsArea23[3] = ypoints2O3[k+2]+a;
						xpointsArea23[4] = xpoints2O3[k+3];
						ypointsArea23[4] = ypoints2O3[k+3]+a;
						
						xpointsArea23[5] = xpoints2O3[k+4];
						ypointsArea23[5] = ypoints2O3[k+4]+a;
						xpointsArea23[6] = xpoints2O3[k+5];
						ypointsArea23[6] = ypoints2O3[k+5]+a;
						xpointsArea23[7] = xpoints2O3[k+5];
						ypointsArea23[7] = ypoints2O3[k+5]+a;
						xpointsArea23[8] = xpoints2O3[k+5];
						ypointsArea23[8] = ypoints2O3[k+5]+a;
						xpointsArea23[9] = xpoints[12];
						ypointsArea23[9] = 235+a;
					break;
					}else if(((int)xpoints2O3[6]>=830)&&((int)xpoints2O3[6]<835)){//7
						xpointsArea23[2] = xpoints2O3[k+1];
						ypointsArea23[2] = ypoints2O3[k+1]+a;
						xpointsArea23[3] = xpoints2O3[k+2];
						ypointsArea23[3] = ypoints2O3[k+2]+a;
						xpointsArea23[4] = xpoints2O3[k+3];
						ypointsArea23[4] = ypoints2O3[k+3]+a;
						
						xpointsArea23[5] = xpoints2O3[k+4];
						ypointsArea23[5] = ypoints2O3[k+4]+a;
						xpointsArea23[6] = xpoints2O3[k+4];
						ypointsArea23[6] = ypoints2O3[k+4]+a;
						xpointsArea23[7] = xpoints2O3[k+4];
						ypointsArea23[7] = ypoints2O3[k+4]+a;
						xpointsArea23[8] = xpoints2O3[k+4];
						ypointsArea23[8] = ypoints2O3[k+4]+a;
						xpointsArea23[9] = xpoints[12];
						ypointsArea23[9] = 235+a;
						break;
					}else if(((int)xpoints2O3[6]>=835)&&((int)xpoints2O3[6]<840)){//8
						xpointsArea23[2] = xpoints2O3[k+1];
						ypointsArea23[2] = ypoints2O3[k+1]+a;
						xpointsArea23[3] = xpoints2O3[k+2];
						ypointsArea23[3] = ypoints2O3[k+2]+a;
						xpointsArea23[4] = xpoints2O3[k+3];
						ypointsArea23[4] = ypoints2O3[k+3]+a;
						
						xpointsArea23[5] = xpoints2O3[k+3];
						ypointsArea23[5] = ypoints2O3[k+3]+a;
						xpointsArea23[6] = xpoints2O3[k+3];
						ypointsArea23[6] = ypoints2O3[k+3]+a;
						xpointsArea23[7] = xpoints2O3[k+3];
						ypointsArea23[7] = ypoints2O3[k+3]+a;
						xpointsArea23[8] = xpoints2O3[k+3];
						ypointsArea23[8] = ypoints2O3[k+3]+a;
						xpointsArea23[9] = xpoints[12];
						ypointsArea23[9] = 235+a;
						break;
					}else if(((int)xpoints2O3[6]>=840)&&((int)xpoints2O3[6]<845)){//9
						xpointsArea23[2] = xpoints2O3[k+1];
						ypointsArea23[2] = ypoints2O3[k+1]+a;
						xpointsArea23[3] = xpoints2O3[k+2];
						ypointsArea23[3] = ypoints2O3[k+2]+a;
						xpointsArea23[4] = xpoints2O3[k+2];
						ypointsArea23[4] = ypoints2O3[k+2]+a;
						
						xpointsArea23[5] = xpoints2O3[k+2];
						ypointsArea23[5] = ypoints2O3[k+2]+a;
						xpointsArea23[6] = xpoints2O3[k+2];
						ypointsArea23[6] = ypoints2O3[k+2]+a;
						xpointsArea23[7] = xpoints2O3[k+2];
						ypointsArea23[7] = ypoints2O3[k+2]+a;
						xpointsArea23[8] = xpoints2O3[k+2];
						ypointsArea23[8] = ypoints2O3[k+2]+a;
						xpointsArea23[9] = xpoints[12];
						ypointsArea23[9] = 235+a;
						break;
					}else if(((int)xpoints2O3[6]>=845)&&((int)xpoints2O3[6]<850)){//10
						xpointsArea23[2] = xpoints2O3[k];
						ypointsArea23[2] = ypoints2O3[k]+a;
						xpointsArea23[3] = xpoints2O3[k+1];
						ypointsArea23[3] = ypoints2O3[k+1]+a;
						xpointsArea23[4] = xpoints2O3[k+1];
						ypointsArea23[4] = ypoints2O3[k+1]+a;
						
						xpointsArea23[5] = xpoints2O3[k+1];
						ypointsArea23[5] = ypoints2O3[k+1]+a;
						xpointsArea23[6] = xpoints2O3[k+1];
						ypointsArea23[6] = ypoints2O3[k+1]+a;
						xpointsArea23[7] = xpoints2O3[k+1];
						ypointsArea23[7] = ypoints2O3[k+1]+a;
						xpointsArea23[8] = xpoints2O3[k+1];
						ypointsArea23[8] = ypoints2O3[k+1]+a;
						xpointsArea23[9] = xpoints[12];
						ypointsArea23[9] = 235+a;
						break;
					}else if((int)xpoints2O3[6]==850){//11
						xpointsArea23[2] = xpoints2O3[k];
						ypointsArea23[2] = ypoints2O3[k]+a;
						xpointsArea23[3] = xpoints2O3[k];
						ypointsArea23[3] = ypoints2O3[k]+a;
						xpointsArea23[4] = xpoints2O3[k];
						ypointsArea23[4] = ypoints2O3[k]+a;
						
						xpointsArea23[5] = xpoints2O3[k];
						ypointsArea23[5] = ypoints2O3[k]+a;
						xpointsArea23[6] = xpoints2O3[k];
						xpointsArea23[7] = xpoints2O3[k];
						ypointsArea23[7] = ypoints2O3[k]+a;
						xpointsArea23[8] = xpoints2O3[k];
						ypointsArea23[8] = ypoints2O3[k]+a;
						xpointsArea23[9] = xpoints2O3[k];
						ypointsArea23[9] = ypoints2O3[k]+a;
						break;
					}
				}
			}
			/*System.out.println("xpointsArea23[0] =  "+xpointsArea23[0]+"ypointsArea23[0] = ="+ypointsArea23[0]);	 
			 System.out.println("xpointsArea23[1] =  "+xpointsArea23[1]+"ypointsArea23[1] = ="+ypointsArea23[1]);	 
			 System.out.println("xpointsArea23[2] =  "+xpointsArea23[2]+"ypointsArea23[2] = ="+ypointsArea23[2]);	 
			 System.out.println("xpointsArea23[3] =  "+xpointsArea23[3]+"ypointsArea23[3] = ="+ypointsArea23[3]);	 
			 System.out.println("xpointsArea23[4] =  "+xpointsArea23[4]+"ypointsArea23[4] = ="+ypointsArea23[4]);	 
			 System.out.println("xpointsArea23[5] =  "+xpointsArea23[5]+"ypointsArea23[5] = ="+ypointsArea23[5]);	 
			 System.out.println("xpointsArea23[6] =  "+xpointsArea23[6]+"ypointsArea23[6] = ="+ypointsArea23[6]);	 
			 System.out.println("xpointsArea23[7] =  "+xpointsArea23[7]+"ypointsArea23[7] = ="+ypointsArea23[7]);
			 System.out.println("xpointsArea23[8] =  "+xpointsArea23[8]+"ypointsArea23[8] = ="+ypointsArea23[8]);	 
			 System.out.println("xpointsArea23[9] =  "+xpointsArea23[9]+"ypointsArea23[9] = ="+ypointsArea23[9]);
			*/
		}
		else if((int)xpoints[0]> 875){
			for(int k = 0;k< 10;k++){
				xpointsArea23[k] = xpoints2O3[0];
				ypointsArea23[k] = 235+a;
			}
			
		}
	
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}

public void drawArea_interact33(Graphics g,double[] xpoints, double[] ypoints){
	int a = 115;
	
	double res = 0;
	
	int counter = 0;
	System.out.println("interact 33-----------------------------------");
	
			if(xpoints[0] <=800){
				System.out.println("xpoints[0] "+xpoints[0]+"xpoints[1] = "+xpoints[1]+"xpoints[2] = "+xpoints[2]);
				if((int)xpoints[0] == 775){
					xpointsAreaI[0] = xpoints[0];
					ypointsAreaI[0] = ypoints[0]+a;
					xpointsAreaI[1] = xpoints[1];
					ypointsAreaI[1] = ypoints[1]+a;
					xpointsAreaI[2] = xpoints[1];
					ypointsAreaI[2] = ypoints[1]+a;
					xpointsAreaI[3] = xpoints[1];
					ypointsAreaI[3] = ypoints[1]+a;
					
				
				}else if((xpoints[0]>775)&&(xpoints[0]<=800)){
					xpointsAreaI[0] = xpoints[0];
					ypointsAreaI[0] = 235+a;
					
					
						System.out.println(" in function >775 ,<800-------------------------");
						val = val+.02;
						res = Math.exp(-val)*Math.exp(-val);
						System.out.println(" res === "+res);
						
						
						
						y = 350 - (res*25);
						xpointsAreaI[1] = xpoints[1];
						ypointsAreaI[1] = y;
						xpointsAreaI[2] = 775;
						ypointsAreaI[2] = y;
						System.out.println(" xpointsAreaI[1] == "+xpointsAreaI[1]+"ypointsAreaI[1] == "+ypointsAreaI[1]);
					
					
					xpointsAreaI[3] = 775;
					ypointsAreaI[3] = 235+a;
					
					
					
				
				} 
			}// if
		else if(((int)xpoints[0]> 800)&&(xpoints[0]<= 825)){
			System.out.println(" indise >308 for loop---------------temp ="+xpoints[7]);
			
			xpointsAreaI[0] = xpoints[0];
			ypointsAreaI[0] = 235+a;
			
			
				System.out.println(" in function >775 ,<800-------------------------");
				val = val+.02;
				res = Math.exp(-val)*Math.exp(-val);
				System.out.println(" res === "+res);
				
				
				
				y = 350 - (res*25);
				xpointsAreaI[1] = xpoints[1];
				ypointsAreaI[1] = y;
				xpointsAreaI[2] = 775;
				ypointsAreaI[2] = y;
				System.out.println(" xpointsAreaI[1] == "+xpointsAreaI[1]+"ypointsAreaI[1] == "+ypointsAreaI[1]);
			
			
			xpointsAreaI[3] = 775;
			ypointsAreaI[3] = 235+a;
		}
			
		else if(((int)xpoints[0]>825)&&(xpoints[0]<=850)){
			
			xpointsAreaI[0] = 825;
			ypointsAreaI[0] = 235+a;
			
			
				System.out.println(" in function >775 ,<800-------------------------");
				val = val+.02;
				res = Math.exp(-val)*Math.exp(-val);
				System.out.println(" res === "+res);
				
				
				
				y = 350 - (res*25);
				xpointsAreaI[1] = 825;
				ypointsAreaI[1] = y;
				xpointsAreaI[2] = xpoints[11];
				ypointsAreaI[2] = y;
				System.out.println(" xpointsAreaI[1] == "+xpointsAreaI[1]+"ypointsAreaI[1] == "+ypointsAreaI[1]);
			
			
			xpointsAreaI[3] = xpoints[12];
			ypointsAreaI[3] = 235+a;
		}
		else if(((int)xpoints[0]>850)&&((int)xpoints[0]<=875)){
			xpointsAreaI[0] = 825;
			ypointsAreaI[0] = 235+a;
			
			
				System.out.println(" in function >775 ,<800-------------------------");
				val = val+.02;
				res = Math.exp(-val)*Math.exp(-val);
				System.out.println(" res === "+res);
				
				
				
				y = 350 - (res*25);
				xpointsAreaI[1] = 825;
				ypointsAreaI[1] = y;
				xpointsAreaI[2] = xpoints[11];
				ypointsAreaI[2] = y;
				System.out.println(" xpointsAreaI[1] == "+xpointsAreaI[1]+"ypointsAreaI[1] == "+ypointsAreaI[1]);
			
			
			xpointsAreaI[3] = xpoints[12];
			ypointsAreaI[3] = 235+a;
		}
		else if((int)xpoints[2]> 875){
			for(int k = 0;k< 4;k++){
				xpointsAreaI[k] = xpoints[1];
				ypointsAreaI[k] = 235+a;
			}
		}
	
		g = getGraphics(); 
		repaint();
		try {
	        animator.sleep(100);
		} catch (InterruptedException e){}
	         
	
}
public void drawSignal(Graphics2D ga,double[]xpoints,double ypoints[]){
	
	ga.setStroke(new BasicStroke(2));
	GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
			xpoints.length);
	polyline.moveTo (xpoints[0], ypoints[0]);
	for ( int index = 1; index < xpoints.length; index++ ) {
		polyline.lineTo(xpoints[index], ypoints[index]);
	};
	ga.draw(polyline);
	//ga.setStroke(new BasicStroke(1));
}

public void drawCurve(Graphics g,double t,double y,double[] xpointsC,double ypointsC[]){
	//System.out.println(" in function drawCurve-------------------------");
	double x = t;
	g = getGraphics();
	double val = 0;
	double res = 0;
	xpointsC[0] = t;
	ypointsC[0] = y;
	xpointsC[1] = t;
	ypointsC[1] = 210;
	for(int i = 2;i<12;i++){
		//System.out.println(" in function drawCurve------inseide loop-------------------");
		val = val+.2;
		res = Math.exp(-val);
		//System.out.println(" res = "+res);
		
		
		t= x + (val*25);
		y = 235 - (res*25);
		xpointsC[i] = t;
		ypointsC[i] = y;
		//System.out.println(" xpointsC["+i+"] = "+xpointsC[i]+"ypointsC["+i+"] = "+ypointsC[i]);
	}
	//Graphics2D ga = (Graphics2D)g;
	//for(int j = 0;j<xpointsC.length-1;j++){
		//ga.draw(new Line2D.Double(xpointsC[j],ypointsC[j],xpointsC[j+1],ypointsC[j+1]));
	//}
	
	
}
public void clearPannel(Graphics g){
	g.setColor(Color.white);
	//g.fillRect(12,128,586,445);
	//g.fillRect(603,128, 381,445);
	g.fillRect(12,127,978,453);
}

public void drawDottedLine(Graphics2D ga,double xcord[],double ycord[],int i){
	float [] Dashes = {10.0F, 3.0F, 3.0F, 3.0F};
	Stroke Pen2 = new BasicStroke (3.0F, BasicStroke.CAP_BUTT, 
              BasicStroke.JOIN_MITER, 
              10.0F, Dashes, 0.F);
	ga.setStroke (Pen2);
	ga.draw(new Line2D.Double(xcord[i],ycord[i],xcord[i+1],ycord[i+1]));
	ga.setStroke(new BasicStroke(1));
	//g.drawLine(30,  100,  30,  300);
}
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
			
			
			
	}
class event implements ItemListener
{
	public void itemStateChanged(ItemEvent e)
	{
		if(cb.isSelected()||cb2.isSelected()||cb3.isSelected()||cb4.isSelected())
		{
			btnPlay.setEnabled(true);
		}
	}
}	
		
}

 