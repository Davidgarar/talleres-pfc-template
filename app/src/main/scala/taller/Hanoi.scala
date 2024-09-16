package taller

class Hanoi {
    def movsTorresHanoi(n : Int) : BigInt = {
        if(n <= 0) 
            throw new IllegalArgumentException("el numero de discos debe de ser mayor a cero")
        else if (n == 1) 
            1
        else 2 * movsTorresHanoi(n-1) + 1   
    

    }
    def torresHanoi( n : Int , t1 : Int , t2 : Int , t3 : Int) : List[(Int , Int)] = {
        if(n <= 0) 
            Nil
        else if(n == 1) 
            List((t1,t3))
        else {
            val mov1 = torresHanoi(n-1, t1, t3, t2)
            val movn = List((t1,t3))
            val mov2 = torresHanoi(n-1,t2, t1, t3)
            mov1 ++ movn ++ mov2 
        }
    }
    /*val totalMovs = movsTorresHanoi(n)
    println (s"numero total de movimientos:  $totalMovs") 

    val tMovs = movsTorresHanoi(64)
    println(s"numero total para 64 discos:  $tMovs") 
    */
    

    

  
}
