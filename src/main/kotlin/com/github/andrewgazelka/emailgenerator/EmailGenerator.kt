package com.github.andrewgazelka.emailgenerator


fun <A, B, C> Sequence<A>.cartesian(other: Sequence<B>, combine: (A, B) -> C): Sequence<C> =
  flatMap { a ->
    other.map { b ->
      combine(a, b)
    }
  }

fun emailSequence(input: CharSequence): Sequence<String> {
  val length = input.length
  if (length == 0) return sequenceOf("")
  val firstChar = input.first()
  if (length == 1) return sequenceOf("$firstChar")
  return sequence {
    for (i in 1..length) {
      val firstChars = input.subSequence(0 until i)
      val nextChars = input.subSequence(i until length)
      emailSequence(nextChars).forEach { str ->
        val res = if (str.isBlank()) firstChars else "$firstChars.$str"
        yield(res.toString())
      }
    }
  }
}

fun main() {
  val endSequence = sequenceOf("gmail.com", "googlemail.com")
  emailSequence("andrewgazelka")
    .cartesian(endSequence) { a, b -> "$a@$b" }
    .toList()
    .forEach {
      println(it)
    }
}
