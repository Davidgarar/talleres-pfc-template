package taller

class ConjuntosDifusos {
    type ConjDifuso = Int => Double

    def pertenece(elem :Int, s : ConjDifuso) : Double =  {
        s (elem)
    }

    def muchoMayorQue(a: Int, m: Int): ConjDifuso = {
        def mma(x: Int): Double = {
        if (x <= a) 0.0
        else if (x > a && x <= m) (x - a).toDouble / (m - a).toDouble
        else 1.0
    }
    mma
    }
    def grande(d: Int, e: Int): ConjDifuso = {
        def grand(x: Int): Double = {
            if (x == 0) 0.0 // Para evitar dividir por cero
            else math.pow(x.toDouble / (x + d).toDouble, e.toDouble)
        }
        grand
    }


    def complemento( c : ConjDifuso) : ConjDifuso = {
        def complement(x :Int) : Double = {
            1.0 - c(x)
        }
        complement
    }
    def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
        def union_(u: Int): Double = {
        math.max(cd1(u), cd2(u))
        }
        union_
    }

    def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = {
        def interseccion_(i: Int): Double = {
            math.min(cd1(i), cd2(i))
        }
        interseccion_
    }

    def inclusion( cd1 : ConjDifuso, cd2 : ConjDifuso) : Boolean = {
        def inclusion_(y:Int, max:Int) : Boolean = {
            if(y>max) true 
            else if (cd1(y) > cd2(y)) false
            else inclusion_(y+1, max) 
        }
        inclusion_(0,1000)
    }
    def igualdad(cd1 : ConjDifuso , cd2 : ConjDifuso) : Boolean = {
        inclusion(cd1, cd2) && inclusion(cd2, cd1)
    }


}
