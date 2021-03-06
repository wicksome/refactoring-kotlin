data class Office(
    val city: String,
    val phone: String
)

fun main() {
    val input = """
        office, country, telephone
        Chicago, USA, +1 312 373 1000
        Beijing, China, +86 4008 900 505
        Bangalore, India, +91 80 4064 9570
    """.trimIndent()
    
    val result = acquireData(input)
    
    println(result)
}

fun acquireData(input: String): List<Office> {
    val lines = input.split("\n")
    var firstLine = true
    val result = mutableListOf<Office>()
    val loopItems = lines
        .drop(1)
        .filter { it.isBlank() }
    for (line in loopItems) {
        val record = line.split(",")
        if (record[1].trim() == "India") {
            result += Office(city = record[0].trim(), phone = record[2].trim())
        }
    }
    return result.toList()
}