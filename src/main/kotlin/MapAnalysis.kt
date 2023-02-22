class MapAnalysis(alphabet :String, textForAnalysis : String) {
    var letters : MutableMap<Char, Int> = mutableMapOf()
    private var text= textForAnalysis
    init {
        fillMap(letters,alphabet)
        countLetters()
        sortedMap()
    }

    private fun fillMap(arrayMap:MutableMap<Char,Int>,alphabet: String){
        for(i in 0 until alphabet.length){
            arrayMap.put(alphabet[i],0)
        }

    }
    private fun countLetters(){
        for(key in letters.keys){
            letters.set(key, text.count{it == key})
        }
    }
    private fun maxValuesMap(): Int{
        var maxValue :Int =0
        for(item in letters){
            if(item.value>maxValue)
                maxValue=item.value
        }
        return maxValue
    }
    fun maxKeyMap():Char{
        var c :Char? =null
        for (item in letters){
            if (item.value == maxValuesMap()) c = item.key
        }
        return c!!
    }
    private fun sortedMap(){
        val sMap: MutableMap<Char, Int> = LinkedHashMap()
        letters.entries.sortedBy { it.value }.forEach { sMap[it.key] = it.value }
        letters = sMap
    }
}