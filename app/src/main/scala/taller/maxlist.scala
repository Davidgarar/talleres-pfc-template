package taller

import scala.annotation.tailrec 


class maxlist {
  def maxLin(l:List[Int] ): Int = {
    if(l.isEmpty) 
      throw new IllegalArgumentException("la lista esta vacia")
    else if (l.tail.isEmpty) 
      l.head
    else {
      val maxRest = maxLin(l.tail)
      if(l.head > maxRest ) l.head else maxRest
    }
  }
  
 
  def maxIt(l:List[Int]): Int = {
    if (l.isEmpty)
      throw new IllegalArgumentException("La lista no puede estar vacía")
    else {
      @tailrec
      def maxItAux(l:List[Int], max:Int): Int = {
        if(l.isEmpty) 
          max
        else {
          val newMax = if(l.head > max) l.head else max
          maxItAux(l.tail, newMax)
        }  
      }
      maxItAux(l.tail, l.head)
    }
  }
  }
