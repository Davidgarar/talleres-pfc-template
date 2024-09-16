package taller


import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class HanoiTest extends AnyFlatSpec with Matchers {

  val hanoi = new Hanoi

  "movsTorresHanoi" should "calcular correctamente el número de movimientos para distintos números de discos" in {
    // Caso 1: Para un disco
    hanoi.movsTorresHanoi(1) should be (1)
    
    // Caso 2: Para dos discos
    hanoi.movsTorresHanoi(2) should be (3)
    
    // Caso 3: Para tres discos
    hanoi.movsTorresHanoi(3) should be (7)
    
    // Caso 4: Para cuatro discos
    hanoi.movsTorresHanoi(4) should be (15)
    
    // Caso 5: Para cinco discos
    hanoi.movsTorresHanoi(5) should be (31)
    
    // Caso 6: Comprobación para un número grande de discos
    hanoi.movsTorresHanoi(64) should be (BigInt("18446744073709551615").toInt)  // 2^10 - 1 = 1023
  }

  "torresHanoi" should "devolver correctamente la lista de movimientos para distintos números de discos" in {
    // Caso 1: Un disco
    hanoi.torresHanoi(1, 1, 2, 3) should be (List((1, 3)))
    
    // Caso 2: Dos discos
    hanoi.torresHanoi(2, 1, 2, 3) should be (List((1, 2), (1, 3), (2, 3)))
    
    // Caso 3: Tres discos
    hanoi.torresHanoi(3, 1, 2, 3) should be (List(
      (1, 3), (1, 2), (3, 2), 
      (1, 3), (2, 1), (2, 3), 
      (1, 3)
    ))
    
    // Caso 4: Cuatro discos
    hanoi.torresHanoi(4, 1, 2, 3).length should be (15) // Solo verificamos el número de movimientos
    
    // Caso 5: Comprobación para más discos (5 discos)
    hanoi.torresHanoi(5, 1, 2, 3).length should be (31) // Verificamos el número de movimientos

    // Caso 5: Comprobación para más discos (5 discos)
    hanoi.torresHanoi(64, 1, 2, 3).length should be (BigInt("18446744073709551615").toInt) // Verificamos el número de movimientos
    }
    "El cálculo de tiempo" should "ser correcto para 64 discos" in {
    val totalMovimientos = hanoi.movsTorresHanoi(64)
    val seg_años = 60*60*24*365.25

    val años = BigDecimal(tMovs) / BigDecimal(seg_años)
    val siglos = años/100

    println(s"la cantidad de siglos que se demorarion los monjes en mover las 64 discos es de: $siglos")
    totalMovimientos should be (BigInt("18446744073709551615").toInt)
    siglos should be (BigDecimal("5845420460.917"))
  }

}
