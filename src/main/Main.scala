import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JButton
import java.util.Random
object Main {
  
  def main(args: Array[String]): Unit = {
    val frame = new SuperFrame()
    //startGame()
  }
  
}

object Orca  {
  var HP = 100
  var score = 0
  private def healthCheck() : Unit = {
    if (HP > 100) {
      HP = 100
    } else if (HP < 1) {
      HP = 0
      println("You Lost")
    }
    println("Orca Health : " + HP + " HP")
  }
  def setHealth(x : Integer) : Unit = {
    HP = HP - x
    healthCheck()
  }
  private def giveScore() : Unit = {
    println("Current Score : " + score)
  }
  def setScore(x : Integer) : Unit = {
    score = score + x
    giveScore()
  }
}

