fun main() {
    println(
        repeatedIntersection(intArrayOf(3, 6, 7, 8, 7, 9), mutableListOf(12, 6, 7, 6, 7, 565))
    )
    println(countLetters("AAGGDDDFBBBAAABB"))
    println(groupWords(arrayOf("ate", "tdb", "eat", "ref", "fer", "test")))
}

fun repeatedIntersection(array1: IntArray, array2: MutableList<Int>): List<Int> {
    return array1
        .filter { e ->
            array2.remove(e)
        }
}

fun countLetters(input: String): String {
    var i = 0
    var count = 0
    var result = ""
    for (letter in input) {
        count++
        i++
        if (i < input.length && letter == input[i]) {
            continue
        }
        result += "${input[i - 1]}$count"
        count = 0
    }
    return result
}

fun groupWords(words: Array<String>): List<List<String>> {
    val map: MutableMap<String, MutableList<String>> = HashMap()
    for (word in words) {
        val sum: String = word.toCharArray().sorted().joinToString()
        map.getOrPut(sum) { mutableListOf() }
            .add(word)
    }
    return map.values.toList()
}
