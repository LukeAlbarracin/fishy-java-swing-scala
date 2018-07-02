object hack {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val x = List(1, 2, 3)                           //> x  : List[Int] = List(1, 2, 3)
  var y = List(1, 2, 7)                           //> y  : List[Int] = List(1, 2, 7)
  val z = List (3, 5)                             //> z  : List[Int] = List(3, 5)
  val yy = y ++ z                                 //> yy  : List[Int] = List(1, 2, 7, 3, 5)
  
  val sx = List("a", "b", "c")                    //> sx  : List[String] = List(a, b, c)
  var sy = List("d", "e")                         //> sy  : List[String] = List(d, e)
  
  val syy = sx ++ sy                              //> syy  : List[String] = List(a, b, c, d, e)
  
  val xhead = x.head                              //> xhead  : Int = 1
  val xtail = x.tail                              //> xtail  : List[Int] = List(2, 3)
  
  val alist = List(1, 2, 3)                       //> alist  : List[Int] = List(1, 2, 3)
  val alistadd1 = alist ++ List(4)                //> alistadd1  : List[Int] = List(1, 2, 3, 4)
  
  val bList = List(1, 2, 3)                       //> bList  : List[Int] = List(1, 2, 3)
  
  // compute sum as linear sequence
  var sum = 0                                     //> sum  : Int = 0
  for (b <- bList) {
  	  sum = sum + b
  }
  assert(sum == 6)
  
  // fold does the same !!!
  
  val bListFold = bList.fold(0)( (sum, b) =>  sum + b )
                                                  //> bListFold  : Int = 6
  assert(bListFold == 5)                          //> java.lang.AssertionError: assertion failed
                                                  //| 	at scala.Predef$.assert(Predef.scala:204)
                                                  //| 	at hack$.$anonfun$main$1(hack.scala:32)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at hack$.main(hack.scala:1)
                                                  //| 	at hack.main(hack.scala)

	// try left fold
	// try right fold
	
	// try fold with explicit function
}

//def sum(a,b) = { a + b }