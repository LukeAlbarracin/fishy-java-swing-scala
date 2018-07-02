import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JButton
import javax.swing.JLabel
import java.util.Random
import java.awt.event.ActionListener
import java.awt.event.ActionEvent
import scala.collection.mutable.ListBuffer

class SuperFrame extends JFrame {
    //var _fishList = List(Salmon("first"))
    // NAA. 
    // See https://alvinalexander.com/scala/how-add-elements-to-a-list-in-scala-listbuffer-immutable
    // But NLA, there is still a better way
    // HINT:  Fish needs to extend or implement another Scala trait in order to be treated like a "List" to be
    // able to implement "++" operator
    var _fishList = new ListBuffer[Fish]
    val frame = new JFrame("The Ocean Game")
    val label = new JLabel()
    val button1 = new JButton("Eat")
    val button2 = new JButton("Don't Eat")
    val options = Set(button1, button2)
    var _click = 0
    frame.setSize(new Dimension(500, 750))
    frame.setLayout(null)
    frame.setVisible(true)
    frame.add(button1)
    frame.add(button2)
    label.setSize(new Dimension(250, 250))
    label.setVisible(true)
    frame.add(label)
    
    button1.setLocation(0, 250)
    button2.setLocation(0, 500)
    startGame()
    
    
    def startGame() : Unit = {
      val rand = new Random()
      for (i <- 1 to 5) {
        val x = rand.nextInt(5) + 1
        if (x < 4) {
          _fishList += Salmon("salmon")
        } else if (x == 4) {
          _fishList += Stingray("stringray")
        } else {
          _fishList += Shark("shark")
        }
      }
      
      
      
      for (f <- _fishList) {
       // println( Fishes.introduce(f))
        
        //println(_fishList.apply(1))
        //println(_fishList(1))
        
      }
      doCheck()
      def doCheck() : Unit = {
        if (!_fishList.isEmpty) {
          label.setText(Fishes.introduce(_fishList(0)))
           
              button1.setOpaque(true)
              button2.setOpaque(true)
              button1.setVisible(true)
              button2.setVisible(true)
              button1.setSize(new Dimension(500,250))
              button2.setSize(new Dimension(500,250))
              button1.addActionListener(new ActionListener { 
                override def actionPerformed(e: ActionEvent): Unit = {
                   button1.removeActionListener(this)
                   button2.removeActionListener(null)
                  _fishList(0).calcRisk()
                 _fishList -= _fishList(0)
                 doCheck()
                }
              })
              button2.addActionListener(new ActionListener { 
                // x.removeActionListener(this)
                  override def actionPerformed(e: ActionEvent): Unit = {
                   button1.removeActionListener(null)
                   button2.removeActionListener(this)
                   println("But I'm Hungry!!!")
                   _fishList -= _fishList(0)
                   doCheck()
                  }
              })
      }
         
      }
      
  }
   
}