import java.util.Random
trait Fish {
  def ToString(name: String) = {
    name
  }
  def calcRisk() {
    val rand = new Random()
    if ((rand.nextInt(5)+1) > Fishes.getRisk(this)) {
      Fishes.giveStatement(this)
      Orca.setHealth(-10)
      Orca.setScore(Fishes.getScore(this))
    } else {
      println("Ouch! No lunchtime!")
      Orca.setHealth(Fishes.getRisk(this) * 10)
      Orca.setScore(0)
    }
  def calcRisk(x : Boolean) {
    
  }
  }
}
case class Salmon(name: String) extends Fish 
case class Stingray(name: String) extends Fish
case class Shark(name: String) extends Fish

object Fishes {
  def getScore(x : Fish) = x match {
    case Salmon(name) => 10
    case Stingray(name) => 25
    case Shark(name) => 100
  }
  def getRisk(x : Fish) = x match {
    case Salmon(name) => 0
    case Stingray(name) => 3
    case Shark(name) => 2
  }
  def giveStatement(x : Fish) = x match {
    case Salmon(name) => println ("You ate the Salmon...")
    case Stingray(name) => println ("You ate the ray... Electrifying taste")
    case Shark(name) => println ("You ate the Shark...")
  }
  def introduce(x : Fish) = x match {
    case Salmon(name) => "Do you want to eat Salmon?"
    case Stingray(name) => "Do you want to eat Stingray?"
    case Shark(name) => "Do you want to eat some Shark?"
  }
  def getName(x : Fish) = x match {
    case Salmon(name) => "Salmon"
    case Stingray(name) => "Stingray"
    case Shark(name) => "Shark"
  }
}