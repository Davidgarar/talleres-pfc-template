import scala.io.StdIn.readLine

object Solution {

    def main(args: Array[String]): Unit = {
        val t = readLine().toInt
        for (_ <- 0 until t) {
            val n = readLine().toInt
            val passwords = (1 to n).map(_ => readLine()).toList
            val login = readLine()
            val result = findPasswordCombination(passwords, login)
            result match {
                case Some(combination) => println(combination.mkString(" "))
                case None => println("WRONG PASSWORD")
                    }
                }
    }
   def findPasswordCombination(passwords: List[String], login: String): Option[List[String]] = {
        // Mapeo de memoización para optimizar el proceso
        val memo = scala.collection.mutable.Map[String, Option[List[String]]]()

def helper(remainingAttempt: String, combination: List[String]): Option[List[String]] = {
            if (remainingAttempt.isEmpty) {
println(s"Found combination: ${combination.reverse.mkString(" ")}")
                Some(combination.reverse)
} else if (memo.contains(remainingAttempt)) {
                println(s"Memo hit for $remainingAttempt: ${memo(remainingAttempt)}")
                memo(remainingAttempt)
            } else {
                println(s"Attempting with remaining string: $remainingAttempt")
for (password <- passwords) {
                    if (remainingAttempt.startsWith(password)) {
                        println(s"Trying password '$password' for remaining '$remainingAttempt'")
                        helper(remainingAttempt.drop(password.length), password :: combination) match {
                            case result @ Some(_) =>
                                memo(remainingAttempt) = result
                                return result
                            case None =>
println(s"No valid combination for $remainingAttempt")
                memo(remainingAttempt) = None
                None
            }
        }
helper(login, List())
    }
}