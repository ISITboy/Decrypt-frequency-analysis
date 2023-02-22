import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

class ReadTextFile {
    var analysisText : String=""
    init {
        analysisText = readText()
    }

    private fun readText() : String{
        var text : String=""
        val fileName = "C:\\IDEA Project\\FrequencyAnalysis\\FrequencyAnalysis\\src\\main\\kotlin\\fileForAnalysis.txt"
        try {
            text = Files.readAllLines(Paths.get(fileName)).toString()
        }catch(e:IOException){
            e.printStackTrace()
        }
        return text
    }
}