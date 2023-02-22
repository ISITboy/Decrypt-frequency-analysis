fun main(args: Array<String>) {

    var a = 12
    println( a.takeIf { it<10 })
    println(a)
    val alphabet: String = "абвгдеёжзийклмнопрстуфхцчшщьыъэюя"
    val readFile = ReadTextFile()

    print("Введите текст для шифра: ")
    val encryption = readLine().toString()
    print("Введите ключ (0<key<=32): ")
    var key = readln().toInt()
    while (writeKey(key)){
        print("Неправильно введен ключ!!\n" +
                "Введите ключ (0<key<=32): ")
        key = readln().toInt()
    }

    val cipher = formattingText(key,alphabet,encryption.toLowerCase())
    println("Текст-шифр: $cipher")



    var mapForFrequency = MapAnalysis(alphabet,readFile.analysisText)
    var mapCipher = MapAnalysis(alphabet,cipher)


    var choose : Short? =null


    while (choose==null)
    {
        println("\nmapAnalysis\n" +
                "${mapForFrequency.letters}\n" +
                "mapCipher\n" +
                "${mapCipher.letters}\n" +
                "maxLetterInAnalysisText is ${mapForFrequency.maxKeyMap()}\n" +
                "maxLetterInCipherText is ${mapCipher.maxKeyMap()}\n")


        var numberForShift:Int = findLetterForAlphabet(mapForFrequency.maxKeyMap(),alphabet)!! - findLetterForAlphabet(mapCipher.maxKeyMap(),alphabet)!!
        println("Расшифровка: ${formattingText(numberForShift,alphabet,cipher.toLowerCase())}")

        print("Текст нормальный?\n" +
                "1 - Yes\n" +
                "2 - No\n" +
                "Choose: ")
        val c = readln()?.toInt()
        when(c){
            1->choose=1
            2-> {mapForFrequency.letters.values.remove(mapForFrequency.letters.values.max())
                choose=null}
        }
    }
}

fun formattingText(key:Int,alphabet: String,text:String): String{
    var result = ""
    var shift =0
    for (l in text){
        for (i in 0 until  alphabet.length){
            if (l == alphabet[i])
            {
                shift = i+key
                if(shift<0){
                    result+=alphabet[alphabet.length+shift]
                }else {
                    var index = -1
                    while (index != shift) {
                        index++
                        if (index <= alphabet.length - 1 && index == shift) {
                            result += alphabet[index]
                        } else if (index > alphabet.length - 1 && index == shift) {
                            result += alphabet[index - 33]
                        }
                    }
                }
            }
        }
    }
    return result
}
fun findLetterForAlphabet(c:Char,alphabet:String):Int?{
    for (l in 0 until alphabet.length){
        if (c==alphabet[l]) return l
    }
    return null
}

fun writeKey(key :Int):Boolean{
    return if (key in 1 ..  32) {
        return false
    } else true
}