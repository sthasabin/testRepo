import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Date;

public class DateConverter extends JFrame{
  //Calander calander=Calander.getInstance();
  Date date=new Date();
  JButton ADtoBS, BStoAD, Clear;
  JTextField year, month, day;
  int Y=0,M=0,D=0;
  String CY,CM,CD;
  JTextField txt;
  JPanel p1, p2, p3, p4;
  
  DateConverter(){
    JFrame frame=new JFrame();
    frame.setLayout(new GridLayout(3,1));
    frame.setTitle("Date Conveter");
    p1=new JPanel();
    p1.add(new JLabel("Welcome! To Date Converter"));
  
    p2=new JPanel();
    p2.setLayout(new GridLayout(3, 3));
    p2.add(new JLabel("Year"));
    p2.add(new JLabel("Month"));
    p2.add(new JLabel("Day"));
    p2.add(year=new JTextField(10));
    p2.add(month=new JTextField(10));
    p2.add(day=new JTextField(10));
    
    p2.add(BStoAD=new JButton("BS to AD"));
    BStoAD.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        BStoAD();
      }
    });
    
    p2.add(Clear=new JButton("Clear"));
    Clear.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        clear();
      }
    });
    
    p2.add(ADtoBS=new JButton("AD to BS"));    
    ADtoBS.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        ADtoBS();
      }
    });
        
    p3=new JPanel();
    p3.add(txt=new JTextField(30));
    
    frame.add(p1,BorderLayout.NORTH);
    frame.add(p2,BorderLayout.CENTER);
    frame.add(p3,BorderLayout.SOUTH);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.pack();
  }
  
 /*....................Funtion for BS to AD...............*/
  
  public void BStoAD(){
    getdate();
    if(0<D && D<=30 && 0<M && M<=12 && 2000<=Y && Y<=2080){
      if(D<=18){
        D=(D+30)-17;
        M--;
      }
      else{
         D=D-17;
      }
      if(M<=8){
        M=(M+12)-8;
        Y--;
      }
      else{
        M=M-8;
      }
        Y=Y-56;
    }
    Display();
  }
  
   /*....................Funtion for AD to BS...............*/  
  public void ADtoBS(){
    getdate();
    if(0<D && D<=30 && 0<M && M<=12 && 1944<=Y && Y<=2024){
      D=D+17;
      M=M+8;
      Y=Y+56;
      if(D>30){
        D=D-30;
        M++;
      }
      if(M>12){
        M=M-12;
        Y++;
      }
    }
    Display();
  }
  
  public void Display(){
    CY=Integer.toString(Y);
    CM=Integer.toString(M);
    CD=Integer.toString(D);
    txt.setText("Converted Date: "+'\n'+Integer.toString(Y)+" ,"+Integer.toString(M)+" , "+Integer.toString(D));
  }
  
  public void getdate(){
    Y=Integer.parseInt(year.getText());
    M=Integer.parseInt(month.getText());
    D=Integer.parseInt(day.getText());
    if(M<=0 || M>12 || D<=0 ||D>31 || Y<=0){
      JOptionPane.showMessageDialog(null, "Invalid Date!");
      clear();
    }
  }

  public void clear(){
    year.setText("");
    month.setText("");
    day.setText("");
    txt.setText("");
  }
  
  
  public static void main(String[] args){
    DateConverter D=new DateConverter();
  }
}