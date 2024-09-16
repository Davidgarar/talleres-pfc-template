package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

//@RunWith(classOf[JUnitRunner])


class maxlistTest extends AnyFunSuite {

  // Instancia del objeto maxlist donde están las funciones
  val maxListObj = new maxlist()

  // Casos de prueba para maxLin
  test("maxLin: Lista con un solo elemento") {
    assert(maxListObj.maxLin(List(5)) === 5)
  }

  test("maxLin: Lista con varios elementos distintos") {
    assert(maxListObj.maxLin(List(1, 5, 3, 7, 2)) === 7)
  }

  test("maxLin: Lista con elementos repetidos") {
    assert(maxListObj.maxLin(List(4, 4, 4, 4)) === 4)
  }

  test("maxLin: Lista con números negativos (aunque no debería ocurrir según el enunciado)") {
    assert(maxListObj.maxLin(List(-1, -5, -3)) === -1)
  }

  test("maxLin: Lista con el valor máximo en la primera posición") {
    assert(maxListObj.maxLin(List(9, 3, 2, 1)) === 9)
  }

  // Casos de prueba para maxIt
  test("maxIt: Lista con un solo elemento") {
    assert(maxListObj.maxIt(List(5)) === 5)
  }

  test("maxIt: Lista con varios elementos distintos") {
    assert(maxListObj.maxIt(List(1, 5, 3, 7, 2)) === 7)
  }

  test("maxIt: Lista con elementos repetidos") {
    assert(maxListObj.maxIt(List(4, 4, 4, 4)) === 4)
  }

  test("maxIt: Lista con números negativos (aunque no debería ocurrir según el enunciado)") {
    assert(maxListObj.maxIt(List(-1, -5, -3)) === -1)
  }

  test("maxIt: Lista con el valor máximo en la primera posición") {
    assert(maxListObj.maxIt(List(9, 3, 2, 1)) === 9)
  }
}

