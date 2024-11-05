package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

class ConjuntosDifusosTest extends AnyFunSuite {

  val conjuntosDifusosObj = new ConjuntosDifusos()

  test("pertenece: Elemento pertenece a un conjunto difuso") {
    val conjunto = conjuntosDifusosObj.muchoMayorQue(5, 10)
    assert(conjuntosDifusosObj.pertenece(6, conjunto) === 0.2)
    assert(conjuntosDifusosObj.pertenece(5, conjunto) === 0.0)
    assert(conjuntosDifusosObj.pertenece(11, conjunto) === 1.0)
    assert(conjuntosDifusosObj.pertenece(9, conjunto) === 0.8)
    assert(conjuntosDifusosObj.pertenece(12, conjunto) === 1.0)
  }

  test("muchoMayorQue: Valores de pertenencia correctos") {
    val conjunto = conjuntosDifusosObj.muchoMayorQue(5, 10)
    assert(conjunto(5) === 0.0)
    assert(conjunto(8) === 0.6) 
    assert(conjunto(10) === 1.0)
    assert(conjunto(11) === 1.0)
    assert(conjunto(7) === 0.4) // (7 - 5) / (10 - 5)
    assert(conjunto(6) === 0.2)
  }

  test("grande: Valores de pertenencia correctos") {
    val conjunto = conjuntosDifusosObj.grande(10, 2)
    // Verifica que el valor sea el esperado según la lógica
    assert(conjunto(0) === 0.0) // Para x = 0
    assert(conjunto(10) === 0.25) // Para x = 10
    assert(conjunto(12) === math.pow(12.0 / (12.0 + 10.0), 2)) // Asegúrate de calcularlo
    assert(conjunto(11) === math.pow(11.0 / (11.0 + 10.0), 2)) // Verifica esto
    assert(conjunto(15) === math.pow(15.0 / (15.0 + 10.0), 2)) // Verifica esto
  }




  test("complemento: Complemento correcto de un conjunto difuso") {
    val conjunto = conjuntosDifusosObj.muchoMayorQue(5, 10)
    val complemento = conjuntosDifusosObj.complemento(conjunto)
    assert(complemento(5) === 1.0)
    assert(complemento(6) === 0.8)
    assert(complemento(10) === 0.0)
    assert(complemento(8) === 0.4)
    assert(complemento(11) === 0.0)
  }

  test("union: Unión de dos conjuntos difusos") {
    val conjunto1 = conjuntosDifusosObj.muchoMayorQue(5, 10)
    val conjunto2 = conjuntosDifusosObj.grande(10, 2)
    val union = conjuntosDifusosObj.union(conjunto1, conjunto2)

    assert(union(5) === 0.1111111111111111) // Máx de 0.0 (conjunto1) y 0.1111 (conjunto2)
    assert(union(6) === 0.2) // Máx de 0.2 (conjunto1) y 0.140625 (conjunto2)
    assert(union(8) === 0.6) // Máx de 0.6 (conjunto1) y 0.19753086419753085 (conjunto2)
    assert(union(10) === 1.0) // Máx de 1.0 (de ambos conjuntos)
    assert(union(12) === 1.0) // Máx de 1.0 (de ambos conjuntos)
    assert(union(15) === 1.0) // Máx de 1.0 (de conjunto1) y 0.36 (conjunto2)
  }


  test("interseccion: Intersección de dos conjuntos difusos") {
    val conjunto1 = conjuntosDifusosObj.muchoMayorQue(5, 10)
    val conjunto2 = conjuntosDifusosObj.grande(10, 2)
    val interseccion = conjuntosDifusosObj.interseccion(conjunto1, conjunto2)

    assert(interseccion(5) === 0.0) // Ambos conjuntos tienen 0.0
    assert(interseccion(6) === 0.140625) // Mínimo de 0.2 (conjunto1) y 0.140625 (conjunto2)
    assert(interseccion(8) === 0.19753086419753085) // Mínimo de 0.6 (conjunto1) y 0.19753...
    assert(interseccion(10) === 0.25) // Mínimo de 1.0 (conjunto1) y 0.25 (conjunto2)
    assert(interseccion(12) === 0.29752066115702475) // Mínimo de 1.0 (conjunto1) y 0.29752...
  }

  
  test("inclusion: Inclusión de un conjunto difuso en otro") {
    val conjunto1 = conjuntosDifusosObj.muchoMayorQue(5, 10)
    val conjunto2 = conjuntosDifusosObj.grande(10, 2)
    assert(conjuntosDifusosObj.inclusion(conjunto1, conjunto2) === false)
    assert(conjuntosDifusosObj.inclusion(conjunto2, conjunto2) === true)
    assert(conjuntosDifusosObj.inclusion(conjunto1, conjunto1) === true)
    assert(conjuntosDifusosObj.inclusion(conjunto2, conjunto1) === false)
  }

  test("igualdad: Comprobación de igualdad de conjuntos difusos") {
    val conjunto1 = conjuntosDifusosObj.muchoMayorQue(5, 10)
    val conjunto2 = conjuntosDifusosObj.muchoMayorQue(5, 10)
    val conjunto3 = conjuntosDifusosObj.grande(10, 2)
    assert(conjuntosDifusosObj.igualdad(conjunto1, conjunto2) === true)
    assert(conjuntosDifusosObj.igualdad(conjunto1, conjunto3) === false)
    val conjunto4 = conjuntosDifusosObj.grande(10, 2)
    assert(conjuntosDifusosObj.igualdad(conjunto3, conjunto4) === true)
    assert(conjuntosDifusosObj.igualdad(conjunto2, conjunto4) === false)
  }
  
}



