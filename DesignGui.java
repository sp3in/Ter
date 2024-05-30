//Program using MouseListener Interface
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class DesignGui implements MouseListener{
    Frame fr;
    Label l1;
    DesignGui(){
        fr=new Frame();
        fr.addMouseListener(this);
        fr.setLayout(null);
        l1=new Label();
        fr.setVisible(true);
        fr.setSize(300,300);
        l1.setBounds(20, 20, 100, 100);
        fr.add(l1);
        l1.setVisible(true);
      
    } 
    public void mousePressed(MouseEvent m){
        l1.setText("Mouse Pressed");
    } 
    public void mouseClicked(MouseEvent m){
        l1.setText("Mouse Clicked");
    }
     public void mouseEntered(MouseEvent m){
        l1.setText("Mouse Entered");
    } 
    public void mouseExited(MouseEvent m){
        l1.setText("Mouse Exited");
    } 
    public void mouseReleased(MouseEvent m){
        l1.setText("Mouse Released");
    }
}

public class TestingAwt {
public static void main(String[] args) {
 new DesignGui();
       
    }
}